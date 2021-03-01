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
 ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
public class EpoxyModelGroup extends EpoxyModelWithHolder<ModelGroupHolder> {
//     ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#
//                                   ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelWithHolder#
//                                                        ^^^^^^^^^^^^^^^^ reference _root_/

  protected final List<EpoxyModel<?>> models;
//                ^^^^ reference java/util/List#
//                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#models.

  private boolean shouldSaveViewStateDefault = false;
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.

  @Nullable
   ^^^^^^^^ reference androidx/annotation/Nullable#
  private Boolean shouldSaveViewState = null;
//        ^^^^^^^ reference java/lang/Boolean#
//                ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState.

  /**
   * @param layoutRes The layout to use with these models.
   * @param models    The models that will be used to bind the views in the given layout.
   */
  public EpoxyModelGroup(@LayoutRes int layoutRes, Collection<? extends EpoxyModel<?>> models) {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`().
//                        ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                      ^^^^^^^^^ definition local0
//                                                 ^^^^^^^^^^ reference java/util/Collection#
//                                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                                     ^^^^^^ definition local1
    this(layoutRes, new ArrayList<>(models));
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+2).
//       ^^^^^^^^^ reference local0
//                  ^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+2).
//                      ^^^^^^^^^ reference java/util/ArrayList#
//                                  ^^^^^^ reference local1
  }

  /**
   * @param layoutRes The layout to use with these models.
   * @param models    The models that will be used to bind the views in the given layout.
   */
  public EpoxyModelGroup(@LayoutRes int layoutRes, EpoxyModel<?>... models) {
//       ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+1).
//                        ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                      ^^^^^^^^^ definition local2
//                                                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^^ definition local3
    this(layoutRes, new ArrayList<>(Arrays.asList(models)));
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+2).
//       ^^^^^^^^^ reference local2
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+2).
//                      ^^^^^^^^^ reference java/util/ArrayList#
//                                  ^^^^^^ reference java/util/Arrays#
//                                         ^^^^^^ reference java/util/Arrays#asList().
//                                                ^^^^^^ reference local3
  }

  /**
   * @param layoutRes The layout to use with these models.
   * @param models    The models that will be used to bind the views in the given layout.
   */
  private EpoxyModelGroup(@LayoutRes int layoutRes, List<EpoxyModel<?>> models) {
//        ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+2).
//                         ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                       ^^^^^^^^^ definition local4
//                                                  ^^^^ reference java/util/List#
//                                                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                      ^^^^^^ definition local5
    if (models.isEmpty()) {
//      ^^^^^^ reference local5
//             ^^^^^^^ reference java/util/List#isEmpty().
      throw new IllegalArgumentException("Models cannot be empty");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#
    }

    this.models = models;
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#this.
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
//          ^^^^^^^^^ definition local6
    for (EpoxyModel<?> model : models) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local7
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
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+3).
    models = new ArrayList<>();
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//           ^^^^^^^^^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).
//               ^^^^^^^^^ reference java/util/ArrayList#
    shouldSaveViewStateDefault = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
  }

  /**
   * Constructor use for DSL
   */
  protected EpoxyModelGroup(@LayoutRes int layoutRes) {
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+4).
//                           ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//                                         ^^^^^^^^^ definition local8
    this();
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+3).
    layout(layoutRes);
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#layout().
//         ^^^^^^^^^ reference local8
  }

  protected void addModel(@NonNull EpoxyModel<?> model) {
//               ^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#addModel().
//                         ^^^^^^^ reference androidx/annotation/NonNull#
//                                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^ definition local9
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
   ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull ModelGroupHolder holder) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#bind().
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^^^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local10
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local10
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#bind().``#`<init>`(). 6:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                                                    ^ definition com/airbnb/epoxy/EpoxyModelGroup#bind().``#`<init>`(). 1:4
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#bind().``#onModel().
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local11
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local12
//                                                                          ^^^^^^^^^^ definition local13
        setViewVisibility(model, viewHolder);
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                        ^^^^^ reference local11
//                               ^^^^^^^^^^ reference local12
        viewHolder.bind(model, null, Collections.emptyList(), modelIndex);
//      ^^^^^^^^^^ reference local12
//                 ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#bind().
//                      ^^^^^ reference local11
//                                   ^^^^^^^^^^^ reference java/util/Collections#
//                                               ^^^^^^^^^ reference java/util/Collections#emptyList().
//                                                            ^^^^^^^^^^ reference local13
      }
    });
  }

  @CallSuper
   ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull ModelGroupHolder holder, @NonNull final List<Object> payloads) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#bind(+1).
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^^^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local14
//                                                    ^^^^^^^ reference androidx/annotation/NonNull#
//                                                                  ^^^^ reference java/util/List#
//                                                                       ^^^^^^ reference java/lang/Object#
//                                                                               ^^^^^^^^ definition local15
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local14
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#bind(+1).``#`<init>`(). 6:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                                                    ^ definition com/airbnb/epoxy/EpoxyModelGroup#bind(+1).``#`<init>`(). 1:4
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#bind(+1).``#onModel().
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local16
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local17
//                                                                          ^^^^^^^^^^ definition local18
        setViewVisibility(model, viewHolder);
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                        ^^^^^ reference local16
//                               ^^^^^^^^^^ reference local17
        viewHolder.bind(model, null, Collections.emptyList(), modelIndex);
//      ^^^^^^^^^^ reference local17
//                 ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#bind().
//                      ^^^^^ reference local16
//                                   ^^^^^^^^^^^ reference java/util/Collections#
//                                               ^^^^^^^^^ reference java/util/Collections#emptyList().
//                                                            ^^^^^^^^^^ reference local18
      }
    });
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void bind(@NonNull ModelGroupHolder holder, @NonNull EpoxyModel<?> previouslyBoundModel) {
//            ^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#bind(+2).
//                  ^^^^^^^ reference androidx/annotation/NonNull#
//                          ^^^^^^^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local19
//                                                    ^^^^^^^ reference androidx/annotation/NonNull#
//                                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                          ^^^^^^^^^^^^^^^^^^^^ definition local20
    if (!(previouslyBoundModel instanceof EpoxyModelGroup)) {
//        ^^^^^^^^^^^^^^^^^^^^ reference local20
//                                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
      bind(holder);
//    ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#bind().
//         ^^^^^^ reference local19
      return;
    }

    final EpoxyModelGroup previousGroup = (EpoxyModelGroup) previouslyBoundModel;
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                        ^^^^^^^^^^^^^ definition local21
//                                         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference local20

    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local19
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#bind(+2).``#`<init>`(). 15:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                                                    ^ definition com/airbnb/epoxy/EpoxyModelGroup#bind(+2).``#`<init>`(). 1:4
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#bind(+2).``#onModel().
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local22
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local23
//                                                                          ^^^^^^^^^^ definition local24
        setViewVisibility(model, viewHolder);
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                        ^^^^^ reference local22
//                               ^^^^^^^^^^ reference local23

        if (modelIndex < previousGroup.models.size()) {
//          ^^^^^^^^^^ reference local24
//                       ^^^^^^^^^^^^^ reference local21
//                                     ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                                            ^^^^ reference java/util/List#size().
          EpoxyModel<?> previousModel = previousGroup.models.get(modelIndex);
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^^^^^^^^ definition local25
//                                      ^^^^^^^^^^^^^ reference local21
//                                                    ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                                                           ^^^ reference java/util/List#get().
//                                                               ^^^^^^^^^^ reference local24
          if (previousModel.id() == model.id()) {
//            ^^^^^^^^^^^^^ reference local25
//                          ^^ reference com/airbnb/epoxy/EpoxyModel#id().
//                                  ^^^^^ reference local22
//                                        ^^ reference com/airbnb/epoxy/EpoxyModel#id().
            viewHolder.bind(model, previousModel, Collections.emptyList(), modelIndex);
//          ^^^^^^^^^^ reference local23
//                     ^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#bind().
//                          ^^^^^ reference local22
//                                 ^^^^^^^^^^^^^ reference local25
//                                                ^^^^^^^^^^^ reference java/util/Collections#
//                                                            ^^^^^^^^^ reference java/util/Collections#emptyList().
//                                                                         ^^^^^^^^^^ reference local24
            return;
          }
        }

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

  private static void setViewVisibility(EpoxyModel model, EpoxyViewHolder viewHolder) {
//                    ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^ definition local26
//                                                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                                        ^^^^^^^^^^ definition local27
    if (model.isShown()) {
//      ^^^^^ reference local26
//            ^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#isShown().
      viewHolder.itemView.setVisibility(View.VISIBLE);
//    ^^^^^^^^^^ reference local27
//               ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#setVisibility#
//                                      ^^^^ reference _root_/
//                                           ^^^^^^^ reference VISIBLE#
    } else {
      viewHolder.itemView.setVisibility(View.GONE);
//    ^^^^^^^^^^ reference local27
//               ^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#itemView#setVisibility#
//                                      ^^^^ reference _root_/
//                                           ^^^^ reference GONE#
    }
  }

  @CallSuper
   ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void unbind(@NonNull ModelGroupHolder holder) {
//            ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#unbind().
//                    ^^^^^^^ reference androidx/annotation/NonNull#
//                            ^^^^^^^^^^^^^^^^ reference _root_/
//                                             ^^^^^^ definition local28
    holder.unbindGroup();
//  ^^^^^^ reference local28
//         ^^^^^^^^^^^ reference unbindGroup#
  }

  @CallSuper
   ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onViewAttachedToWindow(ModelGroupHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#onViewAttachedToWindow().
//                                   ^^^^^^^^^^^^^^^^ reference _root_/
//                                                    ^^^^^^ definition local29
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local29
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#onViewAttachedToWindow().``#`<init>`(). 6:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                                                    ^ definition com/airbnb/epoxy/EpoxyModelGroup#onViewAttachedToWindow().``#`<init>`(). 1:4
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#onViewAttachedToWindow().``#onModel().
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local30
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local31
//                                                                          ^^^^^^^^^^ definition local32
        //noinspection unchecked
        model.onViewAttachedToWindow(viewHolder.objectToBind());
//      ^^^^^ reference local30
//            ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                                   ^^^^^^^^^^ reference local31
//                                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
      }
    });
  }

  @CallSuper
   ^^^^^^^^^ reference androidx/annotation/CallSuper#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void onViewDetachedFromWindow(ModelGroupHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#onViewDetachedFromWindow().
//                                     ^^^^^^^^^^^^^^^^ reference _root_/
//                                                      ^^^^^^ definition local33
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local33
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#onViewDetachedFromWindow().``#`<init>`(). 6:5
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                                                    ^ definition com/airbnb/epoxy/EpoxyModelGroup#onViewDetachedFromWindow().``#`<init>`(). 1:4
      @Override
//     ^^^^^^^^ reference java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#onViewDetachedFromWindow().``#onModel().
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local34
//                                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local35
//                                                                          ^^^^^^^^^^ definition local36
        //noinspection unchecked
        model.onViewDetachedFromWindow(viewHolder.objectToBind());
//      ^^^^^ reference local34
//            ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                     ^^^^^^^^^^ reference local35
//                                                ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
      }
    });
  }

  private void iterateModels(ModelGroupHolder holder, IterateModelsCallback callback) {
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                           ^^^^^^^^^^^^^^^^ reference _root_/
//                                            ^^^^^^ definition local37
//                                                    ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                                                                          ^^^^^^^^ definition local38
    holder.bindGroupIfNeeded(this);
//  ^^^^^^ reference local37
//         ^^^^^^^^^^^^^^^^^ reference bindGroupIfNeeded#
//                           ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#this.
    int modelCount = models.size();
//      ^^^^^^^^^^ definition local39
//                   ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                          ^^^^ reference java/util/List#size().

    for (int i = 0; i < modelCount; i++) {
//           ^ definition local40
//                  ^ reference local40
//                      ^^^^^^^^^^ reference local39
//                                  ^ reference local40
      callback.onModel(models.get(i), holder.getViewHolders().get(i), i);
//    ^^^^^^^^ reference local38
//             ^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//                     ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                            ^^^ reference java/util/List#get().
//                                ^ reference local40
//                                    ^^^^^^ reference local37
//                                           ^^^^^^^^^^^^^^ reference getViewHolders#
//                                                            ^^^ reference getViewHolders#get#
//                                                                ^ reference local40
//                                                                    ^ reference local40
    }
  }

  private interface IterateModelsCallback {
//        ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
    void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex);
//       ^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                          ^^^^^ definition local41
//                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local42
//                                                                 ^^^^^^^^^^ definition local43
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public int getSpanSize(int totalSpanCount, int position, int itemCount) {
//           ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#getSpanSize().
//                           ^^^^^^^^^^^^^^ definition local44
//                                               ^^^^^^^^ definition local45
//                                                             ^^^^^^^^^ definition local46
    // Defaults to using the span size of the first model. Override this if you need to customize it
    return models.get(0).spanSize(totalSpanCount, position, itemCount);
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                ^^^ reference java/util/List#get().
//                       ^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#spanSize().
//                                ^^^^^^^^^^^^^^ reference local44
//                                                ^^^^^^^^ reference local45
//                                                          ^^^^^^^^^ reference local46
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  protected final int getDefaultLayout() {
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#getDefaultLayout().
    throw new UnsupportedOperationException(
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#`<init>`(+1). 1:74
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/UnsupportedOperationException#
        "You should set a layout with layout(...) instead of using this.");
  }

  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  public EpoxyModelGroup shouldSaveViewState(boolean shouldSaveViewState) {
//       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                       ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState().
//                                                   ^^^^^^^^^^^^^^^^^^^ definition local47
    onMutation();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#onMutation().
    this.shouldSaveViewState = shouldSaveViewState;
//  ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#this.
//       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState.
//                             ^^^^^^^^^^^^^^^^^^^ reference local47
    return this;
//         ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#this.
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean shouldSaveViewState() {
//               ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState(+1).
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
//                  ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#useViewStubLayoutParams().
//                                          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                        ^^^^^ definition local48
//                                                                   ^^^^^^^^^^^^^ definition local49
    return true;
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  protected final ModelGroupHolder createNewHolder(@NonNull ViewParent parent) {
//                ^^^^^^^^^^^^^^^^ reference _root_/
//                                 ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#createNewHolder().
//                                                  ^^^^^^^ reference androidx/annotation/NonNull#
//                                                          ^^^^^^^^^^ reference _root_/
//                                                                     ^^^^^^ definition local50
    return new ModelGroupHolder(parent);
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference `<init>`#
//             ^^^^^^^^^^^^^^^^ reference _root_/
//                              ^^^^^^ reference local50
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#equals().
//                      ^^^^^^ reference java/lang/Object#
//                             ^ definition local51
    if (this == o) {
//      ^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#this.
//              ^ reference local51
      return true;
    }
    if (!(o instanceof EpoxyModelGroup)) {
//        ^ reference local51
//                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
      return false;
    }
    if (!super.equals(o)) {
//       ^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#super.
//             ^^^^^^ reference com/airbnb/epoxy/EpoxyModel#equals().
//                    ^ reference local51
      return false;
    }

    EpoxyModelGroup that = (EpoxyModelGroup) o;
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                  ^^^^ definition local52
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#
//                                           ^ reference local51

    return models.equals(that.models);
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                ^^^^^^ reference java/util/List#equals().
//                       ^^^^ reference local52
//                            ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelGroup#hashCode().
    int result = super.hashCode();
//      ^^^^^^ definition local53
//               ^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#super.
//                     ^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#hashCode().
    result = 31 * result + models.hashCode();
//  ^^^^^^ reference local53
//                ^^^^^^ reference local53
//                         ^^^^^^ reference com/airbnb/epoxy/EpoxyModelGroup#models.
//                                ^^^^^^^^ reference java/util/List#hashCode().
    return result;
//         ^^^^^^ reference local53
  }
}
