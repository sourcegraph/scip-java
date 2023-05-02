package com.airbnb.epoxy;

import android.view.LayoutInflater;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . android/view/LayoutInflater#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#
import android.view.ViewGroup;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^ reference semanticdb maven . . android/view/ViewGroup#

import com.airbnb.epoxy.EpoxyController.ModelInterceptorCallback;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
import com.airbnb.epoxy.VisibilityState.Visibility;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#

import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.annotation.FloatRange;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
import androidx.annotation.LayoutRes;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
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

import static com.airbnb.epoxy.IdUtils.hashLong64Bit;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#
import static com.airbnb.epoxy.IdUtils.hashString64Bit;
//            ^^^ reference semanticdb maven . . com/
//                ^^^^^^ reference semanticdb maven . . com/airbnb/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#

/**
 * Helper to bind data to a view using a builder style. The parameterized type should extend
 * Android's View or EpoxyHolder.
 *
 * @see EpoxyModelWithHolder
 * @see EpoxyModelWithView
 */
public abstract class EpoxyModel<T> {
//                    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                               documentation ```java\npublic abstract class EpoxyModel<T>\n```
//                               documentation  Helper to bind data to a view using a builder style. The parameterized type should extend\n Android's View or EpoxyHolder.\n\n @see EpoxyModelWithHolder\n @see EpoxyModelWithView\n
//                               ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                                 documentation ```java\nT\n```

  /**
   * Counts how many of these objects are created, so that each new object can have a unique id .
   * Uses negative values so that these autogenerated ids don't clash with database ids that may be
   * set with {@link #id(long)}
   */
  private static long idCounter = -1;
//                    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#idCounter.
//                              documentation ```java\nprivate static long idCounter\n```
//                              documentation  Counts how many of these objects are created, so that each new object can have a unique id .\n Uses negative values so that these autogenerated ids don't clash with database ids that may be\n set with {@link #id(long)}\n

  /**
   * An id that can be used to uniquely identify this {@link EpoxyModel} for use in RecyclerView
   * stable ids. It defaults to a unique id for this object instance, if you want to maintain the
   * same id across instances use {@link #id(long)}
   */
  private long id;
//             ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id.
//                documentation ```java\nprivate long id\n```
//                documentation  An id that can be used to uniquely identify this {@link EpoxyModel} for use in RecyclerView\n stable ids. It defaults to a unique id for this object instance, if you want to maintain the\n same id across instances use {@link #id(long)}\n
  @LayoutRes private int layout;
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
//                       ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#layout.
//                              documentation ```java\n@LayoutRes\nprivate int layout\n```
  private boolean shown = true;
//                ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shown.
//                      documentation ```java\nprivate boolean shown\n```
  /**
   * Set to true once this model is diffed in an adapter. Used to ensure that this model's id
   * doesn't change after being diffed.
   */
  boolean addedToAdapter;
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addedToAdapter.
//                       documentation ```java\nboolean addedToAdapter\n```
//                       documentation  Set to true once this model is diffed in an adapter. Used to ensure that this model's id\n doesn't change after being diffed.\n
  /**
   * The first controller this model was added to. A reference is kept in debug mode in order to run
   * validations. The model is allowed to be added to other controllers, but we only keep a
   * reference to the first.
   */
  private EpoxyController firstControllerAddedTo;
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#firstControllerAddedTo.
//                                               documentation ```java\nprivate EpoxyController firstControllerAddedTo\n```
//                                               documentation  The first controller this model was added to. A reference is kept in debug mode in order to run\n validations. The model is allowed to be added to other controllers, but we only keep a\n reference to the first.\n
  /**
   * Models are staged when they are changed. This allows them to be automatically added when they
   * are done being changed (eg the next model is changed/added or buildModels finishes). It is only
   * allowed for AutoModels, and only if implicit adding is enabled.
   */
  EpoxyController controllerToStageTo;
//^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
//                                    documentation ```java\nEpoxyController controllerToStageTo\n```
//                                    documentation  Models are staged when they are changed. This allows them to be automatically added when they\n are done being changed (eg the next model is changed/added or buildModels finishes). It is only\n allowed for AutoModels, and only if implicit adding is enabled.\n
  private boolean currentlyInInterceptors;
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#currentlyInInterceptors.
//                                        documentation ```java\nprivate boolean currentlyInInterceptors\n```
  private int hashCodeWhenAdded;
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCodeWhenAdded.
//                              documentation ```java\nprivate int hashCodeWhenAdded\n```
  private boolean hasDefaultId;
//                ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hasDefaultId.
//                             documentation ```java\nprivate boolean hasDefaultId\n```
  @Nullable private SpanSizeOverrideCallback spanSizeOverride;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#SpanSizeOverrideCallback#
//                                           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#spanSizeOverride.
//                                                            documentation ```java\n@Nullable\nprivate SpanSizeOverrideCallback spanSizeOverride\n```

  protected EpoxyModel(long id) {
//          ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#`<init>`().
//                     documentation ```java\nprotected EpoxyModel(long id)\n```
//                          ^^ definition local 0
//                             documentation ```java\nlong id\n```
    id(id);
//  ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+1).
//     ^^ reference local 0
  }

  public EpoxyModel() {
//       ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#`<init>`(+1).
//                  documentation ```java\npublic EpoxyModel()\n```
    this(idCounter--);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#`<init>`().
//       ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#idCounter.
    hasDefaultId = true;
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hasDefaultId.
  }

  boolean hasDefaultId() {
//        ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hasDefaultId().
//                     documentation ```java\nboolean hasDefaultId()\n```
    return hasDefaultId;
//         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hasDefaultId.
  }

  /**
   * Get the view type to associate with this model in the recyclerview. For models that use a
   * layout resource, the view type is simply the layout resource value by default.
   * <p>
   * If this returns 0 Epoxy will assign a unique view type for this model at run time.
   *
   * @see androidx.recyclerview.widget.RecyclerView.Adapter#getItemViewType(int)
   */
  protected int getViewType() {
//              ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getViewType().
//                          documentation ```java\nprotected int getViewType()\n```
//                          documentation  Get the view type to associate with this model in the recyclerview. For models that use a\n layout resource, the view type is simply the layout resource value by default.\n <p>\n If this returns 0 Epoxy will assign a unique view type for this model at run time.\n\n @see androidx.recyclerview.widget.RecyclerView.Adapter#getItemViewType(int)\n
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#getViewType().
    return getLayout();
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getLayout().
  }

