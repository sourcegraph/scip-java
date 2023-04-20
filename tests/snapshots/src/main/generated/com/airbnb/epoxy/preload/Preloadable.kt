package com.airbnb.epoxy.preload
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/

import android.view.View

/**
 * Declares Views that should be preloaded. This can either be implemented by a custom view or by an [EpoxyHolder].
 *
 * The preloadable views can be recursive ie if [Preloadable.viewsToPreload] includes any views that are themselves Preloadable those nested
 * views will instead by used.
 */
interface Preloadable {
//        ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/Preloadable#
//                    documentation ```kt\npublic interface Preloadable\n```\n\n----\n\n\n Declares Views that should be preloaded. This can either be implemented by a custom view or by an [EpoxyHolder].\n\n The preloadable views can be recursive ie if [Preloadable.viewsToPreload] includes any views that are themselves Preloadable those nested\n views will instead by used.\n
    val viewsToPreload: List<View>
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/Preloadable#getViewsToPreload().
//                     documentation ```kt\npublic abstract val viewsToPreload: kotlin.collections.List<[ERROR : View]>\n```
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/Preloadable#viewsToPreload.
//                     documentation ```kt\npublic abstract val viewsToPreload: kotlin.collections.List<[ERROR : View]>\n```
//                      ^^^^ reference semanticdb maven . . kotlin/collections/List#
}
