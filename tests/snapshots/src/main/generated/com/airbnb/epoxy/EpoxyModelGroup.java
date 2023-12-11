package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#
import android.view.ViewParent;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^^ reference semanticdb maven . . android/view/ViewParent#
import android.view.ViewStub;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^ reference semanticdb maven . . android/view/ViewStub#

import java.util.ArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
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

import androidx.annotation.CallSuper;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
import androidx.annotation.LayoutRes;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#

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
//^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
public class EpoxyModelGroup extends EpoxyModelWithHolder<ModelGroupHolder> {
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#
//                           display_name EpoxyModelGroup
//                           documentation ```java\n@SuppressWarnings("rawtypes")\npublic class EpoxyModelGroup\n```
//                           documentation  An {@link EpoxyModel} that contains other models, and allows you to combine those models in\n whatever view configuration you want.\n <p>\n The constructors take a list of models and a layout resource. The layout must have a viewgroup as\n its top level view; it determines how the view of each model is laid out. There are two ways to\n specify this\n <p>\n 1. Leave the viewgroup empty. The view for each model will be inflated and added in order. This\n works fine if you don't need to include any other views, your model views don't need their layout\n params changed, and your views don't need ids (eg for saving state).\n <p>\n Alternatively you can have nested view groups, with the innermost viewgroup given the id\n "epoxy_model_group_child_container" to mark it as the viewgroup that should have the model views\n added to it. The viewgroup marked with this id should be empty. This allows you to nest\n viewgroups, such as a LinearLayout inside of a CardView.\n <p>\n 2. Include a {@link ViewStub} for each of the models in the list. There should be at least as\n many view stubs as models. Extra stubs will be ignored. Each model will have its view replace the\n stub in order of the view stub's position in the view group. That is, the view group's children\n will be iterated through in order. The first view stub found will be used for the first model in\n the models list, the second view stub will be used for the second model, and so on. A depth first\n recursive search through nested viewgroups is done to find these viewstubs.\n <p>\n The layout can be of any ViewGroup subclass, and can have arbitrary other child views besides the\n view stubs. It can arrange the views and view stubs however is needed.\n <p>\n Any layout param options set on the view stubs will be transferred to the corresponding model\n view by default. If you want a model to keep the layout params from it's own layout resource you\n can override {@link #useViewStubLayoutParams(EpoxyModel, int)}\n <p>\n If you want to override the id used for a model's view you can set {@link\n ViewStub#setInflatedId(int)} via xml. That id will be transferred over to the view taking that\n stub's place. This is necessary if you want your model to save view state, since without this the\n model's view won't have an id to associate the saved state with.\n <p>\n By default this model inherits the same id as the first model in the list. Call {@link #id(long)}\n to override that if needed.\n <p>\n When a model group is recycled, its child views are automatically recycled to a pool that is\n shared with all other model groups in the activity. This enables model groups to more efficiently\n manage their children. The shared pool is cleaned up when the activity is destroyed.\n
//                           relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#
//                                   ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#
//                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#

  protected final List<EpoxyModel<?>> models;
//                ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                    ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//                                           display_name models
//                                           documentation ```java\nprotected final List<EpoxyModel<?>> models\n```

  private boolean shouldSaveViewStateDefault = false;
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
//                                           display_name shouldSaveViewStateDefault
//                                           documentation ```java\nprivate boolean shouldSaveViewStateDefault\n```

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  private Boolean shouldSaveViewState = null;
//        ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Boolean#
//                ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState.
//                                    display_name shouldSaveViewState
//                                    documentation ```java\n@Nullable\nprivate Boolean shouldSaveViewState\n```

