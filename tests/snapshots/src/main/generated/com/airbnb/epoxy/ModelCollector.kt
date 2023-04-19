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
//                       documentation ```kt\npublic interface ModelCollector\n```\n\n----\n\n\n Interface used to collect models. Used by [EpoxyController]. It is also convenient to build DSL\n helpers for carousel: @link https://github.com/airbnb/epoxy/issues/847.\n

    fun add(model: EpoxyModel<*>)
//      ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelCollector#add().
//          documentation ```kt\npublic abstract fun add(model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>)\n```
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelCollector#add().(model)
//                documentation ```kt\nvalue-parameter model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>\n```
}
