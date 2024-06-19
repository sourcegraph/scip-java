package com.airbnb.epoxy;

import android.os.Handler;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^^ reference semanticdb maven . . android/os/Handler#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#

import com.airbnb.epoxy.AsyncEpoxyDiffer.ResultCallback;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#

import org.jetbrains.annotations.NotNull;
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/annotations/
//                               ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#

import java.util.ArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.annotation.UiThread;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/UiThread#
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/DiffUtil/
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/DiffUtil/ItemCallback#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#

public final class EpoxyControllerAdapter extends BaseEpoxyAdapter implements ResultCallback {
//                 ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#
//                                        display_name EpoxyControllerAdapter
//                                        signature_documentation java public final class EpoxyControllerAdapter
//                                        kind Class
//                                        relationship is_implementation semanticdb maven . . RecyclerView/Adapter#
//                                        relationship is_implementation semanticdb maven . . StickyHeaderCallbacks#
//                                        relationship is_implementation semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
//                                        relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#
  private final NotifyBlocker notifyBlocker = new NotifyBlocker();
//              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#
//                            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                                          display_name notifyBlocker
//                                          signature_documentation java private final NotifyBlocker notifyBlocker
//                                          kind Field
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#`<init>`().
  private final AsyncEpoxyDiffer differ;
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#
//                               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                                      display_name differ
//                                      signature_documentation java private final AsyncEpoxyDiffer differ
//                                      kind Field
  private final EpoxyController epoxyController;
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                                              display_name epoxyController
//                                              signature_documentation java private final EpoxyController epoxyController
//                                              kind Field
  private int itemCount;
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
//                      display_name itemCount
//                      signature_documentation java private int itemCount
//                      kind Field
  private final List<OnModelBuildFinishedListener> modelBuildListeners = new ArrayList<>();
//              ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                                                                     display_name modelBuildListeners
//                                                                     signature_documentation java private final List<OnModelBuildFinishedListener> modelBuildListeners
//                                                                     kind Field
//                                                                           ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).

