package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference androidx/

/**
 * Used in the generated models to transform normal view click listeners to model click
 * listeners.
 */
class WrappedEpoxyModelClickListener<T : EpoxyModel<*>, V> : OnClickListener, OnLongClickListener {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#
//                                   ^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                                      ^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
    // Save the original click listener to call back to when clicked.
    // This also lets us call back to the original hashCode and equals methods
    private val originalClickListener: OnModelClickListener<T, V>?
//              ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//              ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//                                                          ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                                             ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
    private val originalLongClickListener: OnModelLongClickListener<T, V>?
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//                                                                  ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                                                     ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]

    constructor(clickListener: OnModelClickListener<T, V>?) {
//  ^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`().
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`().(clickListener)
//                                                  ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                                     ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
        requireNotNull(clickListener) {
//      ^^^^^^^^^^^^^^ reference kotlin/PreconditionsKt#requireNotNull(+1).
//                     ^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`().(clickListener)
            "Click listener cannot be null"
        }

        this.originalClickListener = clickListener
//      ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#
//           ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//           ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//                                   ^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`().(clickListener)
        originalLongClickListener = null
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
    }

    constructor(clickListener: OnModelLongClickListener<T, V>?) {
//  ^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`(+1).
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`(+1).(clickListener)
//                                                      ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
//                                                         ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
        requireNotNull(clickListener) {
//      ^^^^^^^^^^^^^^ reference kotlin/PreconditionsKt#requireNotNull(+1).
//                     ^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`(+1).(clickListener)
            "Click listener cannot be null"
        }

        this.originalLongClickListener = clickListener
//      ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//                                       ^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#`<init>`(+1).(clickListener)
        originalClickListener = null
//      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
    }

    override fun onClick(view: View) {
//               ^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#onClick().
//                       ^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#onClick().(view)
        val modelInfo = getClickedModelInfo(view) ?: return
//          ^^^^^^^^^ definition local0
//                      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().
//                                          ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#onClick().(view)

        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference kotlin/Suppress#`<init>`().
        originalClickListener?.onClick(
//      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
            modelInfo.model as T,
//          ^^^^^^^^^ reference local0
//                    ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#model.
//                    ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getModel().
//                             ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
            modelInfo.boundObject as V,
//          ^^^^^^^^^ reference local0
//                    ^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#boundObject.
//                    ^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getBoundObject().
//                                   ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
            view,
//          ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#onClick().(view)
            modelInfo.adapterPosition
//          ^^^^^^^^^ reference local0
//                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#adapterPosition.
//                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getAdapterPosition().
        ) ?: error("Original click listener is null")
//           ^^^^^ reference kotlin/PreconditionsKt#error().
    }

    override fun onLongClick(view: View): Boolean {
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#onLongClick().
//                           ^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#onLongClick().(view)
//                                        ^^^^^^^ reference kotlin/Boolean#
        val modelInfo = getClickedModelInfo(view) ?: return false
//          ^^^^^^^^^ definition local1
//                      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().
//                                          ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#onLongClick().(view)

        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference kotlin/Suppress#`<init>`().
        return originalLongClickListener?.onLongClick(
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
            modelInfo.model as T,
//          ^^^^^^^^^ reference local1
//                    ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#model.
//                    ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getModel().
//                             ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[T]
            modelInfo.boundObject as V,
//          ^^^^^^^^^ reference local1
//                    ^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#boundObject.
//                    ^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getBoundObject().
//                                   ^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#[V]
            view,
//          ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#onLongClick().(view)
            modelInfo.adapterPosition
//          ^^^^^^^^^ reference local1
//                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#adapterPosition.
//                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getAdapterPosition().
        ) ?: error("Original long click listener is null")
//           ^^^^^ reference kotlin/PreconditionsKt#error().
    }

    private fun getClickedModelInfo(view: View): ClickedModelInfo? {
//              ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().
//                                  ^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().(view)
//                                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#
        val epoxyHolder = ListenersUtils.getEpoxyHolderForChildView(view)
//          ^^^^^^^^^^^ definition local2
//                                                                  ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().(view)
            ?: error("Could not find RecyclerView holder for clicked view")
//             ^^^^^ reference kotlin/PreconditionsKt#error().

        val adapterPosition = epoxyHolder.adapterPosition
//          ^^^^^^^^^^^^^^^ definition local3
//                            ^^^^^^^^^^^ reference local2
        if (adapterPosition == RecyclerView.NO_POSITION) return null
//          ^^^^^^^^^^^^^^^ reference local3

        val boundObject = epoxyHolder.objectToBind()
//          ^^^^^^^^^^^ definition local4
//                        ^^^^^^^^^^^ reference local2

        val holderToUse = if (boundObject is ModelGroupHolder) {
//          ^^^^^^^^^^^ definition local5
//                            ^^^^^^^^^^^ reference local4
//                                           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#
            // For a model group the clicked view could belong to any of the nested models in the group.
            // We check the viewholder of each model to see if the clicked view is in that hierarchy
            // in order to figure out which model it belongs to.
            // If it doesn't match any of the nested models then it could be set by the top level
            // parent model.
            boundObject.viewHolders
//          ^^^^^^^^^^^ reference local4
                .firstOrNull { view in it.itemView.allViewsInHierarchy }
//                             ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getClickedModelInfo().(view)
                ?: epoxyHolder
//                 ^^^^^^^^^^^ reference local2
        } else {
            epoxyHolder
//          ^^^^^^^^^^^ reference local2
        }

        // We return the holder and position because since we may be returning a nested group
        // holder the callee cannot use that to get the adapter position of the main model.
        return ClickedModelInfo(
//             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().
            holderToUse.model,
//          ^^^^^^^^^^^ reference local5
            adapterPosition,
//          ^^^^^^^^^^^^^^^ reference local3
            holderToUse.objectToBind()
//          ^^^^^^^^^^^ reference local5
        )
    }

    private class ClickedModelInfo(
//                ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#
//                ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().
        val model: EpoxyModel<*>,
//          ^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#model.
//          ^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getModel().
//          ^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().(model)
        val adapterPosition: Int,
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#adapterPosition.
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getAdapterPosition().
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().(adapterPosition)
//                           ^^^ reference kotlin/Int#
        val boundObject: Any
//          ^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#boundObject.
//          ^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#getBoundObject().
//          ^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#ClickedModelInfo#`<init>`().(boundObject)
//                       ^^^ reference kotlin/Any#
    )

    /**
     * Returns a sequence of this View plus any and all children, recursively.
     */
    private val View.allViewsInHierarchy: Sequence<View>
