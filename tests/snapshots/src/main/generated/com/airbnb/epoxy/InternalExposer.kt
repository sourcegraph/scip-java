package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

/**
 * Exposes package private things as internal so files in other packages can use them.
 */

internal fun EpoxyViewHolder.objectToBindInternal() = objectToBind()
//                           ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#objectToBindInternal().  internal fun [ERROR : EpoxyViewHolder].objectToBindInternal(): [ERROR : <ERROR FUNCTION RETURN TYPE>]

internal fun EpoxyModel<*>.viewTypeInternal() = viewType
//                         ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#viewTypeInternal().  internal fun [ERROR : EpoxyModel<*>]<out [ERROR : *]>.viewTypeInternal(): [ERROR : <ERROR PROPERTY TYPE>]
internal fun BaseEpoxyAdapter.boundViewHoldersInternal() = boundViewHolders
//                            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#boundViewHoldersInternal().  internal fun [ERROR : BaseEpoxyAdapter].boundViewHoldersInternal(): [ERROR : <ERROR PROPERTY TYPE>]
internal fun BaseEpoxyAdapter.getModelForPositionInternal(position: Int): EpoxyModel<*>? {
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().  internal fun [ERROR : BaseEpoxyAdapter].getModelForPositionInternal(position: kotlin.Int): [ERROR : EpoxyModel<*>]<out [ERROR : *]>?
//                                                        ^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().(position)  value-parameter position: kotlin.Int
//                                                                  ^^^ reference kotlin/Int#
    return getModelForPosition(position)
//                             ^^^^^^^^ reference com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().(position)
}
