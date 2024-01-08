package com.airbnb.epoxy;

import android.os.Bundle;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^ reference semanticdb maven . . android/os/
//                ^^^^^^ reference semanticdb maven . . android/os/Bundle#
import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#
import android.view.ViewGroup;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^ reference semanticdb maven . . android/view/ViewGroup#

import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks;
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderCallbacks#

import org.jetbrains.annotations.NotNull;
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/annotations/
//                               ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#

import java.util.Collections;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.annotation.CallSuper;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/GridLayoutManager/
//                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/GridLayoutManager/SpanSizeLookup#
import androidx.recyclerview.widget.RecyclerView;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView#

public abstract class BaseEpoxyAdapter
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                                     display_name BaseEpoxyAdapter
//                                     signature_documentation java public abstract class BaseEpoxyAdapter
//                                     kind Class
//                                     relationship is_implementation semanticdb maven . . RecyclerView/Adapter#
//                                     relationship is_implementation semanticdb maven . . StickyHeaderCallbacks#
    extends RecyclerView.Adapter<EpoxyViewHolder>
//          ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView/
//                       ^^^^^^^ reference semanticdb maven . . RecyclerView/Adapter#
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
    implements StickyHeaderCallbacks {
//             ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . StickyHeaderCallbacks#

  private static final String SAVED_STATE_ARG_VIEW_HOLDERS = "saved_state_view_holders";
//                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#SAVED_STATE_ARG_VIEW_HOLDERS.
//                                                         display_name SAVED_STATE_ARG_VIEW_HOLDERS
//                                                         signature_documentation java private static final String SAVED_STATE_ARG_VIEW_HOLDERS
//                                                         kind StaticField

  private int spanCount = 1;
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
//                      display_name spanCount
//                      signature_documentation java private int spanCount
//                      kind Field

  private final ViewTypeManager viewTypeManager = new ViewTypeManager();
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#
//                              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                                              display_name viewTypeManager
//                                              signature_documentation java private final ViewTypeManager viewTypeManager
//                                              kind Field
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#`<init>`().
  /**
   * Keeps track of view holders that are currently bound so we can save their state in {@link
   * #onSaveInstanceState(Bundle)}.
   */
  private final BoundViewHolders boundViewHolders = new BoundViewHolders();
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#
//                               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                                                display_name boundViewHolders
//                                                signature_documentation java private final BoundViewHolders boundViewHolders
//                                                kind Field
//                                                documentation  Keeps track of view holders that are currently bound so we can save their state in {@link\n #onSaveInstanceState(Bundle)}.\n
//                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#`<init>`().
  private ViewHolderState viewHolderState = new ViewHolderState();
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#
//                        ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                                        display_name viewHolderState
//                                        signature_documentation java private ViewHolderState viewHolderState
//                                        kind Field
//                                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#`<init>`().

  private final SpanSizeLookup spanSizeLookup = new SpanSizeLookup() {
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#
//                             ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#spanSizeLookup.
//                                            display_name spanSizeLookup
//                                            signature_documentation java private final unresolved_type spanSizeLookup
//                                            kind Field
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#

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
//       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#`<init>`().
//                        display_name <init>
//                        signature_documentation java public BaseEpoxyAdapter()
//                        kind Constructor
    // Defaults to stable ids since view models generate unique ids. Set this to false in the
    // subclass if you don't want to support it
    setHasStableIds(true);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#setHasStableIds#
    spanSizeLookup.setSpanIndexCacheEnabled(true);
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#spanSizeLookup.
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#setSpanIndexCacheEnabled#
  }

  /**
   * This is called when recoverable exceptions happen at runtime. They can be ignored and Epoxy
   * will recover, but you can override this to be aware of when they happen.
   */
  protected void onExceptionSwallowed(RuntimeException exception) {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onExceptionSwallowed().
//                                    display_name onExceptionSwallowed
//                                    signature_documentation java protected void onExceptionSwallowed(RuntimeException exception)
//                                    kind Method
//                                    documentation  This is called when recoverable exceptions happen at runtime. They can be ignored and Epoxy\n will recover, but you can override this to be aware of when they happen.\n
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onExceptionSwallowed().
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                                                     ^^^^^^^^^ definition local 0
//                                                               display_name exception
//                                                               signature_documentation java RuntimeException exception
//                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onExceptionSwallowed().

  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getItemCount() {
//           ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getItemCount().
//                        display_name getItemCount
//                        signature_documentation java @Override\npublic int getItemCount()
//                        kind Method
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getItemCount().
    return getCurrentModels().size();
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
  }

  /** Return the models currently being used by the adapter to populate the recyclerview. */
  abstract List<? extends EpoxyModel<?>> getCurrentModels();
//         ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                                        display_name getCurrentModels
//                                                        signature_documentation java abstract List<? extends EpoxyModel<?>> getCurrentModels()
//                                                        kind AbstractMethod
//                                                        documentation Return the models currently being used by the adapter to populate the recyclerview. 
//                                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getCurrentModels().
//                                                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getCurrentModels().

  public boolean isEmpty() {
//               ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#isEmpty().
//                       display_name isEmpty
//                       signature_documentation java public boolean isEmpty()
//                       kind Method
    return getCurrentModels().isEmpty();
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public long getItemId(int position) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getItemId().
//                      display_name getItemId
//                      signature_documentation java @Override\npublic long getItemId(int position)
//                      kind Method
//                          ^^^^^^^^ definition local 1
//                                   display_name position
//                                   signature_documentation java int position
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getItemId().
    // This does not call getModelForPosition so that we don't use the id of the empty model when
    // hidden,
    // so that the id stays constant when gone vs shown
    return getCurrentModels().get(position).id();
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                ^^^^^^^^ reference local 1
//                                          ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getItemViewType(int position) {
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getItemViewType().
//                           display_name getItemViewType
//                           signature_documentation java @Override\npublic int getItemViewType(int position)
//                           kind Method
//                               ^^^^^^^^ definition local 2
//                                        display_name position
//                                        signature_documentation java int position
//                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getItemViewType().
    return viewTypeManager.getViewTypeAndRememberModel(getModelForPosition(position));
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#getViewTypeAndRememberModel().
//                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                                                         ^^^^^^^^ reference local 2
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public EpoxyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onCreateViewHolder().
//                                          display_name onCreateViewHolder
//                                          signature_documentation java @Override\npublic EpoxyViewHolder onCreateViewHolder(unresolved_type parent, int viewType)
//                                          kind Method
//                                          ^^^^^^^^^ reference semanticdb maven . . ViewGroup#
//                                                    ^^^^^^ definition local 3
//                                                           display_name parent
//                                                           signature_documentation java unresolved_type parent
//                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onCreateViewHolder().
//                                                                ^^^^^^^^ definition local 4
//                                                                         display_name viewType
//                                                                         signature_documentation java int viewType
//                                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onCreateViewHolder().
    EpoxyModel<?> model = viewTypeManager.getModelForViewType(this, viewType);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 5
//                      display_name model
//                      signature_documentation java EpoxyModel<?> model
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onCreateViewHolder().
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#getModelForViewType().
//                                                                  ^^^^^^^^ reference local 4
    View view = model.buildView(parent);
//  ^^^^ reference semanticdb maven . . View#
//       ^^^^ definition local 6
//            display_name view
//            signature_documentation java unresolved_type view
//            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onCreateViewHolder().
//              ^^^^^ reference local 5
//                    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#buildView().
//                              ^^^^^^ reference local 3
    return new EpoxyViewHolder(parent, view, model.shouldSaveViewState());
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#`<init>`().
//                             ^^^^^^ reference local 3
//                                     ^^^^ reference local 6
//                                           ^^^^^ reference local 5
//                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onBindViewHolder(EpoxyViewHolder holder, int position) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder().
//                             display_name onBindViewHolder
//                             signature_documentation java @Override\npublic void onBindViewHolder(EpoxyViewHolder holder, int position)
//                             kind Method
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                             ^^^^^^ definition local 7
//                                                    display_name holder
//                                                    signature_documentation java EpoxyViewHolder holder
//                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder().
//                                                         ^^^^^^^^ definition local 8
//                                                                  display_name position
//                                                                  signature_documentation java int position
//                                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder().
    onBindViewHolder(holder, position, Collections.emptyList());
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
//                   ^^^^^^ reference local 7
//                           ^^^^^^^^ reference local 8
//                                     ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                                 ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#emptyList().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onBindViewHolder(EpoxyViewHolder holder, int position, List<Object> payloads) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
//                             display_name onBindViewHolder
//                             signature_documentation java @Override\npublic void onBindViewHolder(EpoxyViewHolder holder, int position, List<Object> payloads)
//                             kind Method
//                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                             ^^^^^^ definition local 9
//                                                    display_name holder
//                                                    signature_documentation java EpoxyViewHolder holder
//                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
//                                                         ^^^^^^^^ definition local 10
//                                                                  display_name position
//                                                                  signature_documentation java int position
//                                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
//                                                                   ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                                ^^^^^^^^ definition local 11
//                                                                                         display_name payloads
//                                                                                         signature_documentation java List<Object> payloads
//                                                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
    EpoxyModel<?> modelToShow = getModelForPosition(position);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^^^^^^ definition local 12
//                            display_name modelToShow
//                            signature_documentation java EpoxyModel<?> modelToShow
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                                  ^^^^^^^^ reference local 10

    EpoxyModel<?> previouslyBoundModel = null;
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^^^^^^^^^^^^^^^ definition local 13
//                                     display_name previouslyBoundModel
//                                     signature_documentation java EpoxyModel<?> previouslyBoundModel
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onBindViewHolder(+1).
    if (diffPayloadsEnabled()) {
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
      previouslyBoundModel = DiffPayload.getModelFromPayload(payloads, getItemId(position));
//    ^^^^^^^^^^^^^^^^^^^^ reference local 13
//                           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#
//                                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffPayload#getModelFromPayload().
//                                                           ^^^^^^^^ reference local 11
//                                                                     ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getItemId().
//                                                                               ^^^^^^^^ reference local 10
    }

    holder.bind(modelToShow, previouslyBoundModel, payloads, position);
//  ^^^^^^ reference local 9
//         ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#bind().
//              ^^^^^^^^^^^ reference local 12
//                           ^^^^^^^^^^^^^^^^^^^^ reference local 13
//                                                 ^^^^^^^^ reference local 11
//                                                           ^^^^^^^^ reference local 10

    if (payloads.isEmpty()) {
//      ^^^^^^^^ reference local 11
//               ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      // We only apply saved state to the view on initial bind, not on model updates.
      // Since view state should be independent of model props, we should not need to apply state
      // again in this case. This simplifies a rebind on update
      viewHolderState.restore(holder);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#restore().
//                            ^^^^^^ reference local 9
    }

    boundViewHolders.put(holder);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                   ^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#put().
//                       ^^^^^^ reference local 9

    if (diffPayloadsEnabled()) {
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
      onModelBound(holder, modelToShow, position, previouslyBoundModel);
//    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
//                 ^^^^^^ reference local 9
//                         ^^^^^^^^^^^ reference local 12
//                                      ^^^^^^^^ reference local 10
//                                                ^^^^^^^^^^^^^^^^^^^^ reference local 13
    } else {
      onModelBound(holder, modelToShow, position, payloads);
//    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
//                 ^^^^^^ reference local 9
//                         ^^^^^^^^^^^ reference local 12
//                                      ^^^^^^^^ reference local 10
//                                                ^^^^^^^^ reference local 11
    }
  }

  boolean diffPayloadsEnabled() {
//        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#diffPayloadsEnabled().
//                            display_name diffPayloadsEnabled
//                            signature_documentation java boolean diffPayloadsEnabled()
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#diffPayloadsEnabled().
    return false;
  }

  /**
   * Called immediately after a model is bound to a view holder. Subclasses can override this if
   * they want alerts on when a model is bound.
   */
  protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position,
//               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
//                            display_name onModelBound
//                            signature_documentation java protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position, List<Object> payloads)
//                            kind Method
//                            documentation  Called immediately after a model is bound to a view holder. Subclasses can override this if\n they want alerts on when a model is bound.\n
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^ definition local 14
//                                                   display_name holder
//                                                   signature_documentation java EpoxyViewHolder holder
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
//                                                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^ definition local 15
//                                                                        display_name model
//                                                                        signature_documentation java EpoxyModel<?> model
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
//                                                                             ^^^^^^^^ definition local 16
//                                                                                      display_name position
//                                                                                      signature_documentation java int position
//                                                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
      @Nullable List<Object> payloads) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                   ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                           ^^^^^^^^ definition local 17
//                                    display_name payloads
//                                    signature_documentation java @Nullable\nList<Object> payloads
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound().
    onModelBound(holder, model, position);
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//               ^^^^^^ reference local 14
//                       ^^^^^ reference local 15
//                              ^^^^^^^^ reference local 16
  }

  void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position,
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
//                  display_name onModelBound
//                  signature_documentation java void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position, EpoxyModel<?> previouslyBoundModel)
//                  kind Method
//                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelBound().
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                  ^^^^^^ definition local 18
//                                         display_name holder
//                                         signature_documentation java EpoxyViewHolder holder
//                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
//                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                        ^^^^^ definition local 19
//                                                              display_name model
//                                                              signature_documentation java EpoxyModel<?> model
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
//                                                                   ^^^^^^^^ definition local 20
//                                                                            display_name position
//                                                                            signature_documentation java int position
//                                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
      @Nullable EpoxyModel<?> previouslyBoundModel) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                            ^^^^^^^^^^^^^^^^^^^^ definition local 21
