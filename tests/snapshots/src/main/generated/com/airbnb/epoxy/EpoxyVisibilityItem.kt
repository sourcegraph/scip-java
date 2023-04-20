package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntRange
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#
import androidx.annotation.Px
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
import androidx.annotation.VisibleForTesting
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/

/**
 * This class represent an item in a [android.view.ViewGroup] and it is
 * being reused with multiple model via the update method. There is 1:1 relationship between an
 * EpoxyVisibilityItem and a child within the [android.view.ViewGroup].
 *
 * It contains the logic to compute the visibility state of an item. It will also invoke the
 * visibility callbacks on [com.airbnb.epoxy.EpoxyViewHolder]
 *
 * This class should remain non-public and is intended to be used by [EpoxyVisibilityTracker]
 * only.
 */
@VisibleForTesting(otherwise = VisibleForTesting.PACKAGE_PRIVATE)
//^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#`<init>`().
//                 ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#`<init>`().(otherwise)
//                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#PACKAGE_PRIVATE.
class EpoxyVisibilityItem(adapterPosition: Int? = null) {
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#
//                        documentation ```kt\npublic final class EpoxyVisibilityItem\n```\n\n----\n\n\n This class represent an item in a [android.view.ViewGroup] and it is\n being reused with multiple model via the update method. There is 1:1 relationship between an\n EpoxyVisibilityItem and a child within the [android.view.ViewGroup].\n\n It contains the logic to compute the visibility state of an item. It will also invoke the\n visibility callbacks on [com.airbnb.epoxy.EpoxyViewHolder]\n\n This class should remain non-public and is intended to be used by [EpoxyVisibilityTracker]\n only.\n
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#`<init>`().
//                        documentation ```kt\npublic constructor EpoxyVisibilityItem(adapterPosition: kotlin.Int? = ...)\n```
//                        ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#`<init>`().(adapterPosition)
//                                        documentation ```kt\nvalue-parameter adapterPosition: kotlin.Int? = ...\n```
//                                         ^^^ reference semanticdb maven . . kotlin/Int#

    private val localVisibleRect = Rect()
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().
//                               documentation ```kt\nprivate final val localVisibleRect: [ERROR : Type for Rect()]\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
//                               documentation ```kt\nprivate final val localVisibleRect: [ERROR : Type for Rect()]\n```

    var adapterPosition = RecyclerView.NO_POSITION
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//                      documentation ```kt\npublic final var adapterPosition: [ERROR : <ERROR PROPERTY TYPE>]\n```
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
//                      documentation ```kt\npublic final var adapterPosition: [ERROR : <ERROR PROPERTY TYPE>]\n```
        private set
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setAdapterPosition().
//                  documentation ```kt\nprivate final fun <set-adapterPosition>(<set-?>: [ERROR : <ERROR PROPERTY TYPE>])\n```

    @Px
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
    private var height = 0
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//                     documentation ```kt\nprivate final var height: kotlin.Int\n```
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#height.
//                     documentation ```kt\nprivate final var height: kotlin.Int\n```
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                     documentation ```kt\nprivate final var height: kotlin.Int\n```

    @Px
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
    private var width = 0
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                    documentation ```kt\nprivate final var width: kotlin.Int\n```
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//                    documentation ```kt\nprivate final var width: kotlin.Int\n```
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#width.
//                    documentation ```kt\nprivate final var width: kotlin.Int\n```

    @Px
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
    private var visibleHeight = 0
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                            documentation ```kt\nprivate final var visibleHeight: kotlin.Int\n```
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                            documentation ```kt\nprivate final var visibleHeight: kotlin.Int\n```
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                            documentation ```kt\nprivate final var visibleHeight: kotlin.Int\n```

    @Px
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
    private var visibleWidth = 0
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                           documentation ```kt\nprivate final var visibleWidth: kotlin.Int\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                           documentation ```kt\nprivate final var visibleWidth: kotlin.Int\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                           documentation ```kt\nprivate final var visibleWidth: kotlin.Int\n```

    @Px
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
    private var viewportHeight = 0
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewportHeight().
//                             documentation ```kt\nprivate final var viewportHeight: kotlin.Int\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewportHeight().
//                             documentation ```kt\nprivate final var viewportHeight: kotlin.Int\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewportHeight.
//                             documentation ```kt\nprivate final var viewportHeight: kotlin.Int\n```

