package com.airbnb.epoxy;

import android.content.Context;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^^ reference semanticdb maven . . android/content/
//                     ^^^^^^^ reference semanticdb maven . . android/content/Context#
import android.util.AttributeSet;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/util/
//                  ^^^^^^^^^^^^ reference semanticdb maven . . android/util/AttributeSet#
import android.util.DisplayMetrics;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/util/
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . android/util/DisplayMetrics#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#
import android.view.ViewGroup;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^ reference semanticdb maven . . android/view/ViewGroup#

import com.airbnb.epoxy.ModelView.Size;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelView#
//                                ^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelView#Size#
import com.airbnb.viewmodeladapter.R;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/viewmodeladapter/
//                                 ^ reference semanticdb maven . . com/airbnb/viewmodeladapter/R#

import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.annotation.DimenRes;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
import androidx.annotation.Dimension;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.annotation.Px;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
import androidx.recyclerview.widget.LinearLayoutManager;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/LinearLayoutManager#
import androidx.recyclerview.widget.LinearSnapHelper;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/LinearSnapHelper#
import androidx.recyclerview.widget.SnapHelper;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/SnapHelper#

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
//^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelView#
//         ^^^^^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelView#saveViewState().
//                               ^^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelView#autoLayout().
//                                            ^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelView#Size#
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelView#Size#MATCH_WIDTH_WRAP_HEIGHT.
public class Carousel extends EpoxyRecyclerView {
//           ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#
//                    documentation ```java\n@ModelView(saveViewState = true, autoLayout = Size.MATCH_WIDTH_WRAP_HEIGHT)\npublic class Carousel\n```
//                    documentation  <i>This feature is in Beta - please report bugs, feature requests, or other feedback at\n https://github.com/airbnb/epoxy by creating a new issue. Thanks!</i>\n\n <p>This is intended as a plug and play "Carousel" view - a Recyclerview with horizontal\n scrolling. It comes with common defaults and performance optimizations and can be either used as\n a top level RecyclerView, or nested within a vertical recyclerview.\n\n <p>This class provides:\n\n <p>1. Automatic integration with Epoxy. A {@link CarouselModel_} is generated from this class,\n which you can use in your EpoxyController. Just call {@link #setModels(List)} to provide the list\n of models to show in the carousel.\n\n <p>2. Default padding for carousel peeking, and an easy way to change this padding - {@link\n #setPaddingDp(int)}\n\n <p>3. Easily control how many items are shown on screen in the carousel at a time - {@link\n #setNumViewsToShowOnScreen(float)}\n\n <p>4. Easy snap support. By default a {@link LinearSnapHelper} is used, but you can set a global\n default for all Carousels with {@link #setDefaultGlobalSnapHelperFactory(SnapHelperFactory)}\n\n <p>5. All of the benefits of {@link EpoxyRecyclerView}\n\n <p>If you need further flexibility you can subclass this view to change its width, height,\n scrolling direction, etc. You can annotate a subclass with {@link ModelView} to generate a new\n EpoxyModel.\n
//                    relationship is_implementation semanticdb maven . . ``/EpoxyRecyclerView#
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
  public static final int NO_VALUE_SET = -1;
//                        ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#NO_VALUE_SET.
//                                     documentation ```java\npublic static final int NO_VALUE_SET\n```

  private static SnapHelperFactory defaultGlobalSnapHelperFactory =
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#defaultGlobalSnapHelperFactory.
//                                                                documentation ```java\nprivate static SnapHelperFactory defaultGlobalSnapHelperFactory\n```
      new SnapHelperFactory() {
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#

        @Override
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
        @NonNull
//       ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
        public SnapHelper buildSnapHelper(Context context) {
//             ^^^^^^^^^^ reference semanticdb maven . . _root_/
//                        ^^^^^^^^^^^^^^^ definition local 2
//                                        documentation ```java\n@Override\n@NonNull\npublic unresolved_type buildSnapHelper(unresolved_type context)\n```
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#buildSnapHelper().
//                                        ^^^^^^^ reference semanticdb maven . . _root_/
//                                                ^^^^^^^ definition local 3
//                                                        documentation ```java\nunresolved_type context\n```
          return new LinearSnapHelper();
        }
      };

  @Dimension(unit = Dimension.DP)
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//           ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                  ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                            ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
  private static int defaultSpacingBetweenItemsDp = 8;
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#defaultSpacingBetweenItemsDp.
//                                                documentation ```java\n@Dimension(unit = Dimension.DP)\nprivate static int defaultSpacingBetweenItemsDp\n```

  private float numViewsToShowOnScreen;
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
//                                     documentation ```java\nprivate float numViewsToShowOnScreen\n```

  public Carousel(Context context) {
//       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`().
//                documentation ```java\npublic Carousel(unresolved_type context)\n```
//                ^^^^^^^ reference semanticdb maven . . _root_/
//                        ^^^^^^^ definition local 4
//                                documentation ```java\nunresolved_type context\n```
    super(context);
//        ^^^^^^^ reference local 4
  }

  public Carousel(Context context, @Nullable AttributeSet attrs) {
//       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`(+1).
//                documentation ```java\npublic Carousel(unresolved_type context, unresolved_type attrs)\n```
//                ^^^^^^^ reference semanticdb maven . . _root_/
//                        ^^^^^^^ definition local 5
//                                documentation ```java\nunresolved_type context\n```
//                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                        ^^^^^ definition local 6
//                                                              documentation ```java\n@Nullable\nunresolved_type attrs\n```
    super(context, attrs);
//        ^^^^^^^ reference local 5
//                 ^^^^^ reference local 6
  }

