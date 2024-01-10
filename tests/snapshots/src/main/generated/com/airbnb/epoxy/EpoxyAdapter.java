
package com.airbnb.epoxy;

import java.util.Arrays;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
import java.util.Collection;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
import java.util.Collections;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#

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
//^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
public abstract class EpoxyAdapter extends BaseEpoxyAdapter {
//                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#
//                                 display_name EpoxyAdapter
//                                 signature_documentation java @SuppressWarnings("WeakerAccess")\npublic abstract class EpoxyAdapter
//                                 kind Class
//                                 documentation  Allows you to easily combine different view types in the same adapter, and handles view holder\n creation, binding, and ids for you. Subclasses just need to add their desired {@link EpoxyModel}\n objects and the rest is done automatically.\n <p/>\n {@link androidx.recyclerview.widget.RecyclerView.Adapter#setHasStableIds(boolean)} is set to true\n by default, since {@link EpoxyModel} makes it easy to support unique ids. If you don't want to\n support this then disable it in your base class (not recommended).\n
//                                 relationship is_implementation semanticdb maven . . RecyclerView/Adapter#
//                                 relationship is_implementation semanticdb maven . . StickyHeaderCallbacks#
//                                 relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#`<init>`().
//                                 display_name <init>
//                                 signature_documentation java public EpoxyAdapter()
//                                 kind Constructor
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
  private final HiddenEpoxyModel hiddenModel = new HiddenEpoxyModel();
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#
//                               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hiddenModel.
//                                           display_name hiddenModel
//                                           signature_documentation java private final HiddenEpoxyModel hiddenModel
//                                           kind Field
//                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#`<init>`().

  /**
   * Subclasses should modify this list as necessary with the models they want to show. Subclasses
   * are responsible for notifying data changes whenever this list is changed.
   */
  protected final List<EpoxyModel<?>> models = new ModelList();
//                ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                                           display_name models
//                                           signature_documentation java protected final List<EpoxyModel<?>> models
//                                           kind Field
//                                           documentation  Subclasses should modify this list as necessary with the models they want to show. Subclasses\n are responsible for notifying data changes whenever this list is changed.\n
//                                                 ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#`<init>`(+1).
  private DiffHelper diffHelper;
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#
//                   ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#diffHelper.
//                              display_name diffHelper
//                              signature_documentation java private DiffHelper diffHelper
//                              kind Field

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  List<EpoxyModel<?>> getCurrentModels() {
//^^^^ reference semanticdb maven jdk 11 java/util/List#
//     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getCurrentModels().
//                                     display_name getCurrentModels
//                                     signature_documentation java @Override\nList<EpoxyModel<?>> getCurrentModels()
//                                     kind Method
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
    return models;
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
  }

