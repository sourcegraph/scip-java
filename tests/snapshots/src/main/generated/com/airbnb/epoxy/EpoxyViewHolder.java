package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#
import android.view.ViewParent;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^^^^^^^ reference android/view/ViewParent#

import com.airbnb.epoxy.ViewHolderState.ViewState;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                                      ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
import com.airbnb.epoxy.VisibilityState.Visibility;
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#Visibility#

import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

import androidx.annotation.FloatRange;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^^ reference androidx/annotation/FloatRange#
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
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView#

@SuppressWarnings("WeakerAccess")
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
public class EpoxyViewHolder extends RecyclerView.ViewHolder {
//           ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder# public class EpoxyViewHolder extends unresolved_type
//                                   ^^^^^^^^^^^^ reference RecyclerView/
//                                                ^^^^^^^^^^ reference RecyclerView/ViewHolder#
  @SuppressWarnings("rawtypes") private EpoxyModel epoxyModel;
// ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#epoxyModel. private EpoxyModel epoxyModel
  private List<Object> payloads;
//        ^^^^ reference java/util/List#
//             ^^^^^^ reference java/lang/Object#
//                     ^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#payloads. private List<Object> payloads
  private EpoxyHolder epoxyHolder;
//        ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyHolder#
//                    ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder. private EpoxyHolder epoxyHolder
  @Nullable ViewHolderState.ViewState initialViewState;
// ^^^^^^^^ reference androidx/annotation/Nullable#
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#
//                          ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
//                                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#initialViewState. ViewState initialViewState

  // Once the EpoxyHolder is created parent will be set to null.
  private ViewParent parent;
//        ^^^^^^^^^^ reference _root_/
//                   ^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#parent. private unresolved_type parent

  public EpoxyViewHolder(ViewParent parent, View view, boolean saveInitialState) {
//       ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#`<init>`(). public EpoxyViewHolder(unresolved_type parent, unresolved_type view, boolean saveInitialState)
//                       ^^^^^^^^^^ reference _root_/
//                                  ^^^^^^ definition local0 unresolved_type parent
//                                          ^^^^ reference _root_/
//                                               ^^^^ definition local1 unresolved_type view
//                                                             ^^^^^^^^^^^^^^^^ definition local2 boolean saveInitialState
    super(view);
//        ^^^^ reference local1

    this.parent = parent;
//  ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//       ^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#parent.
//                ^^^^^^ reference local0
    if (saveInitialState) {
//      ^^^^^^^^^^^^^^^^ reference local2
      // We save the initial state of the view when it is created so that we can reset this initial
      // state before a model is bound for the first time. Otherwise the view may carry over
      // state from a previously bound model.
      initialViewState = new ViewState();
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#`<init>`().
//                           ^^^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#
      initialViewState.save(itemView);
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
//                     ^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#save().
//                          ^^^^^^^^ reference _root_/
    }
  }

  void restoreInitialViewState() {
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#restoreInitialViewState(). void restoreInitialViewState()
    if (initialViewState != null) {
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
      initialViewState.restore(itemView);
//    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
//                     ^^^^^^^ reference com/airbnb/epoxy/ViewHolderState#ViewState#restore().
//                             ^^^^^^^^ reference _root_/
    }
  }

  public void bind(@SuppressWarnings("rawtypes") EpoxyModel model,
//            ^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#bind(). public void bind(EpoxyModel model, EpoxyModel<?> previouslyBoundModel, List<Object> payloads, int position)
//                  ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
//                                               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^ definition local3 EpoxyModel model
      @Nullable EpoxyModel<?> previouslyBoundModel, List<Object> payloads, int position) {
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^^^^^^^^^^^^^^ definition local4 EpoxyModel<?> previouslyBoundModel
//                                                  ^^^^ reference java/util/List#
//                                                       ^^^^^^ reference java/lang/Object#
//                                                               ^^^^^^^^ definition local5 List<Object> payloads
//                                                                             ^^^^^^^^ definition local6 int position
    this.payloads = payloads;
//  ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//       ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#payloads.
//                  ^^^^^^^^ reference local5

    if (epoxyHolder == null && model instanceof EpoxyModelWithHolder) {
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                             ^^^^^ reference local3
//                                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#
      epoxyHolder = ((EpoxyModelWithHolder) model).createNewHolder(parent);
//    ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                    ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#
//                                          ^^^^^ reference local3
//                                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#createNewHolder().
//                                                                 ^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#parent.
      epoxyHolder.bindView(itemView);
//    ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                ^^^^^^^^ reference com/airbnb/epoxy/EpoxyHolder#bindView().
//                         ^^^^^^^^ reference _root_/
    }
    // Safe to set to null as it is only used for createNewHolder method
    parent = null;
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#parent.

    if (model instanceof GeneratedModel) {
//      ^^^^^ reference local3
//                       ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/GeneratedModel#
      // The generated method will enforce that only a properly typed listener can be set
      //noinspection unchecked
      ((GeneratedModel) model).handlePreBind(this, objectToBind(), position);
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/GeneratedModel#
//                      ^^^^^ reference local3
//                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/GeneratedModel#handlePreBind().
//                                           ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                                                                 ^^^^^^^^ reference local6
    }

    if (previouslyBoundModel != null) {
//      ^^^^^^^^^^^^^^^^^^^^ reference local4
      // noinspection unchecked
      model.bind(objectToBind(), previouslyBoundModel);
//    ^^^^^ reference local3
//          ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind(+2).
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                               ^^^^^^^^^^^^^^^^^^^^ reference local4
    } else if (payloads.isEmpty()) {
//             ^^^^^^^^ reference local5
//                      ^^^^^^^ reference java/util/List#isEmpty().
      // noinspection unchecked
      model.bind(objectToBind());
//    ^^^^^ reference local3
//          ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind().
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
    } else {
      // noinspection unchecked
      model.bind(objectToBind(), payloads);
//    ^^^^^ reference local3
//          ^^^^ reference com/airbnb/epoxy/EpoxyModel#bind(+1).
//               ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                               ^^^^^^^^ reference local5
    }

    if (model instanceof GeneratedModel) {
//      ^^^^^ reference local3
//                       ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/GeneratedModel#
      // The generated method will enforce that only a properly typed listener can be set
      //noinspection unchecked
      ((GeneratedModel) model).handlePostBind(objectToBind(), position);
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/GeneratedModel#
//                      ^^^^^ reference local3
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/GeneratedModel#handlePostBind().
//                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                                                            ^^^^^^^^ reference local6
    }

    epoxyModel = model;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//               ^^^^^ reference local3
  }