//                   ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#allViewsInHierarchy.
//                                        ^^^^^^^^ reference kotlin/sequences/Sequence#
        get() {
//      ^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#getAllViewsInHierarchy().
            return if (this is ViewGroup) {
//                     ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#allViewsInHierarchy.
                children.flatMap {
                    sequenceOf(it) + if (it is ViewGroup) it.allViewsInHierarchy else emptySequence()
                }.plus(this)
//                     ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#allViewsInHierarchy.
            } else {
                sequenceOf(this)
//                         ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#allViewsInHierarchy.
            }
        }

    /** Returns a [Sequence] over the child views in this view group. */
    internal val ViewGroup.children: Sequence<View>
//                         ^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#children.
//                                   ^^^^^^^^ reference kotlin/sequences/Sequence#
        get() = object : Sequence<View> {
//      ^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#getChildren().
//                       ^^^^^^^^ reference kotlin/sequences/Sequence#
            override fun iterator() = this@children.iterator()
//                       ^^^^^^^^ definition local6
//                                    ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#children.
        }

    /** Returns a [MutableIterator] over the views in this view group. */
    internal operator fun ViewGroup.iterator() = object : MutableIterator<View> {
//                                  ^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#iterator().
//                                                        ^^^^^^^^^^^^^^^ reference kotlin/collections/MutableIterator#
        private var index = 0
//                  ^^^^^ definition local7
//                  ^^^^^ definition local8
//                  ^^^^^ definition local9
        override fun hasNext() = index < childCount
//                   ^^^^^^^ definition local10
//                               ^^^^^ reference local7
//                               ^^^^^ reference local8
//                               ^^^^^ reference local9
        override fun next() = getChildAt(index++) ?: throw IndexOutOfBoundsException()
//                   ^^^^ definition local11
//                                       ^^^^^ reference local7
//                                       ^^^^^ reference local8
//                                       ^^^^^ reference local9
//                                            ^^ reference kotlin/Int#inc().
        override fun remove() = removeViewAt(--index)
//                   ^^^^^^ definition local12
//                                           ^^ reference kotlin/Int#dec().
//                                             ^^^^^ reference local7
//                                             ^^^^^ reference local8
//                                             ^^^^^ reference local9
    }

    override fun equals(other: Any?): Boolean {
//               ^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().
//                      ^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                             ^^^ reference kotlin/Any#
//                                    ^^^^^^^ reference kotlin/Boolean#
        if (this === other) {
//          ^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#
//                   ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
            return true
        }

        if (other !is WrappedEpoxyModelClickListener<*, *>) {
//          ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#
            return false
        }

        if (if (originalClickListener != null) {
//              ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//              ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
            originalClickListener != other.originalClickListener
//          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
//                                   ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                                         ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//                                         ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
        } else {
                other.originalClickListener != null
//              ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                    ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//                    ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
            }
        ) {
            return false
        }
        return if (originalLongClickListener != null) {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
            originalLongClickListener == other.originalLongClickListener
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
//                                       ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
        } else {
            other.originalLongClickListener == null
//          ^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#equals().(other)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
        }
    }

    override fun hashCode(): Int {
//               ^^^^^^^^ definition com/airbnb/epoxy/WrappedEpoxyModelClickListener#hashCode().
//                           ^^^ reference kotlin/Int#
        var result = originalClickListener?.hashCode() ?: 0
//          ^^^^^^ definition local13
//                   ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalClickListener.
//                   ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalClickListener().
        result = 31 * result + (originalLongClickListener?.hashCode() ?: 0)
//      ^^^^^^ reference local13
//                  ^ reference kotlin/Int#times(+3).
//                    ^^^^^^ reference local13
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#originalLongClickListener.
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/WrappedEpoxyModelClickListener#getOriginalLongClickListener().
        return result
//             ^^^^^^ reference local13
    }
}
