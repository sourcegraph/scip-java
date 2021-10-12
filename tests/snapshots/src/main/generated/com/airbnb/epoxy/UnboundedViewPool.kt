package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

import android.util.SparseArray
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
//     ^^^^^^^^ reference androidx/
import androidx.recyclerview.widget.RecyclerView.ViewHolder
//     ^^^^^^^^ reference androidx/
import java.util.LinkedList
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^ reference java/util/LinkedList#
import java.util.Queue
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^ reference java/util/Queue#

/**
 * Like its parent, UnboundedViewPool lets you share Views between multiple RecyclerViews. However
 * there is no maximum number of recycled views that it will store. This usually ends up being
 * optimal, barring any hard memory constraints, as RecyclerViews do not recycle more Views than
 * they need.
 */
internal class UnboundedViewPool : RecycledViewPool() {
//             ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#
//             ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#`<init>`().

    private val scrapHeaps = SparseArray<Queue<ViewHolder>>()
//              ^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//              ^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                                       ^^^^^ reference java/util/Queue#

    override fun clear() {
//               ^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#clear().
        scrapHeaps.clear()
//      ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//      ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
    }

    override fun setMaxRecycledViews(viewType: Int, max: Int) {
//               ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#setMaxRecycledViews().
//                                   ^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#setMaxRecycledViews().(viewType)
//                                             ^^^ reference kotlin/Int#
//                                                  ^^^ definition com/airbnb/epoxy/UnboundedViewPool#setMaxRecycledViews().(max)
//                                                       ^^^ reference kotlin/Int#
        throw UnsupportedOperationException(
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference kotlin/UnsupportedOperationException#`<init>`(+1).
            "UnboundedViewPool does not support setting a maximum number of recycled views"
        )
    }

    override fun getRecycledView(viewType: Int): ViewHolder? {
//               ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#getRecycledView().
//                               ^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#getRecycledView().(viewType)
//                                         ^^^ reference kotlin/Int#
        val scrapHeap = scrapHeaps.get(viewType)
//          ^^^^^^^^^ definition local0
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                                     ^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getRecycledView().(viewType)
        return scrapHeap?.poll()
//             ^^^^^^^^^ reference local0
    }

    override fun putRecycledView(viewHolder: ViewHolder) {
//               ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#putRecycledView().
//                               ^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#putRecycledView().(viewHolder)
        getScrapHeapForType(viewHolder.itemViewType).add(viewHolder)
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().
//                          ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#putRecycledView().(viewHolder)
//                                                   ^^^ reference java/util/Queue#add().
//                                                       ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#putRecycledView().(viewHolder)
    }

    override fun getRecycledViewCount(viewType: Int): Int {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#getRecycledViewCount().
//                                    ^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#getRecycledViewCount().(viewType)
//                                              ^^^ reference kotlin/Int#
//                                                    ^^^ reference kotlin/Int#
        return scrapHeaps.get(viewType)?.size ?: 0
//             ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//             ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                            ^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getRecycledViewCount().(viewType)
    }

    private fun getScrapHeapForType(viewType: Int): Queue<ViewHolder> {
//              ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().
//                                  ^^^^^^^^ definition com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().(viewType)
//                                            ^^^ reference kotlin/Int#
//                                                  ^^^^^ reference java/util/Queue#
        var scrapHeap: Queue<ViewHolder>? = scrapHeaps.get(viewType)
//          ^^^^^^^^^ definition local1
//                     ^^^^^ reference java/util/Queue#
//                                          ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//                                          ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                                                         ^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().(viewType)
        if (scrapHeap == null) {
//          ^^^^^^^^^ reference local1
//                    ^^ reference java/util/Queue#equals().
            scrapHeap = LinkedList()
//          ^^^^^^^^^ reference local1
//                      ^^^^^^^^^^ reference java/util/LinkedList#`<init>`().
            scrapHeaps.put(viewType, scrapHeap)
//          ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//          ^^^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                         ^^^^^^^^ reference com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().(viewType)
//                                   ^^^^^^^^^ reference local1
        }
        return scrapHeap
//             ^^^^^^^^^ reference local1
    }
}
