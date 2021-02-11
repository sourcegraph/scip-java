
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
 ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
public abstract class EpoxyAdapter extends BaseEpoxyAdapter {
//              ^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#`<init>`().
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#
//                                         ^^^^^^^^^^^^^^^^ reference _root_/
  private final HiddenEpoxyModel hiddenModel = new HiddenEpoxyModel();
//              ^^^^^^^^^^^^^^^^ reference _root_/
//                               ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hiddenModel.
//                                                 ^^^^^^^^^^^^^^^^ reference _root_/

  /**
   * Subclasses should modify this list as necessary with the models they want to show. Subclasses
   * are responsible for notifying data changes whenever this list is changed.
   */
  protected final List<EpoxyModel<?>> models = new ModelList();
//                ^^^^ reference java/util/List#
//                     ^^^^^^^^^^ reference _root_/
//                                    ^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#models.
//                                                 ^^^^^^^^^ reference _root_/
  private DiffHelper diffHelper;
//        ^^^^^^^^^^ reference _root_/
//                   ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#diffHelper.

  @Override
   ^^^^^^^^ reference java/lang/Override#
  List<EpoxyModel<?>> getCurrentModels() {
  ^^^^ reference java/util/List#
//     ^^^^^^^^^^ reference _root_/
//                    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#getCurrentModels().
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
//               ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#enableDiffing().
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
//                   ^^^^^^^^^^ reference _root_/
//                              ^^^^ reference com/airbnb/epoxy/EpoxyAdapter#this.
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  EpoxyModel<?> getModelForPosition(int position) {
  ^^^^^^^^^^ reference _root_/
//              ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#getModelForPosition().
//                                      ^^^^^^^^ definition local0
    EpoxyModel<?> model = models.get(position);
//  ^^^^^^^^^^ reference _root_/
//                ^^^^^ definition local1
//                        ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                               ^^^ reference java/util/List#get().
//                                   ^^^^^^^^ reference local0
    return model.isShown() ? model : hiddenModel;
//         ^^^^^ reference local1
//               ^^^^^^^ reference `<any>`#isShown#
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
//               ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#notifyModelsChanged().
    if (diffHelper == null) {
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#diffHelper.
      throw new IllegalStateException("You must enable diffing before notifying models changed");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }

    diffHelper.notifyModelChanges();
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#diffHelper.
//             ^^^^^^^^^^^^^^^^^^ reference notifyModelChanges#
  }

  /**
   * Notify that the given model has had its data changed. It should only be called if the model
   * retained the same position.
   */
  protected void notifyModelChanged(EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
//                                  ^^^^^^^^^^ reference _root_/
//                                                ^^^^^ definition local2
    notifyModelChanged(model, null);
//  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(+1).
//                     ^^^^^ reference local2
  }

  /**
   * Notify that the given model has had its data changed. It should only be called if the model
   * retained the same position.
   */
  protected void notifyModelChanged(EpoxyModel<?> model, @Nullable Object payload) {
//               ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(+1).
//                                  ^^^^^^^^^^ reference _root_/
//                                                ^^^^^ definition local3
//                                                        ^^^^^^^^ reference androidx/annotation/Nullable#
//                                                                 ^^^^^^ reference java/lang/Object#
//                                                                        ^^^^^^^ definition local4
    int index = getModelPosition(model);
//      ^^^^^ definition local5
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#getModelPosition#
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
//               ^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#addModel().
//                        ^^^^^^^^^^ reference _root_/
//                                      ^^^^^^^^^^ definition local6
    int initialSize = models.size();
//      ^^^^^^^^^^^ definition local7
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
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#addModels().
//                         ^^^^^^^^^^ reference _root_/
//                                          ^^^^^^^^^^^ definition local8
    int initialSize = models.size();
//      ^^^^^^^^^^^ definition local9
//                    ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                           ^^^^ reference java/util/List#size().
    int numModelsToAdd = modelsToAdd.length;
//      ^^^^^^^^^^^^^^ definition local10
//                       ^^^^^^^^^^^ reference local8
//                                   ^^^^^^ reference length.

    ((ModelList) models).ensureCapacity(initialSize + numModelsToAdd);
//    ^^^^^^^^^ reference _root_/
//               ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                       ^^^^^^^^^^^^^^ reference ensureCapacity#
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
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#addModels(+1).
//                         ^^^^^^^^^^ reference java/util/Collection#
//                                              ^^^^^^^^^^ reference _root_/
//                                                             ^^^^^^^^^^^ definition local11
    int initialSize = models.size();
//      ^^^^^^^^^^^ definition local12
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
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#insertModelBefore().
//                                 ^^^^^^^^^^ reference _root_/
//                                               ^^^^^^^^^^^^^ definition local13
//                                                              ^^^^^^^^^^ reference _root_/
//                                                                            ^^^^^^^^^^^^^^^^^^^ definition local14
    int targetIndex = getModelPosition(modelToInsertBefore);
//      ^^^^^^^^^^^ definition local15
//                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#getModelPosition#
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
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
//                                ^^^^^^^^^^ reference _root_/
//                                              ^^^^^^^^^^^^^ definition local16
//                                                             ^^^^^^^^^^ reference _root_/
//                                                                           ^^^^^^^^^^^^^^^^^^ definition local17
    int modelIndex = getModelPosition(modelToInsertAfter);
//      ^^^^^^^^^^ definition local18
//                   ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#getModelPosition#
//                                    ^^^^^^^^^^^^^^^^^^ reference local17
    if (modelIndex == -1) {
//      ^^^^^^^^^^ reference local18
      throw new IllegalStateException("Model is not added: " + modelToInsertAfter);
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
//                                                             ^^^^^^^^^^^^^^^^^^ reference local17
    }

    int targetIndex = modelIndex + 1;
//      ^^^^^^^^^^^ definition local19
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
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#removeModel().
//                           ^^^^^^^^^^ reference _root_/
//                                         ^^^^^ definition local20
    int index = getModelPosition(model);
//      ^^^^^ definition local21
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#getModelPosition#
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
//               ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#removeAllModels().
    int numModelsRemoved = models.size();
//      ^^^^^^^^^^^^^^^^ definition local22
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
//               ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                                   ^^^^^^^^^^ reference _root_/
//                                                 ^^^^^ definition local23
    List<EpoxyModel<?>> modelsToRemove = getAllModelsAfter(model);
//  ^^^^ reference java/util/List#
//       ^^^^^^^^^^ reference _root_/
//                      ^^^^^^^^^^^^^^ definition local24
//                                       ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                                         ^^^^^ reference local23
    int numModelsRemoved = modelsToRemove.size();
//      ^^^^^^^^^^^^^^^^ definition local25
//                         ^^^^^^^^^^^^^^ reference local24
//                                        ^^^^ reference java/util/List#size().
    int initialModelCount = models.size();
//      ^^^^^^^^^^^^^^^^^ definition local26
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
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModel().
//                         ^^^^^^^^^^ reference _root_/
//                                       ^^^^^ definition local27
//                                                      ^^^^ definition local28
    if (model.isShown() == show) {
//      ^^^^^ reference local27
//            ^^^^^^^ reference `<any>`#isShown#
//                         ^^^^ reference local28
      return;
    }

    model.show(show);
//  ^^^^^ reference local27
//        ^^^^ reference `<any>`#show#
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
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModel(+1).
//                         ^^^^^^^^^^ reference _root_/
//                                       ^^^^^ definition local29
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
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModels().
//                          ^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local30
    showModels(Arrays.asList(models));
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModels().
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
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModels(+1).
//                                  ^^^^ definition local31
//                                        ^^^^^^^^^^ reference _root_/
//                                                         ^^^^^^ definition local32
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
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
//                          ^^^^^^^^ reference java/lang/Iterable#
//                                   ^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^ definition local33
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
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//                          ^^^^^^^^ reference java/lang/Iterable#
//                                   ^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^ definition local34
//                                                                  ^^^^ definition local35
    for (EpoxyModel<?> model : models) {
//       ^^^^^^^^^^ reference _root_/
//                     ^^^^^ definition local36
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
//               ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hideModel().
//                         ^^^^^^^^^^ reference _root_/
//                                       ^^^^^ definition local37
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
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hideModels().
//                          ^^^^^^^^ reference java/lang/Iterable#
//                                   ^^^^^^^^^^ reference _root_/
//                                                  ^^^^^^ definition local38
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
//               ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hideModels(+1).
//                          ^^^^^^^^^^ reference _root_/
//                                           ^^^^^^ definition local39
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
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#hideAllAfterModel().
//                                 ^^^^^^^^^^ reference _root_/
//                                               ^^^^^ definition local40
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
//               ^^^^^^^^^^ reference _root_/
//                              ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                                ^^^^^^^^^^ reference _root_/
//                                                              ^^^^^ definition local41
    int index = getModelPosition(model);
//      ^^^^^ definition local42
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#getModelPosition#
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
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    ((ModelList) models).pauseNotifications();
//    ^^^^^^^^^ reference _root_/
//               ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                       ^^^^^^^^^^^^^^^^^^ reference pauseNotifications#
  }

  private void resumeModelListNotifications() {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().
    ((ModelList) models).resumeNotifications();
//    ^^^^^^^^^ reference _root_/
//               ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
//                       ^^^^^^^^^^^^^^^^^^^ reference resumeNotifications#
  }
}
