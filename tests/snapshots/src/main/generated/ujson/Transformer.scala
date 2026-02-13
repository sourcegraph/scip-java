  package ujson
//        ^^^^^ definition semanticdb maven . . ujson/
  import upickle.core.Visitor
//       ^^^^^^^ reference semanticdb maven . . upickle/
//               ^^^^ reference semanticdb maven . . upickle/core/
//                    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                    ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor.
  
  trait Transformer[I] {
//      ^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#
//                  display_name Transformer
//                  signature_documentation scala trait Transformer[I]
//                  kind Trait
//                  ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#[I]
//                    display_name I
//                    signature_documentation scala I
//                    kind TypeParameter
    def transform[T](j: I, f: Visitor[_, T]): T
//      ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().
//                display_name transform
//                signature_documentation scala def transform(j: I, f: Visitor[local0, T[): T
//                kind AbstractMethod
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteArrayParser.transform().
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/ByteBufferParser.transform().
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/CharSequenceParser.transform().
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/IndexedValue.transform().
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/InputStreamParser.transform().
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/StringParser.transform().
//                relationship is_reference is_implementation semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.transform().
//                ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().[T]
//                  display_name T
//                  signature_documentation scala T
//                  kind TypeParameter
//                   ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().(j)
//                     display_name j
//                     signature_documentation scala j: I 
//                     kind Parameter
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#[I]
//                         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().(f)
//                           display_name f
//                           signature_documentation scala f: Visitor[local0, T[ 
//                           kind Parameter
//                            ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                       ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().[T]
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transform().[T]
    def transformable[T](j: I) = Readable.fromTransformer(j, this)
//      ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transformable().
//                    display_name transformable
//                    signature_documentation scala def transformable(j: I): fromTransformer[I]
//                    kind Method
//                    ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transformable().[T]
//                      display_name T
//                      signature_documentation scala T
//                      kind TypeParameter
//                       ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transformable().(j)
//                         display_name j
//                         signature_documentation scala j: I 
//                         kind Parameter
//                          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#[I]
//                               ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.
//                                        ^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable.fromTransformer.
//                                                        ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Transformer#transformable().(j)
  }
