package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#
import android.view.ViewParent;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^^ reference semanticdb maven . . android/view/ViewParent#

import com.airbnb.epoxy.ViewHolderState.ViewState;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#
//                                      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
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
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#

@SuppressWarnings("WeakerAccess")
//^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
public class EpoxyViewHolder extends RecyclerView.ViewHolder {
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                           display_name EpoxyViewHolder
//                           signature_documentation java @SuppressWarnings("WeakerAccess")\npublic class EpoxyViewHolder
//                           relationship is_implementation semanticdb maven . . RecyclerView/ViewHolder#
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/
//                                                ^^^^^^^^^^ reference semanticdb maven . . RecyclerView/ViewHolder#
  @SuppressWarnings("rawtypes") private EpoxyModel epoxyModel;
// ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//                                                            display_name epoxyModel
//                                                            signature_documentation java @SuppressWarnings("rawtypes")\nprivate EpoxyModel epoxyModel
  private List<Object> payloads;
//        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//             ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#payloads.
//                              display_name payloads
//                              signature_documentation java private List<Object> payloads
  private EpoxyHolder epoxyHolder;
//        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#
//                    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                                display_name epoxyHolder
//                                signature_documentation java private EpoxyHolder epoxyHolder
  @Nullable ViewHolderState.ViewState initialViewState;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#
//                          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
//                                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
//                                                     display_name initialViewState
//                                                     signature_documentation java @Nullable\nViewState initialViewState

  // Once the EpoxyHolder is created parent will be set to null.
  private ViewParent parent;
//        ^^^^^^^^^^ reference semanticdb maven . . ViewParent#
//                   ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#parent.
//                          display_name parent
//                          signature_documentation java private unresolved_type parent

  public EpoxyViewHolder(ViewParent parent, View view, boolean saveInitialState) {
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#`<init>`().
//                       display_name <init>
//                       signature_documentation java public EpoxyViewHolder(unresolved_type parent, unresolved_type view, boolean saveInitialState)
//                       ^^^^^^^^^^ reference semanticdb maven . . ViewParent#
//                                  ^^^^^^ definition local 0
//                                         display_name parent
//                                         signature_documentation java unresolved_type parent
//                                          ^^^^ reference semanticdb maven . . View#
//                                               ^^^^ definition local 1
//                                                    display_name view
//                                                    signature_documentation java unresolved_type view
//                                                             ^^^^^^^^^^^^^^^^ definition local 2
//                                                                              display_name saveInitialState
//                                                                              signature_documentation java boolean saveInitialState
    super(view);
//        ^^^^ reference local 1

    this.parent = parent;
//       ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#parent.
//                ^^^^^^ reference local 0
    if (saveInitialState) {
//      ^^^^^^^^^^^^^^^^ reference local 2
      // We save the initial state of the view when it is created so that we can reset this initial
      // state before a model is bound for the first time. Otherwise the view may carry over
      // state from a previously bound model.
      initialViewState = new ViewState();
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
//                           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#`<init>`().
      initialViewState.save(itemView);
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
//                     ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#save().
//                          ^^^^^^^^ reference semanticdb maven . . itemView#
    }
  }

  void restoreInitialViewState() {
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#restoreInitialViewState().
//                             display_name restoreInitialViewState
//                             signature_documentation java void restoreInitialViewState()
    if (initialViewState != null) {
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
      initialViewState.restore(itemView);
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
//                     ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#restore().
//                             ^^^^^^^^ reference semanticdb maven . . itemView#
    }
  }

  public void bind(@SuppressWarnings("rawtypes") EpoxyModel model,
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#bind().
//                 display_name bind
//                 signature_documentation java public void bind(EpoxyModel model, EpoxyModel<?> previouslyBoundModel, List<Object> payloads, int position)
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
//                                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^ definition local 3
//                                                                display_name model
//                                                                signature_documentation java @SuppressWarnings("rawtypes")\nEpoxyModel model
      @Nullable EpoxyModel<?> previouslyBoundModel, List<Object> payloads, int position) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^^^^^^^^^^^^^^ definition local 4
//                                                 display_name previouslyBoundModel
//                                                 signature_documentation java @Nullable\nEpoxyModel<?> previouslyBoundModel
//                                                  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                               ^^^^^^^^ definition local 5
//                                                                        display_name payloads
//                                                                        signature_documentation java List<Object> payloads
//                                                                             ^^^^^^^^ definition local 6
//                                                                                      display_name position
//                                                                                      signature_documentation java int position
    this.payloads = payloads;
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#payloads.
//                  ^^^^^^^^ reference local 5

    if (epoxyHolder == null && model instanceof EpoxyModelWithHolder) {
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                             ^^^^^ reference local 3
//                                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#
      epoxyHolder = ((EpoxyModelWithHolder) model).createNewHolder(parent);
//    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#
//                                          ^^^^^ reference local 3
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#createNewHolder().
//                                                                 ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#parent.
      epoxyHolder.bindView(itemView);
//    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#bindView().
//                         ^^^^^^^^ reference semanticdb maven . . itemView#
    }
    // Safe to set to null as it is only used for createNewHolder method
    parent = null;
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#parent.

    if (model instanceof GeneratedModel) {
//      ^^^^^ reference local 3
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/GeneratedModel#
      // The generated method will enforce that only a properly typed listener can be set
      //noinspection unchecked
      ((GeneratedModel) model).handlePreBind(this, objectToBind(), position);
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/GeneratedModel#
//                      ^^^^^ reference local 3
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/GeneratedModel#handlePreBind().
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                                                                 ^^^^^^^^ reference local 6
    }