  /**
   * Enables support for automatically notifying model changes via {@link #notifyModelsChanged()}.
   * If used, this should be called in the constructor, before any models are changed.
   *
   * @see #notifyModelsChanged()
   */
  protected void enableDiffing() {
//               ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#enableDiffing().
//                             display_name enableDiffing
//                             signature_documentation java protected void enableDiffing()
//                             kind Method
//                             documentation  Enables support for automatically notifying model changes via {@link #notifyModelsChanged()}.\n If used, this should be called in the constructor, before any models are changed.\n\n @see #notifyModelsChanged()\n
//                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#enableDiffing().
    if (diffHelper != null) {
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#diffHelper.
      throw new IllegalStateException("Diffing was already enabled");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    if (!models.isEmpty()) {
//       ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//              ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      throw new IllegalStateException("You must enable diffing before modifying models");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    if (!hasStableIds()) {
//       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hasStableIds#
      throw new IllegalStateException("You must have stable ids to use diffing");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    diffHelper = new DiffHelper(this, false);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#diffHelper.
//                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#`<init>`().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  EpoxyModel<?> getModelForPosition(int position) {
//^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getModelForPosition().
//                                  display_name getModelForPosition
//                                  signature_documentation java @Override\nEpoxyModel<?> getModelForPosition(int position)
//                                  kind Method
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelForPosition().
//                                      ^^^^^^^^ definition local 0
//                                               display_name position
//                                               signature_documentation java int position
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getModelForPosition().
    EpoxyModel<?> model = models.get(position);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^ definition local 1
//                      display_name model
//                      signature_documentation java EpoxyModel<?> model
//                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getModelForPosition().
//                      kind Variable
//                        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                               ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                   ^^^^^^^^ reference local 0
    return model.isShown() ? model : hiddenModel;
//         ^^^^^ reference local 1
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isShown().
//                           ^^^^^ reference local 1
//                                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hiddenModel.
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
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelsChanged().
//                                   display_name notifyModelsChanged
//                                   signature_documentation java protected void notifyModelsChanged()
//                                   kind Method
//                                   documentation  Intelligently notify item changes by comparing the current {@link #models} list against the\n previous so you don't have to micromanage notification calls yourself. This may be\n prohibitively slow for large model lists (in the hundreds), in which case consider doing\n notification calls yourself. If you use this, all your view models must implement {@link\n EpoxyModel#hashCode()} and {@link EpoxyModel#equals(Object)} to completely identify their\n state, so that changes to a model's content can be detected. Before using this you must enable\n it with {@link #enableDiffing()}, since keeping track of the model state adds extra computation\n time to all other data change notifications.\n\n @see #enableDiffing()\n
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#notifyModelsChanged().
    if (diffHelper == null) {
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#diffHelper.
      throw new IllegalStateException("You must enable diffing before notifying models changed");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }

    diffHelper.notifyModelChanges();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#diffHelper.
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffHelper#notifyModelChanges().
  }

  /**
   * Notify that the given model has had its data changed. It should only be called if the model
   * retained the same position.
   */
  protected void notifyModelChanged(EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
//                                  display_name notifyModelChanged
//                                  signature_documentation java protected void notifyModelChanged(EpoxyModel<?> model)
//                                  kind Method
//                                  documentation  Notify that the given model has had its data changed. It should only be called if the model\n retained the same position.\n
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#notifyModelChanged().
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                ^^^^^ definition local 2
//                                                      display_name model
//                                                      signature_documentation java EpoxyModel<?> model
//                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
    notifyModelChanged(model, null);
//  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(+1).
//                     ^^^^^ reference local 2
  }

  /**
   * Notify that the given model has had its data changed. It should only be called if the model
   * retained the same position.
   */
  protected void notifyModelChanged(EpoxyModel<?> model, @Nullable Object payload) {
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(+1).
//                                  display_name notifyModelChanged
//                                  signature_documentation java protected void notifyModelChanged(EpoxyModel<?> model, Object payload)
//                                  kind Method
//                                  documentation  Notify that the given model has had its data changed. It should only be called if the model\n retained the same position.\n
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                ^^^^^ definition local 3
//                                                      display_name model
//                                                      signature_documentation java EpoxyModel<?> model
//                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(+1).
//                                                        ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                        ^^^^^^^ definition local 4
//                                                                                display_name payload
//                                                                                signature_documentation java @Nullable\nObject payload
//                                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(+1).
    int index = getModelPosition(model);
//      ^^^^^ definition local 5
//            display_name index
//            signature_documentation java int index
//            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged(+1).
//            kind Variable
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                               ^^^^^ reference local 3
    if (index != -1) {
//      ^^^^^ reference local 5
      notifyItemChanged(index, payload);
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyItemChanged#
//                      ^^^^^ reference local 5
//                             ^^^^^^^ reference local 4
    }
  }

  /**
   * Adds the model to the end of the {@link #models} list and notifies that the item was inserted.
   */
  protected void addModel(EpoxyModel<?> modelToAdd) {
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModel().
//                        display_name addModel
//                        signature_documentation java protected void addModel(EpoxyModel<?> modelToAdd)
//                        kind Method
//                        documentation  Adds the model to the end of the {@link #models} list and notifies that the item was inserted.\n
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^^^^^^ definition local 6
//                                                 display_name modelToAdd
//                                                 signature_documentation java EpoxyModel<?> modelToAdd
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModel().
    int initialSize = models.size();
//      ^^^^^^^^^^^ definition local 7
//                  display_name initialSize
//                  signature_documentation java int initialSize
//                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModel().
//                  kind Variable
//                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                           ^^^^ reference semanticdb maven jdk 11 java/util/List#size().

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.add(modelToAdd);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//             ^^^^^^^^^^ reference local 6
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeInserted(initialSize, 1);
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeInserted#
//                          ^^^^^^^^^^^ reference local 7
  }

  /**
   * Adds the models to the end of the {@link #models} list and notifies that the items were
   * inserted.
   */
  protected void addModels(EpoxyModel<?>... modelsToAdd) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels().
//                         display_name addModels
//                         signature_documentation java protected void addModels(EpoxyModel<?>[] modelsToAdd)
//                         kind Method
//                         documentation  Adds the models to the end of the {@link #models} list and notifies that the items were\n inserted.\n
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#addModels().
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^^^^^^^ definition local 8
//                                                      display_name modelsToAdd
//                                                      signature_documentation java EpoxyModel<?>[] modelsToAdd
//                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels().
    int initialSize = models.size();
//      ^^^^^^^^^^^ definition local 9
//                  display_name initialSize
//                  signature_documentation java int initialSize
//                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels().
//                  kind Variable
//                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                           ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    int numModelsToAdd = modelsToAdd.length;
//      ^^^^^^^^^^^^^^ definition local 10
//                     display_name numModelsToAdd
//                     signature_documentation java int numModelsToAdd
//                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels().
//                     kind Variable
//                       ^^^^^^^^^^^ reference local 8
//                                   ^^^^^^ reference semanticdb maven . . Array#length.

    ((ModelList) models).ensureCapacity(initialSize + numModelsToAdd);
//    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                       ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#ensureCapacity().
//                                      ^^^^^^^^^^^ reference local 9
//                                                    ^^^^^^^^^^^^^^ reference local 10

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    Collections.addAll(models, modelsToAdd);
//  ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//              ^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#addAll().
//                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                             ^^^^^^^^^^^ reference local 8
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeInserted(initialSize, numModelsToAdd);
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeInserted#
//                          ^^^^^^^^^^^ reference local 9
//                                       ^^^^^^^^^^^^^^ reference local 10
  }

  /**
   * Adds the models to the end of the {@link #models} list and notifies that the items were
   * inserted.
   */
  protected void addModels(Collection<? extends EpoxyModel<?>> modelsToAdd) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels(+1).
//                         display_name addModels
//                         signature_documentation java protected void addModels(Collection<? extends EpoxyModel<?>> modelsToAdd)
//                         kind Method
//                         documentation  Adds the models to the end of the {@link #models} list and notifies that the items were\n inserted.\n
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#addModels(+1).
//                         ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                             ^^^^^^^^^^^ definition local 11
//                                                                         display_name modelsToAdd
//                                                                         signature_documentation java Collection<? extends EpoxyModel<?>> modelsToAdd
//                                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels(+1).
    int initialSize = models.size();
//      ^^^^^^^^^^^ definition local 12
//                  display_name initialSize
//                  signature_documentation java int initialSize
//                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels(+1).
//                  kind Variable
//                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                           ^^^^ reference semanticdb maven jdk 11 java/util/List#size().

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.addAll(modelsToAdd);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^^^^ reference semanticdb maven jdk 11 java/util/List#addAll().
//                ^^^^^^^^^^^ reference local 11
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeInserted(initialSize, modelsToAdd.size());
//  ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeInserted#
//                          ^^^^^^^^^^^ reference local 12
//                                       ^^^^^^^^^^^ reference local 11
//                                                   ^^^^ reference semanticdb maven jdk 11 java/util/Collection#size().
  }

