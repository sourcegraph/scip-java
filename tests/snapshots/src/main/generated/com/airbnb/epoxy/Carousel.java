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
//                    display_name Carousel
//                    signature_documentation java @ModelView(saveViewState = true, autoLayout = Size.MATCH_WIDTH_WRAP_HEIGHT)\npublic class Carousel
//                    documentation  <i>This feature is in Beta - please report bugs, feature requests, or other feedback at\n https://github.com/airbnb/epoxy by creating a new issue. Thanks!</i>\n\n <p>This is intended as a plug and play "Carousel" view - a Recyclerview with horizontal\n scrolling. It comes with common defaults and performance optimizations and can be either used as\n a top level RecyclerView, or nested within a vertical recyclerview.\n\n <p>This class provides:\n\n <p>1. Automatic integration with Epoxy. A {@link CarouselModel_} is generated from this class,\n which you can use in your EpoxyController. Just call {@link #setModels(List)} to provide the list\n of models to show in the carousel.\n\n <p>2. Default padding for carousel peeking, and an easy way to change this padding - {@link\n #setPaddingDp(int)}\n\n <p>3. Easily control how many items are shown on screen in the carousel at a time - {@link\n #setNumViewsToShowOnScreen(float)}\n\n <p>4. Easy snap support. By default a {@link LinearSnapHelper} is used, but you can set a global\n default for all Carousels with {@link #setDefaultGlobalSnapHelperFactory(SnapHelperFactory)}\n\n <p>5. All of the benefits of {@link EpoxyRecyclerView}\n\n <p>If you need further flexibility you can subclass this view to change its width, height,\n scrolling direction, etc. You can annotate a subclass with {@link ModelView} to generate a new\n EpoxyModel.\n
//                    relationship is_implementation semanticdb maven . . EpoxyRecyclerView#
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . EpoxyRecyclerView#
  public static final int NO_VALUE_SET = -1;
