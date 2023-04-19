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
//                           documentation ```java\nclass ControllerHelperLookup\n```
//                           documentation  Looks up a generated {@link ControllerHelper} implementation for a given adapter.\n If the adapter has no {@link com.airbnb.epoxy.AutoModel} models then a No-Op implementation will\n be returned.\n
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#`<init>`().
//                           documentation ```java\nControllerHelperLookup()\n```
  private static final String GENERATED_HELPER_CLASS_SUFFIX = "_EpoxyHelper";
//                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#GENERATED_HELPER_CLASS_SUFFIX.
//                                                          documentation ```java\nprivate static final String GENERATED_HELPER_CLASS_SUFFIX\n```
  private static final Map<Class<?>, Constructor<?>> BINDINGS = new LinkedHashMap<>();
//                     ^^^ reference semanticdb maven jdk 11 java/util/Map#
//                         ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                   ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                                                   ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#BINDINGS.
//                                                            documentation ```java\nprivate static final Map<Class<?>, Constructor<?>> BINDINGS\n```
//                                                                  ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashMap#`<init>`(+2).
  private static final NoOpControllerHelper NO_OP_CONTROLLER_HELPER = new NoOpControllerHelper();
//                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NoOpControllerHelper#
//                                          ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#NO_OP_CONTROLLER_HELPER.
//                                                                  documentation ```java\nprivate static final NoOpControllerHelper NO_OP_CONTROLLER_HELPER\n```
//                                                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NoOpControllerHelper#`<init>`().

  static ControllerHelper getHelperForController(EpoxyController controller) {
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelper#
//                        ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
//                                               documentation ```java\nstatic ControllerHelper getHelperForController(EpoxyController controller)\n```
//                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyController#
//                                                               ^^^^^^^^^^ definition local 0
//                                                                          documentation ```java\nEpoxyController controller\n```
    Constructor<?> constructor = findConstructorForClass(controller.getClass());
//  ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                 ^^^^^^^^^^^ definition local 1
//                             documentation ```java\nConstructor<?> constructor\n```
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
//                                    documentation ```java\nIllegalAccessException e\n```
      throw new RuntimeException("Unable to invoke " + constructor, e);
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`(+2).
//                                                     ^^^^^^^^^^^ reference local 1
//                                                                  ^ reference local 2
    } catch (InstantiationException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/InstantiationException#
//                                  ^ definition local 3
//                                    documentation ```java\nInstantiationException e\n```
      throw new RuntimeException("Unable to invoke " + constructor, e);
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/RuntimeException#`<init>`(+2).
//                                                     ^^^^^^^^^^^ reference local 1
//                                                                  ^ reference local 3
    } catch (InvocationTargetException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationTargetException#
//                                     ^ definition local 4
//                                       documentation ```java\nInvocationTargetException e\n```
      Throwable cause = e.getCause();
//    ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Throwable#
//              ^^^^^ definition local 5
//                    documentation ```java\nThrowable cause\n```
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
//                                                      documentation ```java\n@Nullable\nprivate static Constructor<?> findConstructorForClass(Class<?> controllerClass)\n```
//                                                      ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                               ^^^^^^^^^^^^^^^ definition local 6
//                                                                               documentation ```java\nClass<?> controllerClass\n```
    Constructor<?> helperCtor = BINDINGS.get(controllerClass);
//  ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                 ^^^^^^^^^^ definition local 7
//                            documentation ```java\nConstructor<?> helperCtor\n```
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
//                 documentation ```java\nString clsName\n```
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
//                          documentation ```java\nClass<?> bindingClass\n```
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
//                                    documentation ```java\nClassNotFoundException e\n```
      helperCtor = findConstructorForClass(controllerClass.getSuperclass());
//    ^^^^^^^^^^ reference local 7
//                 ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                                         ^^^^^^^^^^^^^^^ reference local 6
//                                                         ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Class#getSuperclass().
    } catch (NoSuchMethodException e) {
//           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/NoSuchMethodException#
//                                 ^ definition local 11
//                                   documentation ```java\nNoSuchMethodException e\n```
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
