package com.airbnb.epoxy;

import android.content.Context;
//     ^^^^^^^ reference android/
//             ^^^^^^^ reference android/content/
//                     ^^^^^^^ reference android/content/Context#
import android.util.AttributeSet;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/util/
//                  ^^^^^^^^^^^^ reference android/util/AttributeSet#
import android.util.DisplayMetrics;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/util/
//                  ^^^^^^^^^^^^^^ reference android/util/DisplayMetrics#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#
import android.view.ViewGroup;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^^^^^^ reference android/view/ViewGroup#

import com.airbnb.epoxy.ModelView.Size;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^ reference com/airbnb/epoxy/ModelView#
//                                ^^^^ reference com/airbnb/epoxy/ModelView#Size#
import com.airbnb.viewmodeladapter.R;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^^^^^^^^^^^^ reference com/airbnb/viewmodeladapter/
//                                 ^ reference com/airbnb/viewmodeladapter/R#

import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.annotation.DimenRes;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/DimenRes#
import androidx.annotation.Dimension;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/Dimension#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.annotation.Px;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^ reference androidx/annotation/Px#
import androidx.recyclerview.widget.LinearLayoutManager;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/LinearLayoutManager#
import androidx.recyclerview.widget.LinearSnapHelper;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/LinearSnapHelper#
import androidx.recyclerview.widget.SnapHelper;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^ reference androidx/recyclerview/widget/SnapHelper#

/**
 * <i>This feature is in Beta - please report bugs, feature requests, or other feedback at
 * https://github.com/airbnb/epoxy by creating a new issue. Thanks!</i>
 *
 * <p>This is intended as a plug and play "Carousel" view - a Recyclerview with horizontal
 * scrolling. It comes with common defaults and performance optimizations and can be either used as
 * a top level RecyclerView, or nested within a vertical recyclerview.
 *
 * <p>This class provides:
 *
 * <p>1. Automatic integration with Epoxy. A {@link CarouselModel_} is generated from this class,
 * which you can use in your EpoxyController. Just call {@link #setModels(List)} to provide the list
 * of models to show in the carousel.
 *
 * <p>2. Default padding for carousel peeking, and an easy way to change this padding - {@link
 * #setPaddingDp(int)}
 *
 * <p>3. Easily control how many items are shown on screen in the carousel at a time - {@link
 * #setNumViewsToShowOnScreen(float)}
 *
 * <p>4. Easy snap support. By default a {@link LinearSnapHelper} is used, but you can set a global
 * default for all Carousels with {@link #setDefaultGlobalSnapHelperFactory(SnapHelperFactory)}
 *
 * <p>5. All of the benefits of {@link EpoxyRecyclerView}
 *
 * <p>If you need further flexibility you can subclass this view to change its width, height,
 * scrolling direction, etc. You can annotate a subclass with {@link ModelView} to generate a new
 * EpoxyModel.
 */
@ModelView(saveViewState = true, autoLayout = Size.MATCH_WIDTH_WRAP_HEIGHT)
//^^^^^^^^ reference com/airbnb/epoxy/ModelView#
//         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelView#saveViewState().
//                               ^^^^^^^^^^ reference com/airbnb/epoxy/ModelView#autoLayout().
//                                            ^^^^ reference com/airbnb/epoxy/ModelView#Size#
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelView#Size#MATCH_WIDTH_WRAP_HEIGHT.
public class Carousel extends EpoxyRecyclerView {
//           ^^^^^^^^ definition com/airbnb/epoxy/Carousel# public class Carousel extends unresolved_type
//                            ^^^^^^^^^^^^^^^^^ reference _root_/
  public static final int NO_VALUE_SET = -1;
//                        ^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#NO_VALUE_SET. public static final int NO_VALUE_SET

  private static SnapHelperFactory defaultGlobalSnapHelperFactory =
//               ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#defaultGlobalSnapHelperFactory. private static SnapHelperFactory defaultGlobalSnapHelperFactory
      new SnapHelperFactory() {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local1 7:7
//        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#SnapHelperFactory#
//        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#SnapHelperFactory#

        @Override
//       ^^^^^^^^ reference java/lang/Override#
        @NonNull
//       ^^^^^^^ reference androidx/annotation/NonNull#
        public SnapHelper buildSnapHelper(Context context) {
//             ^^^^^^^^^^ reference _root_/
//                        ^^^^^^^^^^^^^^^ definition local2 public buildSnapHelper(unresolved_type context)
//                                        ^^^^^^^ reference _root_/
//                                                ^^^^^^^ definition local3 unresolved_type context
          return new LinearSnapHelper();
//               ^^^^^^^^^^^^^^^^^^^^^^ reference `<init>`#
//                   ^^^^^^^^^^^^^^^^ reference _root_/
        }
      };

  @Dimension(unit = Dimension.DP)
// ^^^^^^^^^ reference androidx/annotation/Dimension#
//           ^^^^ reference androidx/annotation/Dimension#unit().
//                  ^^^^^^^^^ reference androidx/annotation/Dimension#
//                            ^^ reference androidx/annotation/Dimension#DP.
  private static int defaultSpacingBetweenItemsDp = 8;
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#defaultSpacingBetweenItemsDp. private static int defaultSpacingBetweenItemsDp

  private float numViewsToShowOnScreen;
//              ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#numViewsToShowOnScreen. private float numViewsToShowOnScreen

  public Carousel(Context context) {
//       ^^^^^^ definition com/airbnb/epoxy/Carousel#`<init>`(). public void <init>(unresolved_type context)
//                ^^^^^^^ reference _root_/
//                        ^^^^^^^ definition local4 unresolved_type context
    super(context);
//        ^^^^^^^ reference local4
  }

  public Carousel(Context context, @Nullable AttributeSet attrs) {
//       ^^^^^^ definition com/airbnb/epoxy/Carousel#`<init>`(+1). public void <init>(unresolved_type context, unresolved_type attrs)
//                ^^^^^^^ reference _root_/
//                        ^^^^^^^ definition local5 unresolved_type context
//                                  ^^^^^^^^ reference androidx/annotation/Nullable#
//                                           ^^^^^^^^^^^^ reference _root_/
//                                                        ^^^^^ definition local6 unresolved_type attrs
    super(context, attrs);
//        ^^^^^^^ reference local5
//                 ^^^^^ reference local6
  }