//                        ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#NO_VALUE_SET.
//                                     display_name NO_VALUE_SET
//                                     signature_documentation java public static final int NO_VALUE_SET

  private static SnapHelperFactory defaultGlobalSnapHelperFactory =
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#defaultGlobalSnapHelperFactory.
//                                                                display_name defaultGlobalSnapHelperFactory
//                                                                signature_documentation java private static SnapHelperFactory defaultGlobalSnapHelperFactory
      new SnapHelperFactory() {
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#

        @Override
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
        @NonNull
//       ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
        public SnapHelper buildSnapHelper(Context context) {
//             ^^^^^^^^^^ reference semanticdb maven . . SnapHelper#
//                        ^^^^^^^^^^^^^^^ definition local 1
//                                        display_name buildSnapHelper
//                                        signature_documentation java @Override\n@NonNull\npublic unresolved_type buildSnapHelper(unresolved_type context)
//                                        enclosing_symbol local 0
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#buildSnapHelper().
//                                        ^^^^^^^ reference semanticdb maven . . Context#
//                                                ^^^^^^^ definition local 2
//                                                        display_name context
//                                                        signature_documentation java unresolved_type context
//                                                        enclosing_symbol local 1
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
//                                                display_name defaultSpacingBetweenItemsDp
//                                                signature_documentation java @Dimension(unit = Dimension.DP)\nprivate static int defaultSpacingBetweenItemsDp

  private float numViewsToShowOnScreen;
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
//                                     display_name numViewsToShowOnScreen
//                                     signature_documentation java private float numViewsToShowOnScreen

  public Carousel(Context context) {
//       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`().
//                display_name <init>
//                signature_documentation java public Carousel(unresolved_type context)
//                ^^^^^^^ reference semanticdb maven . . Context#
//                        ^^^^^^^ definition local 3
//                                display_name context
//                                signature_documentation java unresolved_type context
//                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`().
    super(context);
//        ^^^^^^^ reference local 3
  }

  public Carousel(Context context, @Nullable AttributeSet attrs) {
//       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`(+1).
//                display_name <init>
//                signature_documentation java public Carousel(unresolved_type context, unresolved_type attrs)
//                ^^^^^^^ reference semanticdb maven . . Context#
//                        ^^^^^^^ definition local 4
//                                display_name context
//                                signature_documentation java unresolved_type context
//                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`(+1).
//                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . AttributeSet#
//                                                        ^^^^^ definition local 5
//                                                              display_name attrs
//                                                              signature_documentation java @Nullable\nunresolved_type attrs
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`(+1).
    super(context, attrs);
//        ^^^^^^^ reference local 4
//                 ^^^^^ reference local 5
  }

  public Carousel(Context context, @Nullable AttributeSet attrs, int defStyle) {
//       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`(+2).
//                display_name <init>
//                signature_documentation java public Carousel(unresolved_type context, unresolved_type attrs, int defStyle)
//                ^^^^^^^ reference semanticdb maven . . Context#
//                        ^^^^^^^ definition local 6
//                                display_name context
//                                signature_documentation java unresolved_type context
//                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`(+2).
//                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . AttributeSet#
//                                                        ^^^^^ definition local 7
//                                                              display_name attrs
//                                                              signature_documentation java @Nullable\nunresolved_type attrs
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`(+2).
//                                                                   ^^^^^^^^ definition local 8
//                                                                            display_name defStyle
//                                                                            signature_documentation java int defStyle
//                                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#`<init>`(+2).
    super(context, attrs, defStyle);
//        ^^^^^^^ reference local 6
//                 ^^^^^ reference local 7
//                        ^^^^^^^^ reference local 8
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void init() {
//               ^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#init().
//                    display_name init
//                    signature_documentation java @Override\nprotected void init()
    super.init();
//  ^^^^^ reference semanticdb maven . . super#
//        ^^^^ reference semanticdb maven . . super#init#
    // When used as a model the padding can't be set via xml so we set it programmatically
    int defaultSpacingDp = getDefaultSpacingBetweenItemsDp();
//      ^^^^^^^^^^^^^^^^ definition local 9
//                       display_name defaultSpacingDp
//                       signature_documentation java int defaultSpacingDp
//                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#init().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getDefaultSpacingBetweenItemsDp().

    if (defaultSpacingDp >= 0) {
//      ^^^^^^^^^^^^^^^^ reference local 9
      setItemSpacingDp(defaultSpacingDp);
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingDp#
//                     ^^^^^^^^^^^^^^^^ reference local 9

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
//                   ^^^^^^^^^^^^^^^^ reference local 9
      }
    }

    SnapHelperFactory snapHelperFactory = getSnapHelperFactory();
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                    ^^^^^^^^^^^^^^^^^ definition local 10
//                                      display_name snapHelperFactory
//                                      signature_documentation java SnapHelperFactory snapHelperFactory
//                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#init().
//                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getSnapHelperFactory().
    if (snapHelperFactory != null) {
//      ^^^^^^^^^^^^^^^^^ reference local 10
      snapHelperFactory.buildSnapHelper(getContext()).attachToRecyclerView(this);
//    ^^^^^^^^^^^^^^^^^ reference local 10
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
//                                                 display_name getSnapHelperFactory
//                                                 signature_documentation java @Nullable\nprotected SnapHelperFactory getSnapHelperFactory()
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
//                                                     display_name setDefaultGlobalSnapHelperFactory
//                                                     signature_documentation java public static void setDefaultGlobalSnapHelperFactory(SnapHelperFactory factory)
//                                                     documentation  Set a {@link SnapHelperFactory} instance to use with all Carousels by default. The {@link\n SnapHelper} created by the factory will be attached to each Carousel on view creation. Set null\n for no snap helper to be attached automatically.\n\n <p>A Carousel subclass can implement {@link #getSnapHelperFactory()} to override the global\n default.\n
//                                                      ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                                                                                 ^^^^^^^ definition local 11
//                                                                                         display_name factory
//                                                                                         signature_documentation java @Nullable\nSnapHelperFactory factory
//                                                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setDefaultGlobalSnapHelperFactory().
    defaultGlobalSnapHelperFactory = factory;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#defaultGlobalSnapHelperFactory.
//                                   ^^^^^^^ reference local 11
  }

  @ModelProp
// ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void setHasFixedSize(boolean hasFixedSize) {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setHasFixedSize().
//                            display_name setHasFixedSize
//                            signature_documentation java @ModelProp\n@Override\npublic void setHasFixedSize(boolean hasFixedSize)
//                                    ^^^^^^^^^^^^ definition local 12
//                                                 display_name hasFixedSize
//                                                 signature_documentation java boolean hasFixedSize
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setHasFixedSize().
    super.setHasFixedSize(hasFixedSize);
//  ^^^^^ reference semanticdb maven . . super#
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . super#setHasFixedSize#
//                        ^^^^^^^^^^^^ reference local 12
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
//                                      display_name setNumViewsToShowOnScreen
//                                      signature_documentation java @ModelProp(group = "prefetch")\npublic void setNumViewsToShowOnScreen(float viewCount)
//                                      documentation  Set the number of views to show on screen in this carousel at a time, partial numbers are\n allowed.\n\n <p>This is useful where you want to easily control for the number of items on screen,\n regardless of screen size. For example, you could set this to 1.2f so that one view is shown in\n full and 20% of the next view "peeks" from the edge to indicate that there is more content to\n scroll to.\n\n <p>Another pattern is setting a different view count depending on whether the device is phone\n or tablet.\n\n <p>Additionally, if a LinearLayoutManager is used this value will be forwarded to {@link\n LinearLayoutManager#setInitialPrefetchItemCount(int)} as a performance optimization.\n\n <p>If you want to only change the prefetch count without changing the view size you can simply\n use {@link #setInitialPrefetchItemCount(int)}\n
//                                            ^^^^^^^^^ definition local 13
//                                                      display_name viewCount
//                                                      signature_documentation java float viewCount
//                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setNumViewsToShowOnScreen().
    numViewsToShowOnScreen = viewCount;
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
//                           ^^^^^^^^^ reference local 13
    setInitialPrefetchItemCount((int) Math.ceil(viewCount));
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setInitialPrefetchItemCount().
//                                    ^^^^ reference semanticdb maven jdk 11 java/lang/Math#
//                                         ^^^^ reference semanticdb maven jdk 11 java/lang/Math#ceil().
//                                              ^^^^^^^^^ reference local 13
  }

  /**
   * @return The number of views to show on screen in this carousel at a time.
   */
  public float getNumViewsToShowOnScreen() {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#getNumViewsToShowOnScreen().
//                                       display_name getNumViewsToShowOnScreen
//                                       signature_documentation java public float getNumViewsToShowOnScreen()
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
//                                        display_name setInitialPrefetchItemCount
//                                        signature_documentation java @ModelProp(group = "prefetch")\npublic void setInitialPrefetchItemCount(int numItemsToPrefetch)
//                                        documentation  If you are using a Linear or Grid layout manager you can use this to set the item prefetch\n count. Only use this if you are not using {@link #setNumViewsToShowOnScreen(float)}\n\n @see #setNumViewsToShowOnScreen(float)\n @see LinearLayoutManager#setInitialPrefetchItemCount(int)\n
//                                            ^^^^^^^^^^^^^^^^^^ definition local 14
//                                                               display_name numItemsToPrefetch
//                                                               signature_documentation java int numItemsToPrefetch
//                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setInitialPrefetchItemCount().
    if (numItemsToPrefetch < 0) {
//      ^^^^^^^^^^^^^^^^^^ reference local 14
      throw new IllegalStateException("numItemsToPrefetch must be greater than 0");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    // Use the linearlayoutmanager default of 2 if the user did not specify one
    int prefetchCount = numItemsToPrefetch == 0 ? 2 : numItemsToPrefetch;
//      ^^^^^^^^^^^^^ definition local 15
//                    display_name prefetchCount
//                    signature_documentation java int prefetchCount
//                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setInitialPrefetchItemCount().
//                      ^^^^^^^^^^^^^^^^^^ reference local 14
//                                                    ^^^^^^^^^^^^^^^^^^ reference local 14

    LayoutManager layoutManager = getLayoutManager();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . LayoutManager#
//                ^^^^^^^^^^^^^ definition local 16
//                              display_name layoutManager
//                              signature_documentation java unresolved_type layoutManager
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setInitialPrefetchItemCount().
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getLayoutManager#
    if (layoutManager instanceof LinearLayoutManager) {
//      ^^^^^^^^^^^^^ reference local 16
//                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . LinearLayoutManager#
      ((LinearLayoutManager) layoutManager).setInitialPrefetchItemCount(prefetchCount);
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . LinearLayoutManager#
//                           ^^^^^^^^^^^^^ reference local 16
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . LinearLayoutManager#setInitialPrefetchItemCount#
//                                                                      ^^^^^^^^^^^^^ reference local 15
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onChildAttachedToWindow(View child) {
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#onChildAttachedToWindow().
//                                    display_name onChildAttachedToWindow
//                                    signature_documentation java @Override\npublic void onChildAttachedToWindow(unresolved_type child)
//                                    ^^^^ reference semanticdb maven . . View#
//                                         ^^^^^ definition local 17
//                                               display_name child
//                                               signature_documentation java unresolved_type child
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#onChildAttachedToWindow().
    if (numViewsToShowOnScreen > 0) {
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
      ViewGroup.LayoutParams childLayoutParams = child.getLayoutParams();
//    ^^^^^^^^^ reference semanticdb maven . . ViewGroup/
//              ^^^^^^^^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#
//                           ^^^^^^^^^^^^^^^^^ definition local 18
//                                             display_name childLayoutParams
//                                             signature_documentation java unresolved_type childLayoutParams
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#onChildAttachedToWindow().
//                                               ^^^^^ reference local 17
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . View#getLayoutParams#
      child.setTag(R.id.epoxy_recycler_view_child_initial_size_id, childLayoutParams.width);
//    ^^^^^ reference local 17
//          ^^^^^^ reference semanticdb maven . . View#setTag#
//                 ^ reference semanticdb maven . . R/
//                   ^^ reference semanticdb maven . . R/id#
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_recycler_view_child_initial_size_id#
//                                                                 ^^^^^^^^^^^^^^^^^ reference local 18
//                                                                                   ^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#width#

      int itemSpacingPx = getSpacingDecorator().getPxBetweenItems();
//        ^^^^^^^^^^^^^ definition local 19
//                      display_name itemSpacingPx
//                      signature_documentation java int itemSpacingPx
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#onChildAttachedToWindow().
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getSpacingDecorator#
//                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getSpacingDecorator#getPxBetweenItems#
      int spaceBetweenItems = 0;
//        ^^^^^^^^^^^^^^^^^ definition local 20
//                          display_name spaceBetweenItems
//                          signature_documentation java int spaceBetweenItems
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#onChildAttachedToWindow().
      if (itemSpacingPx > 0) {
//        ^^^^^^^^^^^^^ reference local 19
        // The item decoration space is not counted in the width of the view
        spaceBetweenItems = (int) (itemSpacingPx * numViewsToShowOnScreen);
//      ^^^^^^^^^^^^^^^^^ reference local 20
//                                 ^^^^^^^^^^^^^ reference local 19
//                                                 ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.
      }

      boolean isScrollingHorizontally = getLayoutManager().canScrollHorizontally();
//            ^^^^^^^^^^^^^^^^^^^^^^^ definition local 21
//                                    display_name isScrollingHorizontally
//                                    signature_documentation java boolean isScrollingHorizontally
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#onChildAttachedToWindow().
//                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getLayoutManager#
//                                                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getLayoutManager#canScrollHorizontally#
      int itemSizeInScrollingDirection =
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 22
//                                     display_name itemSizeInScrollingDirection
//                                     signature_documentation java int itemSizeInScrollingDirection
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#onChildAttachedToWindow().
          (int)
              ((getSpaceForChildren(isScrollingHorizontally) - spaceBetweenItems)
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getSpaceForChildren().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^ reference local 21
//                                                             ^^^^^^^^^^^^^^^^^ reference local 20
                  / numViewsToShowOnScreen);
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#numViewsToShowOnScreen.

      if (isScrollingHorizontally) {
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference local 21
        childLayoutParams.width = itemSizeInScrollingDirection;
//      ^^^^^^^^^^^^^^^^^ reference local 18
//                        ^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#width#
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 22
      } else {
        childLayoutParams.height = itemSizeInScrollingDirection;
//      ^^^^^^^^^^^^^^^^^ reference local 18
//                        ^^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#height#
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 22
      }

      // We don't need to request layout because the layout manager will do that for us next
    }
  }

  private int getSpaceForChildren(boolean horizontal) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#getSpaceForChildren().
//                                display_name getSpaceForChildren
//                                signature_documentation java private int getSpaceForChildren(boolean horizontal)
//                                        ^^^^^^^^^^ definition local 23
//                                                   display_name horizontal
//                                                   signature_documentation java boolean horizontal
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#getSpaceForChildren().
    if (horizontal) {
//      ^^^^^^^^^^ reference local 23
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
//                                   display_name getTotalWidthPx
//                                   signature_documentation java @Px\nprivate static int getTotalWidthPx(unresolved_type view)
//                                   ^^^^ reference semanticdb maven . . View#
//                                        ^^^^ definition local 24
//                                             display_name view
//                                             signature_documentation java unresolved_type view
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#getTotalWidthPx().
    if (view.getWidth() > 0) {
//      ^^^^ reference local 24
//           ^^^^^^^^ reference semanticdb maven . . View#getWidth#
      // Can only get a width if we are laid out
      return view.getWidth();
//           ^^^^ reference local 24
//                ^^^^^^^^ reference semanticdb maven . . View#getWidth#
    }

    if (view.getMeasuredWidth() > 0) {
//      ^^^^ reference local 24
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#getMeasuredWidth#
      return view.getMeasuredWidth();
//           ^^^^ reference local 24
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#getMeasuredWidth#
    }

    // Fall back to assuming we want the full screen width
    DisplayMetrics metrics = view.getContext().getResources().getDisplayMetrics();
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . DisplayMetrics#
//                 ^^^^^^^ definition local 25
//                         display_name metrics
//                         signature_documentation java unresolved_type metrics
//                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#getTotalWidthPx().
//                           ^^^^ reference local 24
//                                ^^^^^^^^^^ reference semanticdb maven . . View#getContext#
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . View#getContext#getResources#
//                                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#getContext#getResources#getDisplayMetrics#
    return metrics.widthPixels;
//         ^^^^^^^ reference local 25
//                 ^^^^^^^^^^^ reference semanticdb maven . . DisplayMetrics#widthPixels#
  }

  @Px
// ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
  private static int getTotalHeightPx(View view) {
//                   ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#getTotalHeightPx().
//                                    display_name getTotalHeightPx
//                                    signature_documentation java @Px\nprivate static int getTotalHeightPx(unresolved_type view)
//                                    ^^^^ reference semanticdb maven . . View#
//                                         ^^^^ definition local 26
//                                              display_name view
//                                              signature_documentation java unresolved_type view
//                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#getTotalHeightPx().
    if (view.getHeight() > 0) {
//      ^^^^ reference local 26
//           ^^^^^^^^^ reference semanticdb maven . . View#getHeight#
      return view.getHeight();
//           ^^^^ reference local 26
//                ^^^^^^^^^ reference semanticdb maven . . View#getHeight#
    }

    if (view.getMeasuredHeight() > 0) {
//      ^^^^ reference local 26
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#getMeasuredHeight#
      return view.getMeasuredHeight();
//           ^^^^ reference local 26
//                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#getMeasuredHeight#
    }

    // Fall back to assuming we want the full screen width
    DisplayMetrics metrics = view.getContext().getResources().getDisplayMetrics();
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . DisplayMetrics#
//                 ^^^^^^^ definition local 27
//                         display_name metrics
//                         signature_documentation java unresolved_type metrics
//                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#getTotalHeightPx().
//                           ^^^^ reference local 26
//                                ^^^^^^^^^^ reference semanticdb maven . . View#getContext#
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . View#getContext#getResources#
//                                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . View#getContext#getResources#getDisplayMetrics#
    return metrics.heightPixels;
//         ^^^^^^^ reference local 27
//                 ^^^^^^^^^^^^ reference semanticdb maven . . DisplayMetrics#heightPixels#
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onChildDetachedFromWindow(View child) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#onChildDetachedFromWindow().
//                                      display_name onChildDetachedFromWindow
//                                      signature_documentation java @Override\npublic void onChildDetachedFromWindow(unresolved_type child)
//                                      ^^^^ reference semanticdb maven . . View#
//                                           ^^^^^ definition local 28
//                                                 display_name child
//                                                 signature_documentation java unresolved_type child
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#onChildDetachedFromWindow().
    // Restore the view width that existed before we modified it
    Object initialWidth = child.getTag(R.id.epoxy_recycler_view_child_initial_size_id);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//         ^^^^^^^^^^^^ definition local 29
//                      display_name initialWidth
//                      signature_documentation java Object initialWidth
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#onChildDetachedFromWindow().
//                        ^^^^^ reference local 28
//                              ^^^^^^ reference semanticdb maven . . View#getTag#
//                                     ^ reference semanticdb maven . . R/
//                                       ^^ reference semanticdb maven . . R/id#
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . R/id#epoxy_recycler_view_child_initial_size_id#

    if (initialWidth instanceof Integer) {
//      ^^^^^^^^^^^^ reference local 29
//                              ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
      ViewGroup.LayoutParams params = child.getLayoutParams();
//    ^^^^^^^^^ reference semanticdb maven . . ViewGroup/
//              ^^^^^^^^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#
//                           ^^^^^^ definition local 30
//                                  display_name params
//                                  signature_documentation java unresolved_type params
//                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#onChildDetachedFromWindow().
//                                    ^^^^^ reference local 28
//                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . View#getLayoutParams#
      params.width = (int) initialWidth;
//    ^^^^^^ reference local 30
//           ^^^^^ reference semanticdb maven . . ViewGroup/LayoutParams#width#
//                         ^^^^^^^^^^^^ reference local 29
      child.setTag(R.id.epoxy_recycler_view_child_initial_size_id, null);
//    ^^^^^ reference local 28
//          ^^^^^^ reference semanticdb maven . . View#setTag#
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
//                                           display_name setDefaultItemSpacingDp
//                                           signature_documentation java public static void setDefaultItemSpacingDp(int dp)
//                                           documentation  Set a global default to use as the item spacing for all Carousels. Set to 0 for no item\n spacing.\n
//                                            ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                                      ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                                                             ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                                                       ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                                                               ^^ definition local 31
//                                                                                  display_name dp
//                                                                                  signature_documentation java @Dimension(unit = Dimension.DP)\nint dp
//                                                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setDefaultItemSpacingDp().
    defaultSpacingBetweenItemsDp = dp;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#defaultSpacingBetweenItemsDp.
//                                 ^^ reference local 31
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
//                                              display_name getDefaultSpacingBetweenItemsDp
//                                              signature_documentation java @Dimension(unit = Dimension.DP)\nprotected int getDefaultSpacingBetweenItemsDp()
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
//                          display_name setPaddingRes
//                          signature_documentation java @ModelProp(group = "padding")\npublic void setPaddingRes(int paddingRes)
//                          documentation  Set a dimension resource to specify the padding value to use on each side of the carousel and\n in between carousel items.\n
//                           ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                                        ^^^^^^^^^^ definition local 32
//                                                   display_name paddingRes
//                                                   signature_documentation java @DimenRes\nint paddingRes
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setPaddingRes().
    int px = resToPx(paddingRes);
//      ^^ definition local 33
//         display_name px
//         signature_documentation java int px
//         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setPaddingRes().
//           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                   ^^^^^^^^^^ reference local 32
    setPadding(px, px, px, px);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
//             ^^ reference local 33
//                 ^^ reference local 33
//                     ^^ reference local 33
//                         ^^ reference local 33
    setItemSpacingPx(px);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                   ^^ reference local 33
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
//                         display_name setPaddingDp
//                         signature_documentation java @ModelProp(defaultValue = "NO_VALUE_SET", group = "padding")\npublic void setPaddingDp(int paddingDp)
//                         documentation  Set a DP value to use as the padding on each side of the carousel and in between carousel\n items.\n\n <p>The default as the value returned by {@link #getDefaultSpacingBetweenItemsDp()}\n
//                          ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                    ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                                           ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                                     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                                             ^^^^^^^^^ definition local 34
//                                                                       display_name paddingDp
//                                                                       signature_documentation java @Dimension(unit = Dimension.DP)\nint paddingDp
//                                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setPaddingDp().
    int px = dpToPx(paddingDp != NO_VALUE_SET ? paddingDp : getDefaultSpacingBetweenItemsDp());
//      ^^ definition local 35
//         display_name px
//         signature_documentation java int px
//         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setPaddingDp().
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                  ^^^^^^^^^ reference local 34
//                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#NO_VALUE_SET.
//                                              ^^^^^^^^^ reference local 34
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#getDefaultSpacingBetweenItemsDp().
    setPadding(px, px, px, px);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
//             ^^ reference local 35
//                 ^^ reference local 35
//                     ^^ reference local 35
//                         ^^ reference local 35
    setItemSpacingPx(px);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                   ^^ reference local 35
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
//                       display_name setPadding
//                       signature_documentation java @ModelProp(group = "padding")\npublic void setPadding(Padding padding)
//                       documentation  Use the {@link Padding} class to specify individual padding values for each side of the\n carousel, as well as item spacing.\n\n <p>A value of null will set all padding and item spacing to 0.\n
//                        ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                 ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                         ^^^^^^^ definition local 36
//                                                 display_name padding
//                                                 signature_documentation java @Nullable\nPadding padding
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding().
    if (padding == null) {
//      ^^^^^^^ reference local 36
      setPaddingDp(0);
//    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPaddingDp().
    } else if (padding.paddingType == Padding.PaddingType.PX) {
//             ^^^^^^^ reference local 36
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                        ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#PX.
      setPadding(padding.left, padding.top, padding.right, padding.bottom);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
//               ^^^^^^^ reference local 36
//                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                             ^^^^^^^ reference local 36
//                                     ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//                                          ^^^^^^^ reference local 36
//                                                  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                                                         ^^^^^^^ reference local 36
//                                                                 ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
      setItemSpacingPx(padding.itemSpacing);
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                     ^^^^^^^ reference local 36
//                             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    } else if (padding.paddingType == Padding.PaddingType.DP) {
//             ^^^^^^^ reference local 36
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                        ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#DP.
      setPadding(
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
          dpToPx(padding.left), dpToPx(padding.top), dpToPx(padding.right), dpToPx(padding.bottom));
//        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//               ^^^^^^^ reference local 36
//                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                              ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                                     ^^^^^^^ reference local 36
//                                             ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//                                                   ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                                                          ^^^^^^^ reference local 36
//                                                                  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                                                                          ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                                                                                 ^^^^^^^ reference local 36
//                                                                                         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
      setItemSpacingPx(dpToPx(padding.itemSpacing));
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#dpToPx#
//                            ^^^^^^^ reference local 36
//                                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    } else if (padding.paddingType == Padding.PaddingType.RESOURCE) {
//             ^^^^^^^ reference local 36
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE.
      setPadding(
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setPadding#
          resToPx(padding.left),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local 36
//                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
          resToPx(padding.top),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local 36
//                        ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
          resToPx(padding.right),
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local 36
//                        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
          resToPx(padding.bottom));
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                ^^^^^^^ reference local 36
//                        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
      setItemSpacingPx(resToPx(padding.itemSpacing));
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#setItemSpacingPx#
//                     ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#resToPx#
//                             ^^^^^^^ reference local 36
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
//                            display_name Padding
//                            signature_documentation java public static class Padding
//                            documentation  Used to specify individual padding values programmatically.\n\n @see #setPadding(Padding)\n
    public final int left;
//                   ^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                        display_name left
//                        signature_documentation java public final int left
    public final int top;
//                   ^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//                       display_name top
//                       signature_documentation java public final int top
    public final int right;
//                   ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                         display_name right
//                         signature_documentation java public final int right
    public final int bottom;
//                   ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
//                          display_name bottom
//                          signature_documentation java public final int bottom
    public final int itemSpacing;
//                   ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
//                               display_name itemSpacing
//                               signature_documentation java public final int itemSpacing
    public final PaddingType paddingType;
//               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                                       display_name paddingType
//                                       signature_documentation java public final PaddingType paddingType

    enum PaddingType {
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                   display_name PaddingType
//                   signature_documentation java enum PaddingType
//                   relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                   relationship is_implementation semanticdb maven jdk 11 java/lang/Comparable#
//                   relationship is_implementation semanticdb maven jdk 11 java/lang/Enum#
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#`<init>`().
//                   display_name <init>
//                   signature_documentation java private PaddingType()
      PX,
//    ^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#PX.
//       display_name PX
//       signature_documentation java PaddingType.PX /* ordinal 0 */
//    ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#`<init>`().
      DP,
//    ^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#DP.
//       display_name DP
//       signature_documentation java PaddingType.DP /* ordinal 1 */
//    ^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#`<init>`().
      RESOURCE
//    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#RESOURCE.
//             display_name RESOURCE
//             signature_documentation java PaddingType.RESOURCE /* ordinal 2 */
//    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#`<init>`().
    }

    /**
     * @param paddingRes Padding as dimension resource.
     * @param itemSpacingRes Space as dimension resource to add between each carousel item. Will be
     *     implemented via an item decoration.
     */
    public static Padding resource(@DimenRes int paddingRes, @DimenRes int itemSpacingRes) {
//                ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource().
//                                 display_name resource
//                                 signature_documentation java public static Padding resource(int paddingRes, int itemSpacingRes)
//                                 documentation  @param paddingRes Padding as dimension resource.\n @param itemSpacingRes Space as dimension resource to add between each carousel item. Will be\n     implemented via an item decoration.\n
//                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                                               ^^^^^^^^^^ definition local 37
//                                                          display_name paddingRes
//                                                          signature_documentation java @DimenRes\nint paddingRes
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource().
//                                                            ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                                                                         ^^^^^^^^^^^^^^ definition local 38
//                                                                                        display_name itemSpacingRes
//                                                                                        signature_documentation java @DimenRes\nint itemSpacingRes
//                                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource().
      return new Padding(
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
          paddingRes, paddingRes, paddingRes, paddingRes, itemSpacingRes, PaddingType.RESOURCE);
//        ^^^^^^^^^^ reference local 37
//                    ^^^^^^^^^^ reference local 37
//                                ^^^^^^^^^^ reference local 37
//                                            ^^^^^^^^^^ reference local 37
//                                                        ^^^^^^^^^^^^^^ reference local 38
//                                                                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
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
//                                 display_name resource
//                                 signature_documentation java public static Padding resource(int leftRes, int topRes, int rightRes, int bottomRes, int itemSpacingRes)
//                                 documentation  @param leftRes Left padding as dimension resource.\n @param topRes Top padding as dimension resource.\n @param rightRes Right padding as dimension resource.\n @param bottomRes Bottom padding as dimension resource.\n @param itemSpacingRes Space as dimension resource to add between each carousel item. Will be\n     implemented via an item decoration.\n
        @DimenRes int leftRes,
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^^ definition local 39
//                            display_name leftRes
//                            signature_documentation java @DimenRes\nint leftRes
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource(+1).
        @DimenRes int topRes,
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^ definition local 40
//                           display_name topRes
//                           signature_documentation java @DimenRes\nint topRes
//                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource(+1).
        @DimenRes int rightRes,
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^^^ definition local 41
//                             display_name rightRes
//                             signature_documentation java @DimenRes\nint rightRes
//                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource(+1).
        @DimenRes int bottomRes,
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^^^^ definition local 42
//                              display_name bottomRes
//                              signature_documentation java @DimenRes\nint bottomRes
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource(+1).
        @DimenRes int itemSpacingRes) {
//       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
//                    ^^^^^^^^^^^^^^ definition local 43
//                                   display_name itemSpacingRes
//                                   signature_documentation java @DimenRes\nint itemSpacingRes
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#resource(+1).
      return new Padding(
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
          leftRes, topRes, rightRes, bottomRes, itemSpacingRes, PaddingType.RESOURCE);
//        ^^^^^^^ reference local 39
//                 ^^^^^^ reference local 40
//                         ^^^^^^^^ reference local 41
//                                   ^^^^^^^^^ reference local 42
//                                              ^^^^^^^^^^^^^^ reference local 43
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
//                           display_name dp
//                           signature_documentation java public static Padding dp(int paddingDp, int itemSpacingDp)
//                           documentation  @param paddingDp Padding in dp.\n @param itemSpacingDp Space in dp to add between each carousel item. Will be implemented via\n     an item decoration.\n
        @Dimension(unit = Dimension.DP) int paddingDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^^ definition local 44
//                                                    display_name paddingDp
//                                                    signature_documentation java @Dimension(unit = Dimension.DP)\nint paddingDp
//                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#dp().
        @Dimension(unit = Dimension.DP) int itemSpacingDp) {
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^^^^^^ definition local 45
//                                                        display_name itemSpacingDp
//                                                        signature_documentation java @Dimension(unit = Dimension.DP)\nint itemSpacingDp
//                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#dp().
      return new Padding(paddingDp, paddingDp, paddingDp, paddingDp, itemSpacingDp, PaddingType.DP);
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                       ^^^^^^^^^ reference local 44
//                                  ^^^^^^^^^ reference local 44
//                                             ^^^^^^^^^ reference local 44
//                                                        ^^^^^^^^^ reference local 44
//                                                                   ^^^^^^^^^^^^^ reference local 45
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
//                           display_name dp
//                           signature_documentation java public static Padding dp(int leftDp, int topDp, int rightDp, int bottomDp, int itemSpacingDp)
//                           documentation  @param leftDp Left padding in dp.\n @param topDp Top padding in dp.\n @param rightDp Right padding in dp.\n @param bottomDp Bottom padding in dp.\n @param itemSpacingDp Space in dp to add between each carousel item. Will be implemented via\n     an item decoration.\n
        @Dimension(unit = Dimension.DP) int leftDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^ definition local 46
//                                                 display_name leftDp
//                                                 signature_documentation java @Dimension(unit = Dimension.DP)\nint leftDp
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#dp(+1).
        @Dimension(unit = Dimension.DP) int topDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^ definition local 47
//                                                display_name topDp
//                                                signature_documentation java @Dimension(unit = Dimension.DP)\nint topDp
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#dp(+1).
        @Dimension(unit = Dimension.DP) int rightDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^ definition local 48
//                                                  display_name rightDp
//                                                  signature_documentation java @Dimension(unit = Dimension.DP)\nint rightDp
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#dp(+1).
        @Dimension(unit = Dimension.DP) int bottomDp,
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^ definition local 49
//                                                   display_name bottomDp
//                                                   signature_documentation java @Dimension(unit = Dimension.DP)\nint bottomDp
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#dp(+1).
        @Dimension(unit = Dimension.DP) int itemSpacingDp) {
//       ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                 ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#unit().
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                          ^^^^^^^^^^^^^ definition local 50
//                                                        display_name itemSpacingDp
//                                                        signature_documentation java @Dimension(unit = Dimension.DP)\nint itemSpacingDp
//                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#dp(+1).
      return new Padding(leftDp, topDp, rightDp, bottomDp, itemSpacingDp, PaddingType.DP);
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                       ^^^^^^ reference local 46
//                               ^^^^^ reference local 47
//                                      ^^^^^^^ reference local 48
//                                               ^^^^^^^^ reference local 49
//                                                         ^^^^^^^^^^^^^ reference local 50
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
//                 display_name <init>
//                 signature_documentation java public Padding(int paddingPx, int itemSpacingPx)
//                 documentation  @param paddingPx Padding in pixels to add on all sides of the carousel\n @param itemSpacingPx Space in pixels to add between each carousel item. Will be implemented\n     via an item decoration.\n
//                  ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                         ^^^^^^^^^ definition local 51
//                                   display_name paddingPx
//                                   signature_documentation java @Px\nint paddingPx
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`().
//                                     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                            ^^^^^^^^^^^^^ definition local 52
//                                                          display_name itemSpacingPx
//                                                          signature_documentation java @Px\nint itemSpacingPx
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`().
      this(paddingPx, paddingPx, paddingPx, paddingPx, itemSpacingPx, PaddingType.PX);
//    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//         ^^^^^^^^^ reference local 51
//                    ^^^^^^^^^ reference local 51
//                               ^^^^^^^^^ reference local 51
//                                          ^^^^^^^^^ reference local 51
//                                                     ^^^^^^^^^^^^^ reference local 52
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
//                 display_name <init>
//                 signature_documentation java public Padding(int leftPx, int topPx, int rightPx, int bottomPx, int itemSpacingPx)
//                 documentation  @param leftPx Left padding in pixels.\n @param topPx Top padding in pixels.\n @param rightPx Right padding in pixels.\n @param bottomPx Bottom padding in pixels.\n @param itemSpacingPx Space in pixels to add between each carousel item. Will be implemented\n     via an item decoration.\n
        @Px int leftPx, @Px int topPx, @Px int rightPx, @Px int bottomPx, @Px int itemSpacingPx) {
//       ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//              ^^^^^^ definition local 53
//                     display_name leftPx
//                     signature_documentation java @Px\nint leftPx
//                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+1).
//                       ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                              ^^^^^ definition local 54
//                                    display_name topPx
//                                    signature_documentation java @Px\nint topPx
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+1).
//                                      ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                             ^^^^^^^ definition local 55
//                                                     display_name rightPx
//                                                     signature_documentation java @Px\nint rightPx
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+1).
//                                                       ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                                              ^^^^^^^^ definition local 56
//                                                                       display_name bottomPx
//                                                                       signature_documentation java @Px\nint bottomPx
//                                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+1).
//                                                                         ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//                                                                                ^^^^^^^^^^^^^ definition local 57
//                                                                                              display_name itemSpacingPx
//                                                                                              signature_documentation java @Px\nint itemSpacingPx
//                                                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+1).
      this(leftPx, topPx, rightPx, bottomPx, itemSpacingPx, PaddingType.PX);
//    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//         ^^^^^^ reference local 53
//                 ^^^^^ reference local 54
//                        ^^^^^^^ reference local 55
//                                 ^^^^^^^^ reference local 56
//                                           ^^^^^^^^^^^^^ reference local 57
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
//                  display_name <init>
//                  signature_documentation java private Padding(int left, int top, int right, int bottom, int itemSpacing, PaddingType paddingType)
//                  documentation  @param left Left padding.\n @param top Top padding.\n @param right Right padding.\n @param bottom Bottom padding.\n @param itemSpacing Space to add between each carousel item. Will be implemented via an item\n     decoration.\n @param paddingType Unit / Type of the given paddings/ itemspacing.\n
        int left, int top, int right, int bottom, int itemSpacing, PaddingType paddingType) {
//          ^^^^ definition local 58
//               display_name left
//               signature_documentation java int left
//               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                    ^^^ definition local 59
//                        display_name top
//                        signature_documentation java int top
//                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                             ^^^^^ definition local 60
//                                   display_name right
//                                   signature_documentation java int right
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                                        ^^^^^^ definition local 61
//                                               display_name bottom
//                                               signature_documentation java int bottom
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                                                    ^^^^^^^^^^^ definition local 62
//                                                                display_name itemSpacing
//                                                                signature_documentation java int itemSpacing
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).
//                                                                 ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#PaddingType#
//                                                                             ^^^^^^^^^^^ definition local 63
//                                                                                         display_name paddingType
//                                                                                         signature_documentation java PaddingType paddingType
//                                                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#`<init>`(+2).

      this.left = left;
//         ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                ^^^^ reference local 58
      this.top = top;
//         ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//               ^^^ reference local 59
      this.right = right;
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                 ^^^^^ reference local 60
      this.bottom = bottom;
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
//                  ^^^^^^ reference local 61
      this.itemSpacing = itemSpacing;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
//                       ^^^^^^^^^^^ reference local 62
      this.paddingType = paddingType;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#paddingType.
//                       ^^^^^^^^^^^ reference local 63
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean equals(Object o) {
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#equals().
//                        display_name equals
//                        signature_documentation java @Override\npublic boolean equals(Object o)
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                               ^ definition local 64
//                                 display_name o
//                                 signature_documentation java Object o
//                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#equals().
      if (this == o) {
//                ^ reference local 64
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
//        ^ reference local 64
//                     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
//                                   ^ reference local 64
//                                     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
        return false;
      }

      Padding padding = (Padding) o;
//    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//            ^^^^^^^ definition local 65
//                    display_name padding
//                    signature_documentation java Padding padding
//                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#equals().
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#
//                                ^ reference local 64

      if (left != padding.left) {
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
//                ^^^^^^^ reference local 65
//                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
        return false;
      }
      if (top != padding.top) {
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
//               ^^^^^^^ reference local 65
//                       ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
        return false;
      }
      if (right != padding.right) {
//        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
//                 ^^^^^^^ reference local 65
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
        return false;
      }
      if (bottom != padding.bottom) {
//        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
//                  ^^^^^^^ reference local 65
//                          ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
        return false;
      }
      return itemSpacing == padding.itemSpacing;
//           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
//                          ^^^^^^^ reference local 65
//                                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public int hashCode() {
//             ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#hashCode().
//                      display_name hashCode
//                      signature_documentation java @Override\npublic int hashCode()
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
      int result = left;
//        ^^^^^^ definition local 66
//               display_name result
//               signature_documentation java int result
//               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#hashCode().
//                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#left.
      result = 31 * result + top;
//    ^^^^^^ reference local 66
//                  ^^^^^^ reference local 66
//                           ^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#top.
      result = 31 * result + right;
//    ^^^^^^ reference local 66
//                  ^^^^^^ reference local 66
//                           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#right.
      result = 31 * result + bottom;
//    ^^^^^^ reference local 66
//                  ^^^^^^ reference local 66
//                           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#bottom.
      result = 31 * result + itemSpacing;
//    ^^^^^^ reference local 66
//                  ^^^^^^ reference local 66
//                           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/Carousel#Padding#itemSpacing.
      return result;
//           ^^^^^^ reference local 66
    }
  }

  @ModelProp
// ^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/ModelProp#
  public void setModels(@NonNull List<? extends EpoxyModel<?>> models) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#setModels().
//                      display_name setModels
//                      signature_documentation java @ModelProp\npublic void setModels(List<? extends EpoxyModel<?>> models)
//                       ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                               ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                             ^^^^^^ definition local 67
//                                                                    display_name models
//                                                                    signature_documentation java @NonNull\nList<? extends EpoxyModel<?>> models
//                                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#setModels().
    super.setModels(models);
//  ^^^^^ reference semanticdb maven . . super#
//        ^^^^^^^^^ reference semanticdb maven . . super#setModels#
//                  ^^^^^^ reference local 67
  }

  @OnViewRecycled
// ^^^^^^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/OnViewRecycled#
  public void clear() {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#clear().
//                  display_name clear
//                  signature_documentation java @OnViewRecycled\npublic void clear()
    super.clear();
//  ^^^^^ reference semanticdb maven . . super#
//        ^^^^^ reference semanticdb maven . . super#clear#
  }

  /** Provide a SnapHelper implementation you want to use with a Carousel. */
  public abstract static class SnapHelperFactory {
//                             ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#
//                                               display_name SnapHelperFactory
//                                               signature_documentation java public abstract static class SnapHelperFactory
//                                               documentation Provide a SnapHelper implementation you want to use with a Carousel. 
//                             ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#`<init>`().
//                                               display_name <init>
//                                               signature_documentation java public SnapHelperFactory()
    /**
     * Create and return a new instance of a {@link androidx.recyclerview.widget.SnapHelper} for use
     * with a Carousel.
     */
    @NonNull
//   ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
    public abstract SnapHelper buildSnapHelper(Context context);
//                  ^^^^^^^^^^ reference semanticdb maven . . SnapHelper#
//                             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#buildSnapHelper().
//                                             display_name buildSnapHelper
//                                             signature_documentation java @NonNull\npublic abstract unresolved_type buildSnapHelper(unresolved_type context)
//                                             documentation  Create and return a new instance of a {@link androidx.recyclerview.widget.SnapHelper} for use\n with a Carousel.\n
//                                             ^^^^^^^ reference semanticdb maven . . Context#
//                                                     ^^^^^^^ definition local 68
//                                                             display_name context
//                                                             signature_documentation java unresolved_type context
//                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/Carousel#SnapHelperFactory#buildSnapHelper().
  }
}