    @Px
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
    private var viewportWidth = 0
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewportWidth().
//                            documentation ```kt\nprivate final var viewportWidth: kotlin.Int\n```
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewportWidth().
//                            documentation ```kt\nprivate final var viewportWidth: kotlin.Int\n```
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewportWidth.
//                            documentation ```kt\nprivate final var viewportWidth: kotlin.Int\n```
    private var partiallyVisible = false
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//                               documentation ```kt\nprivate final var partiallyVisible: kotlin.Boolean\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//                               documentation ```kt\nprivate final var partiallyVisible: kotlin.Boolean\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
//                               documentation ```kt\nprivate final var partiallyVisible: kotlin.Boolean\n```
    private var fullyVisible = false
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//                           documentation ```kt\nprivate final var fullyVisible: kotlin.Boolean\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//                           documentation ```kt\nprivate final var fullyVisible: kotlin.Boolean\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
//                           documentation ```kt\nprivate final var fullyVisible: kotlin.Boolean\n```
    private var visible = false
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//                      documentation ```kt\nprivate final var visible: kotlin.Boolean\n```
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
//                      documentation ```kt\nprivate final var visible: kotlin.Boolean\n```
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visible.
//                      documentation ```kt\nprivate final var visible: kotlin.Boolean\n```
    private var focusedVisible = false
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//                             documentation ```kt\nprivate final var focusedVisible: kotlin.Boolean\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//                             documentation ```kt\nprivate final var focusedVisible: kotlin.Boolean\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
//                             documentation ```kt\nprivate final var focusedVisible: kotlin.Boolean\n```
    private var viewVisibility = View.GONE
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//                             documentation ```kt\nprivate final var viewVisibility: [ERROR : <ERROR PROPERTY TYPE>]\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//                             documentation ```kt\nprivate final var viewVisibility: [ERROR : <ERROR PROPERTY TYPE>]\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//                             documentation ```kt\nprivate final var viewVisibility: [ERROR : <ERROR PROPERTY TYPE>]\n```

    /** Store last value for de-duping  */
    private var lastVisibleHeightNotified: Int? = null
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleHeightNotified().
//                                        documentation ```kt\nprivate final var lastVisibleHeightNotified: kotlin.Int?\n```\n\n----\n\n Store last value for de-duping
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleHeightNotified.
//                                        documentation ```kt\nprivate final var lastVisibleHeightNotified: kotlin.Int?\n```\n\n----\n\n Store last value for de-duping
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleHeightNotified().
//                                        documentation ```kt\nprivate final var lastVisibleHeightNotified: kotlin.Int?\n```\n\n----\n\n Store last value for de-duping
//                                         ^^^ reference semanticdb maven . . kotlin/Int#
    private var lastVisibleWidthNotified: Int? = null
//              ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleWidthNotified().
//                                       documentation ```kt\nprivate final var lastVisibleWidthNotified: kotlin.Int?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleWidthNotified.
//                                       documentation ```kt\nprivate final var lastVisibleWidthNotified: kotlin.Int?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleWidthNotified().
//                                       documentation ```kt\nprivate final var lastVisibleWidthNotified: kotlin.Int?\n```
//                                        ^^^ reference semanticdb maven . . kotlin/Int#
    private var lastVisibilityNotified: Int? = null
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibilityNotified().
//                                     documentation ```kt\nprivate final var lastVisibilityNotified: kotlin.Int?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibilityNotified.
//                                     documentation ```kt\nprivate final var lastVisibilityNotified: kotlin.Int?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibilityNotified().
//                                     documentation ```kt\nprivate final var lastVisibilityNotified: kotlin.Int?\n```
//                                      ^^^ reference semanticdb maven . . kotlin/Int#

    init {
        adapterPosition?.let {
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#`<init>`().(adapterPosition)
//                       ^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/StandardKt#let().
            reset(it)
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#reset().
//                ^^ reference local 0
        }
    }