  public Carousel(Context context, @Nullable AttributeSet attrs, int defStyle) {
//       ^^^^^^ definition com/airbnb/epoxy/Carousel#`<init>`(+2). public void <init>(unresolved_type context, unresolved_type attrs, int defStyle)
//                ^^^^^^^ reference _root_/
//                        ^^^^^^^ definition local7 unresolved_type context
//                                  ^^^^^^^^ reference androidx/annotation/Nullable#
//                                           ^^^^^^^^^^^^ reference _root_/
//                                                        ^^^^^ definition local8 unresolved_type attrs
//                                                                   ^^^^^^^^ definition local9 int defStyle
    super(context, attrs, defStyle);
//        ^^^^^^^ reference local7
//                 ^^^^^ reference local8
//                        ^^^^^^^^ reference local9
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected void init() {
//               ^^^^ definition com/airbnb/epoxy/Carousel#init(). protected void init()
    super.init();
//  ^^^^^ reference _root_/
//        ^^^^ reference init#
    // When used as a model the padding can't be set via xml so we set it programmatically
    int defaultSpacingDp = getDefaultSpacingBetweenItemsDp();
//      ^^^^^^^^^^^^^^^^ definition local10 int defaultSpacingDp
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getDefaultSpacingBetweenItemsDp().

    if (defaultSpacingDp >= 0) {
//      ^^^^^^^^^^^^^^^^ reference local10
      setItemSpacingDp(defaultSpacingDp);
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setItemSpacingDp#
//                     ^^^^^^^^^^^^^^^^ reference local10

      if (getPaddingLeft() == 0
//        ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getPaddingLeft#
          && getPaddingRight() == 0
//           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getPaddingRight#
          && getPaddingTop() == 0
//           ^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getPaddingTop#
          && getPaddingBottom() == 0) {
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getPaddingBottom#
        // Use the item spacing as the default padding if no other padding has been set
        setPaddingDp(defaultSpacingDp);
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setPaddingDp().
//                   ^^^^^^^^^^^^^^^^ reference local10
      }
    }

    SnapHelperFactory snapHelperFactory = getSnapHelperFactory();
//  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                    ^^^^^^^^^^^^^^^^^ definition local11 SnapHelperFactory snapHelperFactory
//                                        ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getSnapHelperFactory().
    if (snapHelperFactory != null) {
//      ^^^^^^^^^^^^^^^^^ reference local11
      snapHelperFactory.buildSnapHelper(getContext()).attachToRecyclerView(this);
//    ^^^^^^^^^^^^^^^^^ reference local11
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#SnapHelperFactory#buildSnapHelper().
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getContext#
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference `<any>`#attachToRecyclerView#
//                                                                         ^^^^ reference com/airbnb/epoxy/Carousel#
    }

    // Carousels will be detached when their parent recyclerview is
    setRemoveAdapterWhenDetachedFromWindow(false);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setRemoveAdapterWhenDetachedFromWindow#
  }

  /**
   * Return a {@link SnapHelperFactory} instance to use with this Carousel. The {@link SnapHelper}
   * created by the factory will be attached to this Carousel on view creation. Return null for no
   * snap helper to be attached automatically.
   */
  @Nullable
// ^^^^^^^^ reference androidx/annotation/Nullable#
  protected SnapHelperFactory getSnapHelperFactory() {
//          ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                            ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#getSnapHelperFactory(). protected SnapHelperFactory getSnapHelperFactory()
    return defaultGlobalSnapHelperFactory;
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#defaultGlobalSnapHelperFactory.
  }

  /**
   * Set a {@link SnapHelperFactory} instance to use with all Carousels by default. The {@link
   * SnapHelper} created by the factory will be attached to each Carousel on view creation. Set null
   * for no snap helper to be attached automatically.
   *
   * <p>A Carousel subclass can implement {@link #getSnapHelperFactory()} to override the global
   * default.
   */
  public static void setDefaultGlobalSnapHelperFactory(@Nullable SnapHelperFactory factory) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#setDefaultGlobalSnapHelperFactory(). public static void setDefaultGlobalSnapHelperFactory(SnapHelperFactory factory)
//                                                      ^^^^^^^^ reference androidx/annotation/Nullable#
//                                                               ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                                                                                 ^^^^^^^ definition local12 SnapHelperFactory factory
    defaultGlobalSnapHelperFactory = factory;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#defaultGlobalSnapHelperFactory.
//                                   ^^^^^^^ reference local12
  }

  @ModelProp
// ^^^^^^^^^ reference com/airbnb/epoxy/ModelProp#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void setHasFixedSize(boolean hasFixedSize) {
//            ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#setHasFixedSize(). public void setHasFixedSize(boolean hasFixedSize)
//                                    ^^^^^^^^^^^^ definition local13 boolean hasFixedSize
    super.setHasFixedSize(hasFixedSize);
//  ^^^^^ reference _root_/
//        ^^^^^^^^^^^^^^^ reference setHasFixedSize#
//                        ^^^^^^^^^^^^ reference local13
  }

  /**
   * Set the number of views to show on screen in this carousel at a time, partial numbers are
   * allowed.
   *
   * <p>This is useful where you want to easily control for the number of items on screen,
   * regardless of screen size. For example, you could set this to 1.2f so that one view is shown in
   * full and 20% of the next view "peeks" from the edge to indicate that there is more content to
   * scroll to.
   *
   * <p>Another pattern is setting a different view count depending on whether the device is phone
   * or tablet.
   *
   * <p>Additionally, if a LinearLayoutManager is used this value will be forwarded to {@link
   * LinearLayoutManager#setInitialPrefetchItemCount(int)} as a performance optimization.
   *
   * <p>If you want to only change the prefetch count without changing the view size you can simply
   * use {@link #setInitialPrefetchItemCount(int)}
   */
  @ModelProp(group = "prefetch")
// ^^^^^^^^^ reference com/airbnb/epoxy/ModelProp#
//           ^^^^^ reference com/airbnb/epoxy/ModelProp#group().
  public void setNumViewsToShowOnScreen(float viewCount) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#setNumViewsToShowOnScreen(). public void setNumViewsToShowOnScreen(float viewCount)
