package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

import android.util.SparseArray
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import androidx.recyclerview.widget.RecyclerView.ViewHolder
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import java.util.LinkedList
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedList#
import java.util.Queue
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^ reference semanticdb maven jdk 11 java/util/Queue#

/**
 * Like its parent, UnboundedViewPool lets you share Views between multiple RecyclerViews. However
 * there is no maximum number of recycled views that it will store. This usually ends up being
 * optimal, barring any hard memory constraints, as RecyclerViews do not recycle more Views than
 * they need.
 */
internal class UnboundedViewPool : RecycledViewPool() {
//             ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#
//                               documentation ```kt\ninternal final class UnboundedViewPool\n```\n\n----\n\n\n Like its parent, UnboundedViewPool lets you share Views between multiple RecyclerViews. However\n there is no maximum number of recycled views that it will store. This usually ends up being\n optimal, barring any hard memory constraints, as RecyclerViews do not recycle more Views than\n they need.\n
//             ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#`<init>`().
//                               documentation ```kt\npublic constructor UnboundedViewPool()\n```\n\n----\n\n\n Like its parent, UnboundedViewPool lets you share Views between multiple RecyclerViews. However\n there is no maximum number of recycled views that it will store. This usually ends up being\n optimal, barring any hard memory constraints, as RecyclerViews do not recycle more Views than\n they need.\n

    private val scrapHeaps = SparseArray<Queue<ViewHolder>>()
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                         documentation ```kt\nprivate final val scrapHeaps: [ERROR : Type for SparseArray<Queue<ViewHolder>>()]\n```
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//                         documentation ```kt\nprivate final val scrapHeaps: [ERROR : Type for SparseArray<Queue<ViewHolder>>()]\n```
//                                       ^^^^^ reference semanticdb maven jdk 11 java/util/Queue#

    override fun clear() {
//               ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#clear().
//                     documentation ```kt\npublic open fun clear()\n```
        scrapHeaps.clear()
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
    }

    override fun setMaxRecycledViews(viewType: Int, max: Int) {
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#setMaxRecycledViews().
//                                   documentation ```kt\npublic open fun setMaxRecycledViews(viewType: kotlin.Int, max: kotlin.Int)\n```
//                                   ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#setMaxRecycledViews().(viewType)
//                                            documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//                                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                                  ^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#setMaxRecycledViews().(max)
//                                                      documentation ```kt\nvalue-parameter max: kotlin.Int\n```
//                                                       ^^^ reference semanticdb maven . . kotlin/Int#
        throw UnsupportedOperationException(
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/UnsupportedOperationException#`<init>`(+1).
            "UnboundedViewPool does not support setting a maximum number of recycled views"
        )
    }

    override fun getRecycledView(viewType: Int): ViewHolder? {
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledView().
//                               documentation ```kt\npublic open fun getRecycledView(viewType: kotlin.Int): [ERROR : ViewHolder]?\n```
//                               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledView().(viewType)
//                                        documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//                                         ^^^ reference semanticdb maven . . kotlin/Int#
        val scrapHeap = scrapHeaps.get(viewType)
//          ^^^^^^^^^ definition local 0
//                    documentation ```kt\nval scrapHeap: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//                                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledView().(viewType)
        return scrapHeap?.poll()
//             ^^^^^^^^^ reference local 0
    }

    override fun putRecycledView(viewHolder: ViewHolder) {
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#putRecycledView().
//                               documentation ```kt\npublic open fun putRecycledView(viewHolder: [ERROR : ViewHolder])\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#putRecycledView().(viewHolder)
//                                          documentation ```kt\nvalue-parameter viewHolder: [ERROR : ViewHolder]\n```
        getScrapHeapForType(viewHolder.itemViewType).add(viewHolder)
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().
//                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#putRecycledView().(viewHolder)
//                                                   ^^^ reference semanticdb maven jdk 11 java/util/Queue#add().
//                                                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#putRecycledView().(viewHolder)
    }

    override fun getRecycledViewCount(viewType: Int): Int {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledViewCount().
//                                    documentation ```kt\npublic open fun getRecycledViewCount(viewType: kotlin.Int): kotlin.Int\n```
//                                    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledViewCount().(viewType)
//                                             documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//                                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                                    ^^^ reference semanticdb maven . . kotlin/Int#
        return scrapHeaps.get(viewType)?.size ?: 0
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledViewCount().(viewType)
    }

    private fun getScrapHeapForType(viewType: Int): Queue<ViewHolder> {
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().
//                                  documentation ```kt\nprivate final fun getScrapHeapForType(viewType: kotlin.Int): java.util.Queue<[ERROR : ViewHolder]>\n```
//                                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().(viewType)
//                                           documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//                                            ^^^ reference semanticdb maven . . kotlin/Int#
//                                                  ^^^^^ reference semanticdb maven jdk 11 java/util/Queue#
        var scrapHeap: Queue<ViewHolder>? = scrapHeaps.get(viewType)
//          ^^^^^^^^^ definition local 1
//                    documentation ```kt\nvar scrapHeap: java.util.Queue<[ERROR : ViewHolder]>?\n```
//                     ^^^^^ reference semanticdb maven jdk 11 java/util/Queue#
//                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//                                                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().(viewType)
        if (scrapHeap == null) {
//          ^^^^^^^^^ reference local 1
//                    ^^ reference semanticdb maven jdk 11 java/util/Queue#equals().
            scrapHeap = LinkedList()
//          ^^^^^^^^^ reference local 1
//                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedList#`<init>`().
            scrapHeaps.put(viewType, scrapHeap)
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().(viewType)
//                                   ^^^^^^^^^ reference local 1
        }
        return scrapHeap
//             ^^^^^^^^^ reference local 1
    }
}
