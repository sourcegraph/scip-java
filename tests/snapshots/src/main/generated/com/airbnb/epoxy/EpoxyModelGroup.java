package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^ reference android/view/View#
import android.view.ViewParent;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^^^^^^^ reference android/view/ViewParent#
import android.view.ViewStub;
//     ^^^^^^^ reference android/
//             ^^^^ reference android/view/
//                  ^^^^^^^^ reference android/view/ViewStub#

import java.util.ArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#
import java.util.Arrays;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^ reference java/util/Arrays#
import java.util.Collection;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^ reference java/util/Collection#
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
import androidx.annotation.LayoutRes;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/LayoutRes#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#

/**
 * An {@link EpoxyModel} that contains other models, and allows you to combine those models in
 * whatever view configuration you want.
 * <p>
 * The constructors take a list of models and a layout resource. The layout must have a viewgroup as
 * its top level view; it determines how the view of each model is laid out. There are two ways to
 * specify this
 * <p>
 * 1. Leave the viewgroup empty. The view for each model will be inflated and added in order. This
 * works fine if you don't need to include any other views, your model views don't need their layout
 * params changed, and your views don't need ids (eg for saving state).
 * <p>
 * Alternatively you can have nested view groups, with the innermost viewgroup given the id
 * "epoxy_model_group_child_container" to mark it as the viewgroup that should have the model views
 * added to it. The viewgroup marked with this id should be empty. This allows you to nest
 * viewgroups, such as a LinearLayout inside of a CardView.
 * <p>
 * 2. Include a {@link ViewStub} for each of the models in the list. There should be at least as
 * many view stubs as models. Extra stubs will be ignored. Each model will have its view replace the
 * stub in order of the view stub's position in the view group. That is, the view group's children
 * will be iterated through in order. The first view stub found will be used for the first model in
 * the models list, the second view stub will be used for the second model, and so on. A depth first
 * recursive search through nested viewgroups is done to find these viewstubs.
 * <p>
 * The layout can be of any ViewGroup subclass, and can have arbitrary other child views besides the
 * view stubs. It can arrange the views and view stubs however is needed.
 * <p>
 * Any layout param options set on the view stubs will be transferred to the corresponding model
 * view by default. If you want a model to keep the layout params from it's own layout resource you
 * can override {@link #useViewStubLayoutParams(EpoxyModel, int)}
 * <p>
 * If you want to override the id used for a model's view you can set {@link
 * ViewStub#setInflatedId(int)} via xml. That id will be transferred over to the view taking that
 * stub's place. This is necessary if you want your model to save view state, since without this the
 * model's view won't have an id to associate the saved state with.
 * <p>
 * By default this model inherits the same id as the first model in the list. Call {@link #id(long)}
 * to override that if needed.
 * <p>
 * When a model group is recycled, its child views are automatically recycled to a pool that is
 * shared with all other model groups in the activity. This enables model groups to more efficiently
 * manage their children. The shared pool is cleaned up when the activity is destroyed.
 */
@SuppressWarnings("rawtypes")
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
public class EpoxyModelGroup extends EpoxyModelWithHolder<ModelGroupHolder> {
//           ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup# @SuppressWarnings("rawtypes") public class EpoxyModelGroup extends EpoxyModelWithHolder<unresolved_type>
//                                   ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#
//                                                        ^^^^^^^^^^^^^^^^ reference _root_/

  protected final List<EpoxyModel<?>> models;
//                ^^^^ reference java/util/List#
//                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#models. protected final List<EpoxyModel<?>> models

  private boolean shouldSaveViewStateDefault = false;
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault. private boolean shouldSaveViewStateDefault

  @Nullable
// ^^^^^^^^ reference androidx/annotation/Nullable#
  private Boolean shouldSaveViewState = null;
//        ^^^^^^^ reference java/lang/Boolean#
//                ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState. @Nullable private Boolean shouldSaveViewState