  /**
   * @param layoutRes The layout to use with these models.
   * @param models    The models that will be used to bind the views in the given layout.
   */
  public EpoxyModelGroup(@LayoutRes int layoutRes, Collection<? extends EpoxyModel<?>> models) {
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#`<init>`().
//                       display_name <init>
//                       documentation ```java\npublic EpoxyModelGroup(int layoutRes, Collection<? extends EpoxyModel<?>> models)\n```
//                       documentation  @param layoutRes The layout to use with these models.\n @param models    The models that will be used to bind the views in the given layout.\n
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
//                                      ^^^^^^^^^ definition local 0
//                                                display_name layoutRes
//                                                documentation ```java\n@LayoutRes\nint layoutRes\n```
//                                                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                                     ^^^^^^ definition local 1
//                                                                                            display_name models
//                                                                                            documentation ```java\nCollection<? extends EpoxyModel<?>> models\n```
    this(layoutRes, new ArrayList<>(models));
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+2).
//       ^^^^^^^^^ reference local 0
//                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+2).
//                                  ^^^^^^ reference local 1
  }

  /**
   * @param layoutRes The layout to use with these models.
   * @param models    The models that will be used to bind the views in the given layout.
   */
  public EpoxyModelGroup(@LayoutRes int layoutRes, EpoxyModel<?>... models) {
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+1).
//                       display_name <init>
//                       documentation ```java\npublic EpoxyModelGroup(int layoutRes, EpoxyModel<?>[] models)\n```
//                       documentation  @param layoutRes The layout to use with these models.\n @param models    The models that will be used to bind the views in the given layout.\n
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
//                                      ^^^^^^^^^ definition local 2
//                                                display_name layoutRes
//                                                documentation ```java\n@LayoutRes\nint layoutRes\n```
//                                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                  ^^^^^^ definition local 3
//                                                                         display_name models
//                                                                         documentation ```java\nEpoxyModel<?>[] models\n```
    this(layoutRes, new ArrayList<>(Arrays.asList(models)));
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+2).
//       ^^^^^^^^^ reference local 2
//                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+2).
//                                  ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                                         ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#asList().
//                                                ^^^^^^ reference local 3
  }

  /**
   * @param layoutRes The layout to use with these models.
   * @param models    The models that will be used to bind the views in the given layout.
   */
  private EpoxyModelGroup(@LayoutRes int layoutRes, List<EpoxyModel<?>> models) {
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+2).
//                        display_name <init>
//                        documentation ```java\nprivate EpoxyModelGroup(int layoutRes, List<EpoxyModel<?>> models)\n```
//                        documentation  @param layoutRes The layout to use with these models.\n @param models    The models that will be used to bind the views in the given layout.\n
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
//                                       ^^^^^^^^^ definition local 4
//                                                 display_name layoutRes
//                                                 documentation ```java\n@LayoutRes\nint layoutRes\n```
//                                                  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                      ^^^^^^ definition local 5
//                                                                             display_name models
//                                                                             documentation ```java\nList<EpoxyModel<?>> models\n```
    if (models.isEmpty()) {
//      ^^^^^^ reference local 5
//             ^^^^^^^ reference semanticdb maven jdk 11 java/util/List#isEmpty().
      throw new IllegalArgumentException("Models cannot be empty");
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`(+1).
    }

    this.models = models;
//       ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//                ^^^^^^ reference local 5
    layout(layoutRes);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#layout().
//         ^^^^^^^^^ reference local 4
    id(models.get(0).id());
//  ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id(+1).
//     ^^^^^^ reference local 5
//            ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                   ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().

    boolean saveState = false;
//          ^^^^^^^^^ definition local 6
//                    display_name saveState
//                    documentation ```java\nboolean saveState\n```
    for (EpoxyModel<?> model : models) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^ definition local 7
//                           display_name model
//                           documentation ```java\nEpoxyModel<?> model\n```
//                             ^^^^^^ reference local 5
      if (model.shouldSaveViewState()) {
//        ^^^^^ reference local 7
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
        saveState = true;
//      ^^^^^^^^^ reference local 6
        break;
      }
    }
    // By default we save view state if any of the models need to save state.
    shouldSaveViewStateDefault = saveState;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
//                               ^^^^^^^^^ reference local 6
  }

  /**
   * Constructor use for DSL
   */
  protected EpoxyModelGroup() {
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+3).
//                          display_name <init>
//                          documentation ```java\nprotected EpoxyModelGroup()\n```
//                          documentation  Constructor use for DSL\n
    models = new ArrayList<>();
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).
    shouldSaveViewStateDefault = false;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
  }

  /**
   * Constructor use for DSL
   */
  protected EpoxyModelGroup(@LayoutRes int layoutRes) {
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+4).
//                          display_name <init>
//                          documentation ```java\nprotected EpoxyModelGroup(int layoutRes)\n```
//                          documentation  Constructor use for DSL\n
//                           ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
//                                         ^^^^^^^^^ definition local 8
//                                                   display_name layoutRes
//                                                   documentation ```java\n@LayoutRes\nint layoutRes\n```
    this();
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#`<init>`(+3).
    layout(layoutRes);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#layout().
//         ^^^^^^^^^ reference local 8
  }

  protected void addModel(@NonNull EpoxyModel<?> model) {
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#addModel().
//                        display_name addModel
//                        documentation ```java\nprotected void addModel(EpoxyModel<?> model)\n```
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                               ^^^^^ definition local 9
//                                                     display_name model
//                                                     documentation ```java\n@NonNull\nEpoxyModel<?> model\n```
    // By default we save view state if any of the models need to save state.
    shouldSaveViewStateDefault |= model.shouldSaveViewState();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
//                                ^^^^^ reference local 9
//                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
    models.add(model);
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//         ^^^ reference semanticdb maven jdk 11 java/util/List#add().
//             ^^^^^ reference local 9
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void bind(@NonNull ModelGroupHolder holder) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind().
//                 display_name bind
//                 documentation ```java\n@CallSuper\n@Override\npublic void bind(unresolved_type holder)\n```
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind().
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind().
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#
//                                           ^^^^^^ definition local 10
//                                                  display_name holder
//                                                  documentation ```java\n@NonNull\nunresolved_type holder\n```
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local 10
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local 12
//                        display_name onModel
//                        documentation ```java\n@Override\npublic void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local 13
//                                         display_name model
//                                         documentation ```java\nEpoxyModel model\n```
//                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local 14
//                                                                     display_name viewHolder
//                                                                     documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                                          ^^^^^^^^^^ definition local 15
//                                                                                     display_name modelIndex
//                                                                                     documentation ```java\nint modelIndex\n```
        setViewVisibility(model, viewHolder);
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                        ^^^^^ reference local 13
//                               ^^^^^^^^^^ reference local 14
        viewHolder.bind(model, null, Collections.emptyList(), modelIndex);
//      ^^^^^^^^^^ reference local 14
//                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#bind().
//                      ^^^^^ reference local 13
//                                   ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#emptyList().
//                                                            ^^^^^^^^^^ reference local 15
      }
    });
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void bind(@NonNull ModelGroupHolder holder, @NonNull final List<Object> payloads) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind(+1).
//                 display_name bind
//                 documentation ```java\n@CallSuper\n@Override\npublic void bind(unresolved_type holder, List<Object> payloads)\n```
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+1).
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+1).
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#
//                                           ^^^^^^ definition local 16
//                                                  display_name holder
//                                                  documentation ```java\n@NonNull\nunresolved_type holder\n```
//                                                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                                  ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                                                                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                               ^^^^^^^^ definition local 17
//                                                                                        display_name payloads
//                                                                                        documentation ```java\n@NonNull\nfinal List<Object> payloads\n```
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local 16
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local 19
//                        display_name onModel
//                        documentation ```java\n@Override\npublic void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local 20
//                                         display_name model
//                                         documentation ```java\nEpoxyModel model\n```
//                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local 21
//                                                                     display_name viewHolder
//                                                                     documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                                          ^^^^^^^^^^ definition local 22
//                                                                                     display_name modelIndex
//                                                                                     documentation ```java\nint modelIndex\n```
        setViewVisibility(model, viewHolder);
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                        ^^^^^ reference local 20
//                               ^^^^^^^^^^ reference local 21
        viewHolder.bind(model, null, Collections.emptyList(), modelIndex);
