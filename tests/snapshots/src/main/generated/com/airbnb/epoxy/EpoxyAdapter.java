
package com.airbnb.epoxy;

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

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#

/**
 * Allows you to easily combine different view types in the same adapter, and handles view holder
 * creation, binding, and ids for you. Subclasses just need to add their desired {@link EpoxyModel}
 * objects and the rest is done automatically.
 * <p/>
 * {@link androidx.recyclerview.widget.RecyclerView.Adapter#setHasStableIds(boolean)} is set to true
 * by default, since {@link EpoxyModel} makes it easy to support unique ids. If you don't want to
 * support this then disable it in your base class (not recommended).
 */
@SuppressWarnings("WeakerAccess")
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
public abstract class EpoxyAdapter extends BaseEpoxyAdapter {
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter# public abstract class EpoxyAdapter extends BaseEpoxyAdapter
//                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#`<init>`(). public EpoxyAdapter()
//                                         ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#
  private final HiddenEpoxyModel hiddenModel = new HiddenEpoxyModel();
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HiddenEpoxyModel#
//                               ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hiddenModel. private final HiddenEpoxyModel hiddenModel
//                                             ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HiddenEpoxyModel#`<init>`().
//                                                 ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HiddenEpoxyModel#

  /**
   * Subclasses should modify this list as necessary with the models they want to show. Subclasses
   * are responsible for notifying data changes whenever this list is changed.
   */
  protected final List<EpoxyModel<?>> models = new ModelList();
//                ^^^^ reference java/util/List#
//                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#models. protected final List<EpoxyModel<?>> models
//                                             ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#`<init>`(+1).
//                                                 ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
  private DiffHelper diffHelper;
//        ^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#
//                   ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#diffHelper. private DiffHelper diffHelper

  @Override
// ^^^^^^^^ reference java/lang/Override#
  List<EpoxyModel<?>> getCurrentModels() {
//^^^^ reference java/util/List#
//     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#getCurrentModels(). List<EpoxyModel<?>> getCurrentModels()
    return models;
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
  }

