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
//                           documentation ```java\n@SuppressWarnings("WeakerAccess")\npublic class EpoxyViewHolder\n```
//                           relationship is_implementation semanticdb maven . . RecyclerView/ViewHolder#
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/
//                                                ^^^^^^^^^^ reference semanticdb maven . . RecyclerView/ViewHolder#
  @SuppressWarnings("rawtypes") private EpoxyModel epoxyModel;
// ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
//                                                            documentation ```java\n@SuppressWarnings("rawtypes")\nprivate EpoxyModel epoxyModel\n```
  private List<Object> payloads;
//        ^^^^ reference semanticdb maven jdk 11 java/util/List#
//             ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#payloads.
//                              documentation ```java\nprivate List<Object> payloads\n```
  private EpoxyHolder epoxyHolder;
//        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#
//                    ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                                documentation ```java\nprivate EpoxyHolder epoxyHolder\n```
  @Nullable ViewHolderState.ViewState initialViewState;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#
//                          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#
//                                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
//                                                     documentation ```java\n@Nullable\nViewState initialViewState\n```

  // Once the EpoxyHolder is created parent will be set to null.
  private ViewParent parent;
//        ^^^^^^^^^^ reference semanticdb maven . . _root_/
//                   ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#parent.
//                          documentation ```java\nprivate unresolved_type parent\n```

  public EpoxyViewHolder(ViewParent parent, View view, boolean saveInitialState) {
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#`<init>`().
//                       documentation ```java\npublic EpoxyViewHolder(unresolved_type parent, unresolved_type view, boolean saveInitialState)\n```
//                       ^^^^^^^^^^ reference semanticdb maven . . _root_/
//                                  ^^^^^^ definition local 0
//                                         documentation ```java\nunresolved_type parent\n```
//                                          ^^^^ reference semanticdb maven . . _root_/
//                                               ^^^^ definition local 1
//                                                    documentation ```java\nunresolved_type view\n```
//                                                             ^^^^^^^^^^^^^^^^ definition local 2
//                                                                              documentation ```java\nboolean saveInitialState\n```
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
//                          ^^^^^^^^ reference semanticdb maven . . _root_/
    }
  }

  void restoreInitialViewState() {
//     ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#restoreInitialViewState().
//                             documentation ```java\nvoid restoreInitialViewState()\n```
    if (initialViewState != null) {
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
      initialViewState.restore(itemView);
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#initialViewState.
//                     ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#ViewState#restore().
//                             ^^^^^^^^ reference semanticdb maven . . _root_/
    }
  }

  public void bind(@SuppressWarnings("rawtypes") EpoxyModel model,
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#bind().
//                 documentation ```java\npublic void bind(EpoxyModel model, EpoxyModel<?> previouslyBoundModel, List<Object> payloads, int position)\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
//                                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^ definition local 3
//                                                                documentation ```java\n@SuppressWarnings("rawtypes")\nEpoxyModel model\n```
      @Nullable EpoxyModel<?> previouslyBoundModel, List<Object> payloads, int position) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^^^^^^^^^^^^^^ definition local 4
//                                                 documentation ```java\n@Nullable\nEpoxyModel<?> previouslyBoundModel\n```
//                                                  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                               ^^^^^^^^ definition local 5
//                                                                        documentation ```java\nList<Object> payloads\n```
//                                                                             ^^^^^^^^ definition local 6
//                                                                                      documentation ```java\nint position\n```
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
//                         ^^^^^^^^ reference semanticdb maven . . _root_/
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
//                    documentation ```java\n@NonNull\nObject objectToBind()\n```
    return epoxyHolder != null ? epoxyHolder : itemView;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
//                                             ^^^^^^^^ reference semanticdb maven . . _root_/
  }

  public void unbind() {
//            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#unbind().
//                   documentation ```java\npublic void unbind()\n```
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
//                                   documentation ```java\npublic void visibilityStateChanged(int visibilityState)\n```
//                                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#
//                                                   ^^^^^^^^^^^^^^^ definition local 7
//                                                                   documentation ```java\n@Visibility\nint visibilityState\n```
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
//                              documentation ```java\npublic void visibilityChanged(float percentVisibleHeight, float percentVisibleWidth, int visibleHeight, int visibleWidth)\n```
      @FloatRange(from = 0.0f, to = 100.0f) float percentVisibleHeight,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                             ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                                ^^^^^^^^^^^^^^^^^^^^ definition local 8
//                                                                     documentation ```java\n@FloatRange(from = 0.0f, to = 100.0f)\nfloat percentVisibleHeight\n```
      @FloatRange(from = 0.0f, to = 100.0f) float percentVisibleWidth,
//     ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#
//                ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#from().
//                             ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/FloatRange#to().
//                                                ^^^^^^^^^^^^^^^^^^^ definition local 9
//                                                                    documentation ```java\n@FloatRange(from = 0.0f, to = 100.0f)\nfloat percentVisibleWidth\n```
      @Px int visibleHeight,
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^^ definition local 10
//                          documentation ```java\n@Px\nint visibleHeight\n```
      @Px int visibleWidth
//     ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
//            ^^^^^^^^^^^^ definition local 11
//                         documentation ```java\n@Px\nint visibleWidth\n```
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
//                                documentation ```java\npublic List<Object> getPayloads()\n```
    assertBound();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    return payloads;
//         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#payloads.
  }

  public EpoxyModel<?> getModel() {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                              documentation ```java\npublic EpoxyModel<?> getModel()\n```
    assertBound();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    return epoxyModel;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
  }

  public EpoxyHolder getHolder() {
//       ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyHolder#
//                   ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getHolder().
//                             documentation ```java\npublic EpoxyHolder getHolder()\n```
    assertBound();
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
    return epoxyHolder;
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyHolder.
  }

  private void assertBound() {
//             ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#assertBound().
//                         documentation ```java\nprivate void assertBound()\n```
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
//                       documentation ```java\n@Override\npublic String toString()\n```
    return "EpoxyViewHolder{"
        + "epoxyModel=" + epoxyModel
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#epoxyModel.
        + ", view=" + itemView
//                    ^^^^^^^^ reference semanticdb maven . . _root_/
        + ", super=" + super.toString()
//                     ^^^^^ reference semanticdb maven . . _root_/
//                           ^^^^^^^^ reference semanticdb maven . . toString#
        + '}';
  }
}
