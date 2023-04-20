package com.airbnb.epoxy.preload
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/

import java.util.ArrayDeque
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayDeque#

internal class PreloadTargetProvider<P : PreloadRequestHolder>(
//             ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#
//                                   documentation ```kt\ninternal final class PreloadTargetProvider<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//             ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().
//                                   documentation ```kt\npublic constructor PreloadTargetProvider<P : com.airbnb.epoxy.preload.PreloadRequestHolder>(maxPreload: kotlin.Int, requestHolderFactory: () -> P)\n```
//                                   ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#[P]
//                                     documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
    maxPreload: Int,
//  ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().(maxPreload)
//             documentation ```kt\nvalue-parameter maxPreload: kotlin.Int\n```
//              ^^^ reference semanticdb maven . . kotlin/Int#
    requestHolderFactory: () -> P
//  ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().(requestHolderFactory)
//                       documentation ```kt\nvalue-parameter requestHolderFactory: () -> P\n```
//                              ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#[P]
) {
    private val queue = ArrayDeque<P>((0 until maxPreload).map { requestHolderFactory() })
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#getQueue().
//                    documentation ```kt\nprivate final val queue: java.util.ArrayDeque<P>\n```
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#queue.
//                    documentation ```kt\nprivate final val queue: java.util.ArrayDeque<P>\n```
//                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayDeque#`<init>`(+2).
//                                 ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#[P]
//                                       ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().(maxPreload)
//                                                         ^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#map(+9).
//                                                               ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().(requestHolderFactory)

    internal fun next(): P {
//               ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#next().
//                    documentation ```kt\ninternal final fun next(): P\n```
//                       ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#[P]
        val result = queue.poll()
//          ^^^^^^ definition local 0
//                 documentation ```kt\nval result: P!\n```
//                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#getQueue().
//                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#queue.
//                         ^^^^ reference semanticdb maven jdk 11 java/util/ArrayDeque#poll().
        queue.offer(result)
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#getQueue().
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#queue.
//            ^^^^^ reference semanticdb maven jdk 11 java/util/ArrayDeque#offer().
//                  ^^^^^^ reference local 0
        result.clear()
//      ^^^^^^ reference local 0
//             ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#clear().
        return result
//             ^^^^^^ reference local 0
    }

    fun clearAll() {
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#clearAll().
//               documentation ```kt\npublic final fun clearAll()\n```
        queue.forEach { it.clear() }
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#getQueue().
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadTargetProvider#queue.
//            ^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#forEach(+10).
//                      ^^ reference local 1
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#clear().
    }
}

/**
 * This is responsible for holding details for a preloading request.
 * Your implementation can do anything it wants with the request, but it must
 * cancel and clear itself when [clear] is called.
 *
 * It is also recommended that your implementation calls [clear] when your request finishes loading
 * to avoid unnecessarily hanging onto the request result (assuming the result is also stored in
 * cache). Otherwise this holder can be stored in a pool for later use and may leak the preloaded
 * data.
 */
interface PreloadRequestHolder {
//        ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                             documentation ```kt\npublic interface PreloadRequestHolder\n```\n\n----\n\n\n This is responsible for holding details for a preloading request.\n Your implementation can do anything it wants with the request, but it must\n cancel and clear itself when [clear] is called.\n\n It is also recommended that your implementation calls [clear] when your request finishes loading\n to avoid unnecessarily hanging onto the request result (assuming the result is also stored in\n cache). Otherwise this holder can be stored in a pool for later use and may leak the preloaded\n data.\n
    /** Clear any ongoing preload request. */
    fun clear()
//      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#clear().
//            documentation ```kt\npublic abstract fun clear()\n```\n\n----\n\n Clear any ongoing preload request.
}
