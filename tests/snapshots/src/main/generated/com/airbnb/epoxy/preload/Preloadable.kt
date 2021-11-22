package com.airbnb.epoxy.preload
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/
//                       ^^^^^^^ reference com/airbnb/epoxy/preload/

import android.view.View

/**
 * Declares Views that should be preloaded. This can either be implemented by a custom view or by an [EpoxyHolder].
 *
 * The preloadable views can be recursive ie if [Preloadable.viewsToPreload] includes any views that are themselves Preloadable those nested
 * views will instead by used.
 */
interface Preloadable {
//        ^^^^^^^^^^^ definition com/airbnb/epoxy/preload/Preloadable#  public interface Preloadable
    val viewsToPreload: List<View>
//      ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/Preloadable#viewsToPreload.  public abstract val viewsToPreload: kotlin.collections.List<[ERROR : View]>
//      ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/Preloadable#getViewsToPreload().  public abstract val viewsToPreload: kotlin.collections.List<[ERROR : View]>
//                      ^^^^ reference kotlin/collections/List#
}
