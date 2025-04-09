package com.sourcegraph.semanticdb_kotlinc

import org.jetbrains.kotlin.descriptors.ConstructorDescriptor
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.ValueParameterDescriptor
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.types.KotlinType

class DescriptorResolver(/* leave public for debugging */ val bindingTrace: BindingTrace) {
    fun fromDeclaration(declaration: KtDeclaration): Sequence<DeclarationDescriptor> = sequence {
        val descriptor = bindingTrace[BindingContext.DECLARATION_TO_DESCRIPTOR, declaration]
        if (descriptor is ValueParameterDescriptor) {
            bindingTrace[BindingContext.VALUE_PARAMETER_AS_PROPERTY, descriptor]?.let { yield(it) }
        }
        descriptor?.let { yield(it) }
    }

    fun syntheticConstructor(klass: KtClass): ConstructorDescriptor? =
        bindingTrace[BindingContext.CONSTRUCTOR, klass]

    fun fromReference(reference: KtReferenceExpression): DeclarationDescriptor? =
        bindingTrace[BindingContext.REFERENCE_TARGET, reference]

    fun fromTypeReference(reference: KtTypeReference): KotlinType =
        bindingTrace[BindingContext.TYPE, reference]
            ?: bindingTrace[BindingContext.ABBREVIATED_TYPE, reference]!!
}
