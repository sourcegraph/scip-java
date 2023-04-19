package com.airbnb.epoxy.stickyheader
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/

import android.view.View
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/

/**
 * Adds sticky headers capabilities to any [RecyclerView.Adapter]
 * combined with [StickyHeaderLinearLayoutManager].
 */
interface StickyHeaderCallbacks {
//        ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#
//                              documentation ```kt\npublic interface StickyHeaderCallbacks\n```\n\n----\n\n\n Adds sticky headers capabilities to any [RecyclerView.Adapter]\n combined with [StickyHeaderLinearLayoutManager].\n

    /**
     * Return true if the view at the specified [position] needs to be sticky
     * else false.
     */
    fun isStickyHeader(position: Int): Boolean
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#isStickyHeader().
//                     documentation ```kt\npublic abstract fun isStickyHeader(position: kotlin.Int): kotlin.Boolean\n```\n\n----\n\n\n Return true if the view at the specified [position] needs to be sticky\n else false.\n
//                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#isStickyHeader().(position)
//                              documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                               ^^^ reference semanticdb maven . . kotlin/Int#
//                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    //region Optional callbacks

    /**
     * Callback to adjusts any necessary properties of the [stickyHeader] view
     * that is being used as a sticky, eg. elevation.
     * Default behaviour is no-op.
     *
     * [teardownStickyHeaderView] will be called sometime after this method
     * and before any other calls to this method go through.
     */
    fun setupStickyHeaderView(stickyHeader: View) = Unit
//      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#setupStickyHeaderView().
//                            documentation ```kt\npublic open fun setupStickyHeaderView(stickyHeader: [ERROR : View])\n```\n\n----\n\n\n Callback to adjusts any necessary properties of the [stickyHeader] view\n that is being used as a sticky, eg. elevation.\n Default behaviour is no-op.\n\n [teardownStickyHeaderView] will be called sometime after this method\n and before any other calls to this method go through.\n
//                            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#setupStickyHeaderView().(stickyHeader)
//                                         documentation ```kt\nvalue-parameter stickyHeader: [ERROR : View]\n```
//                                                  ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#

    /**
     * Callback to revert any properties changed in [setupStickyHeaderView].
     * Default behaviour is no-op.
     *
     * Called after [setupStickyHeaderView].
     */
    fun teardownStickyHeaderView(stickyHeader: View) = Unit
//      ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#teardownStickyHeaderView().
//                               documentation ```kt\npublic open fun teardownStickyHeaderView(stickyHeader: [ERROR : View])\n```\n\n----\n\n\n Callback to revert any properties changed in [setupStickyHeaderView].\n Default behaviour is no-op.\n\n Called after [setupStickyHeaderView].\n
//                               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#teardownStickyHeaderView().(stickyHeader)
//                                            documentation ```kt\nvalue-parameter stickyHeader: [ERROR : View]\n```
//                                                     ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#

    //endregion
}
