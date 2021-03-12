package com.airbnb.epoxy;

import java.lang.reflect.Constructor;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^ reference java/lang/reflect/
//                       ^^^^^^^^^^^ reference java/lang/reflect/Constructor#
import java.lang.reflect.InvocationTargetException;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^ reference java/lang/reflect/
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/reflect/InvocationTargetException#
import java.util.LinkedHashMap;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^^^ reference java/util/LinkedHashMap#
import java.util.Map;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^ reference java/util/Map#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#

/**
 * Looks up a generated {@link ControllerHelper} implementation for a given adapter.
 * If the adapter has no {@link com.airbnb.epoxy.AutoModel} models then a No-Op implementation will
 * be returned.
 */
class ControllerHelperLookup {
//    ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelperLookup#
//    ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelperLookup#`<init>`().
  private static final String GENERATED_HELPER_CLASS_SUFFIX = "_EpoxyHelper";
//                     ^^^^^^ reference java/lang/String#
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelperLookup#GENERATED_HELPER_CLASS_SUFFIX.
  private static final Map<Class<?>, Constructor<?>> BINDINGS = new LinkedHashMap<>();
//                     ^^^ reference java/util/Map#
//                         ^^^^^ reference java/lang/Class#
//                                   ^^^^^^^^^^^ reference java/lang/reflect/Constructor#
//                                                   ^^^^^^^^ definition com/airbnb/epoxy/ControllerHelperLookup#BINDINGS.
//                                                              ^^^^^^^^^^^^^^^^^^^^^ reference java/util/LinkedHashMap#`<init>`(+2).
//                                                                  ^^^^^^^^^^^^^ reference java/util/LinkedHashMap#
  private static final NoOpControllerHelper NO_OP_CONTROLLER_HELPER = new NoOpControllerHelper();
//                     ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/NoOpControllerHelper#
//                                          ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelperLookup#NO_OP_CONTROLLER_HELPER.
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/NoOpControllerHelper#`<init>`().
//                                                                        ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/NoOpControllerHelper#

  static ControllerHelper getHelperForController(EpoxyController controller) {
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelper#
//                        ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelperLookup#getHelperForController().
//                                               ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyController#
//                                                               ^^^^^^^^^^ definition local0
    Constructor<?> constructor = findConstructorForClass(controller.getClass());
//  ^^^^^^^^^^^ reference java/lang/reflect/Constructor#
//                 ^^^^^^^^^^^ definition local1
//                               ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                                                       ^^^^^^^^^^ reference local0
//                                                                  ^^^^^^^^ reference java/lang/Object#getClass().
    if (constructor == null) {
//      ^^^^^^^^^^^ reference local1
      return NO_OP_CONTROLLER_HELPER;
//           ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelperLookup#NO_OP_CONTROLLER_HELPER.
    }

    try {
      return (ControllerHelper) constructor.newInstance(controller);
//            ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelper#
//                              ^^^^^^^^^^^ reference local1
//                                          ^^^^^^^^^^^ reference java/lang/reflect/Constructor#newInstance().
//                                                      ^^^^^^^^^^ reference local0
    } catch (IllegalAccessException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalAccessException#
//                                  ^ definition local2
      throw new RuntimeException("Unable to invoke " + constructor, e);
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#`<init>`(+2).
//              ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                     ^^^^^^^^^^^ reference local1
//                                                                  ^ reference local2
    } catch (InstantiationException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/InstantiationException#
//                                  ^ definition local3
      throw new RuntimeException("Unable to invoke " + constructor, e);
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#`<init>`(+2).
//              ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                     ^^^^^^^^^^^ reference local1
//                                                                  ^ reference local3
    } catch (InvocationTargetException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/reflect/InvocationTargetException#
//                                     ^ definition local4
      Throwable cause = e.getCause();
//    ^^^^^^^^^ reference java/lang/Throwable#
//              ^^^^^ definition local5
//                      ^ reference local4
//                        ^^^^^^^^ reference java/lang/reflect/InvocationTargetException#getCause().
      if (cause instanceof RuntimeException) {
//        ^^^^^ reference local5
//                         ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
        throw (RuntimeException) cause;
//             ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                               ^^^^^ reference local5
      }
      if (cause instanceof Error) {
//        ^^^^^ reference local5
//                         ^^^^^ reference java/lang/Error#
        throw (Error) cause;
//             ^^^^^ reference java/lang/Error#
//                    ^^^^^ reference local5
      }
      throw new RuntimeException("Unable to get Epoxy helper class.", cause);
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#`<init>`(+2).
//              ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                                    ^^^^^ reference local5
    }
  }

