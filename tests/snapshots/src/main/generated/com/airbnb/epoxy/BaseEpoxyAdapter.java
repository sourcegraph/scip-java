package com.airbnb.epoxy;

import android.os.Bundle;
//     ^^^^^^^ reference android/
//             ^^ reference android/os/
//                ^^^^^^ reference android/os/Bundle#
import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#
import android.view.ViewGroup;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^^^^^^ reference android/view/ViewGroup#

import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#

import org.jetbrains.annotations.NotNull;
//     ^^^ reference org/
//         ^^^^^^^^^ reference org/jetbrains/
//                   ^^^^^^^^^^^ reference org/jetbrains/annotations/
//                               ^^^^^^^ reference org/jetbrains/annotations/NotNull#

import java.util.Collections;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^ reference java/util/Collections#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.annotation.CallSuper;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/CallSuper#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/GridLayoutManager/
//                                                    ^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/GridLayoutManager/SpanSizeLookup#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#

public abstract class BaseEpoxyAdapter
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#
    extends RecyclerView.Adapter<EpoxyViewHolder>
//          ^^^^^^^^^^^^ reference RecyclerView/
//                       ^^^^^^^ reference RecyclerView/Adapter#
//                               ^^^^^^^^^^^^^^^ reference _root_/
    implements StickyHeaderCallbacks {
//             ^^^^^^^^^^^^^^^^^^^^^ reference _root_/

  private static final String SAVED_STATE_ARG_VIEW_HOLDERS = "saved_state_view_holders";
//                     ^^^^^^ reference java/lang/String#
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#SAVED_STATE_ARG_VIEW_HOLDERS.

  private int spanCount = 1;
//            ^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.

  private final ViewTypeManager viewTypeManager = new ViewTypeManager();
//              ^^^^^^^^^^^^^^^ reference _root_/
//                              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                                                    ^^^^^^^^^^^^^^^ reference _root_/
  /**
   * Keeps track of view holders that are currently bound so we can save their state in {@link
   * #onSaveInstanceState(Bundle)}.
   */
  private final BoundViewHolders boundViewHolders = new BoundViewHolders();
//              ^^^^^^^^^^^^^^^^ reference _root_/
//                               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                                                      ^^^^^^^^^^^^^^^^ reference _root_/
  private ViewHolderState viewHolderState = new ViewHolderState();
//        ^^^^^^^^^^^^^^^ reference _root_/
//                        ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                                              ^^^^^^^^^^^^^^^ reference _root_/

  private final SpanSizeLookup spanSizeLookup = new SpanSizeLookup() {
//              ^^^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#spanSizeLookup.
//                                                  ^^^^^^^^^^^^^^ reference _root_/

    @Override
    public int getSpanSize(int position) {
      try {
        return getModelForPosition(position)
            .spanSize(spanCount, position, getItemCount());
      } catch (IndexOutOfBoundsException e) {
        // There seems to be a GridLayoutManager bug where when the user is in accessibility mode
        // it incorrectly uses an outdated view position
        // when calling this method. This crashes when a view is animating out, when it is
        // removed from the adapter but technically still added
        // to the layout. We've posted a bug report and hopefully can update when the support
        // library fixes this
        // TODO: (eli_hart 8/23/16) Figure out if this has been fixed in new support library
        onExceptionSwallowed(e);
        return 1;
      }
    }
  };

  public BaseEpoxyAdapter() {
//       ^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#`<init>`().
    // Defaults to stable ids since view models generate unique ids. Set this to false in the
    // subclass if you don't want to support it
    setHasStableIds(true);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#setHasStableIds#
    spanSizeLookup.setSpanIndexCacheEnabled(true);
//  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#spanSizeLookup.
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference setSpanIndexCacheEnabled#
  }

  /**
   * This is called when recoverable exceptions happen at runtime. They can be ignored and Epoxy
   * will recover, but you can override this to be aware of when they happen.
   */
  protected void onExceptionSwallowed(RuntimeException exception) {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onExceptionSwallowed().
//                                    ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                     ^^^^^^^^^ definition local0

  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public int getItemCount() {
//           ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getItemCount().
    return getCurrentModels().size();
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^^ reference java/util/List#size().
  }

  /** Return the models currently being used by the adapter to populate the recyclerview. */
  abstract List<? extends EpoxyModel<?>> getCurrentModels();
//         ^^^^ reference java/util/List#
//                        ^^^^^^^^^^ reference _root_/
//                                       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().

  public boolean isEmpty() {
//               ^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#isEmpty().
    return getCurrentModels().isEmpty();
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^^^^^ reference java/util/List#isEmpty().
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public long getItemId(int position) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getItemId().
//                          ^^^^^^^^ definition local1
    // This does not call getModelForPosition so that we don't use the id of the empty model when
    // hidden,
    // so that the id stays constant when gone vs shown
    return getCurrentModels().get(position).id();
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^ reference java/util/List#get().
//                                ^^^^^^^^ reference local1
//                                          ^^ reference `<any>`#id#
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public int getItemViewType(int position) {
//           ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getItemViewType().
//                               ^^^^^^^^ definition local2
    return viewTypeManager.getViewTypeAndRememberModel(getModelForPosition(position));
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference getViewTypeAndRememberModel#
//                                                     ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                                                         ^^^^^^^^ reference local2
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public EpoxyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//       ^^^^^^^^^^^^^^^ reference _root_/
//                       ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onCreateViewHolder().
//                                          ^^^^^^^^^ reference _root_/
//                                                    ^^^^^^ definition local3
//                                                                ^^^^^^^^ definition local4
    EpoxyModel<?> model = viewTypeManager.getModelForViewType(this, viewType);
//  ^^^^^^^^^^ reference _root_/
//                ^^^^^ definition local5
//                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                                        ^^^^^^^^^^^^^^^^^^^ reference getModelForViewType#
//                                                            ^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#this.
//                                                                  ^^^^^^^^ reference local4
    View view = model.buildView(parent);
//  ^^^^ reference _root_/
//       ^^^^ definition local6
//              ^^^^^ reference local5
//                    ^^^^^^^^^ reference `<any>`#buildView#
//                              ^^^^^^ reference local3
    return new EpoxyViewHolder(parent, view, model.shouldSaveViewState());
//             ^^^^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^ reference local3
//                                     ^^^^ reference local6
//                                           ^^^^^ reference local5
//                                                 ^^^^^^^^^^^^^^^^^^^ reference `<any>`#shouldSaveViewState#
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onBindViewHolder(EpoxyViewHolder holder, int position) {
//            ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder().
//                             ^^^^^^^^^^^^^^^ reference _root_/
//                                             ^^^^^^ definition local7
//                                                         ^^^^^^^^ definition local8
    onBindViewHolder(holder, position, Collections.emptyList());
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
//                   ^^^^^^ reference local7
//                           ^^^^^^^^ reference local8
//                                     ^^^^^^^^^^^ reference java/util/Collections#
//                                                 ^^^^^^^^^ reference java/util/Collections#emptyList().
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onBindViewHolder(EpoxyViewHolder holder, int position, List<Object> payloads) {
//            ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
//                             ^^^^^^^^^^^^^^^ reference _root_/
//                                             ^^^^^^ definition local9
//                                                         ^^^^^^^^ definition local10
//                                                                   ^^^^ reference java/util/List#
//                                                                        ^^^^^^ reference java/lang/Object#
//                                                                                ^^^^^^^^ definition local11
    EpoxyModel<?> modelToShow = getModelForPosition(position);
//  ^^^^^^^^^^ reference _root_/
//                ^^^^^^^^^^^ definition local12
//                              ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                                  ^^^^^^^^ reference local10

    EpoxyModel<?> previouslyBoundModel = null;
//  ^^^^^^^^^^ reference _root_/
//                ^^^^^^^^^^^^^^^^^^^^ definition local13
    if (diffPayloadsEnabled()) {
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
      previouslyBoundModel = DiffPayload.getModelFromPayload(payloads, getItemId(position));
//    ^^^^^^^^^^^^^^^^^^^^ reference local13
//                           ^^^^^^^^^^^ reference _root_/
//                                       ^^^^^^^^^^^^^^^^^^^ reference getModelFromPayload#
//                                                           ^^^^^^^^ reference local11
//                                                                     ^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getItemId().
//                                                                               ^^^^^^^^ reference local10
    }

    holder.bind(modelToShow, previouslyBoundModel, payloads, position);
//  ^^^^^^ reference local9
//         ^^^^ reference bind#
//              ^^^^^^^^^^^ reference local12
//                           ^^^^^^^^^^^^^^^^^^^^ reference local13
//                                                 ^^^^^^^^ reference local11
//                                                           ^^^^^^^^ reference local10

    if (payloads.isEmpty()) {
//      ^^^^^^^^ reference local11
//               ^^^^^^^ reference java/util/List#isEmpty().
      // We only apply saved state to the view on initial bind, not on model updates.
      // Since view state should be independent of model props, we should not need to apply state
      // again in this case. This simplifies a rebind on update
      viewHolderState.restore(holder);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                    ^^^^^^^ reference restore#
//                            ^^^^^^ reference local9
    }

    boundViewHolders.put(holder);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                   ^^^ reference put#
//                       ^^^^^^ reference local9

    if (diffPayloadsEnabled()) {
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
      onModelBound(holder, modelToShow, position, previouslyBoundModel);
//    ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
//                 ^^^^^^ reference local9
//                         ^^^^^^^^^^^ reference local12
//                                      ^^^^^^^^ reference local10
//                                                ^^^^^^^^^^^^^^^^^^^^ reference local13
    } else {
      onModelBound(holder, modelToShow, position, payloads);
//    ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
//                 ^^^^^^ reference local9
//                         ^^^^^^^^^^^ reference local12
//                                      ^^^^^^^^ reference local10
//                                                ^^^^^^^^ reference local11
    }
  }

  boolean diffPayloadsEnabled() {
//        ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
    return false;
  }

  /**
   * Called immediately after a model is bound to a view holder. Subclasses can override this if
   * they want alerts on when a model is bound.
   */
  protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position,
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
//                            ^^^^^^^^^^^^^^^ reference _root_/
//                                            ^^^^^^ definition local14
//                                                    ^^^^^^^^^^ reference _root_/
//                                                                  ^^^^^ definition local15
//                                                                             ^^^^^^^^ definition local16
      @Nullable List<Object> payloads) {
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^ reference java/util/List#
//                   ^^^^^^ reference java/lang/Object#
//                           ^^^^^^^^ definition local17
    onModelBound(holder, model, position);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//               ^^^^^^ reference local14
//                       ^^^^^ reference local15
//                              ^^^^^^^^ reference local16
  }

  void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position,
//     ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
//                  ^^^^^^^^^^^^^^^ reference _root_/
//                                  ^^^^^^ definition local18
//                                          ^^^^^^^^^^ reference _root_/
//                                                        ^^^^^ definition local19
//                                                                   ^^^^^^^^ definition local20
      @Nullable EpoxyModel<?> previouslyBoundModel) {
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference _root_/
//                            ^^^^^^^^^^^^^^^^^^^^ definition local21
    onModelBound(holder, model, position);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//               ^^^^^^ reference local18
//                       ^^^^^ reference local19
//                              ^^^^^^^^ reference local20
  }

  /**
   * Called immediately after a model is bound to a view holder. Subclasses can override this if
   * they want alerts on when a model is bound.
   */
  protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position) {
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//                            ^^^^^^^^^^^^^^^ reference _root_/
//                                            ^^^^^^ definition local22
//                                                    ^^^^^^^^^^ reference _root_/
//                                                                  ^^^^^ definition local23
//                                                                             ^^^^^^^^ definition local24

  }

  /**
   * Returns an object that manages the view holders currently bound to the RecyclerView. This
   * object is mainly used by the base Epoxy adapter to save view states, but you may find it useful
   * to help access views or models currently shown in the RecyclerView.
   */
  protected BoundViewHolders getBoundViewHolders() {
//          ^^^^^^^^^^^^^^^^ reference _root_/
//                           ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
    return boundViewHolders;
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
  }

  EpoxyModel<?> getModelForPosition(int position) {
  ^^^^^^^^^^ reference _root_/
//              ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                      ^^^^^^^^ definition local25
    return getCurrentModels().get(position);
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^ reference java/util/List#get().
//                                ^^^^^^^^ reference local25
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onViewRecycled(EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onViewRecycled().
//                           ^^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local26
    viewHolderState.save(holder);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                  ^^^^ reference save#
//                       ^^^^^^ reference local26
    boundViewHolders.remove(holder);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                   ^^^^^^ reference remove#
//                          ^^^^^^ reference local26

    EpoxyModel<?> model = holder.getModel();
//  ^^^^^^^^^^ reference _root_/
//                ^^^^^ definition local27
//                        ^^^^^^ reference local26
//                               ^^^^^^^^ reference getModel#
    holder.unbind();
//  ^^^^^^ reference local26
//         ^^^^^^ reference unbind#
    onModelUnbound(holder, model);
//  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound().
//                 ^^^^^^ reference local26
//                         ^^^^^ reference local27
  }

  @CallSuper
   ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onDetachedFromRecyclerView().
//                                        ^^^^^^^ reference androidx/annotation/NonNull#
//                                                ^^^^^^^^^^^^ reference _root_/
//                                                             ^^^^^^^^^^^^ definition local28
    // The last model is saved for optimization, but holding onto it can leak anything saved inside
    // the model (like a click listener that references a Fragment). This is only needed during
    // the viewholder creation phase, so it is safe to clear now.
    viewTypeManager.lastModelForViewTypeLookup = null;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference lastModelForViewTypeLookup#
  }

  /**
   * Called immediately after a model is unbound from a view holder. Subclasses can override this if
   * they want alerts on when a model is unbound.
   */
  protected void onModelUnbound(EpoxyViewHolder holder, EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound().
//                              ^^^^^^^^^^^^^^^ reference _root_/
//                                              ^^^^^^ definition local29
//                                                      ^^^^^^^^^^ reference _root_/
//                                                                    ^^^^^ definition local30

  }

  @CallSuper
   ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean onFailedToRecycleView(EpoxyViewHolder holder) {
//               ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onFailedToRecycleView().
//                                     ^^^^^^^^^^^^^^^ reference _root_/
//                                                     ^^^^^^ definition local31
    //noinspection unchecked,rawtypes
    return ((EpoxyModel) holder.getModel()).onFailedToRecycleView(holder.objectToBind());
//           ^^^^^^^^^^ reference _root_/
//                       ^^^^^^ reference local31
//                              ^^^^^^^^ reference getModel#
//                                          ^^^^^^^^^^^^^^^^^^^^^ reference onFailedToRecycleView#
//                                                                ^^^^^^ reference local31
//                                                                       ^^^^^^^^^^^^ reference objectToBind#
  }

  @CallSuper
   ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onViewAttachedToWindow(EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onViewAttachedToWindow().
//                                   ^^^^^^^^^^^^^^^ reference _root_/
//                                                   ^^^^^^ definition local32
    //noinspection unchecked,rawtypes
    ((EpoxyModel) holder.getModel()).onViewAttachedToWindow(holder.objectToBind());
//    ^^^^^^^^^^ reference _root_/
//                ^^^^^^ reference local32
//                       ^^^^^^^^ reference getModel#
//                                   ^^^^^^^^^^^^^^^^^^^^^^ reference onViewAttachedToWindow#
//                                                          ^^^^^^ reference local32
//                                                                 ^^^^^^^^^^^^ reference objectToBind#
  }

  @CallSuper
   ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onViewDetachedFromWindow(EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onViewDetachedFromWindow().
//                                     ^^^^^^^^^^^^^^^ reference _root_/
//                                                     ^^^^^^ definition local33
    //noinspection unchecked,rawtypes
    ((EpoxyModel) holder.getModel()).onViewDetachedFromWindow(holder.objectToBind());
//    ^^^^^^^^^^ reference _root_/
//                ^^^^^^ reference local33
//                       ^^^^^^^^ reference getModel#
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference onViewDetachedFromWindow#
//                                                            ^^^^^^ reference local33
//                                                                   ^^^^^^^^^^^^ reference objectToBind#
  }

  public void onSaveInstanceState(Bundle outState) {
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onSaveInstanceState().
//                                ^^^^^^ reference _root_/
//                                       ^^^^^^^^ definition local34
    // Save the state of currently bound views first so they are included. Views that were
    // scrolled off and unbound will already have had
    // their state saved.
    for (EpoxyViewHolder holder : boundViewHolders) {
//       ^^^^^^^^^^^^^^^ reference _root_/
//                       ^^^^^^ definition local35
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
      viewHolderState.save(holder);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                    ^^^^ reference save#
//                         ^^^^^^ reference local35
    }

    if (viewHolderState.size() > 0 && !hasStableIds()) {
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                      ^^^^ reference size#
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#hasStableIds#
      throw new IllegalStateException("Must have stable ids when saving view holder state");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    outState.putParcelable(SAVED_STATE_ARG_VIEW_HOLDERS, viewHolderState);
//  ^^^^^^^^ reference local34
//           ^^^^^^^^^^^^^ reference putParcelable#
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#SAVED_STATE_ARG_VIEW_HOLDERS.
//                                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
  }

  public void onRestoreInstanceState(@Nullable Bundle inState) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onRestoreInstanceState().
//                                    ^^^^^^^^ reference androidx/annotation/Nullable#
//                                             ^^^^^^ reference _root_/
//                                                    ^^^^^^^ definition local36
    // To simplify things we enforce that state is restored before views are bound, otherwise it
    // is more difficult to update view state once they are bound
    if (boundViewHolders.size() > 0) {
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                       ^^^^ reference size#
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 2:52
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "State cannot be restored once views have been bound. It should be done before adding "
              + "the adapter to the recycler view.");
    }

    if (inState != null) {
//      ^^^^^^^ reference local36
      viewHolderState = inState.getParcelable(SAVED_STATE_ARG_VIEW_HOLDERS);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                      ^^^^^^^ reference local36
//                              ^^^^^^^^^^^^^ reference getParcelable#
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#SAVED_STATE_ARG_VIEW_HOLDERS.
      if (viewHolderState == null) {
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
        throw new IllegalStateException(
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 1:89
//                ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
            "Tried to restore instance state, but onSaveInstanceState was never called.");
      }
    }
  }

  /**
   * Finds the position of the given model in the list. Doesn't use indexOf to avoid unnecessary
   * equals() calls since we're looking for the same object instance.
   *
   * @return The position of the given model in the current models list, or -1 if the model can't be
   * found.
   */
  protected int getModelPosition(EpoxyModel<?> model) {
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                               ^^^^^^^^^^ reference _root_/
//                                             ^^^^^ definition local37
    int size = getCurrentModels().size();
//      ^^^^ definition local38
//             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                ^^^^ reference java/util/List#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local39
//                  ^ reference local39
//                      ^^^^ reference local38
//                            ^ reference local39
      if (model == getCurrentModels().get(i)) {
//        ^^^^^ reference local37
//                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                    ^^^ reference java/util/List#get().
//                                        ^ reference local39
        return i;
//             ^ reference local39
      }
    }

    return -1;
  }

  /**
   * For use with a grid layout manager - use this to get the {@link SpanSizeLookup} for models in
   * this adapter. This will delegate span look up calls to each model's {@link
   * EpoxyModel#getSpanSize(int, int, int)}. Make sure to also call {@link #setSpanCount(int)} so
   * the span count is correct.
   */
  public SpanSizeLookup getSpanSizeLookup() {
//       ^^^^^^^^^^^^^^ reference _root_/
//                      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getSpanSizeLookup().
    return spanSizeLookup;
//         ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#spanSizeLookup.
  }

  /**
   * If you are using a grid layout manager you must call this to set the span count of the grid.
   * This span count will be passed on to the models so models can choose what span count to be.
   *
   * @see #getSpanSizeLookup()
   * @see EpoxyModel#getSpanSize(int, int, int)
   */
  public void setSpanCount(int spanCount) {
//            ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#setSpanCount().
//                             ^^^^^^^^^ definition local40
    this.spanCount = spanCount;
//  ^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#this.
//       ^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
//                   ^^^^^^^^^ reference local40
  }

  public int getSpanCount() {
//           ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getSpanCount().
    return spanCount;
//         ^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
  }

  public boolean isMultiSpan() {
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#isMultiSpan().
    return spanCount > 1;
//         ^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
  }

  //region Sticky header

  /**
   * Optional callback to setup the sticky view,
   * by default it doesn't do anything.
   * <p>
   * The sub-classes should override the function if they are
   * using sticky header feature.
   */
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void setupStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#setupStickyHeaderView().
//                                   ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                           ^^^^ reference _root_/
//                                                ^^^^^^^^^^^^ definition local41
    // no-op
  }

  /**
   * Optional callback to perform tear down operation on the
   * sticky view, by default it doesn't do anything.
   * <p>
   * The sub-classes should override the function if they are
   * using sticky header feature.
   */
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void teardownStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#teardownStickyHeaderView().
//                                      ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^^^^^ definition local42
    // no-op
  }

  /**
   * Called to check if the item at the position is a sticky item,
   * by default returns false.
   * <p>
   * The sub-classes should override the function if they are
   * using sticky header feature.
   */
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean isStickyHeader(int position) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#isStickyHeader().
//                                  ^^^^^^^^ definition local43
    return false;
  }

  //endregion
}