  /**
   * Enables support for automatically notifying model changes via {@link #notifyModelsChanged()}.
   * If used, this should be called in the constructor, before any models are changed.
   *
   * @see #notifyModelsChanged()
   */
  protected void enableDiffing() {
//               ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#enableDiffing(). protected void enableDiffing()
    if (diffHelper != null) {
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#diffHelper.
      throw new IllegalStateException("Diffing was already enabled");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    if (!models.isEmpty()) {
//       ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//              ^^^^^^^ reference java/util/List#isEmpty().
      throw new IllegalStateException("You must enable diffing before modifying models");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    if (!hasStableIds()) {
//       ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#hasStableIds#
      throw new IllegalStateException("You must have stable ids to use diffing");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    diffHelper = new DiffHelper(this, false);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#diffHelper.
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#`<init>`().
//                   ^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#
//                              ^^^^ reference com/airbnb/epoxy/EpoxyAdapter#
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  EpoxyModel<?> getModelForPosition(int position) {
//^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//              ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#getModelForPosition(). EpoxyModel<?> getModelForPosition(int position)
//                                      ^^^^^^^^ definition local0 int position
    EpoxyModel<?> model = models.get(position);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local1 EpoxyModel<?> model
//                        ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                               ^^^ reference java/util/List#get().
//                                   ^^^^^^^^ reference local0
    return model.isShown() ? model : hiddenModel;
//         ^^^^^ reference local1
//               ^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#isShown().
//                           ^^^^^ reference local1
//                                   ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#hiddenModel.
  }

  /**
   * Intelligently notify item changes by comparing the current {@link #models} list against the
   * previous so you don't have to micromanage notification calls yourself. This may be
   * prohibitively slow for large model lists (in the hundreds), in which case consider doing
   * notification calls yourself. If you use this, all your view models must implement {@link
   * EpoxyModel#hashCode()} and {@link EpoxyModel#equals(Object)} to completely identify their
   * state, so that changes to a model's content can be detected. Before using this you must enable
   * it with {@link #enableDiffing()}, since keeping track of the model state adds extra computation
   * time to all other data change notifications.
   *
   * @see #enableDiffing()
   */

  protected void notifyModelsChanged() {
//               ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#notifyModelsChanged(). protected void notifyModelsChanged()
    if (diffHelper == null) {
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#diffHelper.
      throw new IllegalStateException("You must enable diffing before notifying models changed");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    diffHelper.notifyModelChanges();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#diffHelper.
//             ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/DiffHelper#notifyModelChanges().
  }

  /**
   * Notify that the given model has had its data changed. It should only be called if the model
   * retained the same position.
   */
  protected void notifyModelChanged(EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(). protected void notifyModelChanged(EpoxyModel<?> model)
//                                  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                ^^^^^ definition local2 EpoxyModel<?> model
    notifyModelChanged(model, null);
//  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(+1).
//                     ^^^^^ reference local2
  }

  /**
   * Notify that the given model has had its data changed. It should only be called if the model
   * retained the same position.
   */
  protected void notifyModelChanged(EpoxyModel<?> model, @Nullable Object payload) {
//               ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(+1). protected void notifyModelChanged(EpoxyModel<?> model, Object payload)
//                                  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                ^^^^^ definition local3 EpoxyModel<?> model
//                                                        ^^^^^^^^ reference androidx/annotation/Nullable#
//                                                                 ^^^^^^ reference java/lang/Object#
//                                                                        ^^^^^^^ definition local4 Object payload
    int index = getModelPosition(model);
//      ^^^^^ definition local5 int index
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                               ^^^^^ reference local3
    if (index != -1) {
//      ^^^^^ reference local5
      notifyItemChanged(index, payload);
//    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyItemChanged#
//                      ^^^^^ reference local5
//                             ^^^^^^^ reference local4
    }
  }

  /**
   * Adds the model to the end of the {@link #models} list and notifies that the item was inserted.
   */
  protected void addModel(EpoxyModel<?> modelToAdd) {
//               ^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#addModel(). protected void addModel(EpoxyModel<?> modelToAdd)
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^ definition local6 EpoxyModel<?> modelToAdd
    int initialSize = models.size();
//      ^^^^^^^^^^^ definition local7 int initialSize
//                    ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                           ^^^^ reference java/util/List#size().

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.add(modelToAdd);
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^ reference java/util/List#add().
//             ^^^^^^^^^^ reference local6
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeInserted(initialSize, 1);
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeInserted#
//                          ^^^^^^^^^^^ reference local7
  }

  /**
   * Adds the models to the end of the {@link #models} list and notifies that the items were
   * inserted.
   */
  protected void addModels(EpoxyModel<?>... modelsToAdd) {
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#addModels(). protected void addModels(EpoxyModel<?>[] modelsToAdd)
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^^^^^^ definition local8 EpoxyModel<?>[] modelsToAdd
    int initialSize = models.size();
//      ^^^^^^^^^^^ definition local9 int initialSize
//                    ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                           ^^^^ reference java/util/List#size().
    int numModelsToAdd = modelsToAdd.length;
//      ^^^^^^^^^^^^^^ definition local10 int numModelsToAdd
//                       ^^^^^^^^^^^ reference local8
//                                   ^^^^^^ reference length.

    ((ModelList) models).ensureCapacity(initialSize + numModelsToAdd);
//    ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//               ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                       ^^^^^^^^^^^^^^ reference java/util/ArrayList#ensureCapacity().
//                                      ^^^^^^^^^^^ reference local9
//                                                    ^^^^^^^^^^^^^^ reference local10

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    Collections.addAll(models, modelsToAdd);
//  ^^^^^^^^^^^ reference java/util/Collections#
//              ^^^^^^ reference java/util/Collections#addAll().
//                     ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                             ^^^^^^^^^^^ reference local8
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeInserted(initialSize, numModelsToAdd);
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeInserted#
//                          ^^^^^^^^^^^ reference local9
//                                       ^^^^^^^^^^^^^^ reference local10
  }

  /**
   * Adds the models to the end of the {@link #models} list and notifies that the items were
   * inserted.
   */
  protected void addModels(Collection<? extends EpoxyModel<?>> modelsToAdd) {
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#addModels(+1). protected void addModels(Collection<? extends EpoxyModel<?>> modelsToAdd)
//                         ^^^^^^^^^^ reference java/util/Collection#
//                                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                             ^^^^^^^^^^^ definition local11 Collection<? extends EpoxyModel<?>> modelsToAdd
    int initialSize = models.size();
//      ^^^^^^^^^^^ definition local12 int initialSize
//                    ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                           ^^^^ reference java/util/List#size().

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.addAll(modelsToAdd);
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^^^^ reference java/util/List#addAll().
//                ^^^^^^^^^^^ reference local11
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeInserted(initialSize, modelsToAdd.size());
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeInserted#
//                          ^^^^^^^^^^^ reference local12
//                                       ^^^^^^^^^^^ reference local11
//                                                   ^^^^ reference java/util/Collection#size().
  }

  /**
   * Inserts the given model before the other in the {@link #models} list, and notifies that the
   * item was inserted.
   */
  protected void insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore) {
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#insertModelBefore(). protected void insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore)
//                                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^^^ definition local13 EpoxyModel<?> modelToInsert
//                                                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                            ^^^^^^^^^^^^^^^^^^^ definition local14 EpoxyModel<?> modelToInsertBefore
    int targetIndex = getModelPosition(modelToInsertBefore);
//      ^^^^^^^^^^^ definition local15 int targetIndex
//                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                                     ^^^^^^^^^^^^^^^^^^^ reference local14
    if (targetIndex == -1) {
//      ^^^^^^^^^^^ reference local15
      throw new IllegalStateException("Model is not added: " + modelToInsertBefore);
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
//                                                             ^^^^^^^^^^^^^^^^^^^ reference local14
    }

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.add(targetIndex, modelToInsert);
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^ reference java/util/List#add(+1).
//             ^^^^^^^^^^^ reference local15
//                          ^^^^^^^^^^^^^ reference local13
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemInserted(targetIndex);
//  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyItemInserted#
//                     ^^^^^^^^^^^ reference local15
  }

  /**
   * Inserts the given model after the other in the {@link #models} list, and notifies that the item
   * was inserted.
   */
  protected void insertModelAfter(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertAfter) {
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#insertModelAfter(). protected void insertModelAfter(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertAfter)
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^^^^^^^^ definition local16 EpoxyModel<?> modelToInsert
//                                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                           ^^^^^^^^^^^^^^^^^^ definition local17 EpoxyModel<?> modelToInsertAfter
    int modelIndex = getModelPosition(modelToInsertAfter);
//      ^^^^^^^^^^ definition local18 int modelIndex
//                   ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                                    ^^^^^^^^^^^^^^^^^^ reference local17
    if (modelIndex == -1) {
//      ^^^^^^^^^^ reference local18
      throw new IllegalStateException("Model is not added: " + modelToInsertAfter);
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
//                                                             ^^^^^^^^^^^^^^^^^^ reference local17
    }

    int targetIndex = modelIndex + 1;
//      ^^^^^^^^^^^ definition local19 int targetIndex
//                    ^^^^^^^^^^ reference local18
    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.add(targetIndex, modelToInsert);
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^ reference java/util/List#add(+1).
//             ^^^^^^^^^^^ reference local19
//                          ^^^^^^^^^^^^^ reference local16
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemInserted(targetIndex);
//  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyItemInserted#
//                     ^^^^^^^^^^^ reference local19
  }

  /**
   * If the given model exists it is removed and an item removal is notified. Otherwise this does
   * nothing.
   */
  protected void removeModel(EpoxyModel<?> model) {
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#removeModel(). protected void removeModel(EpoxyModel<?> model)
//                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^ definition local20 EpoxyModel<?> model
    int index = getModelPosition(model);
//      ^^^^^ definition local21 int index
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                               ^^^^^ reference local20
    if (index != -1) {
//      ^^^^^ reference local21
      pauseModelListNotifications();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
      models.remove(index);
//    ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//           ^^^^^^ reference java/util/List#remove(+1).
//                  ^^^^^ reference local21
      resumeModelListNotifications();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

      notifyItemRemoved(index);
//    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyItemRemoved#
//                      ^^^^^ reference local21
    }
  }

  /**
   * Removes all models
   */
  protected void removeAllModels() {
//               ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#removeAllModels(). protected void removeAllModels()
    int numModelsRemoved = models.size();
//      ^^^^^^^^^^^^^^^^ definition local22 int numModelsRemoved
//                         ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                                ^^^^ reference java/util/List#size().

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.clear();
//  ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^^^ reference java/util/List#clear().
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeRemoved(0, numModelsRemoved);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeRemoved#
//                            ^^^^^^^^^^^^^^^^ reference local22
  }

  /**
   * Removes all models after the given model, which must have already been added. An example use
   * case is you want to keep a header but clear everything else, like in the case of refreshing
   * data.
   */
  protected void removeAllAfterModel(EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel(). protected void removeAllAfterModel(EpoxyModel<?> model)
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^ definition local23 EpoxyModel<?> model
    List<EpoxyModel<?>> modelsToRemove = getAllModelsAfter(model);
//  ^^^^ reference java/util/List#
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^^^^^^^^^ definition local24 List<EpoxyModel<?>> modelsToRemove
//                                       ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                                         ^^^^^ reference local23
    int numModelsRemoved = modelsToRemove.size();
//      ^^^^^^^^^^^^^^^^ definition local25 int numModelsRemoved
//                         ^^^^^^^^^^^^^^ reference local24
//                                        ^^^^ reference java/util/List#size().
    int initialModelCount = models.size();
//      ^^^^^^^^^^^^^^^^^ definition local26 int initialModelCount
//                          ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                                 ^^^^ reference java/util/List#size().

    // This is a sublist, so clearing it will clear the models in the original list
    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    modelsToRemove.clear();
//  ^^^^^^^^^^^^^^ reference local24
//                 ^^^^^ reference java/util/List#clear().
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeRemoved(initialModelCount - numModelsRemoved, numModelsRemoved);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeRemoved#
//                         ^^^^^^^^^^^^^^^^^ reference local26
//                                             ^^^^^^^^^^^^^^^^ reference local25
//                                                               ^^^^^^^^^^^^^^^^ reference local25
  }

  /**
   * Sets the visibility of the given model, and notifies that the item changed if the new
   * visibility is different from the previous.
   *
   * @param model The model to show. It should already be added to the {@link #models} list.
   * @param show  True to show the model, false to hide it.
   */
  protected void showModel(EpoxyModel<?> model, boolean show) {
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModel(). protected void showModel(EpoxyModel<?> model, boolean show)
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^ definition local27 EpoxyModel<?> model
//                                                      ^^^^ definition local28 boolean show
    if (model.isShown() == show) {
//      ^^^^^ reference local27
//            ^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#isShown().
//                         ^^^^ reference local28
      return;
    }

    model.show(show);
//  ^^^^^ reference local27
//        ^^^^ reference com/airbnb/epoxy/EpoxyModel#show(+1).
//             ^^^^ reference local28
    notifyModelChanged(model);
//  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
//                     ^^^^^ reference local27
  }

  /**
   * Shows the given model, and notifies that the item changed if the item wasn't already shown.
   *
   * @param model The model to show. It should already be added to the {@link #models} list.
   */
  protected void showModel(EpoxyModel<?> model) {
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModel(+1). protected void showModel(EpoxyModel<?> model)
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^ definition local29 EpoxyModel<?> model
    showModel(model, true);
//  ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModel().
//            ^^^^^ reference local29
  }

  /**
   * Shows the given models, and notifies that each item changed if the item wasn't already shown.
   *
   * @param models The models to show. They should already be added to the {@link #models} list.
   */
  protected void showModels(EpoxyModel<?>... models) {
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModels(). protected void showModels(EpoxyModel<?>[] models)
//                          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^ definition local30 EpoxyModel<?>[] models
    showModels(Arrays.asList(models));
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
//             ^^^^^^ reference java/util/Arrays#
//                    ^^^^^^ reference java/util/Arrays#asList().
//                           ^^^^^^ reference local30
  }

  /**
   * Sets the visibility of the given models, and notifies that the items changed if the new
   * visibility is different from the previous.
   *
   * @param models The models to show. They should already be added to the {@link #models} list.
   * @param show   True to show the models, false to hide them.
   */
  protected void showModels(boolean show, EpoxyModel<?>... models) {
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModels(+1). protected void showModels(boolean show, EpoxyModel<?>[] models)
//                                  ^^^^ definition local31 boolean show
//                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                         ^^^^^^ definition local32 EpoxyModel<?>[] models
    showModels(Arrays.asList(models), show);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//             ^^^^^^ reference java/util/Arrays#
//                    ^^^^^^ reference java/util/Arrays#asList().
//                           ^^^^^^ reference local32
//                                    ^^^^ reference local31
  }

  /**
   * Shows the given models, and notifies that each item changed if the item wasn't already shown.
   *
   * @param models The models to show. They should already be added to the {@link #models} list.
   */
  protected void showModels(Iterable<EpoxyModel<?>> models) {
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModels(+2). protected void showModels(Iterable<EpoxyModel<?>> models)
//                          ^^^^^^^^ reference java/lang/Iterable#
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^ definition local33 Iterable<EpoxyModel<?>> models
    showModels(models, true);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//             ^^^^^^ reference local33
  }

  /**
   * Sets the visibility of the given models, and notifies that the items changed if the new
   * visibility is different from the previous.
   *
   * @param models The models to show. They should already be added to the {@link #models} list.
   * @param show   True to show the models, false to hide them.
   */
  protected void showModels(Iterable<EpoxyModel<?>> models, boolean show) {
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModels(+3). protected void showModels(Iterable<EpoxyModel<?>> models, boolean show)
//                          ^^^^^^^^ reference java/lang/Iterable#
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^ definition local34 Iterable<EpoxyModel<?>> models
//                                                                  ^^^^ definition local35 boolean show
    for (EpoxyModel<?> model : models) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local36 EpoxyModel<?> model
//                             ^^^^^^ reference local34
      showModel(model, show);
//    ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModel().
//              ^^^^^ reference local36
//                     ^^^^ reference local35
    }
  }

  /**
   * Hides the given model, and notifies that the item changed if the item wasn't already hidden.
   *
   * @param model The model to hide. This should already be added to the {@link #models} list.
   */
  protected void hideModel(EpoxyModel<?> model) {
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hideModel(). protected void hideModel(EpoxyModel<?> model)
//                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^ definition local37 EpoxyModel<?> model
    showModel(model, false);
//  ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModel().
//            ^^^^^ reference local37
  }

  /**
   * Hides the given models, and notifies that each item changed if the item wasn't already hidden.
   *
   * @param models The models to hide. They should already be added to the {@link #models} list.
   */
  protected void hideModels(Iterable<EpoxyModel<?>> models) {
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hideModels(). protected void hideModels(Iterable<EpoxyModel<?>> models)
//                          ^^^^^^^^ reference java/lang/Iterable#
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^ definition local38 Iterable<EpoxyModel<?>> models
    showModels(models, false);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//             ^^^^^^ reference local38
  }

  /**
   * Hides the given models, and notifies that each item changed if the item wasn't already hidden.
   *
   * @param models The models to hide. They should already be added to the {@link #models} list.
   */
  protected void hideModels(EpoxyModel<?>... models) {
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hideModels(+1). protected void hideModels(EpoxyModel<?>[] models)
//                          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^ definition local39 EpoxyModel<?>[] models
    hideModels(Arrays.asList(models));
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#hideModels().
//             ^^^^^^ reference java/util/Arrays#
//                    ^^^^^^ reference java/util/Arrays#asList().
//                           ^^^^^^ reference local39
  }

  /**
   * Hides all models currently located after the given model in the {@link #models} list.
   *
   * @param model The model after which to hide. It must exist in the {@link #models} list.
   */
  protected void hideAllAfterModel(EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hideAllAfterModel(). protected void hideAllAfterModel(EpoxyModel<?> model)
//                                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^ definition local40 EpoxyModel<?> model
    hideModels(getAllModelsAfter(model));
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#hideModels().
//             ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                               ^^^^^ reference local40
  }

  /**
   * Returns a sub list of all items in {@link #models} that occur after the given model. This list
   * is backed by the original models list, any changes to the returned list will be reflected in
   * the original {@link #models} list.
   *
   * @param model Must exist in {@link #models}.
   */
  protected List<EpoxyModel<?>> getAllModelsAfter(EpoxyModel<?> model) {
//          ^^^^ reference java/util/List#
//               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                              ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter(). protected List<EpoxyModel<?>> getAllModelsAfter(EpoxyModel<?> model)
//                                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                              ^^^^^ definition local41 EpoxyModel<?> model
    int index = getModelPosition(model);
//      ^^^^^ definition local42 int index
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                               ^^^^^ reference local41
    if (index == -1) {
//      ^^^^^ reference local42
      throw new IllegalStateException("Model is not added: " + model);
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
//                                                             ^^^^^ reference local41
    }
    return models.subList(index + 1, models.size());
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                ^^^^^^^ reference java/util/List#subList().
//                        ^^^^^ reference local42
//                                   ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                                          ^^^^ reference java/util/List#size().
  }

  /**
   * We pause the list's notifications when we modify models internally, since we already do the
   * proper adapter notifications for those modifications. By pausing these list notifications we
   * prevent the differ having to do work to track them.
   */
  private void pauseModelListNotifications() {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications(). private void pauseModelListNotifications()
    ((ModelList) models).pauseNotifications();
//    ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//               ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                       ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#pauseNotifications().
  }

  private void resumeModelListNotifications() {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications(). private void resumeModelListNotifications()
    ((ModelList) models).resumeNotifications();
//    ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//               ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#resumeNotifications().
  }
}
