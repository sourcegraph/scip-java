package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/

/**
 * Used in the generated models to transform normal view click listeners to model click
 * listeners.
 */
class WrappedEpoxyModelClickListener<T : EpoxyModel<*>, V> : OnClickListener, OnLongClickListener {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#
//                                   documentation ```kt\npublic final class WrappedEpoxyModelClickListener<T, V>\n```\n\n----\n\n\n Used in the generated models to transform normal view click listeners to model click\n listeners.\n
//                                   ^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                     documentation ```kt\n<T>\n```
//                                                      ^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
//                                                        documentation ```kt\n<V>\n```
    // Save the original click listener to call back to when clicked.
    // This also lets us call back to the original hashCode and equals methods
    private val originalClickListener: OnModelClickListener<T, V>?
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//                                    documentation ```kt\nprivate final val originalClickListener: [ERROR : OnModelClickListener<T, V>]<T, V>?\n```
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//                                    documentation ```kt\nprivate final val originalClickListener: [ERROR : OnModelClickListener<T, V>]<T, V>?\n```
//                                                          ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                                             ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
    private val originalLongClickListener: OnModelLongClickListener<T, V>?
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//                                        documentation ```kt\nprivate final val originalLongClickListener: [ERROR : OnModelLongClickListener<T, V>]<T, V>?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//                                        documentation ```kt\nprivate final val originalLongClickListener: [ERROR : OnModelLongClickListener<T, V>]<T, V>?\n```
//                                                                  ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                                                     ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]

    constructor(clickListener: OnModelClickListener<T, V>?) {
//  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`().
//              documentation ```kt\npublic constructor WrappedEpoxyModelClickListener<T, V>(clickListener: [ERROR : OnModelClickListener<T, V>]<T, V>?)\n```
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`().(clickListener)
//                            documentation ```kt\nvalue-parameter clickListener: [ERROR : OnModelClickListener<T, V>]<T, V>?\n```
//                                                  ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                                     ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
        requireNotNull(clickListener) {
//      ^^^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/PreconditionsKt#requireNotNull(+1).
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`().(clickListener)
            "Click listener cannot be null"
        }

        this.originalClickListener = clickListener
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#
//           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`().(clickListener)
        originalLongClickListener = null
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
    }

    constructor(clickListener: OnModelLongClickListener<T, V>?) {
//  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`(+1).
//              documentation ```kt\npublic constructor WrappedEpoxyModelClickListener<T, V>(clickListener: [ERROR : OnModelLongClickListener<T, V>]<T, V>?)\n```
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`(+1).(clickListener)
//                            documentation ```kt\nvalue-parameter clickListener: [ERROR : OnModelLongClickListener<T, V>]<T, V>?\n```
//                                                      ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                                         ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
        requireNotNull(clickListener) {
//      ^^^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/PreconditionsKt#requireNotNull(+1).
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`(+1).(clickListener)
            "Click listener cannot be null"
        }

        this.originalLongClickListener = clickListener
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//                                       ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`(+1).(clickListener)
        originalClickListener = null
