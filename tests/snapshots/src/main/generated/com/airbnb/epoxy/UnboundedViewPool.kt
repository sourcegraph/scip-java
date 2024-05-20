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
//                               display_name UnboundedViewPool
//                               documentation ```kt\ninternal final class UnboundedViewPool\n```\n\n----\n\n\n Like its parent, UnboundedViewPool lets you share Views between multiple RecyclerViews. However\n there is no maximum number of recycled views that it will store. This usually ends up being\n optimal, barring any hard memory constraints, as RecyclerViews do not recycle more Views than\n they need.\n
//             ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#`<init>`().
//                               display_name UnboundedViewPool
//                               documentation ```kt\npublic constructor UnboundedViewPool()\n```\n\n----\n\n\n Like its parent, UnboundedViewPool lets you share Views between multiple RecyclerViews. However\n there is no maximum number of recycled views that it will store. This usually ends up being\n optimal, barring any hard memory constraints, as RecyclerViews do not recycle more Views than\n they need.\n

    private val scrapHeaps = SparseArray<Queue<ViewHolder>>()
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                         display_name scrapHeaps
//                         documentation ```kt\nprivate final val scrapHeaps: [Error type: Not found recorded type for SparseArray<Queue<ViewHolder>>()]\n```
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//                         display_name scrapHeaps
//                         documentation ```kt\nprivate final val scrapHeaps: [Error type: Not found recorded type for SparseArray<Queue<ViewHolder>>()]\n```
//                                       ^^^^^ reference semanticdb maven jdk 11 java/util/Queue#

    override fun clear() {
//               ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#clear().
//                     display_name clear
//                     documentation ```kt\npublic open fun clear()\n```
        scrapHeaps.clear()
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
    }

    override fun setMaxRecycledViews(viewType: Int, max: Int) {
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#setMaxRecycledViews().
//                                   display_name setMaxRecycledViews
//                                   documentation ```kt\npublic open fun setMaxRecycledViews(viewType: kotlin.Int, max: kotlin.Int)\n```
//                                   ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#setMaxRecycledViews().(viewType)
//                                            display_name viewType
//                                            documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//                                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                                  ^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#setMaxRecycledViews().(max)
//                                                      display_name max
//                                                      documentation ```kt\nvalue-parameter max: kotlin.Int\n```
//                                                       ^^^ reference semanticdb maven . . kotlin/Int#
        throw UnsupportedOperationException(
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/UnsupportedOperationException#`<init>`(+1).
            "UnboundedViewPool does not support setting a maximum number of recycled views"
        )
    }

    override fun getRecycledView(viewType: Int): ViewHolder? {
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledView().
//                               display_name getRecycledView
//                               documentation ```kt\npublic open fun getRecycledView(viewType: kotlin.Int): [Error type: Unresolved type for ViewHolder]?\n```
//                               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledView().(viewType)
//                                        display_name viewType
//                                        documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//                                         ^^^ reference semanticdb maven . . kotlin/Int#
        val scrapHeap = scrapHeaps.get(viewType)
//          ^^^^^^^^^ definition local 0
//                    display_name scrapHeap
//                    documentation ```kt\nval scrapHeap: [Error type: Return type for function cannot be resolved]\n```
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeaps().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#scrapHeaps.
//                                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledView().(viewType)
        return scrapHeap?.poll()
//             ^^^^^^^^^ reference local 0
    }

    override fun putRecycledView(viewHolder: ViewHolder) {
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#putRecycledView().
//                               display_name putRecycledView
//                               documentation ```kt\npublic open fun putRecycledView(viewHolder: [Error type: Unresolved type for ViewHolder])\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#putRecycledView().(viewHolder)
//                                          display_name viewHolder
//                                          documentation ```kt\nvalue-parameter viewHolder: [Error type: Unresolved type for ViewHolder]\n```
        getScrapHeapForType(viewHolder.itemViewType).add(viewHolder)
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().
//                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#putRecycledView().(viewHolder)
//                                                   ^^^ reference semanticdb maven jdk 11 java/util/Queue#add().
//                                                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#putRecycledView().(viewHolder)
    }

    override fun getRecycledViewCount(viewType: Int): Int {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledViewCount().
//                                    display_name getRecycledViewCount
//                                    documentation ```kt\npublic open fun getRecycledViewCount(viewType: kotlin.Int): kotlin.Int\n```
//                                    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getRecycledViewCount().(viewType)
//                                             display_name viewType
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
//                                  display_name getScrapHeapForType
//                                  documentation ```kt\nprivate final fun getScrapHeapForType(viewType: kotlin.Int): java.util.Queue<[Error type: Unresolved type for ViewHolder]>\n```
//                                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#getScrapHeapForType().(viewType)
//                                           display_name viewType
//                                           documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//                                            ^^^ reference semanticdb maven . . kotlin/Int#
//                                                  ^^^^^ reference semanticdb maven jdk 11 java/util/Queue#
        var scrapHeap: Queue<ViewHolder>? = scrapHeaps.get(viewType)
//          ^^^^^^^^^ definition local 1
//                    display_name scrapHeap
//                    documentation ```kt\nvar scrapHeap: java.util.Queue<[Error type: Unresolved type for ViewHolder]>?\n```
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
