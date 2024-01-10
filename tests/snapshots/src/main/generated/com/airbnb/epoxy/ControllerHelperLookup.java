package com.airbnb.epoxy;

import java.lang.reflect.Constructor;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^ reference semanticdb maven . . java/lang/reflect/
//                       ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
import java.lang.reflect.InvocationTargetException;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^ reference semanticdb maven . . java/lang/reflect/
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationTargetException#
import java.util.LinkedHashMap;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashMap#
import java.util.Map;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^ reference semanticdb maven jdk 11 java/util/Map#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#

/**
 * Looks up a generated {@link ControllerHelper} implementation for a given adapter.
 * If the adapter has no {@link com.airbnb.epoxy.AutoModel} models then a No-Op implementation will
 * be returned.
 */
class ControllerHelperLookup {
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#
//                           display_name ControllerHelperLookup
//                           signature_documentation java class ControllerHelperLookup
//                           kind Class
//                           documentation  Looks up a generated {@link ControllerHelper} implementation for a given adapter.\n If the adapter has no {@link com.airbnb.epoxy.AutoModel} models then a No-Op implementation will\n be returned.\n
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#`<init>`().
//                           display_name <init>
//                           signature_documentation java ControllerHelperLookup()
//                           kind Constructor
  private static final String GENERATED_HELPER_CLASS_SUFFIX = "_EpoxyHelper";
//                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#GENERATED_HELPER_CLASS_SUFFIX.
//                                                          display_name GENERATED_HELPER_CLASS_SUFFIX
//                                                          signature_documentation java private static final String GENERATED_HELPER_CLASS_SUFFIX
//                                                          kind StaticField
  private static final Map<Class<?>, Constructor<?>> BINDINGS = new LinkedHashMap<>();
//                     ^^^ reference semanticdb maven jdk 11 java/util/Map#
//                         ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                   ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                                                   ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#BINDINGS.
//                                                            display_name BINDINGS
//                                                            signature_documentation java private static final Map<Class<?>, Constructor<?>> BINDINGS
//                                                            kind StaticField
//                                                                  ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashMap#`<init>`(+2).
  private static final NoOpControllerHelper NO_OP_CONTROLLER_HELPER = new NoOpControllerHelper();
//                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NoOpControllerHelper#
//                                          ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#NO_OP_CONTROLLER_HELPER.
//                                                                  display_name NO_OP_CONTROLLER_HELPER
//                                                                  signature_documentation java private static final NoOpControllerHelper NO_OP_CONTROLLER_HELPER
//                                                                  kind StaticField
//                                                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NoOpControllerHelper#`<init>`().

  static ControllerHelper getHelperForController(EpoxyController controller) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#
//                        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
//                                               display_name getHelperForController
//                                               signature_documentation java static ControllerHelper getHelperForController(EpoxyController controller)
//                                               kind StaticMethod
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                               ^^^^^^^^^^ definition local 0
//                                                                          display_name controller
//                                                                          signature_documentation java EpoxyController controller
//                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
    Constructor<?> constructor = findConstructorForClass(controller.getClass());
//  ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                 ^^^^^^^^^^^ definition local 1
//                             display_name constructor
//                             signature_documentation java Constructor<?> constructor
//                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
//                             kind Variable
//                               ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                                                       ^^^^^^^^^^ reference local 0
//                                                                  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#getClass().
    if (constructor == null) {
//      ^^^^^^^^^^^ reference local 1
      return NO_OP_CONTROLLER_HELPER;
//           ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#NO_OP_CONTROLLER_HELPER.
    }