  @Nullable
// ^^^^^^^^ reference androidx/annotation/Nullable#
  private static Constructor<?> findConstructorForClass(Class<?> controllerClass) {
//               ^^^^^^^^^^^ reference java/lang/reflect/Constructor#
//                              ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                                                      ^^^^^ reference java/lang/Class#
//                                                               ^^^^^^^^^^^^^^^ definition local6
    Constructor<?> helperCtor = BINDINGS.get(controllerClass);
//  ^^^^^^^^^^^ reference java/lang/reflect/Constructor#
//                 ^^^^^^^^^^ definition local7
//                              ^^^^^^^^ reference com/airbnb/epoxy/ControllerHelperLookup#BINDINGS.
//                                       ^^^ reference java/util/Map#get().
//                                           ^^^^^^^^^^^^^^^ reference local6
    if (helperCtor != null || BINDINGS.containsKey(controllerClass)) {
//      ^^^^^^^^^^ reference local7
//                            ^^^^^^^^ reference com/airbnb/epoxy/ControllerHelperLookup#BINDINGS.
//                                     ^^^^^^^^^^^ reference java/util/Map#containsKey().
//                                                 ^^^^^^^^^^^^^^^ reference local6
      return helperCtor;
//           ^^^^^^^^^^ reference local7
    }

    String clsName = controllerClass.getName();
//  ^^^^^^ reference java/lang/String#
//         ^^^^^^^ definition local8
//                   ^^^^^^^^^^^^^^^ reference local6
//                                   ^^^^^^^ reference java/lang/Class#getName().
    if (clsName.startsWith("android.") || clsName.startsWith("java.")) {
//      ^^^^^^^ reference local8
//              ^^^^^^^^^^ reference java/lang/String#startsWith(+1).
//                                        ^^^^^^^ reference local8
//                                                ^^^^^^^^^^ reference java/lang/String#startsWith(+1).
      return null;
    }

    try {
      Class<?> bindingClass = Class.forName(clsName + GENERATED_HELPER_CLASS_SUFFIX);
//    ^^^^^ reference java/lang/Class#
//             ^^^^^^^^^^^^ definition local9
//                            ^^^^^ reference java/lang/Class#
//                                  ^^^^^^^ reference java/lang/Class#forName().
//                                          ^^^^^^^ reference local8
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelperLookup#GENERATED_HELPER_CLASS_SUFFIX.
      //noinspection unchecked
      helperCtor = bindingClass.getConstructor(controllerClass);
//    ^^^^^^^^^^ reference local7
//                 ^^^^^^^^^^^^ reference local9
//                              ^^^^^^^^^^^^^^ reference java/lang/Class#getConstructor().
//                                             ^^^^^^^^^^^^^^^ reference local6
    } catch (ClassNotFoundException e) {
//           ^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/ClassNotFoundException#
//                                  ^ definition local10
      helperCtor = findConstructorForClass(controllerClass.getSuperclass());
//    ^^^^^^^^^^ reference local7
//                 ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerHelperLookup#findConstructorForClass().
//                                         ^^^^^^^^^^^^^^^ reference local6
//                                                         ^^^^^^^^^^^^^ reference java/lang/Class#getSuperclass().
    } catch (NoSuchMethodException e) {
//           ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/NoSuchMethodException#
//                                 ^ definition local11
      throw new RuntimeException("Unable to find Epoxy Helper constructor for " + clsName, e);
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#`<init>`(+2).
//              ^^^^^^^^^^^^^^^^ reference java/lang/RuntimeException#
//                                                                                ^^^^^^^ reference local8
//                                                                                         ^ reference local11
    }
    BINDINGS.put(controllerClass, helperCtor);
//  ^^^^^^^^ reference com/airbnb/epoxy/ControllerHelperLookup#BINDINGS.
//           ^^^ reference java/util/Map#put().
//               ^^^^^^^^^^^^^^^ reference local6
//                                ^^^^^^^^^^ reference local7
    return helperCtor;
//         ^^^^^^^^^^ reference local7
  }
}