//      ^^^^^^^^^^ reference local 21
//                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#bind().
//                      ^^^^^ reference local 20
//                                   ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#emptyList().
//                                                            ^^^^^^^^^^ reference local 22
      }
    });
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void bind(@NonNull ModelGroupHolder holder, @NonNull EpoxyModel<?> previouslyBoundModel) {
//            ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind(+2).
//                 display_name bind
//                 documentation ```java\n@Override\npublic void bind(unresolved_type holder, EpoxyModel<?> previouslyBoundModel)\n```
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#bind(+2).
//                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#bind(+2).
//                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#
//                                           ^^^^^^ definition local 23
//                                                  display_name holder
//                                                  documentation ```java\n@NonNull\nunresolved_type holder\n```
//                                                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                          ^^^^^^^^^^^^^^^^^^^^ definition local 24
//                                                                                               display_name previouslyBoundModel
//                                                                                               documentation ```java\n@NonNull\nEpoxyModel<?> previouslyBoundModel\n```
    if (!(previouslyBoundModel instanceof EpoxyModelGroup)) {
//        ^^^^^^^^^^^^^^^^^^^^ reference local 24
//                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#
      bind(holder);
//    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#bind().
//         ^^^^^^ reference local 23
      return;
    }

    final EpoxyModelGroup previousGroup = (EpoxyModelGroup) previouslyBoundModel;
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#
//                        ^^^^^^^^^^^^^ definition local 25
//                                      display_name previousGroup
//                                      documentation ```java\nfinal EpoxyModelGroup previousGroup\n```
//                                         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#
//                                                          ^^^^^^^^^^^^^^^^^^^^ reference local 24

    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local 23
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local 27
//                        display_name onModel
//                        documentation ```java\n@Override\npublic void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local 28
//                                         display_name model
//                                         documentation ```java\nEpoxyModel model\n```
//                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local 29
//                                                                     display_name viewHolder
//                                                                     documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                                          ^^^^^^^^^^ definition local 30
//                                                                                     display_name modelIndex
//                                                                                     documentation ```java\nint modelIndex\n```
        setViewVisibility(model, viewHolder);
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                        ^^^^^ reference local 28
//                               ^^^^^^^^^^ reference local 29

        if (modelIndex < previousGroup.models.size()) {
//          ^^^^^^^^^^ reference local 30
//                       ^^^^^^^^^^^^^ reference local 25
//                                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//                                            ^^^^ reference semanticdb maven jdk 11 java/util/List#size().
          EpoxyModel<?> previousModel = previousGroup.models.get(modelIndex);
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^^^^^^^^ definition local 31
//                                    display_name previousModel
//                                    documentation ```java\nEpoxyModel<?> previousModel\n```
//                                      ^^^^^^^^^^^^^ reference local 25
//                                                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//                                                           ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                                               ^^^^^^^^^^ reference local 30
          if (previousModel.id() == model.id()) {
//            ^^^^^^^^^^^^^ reference local 31
//                          ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//                                  ^^^^^ reference local 28
//                                        ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
            viewHolder.bind(model, previousModel, Collections.emptyList(), modelIndex);
//          ^^^^^^^^^^ reference local 29
//                     ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#bind().
//                          ^^^^^ reference local 28
//                                 ^^^^^^^^^^^^^ reference local 31
//                                                ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                                            ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#emptyList().
//                                                                         ^^^^^^^^^^ reference local 30
            return;
          }
        }

        viewHolder.bind(model, null, Collections.emptyList(), modelIndex);
//      ^^^^^^^^^^ reference local 29
//                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#bind().
//                      ^^^^^ reference local 28
//                                   ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#emptyList().
//                                                            ^^^^^^^^^^ reference local 30
      }
    });
  }

  private static void setViewVisibility(EpoxyModel model, EpoxyViewHolder viewHolder) {
//                    ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#setViewVisibility().
//                                      display_name setViewVisibility
//                                      documentation ```java\nprivate static void setViewVisibility(EpoxyModel model, EpoxyViewHolder viewHolder)\n```
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                 ^^^^^ definition local 32
//                                                       display_name model
//                                                       documentation ```java\nEpoxyModel model\n```
//                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                                        ^^^^^^^^^^ definition local 33
//                                                                                   display_name viewHolder
//                                                                                   documentation ```java\nEpoxyViewHolder viewHolder\n```
    if (model.isShown()) {
//      ^^^^^ reference local 32
//            ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#isShown().
      viewHolder.itemView.setVisibility(View.VISIBLE);
//    ^^^^^^^^^^ reference local 33
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#setVisibility#
//                                      ^^^^ reference semanticdb maven . . View#
//                                           ^^^^^^^ reference semanticdb maven . . View#VISIBLE#
    } else {
      viewHolder.itemView.setVisibility(View.GONE);
//    ^^^^^^^^^^ reference local 33
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#itemView#setVisibility#
//                                      ^^^^ reference semanticdb maven . . View#
//                                           ^^^^ reference semanticdb maven . . View#GONE#
    }
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void unbind(@NonNull ModelGroupHolder holder) {
//            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#unbind().
//                   display_name unbind
//                   documentation ```java\n@CallSuper\n@Override\npublic void unbind(unresolved_type holder)\n```
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#unbind().
//                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#unbind().
//                    ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#
//                                             ^^^^^^ definition local 34
//                                                    display_name holder
//                                                    documentation ```java\n@NonNull\nunresolved_type holder\n```
    holder.unbindGroup();
//  ^^^^^^ reference local 34
//         ^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#unbindGroup#
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewAttachedToWindow(ModelGroupHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#onViewAttachedToWindow().
//                                   display_name onViewAttachedToWindow
//                                   documentation ```java\n@CallSuper\n@Override\npublic void onViewAttachedToWindow(unresolved_type holder)\n```
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewAttachedToWindow().
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#
//                                                    ^^^^^^ definition local 35
//                                                           display_name holder
//                                                           documentation ```java\nunresolved_type holder\n```
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local 35
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local 37
//                        display_name onModel
//                        documentation ```java\n@Override\npublic void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local 38
//                                         display_name model
//                                         documentation ```java\nEpoxyModel model\n```
//                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local 39
//                                                                     display_name viewHolder
//                                                                     documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                                          ^^^^^^^^^^ definition local 40
//                                                                                     display_name modelIndex
//                                                                                     documentation ```java\nint modelIndex\n```
        //noinspection unchecked
        model.onViewAttachedToWindow(viewHolder.objectToBind());
//      ^^^^^ reference local 38
//            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewAttachedToWindow().
//                                   ^^^^^^^^^^ reference local 39
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
      }
    });
  }

  @CallSuper
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onViewDetachedFromWindow(ModelGroupHolder holder) {
//            ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#onViewDetachedFromWindow().
//                                     display_name onViewDetachedFromWindow
//                                     documentation ```java\n@CallSuper\n@Override\npublic void onViewDetachedFromWindow(unresolved_type holder)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#onViewDetachedFromWindow().
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#
//                                                      ^^^^^^ definition local 41
//                                                             display_name holder
//                                                             documentation ```java\nunresolved_type holder\n```
    iterateModels(holder, new IterateModelsCallback() {
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                ^^^^^^ reference local 41
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
      @Override
//     ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
      public void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex) {
//                ^^^^^^^ definition local 43
//                        display_name onModel
//                        documentation ```java\n@Override\npublic void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)\n```
//                        relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^ definition local 44
//                                         display_name model
//                                         documentation ```java\nEpoxyModel model\n```
//                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                          ^^^^^^^^^^ definition local 45
//                                                                     display_name viewHolder
//                                                                     documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                                          ^^^^^^^^^^ definition local 46
//                                                                                     display_name modelIndex
//                                                                                     documentation ```java\nint modelIndex\n```
        //noinspection unchecked
        model.onViewDetachedFromWindow(viewHolder.objectToBind());
//      ^^^^^ reference local 44
//            ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onViewDetachedFromWindow().
//                                     ^^^^^^^^^^ reference local 45
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#objectToBind().
      }
    });
  }

  private void iterateModels(ModelGroupHolder holder, IterateModelsCallback callback) {
//             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#iterateModels().
//                           display_name iterateModels
//                           documentation ```java\nprivate void iterateModels(unresolved_type holder, IterateModelsCallback callback)\n```
//                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#
//                                            ^^^^^^ definition local 47
//                                                   display_name holder
//                                                   documentation ```java\nunresolved_type holder\n```
//                                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                                                                          ^^^^^^^^ definition local 48
//                                                                                   display_name callback
//                                                                                   documentation ```java\nIterateModelsCallback callback\n```
    holder.bindGroupIfNeeded(this);
//  ^^^^^^ reference local 47
//         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#bindGroupIfNeeded#
    int modelCount = models.size();
//      ^^^^^^^^^^ definition local 49
//                 display_name modelCount
//                 documentation ```java\nint modelCount\n```
//                   ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//                          ^^^^ reference semanticdb maven jdk 11 java/util/List#size().

    for (int i = 0; i < modelCount; i++) {
//           ^ definition local 50
//             display_name i
//             documentation ```java\nint i\n```
//                  ^ reference local 50
//                      ^^^^^^^^^^ reference local 49
//                                  ^ reference local 50
      callback.onModel(models.get(i), holder.getViewHolders().get(i), i);
//    ^^^^^^^^ reference local 48
//             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//                            ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                                ^ reference local 50
//                                    ^^^^^^ reference local 47
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#getViewHolders#
//                                                            ^^^ reference semanticdb maven . . ModelGroupHolder#getViewHolders#get#
//                                                                ^ reference local 50
//                                                                    ^ reference local 50
    }
  }

  private interface IterateModelsCallback {
//                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#
//                                        display_name IterateModelsCallback
//                                        documentation ```java\nprivate interface IterateModelsCallback\n```
    void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex);