  /**
   * Create and return a new instance of a view for this model. By default a view is created by
   * inflating the layout resource.
   */
  protected View buildView(@NonNull ViewGroup parent) {
//          ^^^^ reference semanticdb maven . . _root_/
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#buildView().
//                         documentation ```java\nprotected unresolved_type buildView(unresolved_type parent)\n```
//                         documentation  Create and return a new instance of a view for this model. By default a view is created by\n inflating the layout resource.\n
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#buildView().
//                          ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                  ^^^^^^^^^ reference semanticdb maven . . _root_/
//                                            ^^^^^^ definition local 1
//                                                   documentation ```java\n@NonNull\nunresolved_type parent\n```
    return LayoutInflater.from(parent.getContext()).inflate(getLayout(), parent, false);
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
//                        ^^^^ reference semanticdb maven . . from#
//                             ^^^^^^ reference local 1
//                                    ^^^^^^^^^^ reference semanticdb maven . . getContext#
//                                                  ^^^^^^^ reference semanticdb maven . . `<any>`#inflate#
//                                                          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getLayout().
//                                                                       ^^^^^^ reference local 1
  }

  /**
   * Binds the current data to the given view. You should bind all fields including unset/empty
   * fields to ensure proper recycling.
   */
  public void bind(@NonNull T view) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//                 documentation ```java\npublic void bind(T view)\n```
//                 documentation  Binds the current data to the given view. You should bind all fields including unset/empty\n fields to ensure proper recycling.\n
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind().
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind().
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#bind().
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                            ^^^^ definition local 2
//                                 documentation ```java\n@NonNull\nT view\n```

  }

  /**
   * Similar to {@link #bind(Object)}, but provides a non null, non empty list of payloads
   * describing what changed. This is the payloads list specified in the adapter's notifyItemChanged
   * method. This is a useful optimization to allow you to only change part of a view instead of
   * updating the whole thing, which may prevent unnecessary layout calls. If there are no payloads
   * then {@link #bind(Object)} is called instead. This will only be used if the model is used with
   * an {@link EpoxyAdapter}
   */
  public void bind(@NonNull T view, @NonNull List<Object> payloads) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+1).
//                 documentation ```java\npublic void bind(T view, List<Object> payloads)\n```
//                 documentation  Similar to {@link #bind(Object)}, but provides a non null, non empty list of payloads\n describing what changed. This is the payloads list specified in the adapter's notifyItemChanged\n method. This is a useful optimization to allow you to only change part of a view instead of\n updating the whole thing, which may prevent unnecessary layout calls. If there are no payloads\n then {@link #bind(Object)} is called instead. This will only be used if the model is used with\n an {@link EpoxyAdapter}\n
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind(+1).
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+1).
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                            ^^^^ definition local 3
//                                 documentation ```java\n@NonNull\nT view\n```
//                                   ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                           ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                        ^^^^^^^^ definition local 4
//                                                                 documentation ```java\n@NonNull\nList<Object> payloads\n```
    bind(view);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//       ^^^^ reference local 3
  }

  /**
   * Similar to {@link #bind(Object)}, but provides a non null model which was previously bound to
   * this view. This will only be called if the model is used with an {@link EpoxyController}.
   *
   * @param previouslyBoundModel This is a model with the same id that was previously bound. You can
   *                             compare this previous model with the current one to see exactly
   *                             what changed.
   *                             <p>
   *                             This model and the previously bound model are guaranteed to have
   *                             the same id, but will not necessarily be of the same type depending
   *                             on your implementation of {@link EpoxyController#buildModels()}.
   *                             With common usage patterns of Epoxy they should be the same type,
   *                             and will only differ if you are using different model classes with
   *                             the same id.
   *                             <p>
   *                             Comparing the newly bound model with the previous model allows you
   *                             to be more intelligent when binding your view. This may help you
   *                             optimize view binding, or make it easier to work with animations.
   *                             <p>
   *                             If the new model and the previous model have the same view type
   *                             (given by {@link EpoxyModel#getViewType()}), and if you are using
   *                             the default ReyclerView item animator, the same view will be
   *                             reused. This means that you only need to update the view to reflect
   *                             the data that changed. If you are using a custom item animator then
   *                             the view will be the same if the animator returns true in
   *                             canReuseUpdatedViewHolder.
   *                             <p>
   *                             This previously bound model is taken as a payload from the diffing
   *                             process, and follows the same general conditions for all
   *                             recyclerview change payloads.
   */
  public void bind(@NonNull T view, @NonNull EpoxyModel<?> previouslyBoundModel) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+2).
//                 documentation ```java\npublic void bind(T view, EpoxyModel<?> previouslyBoundModel)\n```
//                 documentation  Similar to {@link #bind(Object)}, but provides a non null model which was previously bound to\n this view. This will only be called if the model is used with an {@link EpoxyController}.\n\n @param previouslyBoundModel This is a model with the same id that was previously bound. You can\n                             compare this previous model with the current one to see exactly\n                             what changed.\n                             <p>\n                             This model and the previously bound model are guaranteed to have\n                             the same id, but will not necessarily be of the same type depending\n                             on your implementation of {@link EpoxyController#buildModels()}.\n                             With common usage patterns of Epoxy they should be the same type,\n                             and will only differ if you are using different model classes with\n                             the same id.\n                             <p>\n                             Comparing the newly bound model with the previous model allows you\n                             to be more intelligent when binding your view. This may help you\n                             optimize view binding, or make it easier to work with animations.\n                             <p>\n                             If the new model and the previous model have the same view type\n                             (given by {@link EpoxyModel#getViewType()}), and if you are using\n                             the default ReyclerView item animator, the same view will be\n                             reused. This means that you only need to update the view to reflect\n                             the data that changed. If you are using a custom item animator then\n                             the view will be the same if the animator returns true in\n                             canReuseUpdatedViewHolder.\n                             <p>\n                             This previously bound model is taken as a payload from the diffing\n                             process, and follows the same general conditions for all\n                             recyclerview change payloads.\n
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind(+2).
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+2).
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                            ^^^^ definition local 5
//                                 documentation ```java\n@NonNull\nT view\n```
//                                   ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                         ^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                                                              documentation ```java\n@NonNull\nEpoxyModel<?> previouslyBoundModel\n```
    bind(view);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//       ^^^^ reference local 5
  }

  /**
   * Called when the view bound to this model is recycled. Subclasses can override this if their
   * view should release resources when it's recycled.
   * <p>
   * Note that {@link #bind(Object)} can be called multiple times without an unbind call in between
   * if the view has remained on screen to be reused across item changes. This means that you should
   * not rely on unbind to clear a view or model's state before bind is called again.
   *
   * @see EpoxyAdapter#onViewRecycled(EpoxyViewHolder)
   */
  public void unbind(@NonNull T view) {
//            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#unbind().
//                   documentation ```java\npublic void unbind(T view)\n```
//                   documentation  Called when the view bound to this model is recycled. Subclasses can override this if their\n view should release resources when it's recycled.\n <p>\n Note that {@link #bind(Object)} can be called multiple times without an unbind call in between\n if the view has remained on screen to be reused across item changes. This means that you should\n not rely on unbind to clear a view or model's state before bind is called again.\n\n @see EpoxyAdapter#onViewRecycled(EpoxyViewHolder)\n
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#unbind().
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#unbind().
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#unbind().
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                              ^^^^ definition local 7
//                                   documentation ```java\n@NonNull\nT view\n```
  }

  /**
   * TODO link to the wiki
   *
   * @see OnVisibilityStateChanged annotation
   */
  public void onVisibilityStateChanged(@Visibility int visibilityState, @NonNull T view) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityStateChanged().
