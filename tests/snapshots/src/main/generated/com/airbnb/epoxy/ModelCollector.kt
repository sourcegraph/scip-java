package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

/**
 * Interface used to collect models. Used by [EpoxyController]. It is also convenient to build DSL
 * helpers for carousel: @link https://github.com/airbnb/epoxy/issues/847.
 */
interface ModelCollector {
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelCollector#
//                       display_name ModelCollector
//                       documentation ```kt\npublic interface ModelCollector\n```\n\n----\n\n\n Interface used to collect models. Used by [EpoxyController]. It is also convenient to build DSL\n helpers for carousel: @link https://github.com/airbnb/epoxy/issues/847.\n
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/GroupModel#

    fun add(model: EpoxyModel<*>)
//      ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelCollector#add().
//          display_name add
//          documentation ```kt\npublic abstract fun add(model: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>)\n```
//          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/GroupModel#add().
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelCollector#add().(model)
//                display_name model
//                documentation ```kt\nvalue-parameter model: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>\n```
}
