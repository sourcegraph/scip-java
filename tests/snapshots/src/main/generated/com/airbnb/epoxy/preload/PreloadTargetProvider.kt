package com.airbnb.epoxy.preload
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/
//                       ^^^^^^^ reference com/airbnb/epoxy/preload/

import java.util.ArrayDeque
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^ reference java/util/ArrayDeque#

internal class PreloadTargetProvider<P : PreloadRequestHolder>(
//             ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadTargetProvider#  internal final class PreloadTargetProvider<P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//             ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().  public constructor PreloadTargetProvider<P : com.airbnb.epoxy.preload.PreloadRequestHolder>(maxPreload: kotlin.Int, requestHolderFactory: () -> P)
//                                   ^ definition com/airbnb/epoxy/preload/PreloadTargetProvider#[P]  <P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//                                       ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
    maxPreload: Int,
//  ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().(maxPreload)  value-parameter maxPreload: kotlin.Int
//              ^^^ reference kotlin/Int#
    requestHolderFactory: () -> P
//  ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().(requestHolderFactory)  value-parameter requestHolderFactory: () -> P
//                              ^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#[P]
) {
    private val queue = ArrayDeque<P>((0 until maxPreload).map { requestHolderFactory() })
//              ^^^^^ definition com/airbnb/epoxy/preload/PreloadTargetProvider#queue.  private final val queue: java.util.ArrayDeque<P>
//              ^^^^^ definition com/airbnb/epoxy/preload/PreloadTargetProvider#getQueue().  private final val queue: java.util.ArrayDeque<P>
//                      ^^^^^^^^^^ reference java/util/ArrayDeque#`<init>`(+2).
//                                 ^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#[P]
//                                       ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                                             ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().(maxPreload)
//                                                         ^^^ reference kotlin/collections/CollectionsKt#map(+9).
//                                                               ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().(requestHolderFactory)

    internal fun next(): P {
//               ^^^^ definition com/airbnb/epoxy/preload/PreloadTargetProvider#next().  internal final fun next(): P
//                       ^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#[P]
        val result = queue.poll()
//          ^^^^^^ definition local0  val result: P!
//                   ^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#queue.
//                   ^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#getQueue().
//                         ^^^^ reference java/util/ArrayDeque#poll().
        queue.offer(result)
//      ^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#queue.
//      ^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#getQueue().
//            ^^^^^ reference java/util/ArrayDeque#offer().
//                  ^^^^^^ reference local0
        result.clear()
//      ^^^^^^ reference local0
//             ^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#clear().
        return result
//             ^^^^^^ reference local0
    }

    fun clearAll() {
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadTargetProvider#clearAll().  public final fun clearAll()
        queue.forEach { it.clear() }
//      ^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#queue.
//      ^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#getQueue().
//            ^^^^^^^ reference kotlin/collections/CollectionsKt#forEach(+10).
//                      ^^ reference local1
//                         ^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#clear().
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
//        ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadRequestHolder#  public interface PreloadRequestHolder
    /** Clear any ongoing preload request. */
    fun clear()
//      ^^^^^ definition com/airbnb/epoxy/preload/PreloadRequestHolder#clear().  public abstract fun clear()
}
