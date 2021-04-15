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
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter# public abstract class BaseEpoxyAdapter extends unresolved_type implements unresolved_type
    extends RecyclerView.Adapter<EpoxyViewHolder>
//          ^^^^^^^^^^^^ reference RecyclerView/
//                       ^^^^^^^ reference RecyclerView/Adapter#
//                               ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
    implements StickyHeaderCallbacks {
//             ^^^^^^^^^^^^^^^^^^^^^ reference _root_/

  private static final String SAVED_STATE_ARG_VIEW_HOLDERS = "saved_state_view_holders";
//                     ^^^^^^ reference java/lang/String#
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#SAVED_STATE_ARG_VIEW_HOLDERS. private static final String SAVED_STATE_ARG_VIEW_HOLDERS

  private int spanCount = 1;
//            ^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#spanCount. private int spanCount

  private final ViewTypeManager viewTypeManager = new ViewTypeManager();
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewTypeManager#
//                              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager. private final ViewTypeManager viewTypeManager
//                                                    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewTypeManager#`<init>`().
  /**
   * Keeps track of view holders that are currently bound so we can save their state in {@link
   * #onSaveInstanceState(Bundle)}.
   */
  private final BoundViewHolders boundViewHolders = new BoundViewHolders();
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#
//                               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders. private final BoundViewHolders boundViewHolders
//                                                      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#`<init>`().
  private ViewHolderState viewHolderState = new ViewHolderState();
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                        ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState. private ViewHolderState viewHolderState
//                                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#`<init>`().

  private final SpanSizeLookup spanSizeLookup = new SpanSizeLookup() {
//              ^^^^^^^^^^^^^^ reference _root_/
//                             ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#spanSizeLookup. private final unresolved_type spanSizeLookup
//                                                  ^^^^^^^^^^^^^^ reference _root_/

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public int getSpanSize(int position) {
//             ^^^^^^^^^^^ definition local1 @Override public int getSpanSize(int position)
//                             ^^^^^^^^ definition local2 int position
      try {
        return getModelForPosition(position)
//             ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                 ^^^^^^^^ reference local2
            .spanSize(spanCount, position, getItemCount());
//           ^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#spanSize().
//                    ^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
//                               ^^^^^^^^ reference local2
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getItemCount().
      } catch (IndexOutOfBoundsException e) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
//                                       ^ definition local3 IndexOutOfBoundsException e
        // There seems to be a GridLayoutManager bug where when the user is in accessibility mode
        // it incorrectly uses an outdated view position
        // when calling this method. This crashes when a view is animating out, when it is
        // removed from the adapter but technically still added
        // to the layout. We've posted a bug report and hopefully can update when the support
        // library fixes this
        // TODO: (eli_hart 8/23/16) Figure out if this has been fixed in new support library
        onExceptionSwallowed(e);
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onExceptionSwallowed().
//                           ^ reference local3
        return 1;
      }
    }
  };

  public BaseEpoxyAdapter() {
//       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#`<init>`(). public BaseEpoxyAdapter()
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
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onExceptionSwallowed(). protected void onExceptionSwallowed(RuntimeException exception)
//                                    ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                     ^^^^^^^^^ definition local4 RuntimeException exception

  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int getItemCount() {
//           ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getItemCount(). @Override public int getItemCount()
    return getCurrentModels().size();
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^^ reference java/util/List#size().
  }

  /** Return the models currently being used by the adapter to populate the recyclerview. */
  abstract List<? extends EpoxyModel<?>> getCurrentModels();
//         ^^^^ reference java/util/List#
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels(). abstract List<? extends EpoxyModel<?>> getCurrentModels()

  public boolean isEmpty() {
//               ^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#isEmpty(). public boolean isEmpty()
    return getCurrentModels().isEmpty();
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^^^^^ reference java/util/List#isEmpty().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public long getItemId(int position) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getItemId(). @Override public long getItemId(int position)
//                          ^^^^^^^^ definition local5 int position
    // This does not call getModelForPosition so that we don't use the id of the empty model when
    // hidden,
    // so that the id stays constant when gone vs shown
    return getCurrentModels().get(position).id();
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^ reference java/util/List#get().
//                                ^^^^^^^^ reference local5
//                                          ^^ reference com/airbnb/epoxy/EpoxyModel#id().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int getItemViewType(int position) {
//           ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getItemViewType(). @Override public int getItemViewType(int position)
//                               ^^^^^^^^ definition local6 int position
    return viewTypeManager.getViewTypeAndRememberModel(getModelForPosition(position));
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewTypeManager#getViewTypeAndRememberModel().
//                                                     ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                                                         ^^^^^^^^ reference local6
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public EpoxyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onCreateViewHolder(). @Override public EpoxyViewHolder onCreateViewHolder(unresolved_type parent, int viewType)
//                                          ^^^^^^^^^ reference _root_/
//                                                    ^^^^^^ definition local7 unresolved_type parent
//                                                                ^^^^^^^^ definition local8 int viewType
    EpoxyModel<?> model = viewTypeManager.getModelForViewType(this, viewType);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local9 EpoxyModel<?> model
//                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewTypeManager#getModelForViewType().
//                                                            ^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#
//                                                                  ^^^^^^^^ reference local8
    View view = model.buildView(parent);
//  ^^^^ reference _root_/
//       ^^^^ definition local10 unresolved_type view
//              ^^^^^ reference local9
//                    ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#buildView().
//                              ^^^^^^ reference local7
    return new EpoxyViewHolder(parent, view, model.shouldSaveViewState());
//             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#`<init>`().
//                             ^^^^^^ reference local7
//                                     ^^^^ reference local10
//                                           ^^^^^ reference local9
//                                                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onBindViewHolder(EpoxyViewHolder holder, int position) {
//            ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(). @Override public void onBindViewHolder(EpoxyViewHolder holder, int position)
//                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                             ^^^^^^ definition local11 EpoxyViewHolder holder
//                                                         ^^^^^^^^ definition local12 int position
    onBindViewHolder(holder, position, Collections.emptyList());
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
//                   ^^^^^^ reference local11
//                           ^^^^^^^^ reference local12
//                                     ^^^^^^^^^^^ reference java/util/Collections#
//                                                 ^^^^^^^^^ reference java/util/Collections#emptyList().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onBindViewHolder(EpoxyViewHolder holder, int position, List<Object> payloads) {
//            ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1). @Override public void onBindViewHolder(EpoxyViewHolder holder, int position, List<Object> payloads)
//                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                             ^^^^^^ definition local13 EpoxyViewHolder holder
//                                                         ^^^^^^^^ definition local14 int position
//                                                                   ^^^^ reference java/util/List#
//                                                                        ^^^^^^ reference java/lang/Object#
//                                                                                ^^^^^^^^ definition local15 List<Object> payloads
    EpoxyModel<?> modelToShow = getModelForPosition(position);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^^^^^^ definition local16 EpoxyModel<?> modelToShow
//                              ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                                  ^^^^^^^^ reference local14

    EpoxyModel<?> previouslyBoundModel = null;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^^^^^^^^^^^^^^^ definition local17 EpoxyModel<?> previouslyBoundModel
    if (diffPayloadsEnabled()) {
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
      previouslyBoundModel = DiffPayload.getModelFromPayload(payloads, getItemId(position));
//    ^^^^^^^^^^^^^^^^^^^^ reference local17
//                           ^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#
//                                       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffPayload#getModelFromPayload().
//                                                           ^^^^^^^^ reference local15
//                                                                     ^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getItemId().
//                                                                               ^^^^^^^^ reference local14
    }

    holder.bind(modelToShow, previouslyBoundModel, payloads, position);
//  ^^^^^^ reference local13
//         ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#bind().
//              ^^^^^^^^^^^ reference local16
//                           ^^^^^^^^^^^^^^^^^^^^ reference local17
//                                                 ^^^^^^^^ reference local15
//                                                           ^^^^^^^^ reference local14

    if (payloads.isEmpty()) {
//      ^^^^^^^^ reference local15
//               ^^^^^^^ reference java/util/List#isEmpty().
      // We only apply saved state to the view on initial bind, not on model updates.
      // Since view state should be independent of model props, we should not need to apply state
      // again in this case. This simplifies a rebind on update
      viewHolderState.restore(holder);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                    ^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#restore().
//                            ^^^^^^ reference local13
    }

    boundViewHolders.put(holder);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                   ^^^ reference com/airbnb/epoxy/BoundViewHolders#put().
//                       ^^^^^^ reference local13

    if (diffPayloadsEnabled()) {
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
      onModelBound(holder, modelToShow, position, previouslyBoundModel);
//    ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
//                 ^^^^^^ reference local13
//                         ^^^^^^^^^^^ reference local16
//                                      ^^^^^^^^ reference local14
//                                                ^^^^^^^^^^^^^^^^^^^^ reference local17
    } else {
      onModelBound(holder, modelToShow, position, payloads);
//    ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
//                 ^^^^^^ reference local13
//                         ^^^^^^^^^^^ reference local16
//                                      ^^^^^^^^ reference local14
//                                                ^^^^^^^^ reference local15
    }
  }

  boolean diffPayloadsEnabled() {
//        ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled(). boolean diffPayloadsEnabled()
    return false;
  }

  /**
   * Called immediately after a model is bound to a view holder. Subclasses can override this if
   * they want alerts on when a model is bound.
   */
  protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position,
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(). protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position, List<Object> payloads)
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^ definition local18 EpoxyViewHolder holder
//                                                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^ definition local19 EpoxyModel<?> model
//                                                                             ^^^^^^^^ definition local20 int position
      @Nullable List<Object> payloads) {
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^ reference java/util/List#
//                   ^^^^^^ reference java/lang/Object#
//                           ^^^^^^^^ definition local21 @Nullable List<Object> payloads
    onModelBound(holder, model, position);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//               ^^^^^^ reference local18
//                       ^^^^^ reference local19
//                              ^^^^^^^^ reference local20
  }

  void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position,