//      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
    }

    override fun onClick(view: View) {
//               ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#onClick().
//                       documentation ```kt\npublic open fun onClick(view: [ERROR : View])\n```
//                       ^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#onClick().(view)
//                            documentation ```kt\nvalue-parameter view: [ERROR : View]\n```
        val modelInfo = getClickedModelInfo(view) ?: return
//          ^^^^^^^^^ definition local 0
//                    documentation ```kt\nval modelInfo: com.airbnb.epoxy.WrappedEpoxyModelClickListener.ClickedModelInfo\n```
//                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().
//                                          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#onClick().(view)

        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Suppress#`<init>`().
        originalClickListener?.onClick(
//      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
            modelInfo.model as T,
//          ^^^^^^^^^ reference local 0
//                    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getModel().
//                    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#model.
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
            modelInfo.boundObject as V,
//          ^^^^^^^^^ reference local 0
//                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#boundObject.
//                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getBoundObject().
//                                   ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
            view,
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#onClick().(view)
            modelInfo.adapterPosition
//          ^^^^^^^^^ reference local 0
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#adapterPosition.
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getAdapterPosition().
        ) ?: error("Original click listener is null")
//           ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/PreconditionsKt#error().
    }

    override fun onLongClick(view: View): Boolean {
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#onLongClick().
//                           documentation ```kt\npublic open fun onLongClick(view: [ERROR : View]): kotlin.Boolean\n```
//                           ^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#onLongClick().(view)
//                                documentation ```kt\nvalue-parameter view: [ERROR : View]\n```
//                                        ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        val modelInfo = getClickedModelInfo(view) ?: return false
//          ^^^^^^^^^ definition local 1
//                    documentation ```kt\nval modelInfo: com.airbnb.epoxy.WrappedEpoxyModelClickListener.ClickedModelInfo\n```
//                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().
//                                          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#onLongClick().(view)

        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Suppress#`<init>`().
        return originalLongClickListener?.onLongClick(
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
            modelInfo.model as T,
//          ^^^^^^^^^ reference local 1
//                    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getModel().
//                    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#model.
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
            modelInfo.boundObject as V,
//          ^^^^^^^^^ reference local 1
//                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#boundObject.
//                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getBoundObject().
//                                   ^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
            view,
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#onLongClick().(view)
            modelInfo.adapterPosition
//          ^^^^^^^^^ reference local 1
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#adapterPosition.
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getAdapterPosition().
        ) ?: error("Original long click listener is null")
//           ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/PreconditionsKt#error().
    }

    private fun getClickedModelInfo(view: View): ClickedModelInfo? {
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().
//                                  documentation ```kt\nprivate final fun getClickedModelInfo(view: [ERROR : View]): com.airbnb.epoxy.WrappedEpoxyModelClickListener.ClickedModelInfo?\n```
//                                  ^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().(view)
//                                       documentation ```kt\nvalue-parameter view: [ERROR : View]\n```
//                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#
        val epoxyHolder = ListenersUtils.getEpoxyHolderForChildView(view)
//          ^^^^^^^^^^^ definition local 2
//                      documentation ```kt\nval epoxyHolder: kotlin.Nothing\n```
//                                                                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().(view)
            ?: error("Could not find RecyclerView holder for clicked view")
//             ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/PreconditionsKt#error().

        val adapterPosition = epoxyHolder.adapterPosition
//          ^^^^^^^^^^^^^^^ definition local 3
//                          documentation ```kt\nval adapterPosition: [ERROR : Type for epoxyHolder.adapterPosition]\n```
//                            ^^^^^^^^^^^ reference local 2
        if (adapterPosition == RecyclerView.NO_POSITION) return null
//          ^^^^^^^^^^^^^^^ reference local 3

        val boundObject = epoxyHolder.objectToBind()
//          ^^^^^^^^^^^ definition local 4
//                      documentation ```kt\nval boundObject: [ERROR : Type for epoxyHolder.objectToBind()]\n```
//                        ^^^^^^^^^^^ reference local 2

        val holderToUse = if (boundObject is ModelGroupHolder) {
//          ^^^^^^^^^^^ definition local 5
//                      documentation ```kt\nval holderToUse: kotlin.Nothing\n```
//                            ^^^^^^^^^^^ reference local 4
//                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#
            // For a model group the clicked view could belong to any of the nested models in the group.
            // We check the viewholder of each model to see if the clicked view is in that hierarchy
            // in order to figure out which model it belongs to.
            // If it doesn't match any of the nested models then it could be set by the top level
            // parent model.
            boundObject.viewHolders
//          ^^^^^^^^^^^ reference local 4
                .firstOrNull { view in it.itemView.allViewsInHierarchy }
//                             ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().(view)
                ?: epoxyHolder
//                 ^^^^^^^^^^^ reference local 2
        } else {
            epoxyHolder
//          ^^^^^^^^^^^ reference local 2
        }

        // We return the holder and position because since we may be returning a nested group
        // holder the callee cannot use that to get the adapter position of the main model.
        return ClickedModelInfo(
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().
            holderToUse.model,
//          ^^^^^^^^^^^ reference local 5
            adapterPosition,
//          ^^^^^^^^^^^^^^^ reference local 3
            holderToUse.objectToBind()
//          ^^^^^^^^^^^ reference local 5
        )
    }

    private class ClickedModelInfo(
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#
//                                 documentation ```kt\nprivate final class ClickedModelInfo\n```
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().
//                                 documentation ```kt\npublic constructor ClickedModelInfo(model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>, adapterPosition: kotlin.Int, boundObject: kotlin.Any)\n```
        val model: EpoxyModel<*>,
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().(model)
//                documentation ```kt\nvalue-parameter model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>\n```
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getModel().
//                documentation ```kt\npublic final val model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>\n```
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#model.
//                documentation ```kt\npublic final val model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>\n```
        val adapterPosition: Int,
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().(adapterPosition)
//                          documentation ```kt\nvalue-parameter adapterPosition: kotlin.Int\n```
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#adapterPosition.
//                          documentation ```kt\npublic final val adapterPosition: kotlin.Int\n```
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getAdapterPosition().
//                          documentation ```kt\npublic final val adapterPosition: kotlin.Int\n```
//                           ^^^ reference semanticdb maven . . kotlin/Int#
        val boundObject: Any
//          ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().(boundObject)
//                      documentation ```kt\nvalue-parameter boundObject: kotlin.Any\n```
//          ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#boundObject.
//                      documentation ```kt\npublic final val boundObject: kotlin.Any\n```
//          ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getBoundObject().
//                      documentation ```kt\npublic final val boundObject: kotlin.Any\n```
//                       ^^^ reference semanticdb maven . . kotlin/Any#
    )

    /**
     * Returns a sequence of this View plus any and all children, recursively.
     */
    private val View.allViewsInHierarchy: Sequence<View>