  public Carousel(Context context, @Nullable AttributeSet attrs, int defStyle) {
//       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`(+2).
//                documentation ```java\npublic Carousel(unresolved_type context, unresolved_type attrs, int defStyle)\n```
//                ^^^^^^^ reference semanticdb maven . . _root_/
//                        ^^^^^^^ definition local 7
//                                documentation ```java\nunresolved_type context\n```
//                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                        ^^^^^ definition local 8
//                                                              documentation ```java\n@Nullable\nunresolved_type attrs\n```
//                                                                   ^^^^^^^^ definition local 9
//                                                                            documentation ```java\nint defStyle\n```
    super(context, attrs, defStyle);
//        ^^^^^^^ reference local 7
//                 ^^^^^ reference local 8
//                        ^^^^^^^^ reference local 9
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void init() {
//               ^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#init().
//                    documentation ```java\n@Override\nprotected void init()\n```
    super.init();
//  ^^^^^ reference semanticdb maven . . _root_/
//        ^^^^ reference semanticdb maven . . init#
    // When used as a model the padding can't be set via xml so we set it programmatically
    int defaultSpacingDp = getDefaultSpacingBetweenItemsDp();
//      ^^^^^^^^^^^^^^^^ definition local 10
//                       documentation ```java\nint defaultSpacingDp\n```
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getDefaultSpacingBetweenItemsDp().

    if (defaultSpacingDp >= 0) {
//      ^^^^^^^^^^^^^^^^ reference local 10
      setItemSpacingDp(defaultSpacingDp);
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingDp#
//                     ^^^^^^^^^^^^^^^^ reference local 10

      if (getPaddingLeft() == 0
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getPaddingLeft#
          && getPaddingRight() == 0
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getPaddingRight#
          && getPaddingTop() == 0
//           ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getPaddingTop#
          && getPaddingBottom() == 0) {
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getPaddingBottom#
        // Use the item spacing as the default padding if no other padding has been set
        setPaddingDp(defaultSpacingDp);
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPaddingDp().
//                   ^^^^^^^^^^^^^^^^ reference local 10
      }
    }

    SnapHelperFactory snapHelperFactory = getSnapHelperFactory();
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                    ^^^^^^^^^^^^^^^^^ definition local 11
//                                      documentation ```java\nSnapHelperFactory snapHelperFactory\n```
//                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getSnapHelperFactory().
    if (snapHelperFactory != null) {
//      ^^^^^^^^^^^^^^^^^ reference local 11
      snapHelperFactory.buildSnapHelper(getContext()).attachToRecyclerView(this);
//    ^^^^^^^^^^^^^^^^^ reference local 11
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#buildSnapHelper().
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getContext#
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . `<any>`#attachToRecyclerView#
    }

    // Carousels will be detached when their parent recyclerview is
    setRemoveAdapterWhenDetachedFromWindow(false);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setRemoveAdapterWhenDetachedFromWindow#
  }

  /**
   * Return a {@link SnapHelperFactory} instance to use with this Carousel. The {@link SnapHelper}
   * created by the factory will be attached to this Carousel on view creation. Return null for no
   * snap helper to be attached automatically.
   */
  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  protected SnapHelperFactory getSnapHelperFactory() {
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#getSnapHelperFactory().
//                                                 documentation ```java\n@Nullable\nprotected SnapHelperFactory getSnapHelperFactory()\n```
//                                                 documentation  Return a {@link SnapHelperFactory} instance to use with this Carousel. The {@link SnapHelper}\n created by the factory will be attached to this Carousel on view creation. Return null for no\n snap helper to be attached automatically.\n
    return defaultGlobalSnapHelperFactory;
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#defaultGlobalSnapHelperFactory.
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
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setDefaultGlobalSnapHelperFactory().
//                                                     documentation ```java\npublic static void setDefaultGlobalSnapHelperFactory(SnapHelperFactory factory)\n```
//                                                     documentation  Set a {@link SnapHelperFactory} instance to use with all Carousels by default. The {@link\n SnapHelper} created by the factory will be attached to each Carousel on view creation. Set null\n for no snap helper to be attached automatically.\n\n <p>A Carousel subclass can implement {@link #getSnapHelperFactory()} to override the global\n default.\n
//                                                      ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                                                                                 ^^^^^^^ definition local 12
//                                                                                         documentation ```java\n@Nullable\nSnapHelperFactory factory\n```
    defaultGlobalSnapHelperFactory = factory;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#defaultGlobalSnapHelperFactory.
//                                   ^^^^^^^ reference local 12
  }

  @ModelProp
// ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void setHasFixedSize(boolean hasFixedSize) {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setHasFixedSize().
//                            documentation ```java\n@ModelProp\n@Override\npublic void setHasFixedSize(boolean hasFixedSize)\n```
//                                    ^^^^^^^^^^^^ definition local 13
//                                                 documentation ```java\nboolean hasFixedSize\n```
    super.setHasFixedSize(hasFixedSize);
//  ^^^^^ reference semanticdb maven . . _root_/
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . setHasFixedSize#
//                        ^^^^^^^^^^^^ reference local 13
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
// ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#
//           ^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#group().
  public void setNumViewsToShowOnScreen(float viewCount) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setNumViewsToShowOnScreen().
//                                      documentation ```java\n@ModelProp(group = "prefetch")\npublic void setNumViewsToShowOnScreen(float viewCount)\n```
//                                      documentation  Set the number of views to show on screen in this carousel at a time, partial numbers are\n allowed.\n\n <p>This is useful where you want to easily control for the number of items on screen,\n regardless of screen size. For example, you could set this to 1.2f so that one view is shown in\n full and 20% of the next view "peeks" from the edge to indicate that there is more content to\n scroll to.\n\n <p>Another pattern is setting a different view count depending on whether the device is phone\n or tablet.\n\n <p>Additionally, if a LinearLayoutManager is used this value will be forwarded to {@link\n LinearLayoutManager#setInitialPrefetchItemCount(int)} as a performance optimization.\n\n <p>If you want to only change the prefetch count without changing the view size you can simply\n use {@link #setInitialPrefetchItemCount(int)}\n
//                                            ^^^^^^^^^ definition local 14
//                                                      documentation ```java\nfloat viewCount\n```
    numViewsToShowOnScreen = viewCount;
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
//                           ^^^^^^^^^ reference local 14
    setInitialPrefetchItemCount((int) Math.ceil(viewCount));
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setInitialPrefetchItemCount().
//                                    ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//                                         ^^^^ reference semanticdb maven jdk 11 java/lang/Math#ceil().
//                                              ^^^^^^^^^ reference local 14
  }

