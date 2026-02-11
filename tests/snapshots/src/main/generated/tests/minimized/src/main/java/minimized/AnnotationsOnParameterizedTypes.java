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
//                                               display_name AnnotationsOnParameterizedTypes
//                                               signature_documentation java public interface AnnotationsOnParameterizedTypes
//                                               enclosing_range 8 0 15 1
//                                               kind Interface

  public static AnnotationsOnParameterizedTypes getInstance() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#
//                                              ^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#getInstance().
//                                                          display_name getInstance
//                                                          signature_documentation java public static AnnotationsOnParameterizedTypes getInstance()
//                                                          enclosing_range 10 2 12 3
//                                                          kind StaticMethod
    return new AnnotationsOnParameterizedTypesImpl();
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#`<init>`().
  }

  <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass);
// ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//   display_name C
//   signature_documentation java C
//   enclosing_range 14 2 74
//   kind TypeParameter
//    ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//      display_name W
//      signature_documentation java W
//      enclosing_range 14 2 74
//      kind TypeParameter
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                   ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                      ^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                              display_name adapter
//                              signature_documentation java public abstract <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass)
//                              enclosing_range 14 2 74
//                              kind AbstractMethod
//                              relationship is_reference is_implementation semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                              ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                    ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                                       ^^^^^^^^ definition local 0
//                                                display_name contract
//                                                signature_documentation java Class<C> contract
//                                                enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                                enclosing_range 14 32 49
//                                                 ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                       ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                                                          ^^^^^^^^^^^^ definition local 1
//                                                                       display_name wrappedClass
//                                                                       signature_documentation java Class<W> wrappedClass
//                                                                       enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                                                       enclosing_range 14 51 72
}


class AnnotationsOnParameterizedTypesImpl implements AnnotationsOnParameterizedTypes {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#
//                                        display_name AnnotationsOnParameterizedTypesImpl
//                                        signature_documentation java class AnnotationsOnParameterizedTypesImpl
//                                        enclosing_range 18 0 41 1
//                                        kind Class
//                                        relationship is_implementation semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#`<init>`().
//                                        display_name <init>
//                                        signature_documentation java AnnotationsOnParameterizedTypesImpl()
//                                        kind Constructor
//                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#
  private ConcurrentMap<Class<?>, Constructor<?>> proxyConstructors = new ConcurrentHashMap<>();
//        ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentMap#
//                      ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                                                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
//                                                                  display_name proxyConstructors
//                                                                  signature_documentation java private ConcurrentMap<Class<?>, Constructor<?>> proxyConstructors
//                                                                  enclosing_range 19 2 96
//                                                                  kind Field
//                                                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#`<init>`().

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass) {
//        ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//          display_name C
//          signature_documentation java C
//          enclosing_range 21 2 29 3
//          kind TypeParameter
//           ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//             display_name W
//             signature_documentation java W
//             enclosing_range 21 2 29 3
//             kind TypeParameter
//              ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                       ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                          ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                             ^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                     display_name adapter
//                                     signature_documentation java @Override\npublic <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass)
//                                     enclosing_range 21 2 29 3
//                                     kind Method
//                                     relationship is_reference is_implementation semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                     ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                           ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                              ^^^^^^^^ definition local 2
//                                                       display_name contract
//                                                       signature_documentation java Class<C> contract
//                                                       enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                                       enclosing_range 22 39 56
//                                                        ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                              ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                                                                 ^^^^^^^^^^^^ definition local 3
//                                                                              display_name wrappedClass
//                                                                              signature_documentation java Class<W> wrappedClass
//                                                                              enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                                                              enclosing_range 22 58 79

    Function<InvocationHandler, C> constructor = getConstructor(contract);
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationHandler#
//                              ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                 ^^^^^^^^^^^ definition local 4
//                                             display_name constructor
//                                             signature_documentation java Function<InvocationHandler, C> constructor
//                                             enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                             enclosing_range 24 4 74
//                                             kind Variable
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                              ^^^^^^^^ reference local 2

    System.out.println(constructor);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+9).
//                     ^^^^^^^^^^^ reference local 4

    return null;
  }

  private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract) {
//         ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//           display_name T
//           signature_documentation java T
//           enclosing_range 31 2 40 3
//           kind TypeParameter
//            ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationHandler#
//                                        ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                           ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                          display_name getConstructor
//                                                          signature_documentation java private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract)
//                                                          enclosing_range 31 2 40 3
//                                                          kind Method
//                                                          ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                                ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                                   ^^^^^^^^ definition local 5
//                                                                            display_name contract
//                                                                            signature_documentation java Class<T> contract
//                                                                            enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                            enclosing_range 31 60 77
    @SuppressWarnings("unchecked")
//   ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
    Constructor<T> constructor = (Constructor<T>) proxyConstructors.computeIfAbsent(contract, c -> {
//  ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//              ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                 ^^^^^^^^^^^ definition local 6
//                             display_name constructor
//                             signature_documentation java @SuppressWarnings\nConstructor<T> constructor
//                             enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                             enclosing_range 32 4 35 7
//                             kind Variable
//                                ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                                            ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentMap#computeIfAbsent().
//                                                                                  ^^^^^^^^ reference local 5
//                                                                                            ^ definition local 7
//                                                                                              display_name c
//                                                                                              signature_documentation java Class<?> c
//                                                                                              enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                                              enclosing_range 33 94 95
      return null;
    });

    System.out.println(constructor);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+9).
//                     ^^^^^^^^^^^ reference local 6

    return null;
  }
}