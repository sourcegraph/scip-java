package com.sourcegraph.semanticdb_kotlinc

import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.DescriptorVisibilities
import org.jetbrains.kotlin.descriptors.impl.LocalVariableDescriptor

fun DeclarationDescriptor.isObjectDeclaration(): Boolean =
    this is ClassDescriptor && this.visibility == DescriptorVisibilities.LOCAL

fun DeclarationDescriptor.isLocalVariable(): Boolean = this is LocalVariableDescriptor
