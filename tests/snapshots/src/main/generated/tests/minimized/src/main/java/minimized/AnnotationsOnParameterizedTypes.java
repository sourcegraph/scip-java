package minimized;

import java.lang.reflect.Constructor;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^ reference semanticdb maven . . java/lang/reflect/
//                       ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
import java.lang.reflect.InvocationHandler;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^ reference semanticdb maven . . java/lang/reflect/
//                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationHandler#
import java.util.concurrent.ConcurrentHashMap;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#
import java.util.concurrent.ConcurrentMap;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                          ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentMap#
import java.util.function.Function;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^ reference semanticdb maven . . java/util/function/
//                        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#

public interface AnnotationsOnParameterizedTypes {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#
//                                               documentation ```java\npublic interface AnnotationsOnParameterizedTypes\n```

  public static AnnotationsOnParameterizedTypes getInstance() {
    return new AnnotationsOnParameterizedTypesImpl();
  }

  <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass);
}


class AnnotationsOnParameterizedTypesImpl implements AnnotationsOnParameterizedTypes {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#
//                                        documentation ```java\nclass AnnotationsOnParameterizedTypesImpl\n```
//                                        relationship is_implementation semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#`<init>`().
//                                        documentation ```java\nAnnotationsOnParameterizedTypesImpl()\n```
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#
  private ConcurrentMap<Class<?>, Constructor<?>> proxyConstructors = new ConcurrentHashMap<>();
//        ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentMap#
//                      ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                                                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
//                                                                  documentation ```java\nprivate ConcurrentMap<Class<?>, Constructor<?>> proxyConstructors\n```
//                                                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#`<init>`().

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass) {
//        ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//          documentation ```java\nC\n```
//           ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//             documentation ```java\nW\n```
//              ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                       ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                          ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                             ^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                     documentation ```java\n@Override\npublic <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass)\n```
//                                     relationship is_reference is_implementation semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                     ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                           ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                              ^^^^^^^^ definition local 0
//                                                       documentation ```java\nClass<C> contract\n```
//                                                        ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                              ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                                                                 ^^^^^^^^^^^^ definition local 1
//                                                                              documentation ```java\nClass<W> wrappedClass\n```

    Function<InvocationHandler, C> constructor = getConstructor(contract);
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationHandler#
//                              ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                 ^^^^^^^^^^^ definition local 2
//                                             documentation ```java\nFunction<InvocationHandler, C> constructor\n```
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                              ^^^^^^^^ reference local 0

    System.out.println(constructor);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+9).
//                     ^^^^^^^^^^^ reference local 2

    return null;
  }

  private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract) {
//         ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//           documentation ```java\nT\n```
//            ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationHandler#
//                                        ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                           ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                          documentation ```java\nprivate <T> Function<InvocationHandler, T> getConstructor(Class<T> contract)\n```
//                                                          ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                                ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                                   ^^^^^^^^ definition local 3
//                                                                            documentation ```java\nClass<T> contract\n```
    @SuppressWarnings("unchecked")
//   ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
    Constructor<T> constructor = (Constructor<T>) proxyConstructors.computeIfAbsent(contract, c -> {
//  ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//              ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                 ^^^^^^^^^^^ definition local 4
//                             documentation ```java\n@SuppressWarnings("unchecked")\nConstructor<T> constructor\n```
//                                ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                                            ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentMap#computeIfAbsent().
//                                                                                  ^^^^^^^^ reference local 3
//                                                                                            ^ definition local 5
//                                                                                              documentation ```java\nClass<?> c\n```
      return null;
    });

    System.out.println(constructor);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+9).
//                     ^^^^^^^^^^^ reference local 4

    return null;
  }
}