//                                            ^^^^^^^^^ definition local14 float viewCount
    numViewsToShowOnScreen = viewCount;
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
//                           ^^^^^^^^^ reference local14
    setInitialPrefetchItemCount((int) Math.ceil(viewCount));
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setInitialPrefetchItemCount().
//                                    ^^^^ reference java/lang/Math#
//                                         ^^^^ reference java/lang/Math#ceil().
//                                              ^^^^^^^^^ reference local14
  }

  /**
   * @return The number of views to show on screen in this carousel at a time.
   */
  public float getNumViewsToShowOnScreen() {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#getNumViewsToShowOnScreen(). public float getNumViewsToShowOnScreen()
      return numViewsToShowOnScreen;
//           ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
  }

  /**
   * If you are using a Linear or Grid layout manager you can use this to set the item prefetch
   * count. Only use this if you are not using {@link #setNumViewsToShowOnScreen(float)}
   *
   * @see #setNumViewsToShowOnScreen(float)
   * @see LinearLayoutManager#setInitialPrefetchItemCount(int)
   */
  @ModelProp(group = "prefetch")
// ^^^^^^^^^ reference com/airbnb/epoxy/ModelProp#
//           ^^^^^ reference com/airbnb/epoxy/ModelProp#group().
  public void setInitialPrefetchItemCount(int numItemsToPrefetch) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#setInitialPrefetchItemCount(). public void setInitialPrefetchItemCount(int numItemsToPrefetch)
