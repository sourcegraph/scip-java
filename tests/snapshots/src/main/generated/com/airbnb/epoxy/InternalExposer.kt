package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

/**
 * Exposes package private things as internal so files in other packages can use them.
 */

internal fun EpoxyViewHolder.objectToBindInternal() = objectToBind()
//                           ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#objectToBindInternal().

internal fun EpoxyModel<*>.viewTypeInternal() = viewType
//                         ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#viewTypeInternal().
internal fun BaseEpoxyAdapter.boundViewHoldersInternal() = boundViewHolders
//                            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#boundViewHoldersInternal().
internal fun BaseEpoxyAdapter.getModelForPositionInternal(position: Int): EpoxyModel<*>? {
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().
//                                                        ^^^^^^^^ definition com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().(position)
//                                                                  ^^^ reference kotlin/Int#
    return getModelForPosition(position)
//                             ^^^^^^^^ reference com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().(position)
}