//                                     documentation ```java\npublic void onVisibilityStateChanged(int visibilityState, T view)\n```
//                                     documentation  TODO link to the wiki\n\n @see OnVisibilityStateChanged annotation\n
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityStateChanged().
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#
//                                                     ^^^^^^^^^^^^^^^ definition local 8
//                                                                     documentation ```java\n@Visibility\nint visibilityState\n```
//                                                                       ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                               ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                                                                                 ^^^^ definition local 9
//                                                                                      documentation ```java\n@NonNull\nT view\n```
  }

  /**
   * TODO link to the wiki
   *
   * @see OnVisibilityChanged annotation
   */
  public void onVisibilityChanged(
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityChanged().
//                                documentation ```java\npublic void onVisibilityChanged(float percentVisibleHeight, float percentVisibleWidth, int visibleHeight, int visibleWidth, T view)\n```
//                                documentation  TODO link to the wiki\n\n @see OnVisibilityChanged annotation\n
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onVisibilityChanged().
      @FloatRange(from = 0.0f, to = 100.0f) float percentVisibleHeight,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                             ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                                ^^^^^^^^^^^^^^^^^^^^ definition local 10
//                                                                     documentation ```java\n@FloatRange(from = 0.0f, to = 100.0f)\nfloat percentVisibleHeight\n```
      @FloatRange(from = 0.0f, to = 100.0f) float percentVisibleWidth,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                             ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                                ^^^^^^^^^^^^^^^^^^^ definition local 11
//                                                                    documentation ```java\n@FloatRange(from = 0.0f, to = 100.0f)\nfloat percentVisibleWidth\n```
      @Px int visibleHeight,
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local 12
//                          documentation ```java\n@Px\nint visibleHeight\n```
      @Px int visibleWidth,
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^ definition local 13
//                         documentation ```java\n@Px\nint visibleWidth\n```
      @NonNull T view
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//               ^^^^ definition local 14
//                    documentation ```java\n@NonNull\nT view\n```
  ) {
  }

  public long id() {
//            ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//               documentation ```java\npublic long id()\n```
    return id;
//         ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id.
  }

  /**
   * Override the default id in cases where the data subject naturally has an id, like an object
   * from a database. This id can only be set before the model is added to the adapter, it is an
   * error to change the id after that.
   */
  public EpoxyModel<T> id(long id) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+1).
//                        documentation ```java\npublic EpoxyModel<T> id(long id)\n```
//                        documentation  Override the default id in cases where the data subject naturally has an id, like an object\n from a database. This id can only be set before the model is added to the adapter, it is an\n error to change the id after that.\n
//                             ^^ definition local 15
//                                documentation ```java\nlong id\n```
    if ((addedToAdapter || firstControllerAddedTo != null) && id != this.id) {
//       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addedToAdapter.
//                         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#firstControllerAddedTo.
//                                                            ^^ reference local 15
//                                                                       ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id.
      throw new IllegalEpoxyUsage(
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
          "Cannot change a model's id after it has been added to the adapter.");
    }

    hasDefaultId = false;
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hasDefaultId.
    this.id = id;
//       ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id.
//            ^^ reference local 15
    return this;
  }

  /**
   * Use multiple numbers as the id for this model. Useful when you don't have a single long that
   * represents a unique id.
   * <p>
   * This hashes the numbers, so there is a tiny risk of collision with other ids.
   */
  public EpoxyModel<T> id(@Nullable Number... ids) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+2).
//                        documentation ```java\npublic EpoxyModel<T> id(Number[] ids)\n```
//                        documentation  Use multiple numbers as the id for this model. Useful when you don't have a single long that\n represents a unique id.\n <p>\n This hashes the numbers, so there is a tiny risk of collision with other ids.\n
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/Number#
//                                            ^^^ definition local 16
//                                                documentation ```java\n@Nullable\nNumber[] ids\n```
    long result = 0;
//       ^^^^^^ definition local 17
//              documentation ```java\nlong result\n```
    if (ids != null) {
//      ^^^ reference local 16
      for (@Nullable Number id : ids) {
//          ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                   ^^^^^^ reference semanticdb maven jdk 11 java/lang/Number#
//                          ^^ definition local 18
//                             documentation ```java\n@Nullable\nNumber id\n```
//                               ^^^ reference local 16
        result = 31 * result + hashLong64Bit(id == null ? 0 : id.hashCode());
//      ^^^^^^ reference local 17
//                    ^^^^^^ reference local 17
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#hashLong64Bit().
//                                           ^^ reference local 18
//                                                            ^^ reference local 18
//                                                               ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#hashCode().
      }
    }
    return id(result);
//         ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+1).
//            ^^^^^^ reference local 17
  }

  /**
   * Use two numbers as the id for this model. Useful when you don't have a single long that
   * represents a unique id.
   * <p>
   * This hashes the two numbers, so there is a tiny risk of collision with other ids.
   */
  public EpoxyModel<T> id(long id1, long id2) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+3).