//     ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1). void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position, EpoxyModel<?> previouslyBoundModel)
//                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                  ^^^^^^ definition local22 EpoxyViewHolder holder
//                                          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                        ^^^^^ definition local23 EpoxyModel<?> model
//                                                                   ^^^^^^^^ definition local24 int position
      @Nullable EpoxyModel<?> previouslyBoundModel) {
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^^^^^^^^^^^^^^ definition local25 @Nullable EpoxyModel<?> previouslyBoundModel
    onModelBound(holder, model, position);
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//               ^^^^^^ reference local22
//                       ^^^^^ reference local23
//                              ^^^^^^^^ reference local24
  }

  /**
   * Called immediately after a model is bound to a view holder. Subclasses can override this if
   * they want alerts on when a model is bound.
   */
  protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position) {
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2). protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position)
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^ definition local26 EpoxyViewHolder holder
//                                                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^ definition local27 EpoxyModel<?> model
//                                                                             ^^^^^^^^ definition local28 int position

  }

  /**
   * Returns an object that manages the view holders currently bound to the RecyclerView. This
   * object is mainly used by the base Epoxy adapter to save view states, but you may find it useful
   * to help access views or models currently shown in the RecyclerView.
   */
  protected BoundViewHolders getBoundViewHolders() {
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#
//                           ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders(). protected BoundViewHolders getBoundViewHolders()
    return boundViewHolders;
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
  }

  EpoxyModel<?> getModelForPosition(int position) {
//^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//              ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition(). EpoxyModel<?> getModelForPosition(int position)
//                                      ^^^^^^^^ definition local29 int position
    return getCurrentModels().get(position);
//         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^ reference java/util/List#get().
//                                ^^^^^^^^ reference local29
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onViewRecycled(EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onViewRecycled(). @Override public void onViewRecycled(EpoxyViewHolder holder)
//                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                           ^^^^^^ definition local30 EpoxyViewHolder holder
    viewHolderState.save(holder);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                  ^^^^ reference com/airbnb/epoxy/ViewHolderState#save(+1).
//                       ^^^^^^ reference local30
    boundViewHolders.remove(holder);
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                   ^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#remove().
//                          ^^^^^^ reference local30

    EpoxyModel<?> model = holder.getModel();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local31 EpoxyModel<?> model
//                        ^^^^^^ reference local30
//                               ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
    holder.unbind();
//  ^^^^^^ reference local30
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#unbind().
    onModelUnbound(holder, model);
//  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound().
//                 ^^^^^^ reference local30
//                         ^^^^^ reference local31
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onDetachedFromRecyclerView(). @CallSuper @Override public void onDetachedFromRecyclerView(unresolved_type recyclerView)
//                                        ^^^^^^^ reference androidx/annotation/NonNull#
//                                                ^^^^^^^^^^^^ reference _root_/
//                                                             ^^^^^^^^^^^^ definition local32 @NonNull unresolved_type recyclerView
    // The last model is saved for optimization, but holding onto it can leak anything saved inside
    // the model (like a click listener that references a Fragment). This is only needed during
    // the viewholder creation phase, so it is safe to clear now.
    viewTypeManager.lastModelForViewTypeLookup = null;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewTypeManager#lastModelForViewTypeLookup.
  }

  /**
   * Called immediately after a model is unbound from a view holder. Subclasses can override this if
   * they want alerts on when a model is unbound.
   */
  protected void onModelUnbound(EpoxyViewHolder holder, EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound(). protected void onModelUnbound(EpoxyViewHolder holder, EpoxyModel<?> model)
//                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                              ^^^^^^ definition local33 EpoxyViewHolder holder
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                    ^^^^^ definition local34 EpoxyModel<?> model

  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public boolean onFailedToRecycleView(EpoxyViewHolder holder) {
//               ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onFailedToRecycleView(). @CallSuper @Override public boolean onFailedToRecycleView(EpoxyViewHolder holder)
//                                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local35 EpoxyViewHolder holder
    //noinspection unchecked,rawtypes
    return ((EpoxyModel) holder.getModel()).onFailedToRecycleView(holder.objectToBind());
//           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                       ^^^^^^ reference local35
//                              ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onFailedToRecycleView().
//                                                                ^^^^^^ reference local35
//                                                                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onViewAttachedToWindow(EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onViewAttachedToWindow(). @CallSuper @Override public void onViewAttachedToWindow(EpoxyViewHolder holder)
//                                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                   ^^^^^^ definition local36 EpoxyViewHolder holder
    //noinspection unchecked,rawtypes
    ((EpoxyModel) holder.getModel()).onViewAttachedToWindow(holder.objectToBind());
//    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^ reference local36
//                       ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                   ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                                                          ^^^^^^ reference local36
//                                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onViewDetachedFromWindow(EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onViewDetachedFromWindow(). @CallSuper @Override public void onViewDetachedFromWindow(EpoxyViewHolder holder)
//                                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local37 EpoxyViewHolder holder
    //noinspection unchecked,rawtypes
    ((EpoxyModel) holder.getModel()).onViewDetachedFromWindow(holder.objectToBind());
//    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^ reference local37
//                       ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                                            ^^^^^^ reference local37
//                                                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  public void onSaveInstanceState(Bundle outState) {
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onSaveInstanceState(). public void onSaveInstanceState(unresolved_type outState)
//                                ^^^^^^ reference _root_/
//                                       ^^^^^^^^ definition local38 unresolved_type outState
    // Save the state of currently bound views first so they are included. Views that were
    // scrolled off and unbound will already have had
    // their state saved.
    for (EpoxyViewHolder holder : boundViewHolders) {
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^ definition local39 EpoxyViewHolder holder
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
      viewHolderState.save(holder);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                    ^^^^ reference com/airbnb/epoxy/ViewHolderState#save(+1).
//                         ^^^^^^ reference local39
    }

    if (viewHolderState.size() > 0 && !hasStableIds()) {
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                      ^^^^ reference androidx/collection/LongSparseArray#size().
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#hasStableIds#
      throw new IllegalStateException("Must have stable ids when saving view holder state");
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
    }

    outState.putParcelable(SAVED_STATE_ARG_VIEW_HOLDERS, viewHolderState);
//  ^^^^^^^^ reference local38
//           ^^^^^^^^^^^^^ reference putParcelable#
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#SAVED_STATE_ARG_VIEW_HOLDERS.
//                                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
  }

  public void onRestoreInstanceState(@Nullable Bundle inState) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#onRestoreInstanceState(). public void onRestoreInstanceState(unresolved_type inState)
//                                    ^^^^^^^^ reference androidx/annotation/Nullable#
//                                             ^^^^^^ reference _root_/
//                                                    ^^^^^^^ definition local40 @Nullable unresolved_type inState
    // To simplify things we enforce that state is restored before views are bound, otherwise it
    // is more difficult to update view state once they are bound
    if (boundViewHolders.size() > 0) {
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                       ^^^^ reference com/airbnb/epoxy/BoundViewHolders#size().
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
          "State cannot be restored once views have been bound. It should be done before adding "
              + "the adapter to the recycler view.");
    }

    if (inState != null) {
//      ^^^^^^^ reference local40
      viewHolderState = inState.getParcelable(SAVED_STATE_ARG_VIEW_HOLDERS);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                      ^^^^^^^ reference local40
//                              ^^^^^^^^^^^^^ reference getParcelable#
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#SAVED_STATE_ARG_VIEW_HOLDERS.
      if (viewHolderState == null) {
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
        throw new IllegalStateException(
//                ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
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
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition(). protected int getModelPosition(EpoxyModel<?> model)
//                               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^ definition local41 EpoxyModel<?> model
    int size = getCurrentModels().size();
//      ^^^^ definition local42 int size
//             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                ^^^^ reference java/util/List#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local43 int i
//                  ^ reference local43
//                      ^^^^ reference local42
//                            ^ reference local43
      if (model == getCurrentModels().get(i)) {
//        ^^^^^ reference local41
//                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                    ^^^ reference java/util/List#get().
//                                        ^ reference local43
        return i;
//             ^ reference local43
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
//                      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getSpanSizeLookup(). public getSpanSizeLookup()
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
//            ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#setSpanCount(). public void setSpanCount(int spanCount)
//                             ^^^^^^^^^ definition local44 int spanCount
    this.spanCount = spanCount;
//  ^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#
//       ^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
//                   ^^^^^^^^^ reference local44
  }

  public int getSpanCount() {
//           ^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#getSpanCount(). public int getSpanCount()
    return spanCount;
//         ^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
  }

  public boolean isMultiSpan() {
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#isMultiSpan(). public boolean isMultiSpan()
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
// ^^^^^^^^ reference java/lang/Override#
  public void setupStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#setupStickyHeaderView(). @Override public void setupStickyHeaderView(unresolved_type stickyHeader)
//                                   ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                           ^^^^ reference _root_/
//                                                ^^^^^^^^^^^^ definition local45 @NotNull unresolved_type stickyHeader
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
// ^^^^^^^^ reference java/lang/Override#
  public void teardownStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#teardownStickyHeaderView(). @Override public void teardownStickyHeaderView(unresolved_type stickyHeader)
//                                      ^^^^^^^ reference org/jetbrains/annotations/NotNull#
//                                              ^^^^ reference _root_/
//                                                   ^^^^^^^^^^^^ definition local46 @NotNull unresolved_type stickyHeader
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
// ^^^^^^^^ reference java/lang/Override#
  public boolean isStickyHeader(int position) {
//               ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/BaseEpoxyAdapter#isStickyHeader(). @Override public boolean isStickyHeader(int position)
//                                  ^^^^^^^^ definition local47 int position
    return false;
  }

  //endregion
}