  /**
   * @param layoutRes The layout to use with these models.
   * @param models    The models that will be used to bind the views in the given layout.
   */
  public EpoxyModelGroup(@LayoutRes int layoutRes, Collection<? extends EpoxyModel<?>> models) {
//       ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`(). public EpoxyModelGroup(int layoutRes, Collection<? extends EpoxyModel<?>> models)
//                        ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                      ^^^^^^^^^ definition local0 @LayoutRes int layoutRes
//                                                 ^^^^^^^^^^ reference java/util/Collection#
//                                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                     ^^^^^^ definition local1 Collection<? extends EpoxyModel<?>> models
    this(layoutRes, new ArrayList<>(models));
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+2).
//       ^^^^^^^^^ reference local0
//                      ^^^^^^^^^ reference java/util/ArrayList#`<init>`(+2).
//                                  ^^^^^^ reference local1
  }

  /**
   * @param layoutRes The layout to use with these models.
   * @param models    The models that will be used to bind the views in the given layout.
   */
  public EpoxyModelGroup(@LayoutRes int layoutRes, EpoxyModel<?>... models) {
//       ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+1). public EpoxyModelGroup(int layoutRes, EpoxyModel<?>[] models)
//                        ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                      ^^^^^^^^^ definition local2 @LayoutRes int layoutRes
//                                                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^^ definition local3 EpoxyModel<?>[] models
    this(layoutRes, new ArrayList<>(Arrays.asList(models)));
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+2).
//       ^^^^^^^^^ reference local2
//                      ^^^^^^^^^ reference java/util/ArrayList#`<init>`(+2).
//                                  ^^^^^^ reference java/util/Arrays#
//                                         ^^^^^^ reference java/util/Arrays#asList().
//                                                ^^^^^^ reference local3
  }

  /**
   * @param layoutRes The layout to use with these models.
   * @param models    The models that will be used to bind the views in the given layout.
   */
  private EpoxyModelGroup(@LayoutRes int layoutRes, List<EpoxyModel<?>> models) {
//        ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+2). private EpoxyModelGroup(int layoutRes, List<EpoxyModel<?>> models)
//                         ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                       ^^^^^^^^^ definition local4 @LayoutRes int layoutRes
//                                                  ^^^^ reference java/util/List#
//                                                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                      ^^^^^^ definition local5 List<EpoxyModel<?>> models
    if (models.isEmpty()) {
//      ^^^^^^ reference local5
//             ^^^^^^^ reference java/util/List#isEmpty().
      throw new IllegalArgumentException("Models cannot be empty");
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`(+1).
    }

    this.models = models;
//       ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                ^^^^^^ reference local5
    layout(layoutRes);
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#layout().
//         ^^^^^^^^^ reference local4
    id(models.get(0).id());
//  ^^ reference com/airbnb/epoxy/EpoxyModel#id(+1).
//     ^^^^^^ reference local5
//            ^^^ reference java/util/List#get().
//                   ^^ reference com/airbnb/epoxy/EpoxyModel#id().

    boolean saveState = false;
//          ^^^^^^^^^ definition local6 boolean saveState
    for (EpoxyModel<?> model : models) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local7 EpoxyModel<?> model
//                             ^^^^^^ reference local5
      if (model.shouldSaveViewState()) {
//        ^^^^^ reference local7
//              ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
        saveState = true;
//      ^^^^^^^^^ reference local6
        break;
      }
    }
    // By default we save view state if any of the models need to save state.
    shouldSaveViewStateDefault = saveState;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
//                               ^^^^^^^^^ reference local6
  }

  /**
   * Constructor use for DSL
   */
  protected EpoxyModelGroup() {
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+3). protected EpoxyModelGroup()
    models = new ArrayList<>();
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//               ^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
    shouldSaveViewStateDefault = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
  }

  /**
   * Constructor use for DSL
   */
  protected EpoxyModelGroup(@LayoutRes int layoutRes) {
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+4). protected EpoxyModelGroup(int layoutRes)
//                           ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                         ^^^^^^^^^ definition local8 @LayoutRes int layoutRes
    this();
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+3).
    layout(layoutRes);
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#layout().
//         ^^^^^^^^^ reference local8
  }

  protected void addModel(@NonNull EpoxyModel<?> model) {
//               ^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#addModel(). protected void addModel(EpoxyModel<?> model)
//                         ^^^^^^^ reference androidx/annotation/NonNull#
//                                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^ definition local9 @NonNull EpoxyModel<?> model
    // By default we save view state if any of the models need to save state.
    shouldSaveViewStateDefault |= model.shouldSaveViewState();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
//                                ^^^^^ reference local9
//                                      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
    models.add(model);
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//         ^^^ reference java/util/List#add().
//             ^^^^^ reference local9
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull ModelGroupHolder holder) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#bind(). @CallSuper @Override public void bind(unresolved_type holder)
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^^^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local10 @NonNull unresolved_type holder
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local10
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local12 6:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local13 @Override public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local14 EpoxyModel model
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local15 EpoxyViewHolder viewHolder
//                                                                          ^^^^^^^^^^ definition local16 int modelIndex
        setViewVisibility(model, viewHolder);
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                        ^^^^^ reference local14
//                               ^^^^^^^^^^ reference local15
        viewHolder.bind(model, null, Collections.emptyList(), modelIndex);
//      ^^^^^^^^^^ reference local15
//                 ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#bind().
//                      ^^^^^ reference local14
//                                   ^^^^^^^^^^^ reference java/util/Collections#
//                                               ^^^^^^^^^ reference java/util/Collections#emptyList().
//                                                            ^^^^^^^^^^ reference local16
      }
    });
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull ModelGroupHolder holder, @NonNull final List<Object> payloads) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#bind(+1). @CallSuper @Override public void bind(unresolved_type holder, List<Object> payloads)
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^^^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local17 @NonNull unresolved_type holder
//                                                    ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                  ^^^^ reference java/util/List#
//                                                                       ^^^^^^ reference java/lang/Object#
//                                                                               ^^^^^^^^ definition local18 @NonNull final List<Object> payloads
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local17
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local20 6:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local21 @Override public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local22 EpoxyModel model
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local23 EpoxyViewHolder viewHolder
//                                                                          ^^^^^^^^^^ definition local24 int modelIndex
        setViewVisibility(model, viewHolder);
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                        ^^^^^ reference local22
//                               ^^^^^^^^^^ reference local23
        viewHolder.bind(model, null, Collections.emptyList(), modelIndex);
//      ^^^^^^^^^^ reference local23
//                 ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#bind().
//                      ^^^^^ reference local22
//                                   ^^^^^^^^^^^ reference java/util/Collections#
//                                               ^^^^^^^^^ reference java/util/Collections#emptyList().
//                                                            ^^^^^^^^^^ reference local24
      }
    });
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull ModelGroupHolder holder, @NonNull EpoxyModel<?> previouslyBoundModel) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#bind(+2). @Override public void bind(unresolved_type holder, EpoxyModel<?> previouslyBoundModel)
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^^^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local25 @NonNull unresolved_type holder
//                                                    ^^^^^^^ reference androidx/annotation/NonNull#
//                                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                          ^^^^^^^^^^^^^^^^^^^^ definition local26 @NonNull EpoxyModel<?> previouslyBoundModel
    if (!(previouslyBoundModel instanceof EpoxyModelGroup)) {
//        ^^^^^^^^^^^^^^^^^^^^ reference local26
//                                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
      bind(holder);
//    ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#bind().
//         ^^^^^^ reference local25
      return;
    }

    final EpoxyModelGroup previousGroup = (EpoxyModelGroup) previouslyBoundModel;
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                        ^^^^^^^^^^^^^ definition local27 final EpoxyModelGroup previousGroup
//                                         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference local26

    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local25
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local29 15:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local30 @Override public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local31 EpoxyModel model
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local32 EpoxyViewHolder viewHolder
//                                                                          ^^^^^^^^^^ definition local33 int modelIndex
        setViewVisibility(model, viewHolder);
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                        ^^^^^ reference local31
//                               ^^^^^^^^^^ reference local32

        if (modelIndex < previousGroup.models.size()) {
//          ^^^^^^^^^^ reference local33
//                       ^^^^^^^^^^^^^ reference local27
//                                     ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                                            ^^^^ reference java/util/List#size().
          EpoxyModel<?> previousModel = previousGroup.models.get(modelIndex);
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^^^^^^^^ definition local34 EpoxyModel<?> previousModel
//                                      ^^^^^^^^^^^^^ reference local27
//                                                    ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                                                           ^^^ reference java/util/List#get().
//                                                               ^^^^^^^^^^ reference local33
          if (previousModel.id() == model.id()) {
//            ^^^^^^^^^^^^^ reference local34
//                          ^^ reference com/airbnb/epoxy/EpoxyModel#id().
//                                  ^^^^^ reference local31
//                                        ^^ reference com/airbnb/epoxy/EpoxyModel#id().
            viewHolder.bind(model, previousModel, Collections.emptyList(), modelIndex);
//          ^^^^^^^^^^ reference local32
//                     ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#bind().
//                          ^^^^^ reference local31
//                                 ^^^^^^^^^^^^^ reference local34
//                                                ^^^^^^^^^^^ reference java/util/Collections#
//                                                            ^^^^^^^^^ reference java/util/Collections#emptyList().
//                                                                         ^^^^^^^^^^ reference local33
            return;
          }
        }

        viewHolder.bind(model, null, Collections.emptyList(), modelIndex);
//      ^^^^^^^^^^ reference local32
//                 ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#bind().
//                      ^^^^^ reference local31
//                                   ^^^^^^^^^^^ reference java/util/Collections#
//                                               ^^^^^^^^^ reference java/util/Collections#emptyList().
//                                                            ^^^^^^^^^^ reference local33
      }
    });
  }

  private static void setViewVisibility(EpoxyModel model, EpoxyViewHolder viewHolder) {
//                    ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility(). private static void setViewVisibility(EpoxyModel model, EpoxyViewHolder viewHolder)
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^ definition local35 EpoxyModel model
//                                                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                        ^^^^^^^^^^ definition local36 EpoxyViewHolder viewHolder
    if (model.isShown()) {
//      ^^^^^ reference local35
//            ^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#isShown().
      viewHolder.itemView.setVisibility(View.VISIBLE);
//    ^^^^^^^^^^ reference local36
//               ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#setVisibility#
//                                      ^^^^ reference _root_/
//                                           ^^^^^^^ reference VISIBLE#
    } else {
      viewHolder.itemView.setVisibility(View.GONE);
//    ^^^^^^^^^^ reference local36
//               ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#setVisibility#
//                                      ^^^^ reference _root_/
//                                           ^^^^ reference GONE#
    }
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void unbind(@NonNull ModelGroupHolder holder) {
//            ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#unbind(). @CallSuper @Override public void unbind(unresolved_type holder)
//                    ^^^^^^^ reference androidx/annotation/NonNull#
//                            ^^^^^^^^^^^^^^^^ reference _root_/
//                                             ^^^^^^ definition local37 @NonNull unresolved_type holder
    holder.unbindGroup();
//  ^^^^^^ reference local37
//         ^^^^^^^^^^^ reference unbindGroup#
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onViewAttachedToWindow(ModelGroupHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#onViewAttachedToWindow(). @CallSuper @Override public void onViewAttachedToWindow(unresolved_type holder)
//                                   ^^^^^^^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^ definition local38 unresolved_type holder
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local38
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local40 6:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local41 @Override public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local42 EpoxyModel model
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local43 EpoxyViewHolder viewHolder
//                                                                          ^^^^^^^^^^ definition local44 int modelIndex
        //noinspection unchecked
        model.onViewAttachedToWindow(viewHolder.objectToBind());
//      ^^^^^ reference local42
//            ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                                   ^^^^^^^^^^ reference local43
//                                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
      }
    });
  }

  @CallSuper
// ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onViewDetachedFromWindow(ModelGroupHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#onViewDetachedFromWindow(). @CallSuper @Override public void onViewDetachedFromWindow(unresolved_type holder)
//                                     ^^^^^^^^^^^^^^^^ reference _root_/
//                                                      ^^^^^^ definition local45 unresolved_type holder
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local45
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local47 6:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local48 @Override public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local49 EpoxyModel model
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local50 EpoxyViewHolder viewHolder
//                                                                          ^^^^^^^^^^ definition local51 int modelIndex
        //noinspection unchecked
        model.onViewDetachedFromWindow(viewHolder.objectToBind());
//      ^^^^^ reference local49
//            ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                     ^^^^^^^^^^ reference local50
//                                                ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
      }
    });
  }

  private void iterateModels(ModelGroupHolder holder, IterateModelsCallback callback) {
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#iterateModels(). private void iterateModels(unresolved_type holder, IterateModelsCallback callback)
//                           ^^^^^^^^^^^^^^^^ reference _root_/
//                                            ^^^^^^ definition local52 unresolved_type holder
//                                                    ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                                                                          ^^^^^^^^ definition local53 IterateModelsCallback callback
    holder.bindGroupIfNeeded(this);
//  ^^^^^^ reference local52
//         ^^^^^^^^^^^^^^^^^ reference bindGroupIfNeeded#
    int modelCount = models.size();
//      ^^^^^^^^^^ definition local54 int modelCount
//                   ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                          ^^^^ reference java/util/List#size().

    for (int i = 0; i < modelCount; i++) {
//           ^ definition local55 int i
//                  ^ reference local55
//                      ^^^^^^^^^^ reference local54
//                                  ^ reference local55
      callback.onModel(models.get(i), holder.getViewHolders().get(i), i);
//    ^^^^^^^^ reference local53
//             ^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//                     ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                            ^^^ reference java/util/List#get().
//                                ^ reference local55
//                                    ^^^^^^ reference local52
//                                           ^^^^^^^^^^^^^^ reference getViewHolders#
//                                                            ^^^ reference getViewHolders#get#
//                                                                ^ reference local55
//                                                                    ^ reference local55
    }
  }

  private interface IterateModelsCallback {
//                  ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback# private abstract static interface IterateModelsCallback
    void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex);
//       ^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel(). public abstract void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)
//               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                          ^^^^^ definition local56 EpoxyModel model
//                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local57 EpoxyViewHolder viewHolder
//                                                                 ^^^^^^^^^^ definition local58 int modelIndex
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int getSpanSize(int totalSpanCount, int position, int itemCount) {
//           ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#getSpanSize(). @Override public int getSpanSize(int totalSpanCount, int position, int itemCount)
//                           ^^^^^^^^^^^^^^ definition local59 int totalSpanCount
//                                               ^^^^^^^^ definition local60 int position
//                                                             ^^^^^^^^^ definition local61 int itemCount
    // Defaults to using the span size of the first model. Override this if you need to customize it
    return models.get(0).spanSize(totalSpanCount, position, itemCount);
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                ^^^ reference java/util/List#get().
//                       ^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#spanSize().
//                                ^^^^^^^^^^^^^^ reference local59
//                                                ^^^^^^^^ reference local60
//                                                          ^^^^^^^^^ reference local61
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected final int getDefaultLayout() {
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#getDefaultLayout(). @Override protected final int getDefaultLayout()
    throw new UnsupportedOperationException(
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#`<init>`(+1).
        "You should set a layout with layout(...) instead of using this.");
  }

  @NonNull
// ^^^^^^^ reference androidx/annotation/NonNull#
  public EpoxyModelGroup shouldSaveViewState(boolean shouldSaveViewState) {
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                       ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState(). @NonNull public EpoxyModelGroup shouldSaveViewState(boolean shouldSaveViewState)
//                                                   ^^^^^^^^^^^^^^^^^^^ definition local62 boolean shouldSaveViewState
    onMutation();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onMutation().
    this.shouldSaveViewState = shouldSaveViewState;
//       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState.
//                             ^^^^^^^^^^^^^^^^^^^ reference local62
    return this;
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public boolean shouldSaveViewState() {
//               ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState(+1). @Override public boolean shouldSaveViewState()
    // By default state is saved if any of the models have saved state enabled.
    // Override this if you need custom behavior.
    if (shouldSaveViewState != null) {
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState.
      return shouldSaveViewState;
//           ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState.
    } else {
      return shouldSaveViewStateDefault;
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
    }
  }

  /**
   * Whether the layout params set on the view stub for the given model should be carried over to
   * the model's view. Default is true
   * <p>
   * Set this to false if you want the layout params on the model's layout resource to be kept.
   *
   * @param model         The model who's view is being created
   * @param modelPosition The position of the model in the models list
   */
  protected boolean useViewStubLayoutParams(EpoxyModel<?> model, int modelPosition) {
//                  ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#useViewStubLayoutParams(). protected boolean useViewStubLayoutParams(EpoxyModel<?> model, int modelPosition)
//                                          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                        ^^^^^ definition local63 EpoxyModel<?> model
//                                                                   ^^^^^^^^^^^^^ definition local64 int modelPosition
    return true;
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  protected final ModelGroupHolder createNewHolder(@NonNull ViewParent parent) {
//                ^^^^^^^^^^^^^^^^ reference _root_/
//                                 ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#createNewHolder(). @Override protected final createNewHolder(unresolved_type parent)
//                                                  ^^^^^^^ reference androidx/annotation/NonNull#
//                                                          ^^^^^^^^^^ reference _root_/
//                                                                     ^^^^^^ definition local65 @NonNull unresolved_type parent
    return new ModelGroupHolder(parent);
//             ^^^^^^^^^^^^^^^^ reference `<init>`#
//                              ^^^^^^ reference local65
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#equals(). @Override public boolean equals(Object o)
//                      ^^^^^^ reference java/lang/Object#
//                             ^ definition local66 Object o
    if (this == o) {
//              ^ reference local66
      return true;
    }
    if (!(o instanceof EpoxyModelGroup)) {
//        ^ reference local66
//                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
      return false;
    }
    if (!super.equals(o)) {
//       ^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#super.
//             ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#equals().
//                    ^ reference local66
      return false;
    }

    EpoxyModelGroup that = (EpoxyModelGroup) o;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                  ^^^^ definition local67 EpoxyModelGroup that
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                                           ^ reference local66

    return models.equals(that.models);
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                ^^^^^^ reference java/util/List#equals().
//                       ^^^^ reference local67
//                            ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#hashCode(). @Override public int hashCode()
    int result = super.hashCode();
//      ^^^^^^ definition local68 int result
//               ^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#super.
//                     ^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#hashCode().
    result = 31 * result + models.hashCode();
//  ^^^^^^ reference local68
//                ^^^^^^ reference local68
//                         ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                                ^^^^^^^^ reference java/util/List#hashCode().
    return result;
//         ^^^^^^ reference local68
  }
}
