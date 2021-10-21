package com.sourcegraph.lsif_protobuf

import java.nio.file.Paths

import scala.collection.mutable.ListBuffer

import com.google.protobuf.DescriptorProtos.DescriptorProto
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto
import com.google.protobuf.DescriptorProtos.EnumValueDescriptorProto
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto
import com.google.protobuf.DescriptorProtos.FileDescriptorProto

class ProtobufSymbolBuilder(
    command: List[String],
    symtab: ProtobufSymtab,
    file: FileDescriptorProto
) {
  private var part: ProtobufSymbol = PackageSymbol(file)
  private val isProto2 = file.getSyntax() == "proto2"
  private val languages = new ProtobufLanguages(command)
  private val javaPackageName = Option(file.getOptions().getJavaPackage())
    .filter(_.nonEmpty)
    .getOrElse(file.getPackage())
    .replace('.', '/')
  private val nonEmptyJavaOuterClassname =
    file.getOptions().getJavaOuterClassname() match {
      case "" =>
        val filename = Cases
          .snakeCaseToCamelCase(Paths.get(file.getName()).getFileName.toString)
        filename.stripSuffix(".proto").capitalize + "OuterClass#"
      case outerClassName =>
        outerClassName + "#"
    }
  private val javaOuterClassname =
    if (file.getOptions().getJavaMultipleFiles())
      ""
    else
      nonEmptyJavaOuterClassname
  object Package {
    def unapply(path: List[Int]): Option[(FileDescriptorProto, List[Int])] =
      part match {
        case p: PackageSymbol =>
          Some(p.file -> path)
        case _ =>
          None
      }
  }
  object Message {
    def unapply(path: List[Int]): Option[(DescriptorProto, List[Int])] =
      part match {
        case m: MessageSymbol =>
          Some(m.message -> path)
        case _ =>
          None
      }
  }
  object Enum {
    def unapply(path: List[Int]): Option[(EnumDescriptorProto, List[Int])] =
      part match {
        case p: EnumSymbol =>
          Some(p.value -> path)
        case _ =>
          None
      }
  }
  object Field {
    def unapply(path: List[Int]): Option[(FieldDescriptorProto, List[Int])] =
      part match {
        case f: FieldSymbol =>
          Some(f.field -> path)
        case _ =>
          None
      }
  }

  def addEnum(value: EnumDescriptorProto): ProtobufSymbolBuilder = {
    part = EnumSymbol(value, Some(part))
    this
  }

  def addEnumValue(value: EnumValueDescriptorProto): ProtobufSymbolBuilder = {
    part = EnumValueSymbol(value, Some(part))
    this
  }

  def addMessage(message: DescriptorProto): ProtobufSymbolBuilder = {
    part = MessageSymbol(message, Some(part))
    this
  }

  def addField(value: FieldDescriptorProto): ProtobufSymbolBuilder = {
    part = FieldSymbol(value, Some(part))
    this
  }

  def buildOuterClassSymbol(): List[String] = {
    if (languages.isJavaEnabled) {
      List(s"$javaPackageName/$nonEmptyJavaOuterClassname")
    } else {
      Nil
    }
  }

  def build(): List[String] = {
    val result = ListBuffer.empty[String]
    if (languages.isJavaEnabled) {
      result ++= buildJavaSymbols(part, isTerminal = true)
    }
    result.toList
  }

  private def buildJavaSymbols(
      p: ProtobufSymbol,
      isTerminal: Boolean
  ): List[String] = {
    p match {
      case PackageSymbol(_) =>
        List(javaPackageName)
      case MessageSymbol(message, Some(parent)) =>
        val owner =
          s"$javaPackageName/$javaOuterClassname${parent.ownerDescriptors}"
        if (isTerminal) {
          List(
            s"$owner${message.getName()}#",
            s"$owner${message.getName()}OrBuilder#",
            s"$owner${message.getName()}#Builder#"
          )
        } else {
          List(s"$owner${message.getName()}#")
        }
      case EnumSymbol(proto, Some(parent)) =>
        buildJavaSymbols(parent, isTerminal = false)
          .take(1)
          .flatMap { owner =>
            List(s"${owner}${proto.getName}#")
          }
      case EnumValueSymbol(proto, Some(parent)) =>
        buildJavaSymbols(parent, isTerminal = false)
          .take(1)
          .flatMap { owner =>
            List(
              s"${owner}${proto.getName}.",
              s"${owner}${proto.getName}_VALUE."
            )
          }
      case FieldSymbol(field, Some(parent)) =>
        val name = field.getJsonName().capitalize
        buildJavaSymbols(parent, isTerminal = true).flatMap { owner =>
          val isRepeated =
            field.getLabel() == FieldDescriptorProto.Label.LABEL_REPEATED
          val isMessageType =
            field.getType() == FieldDescriptorProto.Type.TYPE_MESSAGE
          val isEnumType =
            field.getType() == FieldDescriptorProto.Type.TYPE_ENUM
          val isStringType =
            field.getType() == FieldDescriptorProto.Type.TYPE_STRING
          val isMapType = symtab.isMapType(field)
          val isExplicitlyWrittenMessageType = isMessageType && !isMapType
          val isListType = isRepeated && !isMapType

          // NOTE: the logic below is not a 100% translation of the upstream
          // logic here
          // https://github.com/protocolbuffers/protobuf/blob/b3b3162219201a691c257d75f85f39c1a82e6899/src/google/protobuf/compiler/java/java_helpers.h#L375
          // However, the upstream logic doesn't pass our tests while the
          // condition below does
          val hasHasBit = !isRepeated && isMessageType
          val isBuilder = owner.endsWith("#Builder#")
          val isOrBuilder =
            owner.endsWith("OrBuilder#") && !owner.endsWith("#OrBuilder#")
          val isRegularClass = !isBuilder && !isOrBuilder

          val result = ListBuffer.empty[String]
          result += s"${owner}get${name}()."

          if (isRepeated) {
            result += s"${owner}get${name}Count()."
          }
          if (isListType) {
            result += s"${owner}get${name}List()."
            if (isEnumType) {
              result += s"${owner}get${name}ValueList()."
            } else if (isMessageType) {
              result += s"${owner}get${name}OrBuilderList()."
            }
          }
          if (isMapType) {
            result += s"${owner}get${name}Map()."
            if (isBuilder) {
              result += s"${owner}put${name}()."
              result += s"${owner}putAll${name}()."
              result += s"${owner}getMutable${name}()."
              result += s"${owner}internalGetMutable${name}()."
            }
            result += s"${owner}contains${name}()."
            result += s"${owner}get${name}OrDefault()."
            result += s"${owner}get${name}OrThrow()."
            if (!isOrBuilder) {
              result += s"${owner}internalGet${name}()."
            }
          }

          if (isBuilder) {
            if (!isMapType) {
              result += s"${owner}set${name}()."
            }
            result += s"${owner}clear${name}()."
            if (isExplicitlyWrittenMessageType) {
              result += s"${owner}get${name}Builder()."
              result += s"${owner}set${name}(+1)."
              if (!isRepeated) {
                result += s"${owner}merge${name}()."
              }
            } else if (isEnumType) {
              result += s"${owner}set${name}Value()."
            } else if (isStringType) {
              result += s"${owner}set${name}Bytes()."
            }
            if (isListType) {
              result += s"${owner}add${name}()."
              result += s"${owner}addAll${name}()."
              if (isEnumType) {
                result += s"${owner}get${name}ValueList()."
                result += s"${owner}add${name}Value()."
                result += s"${owner}addAll${name}Value()."
              } else if (isMessageType) {
                result += s"${owner}add${name}(+1)."
                result += s"${owner}add${name}(+2)."
                result += s"${owner}add${name}(+3)."
                result += s"${owner}add${name}Builder()."
                result += s"${owner}add${name}Builder(+1)."
                result += s"${owner}get${name}BuilderList()."
                result += s"${owner}get${name}OrBuilderList()."
              }
            }
            if (isRepeated && isMessageType) {
              result += s"${owner}remove${name}()."
            }

          } else if (isRegularClass) {
            // Regular message
            result += s"${owner}${field.getName().toUpperCase()}_FIELD_NUMBER."
          }

          if (hasHasBit) {
            result += s"${owner}has${name}()."
          }

          if (isExplicitlyWrittenMessageType) {
            result += s"${owner}get${name}OrBuilder()."
          } else if (isEnumType) {
            result += s"${owner}get${name}Value()."
          } else if (isStringType) {
            result += s"${owner}get${name}Bytes()."
          }
          result.toList
        }
      case _ =>
        Nil
    }
  }
}