  /**
   * @return The number of views to show on screen in this carousel at a time.
   */
  public float getNumViewsToShowOnScreen() {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#getNumViewsToShowOnScreen().
//                                       documentation ```java\npublic float getNumViewsToShowOnScreen()\n```
//                                       documentation  @return The number of views to show on screen in this carousel at a time.\n
      return numViewsToShowOnScreen;
//           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
  }

  /**
   * If you are using a Linear or Grid layout manager you can use this to set the item prefetch
   * count. Only use this if you are not using {@link #setNumViewsToShowOnScreen(float)}
   *
   * @see #setNumViewsToShowOnScreen(float)
   * @see LinearLayoutManager#setInitialPrefetchItemCount(int)
   */
  @ModelProp(group = "prefetch")
// ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#
//           ^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#group().
  public void setInitialPrefetchItemCount(int numItemsToPrefetch) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setInitialPrefetchItemCount().
//                                        documentation ```java\n@ModelProp(group = "prefetch")\npublic void setInitialPrefetchItemCount(int numItemsToPrefetch)\n```
//                                        documentation  If you are using a Linear or Grid layout manager you can use this to set the item prefetch\n count. Only use this if you are not using {@link #setNumViewsToShowOnScreen(float)}\n\n @see #setNumViewsToShowOnScreen(float)\n @see LinearLayoutManager#setInitialPrefetchItemCount(int)\n
//                                            ^^^^^^^^^^^^^^^^^^ definition local 15
//                                                               documentation ```java\nint numItemsToPrefetch\n```
    if (numItemsToPrefetch < 0) {
//      ^^^^^^^^^^^^^^^^^^ reference local 15
      throw new IllegalStateException("numItemsToPrefetch must be greater than 0");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    // Use the linearlayoutmanager default of 2 if the user did not specify one
    int prefetchCount = numItemsToPrefetch == 0 ? 2 : numItemsToPrefetch;
//      ^^^^^^^^^^^^^ definition local 16
//                    documentation ```java\nint prefetchCount\n```
//                      ^^^^^^^^^^^^^^^^^^ reference local 15
//                                                    ^^^^^^^^^^^^^^^^^^ reference local 15

    LayoutManager layoutManager = getLayoutManager();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                ^^^^^^^^^^^^^ definition local 17
//                              documentation ```java\nunresolved_type layoutManager\n```
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getLayoutManager#
    if (layoutManager instanceof LinearLayoutManager) {
//      ^^^^^^^^^^^^^ reference local 17
//                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
      ((LinearLayoutManager) layoutManager).setInitialPrefetchItemCount(prefetchCount);
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                           ^^^^^^^^^^^^^ reference local 17
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . setInitialPrefetchItemCount#
//                                                                      ^^^^^^^^^^^^^ reference local 16
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onChildAttachedToWindow(View child) {
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#onChildAttachedToWindow().
//                                    documentation ```java\n@Override\npublic void onChildAttachedToWindow(unresolved_type child)\n```
//                                    ^^^^ reference semanticdb maven . . _root_/
//                                         ^^^^^ definition local 18
//                                               documentation ```java\nunresolved_type child\n```
    if (numViewsToShowOnScreen > 0) {
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
      ViewGroup.LayoutParams childLayoutParams = child.getLayoutParams();
//    ^^^^^^^^^ reference semanticdb maven . . ViewGroup/
//              ^^^^^^^^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#
//                           ^^^^^^^^^^^^^^^^^ definition local 19
//                                             documentation ```java\nunresolved_type childLayoutParams\n```
//                                               ^^^^^ reference local 18
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . getLayoutParams#
      child.setTag(R.id.epoxy_recycler_view_child_initial_size_id, childLayoutParams.width);
//    ^^^^^ reference local 18
//          ^^^^^^ reference semanticdb maven . . setTag#
//                 ^ reference semanticdb maven . . R/
//                   ^^ reference semanticdb maven . . R/id#
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_recycler_view_child_initial_size_id#
//                                                                 ^^^^^^^^^^^^^^^^^ reference local 19
//                                                                                   ^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#width#

      int itemSpacingPx = getSpacingDecorator().getPxBetweenItems();
//        ^^^^^^^^^^^^^ definition local 20
//                      documentation ```java\nint itemSpacingPx\n```
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getSpacingDecorator#
//                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getSpacingDecorator#getPxBetweenItems#
      int spaceBetweenItems = 0;
//        ^^^^^^^^^^^^^^^^^ definition local 21
//                          documentation ```java\nint spaceBetweenItems\n```
      if (itemSpacingPx > 0) {
//        ^^^^^^^^^^^^^ reference local 20
        // The item decoration space is not counted in the width of the view
        spaceBetweenItems = (int) (itemSpacingPx * numViewsToShowOnScreen);
//      ^^^^^^^^^^^^^^^^^ reference local 21
//                                 ^^^^^^^^^^^^^ reference local 20
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
      }

      boolean isScrollingHorizontally = getLayoutManager().canScrollHorizontally();
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition local 22
//                                    documentation ```java\nboolean isScrollingHorizontally\n```
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getLayoutManager#
//                                                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getLayoutManager#canScrollHorizontally#
      int itemSizeInScrollingDirection =
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 23
//                                     documentation ```java\nint itemSizeInScrollingDirection\n```
          (int)
              ((getSpaceForChildren(isScrollingHorizontally) - spaceBetweenItems)
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getSpaceForChildren().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^ reference local 22
//                                                             ^^^^^^^^^^^^^^^^^ reference local 21
                  / numViewsToShowOnScreen);
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.

      if (isScrollingHorizontally) {
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference local 22
        childLayoutParams.width = itemSizeInScrollingDirection;
//      ^^^^^^^^^^^^^^^^^ reference local 19
//                        ^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#width#
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 23
      } else {
        childLayoutParams.height = itemSizeInScrollingDirection;
//      ^^^^^^^^^^^^^^^^^ reference local 19
//                        ^^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#height#
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 23
      }

      // We don't need to request layout because the layout manager will do that for us next
    }
  }

  private int getSpaceForChildren(boolean horizontal) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#getSpaceForChildren().
//                                documentation ```java\nprivate int getSpaceForChildren(boolean horizontal)\n```
//                                        ^^^^^^^^^^ definition local 24
//                                                   documentation ```java\nboolean horizontal\n```
    if (horizontal) {
//      ^^^^^^^^^^ reference local 24
      return getTotalWidthPx(this)
//           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getTotalWidthPx().
          - getPaddingLeft()
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getPaddingLeft#
          - (getClipToPadding() ? getPaddingRight() : 0);
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getClipToPadding#
//                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getPaddingRight#
      // If child views will be showing through padding than we include just one side of padding
      // since when the list is at position 0 only the child towards the end of the list will show
      // through the padding.
    } else {
      return getTotalHeightPx(this)
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getTotalHeightPx().
          - getPaddingTop()
//          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getPaddingTop#
          - (getClipToPadding() ? getPaddingBottom() : 0);
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getClipToPadding#
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getPaddingBottom#
    }
  }

  @Px
// ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
  private static int getTotalWidthPx(View view) {
//                   ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#getTotalWidthPx().
//                                   documentation ```java\n@Px\nprivate static int getTotalWidthPx(unresolved_type view)\n```
//                                   ^^^^ reference semanticdb maven . . _root_/
//                                        ^^^^ definition local 25
//                                             documentation ```java\nunresolved_type view\n```
    if (view.getWidth() > 0) {
//      ^^^^ reference local 25
//           ^^^^^^^^ reference semanticdb maven . . getWidth#
      // Can only get a width if we are laid out
      return view.getWidth();
//           ^^^^ reference local 25
//                ^^^^^^^^ reference semanticdb maven . . getWidth#
    }

    if (view.getMeasuredWidth() > 0) {
//      ^^^^ reference local 25
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . getMeasuredWidth#
      return view.getMeasuredWidth();
//           ^^^^ reference local 25
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . getMeasuredWidth#
    }

    // Fall back to assuming we want the full screen width
    DisplayMetrics metrics = view.getContext().getResources().getDisplayMetrics();
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                 ^^^^^^^ definition local 26
//                         documentation ```java\nunresolved_type metrics\n```
//                           ^^^^ reference local 25
//                                ^^^^^^^^^^ reference semanticdb maven . . getContext#
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . getContext#getResources#
//                                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . getContext#getResources#getDisplayMetrics#
    return metrics.widthPixels;
//         ^^^^^^^ reference local 26
//                 ^^^^^^^^^^^ reference semanticdb maven . . widthPixels#
  }

  @Px
// ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
  private static int getTotalHeightPx(View view) {
//                   ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#getTotalHeightPx().
//                                    documentation ```java\n@Px\nprivate static int getTotalHeightPx(unresolved_type view)\n```
//                                    ^^^^ reference semanticdb maven . . _root_/
//                                         ^^^^ definition local 27
//                                              documentation ```java\nunresolved_type view\n```
    if (view.getHeight() > 0) {
//      ^^^^ reference local 27
//           ^^^^^^^^^ reference semanticdb maven . . getHeight#
      return view.getHeight();
//           ^^^^ reference local 27
//                ^^^^^^^^^ reference semanticdb maven . . getHeight#
    }

    if (view.getMeasuredHeight() > 0) {
//      ^^^^ reference local 27
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . getMeasuredHeight#
      return view.getMeasuredHeight();
//           ^^^^ reference local 27
//                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . getMeasuredHeight#
    }

    // Fall back to assuming we want the full screen width
    DisplayMetrics metrics = view.getContext().getResources().getDisplayMetrics();
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                 ^^^^^^^ definition local 28
//                         documentation ```java\nunresolved_type metrics\n```
//                           ^^^^ reference local 27
//                                ^^^^^^^^^^ reference semanticdb maven . . getContext#
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . getContext#getResources#
//                                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . getContext#getResources#getDisplayMetrics#
    return metrics.heightPixels;
//         ^^^^^^^ reference local 28
//                 ^^^^^^^^^^^^ reference semanticdb maven . . heightPixels#
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onChildDetachedFromWindow(View child) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#onChildDetachedFromWindow().
//                                      documentation ```java\n@Override\npublic void onChildDetachedFromWindow(unresolved_type child)\n```
//                                      ^^^^ reference semanticdb maven . . _root_/
//                                           ^^^^^ definition local 29
//                                                 documentation ```java\nunresolved_type child\n```
    // Restore the view width that existed before we modified it
    Object initialWidth = child.getTag(R.id.epoxy_recycler_view_child_initial_size_id);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//         ^^^^^^^^^^^^ definition local 30
//                      documentation ```java\nObject initialWidth\n```
//                        ^^^^^ reference local 29
//                              ^^^^^^ reference semanticdb maven . . getTag#
//                                     ^ reference semanticdb maven . . R/
//                                       ^^ reference semanticdb maven . . R/id#
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_recycler_view_child_initial_size_id#

    if (initialWidth instanceof Integer) {
//      ^^^^^^^^^^^^ reference local 30
//                              ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
      ViewGroup.LayoutParams params = child.getLayoutParams();
//    ^^^^^^^^^ reference semanticdb maven . . ViewGroup/
//              ^^^^^^^^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#
//                           ^^^^^^ definition local 31
//                                  documentation ```java\nunresolved_type params\n```
//                                    ^^^^^ reference local 29
//                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . getLayoutParams#
      params.width = (int) initialWidth;
//    ^^^^^^ reference local 31
//           ^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#width#
//                         ^^^^^^^^^^^^ reference local 30
      child.setTag(R.id.epoxy_recycler_view_child_initial_size_id, null);
//    ^^^^^ reference local 29
//          ^^^^^^ reference semanticdb maven . . setTag#
//                 ^ reference semanticdb maven . . R/
//                   ^^ reference semanticdb maven . . R/id#
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_recycler_view_child_initial_size_id#
      // No need to request layout since the view is unbound and not attached to window
    }
  }

  /**
   * Set a global default to use as the item spacing for all Carousels. Set to 0 for no item
   * spacing.
   */
  public static void setDefaultItemSpacingDp(@Dimension(unit = Dimension.DP) int dp) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setDefaultItemSpacingDp().
//                                           documentation ```java\npublic static void setDefaultItemSpacingDp(int dp)\n```
//                                           documentation  Set a global default to use as the item spacing for all Carousels. Set to 0 for no item\n spacing.\n
//                                            ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                                      ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                                                             ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                                                       ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                                                               ^^ definition local 32
//                                                                                  documentation ```java\n@Dimension(unit = Dimension.DP)\nint dp\n```
    defaultSpacingBetweenItemsDp = dp;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#defaultSpacingBetweenItemsDp.
//                                 ^^ reference local 32
  }

