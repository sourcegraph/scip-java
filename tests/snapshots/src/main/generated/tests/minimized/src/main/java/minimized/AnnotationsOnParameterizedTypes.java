  package minimized;
  
  import java.lang.reflect.Constructor;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/lang/
//                 ^^^^^^^ reference scip-java maven . . java/lang/reflect/
//                         ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/Constructor#
  import java.lang.reflect.InvocationHandler;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/lang/
//                 ^^^^^^^ reference scip-java maven . . java/lang/reflect/
//                         ^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/InvocationHandler#
  import java.util.concurrent.ConcurrentHashMap;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^^^^^ reference scip-java maven . . java/util/concurrent/
//                            ^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/concurrent/ConcurrentHashMap#
  import java.util.concurrent.ConcurrentMap;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^^^^^ reference scip-java maven . . java/util/concurrent/
//                            ^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/concurrent/ConcurrentMap#
  import java.util.function.Function;
//       ^^^^ reference scip-java maven . . java/
//            ^^^^ reference scip-java maven . . java/util/
//                 ^^^^^^^^ reference scip-java maven . . java/util/function/
//                          ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
  
//⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypes#
  public interface AnnotationsOnParameterizedTypes {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypes#
//                                                 display_name AnnotationsOnParameterizedTypes
//                                                 signature_documentation java public abstract interface AnnotationsOnParameterizedTypes
//                                                 kind Interface
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypes#getInstance().
    public static AnnotationsOnParameterizedTypes getInstance() {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#
//                                                ^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypes#getInstance().
//                                                            display_name getInstance
//                                                            signature_documentation java public static AnnotationsOnParameterizedTypes getInstance()
//                                                            kind StaticMethod
      return new AnnotationsOnParameterizedTypesImpl();
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#`<init>`().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#getInstance().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                                ⌄ enclosing_range_start local 0
//                                                   ⌄ enclosing_range_start local 1
    <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass);
//   ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//     display_name C
//     signature_documentation java C
//     kind TypeParameter
//      ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//        display_name W
//        signature_documentation java W
//        kind TypeParameter
//         ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//                  ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                     ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                        ^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                display_name adapter
//                                signature_documentation java public abstract <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass)
//                                kind AbstractMethod
//                                relationship is_reference is_implementation scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                      ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                                         ^^^^^^^^ definition local 0
//                                                  display_name contract
//                                                  signature_documentation java Class<C> contract
//                                                  enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                                  kind Parameter
//                                                   ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                                         ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                                                            ^^^^^^^^^^^^ definition local 1
//                                                                         display_name wrappedClass
//                                                                         signature_documentation java Class<W> wrappedClass
//                                                                         enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                                                         kind Parameter
//                                                ⌃ enclosing_range_end local 0
//                                                                       ⌃ enclosing_range_end local 1
//                                                                         ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                                                         ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                                                                         ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
  }
//⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#
  
  
//⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#
  class AnnotationsOnParameterizedTypesImpl implements AnnotationsOnParameterizedTypes {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#
//                                          display_name AnnotationsOnParameterizedTypesImpl
//                                          signature_documentation java class AnnotationsOnParameterizedTypesImpl implements AnnotationsOnParameterizedTypes
//                                          kind Class
//                                          relationship is_implementation scip-java maven . . minimized/AnnotationsOnParameterizedTypes#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#`<init>`().
//                                          display_name <init>
//                                          signature_documentation java AnnotationsOnParameterizedTypesImpl()
//                                          kind Constructor
//                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
    private ConcurrentMap<Class<?>, Constructor<?>> proxyConstructors = new ConcurrentHashMap<>();
//          ^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/concurrent/ConcurrentMap#
//                        ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                  ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/Constructor#
//                                                  ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
//                                                                    display_name proxyConstructors
//                                                                    signature_documentation java private ConcurrentMap<Class<?>, Constructor<?>> proxyConstructors
//                                                                    kind Field
//                                                                          ^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/concurrent/ConcurrentHashMap#`<init>`().
//                                                                                               ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
    @Override
//   ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
//                                       ⌄ enclosing_range_start local 2
//                                       ⌄ enclosing_range_start local 0
//                                                          ⌄ enclosing_range_start local 3
//                                                          ⌄ enclosing_range_start local 1
    public <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass) {
//          ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//            display_name C
//            signature_documentation java C
//            kind TypeParameter
//             ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//               display_name W
//               signature_documentation java W
//               kind TypeParameter
//                ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//                         ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                            ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                               ^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                       display_name adapter
//                                       signature_documentation java @Override\npublic <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass)
//                                       kind Method
//                                       relationship is_reference is_implementation scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                       ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                             ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                                ^^^^^^^^ definition local 0
//                                                         display_name contract
//                                                         signature_documentation java Class<C> contract
//                                                         enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                                         kind Parameter
//                                                ^^^^^^^^ definition local 2
//                                                         display_name constructor
//                                                         signature_documentation java Function<InvocationHandler, C> constructor
//                                                         enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                                         kind Variable
//                                                          ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                                                ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                                                                   ^^^^^^^^^^^^ definition local 1
//                                                                                display_name wrappedClass
//                                                                                signature_documentation java Class<W> wrappedClass
//                                                                                enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                                                                kind Parameter
//                                                                   ^^^^^^^^^^^^ definition local 3
//                                                                                display_name contract
//                                                                                signature_documentation java Class<T> contract
//                                                                                enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                                kind Parameter
//                                                       ⌃ enclosing_range_end local 2
//                                                       ⌃ enclosing_range_end local 0
//                                                                              ⌃ enclosing_range_end local 3
//                                                                              ⌃ enclosing_range_end local 1
  
//    ⌄ enclosing_range_start local 4
//    ⌄ enclosing_range_start local 2
      Function<InvocationHandler, C> constructor = getConstructor(contract);
//    ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//             ^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/InvocationHandler#
//                                ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                   ^^^^^^^^^^^ definition local 2
//                                               display_name constructor
//                                               signature_documentation java Function<InvocationHandler, C> constructor
//                                               enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                               kind Variable
//                                   ^^^^^^^^^^^ definition local 4
//                                               display_name constructor
//                                               signature_documentation java @SuppressWarnings\nConstructor<T> constructor
//                                               enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                               kind Variable
//                                                 ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                ^^^^^^^^ reference local 0
//                                                                ^^^^^^^^ reference local 2
//                                                                         ⌃ enclosing_range_end local 4
//                                                                         ⌃ enclosing_range_end local 2
  
      System.out.println(constructor);
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//           ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//               ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+9).
//                       ^^^^^^^^^^^ reference local 2
//                       ^^^^^^^^^^^ reference local 4
  
      return null;
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                            ⌄ enclosing_range_start local 5
//                                                            ⌄ enclosing_range_start local 3
    private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract) {
//           ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//             display_name T
//             signature_documentation java T
//             kind TypeParameter
//              ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//                       ^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/InvocationHandler#
//                                          ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                             ^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                            display_name getConstructor
//                                                            signature_documentation java private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract)
//                                                            kind Method
//                                                            ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                                                  ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                                     ^^^^^^^^ definition local 3
//                                                                              display_name contract
//                                                                              signature_documentation java Class<T> contract
//                                                                              enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                              kind Parameter
//                                                                     ^^^^^^^^ definition local 5
//                                                                              display_name c
//                                                                              signature_documentation java Class<?> c
//                                                                              enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                              kind Parameter
//                                                                            ⌃ enclosing_range_end local 5
//                                                                            ⌃ enclosing_range_end local 3
//    ⌄ enclosing_range_start local 6
//    ⌄ enclosing_range_start local 4
      @SuppressWarnings("unchecked")
//     ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/SuppressWarnings#
//                                                                                              ⌄ enclosing_range_start local 7
//                                                                                              ⌄ enclosing_range_start local 5
      Constructor<T> constructor = (Constructor<T>) proxyConstructors.computeIfAbsent(contract, c -> {
//    ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/Constructor#
//                ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                   ^^^^^^^^^^^ definition local 4
//                               display_name constructor
//                               signature_documentation java @SuppressWarnings\nConstructor<T> constructor
//                               enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                               kind Variable
//                   ^^^^^^^^^^^ definition local 6
//                               display_name constructor
//                               signature_documentation java @SuppressWarnings\nConstructor<T> constructor
//                               enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                               kind Variable
//                                  ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/Constructor#
//                                              ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                  ^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
//                                                                    ^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/concurrent/ConcurrentMap#computeIfAbsent().
//                                                                                    ^^^^^^^^ reference local 3
//                                                                                    ^^^^^^^^ reference local 5
//                                                                                              ^ definition local 5
//                                                                                                display_name c
//                                                                                                signature_documentation java Class<?> c
//                                                                                                enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                                                kind Parameter
//                                                                                              ^ definition local 7
//                                                                                                display_name c
//                                                                                                signature_documentation java Class<?> c
//                                                                                                enclosing_symbol scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                                                kind Parameter
//                                                                                              ⌃ enclosing_range_end local 7
//                                                                                              ⌃ enclosing_range_end local 5
        return null;
      });
//      ⌃ enclosing_range_end local 6
//      ⌃ enclosing_range_end local 4
  
      System.out.println(constructor);
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//           ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//               ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+9).
//                       ^^^^^^^^^^^ reference local 4
//                       ^^^^^^^^^^^ reference local 6
  
      return null;
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
  }//⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#
