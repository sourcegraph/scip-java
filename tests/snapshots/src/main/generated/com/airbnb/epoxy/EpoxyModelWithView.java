package com.airbnb.epoxy;

import android.view.View;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^ reference semanticdb maven . . android/view/View#
import android.view.ViewGroup;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/view/
//                  ^^^^^^^^^ reference semanticdb maven . . android/view/ViewGroup#

import androidx.annotation.LayoutRes;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#

/**
 * A model that allows its view to be built programmatically instead of by inflating a layout
 * resource. Just implement {@link #buildView} so the adapter can create a new view for this model
 * when needed.
 * <p>
 * {@link #getViewType()} is used by the adapter to know how to reuse views for this model. This
 * means that all models that return the same type should be able to share the same view, and the
 * view won't be shared with models of any other type.
 * <p>
 * If it is left unimplemented then at runtime a unique view type will be created to use for all
 * models of that class. The generated view type will be negative so that it cannot collide with
 * values from resource files, which are used in normal Epoxy models. If you would like to share
 * the same view between models of different classes you can have those classes return the same view
 * type. A good way to manually create a view type value is by creating an R.id. value in an ids
 * resource file.
 */
public abstract class EpoxyModelWithView<T extends View> extends EpoxyModel<T> {
//                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#
//                                       documentation ```java\npublic abstract class EpoxyModelWithView<T extends unresolved_type>\n```
//                                       documentation  A model that allows its view to be built programmatically instead of by inflating a layout\n resource. Just implement {@link #buildView} so the adapter can create a new view for this model\n when needed.\n <p>\n {@link #getViewType()} is used by the adapter to know how to reuse views for this model. This\n means that all models that return the same type should be able to share the same view, and the\n view won't be shared with models of any other type.\n <p>\n If it is left unimplemented then at runtime a unique view type will be created to use for all\n models of that class. The generated view type will be negative so that it cannot collide with\n values from resource files, which are used in normal Epoxy models. If you would like to share\n the same view between models of different classes you can have those classes return the same view\n type. A good way to manually create a view type value is by creating an R.id. value in an ids\n resource file.\n
//                                       relationship is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#`<init>`().
//                                       documentation ```java\npublic EpoxyModelWithView()\n```
//                                       ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#[T]
//                                         documentation ```java\nT extends unresolved_type\n```
//                                                 ^^^^ reference semanticdb maven . . _root_/
//                                                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                          ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#[T]

  /**
   * Get the view type associated with this model's view. Any models with the same view type will
   * have views recycled between them.
   *
   * @see androidx.recyclerview.widget.RecyclerView.Adapter#getItemViewType(int)
   */
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected int getViewType() {
//              ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#getViewType().
//                          documentation ```java\n@Override\nprotected int getViewType()\n```
//                          documentation  Get the view type associated with this model's view. Any models with the same view type will\n have views recycled between them.\n\n @see androidx.recyclerview.widget.RecyclerView.Adapter#getItemViewType(int)\n
//                          relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getViewType().
    return 0;
  }

  /**
   * Create and return a new instance of a view for this model. If no layout params are set on the
   * returned view then default layout params will be used.
   *
   * @param parent The parent ViewGroup that the returned view will be added to.
   */
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected abstract T buildView(@NonNull ViewGroup parent);
//                   ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#[T]
//                     ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#buildView().
//                               documentation ```java\n@Override\nprotected abstract T buildView(unresolved_type parent)\n```
//                               documentation  Create and return a new instance of a view for this model. If no layout params are set on the\n returned view then default layout params will be used.\n\n @param parent The parent ViewGroup that the returned view will be added to.\n
//                               relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#buildView().
//                                ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                        ^^^^^^^^^ reference semanticdb maven . . _root_/
//                                                  ^^^^^^ definition local 0
//                                                         documentation ```java\n@NonNull\nunresolved_type parent\n```

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected final int getDefaultLayout() {
//                    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#getDefaultLayout().
//                                     documentation ```java\n@Override\nprotected final int getDefaultLayout()\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#getDefaultLayout().
    throw new UnsupportedOperationException(
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`(+1).
        "Layout resources are unsupported. Views must be created with `buildView`");
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public EpoxyModel<T> layout(@LayoutRes int layoutRes) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#[T]
//                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyModelWithView#layout().
//                            documentation ```java\n@Override\npublic EpoxyModel<T> layout(int layoutRes)\n```
//                            relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/EpoxyModel#layout().
//                             ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#
//                                           ^^^^^^^^^ definition local 1
//                                                     documentation ```java\n@LayoutRes\nint layoutRes\n```
    throw new UnsupportedOperationException(
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/UnsupportedOperationException#`<init>`(+1).
        "Layout resources are unsupported. Views must be created with `buildView`");
  }
}