    /**
     * Update the visibility item according the current layout.
     *
     * @param view        the current [com.airbnb.epoxy.EpoxyViewHolder]'s itemView
     * @param parent      the [android.view.ViewGroup]
     * @return true if the view has been measured
     */
    fun update(view: View, parent: ViewGroup, detachEvent: Boolean): Boolean {
//      ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().
//             documentation ```kt\npublic final fun update(view: [ERROR : View], parent: [ERROR : ViewGroup], detachEvent: kotlin.Boolean): kotlin.Boolean\n```\n\n----\n\n\n Update the visibility item according the current layout.\n\n @param view        the current [com.airbnb.epoxy.EpoxyViewHolder]'s itemView\n @param parent      the [android.view.ViewGroup]\n @return true if the view has been measured\n
//             ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
//                  documentation ```kt\nvalue-parameter view: [ERROR : View]\n```
//                         ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(parent)
//                                documentation ```kt\nvalue-parameter parent: [ERROR : ViewGroup]\n```
//                                            ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(detachEvent)
//                                                        documentation ```kt\nvalue-parameter detachEvent: kotlin.Boolean\n```
//                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        // Clear the rect before calling getLocalVisibleRect
        localVisibleRect.setEmpty()
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
        val viewDrawn = view.getLocalVisibleRect(localVisibleRect) && !detachEvent
//          ^^^^^^^^^ definition local 1
//                    documentation ```kt\nval viewDrawn: kotlin.Boolean\n```
//                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
//                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().
//                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
//                                                                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(detachEvent)
        height = view.height
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#height.
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
        width = view.width
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#width.
//              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
        viewportHeight = parent.height
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewportHeight().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewportHeight().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewportHeight.
//                       ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(parent)
        viewportWidth = parent.width
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewportWidth().
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewportWidth().
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewportWidth.
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(parent)
        visibleHeight = if (viewDrawn) localVisibleRect.height() else 0
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                          ^^^^^^^^^ reference local 1
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
        visibleWidth = if (viewDrawn) localVisibleRect.width() else 0
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                         ^^^^^^^^^ reference local 1
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
        viewVisibility = view.visibility
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
        return height > 0 && width > 0
//             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#height.
//             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                    ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//                           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#width.
//                                 ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
    }

    fun reset(newAdapterPosition: Int) {
//      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#reset().
//            documentation ```kt\npublic final fun reset(newAdapterPosition: kotlin.Int)\n```
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#reset().(newAdapterPosition)
//                               documentation ```kt\nvalue-parameter newAdapterPosition: kotlin.Int\n```
//                                ^^^ reference semanticdb maven . . kotlin/Int#
        fullyVisible = false
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
        visible = false
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visible.
        focusedVisible = false
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
        adapterPosition = newAdapterPosition
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
//                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#reset().(newAdapterPosition)
        lastVisibleHeightNotified = null
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleHeightNotified().
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleHeightNotified.
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleHeightNotified().
        lastVisibleWidthNotified = null
//      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleWidthNotified().
//      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleWidthNotified.
//      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleWidthNotified().
        lastVisibilityNotified = null
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibilityNotified().
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibilityNotified.
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibilityNotified().
    }

    fun handleVisible(epoxyHolder: EpoxyViewHolder, detachEvent: Boolean) {
//      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().
//                    documentation ```kt\npublic final fun handleVisible(epoxyHolder: [ERROR : EpoxyViewHolder], detachEvent: kotlin.Boolean)\n```
//                    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(epoxyHolder)
//                                documentation ```kt\nvalue-parameter epoxyHolder: [ERROR : EpoxyViewHolder]\n```
//                                                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(detachEvent)
//                                                              documentation ```kt\nvalue-parameter detachEvent: kotlin.Boolean\n```
//                                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        val previousVisible = visible
//          ^^^^^^^^^^^^^^^ definition local 2
//                          documentation ```kt\nval previousVisible: kotlin.Boolean\n```
//                            ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//                            ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
//                            ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visible.
        visible = !detachEvent && isVisible()
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visible.
//                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                 ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(detachEvent)
//                                ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isVisible().
        if (visible != previousVisible) {
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visible.
//                  ^^ reference semanticdb maven . . kotlin/Boolean#equals().
//                     ^^^^^^^^^^^^^^^ reference local 2
            if (visible) {
//              ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//              ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
//              ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visible.
                epoxyHolder.visibilityStateChanged(VisibilityState.VISIBLE)
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(epoxyHolder)
            } else {
                epoxyHolder.visibilityStateChanged(VisibilityState.INVISIBLE)
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(epoxyHolder)
            }
        }
    }