//                        documentation ```java\npublic EpoxyModel<T> id(long id1, long id2)\n```
//                        documentation  Use two numbers as the id for this model. Useful when you don't have a single long that\n represents a unique id.\n <p>\n This hashes the two numbers, so there is a tiny risk of collision with other ids.\n
//                             ^^^ definition local 19
//                                 documentation ```java\nlong id1\n```
//                                       ^^^ definition local 20
//                                           documentation ```java\nlong id2\n```
    long result = hashLong64Bit(id1);
//       ^^^^^^ definition local 21
//              documentation ```java\nlong result\n```
//                ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#hashLong64Bit().
//                              ^^^ reference local 19
    result = 31 * result + hashLong64Bit(id2);
//  ^^^^^^ reference local 21
//                ^^^^^^ reference local 21
//                         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#hashLong64Bit().
//                                       ^^^ reference local 20
    return id(result);
//         ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+1).
//            ^^^^^^ reference local 21
  }

  /**
   * Use a string as the model id. Useful for models that don't clearly map to a numerical id. This
   * is preferable to using {@link String#hashCode()} because that is a 32 bit hash and this is a 64
   * bit hash, giving better spread and less chance of collision with other ids.
   * <p>
   * Since this uses a hashcode method to convert the String to a long there is a very small chance
   * that you may have a collision with another id. Assuming an even spread of hashcodes, and
   * several hundred models in the adapter, there would be roughly 1 in 100 trillion chance of a
   * collision. (http://preshing.com/20110504/hash-collision-probabilities/)
   *
   * @see IdUtils#hashString64Bit(CharSequence)
   */
  public EpoxyModel<T> id(@Nullable CharSequence key) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+4).
//                        documentation ```java\npublic EpoxyModel<T> id(CharSequence key)\n```
//                        documentation  Use a string as the model id. Useful for models that don't clearly map to a numerical id. This\n is preferable to using {@link String#hashCode()} because that is a 32 bit hash and this is a 64\n bit hash, giving better spread and less chance of collision with other ids.\n <p>\n Since this uses a hashcode method to convert the String to a long there is a very small chance\n that you may have a collision with another id. Assuming an even spread of hashcodes, and\n several hundred models in the adapter, there would be roughly 1 in 100 trillion chance of a\n collision. (http://preshing.com/20110504/hash-collision-probabilities/)\n\n @see IdUtils#hashString64Bit(CharSequence)\n
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                  ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                               ^^^ definition local 22
//                                                   documentation ```java\n@Nullable\nCharSequence key\n```
    id(hashString64Bit(key));
//  ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+1).
//     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#hashString64Bit().
//                     ^^^ reference local 22
    return this;
  }

  /**
   * Use several strings to define the id of the model.
   * <p>
   * Similar to {@link #id(CharSequence)}, but with additional strings.
   */
  public EpoxyModel<T> id(@Nullable CharSequence key, @Nullable CharSequence... otherKeys) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+5).
//                        documentation ```java\npublic EpoxyModel<T> id(CharSequence key, CharSequence[] otherKeys)\n```
//                        documentation  Use several strings to define the id of the model.\n <p>\n Similar to {@link #id(CharSequence)}, but with additional strings.\n
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                  ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                               ^^^ definition local 23
//                                                   documentation ```java\n@Nullable\nCharSequence key\n```
//                                                     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                                              ^^^^^^^^^ definition local 24
//                                                                                        documentation ```java\n@Nullable\nCharSequence[] otherKeys\n```
    long result = hashString64Bit(key);
//       ^^^^^^ definition local 25
//              documentation ```java\nlong result\n```
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#hashString64Bit().
//                                ^^^ reference local 23
    if (otherKeys != null) {
//      ^^^^^^^^^ reference local 24
      for (CharSequence otherKey : otherKeys) {
//         ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                      ^^^^^^^^ definition local 26
//                               documentation ```java\nCharSequence otherKey\n```
//                                 ^^^^^^^^^ reference local 24
        result = 31 * result + hashString64Bit(otherKey);
//      ^^^^^^ reference local 25
//                    ^^^^^^ reference local 25
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#hashString64Bit().
//                                             ^^^^^^^^ reference local 26
      }
    }
    return id(result);
//         ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+1).
//            ^^^^^^ reference local 25
  }

  /**
   * Set an id that is namespaced with a string. This is useful when you need to show models of
   * multiple types, side by side and don't want to risk id collisions.
   * <p>
   * Since this uses a hashcode method to convert the String to a long there is a very small chance
   * that you may have a collision with another id. Assuming an even spread of hashcodes, and
   * several hundred models in the adapter, there would be roughly 1 in 100 trillion chance of a
   * collision. (http://preshing.com/20110504/hash-collision-probabilities/)
   *
   * @see IdUtils#hashString64Bit(CharSequence)
   * @see IdUtils#hashLong64Bit(long)
   */
  public EpoxyModel<T> id(@Nullable CharSequence key, long id) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+6).
//                        documentation ```java\npublic EpoxyModel<T> id(CharSequence key, long id)\n```
//                        documentation  Set an id that is namespaced with a string. This is useful when you need to show models of\n multiple types, side by side and don't want to risk id collisions.\n <p>\n Since this uses a hashcode method to convert the String to a long there is a very small chance\n that you may have a collision with another id. Assuming an even spread of hashcodes, and\n several hundred models in the adapter, there would be roughly 1 in 100 trillion chance of a\n collision. (http://preshing.com/20110504/hash-collision-probabilities/)\n\n @see IdUtils#hashString64Bit(CharSequence)\n @see IdUtils#hashLong64Bit(long)\n
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                  ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                               ^^^ definition local 27
//                                                   documentation ```java\n@Nullable\nCharSequence key\n```
//                                                         ^^ definition local 28
//                                                            documentation ```java\nlong id\n```
    long result = hashString64Bit(key);
//       ^^^^^^ definition local 29
//              documentation ```java\nlong result\n```
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#hashString64Bit().
//                                ^^^ reference local 27
    result = 31 * result + hashLong64Bit(id);
//  ^^^^^^ reference local 29
//                ^^^^^^ reference local 29
//                         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IdUtils#hashLong64Bit().
//                                       ^^ reference local 28
    id(result);
//  ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+1).
//     ^^^^^^ reference local 29
    return this;
  }

  /**
   * Return the default layout resource to be used when creating views for this model. The resource
   * will be inflated to create a view for the model; additionally the layout int is used as the
   * views type in the RecyclerView.
   * <p>
   * This can be left unimplemented if you use the {@link EpoxyModelClass} annotation to define a
   * layout.
   * <p>
   * This default value can be overridden with {@link #layout(int)} at runtime to change the layout
   * dynamically.
   */
  @LayoutRes
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
  protected abstract int getDefaultLayout();
