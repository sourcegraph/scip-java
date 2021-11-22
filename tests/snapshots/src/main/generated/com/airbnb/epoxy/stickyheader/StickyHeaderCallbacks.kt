package com.airbnb.epoxy.stickyheader
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/
//                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/

import android.view.View
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference androidx/

/**
 * Adds sticky headers capabilities to any [RecyclerView.Adapter]
 * combined with [StickyHeaderLinearLayoutManager].
 */
interface StickyHeaderCallbacks {
//        ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#  public interface StickyHeaderCallbacks

    /**
     * Return true if the view at the specified [position] needs to be sticky
     * else false.
     */
    fun isStickyHeader(position: Int): Boolean
//      ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#isStickyHeader().  public abstract fun isStickyHeader(position: kotlin.Int): kotlin.Boolean
//                     ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#isStickyHeader().(position)  value-parameter position: kotlin.Int
//                               ^^^ reference kotlin/Int#
//                                     ^^^^^^^ reference kotlin/Boolean#

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
//      ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#setupStickyHeaderView().  public open fun setupStickyHeaderView(stickyHeader: [ERROR : View])
//                            ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#setupStickyHeaderView().(stickyHeader)  value-parameter stickyHeader: [ERROR : View]
//                                                  ^^^^ reference kotlin/Unit#

    /**
     * Callback to revert any properties changed in [setupStickyHeaderView].
     * Default behaviour is no-op.
     *
     * Called after [setupStickyHeaderView].
     */
    fun teardownStickyHeaderView(stickyHeader: View) = Unit
//      ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#teardownStickyHeaderView().  public open fun teardownStickyHeaderView(stickyHeader: [ERROR : View])
//                               ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#teardownStickyHeaderView().(stickyHeader)  value-parameter stickyHeader: [ERROR : View]
//                                                     ^^^^ reference kotlin/Unit#

    //endregion
}
