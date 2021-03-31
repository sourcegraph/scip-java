
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
 * Used to annotate fields on EpoxyModel classes in order to generate a subclass of that model with
 * getters, setters, equals, and hashcode for the annotated fields.
 */
@Target(ElementType.FIELD)
//^^^^^ reference java/lang/annotation/Target#
//      ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
//                  ^^^^^ reference java/lang/annotation/ElementType#FIELD.
@Retention(RetentionPolicy.CLASS)
//^^^^^^^^ reference java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                         ^^^^^ reference java/lang/annotation/RetentionPolicy#CLASS.
public @interface EpoxyAttribute {
//                ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAttribute# public @interface EpoxyAttribute
  /**
   * Options that can be included on the attribute to affect how the model's generated class is
   * created.
   */
  enum Option {
//     ^^^^^^ definition com/airbnb/epoxy/EpoxyAttribute#Option# public enum Option
//     ^^^^^^ definition com/airbnb/epoxy/EpoxyAttribute#Option#`<init>`(). private <init>()
    /**
     * A getter is generated for this attribute by default. Add this option to prevent a getter from
     * being generated.
     */
    NoGetter,
//  ^^^^^^^^ definition com/airbnb/epoxy/EpoxyAttribute#Option#NoGetter. Option.NoGetter /* ordinal 0 */
    /**
     * A setter is generated for this attribute by default. Add this option to prevent a setter from
     * being generated.
     */
    NoSetter,
//  ^^^^^^^^ definition com/airbnb/epoxy/EpoxyAttribute#Option#NoSetter. Option.NoSetter /* ordinal 1 */
    /**
     * By default every attribute's hashCode and equals method is called when determining the
     * model's state. This option can be used to exclude an attribute's hashCode/equals from
     * contributing to the state.
     * <p>
     * This is useful for objects that may change without actually changing the model's state. A
     * common case is an anonymous click listener that gets recreated with every bind call.
     * <p>
     * When this is used, the attribute will affect the model state solely based on whether it is
     * null or non null.
     * <p>
     * A good rule of thumb for whether to use this on an attribute is, "If this is the only
     * attribute that changed do I still need to rebind and update the view?" If the answer if no
     * then you can use this to prevent the rebind.
     */
    DoNotHash,
//  ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAttribute#Option#DoNotHash. Option.DoNotHash /* ordinal 2 */
    /**
     * This is meant to be used in conjunction with {@link PackageEpoxyConfig#requireHashCode()}.
     * When that is enabled every attribute must implement hashCode/equals. However, there are some
     * valid cases where the attribute type does not implement hashCode/equals, but it should still
     * be hashed at runtime and contribute to the model's state. Use this option on an attribute in
     * that case to tell the processor to let it pass the hashCode/equals validation.
     * <p>
     * An example case is AutoValue classes, where the generated class correctly implements
     * hashCode/equals at runtime.
     * <p>
     * If you use this it is your responsibility to ensure that the object assigned to the attribute
     * at runtime correctly implements hashCode/equals. If you don't want the attribute to
     * contribute to model state you should use {@link Option#DoNotHash} instead.
     */
    IgnoreRequireHashCode,
//  ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAttribute#Option#IgnoreRequireHashCode. Option.IgnoreRequireHashCode /* ordinal 3 */
    /**
     * This attribute is used in {@link Object#toString()} implementation by default.
     * Add this option to prevent this attribute being used in {@link Object#toString()}.
     */
    DoNotUseInToString
//  ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyAttribute#Option#DoNotUseInToString. Option.DoNotUseInToString /* ordinal 4 */
  }

  /** Specify any {@link Option} values that should be used when generating the model class. */
  Option[] value() default {};
//^^^^^^ reference com/airbnb/epoxy/EpoxyAttribute#Option#
//         ^^^^^ definition com/airbnb/epoxy/EpoxyAttribute#value(). public abstract Option[] value()

  /**
   * Whether or not to include this attribute in equals and hashCode calculations.
   * <p>
   * It may be useful to disable this for objects that get recreated without the underlying data
   * changing such as a click listener that gets created inline in every bind call.
   *
   * @deprecated Use {@link Option#DoNotHash} instead.
   */
  @Deprecated
// ^^^^^^^^^^ reference java/lang/Deprecated#
  boolean hash() default true;
//        ^^^^ definition com/airbnb/epoxy/EpoxyAttribute#hash(). public abstract boolean hash()

  /**
   * Whether or not to generate setter for this attribute.
   * <p>
   * It may be useful to disable this for attribute which can be immutable and doesn't require
   * setter.
   *
   * @deprecated Use {@link Option#NoSetter} instead.
   */
  @Deprecated
// ^^^^^^^^^^ reference java/lang/Deprecated#
  boolean setter() default true;
//        ^^^^^^ definition com/airbnb/epoxy/EpoxyAttribute#setter(). public abstract boolean setter()
}