  @NonNull
// ^^^^^^^ reference androidx/annotation/NonNull#
  Object objectToBind() {
//^^^^^^ reference java/lang/Object#
//       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#objectToBind(). Object objectToBind()
    return epoxyHolder != null ? epoxyHolder : itemView;
//         ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                               ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                                             ^^^^^^^^ reference _root_/
  }

  public void unbind() {
//            ^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#unbind(). public void unbind()
    assertBound();
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    // noinspection unchecked
    epoxyModel.unbind(objectToBind());
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//             ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#unbind().
//                    ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().

    epoxyModel = null;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
    payloads = null;
//  ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#payloads.
  }

  public void visibilityStateChanged(@Visibility int visibilityState) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#visibilityStateChanged(). public void visibilityStateChanged(int visibilityState)
//                                    ^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#Visibility#
//                                                   ^^^^^^^^^^^^^^^ definition local7 int visibilityState
    assertBound();
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    // noinspection unchecked
    epoxyModel.onVisibilityStateChanged(visibilityState, objectToBind());
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//             ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onVisibilityStateChanged().
//                                      ^^^^^^^^^^^^^^^ reference local7
//                                                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  public void visibilityChanged(
//            ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#visibilityChanged(). public void visibilityChanged(float percentVisibleHeight, float percentVisibleWidth, int visibleHeight, int visibleWidth)
      @FloatRange(from = 0.0f, to = 100.0f) float percentVisibleHeight,
//     ^^^^^^^^^^ reference androidx/annotation/FloatRange#
//                ^^^^ reference androidx/annotation/FloatRange#from().
//                             ^^ reference androidx/annotation/FloatRange#to().
//                                                ^^^^^^^^^^^^^^^^^^^^ definition local8 float percentVisibleHeight
      @FloatRange(from = 0.0f, to = 100.0f) float percentVisibleWidth,
//     ^^^^^^^^^^ reference androidx/annotation/FloatRange#
//                ^^^^ reference androidx/annotation/FloatRange#from().
//                             ^^ reference androidx/annotation/FloatRange#to().
//                                                ^^^^^^^^^^^^^^^^^^^ definition local9 float percentVisibleWidth
      @Px int visibleHeight,
//     ^^ reference androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local10 int visibleHeight
      @Px int visibleWidth
//     ^^ reference androidx/annotation/Px#
//            ^^^^^^^^^^^^ definition local11 int visibleWidth
  ) {
    assertBound();
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    // noinspection unchecked
    epoxyModel.onVisibilityChanged(percentVisibleHeight, percentVisibleWidth, visibleHeight,
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//             ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onVisibilityChanged().
//                                 ^^^^^^^^^^^^^^^^^^^^ reference local8
//                                                       ^^^^^^^^^^^^^^^^^^^ reference local9
//                                                                            ^^^^^^^^^^^^^ reference local10
        visibleWidth, objectToBind());
//      ^^^^^^^^^^^^ reference local11
//                    ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  public List<Object> getPayloads() {
//       ^^^^ reference java/util/List#
//            ^^^^^^ reference java/lang/Object#
//                    ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#getPayloads(). public List<Object> getPayloads()
    assertBound();
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    return payloads;
//         ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#payloads.
  }

  public EpoxyModel<?> getModel() {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#getModel(). public EpoxyModel<?> getModel()
    assertBound();
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    return epoxyModel;
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
  }

  public EpoxyHolder getHolder() {
//       ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyHolder#
//                   ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#getHolder(). public EpoxyHolder getHolder()
    assertBound();
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    return epoxyHolder;
//         ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
  }

  private void assertBound() {
//             ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#assertBound(). private void assertBound()
    if (epoxyModel == null) {
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
      throw new IllegalStateException("This holder is not currently bound.");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public String toString() {
//       ^^^^^^ reference java/lang/String#
//              ^^^^^^^^ definition com/airbnb/epoxy/EpoxyViewHolder#toString(). public String toString()
    return "EpoxyViewHolder{"
        + "epoxyModel=" + epoxyModel
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
        + ", view=" + itemView
//                    ^^^^^^^^ reference _root_/
        + ", super=" + super.toString()
//                     ^^^^^ reference _root_/
//                           ^^^^^^^^ reference toString#
        + '}';
  }
}