//                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getDefaultLayout().
//                                        documentation ```java\n@LayoutRes\nprotected abstract int getDefaultLayout()\n```
//                                        documentation  Return the default layout resource to be used when creating views for this model. The resource\n will be inflated to create a view for the model; additionally the layout int is used as the\n views type in the RecyclerView.\n <p>\n This can be left unimplemented if you use the {@link EpoxyModelClass} annotation to define a\n layout.\n <p>\n This default value can be overridden with {@link #layout(int)} at runtime to change the layout\n dynamically.\n
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#getDefaultLayout().
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#getDefaultLayout().
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#getDefaultLayout().
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#getDefaultLayout().

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public EpoxyModel<T> layout(@LayoutRes int layoutRes) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#layout().
//                            documentation ```java\n@NonNull\npublic EpoxyModel<T> layout(int layoutRes)\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#layout().
//                             ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
//                                           ^^^^^^^^^ definition local 30
//                                                     documentation ```java\n@LayoutRes\nint layoutRes\n```
    onMutation();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onMutation().
    layout = layoutRes;
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#layout.
//           ^^^^^^^^^ reference local 30
    return this;
  }

  @LayoutRes
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
  public final int getLayout() {
//                 ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getLayout().
//                           documentation ```java\n@LayoutRes\npublic final int getLayout()\n```
    if (layout == 0) {
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#layout.
      return getDefaultLayout();
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getDefaultLayout().
    }

    return layout;
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#layout.
  }

  /**
   * Sets fields of the model to default ones.
   */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public EpoxyModel<T> reset() {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#reset().
//                           documentation ```java\n@NonNull\npublic EpoxyModel<T> reset()\n```
//                           documentation  Sets fields of the model to default ones.\n
    onMutation();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onMutation().

    layout = 0;
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#layout.
    shown = true;
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shown.

    return this;
  }

  /**
   * Add this model to the given controller. Can only be called from inside {@link
   * EpoxyController#buildModels()}.
   */
  public void addTo(@NonNull EpoxyController controller) {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addTo().
//                  documentation ```java\npublic void addTo(EpoxyController controller)\n```
//                  documentation  Add this model to the given controller. Can only be called from inside {@link\n EpoxyController#buildModels()}.\n
//                   ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                           ^^^^^^^^^^ definition local 31
//                                                      documentation ```java\n@NonNull\nEpoxyController controller\n```
    controller.addInternal(this);
//  ^^^^^^^^^^ reference local 31
//             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#addInternal().
  }

  /**
   * Add this model to the given controller if the condition is true. Can only be called from inside
   * {@link EpoxyController#buildModels()}.
   */
  public void addIf(boolean condition, @NonNull EpoxyController controller) {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addIf().
//                  documentation ```java\npublic void addIf(boolean condition, EpoxyController controller)\n```
//                  documentation  Add this model to the given controller if the condition is true. Can only be called from inside\n {@link EpoxyController#buildModels()}.\n
//                          ^^^^^^^^^ definition local 32
//                                    documentation ```java\nboolean condition\n```
//                                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                              ^^^^^^^^^^ definition local 33
//                                                                         documentation ```java\n@NonNull\nEpoxyController controller\n```
    if (condition) {
//      ^^^^^^^^^ reference local 32
      addTo(controller);
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addTo().
//          ^^^^^^^^^^ reference local 33
    } else if (controllerToStageTo != null) {
//             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
      // Clear this model from staging since it failed the add condition. If this model wasn't
      // staged (eg not changed before addIf was called, then we need to make sure to add the
      // previously staged model.
      controllerToStageTo.clearModelFromStaging(this);
//    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
//                        ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#clearModelFromStaging().
      controllerToStageTo = null;
//    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
    }
  }

  /**
   * Add this model to the given controller if the {@link AddPredicate} return true. Can only be
   * called from inside {@link EpoxyController#buildModels()}.
   */
  public void addIf(@NonNull AddPredicate predicate, @NonNull EpoxyController controller) {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addIf(+1).
//                  documentation ```java\npublic void addIf(AddPredicate predicate, EpoxyController controller)\n```
//                  documentation  Add this model to the given controller if the {@link AddPredicate} return true. Can only be\n called from inside {@link EpoxyController#buildModels()}.\n
//                   ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#AddPredicate#
//                                        ^^^^^^^^^ definition local 34
//                                                  documentation ```java\n@NonNull\nAddPredicate predicate\n```
//                                                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                                            ^^^^^^^^^^ definition local 35
//                                                                                       documentation ```java\n@NonNull\nEpoxyController controller\n```
    addIf(predicate.addIf(), controller);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addIf().
//        ^^^^^^^^^ reference local 34
//                  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#AddPredicate#addIf().
//                           ^^^^^^^^^^ reference local 35
  }

  /**
   * @see #addIf(AddPredicate, EpoxyController)
   */
  public interface AddPredicate {
//                 ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#AddPredicate#
//                              documentation ```java\npublic interface AddPredicate\n```
//                              documentation  @see #addIf(AddPredicate, EpoxyController)\n
    boolean addIf();
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#AddPredicate#addIf().
//                documentation ```java\npublic abstract boolean addIf()\n```
  }

  /**
   * This is used internally by generated models to turn on validation checking when
   * "validateEpoxyModelUsage" is enabled and the model is used with an {@link EpoxyController}.
   */
  protected final void addWithDebugValidation(@NonNull EpoxyController controller) {
//                     ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addWithDebugValidation().
//                                            documentation ```java\nprotected final void addWithDebugValidation(EpoxyController controller)\n```
//                                            documentation  This is used internally by generated models to turn on validation checking when\n "validateEpoxyModelUsage" is enabled and the model is used with an {@link EpoxyController}.\n
//                                             ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                                     ^^^^^^^^^^ definition local 36
//                                                                                documentation ```java\n@NonNull\nEpoxyController controller\n```
    if (controller == null) {
//      ^^^^^^^^^^ reference local 36
      throw new IllegalArgumentException("Controller cannot be null");
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`(+1).
    }

    if (controller.isModelAddedMultipleTimes(this)) {
//      ^^^^^^^^^^ reference local 36
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isModelAddedMultipleTimes().
      throw new IllegalEpoxyUsage(
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/IllegalEpoxyUsage#`<init>`().
          "This model was already added to the controller at position "
              + controller.getFirstIndexOfModelInBuildingList(this));
//              ^^^^^^^^^^ reference local 36
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#getFirstIndexOfModelInBuildingList().
    }

    if (firstControllerAddedTo == null) {
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#firstControllerAddedTo.
      firstControllerAddedTo = controller;
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#firstControllerAddedTo.
//                             ^^^^^^^^^^ reference local 36

      // We save the current hashCode so we can compare it to the hashCode at later points in time
      // in order to validate that it doesn't change and enforce mutability.
      hashCodeWhenAdded = hashCode();
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCodeWhenAdded.
//                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCode().

      // The one time it is valid to change the model is during an interceptor callback. To support
      // that we need to update the hashCode after interceptors have been run.
      // The model can be added to multiple controllers, but we only allow an interceptor change
      // the first time, since after that it will have been added to an adapter.
      controller.addAfterInterceptorCallback(new ModelInterceptorCallback() {
//    ^^^^^^^^^^ reference local 36
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#addAfterInterceptorCallback().
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#
        @Override
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
        public void onInterceptorsStarted(EpoxyController controller) {
//                  ^^^^^^^^^^^^^^^^^^^^^ definition local 39
//                                        documentation ```java\n@Override\npublic void onInterceptorsStarted(EpoxyController controller)\n```
//                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsStarted().
//                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                        ^^^^^^^^^^ definition local 41
//                                                                   documentation ```java\nEpoxyController controller\n```
          currentlyInInterceptors = true;
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#currentlyInInterceptors.
        }

        @Override
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
        public void onInterceptorsFinished(EpoxyController controller) {
//                  ^^^^^^^^^^^^^^^^^^^^^^ definition local 40
//                                         documentation ```java\n@Override\npublic void onInterceptorsFinished(EpoxyController controller)\n```
//                                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyController#ModelInterceptorCallback#onInterceptorsFinished().
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                         ^^^^^^^^^^ definition local 42
//                                                                    documentation ```java\nEpoxyController controller\n```
          hashCodeWhenAdded = EpoxyModel.this.hashCode();
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCodeWhenAdded.
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#this.
//                                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCode().
          currentlyInInterceptors = false;
//        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#currentlyInInterceptors.
        }
      });
    }
  }

  boolean isDebugValidationEnabled() {
//        ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
//                                 documentation ```java\nboolean isDebugValidationEnabled()\n```
    return firstControllerAddedTo != null;
//         ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#firstControllerAddedTo.
  }

  /**
   * This is used internally by generated models to do validation checking when
   * "validateEpoxyModelUsage" is enabled and the model is used with an {@link EpoxyController}.
   * This method validates that it is ok to change this model. It is only valid if the model hasn't
   * yet been added, or the change is being done from an {@link EpoxyController.Interceptor}
   * callback.
   * <p>
   * This is also used to stage the model for implicitly adding it, if it is an AutoModel and
   * implicit adding is enabled.
   */
  protected final void onMutation() {
//                     ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onMutation().
//                                documentation ```java\nprotected final void onMutation()\n```
//                                documentation  This is used internally by generated models to do validation checking when\n "validateEpoxyModelUsage" is enabled and the model is used with an {@link EpoxyController}.\n This method validates that it is ok to change this model. It is only valid if the model hasn't\n yet been added, or the change is being done from an {@link EpoxyController.Interceptor}\n callback.\n <p>\n This is also used to stage the model for implicitly adding it, if it is an AutoModel and\n implicit adding is enabled.\n
    // The model may be added to multiple controllers, in which case if it was already diffed
    // and added to an adapter in one controller we don't want to even allow interceptors
    // from changing the model in a different controller
    if (isDebugValidationEnabled() && !currentlyInInterceptors) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#currentlyInInterceptors.
      throw new ImmutableModelException(this,
//              ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`().
          getPosition(firstControllerAddedTo, this));
//        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getPosition().
//                    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#firstControllerAddedTo.
    }

    if (controllerToStageTo != null) {
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
      controllerToStageTo.setStagedModel(this);
//    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#controllerToStageTo.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#setStagedModel().
    }
  }

  private static int getPosition(@NonNull EpoxyController controller,
//                   ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getPosition().
//                               documentation ```java\nprivate static int getPosition(EpoxyController controller, EpoxyModel<?> model)\n```
//                                ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                        ^^^^^^^^^^ definition local 43
//                                                                   documentation ```java\n@NonNull\nEpoxyController controller\n```
      @NonNull EpoxyModel<?> model) {
//     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^ definition local 44
//                                 documentation ```java\n@NonNull\nEpoxyModel<?> model\n```
    // If the model was added to multiple controllers, or was removed from the controller and then
    // modified, this won't be correct. But those should be very rare cases that we don't need to
    // worry about
    if (controller.isBuildingModels()) {
//      ^^^^^^^^^^ reference local 43
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isBuildingModels().
      return controller.getFirstIndexOfModelInBuildingList(model);
//           ^^^^^^^^^^ reference local 43
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#getFirstIndexOfModelInBuildingList().
//                                                         ^^^^^ reference local 44
    }

    return controller.getAdapter().getModelPosition(model);
//         ^^^^^^^^^^ reference local 43
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#getAdapter().
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition().
//                                                  ^^^^^ reference local 44
  }

  /**
   * This is used internally by generated models to do validation checking when
   * "validateEpoxyModelUsage" is enabled and the model is used with a {@link EpoxyController}. This
   * method validates that the model's hashCode hasn't been changed since it was added to the
   * controller. This is similar to {@link #onMutation()}, but that method is only used for
   * specific model changes such as calling a setter. By checking the hashCode, this method allows
   * us to catch more subtle changes, such as through setting a field directly or through changing
   * an object that is set on the model.
   */
  protected final void validateStateHasNotChangedSinceAdded(String descriptionOfChange,
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#validateStateHasNotChangedSinceAdded().
//                                                          documentation ```java\nprotected final void validateStateHasNotChangedSinceAdded(String descriptionOfChange, int modelPosition)\n```
//                                                          documentation  This is used internally by generated models to do validation checking when\n "validateEpoxyModelUsage" is enabled and the model is used with a {@link EpoxyController}. This\n method validates that the model's hashCode hasn't been changed since it was added to the\n controller. This is similar to {@link #onMutation()}, but that method is only used for\n specific model changes such as calling a setter. By checking the hashCode, this method allows\n us to catch more subtle changes, such as through setting a field directly or through changing\n an object that is set on the model.\n
//                                                          ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                                                                 ^^^^^^^^^^^^^^^^^^^ definition local 45
//                                                                                     documentation ```java\nString descriptionOfChange\n```
      int modelPosition) {
//        ^^^^^^^^^^^^^ definition local 46
//                      documentation ```java\nint modelPosition\n```
    if (isDebugValidationEnabled()
//      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
        && !currentlyInInterceptors
//          ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#currentlyInInterceptors.
        && hashCodeWhenAdded != hashCode()) {
//         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCodeWhenAdded.
//                              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCode().
      throw new ImmutableModelException(this, descriptionOfChange, modelPosition);
//              ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ImmutableModelException#`<init>`(+1).
//                                            ^^^^^^^^^^^^^^^^^^^ reference local 45
//                                                                 ^^^^^^^^^^^^^ reference local 46
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#equals().
//                      documentation ```java\n@Override\npublic boolean equals(Object o)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#equals().
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#equals().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 47
//                               documentation ```java\nObject o\n```
    if (this == o) {
//              ^ reference local 47
      return true;
    }
    if (!(o instanceof EpoxyModel)) {
//        ^ reference local 47
//                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
      return false;
    }

    EpoxyModel<?> that = (EpoxyModel<?>) o;
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^ definition local 48
//                     documentation ```java\nEpoxyModel<?> that\n```
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                       ^ reference local 47

    if (id != that.id) {
//      ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id.
//            ^^^^ reference local 48
//                 ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id.
      return false;
    }
    if (getViewType() != that.getViewType()) {
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getViewType().
//                       ^^^^ reference local 48
//                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getViewType().
      return false;
    }
    return shown == that.shown;
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shown.
//                  ^^^^ reference local 48
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shown.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCode().
//                    documentation ```java\n@Override\npublic int hashCode()\n```
//                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#hashCode().
//                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#hashCode().
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
    int result = (int) (id ^ (id >>> 32));
//      ^^^^^^ definition local 49
//             documentation ```java\nint result\n```
//                      ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id.
//                            ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id.
    result = 31 * result + getViewType();
//  ^^^^^^ reference local 49
//                ^^^^^^ reference local 49
//                         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getViewType().
    result = 31 * result + (shown ? 1 : 0);
//  ^^^^^^ reference local 49
//                ^^^^^^ reference local 49
//                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shown.
    return result;
//         ^^^^^^ reference local 49
  }

  /**
   * Subclasses can override this if they want their view to take up more than one span in a grid
   * layout.
   *
   * @param totalSpanCount The number of spans in the grid
   * @param position       The position of the model
   * @param itemCount      The total number of items in the adapter
   */
  public int getSpanSize(int totalSpanCount, int position, int itemCount) {
//           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getSpanSize().
//                       documentation ```java\npublic int getSpanSize(int totalSpanCount, int position, int itemCount)\n```
//                       documentation  Subclasses can override this if they want their view to take up more than one span in a grid\n layout.\n\n @param totalSpanCount The number of spans in the grid\n @param position       The position of the model\n @param itemCount      The total number of items in the adapter\n
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#getSpanSize().
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#getSpanSize().
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyModel#getSpanSize().
//                           ^^^^^^^^^^^^^^ definition local 50
//                                          documentation ```java\nint totalSpanCount\n```
//                                               ^^^^^^^^ definition local 51
//                                                        documentation ```java\nint position\n```
//                                                             ^^^^^^^^^ definition local 52
//                                                                       documentation ```java\nint itemCount\n```
    return 1;
  }

  public EpoxyModel<T> spanSizeOverride(@Nullable SpanSizeOverrideCallback spanSizeCallback) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#spanSizeOverride().
//                                      documentation ```java\npublic EpoxyModel<T> spanSizeOverride(SpanSizeOverrideCallback spanSizeCallback)\n```
//                                       ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#SpanSizeOverrideCallback#
//                                                                         ^^^^^^^^^^^^^^^^ definition local 53
//                                                                                          documentation ```java\n@Nullable\nSpanSizeOverrideCallback spanSizeCallback\n```
    this.spanSizeOverride = spanSizeCallback;
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#spanSizeOverride.
//                          ^^^^^^^^^^^^^^^^ reference local 53
    return this;
  }

  public interface SpanSizeOverrideCallback {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#SpanSizeOverrideCallback#
//                                          documentation ```java\npublic interface SpanSizeOverrideCallback\n```
    int getSpanSize(int totalSpanCount, int position, int itemCount);
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#SpanSizeOverrideCallback#getSpanSize().
//                  documentation ```java\npublic abstract int getSpanSize(int totalSpanCount, int position, int itemCount)\n```
//                      ^^^^^^^^^^^^^^ definition local 54
//                                     documentation ```java\nint totalSpanCount\n```
//                                          ^^^^^^^^ definition local 55
//                                                   documentation ```java\nint position\n```
//                                                        ^^^^^^^^^ definition local 56
//                                                                  documentation ```java\nint itemCount\n```
  }

  /**
   * Returns the actual span size of this model, using the {@link SpanSizeOverrideCallback} if one
   * was set, otherwise using the value from {@link #getSpanSize(int, int, int)}
   */
  public final int spanSize(int totalSpanCount, int position, int itemCount) {
//                 ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#spanSize().
//                          documentation ```java\npublic final int spanSize(int totalSpanCount, int position, int itemCount)\n```
//                          documentation  Returns the actual span size of this model, using the {@link SpanSizeOverrideCallback} if one\n was set, otherwise using the value from {@link #getSpanSize(int, int, int)}\n
//                              ^^^^^^^^^^^^^^ definition local 57
//                                             documentation ```java\nint totalSpanCount\n```
//                                                  ^^^^^^^^ definition local 58
//                                                           documentation ```java\nint position\n```
//                                                                ^^^^^^^^^ definition local 59
//                                                                          documentation ```java\nint itemCount\n```
    if (spanSizeOverride != null) {
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#spanSizeOverride.
      return spanSizeOverride.getSpanSize(totalSpanCount, position, itemCount);
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#spanSizeOverride.
//                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#SpanSizeOverrideCallback#getSpanSize().
//                                        ^^^^^^^^^^^^^^ reference local 57
//                                                        ^^^^^^^^ reference local 58
//                                                                  ^^^^^^^^^ reference local 59
    }

    return getSpanSize(totalSpanCount, position, itemCount);
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getSpanSize().
//                     ^^^^^^^^^^^^^^ reference local 57
//                                     ^^^^^^^^ reference local 58
//                                               ^^^^^^^^^ reference local 59
  }

  /**
   * Change the visibility of the model so that it's view is shown. This only works if the model is
   * used in {@link EpoxyAdapter} or a {@link EpoxyModelGroup}, but is not supported in {@link
   * EpoxyController}
   */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public EpoxyModel<T> show() {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#show().
//                          documentation ```java\n@NonNull\npublic EpoxyModel<T> show()\n```
//                          documentation  Change the visibility of the model so that it's view is shown. This only works if the model is\n used in {@link EpoxyAdapter} or a {@link EpoxyModelGroup}, but is not supported in {@link\n EpoxyController}\n
    return show(true);
//         ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#show(+1).
  }

  /**
   * Change the visibility of the model's view. This only works if the model is
   * used in {@link EpoxyAdapter} or a {@link EpoxyModelGroup}, but is not supported in {@link
   * EpoxyController}
   */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public EpoxyModel<T> show(boolean show) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#show(+1).