    fun handleFocus(epoxyHolder: EpoxyViewHolder, detachEvent: Boolean) {
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().
//                  documentation ```kt\npublic final fun handleFocus(epoxyHolder: [ERROR : EpoxyViewHolder], detachEvent: kotlin.Boolean)\n```
//                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(epoxyHolder)
//                              documentation ```kt\nvalue-parameter epoxyHolder: [ERROR : EpoxyViewHolder]\n```
//                                                ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(detachEvent)
//                                                            documentation ```kt\nvalue-parameter detachEvent: kotlin.Boolean\n```
//                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        val previousFocusedVisible = focusedVisible
//          ^^^^^^^^^^^^^^^^^^^^^^ definition local 3
//                                 documentation ```kt\nval previousFocusedVisible: kotlin.Boolean\n```
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
        focusedVisible = !detachEvent && isInFocusVisible()
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
//                       ^ reference semanticdb maven . . kotlin/Boolean#not().
//                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(detachEvent)
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isInFocusVisible().
        if (focusedVisible != previousFocusedVisible) {
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
//                         ^^ reference semanticdb maven . . kotlin/Boolean#equals().
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference local 3
            if (focusedVisible) {
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
                epoxyHolder.visibilityStateChanged(VisibilityState.FOCUSED_VISIBLE)
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(epoxyHolder)
            } else {
                epoxyHolder.visibilityStateChanged(VisibilityState.UNFOCUSED_VISIBLE)
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(epoxyHolder)
            }
        }
    }

    fun handlePartialImpressionVisible(
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().
//                                     documentation ```kt\npublic final fun handlePartialImpressionVisible(epoxyHolder: [ERROR : EpoxyViewHolder], detachEvent: kotlin.Boolean, thresholdPercentage: kotlin.Int)\n```
        epoxyHolder: EpoxyViewHolder,
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(epoxyHolder)
//                  documentation ```kt\nvalue-parameter epoxyHolder: [ERROR : EpoxyViewHolder]\n```
        detachEvent: Boolean,
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(detachEvent)
//                  documentation ```kt\nvalue-parameter detachEvent: kotlin.Boolean\n```
//                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        @IntRange(from = 0, to = 100) thresholdPercentage: Int
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#`<init>`().
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#`<init>`().(from)
//                          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#`<init>`().(to)
//                                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(thresholdPercentage)
//                                                        documentation ```kt\nvalue-parameter thresholdPercentage: kotlin.Int\n```
//                                                         ^^^ reference semanticdb maven . . kotlin/Int#
    ) {
        val previousPartiallyVisible = partiallyVisible
//          ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 4
//                                   documentation ```kt\nval previousPartiallyVisible: kotlin.Boolean\n```
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
        partiallyVisible = !detachEvent && isPartiallyVisible(thresholdPercentage)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
//                         ^ reference semanticdb maven . . kotlin/Boolean#not().
//                          ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(detachEvent)
//                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().
//                                                            ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(thresholdPercentage)
        if (partiallyVisible != previousPartiallyVisible) {
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
//                           ^^ reference semanticdb maven . . kotlin/Boolean#equals().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 4
            if (partiallyVisible) {
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
                epoxyHolder.visibilityStateChanged(VisibilityState.PARTIAL_IMPRESSION_VISIBLE)
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(epoxyHolder)
            } else {
                epoxyHolder.visibilityStateChanged(VisibilityState.PARTIAL_IMPRESSION_INVISIBLE)
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(epoxyHolder)
            }
        }
    }

