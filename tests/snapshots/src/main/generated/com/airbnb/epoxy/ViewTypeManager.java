package com.airbnb.epoxy;

import java.util.HashMap;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#
import java.util.Map;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^ reference semanticdb maven jdk 11 java/util/Map#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.annotation.VisibleForTesting;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#

class ViewTypeManager {
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#
//                    display_name ViewTypeManager
//                    signature_documentation java class ViewTypeManager
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#`<init>`().
//                    display_name <init>
//                    signature_documentation java ViewTypeManager()
  private static final Map<Class, Integer> VIEW_TYPE_MAP = new HashMap<>();
//                     ^^^ reference semanticdb maven jdk 11 java/util/Map#
//                         ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//                                         ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#VIEW_TYPE_MAP.
//                                                       display_name VIEW_TYPE_MAP
//                                                       signature_documentation java private static final Map<Class, Integer> VIEW_TYPE_MAP
//                                                             ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`(+2).
  /**
   * The last model that had its view type looked up. This is stored so in most cases we can quickly
   * look up what view type belongs to which model.
   */
  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  EpoxyModel<?> lastModelForViewTypeLookup;
//^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#lastModelForViewTypeLookup.
//                                         display_name lastModelForViewTypeLookup
//                                         signature_documentation java @Nullable\nEpoxyModel<?> lastModelForViewTypeLookup
//                                         documentation  The last model that had its view type looked up. This is stored so in most cases we can quickly\n look up what view type belongs to which model.\n

  /**
   * The type map is static so that models of the same class share the same views across different
   * adapters. This is useful for view recycling when the adapter instance changes, or when there
   * are multiple adapters. For testing purposes though it is good to be able to clear the map so we
   * don't carry over values across tests.
   */
  @VisibleForTesting
// ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#
  void resetMapForTesting() {
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#resetMapForTesting().
//                        display_name resetMapForTesting
//                        signature_documentation java @VisibleForTesting\nvoid resetMapForTesting()
//                        documentation  The type map is static so that models of the same class share the same views across different\n adapters. This is useful for view recycling when the adapter instance changes, or when there\n are multiple adapters. For testing purposes though it is good to be able to clear the map so we\n don't carry over values across tests.\n
    VIEW_TYPE_MAP.clear();
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#VIEW_TYPE_MAP.
//                ^^^^^ reference semanticdb maven jdk 11 java/util/Map#clear().
  }

  int getViewTypeAndRememberModel(EpoxyModel<?> model) {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#getViewTypeAndRememberModel().
//                                display_name getViewTypeAndRememberModel
//                                signature_documentation java int getViewTypeAndRememberModel(EpoxyModel<?> model)
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^ definition local 0
//                                                    display_name model
//                                                    signature_documentation java EpoxyModel<?> model
    lastModelForViewTypeLookup = model;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#lastModelForViewTypeLookup.
//                               ^^^^^ reference local 0
    return getViewType(model);
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#getViewType().
//                     ^^^^^ reference local 0
  }

  static int getViewType(EpoxyModel<?> model) {
//           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#getViewType().
//                       display_name getViewType
//                       signature_documentation java static int getViewType(EpoxyModel<?> model)
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                     ^^^^^ definition local 1
//                                           display_name model
//                                           signature_documentation java EpoxyModel<?> model
    int defaultViewType = model.getViewType();
//      ^^^^^^^^^^^^^^^ definition local 2
//                      display_name defaultViewType
//                      signature_documentation java int defaultViewType
//                        ^^^^^ reference local 1
//                              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getViewType().
    if (defaultViewType != 0) {
//      ^^^^^^^^^^^^^^^ reference local 2
      return defaultViewType;
//           ^^^^^^^^^^^^^^^ reference local 2
    }

    // If a model does not specify a view type then we generate a value to use for models of that
    // class.
    Class modelClass = model.getClass();
//  ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//        ^^^^^^^^^^ definition local 3
//                   display_name modelClass
//                   signature_documentation java Class modelClass
//                     ^^^^^ reference local 1
//                           ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().

    Integer viewType = VIEW_TYPE_MAP.get(modelClass);
//  ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Integer#
//          ^^^^^^^^ definition local 4
//                   display_name viewType
//                   signature_documentation java Integer viewType
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#VIEW_TYPE_MAP.
//                                   ^^^ reference semanticdb maven jdk 11 java/util/Map#get().
//                                       ^^^^^^^^^^ reference local 3

    if (viewType == null) {
//      ^^^^^^^^ reference local 4
      viewType = -VIEW_TYPE_MAP.size() - 1;
//    ^^^^^^^^ reference local 4
//                ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#VIEW_TYPE_MAP.
//                              ^^^^ reference semanticdb maven jdk 11 java/util/Map#size().
      VIEW_TYPE_MAP.put(modelClass, viewType);
//    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#VIEW_TYPE_MAP.
//                  ^^^ reference semanticdb maven jdk 11 java/util/Map#put().
//                      ^^^^^^^^^^ reference local 3
//                                  ^^^^^^^^ reference local 4
    }

    return viewType;
//         ^^^^^^^^ reference local 4
  }