//                                            ^^^^^^^^^^^^^^^^^^ definition local15 int numItemsToPrefetch
    if (numItemsToPrefetch < 0) {
//      ^^^^^^^^^^^^^^^^^^ reference local15
      throw new IllegalStateException("numItemsToPrefetch must be greater than 0");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    // Use the linearlayoutmanager default of 2 if the user did not specify one
    int prefetchCount = numItemsToPrefetch == 0 ? 2 : numItemsToPrefetch;
//      ^^^^^^^^^^^^^ definition local16 int prefetchCount
//                      ^^^^^^^^^^^^^^^^^^ reference local15
//                                                    ^^^^^^^^^^^^^^^^^^ reference local15

    LayoutManager layoutManager = getLayoutManager();
//  ^^^^^^^^^^^^^ reference _root_/
//                ^^^^^^^^^^^^^ definition local17 unresolved_type layoutManager
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getLayoutManager#
    if (layoutManager instanceof LinearLayoutManager) {
//      ^^^^^^^^^^^^^ reference local17
//                               ^^^^^^^^^^^^^^^^^^^ reference _root_/
      ((LinearLayoutManager) layoutManager).setInitialPrefetchItemCount(prefetchCount);
//      ^^^^^^^^^^^^^^^^^^^ reference _root_/
//                           ^^^^^^^^^^^^^ reference local17
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference setInitialPrefetchItemCount#
//                                                                      ^^^^^^^^^^^^^ reference local16
    }
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onChildAttachedToWindow(View child) {
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#onChildAttachedToWindow(). public void onChildAttachedToWindow(unresolved_type child)
//                                    ^^^^ reference _root_/
//                                         ^^^^^ definition local18 unresolved_type child
    if (numViewsToShowOnScreen > 0) {
//      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
      ViewGroup.LayoutParams childLayoutParams = child.getLayoutParams();
//    ^^^^^^^^^ reference ViewGroup/
//              ^^^^^^^^^^^^ reference ViewGroup/LayoutParams#
//                           ^^^^^^^^^^^^^^^^^ definition local19 unresolved_type childLayoutParams
//                                               ^^^^^ reference local18
//                                                     ^^^^^^^^^^^^^^^ reference getLayoutParams#
      child.setTag(R.id.epoxy_recycler_view_child_initial_size_id, childLayoutParams.width);
//    ^^^^^ reference local18
//          ^^^^^^ reference setTag#
//                 ^ reference R/
//                   ^^ reference R/id#
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference R/id#epoxy_recycler_view_child_initial_size_id#
//                                                                 ^^^^^^^^^^^^^^^^^ reference local19
//                                                                                   ^^^^^ reference ViewGroup/LayoutParams#width#

      int itemSpacingPx = getSpacingDecorator().getPxBetweenItems();
//        ^^^^^^^^^^^^^ definition local20 int itemSpacingPx
//                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getSpacingDecorator#
//                                              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getSpacingDecorator#getPxBetweenItems#
      int spaceBetweenItems = 0;
//        ^^^^^^^^^^^^^^^^^ definition local21 int spaceBetweenItems
      if (itemSpacingPx > 0) {
//        ^^^^^^^^^^^^^ reference local20
        // The item decoration space is not counted in the width of the view
        spaceBetweenItems = (int) (itemSpacingPx * numViewsToShowOnScreen);
//      ^^^^^^^^^^^^^^^^^ reference local21
//                                 ^^^^^^^^^^^^^ reference local20
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
      }

      boolean isScrollingHorizontally = getLayoutManager().canScrollHorizontally();
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition local22 boolean isScrollingHorizontally
//                                      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getLayoutManager#
//                                                         ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getLayoutManager#canScrollHorizontally#
      int itemSizeInScrollingDirection =
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local23 int itemSizeInScrollingDirection
          (int)
              ((getSpaceForChildren(isScrollingHorizontally) - spaceBetweenItems)
//              ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getSpaceForChildren().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^ reference local22
//                                                             ^^^^^^^^^^^^^^^^^ reference local21
                  / numViewsToShowOnScreen);
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.

      if (isScrollingHorizontally) {
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference local22
        childLayoutParams.width = itemSizeInScrollingDirection;
//      ^^^^^^^^^^^^^^^^^ reference local19
//                        ^^^^^ reference ViewGroup/LayoutParams#width#
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local23
      } else {
        childLayoutParams.height = itemSizeInScrollingDirection;
//      ^^^^^^^^^^^^^^^^^ reference local19
//                        ^^^^^^ reference ViewGroup/LayoutParams#height#
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local23
      }

      // We don't need to request layout because the layout manager will do that for us next
    }
  }

  private int getSpaceForChildren(boolean horizontal) {
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#getSpaceForChildren(). private int getSpaceForChildren(boolean horizontal)
//                                        ^^^^^^^^^^ definition local24 boolean horizontal
    if (horizontal) {
//      ^^^^^^^^^^ reference local24
      return getTotalWidthPx(this)
//           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getTotalWidthPx().
//                           ^^^^ reference com/airbnb/epoxy/Carousel#
          - getPaddingLeft()
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getPaddingLeft#
          - (getClipToPadding() ? getPaddingRight() : 0);
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getClipToPadding#
//                                ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getPaddingRight#
      // If child views will be showing through padding than we include just one side of padding
      // since when the list is at position 0 only the child towards the end of the list will show
      // through the padding.
    } else {
      return getTotalHeightPx(this)
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getTotalHeightPx().
//                            ^^^^ reference com/airbnb/epoxy/Carousel#
          - getPaddingTop()
//          ^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getPaddingTop#
          - (getClipToPadding() ? getPaddingBottom() : 0);
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getClipToPadding#
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getPaddingBottom#
    }
  }

  @Px
// ^^ reference androidx/annotation/Px#
  private static int getTotalWidthPx(View view) {
//                   ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#getTotalWidthPx(). private static int getTotalWidthPx(unresolved_type view)
//                                   ^^^^ reference _root_/
//                                        ^^^^ definition local25 unresolved_type view
    if (view.getWidth() > 0) {
//      ^^^^ reference local25
//           ^^^^^^^^ reference getWidth#
      // Can only get a width if we are laid out
      return view.getWidth();
//           ^^^^ reference local25
//                ^^^^^^^^ reference getWidth#
    }

    if (view.getMeasuredWidth() > 0) {
//      ^^^^ reference local25
//           ^^^^^^^^^^^^^^^^ reference getMeasuredWidth#
      return view.getMeasuredWidth();
//           ^^^^ reference local25
//                ^^^^^^^^^^^^^^^^ reference getMeasuredWidth#
    }

    // Fall back to assuming we want the full screen width
    DisplayMetrics metrics = view.getContext().getResources().getDisplayMetrics();
//  ^^^^^^^^^^^^^^ reference _root_/
//                 ^^^^^^^ definition local26 unresolved_type metrics
//                           ^^^^ reference local25
//                                ^^^^^^^^^^ reference getContext#
//                                             ^^^^^^^^^^^^ reference getContext#getResources#
//                                                            ^^^^^^^^^^^^^^^^^ reference getContext#getResources#getDisplayMetrics#
    return metrics.widthPixels;
//         ^^^^^^^ reference local26
//                 ^^^^^^^^^^^ reference widthPixels#
  }

  @Px
// ^^ reference androidx/annotation/Px#
  private static int getTotalHeightPx(View view) {
//                   ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#getTotalHeightPx(). private static int getTotalHeightPx(unresolved_type view)
//                                    ^^^^ reference _root_/
//                                         ^^^^ definition local27 unresolved_type view
    if (view.getHeight() > 0) {
//      ^^^^ reference local27
//           ^^^^^^^^^ reference getHeight#
      return view.getHeight();
//           ^^^^ reference local27
//                ^^^^^^^^^ reference getHeight#
    }

    if (view.getMeasuredHeight() > 0) {
//      ^^^^ reference local27
//           ^^^^^^^^^^^^^^^^^ reference getMeasuredHeight#
      return view.getMeasuredHeight();
//           ^^^^ reference local27
//                ^^^^^^^^^^^^^^^^^ reference getMeasuredHeight#
    }

    // Fall back to assuming we want the full screen width
    DisplayMetrics metrics = view.getContext().getResources().getDisplayMetrics();
//  ^^^^^^^^^^^^^^ reference _root_/
//                 ^^^^^^^ definition local28 unresolved_type metrics
//                           ^^^^ reference local27
//                                ^^^^^^^^^^ reference getContext#
//                                             ^^^^^^^^^^^^ reference getContext#getResources#
//                                                            ^^^^^^^^^^^^^^^^^ reference getContext#getResources#getDisplayMetrics#
    return metrics.heightPixels;
//         ^^^^^^^ reference local28
//                 ^^^^^^^^^^^^ reference heightPixels#
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onChildDetachedFromWindow(View child) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#onChildDetachedFromWindow(). public void onChildDetachedFromWindow(unresolved_type child)
//                                      ^^^^ reference _root_/
//                                           ^^^^^ definition local29 unresolved_type child
    // Restore the view width that existed before we modified it
    Object initialWidth = child.getTag(R.id.epoxy_recycler_view_child_initial_size_id);
//  ^^^^^^ reference java/lang/Object#
//         ^^^^^^^^^^^^ definition local30 Object initialWidth
//                        ^^^^^ reference local29
//                              ^^^^^^ reference getTag#
//                                     ^ reference R/
//                                       ^^ reference R/id#
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference R/id#epoxy_recycler_view_child_initial_size_id#

    if (initialWidth instanceof Integer) {
//      ^^^^^^^^^^^^ reference local30
//                              ^^^^^^^ reference java/lang/Integer#
      ViewGroup.LayoutParams params = child.getLayoutParams();
//    ^^^^^^^^^ reference ViewGroup/
//              ^^^^^^^^^^^^ reference ViewGroup/LayoutParams#
//                           ^^^^^^ definition local31 unresolved_type params
//                                    ^^^^^ reference local29
//                                          ^^^^^^^^^^^^^^^ reference getLayoutParams#
      params.width = (int) initialWidth;
//    ^^^^^^ reference local31
//           ^^^^^ reference ViewGroup/LayoutParams#width#
//                         ^^^^^^^^^^^^ reference local30
      child.setTag(R.id.epoxy_recycler_view_child_initial_size_id, null);
//    ^^^^^ reference local29
//          ^^^^^^ reference setTag#
//                 ^ reference R/
//                   ^^ reference R/id#
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference R/id#epoxy_recycler_view_child_initial_size_id#
      // No need to request layout since the view is unbound and not attached to window
    }
  }

  /**
   * Set a global default to use as the item spacing for all Carousels. Set to 0 for no item
   * spacing.
   */
  public static void setDefaultItemSpacingDp(@Dimension(unit = Dimension.DP) int dp) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#setDefaultItemSpacingDp(). public static void setDefaultItemSpacingDp(int dp)
//                                            ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                                      ^^^^ reference androidx/annotation/Dimension#unit().
//                                                             ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                                                       ^^ reference androidx/annotation/Dimension#DP.
//                                                                               ^^ definition local32 int dp
    defaultSpacingBetweenItemsDp = dp;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#defaultSpacingBetweenItemsDp.
//                                 ^^ reference local32
  }

  /**
   * Return the item spacing to use in this carousel, or 0 for no spacing.
   *
   * <p>By default this uses the global default set in {@link #setDefaultItemSpacingDp(int)}, but
   * subclasses can override this to specify their own value.
   */
  @Dimension(unit = Dimension.DP)