//                                                 display_name previouslyBoundModel
//                                                 signature_documentation java @Nullable\nEpoxyModel<?> previouslyBoundModel
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+1).
    onModelBound(holder, model, position);
//  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//               ^^^^^^ reference local 18
//                       ^^^^^ reference local 19
//                              ^^^^^^^^ reference local 20
  }

  /**
   * Called immediately after a model is bound to a view holder. Subclasses can override this if
   * they want alerts on when a model is bound.
   */
  protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position) {
//               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//                            display_name onModelBound
//                            signature_documentation java protected void onModelBound(EpoxyViewHolder holder, EpoxyModel<?> model, int position)
//                            kind Method
//                            documentation  Called immediately after a model is bound to a view holder. Subclasses can override this if\n they want alerts on when a model is bound.\n
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                            ^^^^^^ definition local 22
//                                                   display_name holder
//                                                   signature_documentation java EpoxyViewHolder holder
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//                                                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^ definition local 23
//                                                                        display_name model
//                                                                        signature_documentation java EpoxyModel<?> model
//                                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).
//                                                                             ^^^^^^^^ definition local 24
//                                                                                      display_name position
//                                                                                      signature_documentation java int position
//                                                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelBound(+2).

  }

  /**
   * Returns an object that manages the view holders currently bound to the RecyclerView. This
   * object is mainly used by the base Epoxy adapter to save view states, but you may find it useful
   * to help access views or models currently shown in the RecyclerView.
   */
  protected BoundViewHolders getBoundViewHolders() {
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#
//                           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
//                                               display_name getBoundViewHolders
//                                               signature_documentation java protected BoundViewHolders getBoundViewHolders()
//                                               kind Method
//                                               documentation  Returns an object that manages the view holders currently bound to the RecyclerView. This\n object is mainly used by the base Epoxy adapter to save view states, but you may find it useful\n to help access views or models currently shown in the RecyclerView.\n
//                                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getBoundViewHolders().
//                                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getBoundViewHolders().
    return boundViewHolders;
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
  }

  EpoxyModel<?> getModelForPosition(int position) {
//^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                  display_name getModelForPosition
//                                  signature_documentation java EpoxyModel<?> getModelForPosition(int position)
//                                  kind Method
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getModelForPosition().
//                                      ^^^^^^^^ definition local 25
//                                               display_name position
//                                               signature_documentation java int position
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
    return getCurrentModels().get(position);
//         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                            ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                ^^^^^^^^ reference local 25
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewRecycled(EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewRecycled().
//                           display_name onViewRecycled
//                           signature_documentation java @Override\npublic void onViewRecycled(EpoxyViewHolder holder)
//                           kind Method
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                           ^^^^^^ definition local 26
//                                                  display_name holder
//                                                  signature_documentation java EpoxyViewHolder holder
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewRecycled().
    viewHolderState.save(holder);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#save(+1).
//                       ^^^^^^ reference local 26
    boundViewHolders.remove(holder);
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                   ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#remove().
//                          ^^^^^^ reference local 26

    EpoxyModel<?> model = holder.getModel();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 27
//                      display_name model
//                      signature_documentation java EpoxyModel<?> model
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewRecycled().
//                        ^^^^^^ reference local 26
//                               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
    holder.unbind();
//  ^^^^^^ reference local 26
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#unbind().
    onModelUnbound(holder, model);
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound().
//                 ^^^^^^ reference local 26
//                         ^^^^^ reference local 27
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onDetachedFromRecyclerView().
//                                       display_name onDetachedFromRecyclerView
//                                       signature_documentation java @CallSuper\n@Override\npublic void onDetachedFromRecyclerView(unresolved_type recyclerView)
//                                       kind Method
//                                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onDetachedFromRecyclerView().
//                                        ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . RecyclerView#
//                                                             ^^^^^^^^^^^^ definition local 28
//                                                                          display_name recyclerView
//                                                                          signature_documentation java @NonNull\nunresolved_type recyclerView
//                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onDetachedFromRecyclerView().
    // The last model is saved for optimization, but holding onto it can leak anything saved inside
    // the model (like a click listener that references a Fragment). This is only needed during
    // the viewholder creation phase, so it is safe to clear now.
    viewTypeManager.lastModelForViewTypeLookup = null;
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewTypeManager.
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#lastModelForViewTypeLookup.
  }

  /**
   * Called immediately after a model is unbound from a view holder. Subclasses can override this if
   * they want alerts on when a model is unbound.
   */
  protected void onModelUnbound(EpoxyViewHolder holder, EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound().
//                              display_name onModelUnbound
//                              signature_documentation java protected void onModelUnbound(EpoxyViewHolder holder, EpoxyModel<?> model)
//                              kind Method
//                              documentation  Called immediately after a model is unbound from a view holder. Subclasses can override this if\n they want alerts on when a model is unbound.\n
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onModelUnbound().
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                              ^^^^^^ definition local 29
//                                                     display_name holder
//                                                     signature_documentation java EpoxyViewHolder holder
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound().
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                    ^^^^^ definition local 30
//                                                                          display_name model
//                                                                          signature_documentation java EpoxyModel<?> model
//                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onModelUnbound().

  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean onFailedToRecycleView(EpoxyViewHolder holder) {
//               ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onFailedToRecycleView().
//                                     display_name onFailedToRecycleView
//                                     signature_documentation java @CallSuper\n@Override\npublic boolean onFailedToRecycleView(EpoxyViewHolder holder)
//                                     kind Method
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local 31
//                                                            display_name holder
//                                                            signature_documentation java EpoxyViewHolder holder
//                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onFailedToRecycleView().
    //noinspection unchecked,rawtypes
    return ((EpoxyModel) holder.getModel()).onFailedToRecycleView(holder.objectToBind());
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                       ^^^^^^ reference local 31
//                              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onFailedToRecycleView().
//                                                                ^^^^^^ reference local 31
//                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewAttachedToWindow(EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewAttachedToWindow().
//                                   display_name onViewAttachedToWindow
//                                   signature_documentation java @CallSuper\n@Override\npublic void onViewAttachedToWindow(EpoxyViewHolder holder)
//                                   kind Method
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onViewAttachedToWindow().
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                   ^^^^^^ definition local 32
//                                                          display_name holder
//                                                          signature_documentation java EpoxyViewHolder holder
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewAttachedToWindow().
    //noinspection unchecked,rawtypes
    ((EpoxyModel) holder.getModel()).onViewAttachedToWindow(holder.objectToBind());
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^ reference local 32
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                   ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                                                          ^^^^^^ reference local 32
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewDetachedFromWindow(EpoxyViewHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewDetachedFromWindow().
//                                     display_name onViewDetachedFromWindow
//                                     signature_documentation java @CallSuper\n@Override\npublic void onViewDetachedFromWindow(EpoxyViewHolder holder)
//                                     kind Method
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#onViewDetachedFromWindow().
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                     ^^^^^^ definition local 33
//                                                            display_name holder
//                                                            signature_documentation java EpoxyViewHolder holder
//                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onViewDetachedFromWindow().
    //noinspection unchecked,rawtypes
    ((EpoxyModel) holder.getModel()).onViewDetachedFromWindow(holder.objectToBind());
//    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^ reference local 33
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#getModel().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                                            ^^^^^^ reference local 33
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
  }

  public void onSaveInstanceState(Bundle outState) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onSaveInstanceState().
//                                display_name onSaveInstanceState
//                                signature_documentation java public void onSaveInstanceState(unresolved_type outState)
//                                kind Method
//                                ^^^^^^ reference semanticdb maven . . Bundle#
//                                       ^^^^^^^^ definition local 34
//                                                display_name outState
//                                                signature_documentation java unresolved_type outState
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onSaveInstanceState().
    // Save the state of currently bound views first so they are included. Views that were
    // scrolled off and unbound will already have had
    // their state saved.
    for (EpoxyViewHolder holder : boundViewHolders) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                       ^^^^^^ definition local 35
//                              display_name holder
//                              signature_documentation java EpoxyViewHolder holder
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onSaveInstanceState().
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
      viewHolderState.save(holder);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewHolderState#save(+1).
//                         ^^^^^^ reference local 35
    }

    if (viewHolderState.size() > 0 && !hasStableIds()) {
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                      ^^^^ reference semanticdb maven maven/androidx.collection/collection 1.0.0 androidx/collection/LongSparseArray#size().
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#hasStableIds#
      throw new IllegalStateException("Must have stable ids when saving view holder state");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    outState.putParcelable(SAVED_STATE_ARG_VIEW_HOLDERS, viewHolderState);
//  ^^^^^^^^ reference local 34
//           ^^^^^^^^^^^^^ reference semanticdb maven . . Bundle#putParcelable#
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#SAVED_STATE_ARG_VIEW_HOLDERS.
//                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
  }

  public void onRestoreInstanceState(@Nullable Bundle inState) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onRestoreInstanceState().
//                                   display_name onRestoreInstanceState
//                                   signature_documentation java public void onRestoreInstanceState(unresolved_type inState)
//                                   kind Method
//                                    ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                             ^^^^^^ reference semanticdb maven . . Bundle#
//                                                    ^^^^^^^ definition local 36
//                                                            display_name inState
//                                                            signature_documentation java @Nullable\nunresolved_type inState
//                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onRestoreInstanceState().
    // To simplify things we enforce that state is restored before views are bound, otherwise it
    // is more difficult to update view state once they are bound
    if (boundViewHolders.size() > 0) {
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#boundViewHolders.
//                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#size().
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "State cannot be restored once views have been bound. It should be done before adding "
              + "the adapter to the recycler view.");
    }

    if (inState != null) {
//      ^^^^^^^ reference local 36
      viewHolderState = inState.getParcelable(SAVED_STATE_ARG_VIEW_HOLDERS);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
//                      ^^^^^^^ reference local 36
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . Bundle#getParcelable#
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#SAVED_STATE_ARG_VIEW_HOLDERS.
      if (viewHolderState == null) {
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#viewHolderState.
        throw new IllegalStateException(
//                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
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
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                               display_name getModelPosition
//                               signature_documentation java protected int getModelPosition(EpoxyModel<?> model)
//                               kind Method
//                               documentation  Finds the position of the given model in the list. Doesn't use indexOf to avoid unnecessary\n equals() calls since we're looking for the same object instance.\n\n @return The position of the given model in the current models list, or -1 if the model can't be\n found.\n
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#getModelPosition().
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getModelPosition().
//                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^ definition local 37
//                                                   display_name model
//                                                   signature_documentation java EpoxyModel<?> model
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
    int size = getCurrentModels().size();
//      ^^^^ definition local 38
//           display_name size
//           signature_documentation java int size
//           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    for (int i = 0; i < size; i++) {
//           ^ definition local 39
//             display_name i
//             signature_documentation java int i
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                  ^ reference local 39
//                      ^^^^ reference local 38
//                            ^ reference local 39
      if (model == getCurrentModels().get(i)) {
//        ^^^^^ reference local 37
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
//                                    ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                        ^ reference local 39
        return i;
//             ^ reference local 39
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
//       ^^^^^^^^^^^^^^ reference semanticdb maven . . SpanSizeLookup#
//                      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getSpanSizeLookup().
//                                        display_name getSpanSizeLookup
//                                        signature_documentation java public unresolved_type getSpanSizeLookup()
//                                        kind Method
//                                        documentation  For use with a grid layout manager - use this to get the {@link SpanSizeLookup} for models in\n this adapter. This will delegate span look up calls to each model's {@link\n EpoxyModel#getSpanSize(int, int, int)}. Make sure to also call {@link #setSpanCount(int)} so\n the span count is correct.\n
    return spanSizeLookup;
//         ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#spanSizeLookup.
  }

  /**
   * If you are using a grid layout manager you must call this to set the span count of the grid.
   * This span count will be passed on to the models so models can choose what span count to be.
   *
   * @see #getSpanSizeLookup()
   * @see EpoxyModel#getSpanSize(int, int, int)
   */
  public void setSpanCount(int spanCount) {
//            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#setSpanCount().
//                         display_name setSpanCount
//                         signature_documentation java public void setSpanCount(int spanCount)
//                         kind Method
//                         documentation  If you are using a grid layout manager you must call this to set the span count of the grid.\n This span count will be passed on to the models so models can choose what span count to be.\n\n @see #getSpanSizeLookup()\n @see EpoxyModel#getSpanSize(int, int, int)\n
//                             ^^^^^^^^^ definition local 40
//                                       display_name spanCount
//                                       signature_documentation java int spanCount
//                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#setSpanCount().
    this.spanCount = spanCount;
//       ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
//                   ^^^^^^^^^ reference local 40
  }

  public int getSpanCount() {
//           ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getSpanCount().
//                        display_name getSpanCount
//                        signature_documentation java public int getSpanCount()
//                        kind Method
    return spanCount;
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
  }

  public boolean isMultiSpan() {
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#isMultiSpan().
//                           display_name isMultiSpan
//                           signature_documentation java public boolean isMultiSpan()
//                           kind Method
    return spanCount > 1;
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#spanCount.
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
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void setupStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#setupStickyHeaderView().
//                                  display_name setupStickyHeaderView
//                                  signature_documentation java @Override\npublic void setupStickyHeaderView(unresolved_type stickyHeader)
//                                  kind Method
//                                  documentation  Optional callback to setup the sticky view,\n by default it doesn't do anything.\n <p>\n The sub-classes should override the function if they are\n using sticky header feature.\n
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#setupStickyHeaderView().
//                                   ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#
//                                           ^^^^ reference semanticdb maven . . View#
//                                                ^^^^^^^^^^^^ definition local 41
//                                                             display_name stickyHeader
//                                                             signature_documentation java @NotNull\nunresolved_type stickyHeader
//                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#setupStickyHeaderView().
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
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void teardownStickyHeaderView(@NotNull View stickyHeader) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#teardownStickyHeaderView().
//                                     display_name teardownStickyHeaderView
//                                     signature_documentation java @Override\npublic void teardownStickyHeaderView(unresolved_type stickyHeader)
//                                     kind Method
//                                     documentation  Optional callback to perform tear down operation on the\n sticky view, by default it doesn't do anything.\n <p>\n The sub-classes should override the function if they are\n using sticky header feature.\n
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#teardownStickyHeaderView().
//                                      ^^^^^^^ reference semanticdb maven maven/org.jetbrains/annotations 13.0 org/jetbrains/annotations/NotNull#
//                                              ^^^^ reference semanticdb maven . . View#
//                                                   ^^^^^^^^^^^^ definition local 42
//                                                                display_name stickyHeader
//                                                                signature_documentation java @NotNull\nunresolved_type stickyHeader
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#teardownStickyHeaderView().
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
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean isStickyHeader(int position) {
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#isStickyHeader().
//                              display_name isStickyHeader
//                              signature_documentation java @Override\npublic boolean isStickyHeader(int position)
//                              kind Method
//                              documentation  Called to check if the item at the position is a sticky item,\n by default returns false.\n <p>\n The sub-classes should override the function if they are\n using sticky header feature.\n
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyControllerAdapter#isStickyHeader().
//                                  ^^^^^^^^ definition local 43
//                                           display_name position
//                                           signature_documentation java int position
//                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#isStickyHeader().
    return false;
  }

  //endregion
}