    try {
      return (ControllerHelper) constructor.newInstance(controller);
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#
//                              ^^^^^^^^^^^ reference local 1
//                                          ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#newInstance().
//                                                      ^^^^^^^^^^ reference local 0
    } catch (IllegalAccessException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalAccessException#
//                                  ^ definition local 2
//                                    display_name e
//                                    signature_documentation java IllegalAccessException e
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
      throw new RuntimeException("Unable to invoke " + constructor, e);
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`(+2).
//                                                     ^^^^^^^^^^^ reference local 1
//                                                                  ^ reference local 2
    } catch (InstantiationException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/InstantiationException#
//                                  ^ definition local 3
//                                    display_name e
//                                    signature_documentation java InstantiationException e
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
      throw new RuntimeException("Unable to invoke " + constructor, e);
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`(+2).
//                                                     ^^^^^^^^^^^ reference local 1
//                                                                  ^ reference local 3
    } catch (InvocationTargetException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationTargetException#
//                                     ^ definition local 4
//                                       display_name e
//                                       signature_documentation java InvocationTargetException e
//                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
      Throwable cause = e.getCause();
//    ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Throwable#
//              ^^^^^ definition local 5
//                    display_name cause
//                    signature_documentation java Throwable cause
//                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
//                    kind Variable
//                      ^ reference local 4
//                        ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationTargetException#getCause().
      if (cause instanceof RuntimeException) {
//        ^^^^^ reference local 5
//                         ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
        throw (RuntimeException) cause;
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#
//                               ^^^^^ reference local 5
      }
      if (cause instanceof Error) {
//        ^^^^^ reference local 5
//                         ^^^^^ reference semanticdb maven jdk 11 java/lang/Error#
        throw (Error) cause;
//             ^^^^^ reference semanticdb maven jdk 11 java/lang/Error#
//                    ^^^^^ reference local 5
      }
      throw new RuntimeException("Unable to get Epoxy helper class.", cause);
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`(+2).
//                                                                    ^^^^^ reference local 5
    }
  }

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  private static Constructor<?> findConstructorForClass(Class<?> controllerClass) {
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                                                      display_name findConstructorForClass
//                                                      signature_documentation java @Nullable\nprivate static Constructor<?> findConstructorForClass(Class<?> controllerClass)
//                                                      kind StaticMethod
//                                                      ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                               ^^^^^^^^^^^^^^^ definition local 6
//                                                                               display_name controllerClass
//                                                                               signature_documentation java Class<?> controllerClass
//                                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
    Constructor<?> helperCtor = BINDINGS.get(controllerClass);
//  ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                 ^^^^^^^^^^ definition local 7
//                            display_name helperCtor
//                            signature_documentation java Constructor<?> helperCtor
//                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                            kind Variable
//                              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#BINDINGS.
//                                       ^^^ reference semanticdb maven jdk 11 java/util/Map#get().
//                                           ^^^^^^^^^^^^^^^ reference local 6
    if (helperCtor != null || BINDINGS.containsKey(controllerClass)) {
//      ^^^^^^^^^^ reference local 7
//                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#BINDINGS.
//                                     ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Map#containsKey().
//                                                 ^^^^^^^^^^^^^^^ reference local 6
      return helperCtor;
//           ^^^^^^^^^^ reference local 7
    }

    String clsName = controllerClass.getName();
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//         ^^^^^^^ definition local 8
//                 display_name clsName
//                 signature_documentation java String clsName
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                 kind Variable
//                   ^^^^^^^^^^^^^^^ reference local 6
//                                   ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getName().
    if (clsName.startsWith("android.") || clsName.startsWith("java.")) {
//      ^^^^^^^ reference local 8
//              ^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#startsWith(+1).
//                                        ^^^^^^^ reference local 8
//                                                ^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/String#startsWith(+1).
      return null;
    }

    try {
      Class<?> bindingClass = Class.forName(clsName + GENERATED_HELPER_CLASS_SUFFIX);
//    ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//             ^^^^^^^^^^^^ definition local 9
//                          display_name bindingClass
//                          signature_documentation java Class<?> bindingClass
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                          kind Variable
//                            ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                  ^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#forName().
//                                          ^^^^^^^ reference local 8
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#GENERATED_HELPER_CLASS_SUFFIX.
      //noinspection unchecked
      helperCtor = bindingClass.getConstructor(controllerClass);
//    ^^^^^^^^^^ reference local 7
//                 ^^^^^^^^^^^^ reference local 9
//                              ^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getConstructor().
//                                             ^^^^^^^^^^^^^^^ reference local 6
    } catch (ClassNotFoundException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/ClassNotFoundException#
//                                  ^ definition local 10
//                                    display_name e
//                                    signature_documentation java ClassNotFoundException e
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
      helperCtor = findConstructorForClass(controllerClass.getSuperclass());
//    ^^^^^^^^^^ reference local 7
//                 ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                                         ^^^^^^^^^^^^^^^ reference local 6
//                                                         ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getSuperclass().
    } catch (NoSuchMethodException e) {
//           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/NoSuchMethodException#
//                                 ^ definition local 11
//                                   display_name e
//                                   signature_documentation java NoSuchMethodException e
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
      throw new RuntimeException("Unable to find Epoxy Helper constructor for " + clsName, e);
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`(+2).
//                                                                                ^^^^^^^ reference local 8
//                                                                                         ^ reference local 11
    }
    BINDINGS.put(controllerClass, helperCtor);
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#BINDINGS.
//           ^^^ reference semanticdb maven jdk 11 java/util/Map#put().
//               ^^^^^^^^^^^^^^^ reference local 6
//                                ^^^^^^^^^^ reference local 7
    return helperCtor;
//         ^^^^^^^^^^ reference local 7
  }
}