//                          documentation ```java\n@NonNull\npublic EpoxyModel<T> show(boolean show)\n```
//                          documentation  Change the visibility of the model's view. This only works if the model is\n used in {@link EpoxyAdapter} or a {@link EpoxyModelGroup}, but is not supported in {@link\n EpoxyController}\n
//                                  ^^^^ definition local 60
//                                       documentation ```java\nboolean show\n```
    onMutation();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onMutation().
    shown = show;
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shown.
//          ^^^^ reference local 60
    return this;
  }

  /**
   * Change the visibility of the model so that it's view is hidden. This only works if the model is
   * used in {@link EpoxyAdapter} or a {@link EpoxyModelGroup}, but is not supported in {@link
   * EpoxyController}
   */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public EpoxyModel<T> hide() {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hide().
//                          documentation ```java\n@NonNull\npublic EpoxyModel<T> hide()\n```
//                          documentation  Change the visibility of the model so that it's view is hidden. This only works if the model is\n used in {@link EpoxyAdapter} or a {@link EpoxyModelGroup}, but is not supported in {@link\n EpoxyController}\n
    return show(false);
//         ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#show(+1).
  }

  /**
   * Whether the model's view should be shown on screen. If false it won't be inflated and drawn,
   * and will be like it was never added to the recycler view.
   */
  public boolean isShown() {
//               ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isShown().
//                       documentation ```java\npublic boolean isShown()\n```
//                       documentation  Whether the model's view should be shown on screen. If false it won't be inflated and drawn,\n and will be like it was never added to the recycler view.\n
    return shown;
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shown.
  }

  /**
   * Whether the adapter should save the state of the view bound to this model.
   */
  public boolean shouldSaveViewState() {
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
//                                   documentation ```java\npublic boolean shouldSaveViewState()\n```
//                                   documentation  Whether the adapter should save the state of the view bound to this model.\n
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState(+1).
    return false;
  }

  /**
   * Called if the RecyclerView failed to recycle this model's view. You can take this opportunity
   * to clear the animation(s) that affect the View's transient state and return <code>true</code>
   * so that the View can be recycled. Keep in mind that the View in question is already removed
   * from the RecyclerView.
   *
   * @return True if the View should be recycled, false otherwise
   * @see EpoxyAdapter#onFailedToRecycleView(androidx.recyclerview.widget.RecyclerView.ViewHolder)
   */
  public boolean onFailedToRecycleView(@NonNull T view) {
//               ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onFailedToRecycleView().
//                                     documentation ```java\npublic boolean onFailedToRecycleView(T view)\n```
//                                     documentation  Called if the RecyclerView failed to recycle this model's view. You can take this opportunity\n to clear the animation(s) that affect the View's transient state and return <code>true</code>\n so that the View can be recycled. Keep in mind that the View in question is already removed\n from the RecyclerView.\n\n @return True if the View should be recycled, false otherwise\n @see EpoxyAdapter#onFailedToRecycleView(androidx.recyclerview.widget.RecyclerView.ViewHolder)\n
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onFailedToRecycleView().
//                                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                              ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                                                ^^^^ definition local 61
//                                                     documentation ```java\n@NonNull\nT view\n```
    return false;
  }

  /**
   * Called when this model's view is attached to the window.
   *
   * @see EpoxyAdapter#onViewAttachedToWindow(androidx.recyclerview.widget.RecyclerView.ViewHolder)
   */
  public void onViewAttachedToWindow(@NonNull T view) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                                   documentation ```java\npublic void onViewAttachedToWindow(T view)\n```
