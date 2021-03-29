package com.airbnb.epoxy;

import java.lang.annotation.ElementType;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
import java.lang.annotation.Retention;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^ reference java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
import java.lang.annotation.Target;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^ reference java/lang/annotation/Target#

/**
 * This can be used to annotate methods inside classes with a {@link com.airbnb.epoxy.ModelView}
 * annotation. Methods with this annotation will be called after a view instance  is bound to a
 * model and all model props have been set. This is useful if you need to wait until multiple props
 * are set before doing certain initialization.
 * <p>
 * Methods with this annotation will be called after both the initial bind when the view comes on
 * screen, and after partial binds when an onscreen view is updated.
 */
@Target(ElementType.METHOD)
//^^^^^ reference java/lang/annotation/Target#
//      ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
//                  ^^^^^^ reference java/lang/annotation/ElementType#METHOD.
@Retention(RetentionPolicy.CLASS)
//^^^^^^^^ reference java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                         ^^^^^ reference java/lang/annotation/RetentionPolicy#CLASS.
public @interface AfterPropsSet {
//                ^^^^^^^^^^^^^ definition com/airbnb/epoxy/AfterPropsSet# public abstract AfterPropsSet extends Annotation
}