    if (previouslyBoundModel != null) {
//      ^^^^^^^^^^^^^^^^^^^^ reference local 4
      // noinspection unchecked
      model.bind(objectToBind(), previouslyBoundModel);
//    ^^^^^ reference local 3
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+2).
//               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                               ^^^^^^^^^^^^^^^^^^^^ reference local 4
    } else if (payloads.isEmpty()) {
//             ^^^^^^^^ reference local 5
//                      ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      // noinspection unchecked
      model.bind(objectToBind());
//    ^^^^^ reference local 3
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
    } else {
      // noinspection unchecked
      model.bind(objectToBind(), payloads);
//    ^^^^^ reference local 3
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+1).
//               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                               ^^^^^^^^ reference local 5
    }

    if (model instanceof GeneratedModel) {
//      ^^^^^ reference local 3
//                       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/GeneratedModel#
      // The generated method will enforce that only a properly typed listener can be set
      //noinspection unchecked
      ((GeneratedModel) model).handlePostBind(objectToBind(), position);
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/GeneratedModel#
//                      ^^^^^ reference local 3
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/GeneratedModel#handlePostBind().
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                                                            ^^^^^^^^ reference local 6
    }

    epoxyModel = model;
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//               ^^^^^ reference local 3
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  Object objectToBind() {
//^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//       ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
//                    display_name objectToBind
//                    signature_documentation java @NonNull\nObject objectToBind()
    return epoxyHolder != null ? epoxyHolder : itemView;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                                             ^^^^^^^^ reference semanticdb maven . . itemView#
  }

  public void unbind() {
//            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#unbind().
//                   display_name unbind
//                   signature_documentation java public void unbind()
    assertBound();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    // noinspection unchecked
    epoxyModel.unbind(objectToBind());
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#unbind().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().

    epoxyModel = null;
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
    payloads = null;
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#payloads.
  }

  public void visibilityStateChanged(@Visibility int visibilityState) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#visibilityStateChanged().
//                                   display_name visibilityStateChanged
//                                   signature_documentation java public void visibilityStateChanged(int visibilityState)
//                                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#
//                                                   ^^^^^^^^^^^^^^^ definition local 7
//                                                                   display_name visibilityState
//                                                                   signature_documentation java @Visibility\nint visibilityState
    assertBound();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    // noinspection unchecked
    epoxyModel.onVisibilityStateChanged(visibilityState, objectToBind());
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//             ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityStateChanged().
//                                      ^^^^^^^^^^^^^^^ reference local 7
//                                                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  public void visibilityChanged(
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#visibilityChanged().
//                              display_name visibilityChanged
//                              signature_documentation java public void visibilityChanged(float percentVisibleHeight, float percentVisibleWidth, int visibleHeight, int visibleWidth)
      @FloatRange(from = 0.0f, to = 100.0f) float percentVisibleHeight,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                             ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                                ^^^^^^^^^^^^^^^^^^^^ definition local 8
//                                                                     display_name percentVisibleHeight
//                                                                     signature_documentation java @FloatRange(from = 0.0f, to = 100.0f)\nfloat percentVisibleHeight
      @FloatRange(from = 0.0f, to = 100.0f) float percentVisibleWidth,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                             ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                                ^^^^^^^^^^^^^^^^^^^ definition local 9
//                                                                    display_name percentVisibleWidth
//                                                                    signature_documentation java @FloatRange(from = 0.0f, to = 100.0f)\nfloat percentVisibleWidth
      @Px int visibleHeight,
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local 10
//                          display_name visibleHeight
//                          signature_documentation java @Px\nint visibleHeight
      @Px int visibleWidth
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^ definition local 11
//                         display_name visibleWidth
//                         signature_documentation java @Px\nint visibleWidth
  ) {
    assertBound();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    // noinspection unchecked
    epoxyModel.onVisibilityChanged(percentVisibleHeight, percentVisibleWidth, visibleHeight,
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onVisibilityChanged().
//                                 ^^^^^^^^^^^^^^^^^^^^ reference local 8
//                                                       ^^^^^^^^^^^^^^^^^^^ reference local 9
//                                                                            ^^^^^^^^^^^^^ reference local 10
        visibleWidth, objectToBind());
//      ^^^^^^^^^^^^ reference local 11
//                    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  public List<Object> getPayloads() {
//       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getPayloads().
//                                display_name getPayloads
//                                signature_documentation java public List<Object> getPayloads()
    assertBound();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    return payloads;
//         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#payloads.
  }

  public EpoxyModel<?> getModel() {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                              display_name getModel
//                              signature_documentation java public EpoxyModel<?> getModel()
    assertBound();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    return epoxyModel;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
  }

  public EpoxyHolder getHolder() {
//       ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#
//                   ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getHolder().
//                             display_name getHolder
//                             signature_documentation java public EpoxyHolder getHolder()
    assertBound();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    return epoxyHolder;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
  }

  private void assertBound() {
//             ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
//                         display_name assertBound
//                         signature_documentation java private void assertBound()
    if (epoxyModel == null) {
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
      throw new IllegalStateException("This holder is not currently bound.");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public String toString() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#toString().
//                       display_name toString
//                       signature_documentation java @Override\npublic String toString()
    return "EpoxyViewHolder{"
        + "epoxyModel=" + epoxyModel
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
        + ", view=" + itemView
//                    ^^^^^^^^ reference semanticdb maven . . itemView#
        + ", super=" + super.toString()
//                     ^^^^^ reference semanticdb maven . . super#
//                           ^^^^^^^^ reference semanticdb maven . . super#toString#
        + '}';
  }
}
