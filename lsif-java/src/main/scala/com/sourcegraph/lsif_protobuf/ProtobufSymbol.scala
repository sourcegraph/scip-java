package com.sourcegraph.lsif_protobuf

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

import com.google.protobuf.DescriptorProtos.DescriptorProto
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto
import com.google.protobuf.DescriptorProtos.EnumValueDescriptorProto
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto
import com.google.protobuf.DescriptorProtos.FileDescriptorProto
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols.Descriptor

sealed abstract class ProtobufSymbol extends Product with Serializable {
  def owner: Option[ProtobufSymbol]
  def owners: List[ProtobufSymbol] = {
    val result = ListBuffer.empty[ProtobufSymbol]
    @tailrec
    def loop(p: ProtobufSymbol): Unit = {
      result += p
      p.owner match {
        case Some(parent) =>
          loop(parent)
        case _ =>
      }
    }
    loop(this)
    result.toList
  }
  def ownerDescriptors: String =
    owners
      .collect {
        case MessageSymbol(message, _) =>
          new Descriptor(Descriptor.Kind.Type, message.getName()).encode()
        case EnumSymbol(value, _) =>
          new Descriptor(Descriptor.Kind.Term, value.getName()).encode()
      }
      .mkString
}
case class PackageSymbol(file: FileDescriptorProto) extends ProtobufSymbol {
  def owner: Option[ProtobufSymbol] = None
}
case class FieldSymbol(
    field: FieldDescriptorProto,
    owner: Option[ProtobufSymbol]
) extends ProtobufSymbol
case class MessageSymbol(
    message: DescriptorProto,
    owner: Option[ProtobufSymbol]
) extends ProtobufSymbol
case class EnumSymbol(value: EnumDescriptorProto, owner: Option[ProtobufSymbol])
    extends ProtobufSymbol
case class EnumValueSymbol(
    value: EnumValueDescriptorProto,
    owner: Option[ProtobufSymbol]
) extends ProtobufSymbol