//                                   documentation  Called when this model's view is attached to the window.\n\n @see EpoxyAdapter#onViewAttachedToWindow(androidx.recyclerview.widget.RecyclerView.ViewHolder)\n
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#onViewAttachedToWindow().
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewAttachedToWindow().
//                                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                                              ^^^^ definition local 62
//                                                   documentation ```java\n@NonNull\nT view\n```

  }

  /**
   * Called when this model's view is detached from the the window.
   *
   * @see EpoxyAdapter#onViewDetachedFromWindow(androidx.recyclerview.widget.RecyclerView
   * .ViewHolder)
   */
  public void onViewDetachedFromWindow(@NonNull T view) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                     documentation ```java\npublic void onViewDetachedFromWindow(T view)\n```
//                                     documentation  Called when this model's view is detached from the the window.\n\n @see EpoxyAdapter#onViewDetachedFromWindow(androidx.recyclerview.widget.RecyclerView\n .ViewHolder)\n
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#onViewDetachedFromWindow().
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewDetachedFromWindow().
//                                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                              ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#[T]
//                                                ^^^^ definition local 63
//                                                     documentation ```java\n@NonNull\nT view\n```

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public String toString() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModel#toString().
//                       documentation ```java\n@Override\npublic String toString()\n```
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#toString().
    return getClass().getSimpleName() + "{"
//         ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
//                    ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getSimpleName().
        + "id=" + id
//                ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id.
        + ", viewType=" + getViewType()
//                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getViewType().
        + ", shown=" + shown
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shown.
        + ", addedToAdapter=" + addedToAdapter
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#addedToAdapter.
        + '}';
  }
}
