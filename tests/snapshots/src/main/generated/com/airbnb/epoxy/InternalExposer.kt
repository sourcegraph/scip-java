package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

/**
 * Exposes package private things as internal so files in other packages can use them.
 */

internal fun EpoxyViewHolder.objectToBindInternal() = objectToBind()
//                           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#objectToBindInternal().
//                                                documentation ```kt\ninternal fun [ERROR : EpoxyViewHolder].objectToBindInternal(): [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```\n\n----\n\n\n Exposes package private things as internal so files in other packages can use them.\n

internal fun EpoxyModel<*>.viewTypeInternal() = viewType
//                         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#viewTypeInternal().
//                                          documentation ```kt\ninternal fun [ERROR : EpoxyModel<*>]<out [ERROR : *]>.viewTypeInternal(): [ERROR : <ERROR PROPERTY TYPE>]\n```
internal fun BaseEpoxyAdapter.boundViewHoldersInternal() = boundViewHolders
//                            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#boundViewHoldersInternal().
//                                                     documentation ```kt\ninternal fun [ERROR : BaseEpoxyAdapter].boundViewHoldersInternal(): [ERROR : <ERROR PROPERTY TYPE>]\n```
internal fun BaseEpoxyAdapter.getModelForPositionInternal(position: Int): EpoxyModel<*>? {
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().
//                                                        documentation ```kt\ninternal fun [ERROR : BaseEpoxyAdapter].getModelForPositionInternal(position: kotlin.Int): [ERROR : EpoxyModel<*>]<out [ERROR : *]>?\n```
//                                                        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().(position)
//                                                                 documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                                                  ^^^ reference semanticdb maven . . kotlin/Int#
    return getModelForPosition(position)
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().(position)
}
