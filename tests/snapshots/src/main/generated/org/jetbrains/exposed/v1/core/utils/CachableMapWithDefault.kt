package org.jetbrains.exposed.v1.core.utils
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/

import org.jetbrains.exposed.v1.core.InternalApi
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#

interface CacheWithDefault<K, V> {
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithDefault#
//                         display_name CacheWithDefault
//                         documentation ```kotlin\npublic abstract interface CacheWithDefault<K, V> : Any\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#
//                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithDefault#[K]
//                           display_name FirTypeParameterSymbol K
//                           documentation ```kotlin\nK\n```
//                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithDefault#[V]
//                              display_name FirTypeParameterSymbol V
//                              documentation ```kotlin\nV\n```
    fun get(key: K): V
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithDefault#get().
//          display_name get
//          documentation ```kotlin\npublic abstract fun get(key: K): V\n\n```
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#get().
//          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithDefault#get().(key)
//              display_name key
//              documentation ```kotlin\nkey: K\n```
}

@InternalApi
class CachableMapWithDefault<K, V>(
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#
//                           display_name CachableMapWithDefault
//                           documentation ```kotlin\n@InternalApi() public final class CachableMapWithDefault<K, V> : CacheWithDefault<K, V>\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithDefault#
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#`<init>`().
//                           display_name CachableMapWithDefault
//                           documentation ```kotlin\npublic constructor<K, V>(map: MutableMap<K, V> = ..., default: (K) -> V): CachableMapWithDefault<K, V>\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#[K]
//                             display_name FirTypeParameterSymbol K
//                             documentation ```kotlin\nK\n```
//                              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#[V]
//                                display_name FirTypeParameterSymbol V
//                                documentation ```kotlin\nV\n```
    private val map: MutableMap<K, V> = mutableMapOf(),
//              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#`<init>`().(map)
//                  display_name map
//                  documentation ```kotlin\nmap: MutableMap<K, V> = ...\n```
//              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#`<init>`().(map)
//              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#getMap().
//                  display_name map
//                  documentation ```kotlin\nprivate get(): MutableMap<K, V>\n```
//              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#map.
//                  display_name map
//                  documentation ```kotlin\nprivate final val map: MutableMap<K, V>\n```
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableMapOf().
    val default: (K) -> V
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#`<init>`().(default)
//              display_name default
//              documentation ```kotlin\ndefault: (K) -> V\n```
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#`<init>`().(default)
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#default.
//              display_name default
//              documentation ```kotlin\npublic final val default: (K) -> V\n```
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#getDefault().
//              display_name default
//              documentation ```kotlin\npublic get(): (K) -> V\n```
//               ^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
) : CacheWithDefault<K, V> {
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithDefault#
    override fun get(key: K): V = map.getOrPut(key) { default(key) }
//               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#get().
//                   display_name get
//                   documentation ```kotlin\npublic open override fun get(key: K): V\n```
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CacheWithDefault#get().
//                   ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#get().(key)
//                       display_name key
//                       documentation ```kotlin\nkey: K\n```
//                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#getMap().
//                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#map.
//                                    ^^^^^^^^ reference semanticdb maven . . kotlin/collections/getOrPut(+1).
//                                             ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#get().(key)
//                                                    ^^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#default.
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#getDefault().
//                                                            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/utils/CachableMapWithDefault#get().(key)
}
