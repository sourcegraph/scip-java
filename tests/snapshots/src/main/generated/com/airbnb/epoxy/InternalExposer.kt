package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

/**
 * Exposes package private things as internal so files in other packages can use them.
 */

internal fun EpoxyViewHolder.objectToBindInternal() = objectToBind()
//                           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#objectToBindInternal().
//                                                display_name objectToBindInternal
//                                                documentation ```kt\ninternal fun [Error type: Unresolved type for EpoxyViewHolder].objectToBindInternal(): [Error type: Return type for function cannot be resolved]\n```\n\n----\n\n\n Exposes package private things as internal so files in other packages can use them.\n

internal fun EpoxyModel<*>.viewTypeInternal() = viewType
//                         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#viewTypeInternal().
//                                          display_name viewTypeInternal
//                                          documentation ```kt\ninternal fun [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>.viewTypeInternal(): [Error type: Error property type]\n```
internal fun BaseEpoxyAdapter.boundViewHoldersInternal() = boundViewHolders
//                            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#boundViewHoldersInternal().
//                                                     display_name boundViewHoldersInternal
//                                                     documentation ```kt\ninternal fun [Error type: Unresolved type for BaseEpoxyAdapter].boundViewHoldersInternal(): [Error type: Error property type]\n```
internal fun BaseEpoxyAdapter.getModelForPositionInternal(position: Int): EpoxyModel<*>? {
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().
//                                                        display_name getModelForPositionInternal
//                                                        documentation ```kt\ninternal fun [Error type: Unresolved type for BaseEpoxyAdapter].getModelForPositionInternal(position: kotlin.Int): [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>?\n```
//                                                        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().(position)
//                                                                 display_name position
//                                                                 documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                                                  ^^^ reference semanticdb maven . . kotlin/Int#
    return getModelForPosition(position)
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().(position)
}
