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
//                                                 kind Interface
//                                                 display_name AnnotationsOnParameterizedTypes
//                                                 signature_documentation
//                                                 > public interface AnnotationsOnParameterizedTypes
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypes#getInstance().
    public static AnnotationsOnParameterizedTypes getInstance() {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#
//                                                ^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypes#getInstance().
//                                                            kind StaticMethod
//                                                            display_name getInstance
//                                                            signature_documentation
//                                                            > public static AnnotationsOnParameterizedTypes getInstance()
      return new AnnotationsOnParameterizedTypesImpl();
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#`<init>`().
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#getInstance().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                ⌄ enclosing_range_start local 0
//                                                   ⌄ enclosing_range_start local 1
    <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass);
//   ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//     kind TypeParameter
//     display_name C
//     signature_documentation
//     > C
//      ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//        kind TypeParameter
//        display_name W
//        signature_documentation
//        > W
//         ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//                  ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                     ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                        ^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
//                                kind AbstractMethod
//                                display_name adapter
//                                signature_documentation
//                                > public abstract <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass)
//                                relationship scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter(). implementation reference
//                                ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                      ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                                         ^^^^^^^^ definition local 0
//                                                  display_name contract
//                                                  signature_documentation
//                                                  > Class<C> contract
//                                                   ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                                         ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                                                            ^^^^^^^^^^^^ definition local 1
//                                                                         display_name wrappedClass
//                                                                         signature_documentation
//                                                                         > Class<W> wrappedClass
//                                                ⌃ enclosing_range_end local 0
//                                                                       ⌃ enclosing_range_end local 1
//                                                                         ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[C]
//                                                                         ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().[W]
//                                                                         ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypes#
  
  
//⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#
  class AnnotationsOnParameterizedTypesImpl implements AnnotationsOnParameterizedTypes {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#
//                                          kind Class
//                                          display_name AnnotationsOnParameterizedTypesImpl
//                                          signature_documentation
//                                          > class AnnotationsOnParameterizedTypesImpl implements AnnotationsOnParameterizedTypes
//                                          relationship scip-java maven . . minimized/AnnotationsOnParameterizedTypes# implementation
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#`<init>`().
//                                          kind Constructor
//                                          display_name <init>
//                                          signature_documentation
//                                          > AnnotationsOnParameterizedTypesImpl()
//                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypes#
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
    private ConcurrentMap<Class<?>, Constructor<?>> proxyConstructors = new ConcurrentHashMap<>();
//          ^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/concurrent/ConcurrentMap#
//                        ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                  ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/Constructor#
//                                                  ^^^^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
//                                                                    kind Field
//                                                                    display_name proxyConstructors
//                                                                    signature_documentation
//                                                                    > private ConcurrentMap<Class<?>, Constructor<?>> proxyConstructors
//                                                                          ^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/concurrent/ConcurrentHashMap#`<init>`().
//                                                                                               ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
    @Override
//   ^^^^^^^^ reference scip-java maven jdk 11 java/lang/Override#
//                                       ⌄ enclosing_range_start local 2
//                                                          ⌄ enclosing_range_start local 3
    public <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass) {
//          ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//            kind TypeParameter
//            display_name C
//            signature_documentation
//            > C
//             ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//               kind TypeParameter
//               display_name W
//               signature_documentation
//               > W
//                ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//                         ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                            ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                               ^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
//                                       kind Method
//                                       display_name adapter
//                                       signature_documentation
//                                       > @Override
//                                       > public <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass)
//                                       relationship scip-java maven . . minimized/AnnotationsOnParameterizedTypes#adapter(). implementation reference
//                                       ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                             ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                                ^^^^^^^^ definition local 2
//                                                         display_name contract
//                                                         signature_documentation
//                                                         > Class<C> contract
//                                                          ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                                                ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//                                                                   ^^^^^^^^^^^^ definition local 3
//                                                                                display_name wrappedClass
//                                                                                signature_documentation
//                                                                                > Class<W> wrappedClass
//                                                       ⌃ enclosing_range_end local 2
//                                                                              ⌃ enclosing_range_end local 3
  
//    ⌄ enclosing_range_start local 4
      Function<InvocationHandler, C> constructor = getConstructor(contract);
//    ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//             ^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/InvocationHandler#
//                                ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//                                   ^^^^^^^^^^^ definition local 4
//                                               kind Variable
//                                               display_name constructor
//                                               signature_documentation
//                                               > Function<InvocationHandler, C> constructor
//                                                 ^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                                ^^^^^^^^ reference local 2
//                                                                         ⌃ enclosing_range_end local 4
  
      System.out.println(constructor);
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//           ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//               ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+9).
//                       ^^^^^^^^^^^ reference local 4
  
      return null;
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[C]
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().[W]
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#adapter().
  
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//  ⌄ enclosing_range_start scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                            ⌄ enclosing_range_start local 5
    private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract) {
//           ^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//             kind TypeParameter
//             display_name T
//             signature_documentation
//             > T
//              ^^^^^^^^ reference scip-java maven jdk 11 java/util/function/Function#
//                       ^^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/InvocationHandler#
//                                          ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                             ^^^^^^^^^^^^^^ definition scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
//                                                            kind Method
//                                                            display_name getConstructor
//                                                            signature_documentation
//                                                            > private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract)
//                                                            ^^^^^ reference scip-java maven jdk 11 java/lang/Class#
//                                                                  ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                                     ^^^^^^^^ definition local 5
//                                                                              display_name contract
//                                                                              signature_documentation
//                                                                              > Class<T> contract
//                                                                            ⌃ enclosing_range_end local 5
//    ⌄ enclosing_range_start local 6
      @SuppressWarnings("unchecked")
//     ^^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/SuppressWarnings#
//                                                                                              ⌄ enclosing_range_start local 7
      Constructor<T> constructor = (Constructor<T>) proxyConstructors.computeIfAbsent(contract, c -> {
//    ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/Constructor#
//                ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                   ^^^^^^^^^^^ definition local 6
//                               kind Variable
//                               display_name constructor
//                               signature_documentation
//                               > @SuppressWarnings("unchecked")
//                               > Constructor<T> constructor
//                                  ^^^^^^^^^^^ reference scip-java maven jdk 11 java/lang/reflect/Constructor#
//                                              ^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//                                                  ^^^^^^^^^^^^^^^^^ reference scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#proxyConstructors.
//                                                                    ^^^^^^^^^^^^^^^ reference scip-java maven jdk 11 java/util/concurrent/ConcurrentMap#computeIfAbsent().
//                                                                                    ^^^^^^^^ reference local 5
//                                                                                              ^ definition local 7
//                                                                                                display_name c
//                                                                                                signature_documentation
//                                                                                                > Class<?> c
//                                                                                              ⌃ enclosing_range_end local 7
        return null;
      });
//      ⌃ enclosing_range_end local 6
  
      System.out.println(constructor);
//    ^^^^^^ reference scip-java maven jdk 11 java/lang/System#
//           ^^^ reference scip-java maven jdk 11 java/lang/System#out.
//               ^^^^^^^ reference scip-java maven jdk 11 java/io/PrintStream#println(+9).
//                       ^^^^^^^^^^^ reference local 6
  
      return null;
    }
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().[T]
//  ⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#getConstructor().
  }
//⌃ enclosing_range_end scip-java maven . . minimized/AnnotationsOnParameterizedTypesImpl#
