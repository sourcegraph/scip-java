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
//                              display_name SimpleEpoxyAdapter
//                              signature_documentation java public class SimpleEpoxyAdapter
//                              documentation  A non-abstract version of {@link com.airbnb.epoxy.EpoxyAdapter} that exposes all methods and\n models as public. Use this if you don't want to create your own adapter subclass and instead want\n to modify the adapter from elsewhere, such as from an activity.\n
//                              relationship is_implementation semanticdb maven . . RecyclerView/Adapter#
//                              relationship is_implementation semanticdb maven . . StickyHeaderCallbacks#
//                              relationship is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                              relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#
//           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#`<init>`().
//                              display_name <init>
//                              signature_documentation java public SimpleEpoxyAdapter()
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#

  public List<EpoxyModel<?>> getModels() {
//       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getModels().
//                                     display_name getModels
//                                     signature_documentation java public List<EpoxyModel<?>> getModels()
    return models;
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#models.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void enableDiffing() {
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#enableDiffing().
//                          display_name enableDiffing
//                          signature_documentation java @Override\npublic void enableDiffing()
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#enableDiffing().
    super.enableDiffing();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#enableDiffing().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void notifyModelsChanged() {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#notifyModelsChanged().
//                                display_name notifyModelsChanged
//                                signature_documentation java @Override\npublic void notifyModelsChanged()
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
//                                            display_name getBoundViewHolders
//                                            signature_documentation java @Override\npublic BoundViewHolders getBoundViewHolders()
//                                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
    return super.getBoundViewHolders();
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void notifyModelChanged(EpoxyModel<?> model) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#notifyModelChanged().
//                               display_name notifyModelChanged
//                               signature_documentation java @Override\npublic void notifyModelChanged(EpoxyModel<?> model)
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
//                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^ definition local 0
//                                                   display_name model
//                                                   signature_documentation java EpoxyModel<?> model
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#notifyModelChanged().
    super.notifyModelChanged(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
//                           ^^^^^ reference local 0
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void addModels(EpoxyModel<?>... modelsToAdd) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#addModels().
//                      display_name addModels
//                      signature_documentation java @Override\npublic void addModels(EpoxyModel<?>[] modelsToAdd)
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^^^^^^^ definition local 1
//                                                   display_name modelsToAdd
//                                                   signature_documentation java EpoxyModel<?>[] modelsToAdd
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#addModels().
    super.addModels(modelsToAdd);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels().
//                  ^^^^^^^^^^^ reference local 1
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void addModels(Collection<? extends EpoxyModel<?>> modelsToAdd) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#addModels(+1).
//                      display_name addModels
//                      signature_documentation java @Override\npublic void addModels(Collection<? extends EpoxyModel<?>> modelsToAdd)
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels(+1).
//                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^^^^^^^ definition local 2
//                                                                      display_name modelsToAdd
//                                                                      signature_documentation java Collection<? extends EpoxyModel<?>> modelsToAdd
//                                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#addModels(+1).
    super.addModels(modelsToAdd);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#addModels(+1).
//                  ^^^^^^^^^^^ reference local 2
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore) {
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelBefore().
//                              display_name insertModelBefore
//                              signature_documentation java @Override\npublic void insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore)
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelBefore().
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                            ^^^^^^^^^^^^^ definition local 3
//                                                          display_name modelToInsert
//                                                          signature_documentation java EpoxyModel<?> modelToInsert
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelBefore().
//                                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                         ^^^^^^^^^^^^^^^^^^^ definition local 4
//                                                                                             display_name modelToInsertBefore
//                                                                                             signature_documentation java EpoxyModel<?> modelToInsertBefore
//                                                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelBefore().
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
//                             display_name insertModelAfter
//                             signature_documentation java @Override\npublic void insertModelAfter(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertAfter)
//                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
//                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^^^^^ definition local 5
//                                                         display_name modelToInsert
//                                                         signature_documentation java EpoxyModel<?> modelToInsert
//                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelAfter().
//                                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                        ^^^^^^^^^^^^^^^^^^ definition local 6
//                                                                                           display_name modelToInsertAfter
//                                                                                           signature_documentation java EpoxyModel<?> modelToInsertAfter
//                                                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelAfter().
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
//                        display_name removeModel
//                        signature_documentation java @Override\npublic void removeModel(EpoxyModel<?> model)
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeModel().
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^ definition local 7
//                                            display_name model
//                                            signature_documentation java EpoxyModel<?> model
//                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeModel().
    super.removeModel(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeModel().
//                    ^^^^^ reference local 7
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void removeAllModels() {
//            ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeAllModels().
//                            display_name removeAllModels
//                            signature_documentation java @Override\npublic void removeAllModels()
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllModels().
    super.removeAllModels();
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllModels().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void removeAllAfterModel(EpoxyModel<?> model) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeAllAfterModel().
//                                display_name removeAllAfterModel
//                                signature_documentation java @Override\npublic void removeAllAfterModel(EpoxyModel<?> model)
//                                relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^ definition local 8
//                                                    display_name model
//                                                    signature_documentation java EpoxyModel<?> model
//                                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#removeAllAfterModel().
    super.removeAllAfterModel(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                            ^^^^^ reference local 8
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModel(EpoxyModel<?> model, boolean show) {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModel().
//                      display_name showModel
//                      signature_documentation java @Override\npublic void showModel(EpoxyModel<?> model, boolean show)
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^ definition local 9
//                                          display_name model
//                                          signature_documentation java EpoxyModel<?> model
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModel().
//                                                   ^^^^ definition local 10
//                                                        display_name show
//                                                        signature_documentation java boolean show
//                                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModel().
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
//                      display_name showModel
//                      signature_documentation java @Override\npublic void showModel(EpoxyModel<?> model)
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel(+1).
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^ definition local 11
//                                          display_name model
//                                          signature_documentation java EpoxyModel<?> model
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModel(+1).
    super.showModel(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModel(+1).
//                  ^^^^^ reference local 11
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModels(EpoxyModel<?>... models) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels().
//                       display_name showModels
//                       signature_documentation java @Override\npublic void showModels(EpoxyModel<?>[] models)
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels().
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^^ definition local 12
//                                               display_name models
//                                               signature_documentation java EpoxyModel<?>[] models
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels().
    super.showModels(models);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels().
//                   ^^^^^^ reference local 12
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModels(boolean show, EpoxyModel<?>... models) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+1).
//                       display_name showModels
//                       signature_documentation java @Override\npublic void showModels(boolean show, EpoxyModel<?>[] models)
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+1).
//                               ^^^^ definition local 13
//                                    display_name show
//                                    signature_documentation java boolean show
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+1).
//                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                      ^^^^^^ definition local 14
//                                                             display_name models
//                                                             signature_documentation java EpoxyModel<?>[] models
//                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+1).
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
//                       display_name showModels
//                       signature_documentation java @Override\npublic void showModels(Iterable<EpoxyModel<?>> epoxyModels)
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
//                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^ definition local 15
//                                                           display_name epoxyModels
//                                                           signature_documentation java Iterable<EpoxyModel<?>> epoxyModels
//                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+2).
    super.showModels(epoxyModels);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
//                   ^^^^^^^^^^^ reference local 15
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void showModels(Iterable<EpoxyModel<?>> epoxyModels, boolean show) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+3).
//                       display_name showModels
//                       signature_documentation java @Override\npublic void showModels(Iterable<EpoxyModel<?>> epoxyModels, boolean show)
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^ definition local 16
//                                                           display_name epoxyModels
//                                                           signature_documentation java Iterable<EpoxyModel<?>> epoxyModels
//                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+3).
//                                                                    ^^^^ definition local 17
//                                                                         display_name show
//                                                                         signature_documentation java boolean show
//                                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+3).
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
//                      display_name hideModel
//                      signature_documentation java @Override\npublic void hideModel(EpoxyModel<?> model)
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModel().
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^ definition local 18
//                                          display_name model
//                                          signature_documentation java EpoxyModel<?> model
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModel().
    super.hideModel(model);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModel().
//                  ^^^^^ reference local 18
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void hideModels(Iterable<EpoxyModel<?>> epoxyModels) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels().
//                       display_name hideModels
//                       signature_documentation java @Override\npublic void hideModels(Iterable<EpoxyModel<?>> epoxyModels)
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels().
//                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Iterable#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^ definition local 19
//                                                           display_name epoxyModels
//                                                           signature_documentation java Iterable<EpoxyModel<?>> epoxyModels
//                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels().
    super.hideModels(epoxyModels);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels().
//                   ^^^^^^^^^^^ reference local 19
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void hideModels(EpoxyModel<?>... models) {
//            ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels(+1).
//                       display_name hideModels
//                       signature_documentation java @Override\npublic void hideModels(EpoxyModel<?>[] models)
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels(+1).
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^^ definition local 20
//                                               display_name models
//                                               signature_documentation java EpoxyModel<?>[] models
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels(+1).
    super.hideModels(models);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideModels(+1).
//                   ^^^^^^ reference local 20
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void hideAllAfterModel(EpoxyModel<?> model) {
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideAllAfterModel().
//                              display_name hideAllAfterModel
//                              signature_documentation java @Override\npublic void hideAllAfterModel(EpoxyModel<?> model)
//                              relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#hideAllAfterModel().
//                              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                            ^^^^^ definition local 21
//                                                  display_name model
//                                                  signature_documentation java EpoxyModel<?> model
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#hideAllAfterModel().
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
//                                             display_name getAllModelsAfter
//                                             signature_documentation java @Override\npublic List<EpoxyModel<?>> getAllModelsAfter(EpoxyModel<?> model)
//                                             relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^ definition local 22
//                                                                 display_name model
//                                                                 signature_documentation java EpoxyModel<?> model
//                                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getAllModelsAfter().
    return super.getAllModelsAfter(model);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                 ^^^^^ reference local 22
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getModelPosition(EpoxyModel<?> model) {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getModelPosition().
//                            display_name getModelPosition
//                            signature_documentation java @Override\npublic int getModelPosition(EpoxyModel<?> model)
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^ definition local 23
//                                                display_name model
//                                                signature_documentation java EpoxyModel<?> model
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#getModelPosition().
    return super.getModelPosition(model);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                                ^^^^^ reference local 23
  }
}
