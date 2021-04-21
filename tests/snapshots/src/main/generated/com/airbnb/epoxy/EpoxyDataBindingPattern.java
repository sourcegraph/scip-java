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
 * Used to specify a naming pattern for the databinding layouts that you want models generated for.
 * Use this instead of {@link EpoxyDataBindingLayouts} to avoid having to explicitly list every
 * databinding layout.
 * <p>
 * The layouts must not specify a custom databinding class name or package via the
 * class="com.example.CustomClassName" override in the layout xml.
 */
@Target(ElementType.TYPE)
//^^^^^ reference java/lang/annotation/Target#
//      ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
//                  ^^^^ reference java/lang/annotation/ElementType#TYPE.
@Retention(RetentionPolicy.CLASS)
//^^^^^^^^ reference java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                         ^^^^^ reference java/lang/annotation/RetentionPolicy#CLASS.
public @interface EpoxyDataBindingPattern {
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyDataBindingPattern# @Target(ElementType.TYPE) @Retention(RetentionPolicy.CLASS) public @interface EpoxyDataBindingPattern
  /**
   * The R class used in this module (eg "com.example.app.R.class"). This is needed so Epoxy can
   * look up layout files.
   */
  Class<?> rClass();
//^^^^^ reference java/lang/Class#
//         ^^^^^^ definition com/airbnb/epoxy/EpoxyDataBindingPattern#rClass(). public Class<?> rClass()
  /**
   * A string prefix that your databinding layouts start with. Epoxy will generate a model for each
   * databinding layout whose name starts with this.
   * <p>
   * For example, if you set this prefix to "view_holder" and you have a "view_holder_header.xml"
   * databinding layout, Epoxy will generate a HeaderBindingModel_ class for that layout.
   */
  String layoutPrefix();
//^^^^^^ reference java/lang/String#
//       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyDataBindingPattern#layoutPrefix(). public String layoutPrefix()

  /**
   * If true, any variable whose type does not implement equals and hashcode will have the
   * {@link EpoxyAttribute.Option#DoNotHash} behavior applied to them automatically.
   * <p>
   * This is generally helpful for listeners - other variables should almost always implement
   * equals and hashcode.
   * <p>
   * For details on the nuances of this, see https://github.com/airbnb/epoxy/wiki/DoNotHash
   */
  boolean enableDoNotHash() default true;
//        ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyDataBindingPattern#enableDoNotHash(). public boolean enableDoNotHash()
}