  /**
   * Return the item spacing to use in this carousel, or 0 for no spacing.
   *
   * <p>By default this uses the global default set in {@link #setDefaultItemSpacingDp(int)}, but
   * subclasses can override this to specify their own value.
   */
  @Dimension(unit = Dimension.DP)
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//           ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                  ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                            ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
  protected int getDefaultSpacingBetweenItemsDp() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#getDefaultSpacingBetweenItemsDp().
//                                              documentation ```java\n@Dimension(unit = Dimension.DP)\nprotected int getDefaultSpacingBetweenItemsDp()\n```
//                                              documentation  Return the item spacing to use in this carousel, or 0 for no spacing.\n\n <p>By default this uses the global default set in {@link #setDefaultItemSpacingDp(int)}, but\n subclasses can override this to specify their own value.\n
    return defaultSpacingBetweenItemsDp;
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#defaultSpacingBetweenItemsDp.
  }

  /**
   * Set a dimension resource to specify the padding value to use on each side of the carousel and
   * in between carousel items.
   */
  @ModelProp(group = "padding")
// ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#
//           ^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#group().
  public void setPaddingRes(@DimenRes int paddingRes) {
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setPaddingRes().
//                          documentation ```java\n@ModelProp(group = "padding")\npublic void setPaddingRes(int paddingRes)\n```
//                          documentation  Set a dimension resource to specify the padding value to use on each side of the carousel and\n in between carousel items.\n
//                           ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                                        ^^^^^^^^^^ definition local 33
//                                                   documentation ```java\n@DimenRes\nint paddingRes\n```
    int px = resToPx(paddingRes);
//      ^^ definition local 34
//         documentation ```java\nint px\n```
//           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                   ^^^^^^^^^^ reference local 33
    setPadding(px, px, px, px);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
//             ^^ reference local 34
//                 ^^ reference local 34
//                     ^^ reference local 34
//                         ^^ reference local 34
    setItemSpacingPx(px);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                   ^^ reference local 34
  }

  /**
   * Set a DP value to use as the padding on each side of the carousel and in between carousel
   * items.
   *
   * <p>The default as the value returned by {@link #getDefaultSpacingBetweenItemsDp()}
   */
  @ModelProp(defaultValue = "NO_VALUE_SET", group = "padding")
// ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#
//           ^^^^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#defaultValue().
//                                          ^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#group().
  public void setPaddingDp(@Dimension(unit = Dimension.DP) int paddingDp) {
//            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setPaddingDp().
//                         documentation ```java\n@ModelProp(defaultValue = "NO_VALUE_SET", group = "padding")\npublic void setPaddingDp(int paddingDp)\n```
//                         documentation  Set a DP value to use as the padding on each side of the carousel and in between carousel\n items.\n\n <p>The default as the value returned by {@link #getDefaultSpacingBetweenItemsDp()}\n
//                          ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                    ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                                           ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                                     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                                             ^^^^^^^^^ definition local 35
//                                                                       documentation ```java\n@Dimension(unit = Dimension.DP)\nint paddingDp\n```
    int px = dpToPx(paddingDp != NO_VALUE_SET ? paddingDp : getDefaultSpacingBetweenItemsDp());
//      ^^ definition local 36
//         documentation ```java\nint px\n```
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                  ^^^^^^^^^ reference local 35
//                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#NO_VALUE_SET.
//                                              ^^^^^^^^^ reference local 35
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getDefaultSpacingBetweenItemsDp().
    setPadding(px, px, px, px);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
//             ^^ reference local 36
//                 ^^ reference local 36
//                     ^^ reference local 36
//                         ^^ reference local 36
    setItemSpacingPx(px);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                   ^^ reference local 36
  }

  /**
   * Use the {@link Padding} class to specify individual padding values for each side of the
   * carousel, as well as item spacing.
   *
   * <p>A value of null will set all padding and item spacing to 0.
   */
  @ModelProp(group = "padding")
// ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#
//           ^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#group().
  public void setPadding(@Nullable Padding padding) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding().
