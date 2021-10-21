package com.sourcegraph.lsif_protobuf

import scala.collection.mutable

import com.google.protobuf.DescriptorProtos.DescriptorProto
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto
import com.google.protobuf.DescriptorProtos.FileDescriptorProto

class ProtobufSymtab(file: FileDescriptorProto) {
  private val symbols = mutable.Map.empty[String, DescriptorProto]
  file
    .getMessageTypeList()
    .forEach(m =>
      walkDescriptorTree(
        m,
        if (file.getPackage().isEmpty())
          ""
        else
          s".${file.getPackage()}"
      )
    )
  private def walkDescriptorTree(
      descriptor: DescriptorProto,
      owner: String
  ): Unit = {
    val symbol = s"$owner.${descriptor.getName()}"
    symbols(symbol) = descriptor
    descriptor.getNestedTypeList().forEach(m => walkDescriptorTree(m, symbol))
  }

  def isMapType(field: FieldDescriptorProto): Boolean = {
    symbols.get(field.getTypeName()).exists(_.getOptions().getMapEntry())
  }
}