//                   ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#allViewsInHierarchy.
//                                       documentation ```kt\nprivate final val [ERROR : View].allViewsInHierarchy: kotlin.sequences.Sequence<[ERROR : View]>\n```\n\n----\n\n\n Returns a sequence of this View plus any and all children, recursively.\n
//                                        ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/sequences/Sequence#
        get() {
//      ^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getAllViewsInHierarchy().
//          documentation ```kt\nprivate final fun [ERROR : View].<get-allViewsInHierarchy>(): kotlin.sequences.Sequence<[ERROR : View]>\n```
            return if (this is ViewGroup) {
//                     ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#allViewsInHierarchy.
                children.flatMap {
                    sequenceOf(it) + if (it is ViewGroup) it.allViewsInHierarchy else emptySequence()
                }.plus(this)
//                     ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#allViewsInHierarchy.
            } else {
                sequenceOf(this)
//                         ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#allViewsInHierarchy.
            }
        }

    /** Returns a [Sequence] over the child views in this view group. */
    internal val ViewGroup.children: Sequence<View>
//                         ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#children.
//                                  documentation ```kt\ninternal final val [ERROR : ViewGroup].children: kotlin.sequences.Sequence<[ERROR : View]>\n```\n\n----\n\n Returns a [Sequence] over the child views in this view group.
//                                   ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/sequences/Sequence#
        get() = object : Sequence<View> {
//      ^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getChildren().
//          documentation ```kt\ninternal final fun [ERROR : ViewGroup].<get-children>(): kotlin.sequences.Sequence<[ERROR : View]>\n```
//                       ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/sequences/Sequence#
            override fun iterator() = this@children.iterator()
//                       ^^^^^^^^ definition local 6
//                                documentation ```kt\npublic open fun iterator(): [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//                                    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#children.
        }

    /** Returns a [MutableIterator] over the views in this view group. */
    internal operator fun ViewGroup.iterator() = object : MutableIterator<View> {
//                                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#iterator().
//                                           documentation ```kt\ninternal final operator fun [ERROR : ViewGroup].iterator(): kotlin.collections.MutableIterator<[ERROR : View]>\n```\n\n----\n\n Returns a [MutableIterator] over the views in this view group.
//                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#
        private var index = 0
//                  ^^^^^ definition local 7
//                        documentation ```kt\nprivate final var index: kotlin.Int\n```
//                  ^^^^^ definition local 8
//                        documentation ```kt\nprivate final var index: kotlin.Int\n```
//                  ^^^^^ definition local 9
//                        documentation ```kt\nprivate final var index: kotlin.Int\n```
        override fun hasNext() = index < childCount
//                   ^^^^^^^ definition local 10
//                           documentation ```kt\npublic open fun hasNext(): [ERROR : Error function type]\n```
//                               ^^^^^ reference local 7
//                               ^^^^^ reference local 8
//                               ^^^^^ reference local 9
        override fun next() = getChildAt(index++) ?: throw IndexOutOfBoundsException()
//                   ^^^^ definition local 11
//                        documentation ```kt\npublic open fun next(): kotlin.Nothing\n```
//                                       ^^^^^ reference local 7
//                                       ^^^^^ reference local 8
//                                       ^^^^^ reference local 9
//                                            ^^ reference semanticdb maven . . kotlin/Int#inc().
        override fun remove() = removeViewAt(--index)
//                   ^^^^^^ definition local 12
//                          documentation ```kt\npublic open fun remove(): [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//                                           ^^ reference semanticdb maven . . kotlin/Int#dec().
//                                             ^^^^^ reference local 7
//                                             ^^^^^ reference local 8
//                                             ^^^^^ reference local 9
    }

    override fun equals(other: Any?): Boolean {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().
//                      documentation ```kt\npublic open fun equals(other: kotlin.Any?): kotlin.Boolean\n```
//                      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                            documentation ```kt\nvalue-parameter other: kotlin.Any?\n```
//                             ^^^ reference semanticdb maven . . kotlin/Any#
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        if (this === other) {
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#
//                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
            return true
        }

        if (other !is WrappedEpoxyModelClickListener<*, *>) {
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#
            return false
        }

        if (if (originalClickListener != null) {
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
            originalClickListener != other.originalClickListener
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//                                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//                                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
        } else {
                other.originalClickListener != null
//              ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
            }
        ) {
            return false
        }
        return if (originalLongClickListener != null) {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
            originalLongClickListener == other.originalLongClickListener
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//                                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
        } else {
            other.originalLongClickListener == null
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
        }
    }

    override fun hashCode(): Int {
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#hashCode().
//                        documentation ```kt\npublic open fun hashCode(): kotlin.Int\n```
//                           ^^^ reference semanticdb maven . . kotlin/Int#
        var result = originalClickListener?.hashCode() ?: 0
//          ^^^^^^ definition local 13
//                 documentation ```kt\nvar result: kotlin.Int\n```
//                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
        result = 31 * result + (originalLongClickListener?.hashCode() ?: 0)
//      ^^^^^^ reference local 13
//                  ^ reference semanticdb maven . . kotlin/Int#times(+3).
//                    ^^^^^^ reference local 13
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
        return result
//             ^^^^^^ reference local 13
    }
}