  /**
   * Find the model that has the given view type so we can create a view for that model. In most
   * cases this value is a layout resource and we could simply inflate it, but to support {@link
   * EpoxyModelWithView} we can't assume the view type is a layout. In that case we need to lookup
   * the model so we can ask it to create a new view for itself.
   * <p>
   * To make this efficient, we rely on the RecyclerView implementation detail that {@link
   * BaseEpoxyAdapter#getItemViewType(int)} is called immediately before {@link
   * BaseEpoxyAdapter#onCreateViewHolder(android.view.ViewGroup, int)} . We cache the last model
   * that had its view type looked up, and unless that implementation changes we expect to have a
   * very fast lookup for the correct model.
   * <p>
   * To be safe, we fallback to searching through all models for a view type match. This is slow and
   * shouldn't be needed, but is a guard against recyclerview behavior changing.
   */
  EpoxyModel<?> getModelForViewType(BaseEpoxyAdapter adapter, int viewType) {
//^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#getModelForViewType().
//                                  display_name getModelForViewType
//                                  signature_documentation java EpoxyModel<?> getModelForViewType(BaseEpoxyAdapter adapter, int viewType)
//                                  documentation  Find the model that has the given view type so we can create a view for that model. In most\n cases this value is a layout resource and we could simply inflate it, but to support {@link\n EpoxyModelWithView} we can't assume the view type is a layout. In that case we need to lookup\n the model so we can ask it to create a new view for itself.\n <p>\n To make this efficient, we rely on the RecyclerView implementation detail that {@link\n BaseEpoxyAdapter#getItemViewType(int)} is called immediately before {@link\n BaseEpoxyAdapter#onCreateViewHolder(android.view.ViewGroup, int)} . We cache the last model\n that had its view type looked up, and unless that implementation changes we expect to have a\n very fast lookup for the correct model.\n <p>\n To be safe, we fallback to searching through all models for a view type match. This is slow and\n shouldn't be needed, but is a guard against recyclerview behavior changing.\n
//                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#
//                                                   ^^^^^^^ definition local 5
//                                                           display_name adapter
//                                                           signature_documentation java BaseEpoxyAdapter adapter
//                                                                ^^^^^^^^ definition local 6
//                                                                         display_name viewType
//                                                                         signature_documentation java int viewType
    if (lastModelForViewTypeLookup != null
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#lastModelForViewTypeLookup.
        && getViewType(lastModelForViewTypeLookup) == viewType) {
//         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#getViewType().
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#lastModelForViewTypeLookup.
//                                                    ^^^^^^^^ reference local 6
      // We expect this to be a hit 100% of the time
      return lastModelForViewTypeLookup;
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#lastModelForViewTypeLookup.
    }

    adapter.onExceptionSwallowed(
//  ^^^^^^^ reference local 5
//          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#onExceptionSwallowed().
        new IllegalStateException("Last model did not match expected view type"));
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).

    // To be extra safe in case RecyclerView implementation details change...
    for (EpoxyModel<?> model : adapter.getCurrentModels()) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local 7
//                           display_name model
//                           signature_documentation java EpoxyModel<?> model
//                             ^^^^^^^ reference local 5
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/BaseEpoxyAdapter#getCurrentModels().
      if (getViewType(model) == viewType) {
//        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewTypeManager#getViewType().
//                    ^^^^^ reference local 7
//                              ^^^^^^^^ reference local 6
        return model;
//             ^^^^^ reference local 7
      }
    }

    // Check for the hidden model.
    HiddenEpoxyModel hiddenEpoxyModel = new HiddenEpoxyModel();
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#
//                   ^^^^^^^^^^^^^^^^ definition local 8
//                                    display_name hiddenEpoxyModel
//                                    signature_documentation java HiddenEpoxyModel hiddenEpoxyModel
//                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HiddenEpoxyModel#`<init>`().
    if (viewType == hiddenEpoxyModel.getViewType()) {
//      ^^^^^^^^ reference local 6
//                  ^^^^^^^^^^^^^^^^ reference local 8
//                                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getViewType().
      return hiddenEpoxyModel;
//           ^^^^^^^^^^^^^^^^ reference local 8
    }

    throw new IllegalStateException("Could not find model for view type: " + viewType);
//            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
//                                                                           ^^^^^^^^ reference local 6
  }
}