//       ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#IterateModelsCallback#onModel().
//               display_name onModel
//               documentation ```java\npublic abstract void onModel(EpoxyModel model, EpoxyViewHolder viewHolder, int modelIndex)\n```
//               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                          ^^^^^ definition local 51
//                                display_name model
//                                documentation ```java\nEpoxyModel model\n```
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyViewHolder#
//                                                 ^^^^^^^^^^ definition local 52
//                                                            display_name viewHolder
//                                                            documentation ```java\nEpoxyViewHolder viewHolder\n```
//                                                                 ^^^^^^^^^^ definition local 53
//                                                                            display_name modelIndex
//                                                                            documentation ```java\nint modelIndex\n```
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int getSpanSize(int totalSpanCount, int position, int itemCount) {
//           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#getSpanSize().
//                       display_name getSpanSize
//                       documentation ```java\n@Override\npublic int getSpanSize(int totalSpanCount, int position, int itemCount)\n```
//                       relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getSpanSize().
//                           ^^^^^^^^^^^^^^ definition local 54
//                                          display_name totalSpanCount
//                                          documentation ```java\nint totalSpanCount\n```
//                                               ^^^^^^^^ definition local 55
//                                                        display_name position
//                                                        documentation ```java\nint position\n```
//                                                             ^^^^^^^^^ definition local 56
//                                                                       display_name itemCount
//                                                                       documentation ```java\nint itemCount\n```
    // Defaults to using the span size of the first model. Override this if you need to customize it
    return models.get(0).spanSize(totalSpanCount, position, itemCount);
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//                ^^^ reference semanticdb maven jdk 11 java/util/List#get().
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#spanSize().
//                                ^^^^^^^^^^^^^^ reference local 54
//                                                ^^^^^^^^ reference local 55
//                                                          ^^^^^^^^^ reference local 56
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected final int getDefaultLayout() {
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#getDefaultLayout().
//                                     display_name getDefaultLayout
//                                     documentation ```java\n@Override\nprotected final int getDefaultLayout()\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getDefaultLayout().
    throw new UnsupportedOperationException(
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`(+1).
        "You should set a layout with layout(...) instead of using this.");
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  public EpoxyModelGroup shouldSaveViewState(boolean shouldSaveViewState) {
//       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#
//                       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState().
//                                           display_name shouldSaveViewState
//                                           documentation ```java\n@NonNull\npublic EpoxyModelGroup shouldSaveViewState(boolean shouldSaveViewState)\n```
//                                                   ^^^^^^^^^^^^^^^^^^^ definition local 57
//                                                                       display_name shouldSaveViewState
//                                                                       documentation ```java\nboolean shouldSaveViewState\n```
    onMutation();
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#onMutation().
    this.shouldSaveViewState = shouldSaveViewState;
//       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState.
//                             ^^^^^^^^^^^^^^^^^^^ reference local 57
    return this;
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean shouldSaveViewState() {
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState(+1).
//                                   display_name shouldSaveViewState
//                                   documentation ```java\n@Override\npublic boolean shouldSaveViewState()\n```
//                                   relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#shouldSaveViewState().
    // By default state is saved if any of the models have saved state enabled.
    // Override this if you need custom behavior.
    if (shouldSaveViewState != null) {
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState.
      return shouldSaveViewState;
//           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewState.
    } else {
      return shouldSaveViewStateDefault;
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#shouldSaveViewStateDefault.
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
//                  ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#useViewStubLayoutParams().
//                                          display_name useViewStubLayoutParams
//                                          documentation ```java\nprotected boolean useViewStubLayoutParams(EpoxyModel<?> model, int modelPosition)\n```
//                                          documentation  Whether the layout params set on the view stub for the given model should be carried over to\n the model's view. Default is true\n <p>\n Set this to false if you want the layout params on the model's layout resource to be kept.\n\n @param model         The model who's view is being created\n @param modelPosition The position of the model in the models list\n
//                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                        ^^^^^ definition local 58
//                                                              display_name model
//                                                              documentation ```java\nEpoxyModel<?> model\n```
//                                                                   ^^^^^^^^^^^^^ definition local 59
//                                                                                 display_name modelPosition
//                                                                                 documentation ```java\nint modelPosition\n```
    return true;
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected final ModelGroupHolder createNewHolder(@NonNull ViewParent parent) {
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . ModelGroupHolder#
//                                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#createNewHolder().
//                                                 display_name createNewHolder
//                                                 documentation ```java\n@Override\nprotected final unresolved_type createNewHolder(unresolved_type parent)\n```
//                                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithHolder#createNewHolder().
//                                                  ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                                          ^^^^^^^^^^ reference semanticdb maven . . ViewParent#
//                                                                     ^^^^^^ definition local 60
//                                                                            display_name parent
//                                                                            documentation ```java\n@NonNull\nunresolved_type parent\n```
    return new ModelGroupHolder(parent);
//                              ^^^^^^ reference local 60
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#equals().
//                      display_name equals
//                      documentation ```java\n@Override\npublic boolean equals(Object o)\n```
//                      relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#equals().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 61
//                               display_name o
//                               documentation ```java\nObject o\n```
    if (this == o) {
//              ^ reference local 61
      return true;
    }
    if (!(o instanceof EpoxyModelGroup)) {
//        ^ reference local 61
//                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#
      return false;
    }
    if (!super.equals(o)) {
//       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#super.
//             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#equals().
//                    ^ reference local 61
      return false;
    }

    EpoxyModelGroup that = (EpoxyModelGroup) o;
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#
//                  ^^^^ definition local 62
//                       display_name that
//                       documentation ```java\nEpoxyModelGroup that\n```
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#
//                                           ^ reference local 61

    return models.equals(that.models);
//         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//                ^^^^^^ reference semanticdb maven jdk 11 java/util/List#equals().
//                       ^^^^ reference local 62
//                            ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#hashCode().
//                    display_name hashCode
//                    documentation ```java\n@Override\npublic int hashCode()\n```
//                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCode().
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
    int result = super.hashCode();
//      ^^^^^^ definition local 63
//             display_name result
//             documentation ```java\nint result\n```
//               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#super.
//                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#hashCode().
    result = 31 * result + models.hashCode();
//  ^^^^^^ reference local 63
//                ^^^^^^ reference local 63
//                         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelGroup#models.
//                                ^^^^^^^^ reference semanticdb maven jdk 11 java/util/List#hashCode().
    return result;
//         ^^^^^^ reference local 63
  }
}