//                       documentation ```java\n@ModelProp(group = "padding")\npublic void setPadding(Padding padding)\n```
//                       documentation  Use the {@link Padding} class to specify individual padding values for each side of the\n carousel, as well as item spacing.\n\n <p>A value of null will set all padding and item spacing to 0.\n
//                        ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                 ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                         ^^^^^^^ definition local 37
//                                                 documentation ```java\n@Nullable\nPadding padding\n```
    if (padding == null) {
//      ^^^^^^^ reference local 37
      setPaddingDp(0);
//    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPaddingDp().
    } else if (padding.paddingType == Padding.PaddingType.PX) {
//             ^^^^^^^ reference local 37
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                        ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#PX.
      setPadding(padding.left, padding.top, padding.right, padding.bottom);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
//               ^^^^^^^ reference local 37
//                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                             ^^^^^^^ reference local 37
//                                     ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//                                          ^^^^^^^ reference local 37
//                                                  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                                                         ^^^^^^^ reference local 37
//                                                                 ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
      setItemSpacingPx(padding.itemSpacing);
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                     ^^^^^^^ reference local 37
//                             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    } else if (padding.paddingType == Padding.PaddingType.DP) {
//             ^^^^^^^ reference local 37
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                        ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#DP.
      setPadding(
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
          dpToPx(padding.left), dpToPx(padding.top), dpToPx(padding.right), dpToPx(padding.bottom));
//        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//               ^^^^^^^ reference local 37
//                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                              ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                                     ^^^^^^^ reference local 37
//                                             ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//                                                   ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                                                          ^^^^^^^ reference local 37
//                                                                  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                                                                          ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                                                                                 ^^^^^^^ reference local 37
//                                                                                         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
      setItemSpacingPx(dpToPx(padding.itemSpacing));
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                            ^^^^^^^ reference local 37
//                                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    } else if (padding.paddingType == Padding.PaddingType.RESOURCE) {
//             ^^^^^^^ reference local 37
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE.
      setPadding(
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
          resToPx(padding.left),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local 37
//                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
          resToPx(padding.top),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local 37
//                        ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
          resToPx(padding.right),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local 37
//                        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
          resToPx(padding.bottom));
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local 37
//                        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
      setItemSpacingPx(resToPx(padding.itemSpacing));
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                     ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                             ^^^^^^^ reference local 37
//                                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    }
  }

  /**
   * Used to specify individual padding values programmatically.
   *
   * @see #setPadding(Padding)
   */
  public static class Padding {
//                    ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                            documentation ```java\npublic static class Padding\n```
//                            documentation  Used to specify individual padding values programmatically.\n\n @see #setPadding(Padding)\n
    public final int left;
//                   ^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                        documentation ```java\npublic final int left\n```
    public final int top;
//                   ^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//                       documentation ```java\npublic final int top\n```
    public final int right;
//                   ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                         documentation ```java\npublic final int right\n```
    public final int bottom;
//                   ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
//                          documentation ```java\npublic final int bottom\n```
    public final int itemSpacing;
//                   ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
//                               documentation ```java\npublic final int itemSpacing\n```
    public final PaddingType paddingType;
//               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                       documentation ```java\npublic final PaddingType paddingType\n```

    enum PaddingType {
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                   documentation ```java\nenum PaddingType\n```
//                   relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                   relationship is_implementation semanticdb maven jdk 11 java/lang/Comparable#
//                   relationship is_implementation semanticdb maven jdk 11 java/lang/Enum#
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#`<init>`().
//                   documentation ```java\nprivate PaddingType()\n```
      PX,
//    ^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#PX.
//       documentation ```java\nPaddingType.PX /* ordinal 0 */\n```
      DP,
//    ^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#DP.
//       documentation ```java\nPaddingType.DP /* ordinal 1 */\n```
      RESOURCE
//    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE.
//             documentation ```java\nPaddingType.RESOURCE /* ordinal 2 */\n```
    }

    /**
     * @param paddingRes Padding as dimension resource.
     * @param itemSpacingRes Space as dimension resource to add between each carousel item. Will be
     *     implemented via an item decoration.
     */
    public static Padding resource(@DimenRes int paddingRes, @DimenRes int itemSpacingRes) {
//                ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource().
//                                 documentation ```java\npublic static Padding resource(int paddingRes, int itemSpacingRes)\n```
//                                 documentation  @param paddingRes Padding as dimension resource.\n @param itemSpacingRes Space as dimension resource to add between each carousel item. Will be\n     implemented via an item decoration.\n
//                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                                               ^^^^^^^^^^ definition local 38
//                                                          documentation ```java\n@DimenRes\nint paddingRes\n```
//                                                            ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                                                                         ^^^^^^^^^^^^^^ definition local 39
//                                                                                        documentation ```java\n@DimenRes\nint itemSpacingRes\n```
      return new Padding(
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
          paddingRes, paddingRes, paddingRes, paddingRes, itemSpacingRes, PaddingType.RESOURCE);
//        ^^^^^^^^^^ reference local 38
//                    ^^^^^^^^^^ reference local 38
//                                ^^^^^^^^^^ reference local 38
//                                            ^^^^^^^^^^ reference local 38
//                                                        ^^^^^^^^^^^^^^ reference local 39
//                                                                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#`<init>`().
//                                                                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#`<init>`().
//                                                                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#`<init>`().
//                                                                                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE.
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
//                ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource(+1).
//                                 documentation ```java\npublic static Padding resource(int leftRes, int topRes, int rightRes, int bottomRes, int itemSpacingRes)\n```
//                                 documentation  @param leftRes Left padding as dimension resource.\n @param topRes Top padding as dimension resource.\n @param rightRes Right padding as dimension resource.\n @param bottomRes Bottom padding as dimension resource.\n @param itemSpacingRes Space as dimension resource to add between each carousel item. Will be\n     implemented via an item decoration.\n
        @DimenRes int leftRes,
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^^ definition local 40
//                            documentation ```java\n@DimenRes\nint leftRes\n```
        @DimenRes int topRes,
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^ definition local 41
//                           documentation ```java\n@DimenRes\nint topRes\n```
        @DimenRes int rightRes,
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^^^ definition local 42
//                             documentation ```java\n@DimenRes\nint rightRes\n```
        @DimenRes int bottomRes,
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^^^^ definition local 43
//                              documentation ```java\n@DimenRes\nint bottomRes\n```
        @DimenRes int itemSpacingRes) {
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^^^^^^^^^ definition local 44
//                                   documentation ```java\n@DimenRes\nint itemSpacingRes\n```
      return new Padding(
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
          leftRes, topRes, rightRes, bottomRes, itemSpacingRes, PaddingType.RESOURCE);
//        ^^^^^^^ reference local 40
//                 ^^^^^^ reference local 41
//                         ^^^^^^^^ reference local 42
//                                   ^^^^^^^^^ reference local 43
//                                              ^^^^^^^^^^^^^^ reference local 44
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE.
    }

    /**
     * @param paddingDp Padding in dp.
     * @param itemSpacingDp Space in dp to add between each carousel item. Will be implemented via
     *     an item decoration.
     */
    public static Padding dp(
//                ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                        ^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#dp().
//                           documentation ```java\npublic static Padding dp(int paddingDp, int itemSpacingDp)\n```
//                           documentation  @param paddingDp Padding in dp.\n @param itemSpacingDp Space in dp to add between each carousel item. Will be implemented via\n     an item decoration.\n
        @Dimension(unit = Dimension.DP) int paddingDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^^ definition local 45
//                                                    documentation ```java\n@Dimension(unit = Dimension.DP)\nint paddingDp\n```
        @Dimension(unit = Dimension.DP) int itemSpacingDp) {
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^^^^^^ definition local 46
//                                                        documentation ```java\n@Dimension(unit = Dimension.DP)\nint itemSpacingDp\n```
      return new Padding(paddingDp, paddingDp, paddingDp, paddingDp, itemSpacingDp, PaddingType.DP);
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                       ^^^^^^^^^ reference local 45
//                                  ^^^^^^^^^ reference local 45
//                                             ^^^^^^^^^ reference local 45
//                                                        ^^^^^^^^^ reference local 45
//                                                                   ^^^^^^^^^^^^^ reference local 46
//                                                                                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                                              ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#DP.
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
//                ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                        ^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#dp(+1).
//                           documentation ```java\npublic static Padding dp(int leftDp, int topDp, int rightDp, int bottomDp, int itemSpacingDp)\n```
//                           documentation  @param leftDp Left padding in dp.\n @param topDp Top padding in dp.\n @param rightDp Right padding in dp.\n @param bottomDp Bottom padding in dp.\n @param itemSpacingDp Space in dp to add between each carousel item. Will be implemented via\n     an item decoration.\n
        @Dimension(unit = Dimension.DP) int leftDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^ definition local 47
//                                                 documentation ```java\n@Dimension(unit = Dimension.DP)\nint leftDp\n```
        @Dimension(unit = Dimension.DP) int topDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^ definition local 48
//                                                documentation ```java\n@Dimension(unit = Dimension.DP)\nint topDp\n```
        @Dimension(unit = Dimension.DP) int rightDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^ definition local 49
//                                                  documentation ```java\n@Dimension(unit = Dimension.DP)\nint rightDp\n```
        @Dimension(unit = Dimension.DP) int bottomDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^ definition local 50
//                                                   documentation ```java\n@Dimension(unit = Dimension.DP)\nint bottomDp\n```
        @Dimension(unit = Dimension.DP) int itemSpacingDp) {
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^^^^^^ definition local 51
//                                                        documentation ```java\n@Dimension(unit = Dimension.DP)\nint itemSpacingDp\n```
      return new Padding(leftDp, topDp, rightDp, bottomDp, itemSpacingDp, PaddingType.DP);
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                       ^^^^^^ reference local 47
//                               ^^^^^ reference local 48
//                                      ^^^^^^^ reference local 49
//                                               ^^^^^^^^ reference local 50
//                                                         ^^^^^^^^^^^^^ reference local 51
//                                                                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                                    ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#DP.
    }

    /**
     * @param paddingPx Padding in pixels to add on all sides of the carousel
     * @param itemSpacingPx Space in pixels to add between each carousel item. Will be implemented
     *     via an item decoration.
     */
    public Padding(@Px int paddingPx, @Px int itemSpacingPx) {
//         ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`().
//                 documentation ```java\npublic Padding(int paddingPx, int itemSpacingPx)\n```
//                 documentation  @param paddingPx Padding in pixels to add on all sides of the carousel\n @param itemSpacingPx Space in pixels to add between each carousel item. Will be implemented\n     via an item decoration.\n
//                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                         ^^^^^^^^^ definition local 52
//                                   documentation ```java\n@Px\nint paddingPx\n```
//                                     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                            ^^^^^^^^^^^^^ definition local 53
//                                                          documentation ```java\n@Px\nint itemSpacingPx\n```
      this(paddingPx, paddingPx, paddingPx, paddingPx, itemSpacingPx, PaddingType.PX);
//    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//         ^^^^^^^^^ reference local 52
//                    ^^^^^^^^^ reference local 52
//                               ^^^^^^^^^ reference local 52
//                                          ^^^^^^^^^ reference local 52
//                                                     ^^^^^^^^^^^^^ reference local 53
//                                                                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                                ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#PX.
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
//         ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+1).
//                 documentation ```java\npublic Padding(int leftPx, int topPx, int rightPx, int bottomPx, int itemSpacingPx)\n```
//                 documentation  @param leftPx Left padding in pixels.\n @param topPx Top padding in pixels.\n @param rightPx Right padding in pixels.\n @param bottomPx Bottom padding in pixels.\n @param itemSpacingPx Space in pixels to add between each carousel item. Will be implemented\n     via an item decoration.\n
        @Px int leftPx, @Px int topPx, @Px int rightPx, @Px int bottomPx, @Px int itemSpacingPx) {
//       ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//              ^^^^^^ definition local 54
//                     documentation ```java\n@Px\nint leftPx\n```
//                       ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                              ^^^^^ definition local 55
//                                    documentation ```java\n@Px\nint topPx\n```
//                                      ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                             ^^^^^^^ definition local 56
//                                                     documentation ```java\n@Px\nint rightPx\n```
//                                                       ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                                              ^^^^^^^^ definition local 57
//                                                                       documentation ```java\n@Px\nint bottomPx\n```
//                                                                         ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                                                                ^^^^^^^^^^^^^ definition local 58
//                                                                                              documentation ```java\n@Px\nint itemSpacingPx\n```
      this(leftPx, topPx, rightPx, bottomPx, itemSpacingPx, PaddingType.PX);
//    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//         ^^^^^^ reference local 54
//                 ^^^^^ reference local 55
//                        ^^^^^^^ reference local 56
//                                 ^^^^^^^^ reference local 57
//                                           ^^^^^^^^^^^^^ reference local 58
//                                                          ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                      ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#PX.
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
//          ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                  documentation ```java\nprivate Padding(int left, int top, int right, int bottom, int itemSpacing, PaddingType paddingType)\n```
//                  documentation  @param left Left padding.\n @param top Top padding.\n @param right Right padding.\n @param bottom Bottom padding.\n @param itemSpacing Space to add between each carousel item. Will be implemented via an item\n     decoration.\n @param paddingType Unit / Type of the given paddings/ itemspacing.\n
        int left, int top, int right, int bottom, int itemSpacing, PaddingType paddingType) {
//          ^^^^ definition local 59
//               documentation ```java\nint left\n```
//                    ^^^ definition local 60
//                        documentation ```java\nint top\n```
//                             ^^^^^ definition local 61
//                                   documentation ```java\nint right\n```
//                                        ^^^^^^ definition local 62
//                                               documentation ```java\nint bottom\n```
//                                                    ^^^^^^^^^^^ definition local 63
//                                                                documentation ```java\nint itemSpacing\n```
//                                                                 ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                             ^^^^^^^^^^^ definition local 64
//                                                                                         documentation ```java\nPaddingType paddingType\n```

      this.left = left;
//         ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                ^^^^ reference local 59
      this.top = top;
//         ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//               ^^^ reference local 60
      this.right = right;
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                 ^^^^^ reference local 61
      this.bottom = bottom;
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
//                  ^^^^^^ reference local 62
      this.itemSpacing = itemSpacing;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
//                       ^^^^^^^^^^^ reference local 63
      this.paddingType = paddingType;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                       ^^^^^^^^^^^ reference local 64
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean equals(Object o) {
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#equals().
//                        documentation ```java\n@Override\npublic boolean equals(Object o)\n```
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                               ^ definition local 65
//                                 documentation ```java\nObject o\n```
      if (this == o) {
//                ^ reference local 65
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
//        ^ reference local 65
//                     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
//                                   ^ reference local 65
//                                     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
        return false;
      }

      Padding padding = (Padding) o;
//    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//            ^^^^^^^ definition local 66
//                    documentation ```java\nPadding padding\n```
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                ^ reference local 65

      if (left != padding.left) {
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                ^^^^^^^ reference local 66
//                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
        return false;
      }
      if (top != padding.top) {
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//               ^^^^^^^ reference local 66
//                       ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
        return false;
      }
      if (right != padding.right) {
//        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                 ^^^^^^^ reference local 66
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
        return false;
      }
      if (bottom != padding.bottom) {
//        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
//                  ^^^^^^^ reference local 66
//                          ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
        return false;
      }
      return itemSpacing == padding.itemSpacing;
//           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
//                          ^^^^^^^ reference local 66
//                                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public int hashCode() {
//             ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#hashCode().
//                      documentation ```java\n@Override\npublic int hashCode()\n```
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
      int result = left;
//        ^^^^^^ definition local 67
//               documentation ```java\nint result\n```
//                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
      result = 31 * result + top;
//    ^^^^^^ reference local 67
//                  ^^^^^^ reference local 67
//                           ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
      result = 31 * result + right;
//    ^^^^^^ reference local 67
//                  ^^^^^^ reference local 67
//                           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
      result = 31 * result + bottom;
//    ^^^^^^ reference local 67
//                  ^^^^^^ reference local 67
//                           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
      result = 31 * result + itemSpacing;
//    ^^^^^^ reference local 67
//                  ^^^^^^ reference local 67
//                           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
      return result;
//           ^^^^^^ reference local 67
    }
  }

  @ModelProp
// ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#
  public void setModels(@NonNull List<? extends EpoxyModel<?>> models) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setModels().
//                      documentation ```java\n@ModelProp\npublic void setModels(List<? extends EpoxyModel<?>> models)\n```
//                       ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                             ^^^^^^ definition local 68
//                                                                    documentation ```java\n@NonNull\nList<? extends EpoxyModel<?>> models\n```
    super.setModels(models);
//  ^^^^^ reference semanticdb maven . . _root_/
//        ^^^^^^^^^ reference semanticdb maven . . setModels#
//                  ^^^^^^ reference local 68
  }

  @OnViewRecycled
// ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/OnViewRecycled#
  public void clear() {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#clear().
//                  documentation ```java\n@OnViewRecycled\npublic void clear()\n```
    super.clear();
//  ^^^^^ reference semanticdb maven . . _root_/
//        ^^^^^ reference semanticdb maven . . clear#
  }

  /** Provide a SnapHelper implementation you want to use with a Carousel. */
  public abstract static class SnapHelperFactory {
//                             ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                                               documentation ```java\npublic abstract static class SnapHelperFactory\n```
//                                               documentation Provide a SnapHelper implementation you want to use with a Carousel. 
//                             ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#`<init>`().
//                                               documentation ```java\npublic SnapHelperFactory()\n```
    /**
     * Create and return a new instance of a {@link androidx.recyclerview.widget.SnapHelper} for use
     * with a Carousel.
     */
    @NonNull
//   ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
    public abstract SnapHelper buildSnapHelper(Context context);
//                  ^^^^^^^^^^ reference semanticdb maven . . _root_/
//                             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#buildSnapHelper().
//                                             documentation ```java\n@NonNull\npublic abstract unresolved_type buildSnapHelper(unresolved_type context)\n```
//                                             documentation  Create and return a new instance of a {@link androidx.recyclerview.widget.SnapHelper} for use\n with a Carousel.\n
//                                             ^^^^^^^ reference semanticdb maven . . _root_/
//                                                     ^^^^^^^ definition local 69
//                                                             documentation ```java\nunresolved_type context\n```
  }
}