    fun handleFullImpressionVisible(epoxyHolder: EpoxyViewHolder, detachEvent: Boolean) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().
//                                  documentation ```kt\npublic final fun handleFullImpressionVisible(epoxyHolder: [ERROR : EpoxyViewHolder], detachEvent: kotlin.Boolean)\n```
//                                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().(epoxyHolder)
//                                              documentation ```kt\nvalue-parameter epoxyHolder: [ERROR : EpoxyViewHolder]\n```
//                                                                ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().(detachEvent)
//                                                                            documentation ```kt\nvalue-parameter detachEvent: kotlin.Boolean\n```
//                                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        val previousFullyVisible = fullyVisible
//          ^^^^^^^^^^^^^^^^^^^^ definition local 5
//                               documentation ```kt\nval previousFullyVisible: kotlin.Boolean\n```
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
        fullyVisible = !detachEvent && isFullyVisible()
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
//                     ^ reference semanticdb maven . . kotlin/Boolean#not().
//                      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().(detachEvent)
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isFullyVisible().
        if (fullyVisible != previousFullyVisible) {
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
//                       ^^ reference semanticdb maven . . kotlin/Boolean#equals().
//                          ^^^^^^^^^^^^^^^^^^^^ reference local 5
            if (fullyVisible) {
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
                epoxyHolder.visibilityStateChanged(VisibilityState.FULL_IMPRESSION_VISIBLE)
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().(epoxyHolder)
            }
        }
    }

    fun handleChanged(epoxyHolder: EpoxyViewHolder, visibilityChangedEnabled: Boolean): Boolean {
//      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().
//                    documentation ```kt\npublic final fun handleChanged(epoxyHolder: [ERROR : EpoxyViewHolder], visibilityChangedEnabled: kotlin.Boolean): kotlin.Boolean\n```
//                    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(epoxyHolder)
//                                documentation ```kt\nvalue-parameter epoxyHolder: [ERROR : EpoxyViewHolder]\n```
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(visibilityChangedEnabled)
//                                                                           documentation ```kt\nvalue-parameter visibilityChangedEnabled: kotlin.Boolean\n```
//                                                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        var changed = false
//          ^^^^^^^ definition local 6
//                  documentation ```kt\nvar changed: kotlin.Boolean\n```
        if (visibleHeight != lastVisibleHeightNotified || visibleWidth != lastVisibleWidthNotified || viewVisibility != lastVisibilityNotified) {
//          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                        ^^ reference semanticdb maven . . kotlin/Int#equals().
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleHeightNotified().
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleHeightNotified.
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleHeightNotified().
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                                                     ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleWidthNotified().
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleWidthNotified.
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleWidthNotified().
//                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//                                                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibilityNotified().
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibilityNotified.
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibilityNotified().
            if (visibilityChangedEnabled) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(visibilityChangedEnabled)
                if (viewVisibility == View.GONE) {
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
                    epoxyHolder.visibilityChanged(0f, 0f, 0, 0)
//                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(epoxyHolder)
                } else {
                    epoxyHolder.visibilityChanged(
//                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(epoxyHolder)
                        100f / height * visibleHeight,
//                           ^ reference semanticdb maven . . kotlin/Float#div(+3).
//                             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//                             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#height.
//                             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                                    ^ reference semanticdb maven . . kotlin/Float#times(+3).
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
                        100f / width * visibleWidth,
//                           ^ reference semanticdb maven . . kotlin/Float#div(+3).
//                             ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                             ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//                             ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#width.
//                                   ^ reference semanticdb maven . . kotlin/Float#times(+3).
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
                        visibleHeight, visibleWidth
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
                    )
                }
            }
            lastVisibleHeightNotified = visibleHeight
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleHeightNotified().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleHeightNotified.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleHeightNotified().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
            lastVisibleWidthNotified = visibleWidth
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleWidthNotified().
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleWidthNotified.
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleWidthNotified().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
            lastVisibilityNotified = viewVisibility
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibilityNotified().
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibilityNotified.
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibilityNotified().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
            changed = true
//          ^^^^^^^ reference local 6
        }
        return changed