// ^^^^^^^^^ reference androidx/annotation/Dimension#
//           ^^^^ reference androidx/annotation/Dimension#unit().
//                  ^^^^^^^^^ reference androidx/annotation/Dimension#
//                            ^^ reference androidx/annotation/Dimension#DP.
  protected int getDefaultSpacingBetweenItemsDp() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#getDefaultSpacingBetweenItemsDp(). protected int getDefaultSpacingBetweenItemsDp()
    return defaultSpacingBetweenItemsDp;
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#defaultSpacingBetweenItemsDp.
  }

  /**
   * Set a dimension resource to specify the padding value to use on each side of the carousel and
   * in between carousel items.
   */
  @ModelProp(group = "padding")
// ^^^^^^^^^ reference com/airbnb/epoxy/ModelProp#
//           ^^^^^ reference com/airbnb/epoxy/ModelProp#group().
  public void setPaddingRes(@DimenRes int paddingRes) {
//            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#setPaddingRes(). public void setPaddingRes(int paddingRes)
//                           ^^^^^^^^ reference androidx/annotation/DimenRes#
//                                        ^^^^^^^^^^ definition local33 int paddingRes
    int px = resToPx(paddingRes);
//      ^^ definition local34 int px
//           ^^^^^^^ reference com/airbnb/epoxy/Carousel#resToPx#
//                   ^^^^^^^^^^ reference local33
    setPadding(px, px, px, px);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setPadding#
//             ^^ reference local34
//                 ^^ reference local34
//                     ^^ reference local34
//                         ^^ reference local34
    setItemSpacingPx(px);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                   ^^ reference local34
  }

  /**
   * Set a DP value to use as the padding on each side of the carousel and in between carousel
   * items.
   *
   * <p>The default as the value returned by {@link #getDefaultSpacingBetweenItemsDp()}
   */
  @ModelProp(defaultValue = "NO_VALUE_SET", group = "padding")
// ^^^^^^^^^ reference com/airbnb/epoxy/ModelProp#
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelProp#defaultValue().
//                                          ^^^^^ reference com/airbnb/epoxy/ModelProp#group().
  public void setPaddingDp(@Dimension(unit = Dimension.DP) int paddingDp) {
//            ^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#setPaddingDp(). public void setPaddingDp(int paddingDp)
//                          ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                    ^^^^ reference androidx/annotation/Dimension#unit().
//                                           ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                                     ^^ reference androidx/annotation/Dimension#DP.
//                                                             ^^^^^^^^^ definition local35 int paddingDp
    int px = dpToPx(paddingDp != NO_VALUE_SET ? paddingDp : getDefaultSpacingBetweenItemsDp());
//      ^^ definition local36 int px
//           ^^^^^^ reference com/airbnb/epoxy/Carousel#dpToPx#
//                  ^^^^^^^^^ reference local35
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#NO_VALUE_SET.
//                                              ^^^^^^^^^ reference local35
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#getDefaultSpacingBetweenItemsDp().
    setPadding(px, px, px, px);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setPadding#
//             ^^ reference local36
//                 ^^ reference local36
//                     ^^ reference local36
//                         ^^ reference local36
    setItemSpacingPx(px);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                   ^^ reference local36
  }

  /**
   * Use the {@link Padding} class to specify individual padding values for each side of the
   * carousel, as well as item spacing.
   *
   * <p>A value of null will set all padding and item spacing to 0.
   */
  @ModelProp(group = "padding")
// ^^^^^^^^^ reference com/airbnb/epoxy/ModelProp#
//           ^^^^^ reference com/airbnb/epoxy/ModelProp#group().
  public void setPadding(@Nullable Padding padding) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#setPadding(). public void setPadding(Padding padding)