  /**
   * Inserts the given model before the other in the {@link #models} list, and notifies that the
   * item was inserted.
   */
  protected void insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore) {
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelBefore().
//                                 display_name insertModelBefore
//                                 signature_documentation java protected void insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore)
//                                 kind Method
//                                 documentation  Inserts the given model before the other in the {@link #models} list, and notifies that the\n item was inserted.\n
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelBefore().
//                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^^^ definition local 13
//                                                             display_name modelToInsert
//                                                             signature_documentation java EpoxyModel<?> modelToInsert
//                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelBefore().
//                                                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                            ^^^^^^^^^^^^^^^^^^^ definition local 14
//                                                                                                display_name modelToInsertBefore
//                                                                                                signature_documentation java EpoxyModel<?> modelToInsertBefore
//                                                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelBefore().
    int targetIndex = getModelPosition(modelToInsertBefore);
//      ^^^^^^^^^^^ definition local 15
//                  display_name targetIndex
//                  signature_documentation java int targetIndex
//                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelBefore().
//                  kind Variable
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                                     ^^^^^^^^^^^^^^^^^^^ reference local 14
    if (targetIndex == -1) {
//      ^^^^^^^^^^^ reference local 15
      throw new IllegalStateException("Model is not added: " + modelToInsertBefore);
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
//                                                             ^^^^^^^^^^^^^^^^^^^ reference local 14
    }

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.add(targetIndex, modelToInsert);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^ reference semanticdb maven jdk 11 java/util/List#add(+1).
//             ^^^^^^^^^^^ reference local 15
//                          ^^^^^^^^^^^^^ reference local 13
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemInserted(targetIndex);
//  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyItemInserted#
//                     ^^^^^^^^^^^ reference local 15
  }

  /**
   * Inserts the given model after the other in the {@link #models} list, and notifies that the item
   * was inserted.
   */
  protected void insertModelAfter(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertAfter) {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
//                                display_name insertModelAfter
//                                signature_documentation java protected void insertModelAfter(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertAfter)
//                                kind Method
//                                documentation  Inserts the given model after the other in the {@link #models} list, and notifies that the item\n was inserted.\n
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelAfter().
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^^^^^^^^ definition local 16
//                                                            display_name modelToInsert
//                                                            signature_documentation java EpoxyModel<?> modelToInsert
//                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
//                                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                           ^^^^^^^^^^^^^^^^^^ definition local 17
//                                                                                              display_name modelToInsertAfter
//                                                                                              signature_documentation java EpoxyModel<?> modelToInsertAfter
//                                                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
    int modelIndex = getModelPosition(modelToInsertAfter);
//      ^^^^^^^^^^ definition local 18
//                 display_name modelIndex
//                 signature_documentation java int modelIndex
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
//                 kind Variable
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                                    ^^^^^^^^^^^^^^^^^^ reference local 17
    if (modelIndex == -1) {
//      ^^^^^^^^^^ reference local 18
      throw new IllegalStateException("Model is not added: " + modelToInsertAfter);
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
//                                                             ^^^^^^^^^^^^^^^^^^ reference local 17
    }

    int targetIndex = modelIndex + 1;
//      ^^^^^^^^^^^ definition local 19
//                  display_name targetIndex
//                  signature_documentation java int targetIndex
//                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
//                  kind Variable
//                    ^^^^^^^^^^ reference local 18
    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.add(targetIndex, modelToInsert);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^ reference semanticdb maven jdk 11 java/util/List#add(+1).
//             ^^^^^^^^^^^ reference local 19
//                          ^^^^^^^^^^^^^ reference local 16
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemInserted(targetIndex);
//  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyItemInserted#
//                     ^^^^^^^^^^^ reference local 19
  }

  /**
   * If the given model exists it is removed and an item removal is notified. Otherwise this does
   * nothing.
   */
  protected void removeModel(EpoxyModel<?> model) {
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeModel().
//                           display_name removeModel
//                           signature_documentation java protected void removeModel(EpoxyModel<?> model)
//                           kind Method
//                           documentation  If the given model exists it is removed and an item removal is notified. Otherwise this does\n nothing.\n
//                           relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeModel().
//                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^ definition local 20
//                                               display_name model
//                                               signature_documentation java EpoxyModel<?> model
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeModel().
    int index = getModelPosition(model);
//      ^^^^^ definition local 21
//            display_name index
//            signature_documentation java int index
//            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeModel().
//            kind Variable
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                               ^^^^^ reference local 20
    if (index != -1) {
//      ^^^^^ reference local 21
      pauseModelListNotifications();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
      models.remove(index);
//    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//           ^^^^^^ reference semanticdb maven jdk 11 java/util/List#remove(+1).
//                  ^^^^^ reference local 21
      resumeModelListNotifications();
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

      notifyItemRemoved(index);
//    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyItemRemoved#
//                      ^^^^^ reference local 21
    }
  }

  /**
   * Removes all models
   */
  protected void removeAllModels() {
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllModels().
//                               display_name removeAllModels
//                               signature_documentation java protected void removeAllModels()
//                               kind Method
//                               documentation  Removes all models\n
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeAllModels().
    int numModelsRemoved = models.size();
//      ^^^^^^^^^^^^^^^^ definition local 22
//                       display_name numModelsRemoved
//                       signature_documentation java int numModelsRemoved
//                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllModels().
//                       kind Variable
//                         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                                ^^^^ reference semanticdb maven jdk 11 java/util/List#size().

    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    models.clear();
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//         ^^^^^ reference semanticdb maven jdk 11 java/util/List#clear().
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeRemoved(0, numModelsRemoved);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeRemoved#
//                            ^^^^^^^^^^^^^^^^ reference local 22
  }

  /**
   * Removes all models after the given model, which must have already been added. An example use
   * case is you want to keep a header but clear everything else, like in the case of refreshing
   * data.
   */
  protected void removeAllAfterModel(EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                                   display_name removeAllAfterModel
//                                   signature_documentation java protected void removeAllAfterModel(EpoxyModel<?> model)
//                                   kind Method
//                                   documentation  Removes all models after the given model, which must have already been added. An example use\n case is you want to keep a header but clear everything else, like in the case of refreshing\n data.\n
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeAllAfterModel().
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^ definition local 23
//                                                       display_name model
//                                                       signature_documentation java EpoxyModel<?> model
//                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
    List<EpoxyModel<?>> modelsToRemove = getAllModelsAfter(model);
//  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^^^^^^^^^ definition local 24
//                                     display_name modelsToRemove
//                                     signature_documentation java List<EpoxyModel<?>> modelsToRemove
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                                     kind Variable
//                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                                         ^^^^^ reference local 23
    int numModelsRemoved = modelsToRemove.size();
//      ^^^^^^^^^^^^^^^^ definition local 25
//                       display_name numModelsRemoved
//                       signature_documentation java int numModelsRemoved
//                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                       kind Variable
//                         ^^^^^^^^^^^^^^ reference local 24
//                                        ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
    int initialModelCount = models.size();
//      ^^^^^^^^^^^^^^^^^ definition local 26
//                        display_name initialModelCount
//                        signature_documentation java int initialModelCount
//                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                        kind Variable
//                          ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/List#size().

    // This is a sublist, so clearing it will clear the models in the original list
    pauseModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
    modelsToRemove.clear();
//  ^^^^^^^^^^^^^^ reference local 24
//                 ^^^^^ reference semanticdb maven jdk 11 java/util/List#clear().
    resumeModelListNotifications();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().

    notifyItemRangeRemoved(initialModelCount - numModelsRemoved, numModelsRemoved);
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyItemRangeRemoved#
//                         ^^^^^^^^^^^^^^^^^ reference local 26
//                                             ^^^^^^^^^^^^^^^^ reference local 25
//                                                               ^^^^^^^^^^^^^^^^ reference local 25
  }

  /**
   * Sets the visibility of the given model, and notifies that the item changed if the new
   * visibility is different from the previous.
   *
   * @param model The model to show. It should already be added to the {@link #models} list.
   * @param show  True to show the model, false to hide it.
   */
  protected void showModel(EpoxyModel<?> model, boolean show) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel().
