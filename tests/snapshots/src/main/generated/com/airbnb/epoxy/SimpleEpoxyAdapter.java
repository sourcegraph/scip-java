package com.airbnb.epoxy;

import java.util.Collection;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

/**
 * A non-abstract version of {@link com.airbnb.epoxy.EpoxyAdapter} that exposes all methods and
 * models as public. Use this if you don't want to create your own adapter subclass and instead want
 * to modify the adapter from elsewhere, such as from an activity.
 */
public class SimpleEpoxyAdapter extends EpoxyAdapter {
//           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#
//                              documentation ```java\npublic class SimpleEpoxyAdapter\n```
//                              documentation  A non-abstract version of {@link com.airbnb.epoxy.EpoxyAdapter} that exposes all methods and\n models as public. Use this if you don't want to create your own adapter subclass and instead want\n to modify the adapter from elsewhere, such as from an activity.\n
//                              relationship is_implementation semanticdb maven . . RecyclerView/Adapter#
//                              relationship is_implementation semanticdb maven . . ``/StickyHeaderCallbacks#
//                              relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                              relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#
//           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#`<init>`().
//                              documentation ```java\npublic SimpleEpoxyAdapter()\n```
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#

  public List<EpoxyModel<?>> getModels() {
//       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getModels().
//                                     documentation ```java\npublic List<EpoxyModel<?>> getModels()\n```
    return models;
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void enableDiffing() {
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#enableDiffing().
//                          documentation ```java\n@Override\npublic void enableDiffing()\n```
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#enableDiffing().
    super.enableDiffing();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#enableDiffing().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void notifyModelsChanged() {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#notifyModelsChanged().
//                                documentation ```java\n@Override\npublic void notifyModelsChanged()\n```
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelsChanged().
    super.notifyModelsChanged();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelsChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public BoundViewHolders getBoundViewHolders() {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BoundViewHolders#
//                        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getBoundViewHolders().
//                                            documentation ```java\n@Override\npublic BoundViewHolders getBoundViewHolders()\n```
//                                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
    return super.getBoundViewHolders();
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void notifyModelChanged(EpoxyModel<?> model) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#notifyModelChanged().
//                               documentation ```java\n@Override\npublic void notifyModelChanged(EpoxyModel<?> model)\n```
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
//                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^ definition local 0
//                                                   documentation ```java\nEpoxyModel<?> model\n```
    super.notifyModelChanged(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
//                           ^^^^^ reference local 0
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void addModels(EpoxyModel<?>... modelsToAdd) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#addModels().
//                      documentation ```java\n@Override\npublic void addModels(EpoxyModel<?>[] modelsToAdd)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^^^^^^^ definition local 1
//                                                   documentation ```java\nEpoxyModel<?>[] modelsToAdd\n```
    super.addModels(modelsToAdd);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels().
//                  ^^^^^^^^^^^ reference local 1
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void addModels(Collection<? extends EpoxyModel<?>> modelsToAdd) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#addModels(+1).
//                      documentation ```java\n@Override\npublic void addModels(Collection<? extends EpoxyModel<?>> modelsToAdd)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels(+1).
//                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^^^^^^^ definition local 2
//                                                                      documentation ```java\nCollection<? extends EpoxyModel<?>> modelsToAdd\n```
    super.addModels(modelsToAdd);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels(+1).
//                  ^^^^^^^^^^^ reference local 2
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore) {
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelBefore().
//                              documentation ```java\n@Override\npublic void insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore)\n```
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelBefore().
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                            ^^^^^^^^^^^^^ definition local 3
//                                                          documentation ```java\nEpoxyModel<?> modelToInsert\n```
//                                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                         ^^^^^^^^^^^^^^^^^^^ definition local 4
//                                                                                             documentation ```java\nEpoxyModel<?> modelToInsertBefore\n```
    super.insertModelBefore(modelToInsert, modelToInsertBefore);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelBefore().
//                          ^^^^^^^^^^^^^ reference local 3
//                                         ^^^^^^^^^^^^^^^^^^^ reference local 4
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void insertModelAfter(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertAfter) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelAfter().
//                             documentation ```java\n@Override\npublic void insertModelAfter(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertAfter)\n```
//                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
//                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^^^^^ definition local 5
//                                                         documentation ```java\nEpoxyModel<?> modelToInsert\n```
//                                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                        ^^^^^^^^^^^^^^^^^^ definition local 6
//                                                                                           documentation ```java\nEpoxyModel<?> modelToInsertAfter\n```
    super.insertModelAfter(modelToInsert, modelToInsertAfter);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
//                         ^^^^^^^^^^^^^ reference local 5
//                                        ^^^^^^^^^^^^^^^^^^ reference local 6
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void removeModel(EpoxyModel<?> model) {
//            ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeModel().
//                        documentation ```java\n@Override\npublic void removeModel(EpoxyModel<?> model)\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeModel().
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^ definition local 7
//                                            documentation ```java\nEpoxyModel<?> model\n```
    super.removeModel(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeModel().
//                    ^^^^^ reference local 7
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void removeAllModels() {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeAllModels().
//                            documentation ```java\n@Override\npublic void removeAllModels()\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllModels().
    super.removeAllModels();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllModels().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void removeAllAfterModel(EpoxyModel<?> model) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeAllAfterModel().
//                                documentation ```java\n@Override\npublic void removeAllAfterModel(EpoxyModel<?> model)\n```
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^ definition local 8
//                                                    documentation ```java\nEpoxyModel<?> model\n```
    super.removeAllAfterModel(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                            ^^^^^ reference local 8
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModel(EpoxyModel<?> model, boolean show) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModel().
//                      documentation ```java\n@Override\npublic void showModel(EpoxyModel<?> model, boolean show)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^ definition local 9
//                                          documentation ```java\nEpoxyModel<?> model\n```
//                                                   ^^^^ definition local 10
//                                                        documentation ```java\nboolean show\n```
    super.showModel(model, show);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel().
//                  ^^^^^ reference local 9
//                         ^^^^ reference local 10
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModel(EpoxyModel<?> model) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModel(+1).
//                      documentation ```java\n@Override\npublic void showModel(EpoxyModel<?> model)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel(+1).
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^ definition local 11
//                                          documentation ```java\nEpoxyModel<?> model\n```
    super.showModel(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel(+1).
//                  ^^^^^ reference local 11
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModels(EpoxyModel<?>... models) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels().
//                       documentation ```java\n@Override\npublic void showModels(EpoxyModel<?>[] models)\n```
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels().
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^^ definition local 12
//                                               documentation ```java\nEpoxyModel<?>[] models\n```
    super.showModels(models);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels().
//                   ^^^^^^ reference local 12
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModels(boolean show, EpoxyModel<?>... models) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+1).
//                       documentation ```java\n@Override\npublic void showModels(boolean show, EpoxyModel<?>[] models)\n```
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+1).
//                               ^^^^ definition local 13
//                                    documentation ```java\nboolean show\n```
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                      ^^^^^^ definition local 14
//                                                             documentation ```java\nEpoxyModel<?>[] models\n```
    super.showModels(show, models);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+1).
//                   ^^^^ reference local 13
//                         ^^^^^^ reference local 14
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModels(Iterable<EpoxyModel<?>> epoxyModels) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+2).
//                       documentation ```java\n@Override\npublic void showModels(Iterable<EpoxyModel<?>> epoxyModels)\n```
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
//                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^ definition local 15
//                                                           documentation ```java\nIterable<EpoxyModel<?>> epoxyModels\n```
    super.showModels(epoxyModels);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
//                   ^^^^^^^^^^^ reference local 15
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModels(Iterable<EpoxyModel<?>> epoxyModels, boolean show) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+3).
//                       documentation ```java\n@Override\npublic void showModels(Iterable<EpoxyModel<?>> epoxyModels, boolean show)\n```
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^ definition local 16
//                                                           documentation ```java\nIterable<EpoxyModel<?>> epoxyModels\n```
//                                                                    ^^^^ definition local 17
//                                                                         documentation ```java\nboolean show\n```
    super.showModels(epoxyModels, show);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//                   ^^^^^^^^^^^ reference local 16
//                                ^^^^ reference local 17
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void hideModel(EpoxyModel<?> model) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModel().
//                      documentation ```java\n@Override\npublic void hideModel(EpoxyModel<?> model)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModel().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^ definition local 18
//                                          documentation ```java\nEpoxyModel<?> model\n```
    super.hideModel(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModel().
//                  ^^^^^ reference local 18
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void hideModels(Iterable<EpoxyModel<?>> epoxyModels) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels().
//                       documentation ```java\n@Override\npublic void hideModels(Iterable<EpoxyModel<?>> epoxyModels)\n```
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels().
//                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^ definition local 19
//                                                           documentation ```java\nIterable<EpoxyModel<?>> epoxyModels\n```
    super.hideModels(epoxyModels);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels().
//                   ^^^^^^^^^^^ reference local 19
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void hideModels(EpoxyModel<?>... models) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels(+1).
//                       documentation ```java\n@Override\npublic void hideModels(EpoxyModel<?>[] models)\n```
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels(+1).
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^^ definition local 20
//                                               documentation ```java\nEpoxyModel<?>[] models\n```
    super.hideModels(models);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels(+1).
//                   ^^^^^^ reference local 20
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void hideAllAfterModel(EpoxyModel<?> model) {
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideAllAfterModel().
//                              documentation ```java\n@Override\npublic void hideAllAfterModel(EpoxyModel<?> model)\n```
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideAllAfterModel().
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                            ^^^^^ definition local 21
//                                                  documentation ```java\nEpoxyModel<?> model\n```
    super.hideAllAfterModel(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideAllAfterModel().
//                          ^^^^^ reference local 21
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public List<EpoxyModel<?>> getAllModelsAfter(EpoxyModel<?> model) {
//       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getAllModelsAfter().
//                                             documentation ```java\n@Override\npublic List<EpoxyModel<?>> getAllModelsAfter(EpoxyModel<?> model)\n```
//                                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^ definition local 22
//                                                                 documentation ```java\nEpoxyModel<?> model\n```
    return super.getAllModelsAfter(model);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                 ^^^^^ reference local 22
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getModelPosition(EpoxyModel<?> model) {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getModelPosition().
//                            documentation ```java\n@Override\npublic int getModelPosition(EpoxyModel<?> model)\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^ definition local 23
//                                                documentation ```java\nEpoxyModel<?> model\n```
    return super.getModelPosition(model);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                                ^^^^^ reference local 23
  }
}
