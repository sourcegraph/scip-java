package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

/**
 * Interface used to collect models. Used by [EpoxyController]. It is also convenient to build DSL
 * helpers for carousel: @link https://github.com/airbnb/epoxy/issues/847.
 */
interface ModelCollector {
//        ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelCollector#  public interface ModelCollector

    fun add(model: EpoxyModel<*>)
//      ^^^ definition com/airbnb/epoxy/ModelCollector#add().  public abstract fun add(model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>)
//          ^^^^^ definition com/airbnb/epoxy/ModelCollector#add().(model)  value-parameter model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>
}
