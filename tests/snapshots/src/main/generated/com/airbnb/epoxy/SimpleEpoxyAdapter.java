package com.airbnb.epoxy;

import java.util.Collection;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^ reference java/util/Collection#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

/**
 * A non-abstract version of {@link com.airbnb.epoxy.EpoxyAdapter} that exposes all methods and
 * models as public. Use this if you don't want to create your own adapter subclass and instead want
 * to modify the adapter from elsewhere, such as from an activity.
 */
public class SimpleEpoxyAdapter extends EpoxyAdapter {
//           ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter# public class SimpleEpoxyAdapter extends EpoxyAdapter
//           ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#`<init>`(). public <init>()
//                                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#

  public List<EpoxyModel<?>> getModels() {
//       ^^^^ reference java/util/List#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#getModels(). public List<EpoxyModel<?>> getModels()
    return models;
//         ^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#models.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void enableDiffing() {
//            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#enableDiffing(). public enableDiffing()
    super.enableDiffing();
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#enableDiffing().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void notifyModelsChanged() {
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#notifyModelsChanged(). public notifyModelsChanged()
    super.notifyModelsChanged();
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyModelsChanged().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public BoundViewHolders getBoundViewHolders() {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BoundViewHolders#
//                        ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#getBoundViewHolders(). public BoundViewHolders getBoundViewHolders()
    return super.getBoundViewHolders();
//         ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//               ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getBoundViewHolders().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void notifyModelChanged(EpoxyModel<?> model) {
//            ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#notifyModelChanged(). public notifyModelChanged(EpoxyModel<?> model)
//                               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                             ^^^^^ definition local0 EpoxyModel<?> model
    super.notifyModelChanged(model);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#notifyModelChanged().
//                           ^^^^^ reference local0
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void addModels(EpoxyModel<?>... modelsToAdd) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#addModels(). public addModels(Array<EpoxyModel<?>> modelsToAdd)
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                       ^^^^^^^^^^^ definition local1 Array<EpoxyModel<?>> modelsToAdd
    super.addModels(modelsToAdd);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#addModels().
//                  ^^^^^^^^^^^ reference local1
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void addModels(Collection<? extends EpoxyModel<?>> modelsToAdd) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#addModels(+1). public addModels(Collection<? extends EpoxyModel<?>> modelsToAdd)
//                      ^^^^^^^^^^ reference java/util/Collection#
//                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                          ^^^^^^^^^^^ definition local2 Collection<? extends EpoxyModel<?>> modelsToAdd
    super.addModels(modelsToAdd);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#addModels(+1).
//                  ^^^^^^^^^^^ reference local2
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore) {
//            ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelBefore(). public insertModelBefore(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertBefore)
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                            ^^^^^^^^^^^^^ definition local3 EpoxyModel<?> modelToInsert
//                                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                         ^^^^^^^^^^^^^^^^^^^ definition local4 EpoxyModel<?> modelToInsertBefore
    super.insertModelBefore(modelToInsert, modelToInsertBefore);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#insertModelBefore().
//                          ^^^^^^^^^^^^^ reference local3
//                                         ^^^^^^^^^^^^^^^^^^^ reference local4
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void insertModelAfter(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertAfter) {
//            ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#insertModelAfter(). public insertModelAfter(EpoxyModel<?> modelToInsert, EpoxyModel<?> modelToInsertAfter)
//                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                           ^^^^^^^^^^^^^ definition local5 EpoxyModel<?> modelToInsert
//                                                          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                        ^^^^^^^^^^^^^^^^^^ definition local6 EpoxyModel<?> modelToInsertAfter
    super.insertModelAfter(modelToInsert, modelToInsertAfter);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#insertModelAfter().
//                         ^^^^^^^^^^^^^ reference local5
//                                        ^^^^^^^^^^^^^^^^^^ reference local6
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void removeModel(EpoxyModel<?> model) {
//            ^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#removeModel(). public removeModel(EpoxyModel<?> model)
//                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                      ^^^^^ definition local7 EpoxyModel<?> model
    super.removeModel(model);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#removeModel().
//                    ^^^^^ reference local7
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void removeAllModels() {
//            ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#removeAllModels(). public removeAllModels()
    super.removeAllModels();
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#removeAllModels().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void removeAllAfterModel(EpoxyModel<?> model) {
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#removeAllAfterModel(). public removeAllAfterModel(EpoxyModel<?> model)
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^ definition local8 EpoxyModel<?> model
    super.removeAllAfterModel(model);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#removeAllAfterModel().
//                            ^^^^^ reference local8
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void showModel(EpoxyModel<?> model, boolean show) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#showModel(). public showModel(EpoxyModel<?> model, boolean show)
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^ definition local9 EpoxyModel<?> model
//                                                   ^^^^ definition local10 boolean show
    super.showModel(model, show);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModel().
//                  ^^^^^ reference local9
//                         ^^^^ reference local10
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void showModel(EpoxyModel<?> model) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#showModel(+1). public showModel(EpoxyModel<?> model)
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^ definition local11 EpoxyModel<?> model
    super.showModel(model);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModel(+1).
//                  ^^^^^ reference local11
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void showModels(EpoxyModel<?>... models) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(). public showModels(Array<EpoxyModel<?>> models)
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^^ definition local12 Array<EpoxyModel<?>> models
    super.showModels(models);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModels().
//                   ^^^^^^ reference local12
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void showModels(boolean show, EpoxyModel<?>... models) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+1). public showModels(boolean show, Array<EpoxyModel<?>> models)
//                               ^^^^ definition local13 boolean show
//                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                      ^^^^^^ definition local14 Array<EpoxyModel<?>> models
    super.showModels(show, models);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModels(+1).
//                   ^^^^ reference local13
//                         ^^^^^^ reference local14
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void showModels(Iterable<EpoxyModel<?>> epoxyModels) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+2). public showModels(Iterable<EpoxyModel<?>> epoxyModels)
//                       ^^^^^^^^ reference java/lang/Iterable#
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^ definition local15 Iterable<EpoxyModel<?>> epoxyModels
    super.showModels(epoxyModels);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModels(+2).
//                   ^^^^^^^^^^^ reference local15
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void showModels(Iterable<EpoxyModel<?>> epoxyModels, boolean show) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#showModels(+3). public showModels(Iterable<EpoxyModel<?>> epoxyModels, boolean show)
//                       ^^^^^^^^ reference java/lang/Iterable#
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^ definition local16 Iterable<EpoxyModel<?>> epoxyModels
//                                                                    ^^^^ definition local17 boolean show
    super.showModels(epoxyModels, show);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#showModels(+3).
//                   ^^^^^^^^^^^ reference local16
//                                ^^^^ reference local17
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void hideModel(EpoxyModel<?> model) {
//            ^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#hideModel(). public hideModel(EpoxyModel<?> model)
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^ definition local18 EpoxyModel<?> model
    super.hideModel(model);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#hideModel().
//                  ^^^^^ reference local18
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void hideModels(Iterable<EpoxyModel<?>> epoxyModels) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels(). public hideModels(Iterable<EpoxyModel<?>> epoxyModels)
//                       ^^^^^^^^ reference java/lang/Iterable#
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^^^^^^^ definition local19 Iterable<EpoxyModel<?>> epoxyModels
    super.hideModels(epoxyModels);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#hideModels().
//                   ^^^^^^^^^^^ reference local19
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void hideModels(EpoxyModel<?>... models) {
//            ^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#hideModels(+1). public hideModels(Array<EpoxyModel<?>> models)
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                        ^^^^^^ definition local20 Array<EpoxyModel<?>> models
    super.hideModels(models);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#hideModels(+1).
//                   ^^^^^^ reference local20
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void hideAllAfterModel(EpoxyModel<?> model) {
//            ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#hideAllAfterModel(). public hideAllAfterModel(EpoxyModel<?> model)
//                              ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                            ^^^^^ definition local21 EpoxyModel<?> model
    super.hideAllAfterModel(model);
//  ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#hideAllAfterModel().
//                          ^^^^^ reference local21
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public List<EpoxyModel<?>> getAllModelsAfter(EpoxyModel<?> model) {
//       ^^^^ reference java/util/List#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#getAllModelsAfter(). public List<EpoxyModel<?>> getAllModelsAfter(EpoxyModel<?> model)
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                           ^^^^^ definition local22 EpoxyModel<?> model
    return super.getAllModelsAfter(model);
//         ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//               ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyAdapter#getAllModelsAfter().
//                                 ^^^^^ reference local22
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int getModelPosition(EpoxyModel<?> model) {
//           ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/SimpleEpoxyAdapter#getModelPosition(). public int getModelPosition(EpoxyModel<?> model)
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                          ^^^^^ definition local23 EpoxyModel<?> model
    return super.getModelPosition(model);
//         ^^^^^ reference com/airbnb/epoxy/SimpleEpoxyAdapter#super.
//               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/BaseEpoxyAdapter#getModelPosition().
//                                ^^^^^ reference local23
  }
}