//                        ^^^^^^^^ reference androidx/annotation/Nullable#
//                                 ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                                         ^^^^^^^ definition local37 Padding padding
    if (padding == null) {
//      ^^^^^^^ reference local37
      setPaddingDp(0);
//    ^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setPaddingDp().
    } else if (padding.paddingType == Padding.PaddingType.PX) {
//             ^^^^^^^ reference local37
//                     ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                    ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                                            ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                        ^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#PX.
      setPadding(padding.left, padding.top, padding.right, padding.bottom);
//    ^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setPadding#
//               ^^^^^^^ reference local37
//                       ^^^^ reference com/airbnb/epoxy/Carousel#Padding#left.
//                             ^^^^^^^ reference local37
//                                     ^^^ reference com/airbnb/epoxy/Carousel#Padding#top.
//                                          ^^^^^^^ reference local37
//                                                  ^^^^^ reference com/airbnb/epoxy/Carousel#Padding#right.
//                                                         ^^^^^^^ reference local37
//                                                                 ^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#bottom.
      setItemSpacingPx(padding.itemSpacing);
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                     ^^^^^^^ reference local37
//                             ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    } else if (padding.paddingType == Padding.PaddingType.DP) {
//             ^^^^^^^ reference local37
//                     ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                    ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                                            ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                        ^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#DP.
      setPadding(
//    ^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setPadding#
          dpToPx(padding.left), dpToPx(padding.top), dpToPx(padding.right), dpToPx(padding.bottom));
//        ^^^^^^ reference com/airbnb/epoxy/Carousel#dpToPx#
//               ^^^^^^^ reference local37
//                       ^^^^ reference com/airbnb/epoxy/Carousel#Padding#left.
//                              ^^^^^^ reference com/airbnb/epoxy/Carousel#dpToPx#
//                                     ^^^^^^^ reference local37
//                                             ^^^ reference com/airbnb/epoxy/Carousel#Padding#top.
//                                                   ^^^^^^ reference com/airbnb/epoxy/Carousel#dpToPx#
//                                                          ^^^^^^^ reference local37
//                                                                  ^^^^^ reference com/airbnb/epoxy/Carousel#Padding#right.
//                                                                          ^^^^^^ reference com/airbnb/epoxy/Carousel#dpToPx#
//                                                                                 ^^^^^^^ reference local37
//                                                                                         ^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#bottom.
      setItemSpacingPx(dpToPx(padding.itemSpacing));
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                     ^^^^^^ reference com/airbnb/epoxy/Carousel#dpToPx#
//                            ^^^^^^^ reference local37
//                                    ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    } else if (padding.paddingType == Padding.PaddingType.RESOURCE) {
//             ^^^^^^^ reference local37
//                     ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                    ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                                            ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                        ^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE.
      setPadding(
//    ^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setPadding#
          resToPx(padding.left),
//        ^^^^^^^ reference com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local37
//                        ^^^^ reference com/airbnb/epoxy/Carousel#Padding#left.
          resToPx(padding.top),
//        ^^^^^^^ reference com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local37
//                        ^^^ reference com/airbnb/epoxy/Carousel#Padding#top.
          resToPx(padding.right),
//        ^^^^^^^ reference com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local37
//                        ^^^^^ reference com/airbnb/epoxy/Carousel#Padding#right.
          resToPx(padding.bottom));
//        ^^^^^^^ reference com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local37
//                        ^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#bottom.
      setItemSpacingPx(resToPx(padding.itemSpacing));
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                     ^^^^^^^ reference com/airbnb/epoxy/Carousel#resToPx#
//                             ^^^^^^^ reference local37
//                                     ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    }
  }

  /**
   * Used to specify individual padding values programmatically.
   *
   * @see #setPadding(Padding)
   */
  public static class Padding {
//                    ^^^^^^^ definition com/airbnb/epoxy/Carousel#Padding# public static class Padding
    public final int left;
//                   ^^^^ definition com/airbnb/epoxy/Carousel#Padding#left. public final int left
    public final int top;
//                   ^^^ definition com/airbnb/epoxy/Carousel#Padding#top. public final int top
    public final int right;
//                   ^^^^^ definition com/airbnb/epoxy/Carousel#Padding#right. public final int right
    public final int bottom;
//                   ^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#bottom. public final int bottom
    public final int itemSpacing;
//                   ^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#itemSpacing. public final int itemSpacing
    public final PaddingType paddingType;
//               ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                           ^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#paddingType. public final PaddingType paddingType

    enum PaddingType {
//       ^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#PaddingType# enum PaddingType
//       ^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#PaddingType#`<init>`(). private void <init>()
      PX,
//    ^^ definition com/airbnb/epoxy/Carousel#Padding#PaddingType#PX. PaddingType.PX /* ordinal 0 */
      DP,
//    ^^ definition com/airbnb/epoxy/Carousel#Padding#PaddingType#DP. PaddingType.DP /* ordinal 1 */
      RESOURCE
//    ^^^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE. PaddingType.RESOURCE /* ordinal 2 */
    }

    /**
     * @param paddingRes Padding as dimension resource.
     * @param itemSpacingRes Space as dimension resource to add between each carousel item. Will be
     *     implemented via an item decoration.
     */
    public static Padding resource(@DimenRes int paddingRes, @DimenRes int itemSpacingRes) {
//                ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                        ^^^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#resource(). public static Padding resource(int paddingRes, int itemSpacingRes)
//                                  ^^^^^^^^ reference androidx/annotation/DimenRes#
//                                               ^^^^^^^^^^ definition local38 int paddingRes
//                                                            ^^^^^^^^ reference androidx/annotation/DimenRes#
//                                                                         ^^^^^^^^^^^^^^ definition local39 int itemSpacingRes
      return new Padding(
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#`<init>`(+2). 1:95
//               ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
          paddingRes, paddingRes, paddingRes, paddingRes, itemSpacingRes, PaddingType.RESOURCE);
//        ^^^^^^^^^^ reference local38
//                    ^^^^^^^^^^ reference local38
//                                ^^^^^^^^^^ reference local38
//                                            ^^^^^^^^^^ reference local38
//                                                        ^^^^^^^^^^^^^^ reference local39
//                                                                        ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                                    ^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE.
    }

    /**
     * @param leftRes Left padding as dimension resource.
     * @param topRes Top padding as dimension resource.
     * @param rightRes Right padding as dimension resource.
     * @param bottomRes Bottom padding as dimension resource.
     * @param itemSpacingRes Space as dimension resource to add between each carousel item. Will be
     *     implemented via an item decoration.
     */
    public static Padding resource(
//                ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                        ^^^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#resource(+1). public static Padding resource(int leftRes, int topRes, int rightRes, int bottomRes, int itemSpacingRes)
        @DimenRes int leftRes,
//       ^^^^^^^^ reference androidx/annotation/DimenRes#
//                    ^^^^^^^ definition local40 int leftRes
        @DimenRes int topRes,
//       ^^^^^^^^ reference androidx/annotation/DimenRes#
//                    ^^^^^^ definition local41 int topRes
        @DimenRes int rightRes,
//       ^^^^^^^^ reference androidx/annotation/DimenRes#
//                    ^^^^^^^^ definition local42 int rightRes
        @DimenRes int bottomRes,
//       ^^^^^^^^ reference androidx/annotation/DimenRes#
//                    ^^^^^^^^^ definition local43 int bottomRes
        @DimenRes int itemSpacingRes) {
//       ^^^^^^^^ reference androidx/annotation/DimenRes#
//                    ^^^^^^^^^^^^^^ definition local44 int itemSpacingRes
      return new Padding(
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#`<init>`(+2). 1:85
//               ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
          leftRes, topRes, rightRes, bottomRes, itemSpacingRes, PaddingType.RESOURCE);
//        ^^^^^^^ reference local40
//                 ^^^^^^ reference local41
//                         ^^^^^^^^ reference local42
//                                   ^^^^^^^^^ reference local43
//                                              ^^^^^^^^^^^^^^ reference local44
//                                                              ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                          ^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE.
    }

    /**
     * @param paddingDp Padding in dp.
     * @param itemSpacingDp Space in dp to add between each carousel item. Will be implemented via
     *     an item decoration.
     */
    public static Padding dp(
//                ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                        ^^ definition com/airbnb/epoxy/Carousel#Padding#dp(). public static Padding dp(int paddingDp, int itemSpacingDp)
        @Dimension(unit = Dimension.DP) int paddingDp,
//       ^^^^^^^^^ reference androidx/annotation/Dimension#
//                 ^^^^ reference androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                  ^^ reference androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^^ definition local45 int paddingDp
        @Dimension(unit = Dimension.DP) int itemSpacingDp) {
//       ^^^^^^^^^ reference androidx/annotation/Dimension#
//                 ^^^^ reference androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                  ^^ reference androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^^^^^^ definition local46 int itemSpacingDp
      return new Padding(paddingDp, paddingDp, paddingDp, paddingDp, itemSpacingDp, PaddingType.DP);
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//               ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                       ^^^^^^^^^ reference local45
//                                  ^^^^^^^^^ reference local45
//                                             ^^^^^^^^^ reference local45
//                                                        ^^^^^^^^^ reference local45
//                                                                   ^^^^^^^^^^^^^ reference local46
//                                                                                  ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                                              ^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#DP.
    }

    /**
     * @param leftDp Left padding in dp.
     * @param topDp Top padding in dp.
     * @param rightDp Right padding in dp.
     * @param bottomDp Bottom padding in dp.
     * @param itemSpacingDp Space in dp to add between each carousel item. Will be implemented via
     *     an item decoration.
     */
    public static Padding dp(
//                ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                        ^^ definition com/airbnb/epoxy/Carousel#Padding#dp(+1). public static Padding dp(int leftDp, int topDp, int rightDp, int bottomDp, int itemSpacingDp)
        @Dimension(unit = Dimension.DP) int leftDp,
//       ^^^^^^^^^ reference androidx/annotation/Dimension#
//                 ^^^^ reference androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                  ^^ reference androidx/annotation/Dimension#DP.
//                                          ^^^^^^ definition local47 int leftDp
        @Dimension(unit = Dimension.DP) int topDp,
//       ^^^^^^^^^ reference androidx/annotation/Dimension#
//                 ^^^^ reference androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                  ^^ reference androidx/annotation/Dimension#DP.
//                                          ^^^^^ definition local48 int topDp
        @Dimension(unit = Dimension.DP) int rightDp,
//       ^^^^^^^^^ reference androidx/annotation/Dimension#
//                 ^^^^ reference androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                  ^^ reference androidx/annotation/Dimension#DP.
//                                          ^^^^^^^ definition local49 int rightDp
        @Dimension(unit = Dimension.DP) int bottomDp,
//       ^^^^^^^^^ reference androidx/annotation/Dimension#
//                 ^^^^ reference androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                  ^^ reference androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^ definition local50 int bottomDp
        @Dimension(unit = Dimension.DP) int itemSpacingDp) {
//       ^^^^^^^^^ reference androidx/annotation/Dimension#
//                 ^^^^ reference androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference androidx/annotation/Dimension#
//                                  ^^ reference androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^^^^^^ definition local51 int itemSpacingDp
      return new Padding(leftDp, topDp, rightDp, bottomDp, itemSpacingDp, PaddingType.DP);
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//               ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                       ^^^^^^ reference local47
//                               ^^^^^ reference local48
//                                      ^^^^^^^ reference local49
//                                               ^^^^^^^^ reference local50
//                                                         ^^^^^^^^^^^^^ reference local51
//                                                                        ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                                    ^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#DP.
    }

    /**
     * @param paddingPx Padding in pixels to add on all sides of the carousel
     * @param itemSpacingPx Space in pixels to add between each carousel item. Will be implemented
     *     via an item decoration.
     */
    public Padding(@Px int paddingPx, @Px int itemSpacingPx) {
//         ^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#`<init>`(). public void <init>(int paddingPx, int itemSpacingPx)
//                  ^^ reference androidx/annotation/Px#
//                         ^^^^^^^^^ definition local52 int paddingPx
//                                     ^^ reference androidx/annotation/Px#
//                                            ^^^^^^^^^^^^^ definition local53 int itemSpacingPx
      this(paddingPx, paddingPx, paddingPx, paddingPx, itemSpacingPx, PaddingType.PX);
//    ^^^^ reference com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//         ^^^^^^^^^ reference local52
//                    ^^^^^^^^^ reference local52
//                               ^^^^^^^^^ reference local52
//                                          ^^^^^^^^^ reference local52
//                                                     ^^^^^^^^^^^^^ reference local53
//                                                                    ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                                ^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#PX.
    }

    /**
     * @param leftPx Left padding in pixels.
     * @param topPx Top padding in pixels.
     * @param rightPx Right padding in pixels.
     * @param bottomPx Bottom padding in pixels.
     * @param itemSpacingPx Space in pixels to add between each carousel item. Will be implemented
     *     via an item decoration.
     */
    public Padding(
//         ^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#`<init>`(+1). public void <init>(int leftPx, int topPx, int rightPx, int bottomPx, int itemSpacingPx)
        @Px int leftPx, @Px int topPx, @Px int rightPx, @Px int bottomPx, @Px int itemSpacingPx) {
//       ^^ reference androidx/annotation/Px#
//              ^^^^^^ definition local54 int leftPx
//                       ^^ reference androidx/annotation/Px#
//                              ^^^^^ definition local55 int topPx
//                                      ^^ reference androidx/annotation/Px#
//                                             ^^^^^^^ definition local56 int rightPx
//                                                       ^^ reference androidx/annotation/Px#
//                                                              ^^^^^^^^ definition local57 int bottomPx
//                                                                         ^^ reference androidx/annotation/Px#
//                                                                                ^^^^^^^^^^^^^ definition local58 int itemSpacingPx
      this(leftPx, topPx, rightPx, bottomPx, itemSpacingPx, PaddingType.PX);
//    ^^^^ reference com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//         ^^^^^^ reference local54
//                 ^^^^^ reference local55
//                        ^^^^^^^ reference local56
//                                 ^^^^^^^^ reference local57
//                                           ^^^^^^^^^^^^^ reference local58
//                                                          ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                      ^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#PX.
    }

    /**
     * @param left Left padding.
     * @param top Top padding.
     * @param right Right padding.
     * @param bottom Bottom padding.
     * @param itemSpacing Space to add between each carousel item. Will be implemented via an item
     *     decoration.
     * @param paddingType Unit / Type of the given paddings/ itemspacing.
     */
    private Padding(
//          ^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#`<init>`(+2). private void <init>(int left, int top, int right, int bottom, int itemSpacing, PaddingType paddingType)
        int left, int top, int right, int bottom, int itemSpacing, PaddingType paddingType) {
//          ^^^^ definition local59 int left
//                    ^^^ definition local60 int top
//                             ^^^^^ definition local61 int right
//                                        ^^^^^^ definition local62 int bottom
//                                                    ^^^^^^^^^^^ definition local63 int itemSpacing
//                                                                 ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                             ^^^^^^^^^^^ definition local64 PaddingType paddingType

      this.left = left;
//    ^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//         ^^^^ reference com/airbnb/epoxy/Carousel#Padding#left.
//                ^^^^ reference local59
      this.top = top;
//    ^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//         ^^^ reference com/airbnb/epoxy/Carousel#Padding#top.
//               ^^^ reference local60
      this.right = right;
//    ^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//         ^^^^^ reference com/airbnb/epoxy/Carousel#Padding#right.
//                 ^^^^^ reference local61
      this.bottom = bottom;
//    ^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//         ^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#bottom.
//                  ^^^^^^ reference local62
      this.itemSpacing = itemSpacing;
//    ^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//         ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#itemSpacing.
//                       ^^^^^^^^^^^ reference local63
      this.paddingType = paddingType;
//    ^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//         ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#paddingType.
//                       ^^^^^^^^^^^ reference local64
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public boolean equals(Object o) {
//                 ^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#equals(). public boolean equals(Object o)
//                        ^^^^^^ reference java/lang/Object#
//                               ^ definition local65 Object o
      if (this == o) {
//        ^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                ^ reference local65
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
//        ^ reference local65
//                     ^^^^^^^^ reference java/lang/Object#getClass().
//                                   ^ reference local65
//                                     ^^^^^^^^ reference java/lang/Object#getClass().
        return false;
      }

      Padding padding = (Padding) o;
//    ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//            ^^^^^^^ definition local66 Padding padding
//                       ^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#
//                                ^ reference local65

      if (left != padding.left) {
//        ^^^^ reference com/airbnb/epoxy/Carousel#Padding#left.
//                ^^^^^^^ reference local66
//                        ^^^^ reference com/airbnb/epoxy/Carousel#Padding#left.
        return false;
      }
      if (top != padding.top) {
//        ^^^ reference com/airbnb/epoxy/Carousel#Padding#top.
//               ^^^^^^^ reference local66
//                       ^^^ reference com/airbnb/epoxy/Carousel#Padding#top.
        return false;
      }
      if (right != padding.right) {
//        ^^^^^ reference com/airbnb/epoxy/Carousel#Padding#right.
//                 ^^^^^^^ reference local66
//                         ^^^^^ reference com/airbnb/epoxy/Carousel#Padding#right.
        return false;
      }
      if (bottom != padding.bottom) {
//        ^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#bottom.
//                  ^^^^^^^ reference local66
//                          ^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#bottom.
        return false;
      }
      return itemSpacing == padding.itemSpacing;
//           ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#itemSpacing.
//                          ^^^^^^^ reference local66
//                                  ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public int hashCode() {
//             ^^^^^^^^ definition com/airbnb/epoxy/Carousel#Padding#hashCode(). public int hashCode()
      int result = left;
//        ^^^^^^ definition local67 int result
//                 ^^^^ reference com/airbnb/epoxy/Carousel#Padding#left.
      result = 31 * result + top;
//    ^^^^^^ reference local67
//                  ^^^^^^ reference local67
//                           ^^^ reference com/airbnb/epoxy/Carousel#Padding#top.
      result = 31 * result + right;
//    ^^^^^^ reference local67
//                  ^^^^^^ reference local67
//                           ^^^^^ reference com/airbnb/epoxy/Carousel#Padding#right.
      result = 31 * result + bottom;
//    ^^^^^^ reference local67
//                  ^^^^^^ reference local67
//                           ^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#bottom.
      result = 31 * result + itemSpacing;
//    ^^^^^^ reference local67
//                  ^^^^^^ reference local67
//                           ^^^^^^^^^^^ reference com/airbnb/epoxy/Carousel#Padding#itemSpacing.
      return result;
//           ^^^^^^ reference local67
    }
  }

  @ModelProp
// ^^^^^^^^^ reference com/airbnb/epoxy/ModelProp#
  public void setModels(@NonNull List<? extends EpoxyModel<?>> models) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/Carousel#setModels(). public void setModels(List<? extends EpoxyModel<?>> models)
//                       ^^^^^^^ reference androidx/annotation/NonNull#
//                               ^^^^ reference java/util/List#
//                                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                             ^^^^^^ definition local68 List<? extends EpoxyModel<?>> models
    super.setModels(models);
//  ^^^^^ reference _root_/
//        ^^^^^^^^^ reference setModels#
//                  ^^^^^^ reference local68
  }

  @OnViewRecycled
// ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/OnViewRecycled#
  public void clear() {
//            ^^^^^ definition com/airbnb/epoxy/Carousel#clear(). public void clear()
    super.clear();
//  ^^^^^ reference _root_/
//        ^^^^^ reference clear#
  }

  /** Provide a SnapHelper implementation you want to use with a Carousel. */
  public abstract static class SnapHelperFactory {
//                             ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#SnapHelperFactory# public abstract static class SnapHelperFactory
//                             ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#SnapHelperFactory#`<init>`(). public void <init>()
    /**
     * Create and return a new instance of a {@link androidx.recyclerview.widget.SnapHelper} for use
     * with a Carousel.
     */
    @NonNull
//   ^^^^^^^ reference androidx/annotation/NonNull#
    public abstract SnapHelper buildSnapHelper(Context context);
//                  ^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/Carousel#SnapHelperFactory#buildSnapHelper(). public abstract buildSnapHelper(unresolved_type context)
//                                             ^^^^^^^ reference _root_/
//                                                     ^^^^^^^ definition local69 unresolved_type context
  }
}