//                         display_name showModel
//                         signature_documentation java protected void showModel(EpoxyModel<?> model, boolean show)
//                         kind Method
//                         documentation  Sets the visibility of the given model, and notifies that the item changed if the new\n visibility is different from the previous.\n\n @param model The model to show. It should already be added to the {@link #models} list.\n @param show  True to show the model, false to hide it.\n
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModel().
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^ definition local 27
//                                             display_name model
//                                             signature_documentation java EpoxyModel<?> model
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel().
//                                                      ^^^^ definition local 28
//                                                           display_name show
//                                                           signature_documentation java boolean show
//                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel().
    if (model.isShown() == show) {
//      ^^^^^ reference local 27
//            ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isShown().
//                         ^^^^ reference local 28
      return;
    }

    model.show(show);
//  ^^^^^ reference local 27
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#show(+1).
//             ^^^^ reference local 28
    notifyModelChanged(model);
//  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
//                     ^^^^^ reference local 27
  }

  /**
   * Shows the given model, and notifies that the item changed if the item wasn't already shown.
   *
   * @param model The model to show. It should already be added to the {@link #models} list.
   */
  protected void showModel(EpoxyModel<?> model) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel(+1).
//                         display_name showModel
//                         signature_documentation java protected void showModel(EpoxyModel<?> model)
//                         kind Method
//                         documentation  Shows the given model, and notifies that the item changed if the item wasn't already shown.\n\n @param model The model to show. It should already be added to the {@link #models} list.\n
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModel(+1).
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^ definition local 29
//                                             display_name model
//                                             signature_documentation java EpoxyModel<?> model
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel(+1).
    showModel(model, true);
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel().
//            ^^^^^ reference local 29
  }

  /**
   * Shows the given models, and notifies that each item changed if the item wasn't already shown.
   *
   * @param models The models to show. They should already be added to the {@link #models} list.
   */
  protected void showModels(EpoxyModel<?>... models) {
//               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels().
//                          display_name showModels
//                          signature_documentation java protected void showModels(EpoxyModel<?>[] models)
//                          kind Method
//                          documentation  Shows the given models, and notifies that each item changed if the item wasn't already shown.\n\n @param models The models to show. They should already be added to the {@link #models} list.\n
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels().
//                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^ definition local 30
//                                                  display_name models
//                                                  signature_documentation java EpoxyModel<?>[] models
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels().
    showModels(Arrays.asList(models));
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
//             ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                    ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#asList().
//                           ^^^^^^ reference local 30
  }

  /**
   * Sets the visibility of the given models, and notifies that the items changed if the new
   * visibility is different from the previous.
   *
   * @param models The models to show. They should already be added to the {@link #models} list.
   * @param show   True to show the models, false to hide them.
   */
  protected void showModels(boolean show, EpoxyModel<?>... models) {
//               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+1).
//                          display_name showModels
//                          signature_documentation java protected void showModels(boolean show, EpoxyModel<?>[] models)
//                          kind Method
//                          documentation  Sets the visibility of the given models, and notifies that the items changed if the new\n visibility is different from the previous.\n\n @param models The models to show. They should already be added to the {@link #models} list.\n @param show   True to show the models, false to hide them.\n
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+1).
//                                  ^^^^ definition local 31
//                                       display_name show
//                                       signature_documentation java boolean show
//                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+1).
//                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                         ^^^^^^ definition local 32
//                                                                display_name models
//                                                                signature_documentation java EpoxyModel<?>[] models
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+1).
    showModels(Arrays.asList(models), show);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//             ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                    ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#asList().