  EpoxyControllerAdapter(@NonNull EpoxyController epoxyController, Handler diffingHandler) {
//^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#`<init>`().
//                       display_name <init>
//                       signature_documentation java EpoxyControllerAdapter(EpoxyController epoxyController, unresolved_type diffingHandler)
//                       kind Constructor
//                        ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                ^^^^^^^^^^^^^^^ definition local 0
//                                                                display_name epoxyController
//                                                                signature_documentation java @NonNull\nEpoxyController epoxyController
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#`<init>`().
//                                                                 ^^^^^^^ reference semanticdb maven . . Handler#
//                                                                         ^^^^^^^^^^^^^^ definition local 1
//                                                                                        display_name diffingHandler
//                                                                                        signature_documentation java unresolved_type diffingHandler
//                                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#`<init>`().
    this.epoxyController = epoxyController;
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                         ^^^^^^^^^^^^^^^ reference local 0
    differ = new AsyncEpoxyDiffer(
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#`<init>`().
        diffingHandler,
//      ^^^^^^^^^^^^^^ reference local 1
        this,
        ITEM_CALLBACK
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#ITEM_CALLBACK.
    );
    registerAdapterDataObserver(notifyBlocker);
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#registerAdapterDataObserver#
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onExceptionSwallowed().
//                                    display_name onExceptionSwallowed
//                                    signature_documentation java @Override\nprotected void onExceptionSwallowed(RuntimeException exception)
//                                    kind Method
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onExceptionSwallowed().
//                                     ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                                              ^^^^^^^^^ definition local 2
//                                                                        display_name exception
//                                                                        signature_documentation java @NonNull\nRuntimeException exception
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onExceptionSwallowed().
    epoxyController.onExceptionSwallowed(exception);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onExceptionSwallowed().
//                                       ^^^^^^^^^ reference local 2
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  List<? extends EpoxyModel<?>> getCurrentModels() {
//^^^^ reference semanticdb maven jdk 11 java/util/List#
//               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                               display_name getCurrentModels
//                                               signature_documentation java @NonNull\n@Override\nList<? extends EpoxyModel<?>> getCurrentModels()
//                                               kind Method
//                                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
    return differ.getCurrentList();
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#getCurrentList().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getItemCount() {
//           ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getItemCount().
//                        display_name getItemCount
//                        signature_documentation java @Override\npublic int getItemCount()
//                        kind Method
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getItemCount().
    // RecyclerView calls this A LOT. The base class implementation does
    // getCurrentModels().size() which adds some overhead because of the method calls.
    // We can easily memoize this, which seems to help when there are lots of models.
    return itemCount;
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
  }

  /** This is set from whatever thread model building happened on, so must be thread safe. */
  void setModels(@NonNull ControllerModelList models) {
//     ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setModels().
//               display_name setModels
//               signature_documentation java void setModels(ControllerModelList models)
//               kind Method
//               documentation This is set from whatever thread model building happened on, so must be thread safe. 
//                ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerModelList#
//                                            ^^^^^^ definition local 3
//                                                   display_name models
//                                                   signature_documentation java @NonNull\nControllerModelList models
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setModels().
    // If debug model validations are on then we should help detect the error case where models
    // were incorrectly mutated once they were added. That check is also done before and after
    // bind, but there is no other check after that to see if a model is incorrectly
    // mutated after being bound.
    // If a data class inside a model is mutated, then when models are rebuilt the differ
    // will still recognize the old and new models as equal, even though the old model was changed.
    // To help catch that error case we check for mutations here, before running the differ.
    //
    // https://github.com/airbnb/epoxy/issues/805
    List<? extends EpoxyModel<?>> currentModels = getCurrentModels();
//  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                ^^^^^^^^^^^^^ definition local 4
//                                              display_name currentModels
//                                              signature_documentation java List<? extends EpoxyModel<?>> currentModels
//                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setModels().
//                                              kind Variable
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
    if (!currentModels.isEmpty() && currentModels.get(0).isDebugValidationEnabled()) {
//       ^^^^^^^^^^^^^ reference local 4
//                     ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
//                                  ^^^^^^^^^^^^^ reference local 4
//                                                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isDebugValidationEnabled().
      for (int i = 0; i < currentModels.size(); i++) {
//             ^ definition local 5
//               display_name i
//               signature_documentation java int i
//               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setModels().
//               kind Variable
//                    ^ reference local 5
//                        ^^^^^^^^^^^^^ reference local 4
//                                      ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
//                                              ^ reference local 5
        EpoxyModel<?> model = currentModels.get(i);
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^ definition local 6
//                          display_name model
//                          signature_documentation java EpoxyModel<?> model
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setModels().
//                          kind Variable
//                            ^^^^^^^^^^^^^ reference local 4
//                                          ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                              ^ reference local 5
        model.validateStateHasNotChangedSinceAdded(
//      ^^^^^ reference local 6
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#validateStateHasNotChangedSinceAdded().
            "The model was changed between being bound and when models were rebuilt",
            i
//          ^ reference local 5
        );
      }
    }

    differ.submitList(models);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#submitList().
//                    ^^^^^^ reference local 3
  }

  /**
   * @return True if a diff operation is in progress.
   */
  public boolean isDiffInProgress() {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#isDiffInProgress().
//                                display_name isDiffInProgress
//                                signature_documentation java public boolean isDiffInProgress()
//                                kind Method
//                                documentation  @return True if a diff operation is in progress.\n
    return differ.isDiffInProgress();
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#isDiffInProgress().
  }

  // Called on diff results from the differ
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onResult(@NonNull DiffResult result) {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onResult().
//                     display_name onResult
//                     signature_documentation java @Override\npublic void onResult(DiffResult result)
//                     kind Method
//                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#ResultCallback#onResult().
//                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                         ^^^^^^ definition local 7
//                                                display_name result
//                                                signature_documentation java @NonNull\nDiffResult result
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onResult().
    itemCount = result.newModels.size();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#itemCount.
//              ^^^^^^ reference local 7
//                     ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#newModels.
//                               ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    notifyBlocker.allowChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#allowChanges().
    result.dispatchTo(this);
//  ^^^^^^ reference local 7
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#dispatchTo().
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#blockChanges().

    for (int i = modelBuildListeners.size() - 1; i >= 0; i--) {
//           ^ definition local 8
//             display_name i
//             signature_documentation java int i
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onResult().
//             kind Variable
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                                   ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
//                                               ^ reference local 8
//                                                       ^ reference local 8
      modelBuildListeners.get(i).onModelBuildFinished(result);
//    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                        ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                            ^ reference local 8
//                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#onModelBuildFinished().
//                                                    ^^^^^^ reference local 7
    }
  }

  public void addModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#addModelBuildListener().
//                                  display_name addModelBuildListener
//                                  signature_documentation java public void addModelBuildListener(OnModelBuildFinishedListener listener)
//                                  kind Method
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                               ^^^^^^^^ definition local 9
//                                                                        display_name listener
//                                                                        signature_documentation java OnModelBuildFinishedListener listener
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#addModelBuildListener().
    modelBuildListeners.add(listener);
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                      ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//                          ^^^^^^^^ reference local 9
  }

