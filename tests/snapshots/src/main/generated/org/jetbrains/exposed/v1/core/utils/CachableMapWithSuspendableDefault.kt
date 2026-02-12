  package org.jetbrains.exposed.v1.core.utils
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/
  
  import org.jetbrains.exposed.v1.core.InternalApi
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
  import java.util.concurrent.ConcurrentHashMap
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
//                 ^^^^^^^^^^ reference semanticdb maven . . java/util/concurrent/
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#
  
  interface CacheWithSuspendableDefault<K, V> {
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithSuspendableDefault#
//                                      display_name CacheWithSuspendableDefault
//                                      documentation ```kotlin\npublic abstract interface CacheWithSuspendableDefault<K, V> : Any\n```
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#
//                                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithSuspendableDefault#[K]
//                                        display_name FirTypeParameterSymbol K
//                                        documentation ```kotlin\nK\n```
//                                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithSuspendableDefault#[V]
//                                           display_name FirTypeParameterSymbol V
//                                           documentation ```kotlin\nV\n```
      suspend fun get(key: K): V
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithSuspendableDefault#get().
//                    display_name get
//                    documentation ```kotlin\npublic abstract suspend fun get(key: K): V\n\n```
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#get().
//                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithSuspendableDefault#get().(key)
//                        display_name key
//                        documentation ```kotlin\nkey: K\n```
  }
  
  @InternalApi
  class CachableMapWithSuspendableDefault<K, V>(
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#
//                                        display_name CachableMapWithSuspendableDefault
//                                        documentation ```kotlin\n@InternalApi() public final class CachableMapWithSuspendableDefault<K, V> : CacheWithSuspendableDefault<K, V>\n```
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithSuspendableDefault#
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#`<init>`().
//                                        display_name CachableMapWithSuspendableDefault
//                                        documentation ```kotlin\npublic constructor<K, V>(map: MutableMap<K, V> = ..., default: suspend (K) -> V): CachableMapWithSuspendableDefault<K, V>\n```
//                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#[K]
//                                          display_name FirTypeParameterSymbol K
//                                          documentation ```kotlin\nK\n```
//                                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#[V]
//                                             display_name FirTypeParameterSymbol V
//                                             documentation ```kotlin\nV\n```
      private val map: MutableMap<K, V> = ConcurrentHashMap<K, V>(),
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#`<init>`().(map)
//                    display_name map
//                    documentation ```kotlin\nmap: MutableMap<K, V> = ...\n```
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#`<init>`().(map)
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#getMap().
//                    display_name map
//                    documentation ```kotlin\nprivate get(): MutableMap<K, V>\n```
//                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#map.
//                    display_name map
//                    documentation ```kotlin\nprivate final val map: MutableMap<K, V>\n```
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/concurrent/ConcurrentHashMap#`<init>`().
      val default: suspend (K) -> V
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#`<init>`().(default)
//                display_name default
//                documentation ```kotlin\ndefault: suspend (K) -> V\n```
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#`<init>`().(default)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#default.
//                display_name default
//                documentation ```kotlin\npublic final val default: suspend (K) -> V\n```
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#getDefault().
//                display_name default
//                documentation ```kotlin\npublic get(): suspend (K) -> V\n```
//                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/coroutines/SuspendFunction1#
  ) : CacheWithSuspendableDefault<K, V> {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithSuspendableDefault#
      override suspend fun get(key: K): V {
//                         ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#get().
//                             display_name get
//                             documentation ```kotlin\npublic open override suspend fun get(key: K): V\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithSuspendableDefault#get().
//                             ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#get().(key)
//                                 display_name key
//                                 documentation ```kotlin\nkey: K\n```
          return map.getOrPut(key) { default(key) }
//               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#getMap().
//               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#map.
//                   ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#get().(key)
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/coroutines/SuspendFunction1#invoke().
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#default.
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#getDefault().
//                                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithSuspendableDefault#get().(key)
      }
  }