//                           ^^^^^^ reference local 32
//                                    ^^^^ reference local 31
  }

  /**
   * Shows the given models, and notifies that each item changed if the item wasn't already shown.
   *
   * @param models The models to show. They should already be added to the {@link #models} list.
   */
  protected void showModels(Iterable<EpoxyModel<?>> models) {
//               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
//                          display_name showModels
//                          signature_documentation java protected void showModels(Iterable<EpoxyModel<?>> models)
//                          kind Method
//                          documentation  Shows the given models, and notifies that each item changed if the item wasn't already shown.\n\n @param models The models to show. They should already be added to the {@link #models} list.\n
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+2).
//                          ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^ definition local 33
//                                                         display_name models
//                                                         signature_documentation java Iterable<EpoxyModel<?>> models
//                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
    showModels(models, true);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//             ^^^^^^ reference local 33
  }

  /**
   * Sets the visibility of the given models, and notifies that the items changed if the new
   * visibility is different from the previous.
   *
   * @param models The models to show. They should already be added to the {@link #models} list.
   * @param show   True to show the models, false to hide them.
   */
  protected void showModels(Iterable<EpoxyModel<?>> models, boolean show) {
//               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//                          display_name showModels
//                          signature_documentation java protected void showModels(Iterable<EpoxyModel<?>> models, boolean show)
//                          kind Method
//                          documentation  Sets the visibility of the given models, and notifies that the items changed if the new\n visibility is different from the previous.\n\n @param models The models to show. They should already be added to the {@link #models} list.\n @param show   True to show the models, false to hide them.\n
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+3).
//                          ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^ definition local 34
//                                                         display_name models
//                                                         signature_documentation java Iterable<EpoxyModel<?>> models
//                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//                                                                  ^^^^ definition local 35
//                                                                       display_name show
//                                                                       signature_documentation java boolean show
//                                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
    for (EpoxyModel<?> model : models) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local 36