//             ^^^^^^^ reference local 6
    }

    private fun isVisible(): Boolean {
//              ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isVisible().
//                        documentation ```kt\nprivate final fun isVisible(): kotlin.Boolean\n```
//                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        return viewVisibility == View.VISIBLE && visibleHeight > 0 && visibleWidth > 0
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                                                             ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                                                                 ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
    }

    private fun isInFocusVisible(): Boolean {
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isInFocusVisible().
//                               documentation ```kt\nprivate final fun isInFocusVisible(): kotlin.Boolean\n```
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        val halfViewportArea = viewportHeight * viewportWidth / 2
//          ^^^^^^^^^^^^^^^^ definition local 7
//                           documentation ```kt\nval halfViewportArea: kotlin.Int\n```
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewportHeight().
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewportHeight().
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewportHeight.
//                                            ^ reference semanticdb maven . . kotlin/Int#times(+3).
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewportWidth().
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewportWidth().
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewportWidth.
//                                                            ^ reference semanticdb maven . . kotlin/Int#div(+3).
        val totalArea = height * width
//          ^^^^^^^^^ definition local 8
//                    documentation ```kt\nval totalArea: kotlin.Int\n```
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#height.
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                             ^ reference semanticdb maven . . kotlin/Int#times(+3).
//                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#width.
        val visibleArea = visibleHeight * visibleWidth
//          ^^^^^^^^^^^ definition local 9
//                      documentation ```kt\nval visibleArea: kotlin.Int\n```
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                                      ^ reference semanticdb maven . . kotlin/Int#times(+3).
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
        // The model has entered the focused range either if it is larger than half of the viewport
        // and it occupies at least half of the viewport or if it is smaller than half of the viewport
        // and it is fully visible.
        return viewVisibility == View.VISIBLE &&
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
            if (totalArea >= halfViewportArea) visibleArea >= halfViewportArea else totalArea == visibleArea
//              ^^^^^^^^^ reference local 8
//                        ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                           ^^^^^^^^^^^^^^^^ reference local 7
//                                             ^^^^^^^^^^^ reference local 9
//                                                         ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                            ^^^^^^^^^^^^^^^^ reference local 7
//                                                                                  ^^^^^^^^^ reference local 8
//                                                                                            ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                                                               ^^^^^^^^^^^ reference local 9
    }

    private fun isPartiallyVisible(
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().
//                                 documentation ```kt\nprivate final fun isPartiallyVisible(thresholdPercentage: kotlin.Int): kotlin.Boolean\n```
        @IntRange(
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#`<init>`().
            from = 0,
//          ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#`<init>`().(from)
            to = 100
//          ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#`<init>`().(to)
        ) thresholdPercentage: Int
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().(thresholdPercentage)
//                            documentation ```kt\nvalue-parameter thresholdPercentage: kotlin.Int\n```
//                             ^^^ reference semanticdb maven . . kotlin/Int#
    ): Boolean {
//     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        // special case 0%: trigger as soon as some pixels are one the screen
        if (thresholdPercentage == 0) return isVisible()
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().(thresholdPercentage)
//                              ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isVisible().
        val totalArea = height * width
//          ^^^^^^^^^ definition local 10
//                    documentation ```kt\nval totalArea: kotlin.Int\n```
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#height.
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                             ^ reference semanticdb maven . . kotlin/Int#times(+3).
//                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#width.
        val visibleArea = visibleHeight * visibleWidth
//          ^^^^^^^^^^^ definition local 11
//                      documentation ```kt\nval visibleArea: kotlin.Int\n```
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                                      ^ reference semanticdb maven . . kotlin/Int#times(+3).
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
        val visibleAreaPercentage = visibleArea / totalArea.toFloat() * 100
//          ^^^^^^^^^^^^^^^^^^^^^ definition local 12
//                                documentation ```kt\nval visibleAreaPercentage: kotlin.Float\n```
//                                  ^^^^^^^^^^^ reference local 11
//                                              ^ reference semanticdb maven . . kotlin/Int#div(+2).
//                                                ^^^^^^^^^ reference local 10
//                                                          ^^^^^^^ reference semanticdb maven . . kotlin/Int#toFloat().
//                                                                    ^ reference semanticdb maven . . kotlin/Float#times(+3).
        return viewVisibility == View.VISIBLE && visibleAreaPercentage >= thresholdPercentage
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//                                               ^^^^^^^^^^^^^^^^^^^^^ reference local 12
//                                                                     ^^ reference semanticdb maven . . kotlin/Float#compareTo(+3).
//                                                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().(thresholdPercentage)
    }

    private fun isFullyVisible(): Boolean {
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#isFullyVisible().
//                             documentation ```kt\nprivate final fun isFullyVisible(): kotlin.Boolean\n```
//                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        return viewVisibility == View.VISIBLE && visibleHeight == height && visibleWidth == width
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                                                             ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                                ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//                                                                ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#height.
//                                                                ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                                                                       ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                                                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                                                                                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//                                                                                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#width.
    }

    fun shiftBy(offsetPosition: Int) {
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//              documentation ```kt\npublic final fun shiftBy(offsetPosition: kotlin.Int)\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().(offsetPosition)
//                             documentation ```kt\nvalue-parameter offsetPosition: kotlin.Int\n```
//                              ^^^ reference semanticdb maven . . kotlin/Int#
        adapterPosition += offsetPosition
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
    }
}