  public void removeModelBuildListener(OnModelBuildFinishedListener listener) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#removeModelBuildListener().
//                                     display_name removeModelBuildListener
//                                     signature_documentation java public void removeModelBuildListener(OnModelBuildFinishedListener listener)
//                                     kind Method
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                                                  ^^^^^^^^ definition local 10
//                                                                           display_name listener
//                                                                           signature_documentation java OnModelBuildFinishedListener listener
//                                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#removeModelBuildListener().
    modelBuildListeners.remove(listener);
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#modelBuildListeners.
//                      ^^^^^^ reference semanticdb maven jdk 11 java/util/List#remove().
//                             ^^^^^^^^ reference local 10
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  boolean diffPayloadsEnabled() {
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#diffPayloadsEnabled().
//                            display_name diffPayloadsEnabled
//                            signature_documentation java @Override\nboolean diffPayloadsEnabled()
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
    return true;
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onAttachedToRecyclerView().
//                                     display_name onAttachedToRecyclerView
//                                     signature_documentation java @Override\npublic void onAttachedToRecyclerView(unresolved_type recyclerView)
//                                     kind Method
//                                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                           ^^^^^^^^^^^^ definition local 11
//                                                                        display_name recyclerView
//                                                                        signature_documentation java @NonNull\nunresolved_type recyclerView
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onAttachedToRecyclerView().
    super.onAttachedToRecyclerView(recyclerView);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onAttachedToRecyclerView#
//                                 ^^^^^^^^^^^^ reference local 11
    epoxyController.onAttachedToRecyclerViewInternal(recyclerView);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onAttachedToRecyclerViewInternal().
//                                                   ^^^^^^^^^^^^ reference local 11
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onDetachedFromRecyclerView().
//                                       display_name onDetachedFromRecyclerView
//                                       signature_documentation java @Override\npublic void onDetachedFromRecyclerView(unresolved_type recyclerView)
//                                       kind Method
//                                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onDetachedFromRecyclerView().
//                                        ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                             ^^^^^^^^^^^^ definition local 12
//                                                                          display_name recyclerView
//                                                                          signature_documentation java @NonNull\nunresolved_type recyclerView
//                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onDetachedFromRecyclerView().
    super.onDetachedFromRecyclerView(recyclerView);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onDetachedFromRecyclerView().
//                                   ^^^^^^^^^^^^ reference local 12
    epoxyController.onDetachedFromRecyclerViewInternal(recyclerView);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onDetachedFromRecyclerViewInternal().
//                                                     ^^^^^^^^^^^^ reference local 12
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewAttachedToWindow(@NonNull EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onViewAttachedToWindow().
//                                   display_name onViewAttachedToWindow
//                                   signature_documentation java @Override\npublic void onViewAttachedToWindow(EpoxyViewHolder holder)
//                                   kind Method
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewAttachedToWindow().
//                                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                            ^^^^^^ definition local 13
//                                                                   display_name holder
//                                                                   signature_documentation java @NonNull\nEpoxyViewHolder holder
//                                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onViewAttachedToWindow().
    super.onViewAttachedToWindow(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewAttachedToWindow().
//                               ^^^^^^ reference local 13
    epoxyController.onViewAttachedToWindow(holder, holder.getModel());
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onViewAttachedToWindow().
//                                         ^^^^^^ reference local 13
//                                                 ^^^^^^ reference local 13
//                                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewDetachedFromWindow(@NonNull EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onViewDetachedFromWindow().
//                                     display_name onViewDetachedFromWindow
//                                     signature_documentation java @Override\npublic void onViewDetachedFromWindow(EpoxyViewHolder holder)
//                                     kind Method
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewDetachedFromWindow().
//                                      ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                              ^^^^^^ definition local 14
//                                                                     display_name holder
//                                                                     signature_documentation java @NonNull\nEpoxyViewHolder holder
//                                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onViewDetachedFromWindow().
    super.onViewDetachedFromWindow(holder);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewDetachedFromWindow().
//                                 ^^^^^^ reference local 14
    epoxyController.onViewDetachedFromWindow(holder, holder.getModel());
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onViewDetachedFromWindow().
//                                           ^^^^^^ reference local 14
//                                                   ^^^^^^ reference local 14
//                                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onModelBound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model,
//               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelBound().
//                            display_name onModelBound
//                            signature_documentation java @Override\nprotected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position, EpoxyModel<?> previouslyBoundModel)
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
//                             ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local 15
//                                                            display_name holder
//                                                            signature_documentation java @NonNull\nEpoxyViewHolder holder
//                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelBound().
//                                                              ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                    ^^^^^ definition local 16
//                                                                                          display_name model
//                                                                                          signature_documentation java @NonNull\nEpoxyModel<?> model
//                                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelBound().
      int position, @Nullable EpoxyModel<?> previouslyBoundModel) {
//        ^^^^^^^^ definition local 17
//                 display_name position
//                 signature_documentation java int position
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelBound().
//                   ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^^^^^^^^^^^^^^^ definition local 18
//                                                               display_name previouslyBoundModel
//                                                               signature_documentation java @Nullable\nEpoxyModel<?> previouslyBoundModel
//                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelBound().
    epoxyController.onModelBound(holder, model, position, previouslyBoundModel);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onModelBound().
//                               ^^^^^^ reference local 15
//                                       ^^^^^ reference local 16
//                                              ^^^^^^^^ reference local 17
//                                                        ^^^^^^^^^^^^^^^^^^^^ reference local 18
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void onModelUnbound(@NonNull EpoxyViewHolder holder, @NonNull EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelUnbound().
//                              display_name onModelUnbound
//                              signature_documentation java @Override\nprotected void onModelUnbound(EpoxyViewHolder holder, EpoxyModel<?> model)
//                              kind Method
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound().
//                               ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                       ^^^^^^ definition local 19
//                                                              display_name holder
//                                                              signature_documentation java @NonNull\nEpoxyViewHolder holder
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelUnbound().
//                                                                ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                      ^^^^^ definition local 20
//                                                                                            display_name model
//                                                                                            signature_documentation java @NonNull\nEpoxyModel<?> model
//                                                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelUnbound().
    epoxyController.onModelUnbound(holder, model);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#onModelUnbound().
//                                 ^^^^^^ reference local 19
//                                         ^^^^^ reference local 20
  }

  /** Get an unmodifiable copy of the current models set on the adapter. */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public List<EpoxyModel<?>> getCopyOfModels() {
//       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCopyOfModels().
//                                           display_name getCopyOfModels
//                                           signature_documentation java @NonNull\npublic List<EpoxyModel<?>> getCopyOfModels()
//                                           kind Method
//                                           documentation Get an unmodifiable copy of the current models set on the adapter. 
    //noinspection unchecked
    return (List<EpoxyModel<?>>) getCurrentModels();
//          ^^^^ reference semanticdb maven jdk 11 java/util/List#
//               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
  }

  /**
   * @throws IndexOutOfBoundsException If the given position is out of range of the current model
   *                                   list.
   */
  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public EpoxyModel<?> getModelAtPosition(int position) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelAtPosition().
//                                        display_name getModelAtPosition
//                                        signature_documentation java @NonNull\npublic EpoxyModel<?> getModelAtPosition(int position)
//                                        kind Method
//                                        documentation  @throws IndexOutOfBoundsException If the given position is out of range of the current model\n                                   list.\n
//                                            ^^^^^^^^ definition local 21
//                                                     display_name position
//                                                     signature_documentation java int position
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelAtPosition().
    return getCurrentModels().get(position);
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                            ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                ^^^^^^^^ reference local 21
  }

  /**
   * Searches the current model list for the model with the given id. Returns the matching model if
   * one is found, otherwise null is returned.
   */
  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public EpoxyModel<?> getModelById(long id) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelById().
//                                  display_name getModelById
//                                  signature_documentation java @Nullable\npublic EpoxyModel<?> getModelById(long id)
//                                  kind Method
//                                  documentation  Searches the current model list for the model with the given id. Returns the matching model if\n one is found, otherwise null is returned.\n
//                                       ^^ definition local 22
//                                          display_name id
//                                          signature_documentation java long id
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelById().
    for (EpoxyModel<?> model : getCurrentModels()) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local 23
//                           display_name model
//                           signature_documentation java EpoxyModel<?> model
//                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelById().
//                           kind Variable
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
      if (model.id() == id) {
//        ^^^^^ reference local 23
//              ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//                      ^^ reference local 22
        return model;
//             ^^^^^ reference local 23
      }
    }

    return null;
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getModelPosition(@NonNull EpoxyModel<?> targetModel) {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition().
//                            display_name getModelPosition
//                            signature_documentation java @Override\npublic int getModelPosition(EpoxyModel<?> targetModel)
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                             ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                   ^^^^^^^^^^^ definition local 24
//                                                               display_name targetModel
//                                                               signature_documentation java @NonNull\nEpoxyModel<?> targetModel
//                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition().
    int size = getCurrentModels().size();
//      ^^^^ definition local 25
//           display_name size
//           signature_documentation java int size
//           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition().
//           kind Variable
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local 26
//             display_name i
//             signature_documentation java int i
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition().
//             kind Variable
//                  ^ reference local 26
//                      ^^^^ reference local 25
//                            ^ reference local 26
      EpoxyModel<?> model = getCurrentModels().get(i);
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^^^^^ definition local 27
//                        display_name model
//                        signature_documentation java EpoxyModel<?> model
//                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition().
//                        kind Variable
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().
//                                             ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                                 ^ reference local 26
      if (model.id() == targetModel.id()) {
//        ^^^^^ reference local 27
//              ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//                      ^^^^^^^^^^^ reference local 24
//                                  ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
        return i;
//             ^ reference local 26
      }
    }

    return -1;
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public BoundViewHolders getBoundViewHolders() {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#
//                        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getBoundViewHolders().
//                                            display_name getBoundViewHolders
//                                            signature_documentation java @NonNull\n@Override\npublic BoundViewHolders getBoundViewHolders()
//                                            kind Method
//                                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
    return super.getBoundViewHolders();
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#super.
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
  }

  @UiThread
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/UiThread#
  void moveModel(int fromPosition, int toPosition) {
//     ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#moveModel().
//               display_name moveModel
//               signature_documentation java @UiThread\nvoid moveModel(int fromPosition, int toPosition)
//               kind Method
//                   ^^^^^^^^^^^^ definition local 28
//                                display_name fromPosition
//                                signature_documentation java int fromPosition
//                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#moveModel().
//                                     ^^^^^^^^^^ definition local 29
//                                                display_name toPosition
//                                                signature_documentation java int toPosition
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#moveModel().
    ArrayList<EpoxyModel<?>> updatedList = new ArrayList<>(getCurrentModels());
//  ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^ definition local 30
//                                       display_name updatedList
//                                       signature_documentation java ArrayList<EpoxyModel<?>> updatedList
//                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#moveModel().
//                                       kind Variable
//                                             ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+2).
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().

    updatedList.add(toPosition, updatedList.remove(fromPosition));
//  ^^^^^^^^^^^ reference local 30
//              ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add(+1).
//                  ^^^^^^^^^^ reference local 29
//                              ^^^^^^^^^^^ reference local 30
//                                          ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#remove().
//                                                 ^^^^^^^^^^^^ reference local 28
    notifyBlocker.allowChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#allowChanges().
    notifyItemMoved(fromPosition, toPosition);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyItemMoved#
//                  ^^^^^^^^^^^^ reference local 28
//                                ^^^^^^^^^^ reference local 29
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#blockChanges().

    boolean interruptedDiff = differ.forceListOverride(updatedList);
//          ^^^^^^^^^^^^^^^ definition local 31
//                          display_name interruptedDiff
//                          signature_documentation java boolean interruptedDiff
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#moveModel().
//                          kind Variable
//                            ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
//                                                     ^^^^^^^^^^^ reference local 30

    if (interruptedDiff) {
//      ^^^^^^^^^^^^^^^ reference local 31
      // The move interrupted a model rebuild/diff that was in progress,
      // so models may be out of date and we should force them to rebuilt
      epoxyController.requestModelBuild();
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
    }
  }

  @UiThread
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/UiThread#
  void notifyModelChanged(int position) {
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyModelChanged().
//                        display_name notifyModelChanged
//                        signature_documentation java @UiThread\nvoid notifyModelChanged(int position)
//                        kind Method
//                            ^^^^^^^^ definition local 32
//                                     display_name position
//                                     signature_documentation java int position
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyModelChanged().
    ArrayList<EpoxyModel<?>> updatedList = new ArrayList<>(getCurrentModels());
//  ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^ definition local 33
//                                       display_name updatedList
//                                       signature_documentation java ArrayList<EpoxyModel<?>> updatedList
//                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyModelChanged().
//                                       kind Variable
//                                             ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+2).
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().

    notifyBlocker.allowChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#allowChanges().
    notifyItemChanged(position);
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyItemChanged#
//                    ^^^^^^^^ reference local 32
    notifyBlocker.blockChanges();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyBlocker.
//                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#blockChanges().

    boolean interruptedDiff = differ.forceListOverride(updatedList);
//          ^^^^^^^^^^^^^^^ definition local 34
//                          display_name interruptedDiff
//                          signature_documentation java boolean interruptedDiff
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#notifyModelChanged().
//                          kind Variable
//                            ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#differ.
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/AsyncEpoxyDiffer#forceListOverride().
//                                                     ^^^^^^^^^^^ reference local 33

    if (interruptedDiff) {
//      ^^^^^^^^^^^^^^^ reference local 34
      // The move interrupted a model rebuild/diff that was in progress,
      // so models may be out of date and we should force them to rebuilt
      epoxyController.requestModelBuild();
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#requestModelBuild().
    }
  }

  private static final ItemCallback<EpoxyModel<?>> ITEM_CALLBACK =
//                     ^^^^^^^^^^^^ reference semanticdb maven . . ItemCallback#
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#ITEM_CALLBACK.
//                                                               display_name ITEM_CALLBACK
//                                                               signature_documentation java private static final unresolved_type ITEM_CALLBACK
//                                                               kind StaticField
      new ItemCallback<EpoxyModel<?>>() {
//        ^^^^^^^^^^^^ reference semanticdb maven . . ItemCallback#
//                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
        @Override
        public boolean areItemsTheSame(EpoxyModel<?> oldItem, EpoxyModel<?> newItem) {
          return oldItem.id() == newItem.id();
        }

        @Override
        public boolean areContentsTheSame(EpoxyModel<?> oldItem, EpoxyModel<?> newItem) {
          return oldItem.equals(newItem);
        }

        @Override
        public Object getChangePayload(EpoxyModel<?> oldItem, EpoxyModel<?> newItem) {
          return new DiffPayload(oldItem);
        }
      };

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean isStickyHeader(int position) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#isStickyHeader().
//                              display_name isStickyHeader
//                              signature_documentation java @Override\npublic boolean isStickyHeader(int position)
//                              kind Method
//                              documentation  Delegates the callbacks received in the adapter\n to the controller.\n
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#isStickyHeader().
//                                  ^^^^^^^^ definition local 35
//                                           display_name position
//                                           signature_documentation java int position
//                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#isStickyHeader().
    return epoxyController.isStickyHeader(position);
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                         ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#isStickyHeader().
//                                        ^^^^^^^^ reference local 35
  }

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void setupStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setupStickyHeaderView().
//                                  display_name setupStickyHeaderView
//                                  signature_documentation java @Override\npublic void setupStickyHeaderView(unresolved_type stickyHeader)
//                                  kind Method
//                                  documentation  Delegates the callbacks received in the adapter\n to the controller.\n
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#setupStickyHeaderView().
//                                   ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#
//                                           ^^^^ reference semanticdb maven . . View#
//                                                ^^^^^^^^^^^^ definition local 36
//                                                             display_name stickyHeader
//                                                             signature_documentation java @NotNull\nunresolved_type stickyHeader
//                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setupStickyHeaderView().
    epoxyController.setupStickyHeaderView(stickyHeader);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#setupStickyHeaderView().
//                                        ^^^^^^^^^^^^ reference local 36
  }

  /**
   * Delegates the callbacks received in the adapter
   * to the controller.
   */
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void teardownStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#teardownStickyHeaderView().
//                                     display_name teardownStickyHeaderView
//                                     signature_documentation java @Override\npublic void teardownStickyHeaderView(unresolved_type stickyHeader)
//                                     kind Method
//                                     documentation  Delegates the callbacks received in the adapter\n to the controller.\n
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#teardownStickyHeaderView().
//                                      ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#
//                                              ^^^^ reference semanticdb maven . . View#
//                                                   ^^^^^^^^^^^^ definition local 37
//                                                                display_name stickyHeader
//                                                                signature_documentation java @NotNull\nunresolved_type stickyHeader
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#teardownStickyHeaderView().
    epoxyController.teardownStickyHeaderView(stickyHeader);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#epoxyController.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#teardownStickyHeaderView().
//                                           ^^^^^^^^^^^^ reference local 37
  }
}
