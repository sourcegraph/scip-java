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
//                                               kind Interface

  public static AnnotationsOnParameterizedTypes getInstance() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#
//                                              ^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#getInstance().
//                                                          display_name getInstance
//                                                          signature_documentation java public static AnnotationsOnParameterizedTypes getInstance()
//                                                          kind StaticMethod
    return new AnnotationsOnParameterizedTypesImpl();
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#`<init>`().
  }

  <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass);
// ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//   display_name C
//   signature_documentation java C
//   kind TypeParameter
//    ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//      display_name W
//      signature_documentation java W
//      kind TypeParameter
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                   ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                      ^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                              display_name adapter
//                              signature_documentation java public abstract <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass)
//                              kind AbstractMethod
//                              relationship is_reference is_implementation semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                              relationship is_reference is_implementation semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                              ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                    ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                                       ^^^^^^^^ definition local 0
//                                                display_name contract
//                                                signature_documentation java Class<C> contract
//                                                enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                                 ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                       ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                                                          ^^^^^^^^^^^^ definition local 1
//                                                                       display_name wrappedClass
//                                                                       signature_documentation java Class<W> wrappedClass
//                                                                       enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
}


class AnnotationsOnParameterizedTypesImpl implements AnnotationsOnParameterizedTypes {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#
//                                        display_name AnnotationsOnParameterizedTypesImpl
//                                        signature_documentation java class AnnotationsOnParameterizedTypesImpl
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
//                                                                  kind Field
//                                                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#`<init>`().

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass) {
//        ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//          display_name C
//          signature_documentation java C
//          kind TypeParameter
//           ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//             display_name W
//             signature_documentation java W
//             kind TypeParameter
//              ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                       ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                          ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                             ^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                     display_name adapter
//                                     signature_documentation java @Override\npublic <C, W> Function<W, C> adapter(Class<C> contract, Class<T> contract)
//                                     kind Method
//                                     relationship is_reference is_implementation semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                     ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                           ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                              ^^^^^^^^ definition local 0
//                                                       display_name contract
//                                                       signature_documentation java Class<C> contract
//                                                       enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                              ^^^^^^^^ definition local 2
//                                                       display_name contract
//                                                       signature_documentation java Class<C> contract
//                                                       enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                                        ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                              ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                                                                 ^^^^^^^^^^^^ definition local 1
//                                                                              display_name wrappedClass
//                                                                              signature_documentation java Class<W> wrappedClass
//                                                                              enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                                                 ^^^^^^^^^^^^ definition local 3
//                                                                              display_name contract
//                                                                              signature_documentation java Class<T> contract
//                                                                              enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().

    Function<InvocationHandler, C> constructor = getConstructor(contract);
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationHandler#
//                              ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                 ^^^^^^^^^^^ definition local 2
//                                             display_name contract
//                                             signature_documentation java Class<C> contract
//                                             enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                 ^^^^^^^^^^^ definition local 4
//                                             display_name constructor
//                                             signature_documentation java @SuppressWarnings("unchecked")\nConstructor<T> constructor
//                                             enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                             kind Variable
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                              ^^^^^^^^ reference local 0
//                                                              ^^^^^^^^ reference local 2

    System.out.println(constructor);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+9).
//                     ^^^^^^^^^^^ reference local 2
//                     ^^^^^^^^^^^ reference local 4

    return null;
  }

  private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract) {
//         ^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//           display_name T
//           signature_documentation java T
//           kind TypeParameter
//            ^^^^^^^^ reference semanticdb maven jdk 11 java/util/function/Function#
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/InvocationHandler#
//                                        ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                           ^^^^^^^^^^^^^^ definition semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                          display_name getConstructor
//                                                          signature_documentation java private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract)
//                                                          kind Method
//                                                          ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                                                ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                                   ^^^^^^^^ definition local 3
//                                                                            display_name contract
//                                                                            signature_documentation java Class<T> contract
//                                                                            enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                   ^^^^^^^^ definition local 5
//                                                                            display_name contract
//                                                                            signature_documentation java Class<T> contract
//                                                                            enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
    @SuppressWarnings("unchecked")
//   ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
    Constructor<T> constructor = (Constructor<T>) proxyConstructors.computeIfAbsent(contract, c -> {
//  ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//              ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                 ^^^^^^^^^^^ definition local 4
//                             display_name constructor
//                             signature_documentation java @SuppressWarnings("unchecked")\nConstructor<T> constructor
//                             enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                             kind Variable
//                 ^^^^^^^^^^^ definition local 6
//                             display_name constructor
//                             signature_documentation java @SuppressWarnings\nConstructor<T> constructor
//                             enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                             kind Variable
//                                ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/reflect/Constructor#
//                                            ^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
//                                                                  ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentMap#computeIfAbsent().
//                                                                                  ^^^^^^^^ reference local 3
//                                                                                  ^^^^^^^^ reference local 5
//                                                                                            ^ definition local 5
//                                                                                              display_name contract
//                                                                                              signature_documentation java Class<T> contract
//                                                                                              enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                                            ^ definition local 7
//                                                                                              display_name c
//                                                                                              signature_documentation java Class<?> c
//                                                                                              enclosing_symbol semanticdb maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
      return null;
    });

    System.out.println(constructor);
//  ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//         ^^^ reference semanticdb maven jdk 11 java/lang/System#out.
//             ^^^^^^^ reference semanticdb maven jdk 11 java/io/PrintStream#println(+9).
//                     ^^^^^^^^^^^ reference local 4
//                     ^^^^^^^^^^^ reference local 6

    return null;
  }
}