//                           display_name model
//                           signature_documentation java EpoxyModel<?> model
//                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//                           kind Variable
//                             ^^^^^^ reference local 34
      showModel(model, show);
//    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel().
//              ^^^^^ reference local 36
//                     ^^^^ reference local 35
    }
  }

  /**
   * Hides the given model, and notifies that the item changed if the item wasn't already hidden.
   *
   * @param model The model to hide. This should already be added to the {@link #models} list.
   */
  protected void hideModel(EpoxyModel<?> model) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModel().
//                         display_name hideModel
//                         signature_documentation java protected void hideModel(EpoxyModel<?> model)
//                         kind Method
//                         documentation  Hides the given model, and notifies that the item changed if the item wasn't already hidden.\n\n @param model The model to hide. This should already be added to the {@link #models} list.\n
//                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModel().
//                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^ definition local 37
//                                             display_name model
//                                             signature_documentation java EpoxyModel<?> model
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModel().
    showModel(model, false);
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel().
//            ^^^^^ reference local 37
  }

  /**
   * Hides the given models, and notifies that each item changed if the item wasn't already hidden.
   *
   * @param models The models to hide. They should already be added to the {@link #models} list.
   */
  protected void hideModels(Iterable<EpoxyModel<?>> models) {
//               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels().
//                          display_name hideModels
//                          signature_documentation java protected void hideModels(Iterable<EpoxyModel<?>> models)
//                          kind Method
//                          documentation  Hides the given models, and notifies that each item changed if the item wasn't already hidden.\n\n @param models The models to hide. They should already be added to the {@link #models} list.\n
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels().
//                          ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^ definition local 38
//                                                         display_name models
//                                                         signature_documentation java Iterable<EpoxyModel<?>> models
//                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels().
    showModels(models, false);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//             ^^^^^^ reference local 38
  }

  /**
   * Hides the given models, and notifies that each item changed if the item wasn't already hidden.
   *
   * @param models The models to hide. They should already be added to the {@link #models} list.
   */
  protected void hideModels(EpoxyModel<?>... models) {
//               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels(+1).
//                          display_name hideModels
//                          signature_documentation java protected void hideModels(EpoxyModel<?>[] models)
//                          kind Method
//                          documentation  Hides the given models, and notifies that each item changed if the item wasn't already hidden.\n\n @param models The models to hide. They should already be added to the {@link #models} list.\n
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels(+1).
//                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^ definition local 39
//                                                  display_name models
//                                                  signature_documentation java EpoxyModel<?>[] models
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels(+1).
    hideModels(Arrays.asList(models));
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels().
//             ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                    ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#asList().
//                           ^^^^^^ reference local 39
  }

  /**
   * Hides all models currently located after the given model in the {@link #models} list.
   *
   * @param model The model after which to hide. It must exist in the {@link #models} list.
   */
  protected void hideAllAfterModel(EpoxyModel<?> model) {
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideAllAfterModel().
//                                 display_name hideAllAfterModel
//                                 signature_documentation java protected void hideAllAfterModel(EpoxyModel<?> model)
//                                 kind Method
//                                 documentation  Hides all models currently located after the given model in the {@link #models} list.\n\n @param model The model after which to hide. It must exist in the {@link #models} list.\n
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideAllAfterModel().
//                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^ definition local 40
//                                                     display_name model
//                                                     signature_documentation java EpoxyModel<?> model
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideAllAfterModel().
    hideModels(getAllModelsAfter(model));
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels().
//             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                               ^^^^^ reference local 40
  }

  /**
   * Returns a sub list of all items in {@link #models} that occur after the given model. This list
   * is backed by the original models list, any changes to the returned list will be reflected in
   * the original {@link #models} list.
   *
   * @param model Must exist in {@link #models}.
   */
  protected List<EpoxyModel<?>> getAllModelsAfter(EpoxyModel<?> model) {
//          ^^^^ reference semanticdb maven jdk 11 java/util/List#
//               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                                display_name getAllModelsAfter
//                                                signature_documentation java protected List<EpoxyModel<?>> getAllModelsAfter(EpoxyModel<?> model)
//                                                kind Method
//                                                documentation  Returns a sub list of all items in {@link #models} that occur after the given model. This list\n is backed by the original models list, any changes to the returned list will be reflected in\n the original {@link #models} list.\n\n @param model Must exist in {@link #models}.\n
//                                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getAllModelsAfter().
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                              ^^^^^ definition local 41
//                                                                    display_name model
//                                                                    signature_documentation java EpoxyModel<?> model
//                                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
    int index = getModelPosition(model);
//      ^^^^^ definition local 42
//            display_name index
//            signature_documentation java int index
//            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//            kind Variable
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                               ^^^^^ reference local 41
    if (index == -1) {
//      ^^^^^ reference local 42
      throw new IllegalStateException("Model is not added: " + model);
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
//                                                             ^^^^^ reference local 41
    }
    return models.subList(index + 1, models.size());
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#subList().
//                        ^^^^^ reference local 42
//                                   ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                                          ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
  }

  /**
   * We pause the list's notifications when we modify models internally, since we already do the
   * proper adapter notifications for those modifications. By pausing these list notifications we
   * prevent the differ having to do work to track them.
   */
  private void pauseModelListNotifications() {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#pauseModelListNotifications().
//                                         display_name pauseModelListNotifications
//                                         signature_documentation java private void pauseModelListNotifications()
//                                         kind Method
//                                         documentation  We pause the list's notifications when we modify models internally, since we already do the\n proper adapter notifications for those modifications. By pausing these list notifications we\n prevent the differ having to do work to track them.\n
    ((ModelList) models).pauseNotifications();
//    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#pauseNotifications().
  }

  private void resumeModelListNotifications() {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#resumeModelListNotifications().
//                                          display_name resumeModelListNotifications
//                                          signature_documentation java private void resumeModelListNotifications()
//                                          kind Method
    ((ModelList) models).resumeNotifications();
//    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#resumeNotifications().
  }
}
