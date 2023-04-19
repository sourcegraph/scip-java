package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import androidx.core.view.ViewCompat
//     ^^^^^^^^ reference androidx/
import androidx.lifecycle.Lifecycle
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^ reference androidx/lifecycle/
//                        ^^^^^^^^^ reference androidx/lifecycle/Lifecycle#
import androidx.lifecycle.LifecycleObserver
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^ reference androidx/lifecycle/
//                        ^^^^^^^^^^^^^^^^^ reference androidx/lifecycle/LifecycleObserver#
import androidx.lifecycle.LifecycleOwner
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^ reference androidx/lifecycle/
//                        ^^^^^^^^^^^^^^ reference androidx/lifecycle/LifecycleOwner#
import androidx.lifecycle.OnLifecycleEvent
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^ reference androidx/lifecycle/
//                        ^^^^^^^^^^^^^^^^ reference androidx/lifecycle/OnLifecycleEvent#
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference androidx/
import java.lang.ref.WeakReference
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^ reference java/lang/ref/
//                   ^^^^^^^^^^^^^ reference java/lang/ref/WeakReference#
import java.util.ArrayList
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#

internal class ActivityRecyclerPool {
//             ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool# internal final class ActivityRecyclerPool
//             ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#`<init>`(). public constructor ActivityRecyclerPool()

    /**
     * Store one unique pool per activity. They are cleared out when activities are destroyed, so this
     * only needs to hold pools for active activities.
     */
    private val pools = ArrayList<PoolReference>(5)
//              ^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#pools. private final val pools: java.util.ArrayList<com.airbnb.epoxy.PoolReference>
//              ^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#getPools(). private final val pools: java.util.ArrayList<com.airbnb.epoxy.PoolReference>
//                      ^^^^^^^^^ reference java/util/ArrayList#`<init>`().
//                                ^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#

    @JvmOverloads
//   ^^^^^^^^^^^^ reference kotlin/jvm/JvmOverloads#`<init>`().
    fun getPool(
//      ^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#getPool(). public final fun getPool(context: [ERROR : Context], poolFactory: () -> [ERROR : RecyclerView.RecycledViewPool]): com.airbnb.epoxy.PoolReference
        context: Context,
//      ^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#getPool().(context) value-parameter context: [ERROR : Context]
        poolFactory: () -> RecyclerView.RecycledViewPool
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#getPool().(poolFactory) value-parameter poolFactory: () -> [ERROR : RecyclerView.RecycledViewPool]
    ): PoolReference {
//     ^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#

        val iterator = pools.iterator()
//          ^^^^^^^^ definition local0 val iterator: kotlin.collections.MutableIterator<com.airbnb.epoxy.PoolReference>
//                     ^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#pools.
//                     ^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#getPools().
//                           ^^^^^^^^ reference java/util/ArrayList#iterator().
        var poolToUse: PoolReference? = null
//          ^^^^^^^^^ definition local1 var poolToUse: com.airbnb.epoxy.PoolReference?
//                     ^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#

        while (iterator.hasNext()) {
//             ^^^^^^^^ reference local0
//                      ^^^^^^^ reference kotlin/collections/MutableIterator#hasNext().
            val poolReference = iterator.next()
//              ^^^^^^^^^^^^^ definition local2 val poolReference: com.airbnb.epoxy.PoolReference
//                              ^^^^^^^^ reference local0
//                                       ^^^^ reference kotlin/collections/MutableIterator#next().
            when {
                poolReference.context === context -> {
//              ^^^^^^^^^^^^^ reference local2
//                            ^^^^^^^ reference com/airbnb/epoxy/PoolReference#context.
//                                        ^^^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#getPool().(context)
                    if (poolToUse != null) {
//                      ^^^^^^^^^ reference local1
//                                ^^ reference com/airbnb/epoxy/PoolReference#equals(+-1).
                        throw IllegalStateException("A pool was already found")
//                            ^^^^^^^^^^^^^^^^^^^^^ reference kotlin/IllegalStateException#`<init>`(+1).
                    }
                    poolToUse = poolReference
//                  ^^^^^^^^^ reference local1
//                              ^^^^^^^^^^^^^ reference local2
                    // finish iterating to remove any old contexts
                }
                poolReference.context.isActivityDestroyed() -> {
//              ^^^^^^^^^^^^^ reference local2
//                            ^^^^^^^ reference com/airbnb/epoxy/PoolReference#context.
                    // A pool from a different activity that was destroyed.
                    // Clear the pool references to allow the activity to be GC'd
                    poolReference.viewPool.clear()
//                  ^^^^^^^^^^^^^ reference local2
//                                ^^^^^^^^ reference com/airbnb/epoxy/PoolReference#viewPool.
//                                ^^^^^^^^ reference com/airbnb/epoxy/PoolReference#getViewPool().
                    iterator.remove()
//                  ^^^^^^^^ reference local0
//                           ^^^^^^ reference kotlin/collections/MutableIterator#remove().
                }
            }
        }

        if (poolToUse == null) {
//          ^^^^^^^^^ reference local1
//                    ^^ reference com/airbnb/epoxy/PoolReference#equals(+-1).
            poolToUse = PoolReference(context, poolFactory(), this)
//          ^^^^^^^^^ reference local1
//                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#`<init>`().
//                                    ^^^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#getPool().(context)
//                                             ^^^^^^^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#getPool().(poolFactory)
//                                                            ^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#
            context.lifecycle()?.addObserver(poolToUse)
//          ^^^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#getPool().(context)
//                                           ^^^^^^^^^ reference local1
            pools.add(poolToUse)
//          ^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#pools.
//          ^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#getPools().
//                ^^^ reference java/util/ArrayList#add(+1).
//                    ^^^^^^^^^ reference local1
        }

        return poolToUse
//             ^^^^^^^^^ reference local1
    }

    fun clearIfDestroyed(pool: PoolReference) {
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed(). public final fun clearIfDestroyed(pool: com.airbnb.epoxy.PoolReference)
//                       ^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().(pool) value-parameter pool: com.airbnb.epoxy.PoolReference
//                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#
        if (pool.context.isActivityDestroyed()) {
//          ^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().(pool)
//               ^^^^^^^ reference com/airbnb/epoxy/PoolReference#context.
            pool.viewPool.clear()
//          ^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().(pool)
//               ^^^^^^^^ reference com/airbnb/epoxy/PoolReference#viewPool.
//               ^^^^^^^^ reference com/airbnb/epoxy/PoolReference#getViewPool().
            pools.remove(pool)
//          ^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#pools.
//          ^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#getPools().
//                ^^^^^^ reference java/util/ArrayList#remove().
//                       ^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().(pool)
        }
    }

    private fun Context.lifecycle(): Lifecycle? {
//                      ^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#lifecycle(). private final fun [ERROR : Context].lifecycle(): androidx.lifecycle.Lifecycle?
//                                   ^^^^^^^^^ reference androidx/lifecycle/Lifecycle#
        if (this is LifecycleOwner) {
//          ^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#lifecycle().
//                  ^^^^^^^^^^^^^^ reference androidx/lifecycle/LifecycleOwner#
            return lifecycle
        }

        if (this is ContextWrapper) {
//          ^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#lifecycle().
            return baseContext.lifecycle()
        }

        return null
    }
}

internal class PoolReference(
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference# internal final class PoolReference : androidx.lifecycle.LifecycleObserver
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#`<init>`(). public constructor PoolReference(context: [ERROR : Context], viewPool: [ERROR : RecyclerView.RecycledViewPool], parent: com.airbnb.epoxy.ActivityRecyclerPool)
    context: Context,
//  ^^^^^^^ definition com/airbnb/epoxy/PoolReference#`<init>`().(context) value-parameter context: [ERROR : Context]
    val viewPool: RecyclerView.RecycledViewPool,
//      ^^^^^^^^ definition com/airbnb/epoxy/PoolReference#viewPool. public final val viewPool: [ERROR : RecyclerView.RecycledViewPool]
//      ^^^^^^^^ definition com/airbnb/epoxy/PoolReference#getViewPool(). public final val viewPool: [ERROR : RecyclerView.RecycledViewPool]
//      ^^^^^^^^ definition com/airbnb/epoxy/PoolReference#`<init>`().(viewPool) value-parameter viewPool: [ERROR : RecyclerView.RecycledViewPool]
    private val parent: ActivityRecyclerPool
//              ^^^^^^ definition com/airbnb/epoxy/PoolReference#parent. private final val parent: com.airbnb.epoxy.ActivityRecyclerPool
//              ^^^^^^ definition com/airbnb/epoxy/PoolReference#getParent(). private final val parent: com.airbnb.epoxy.ActivityRecyclerPool
//              ^^^^^^ definition com/airbnb/epoxy/PoolReference#`<init>`().(parent) value-parameter parent: com.airbnb.epoxy.ActivityRecyclerPool
//                      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#
) : LifecycleObserver {
//  ^^^^^^^^^^^^^^^^^ reference androidx/lifecycle/LifecycleObserver#
    private val contextReference: WeakReference<Context> = WeakReference(context)
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#contextReference. private final val contextReference: java.lang.ref.WeakReference<[ERROR : Context]>
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#getContextReference(). private final val contextReference: java.lang.ref.WeakReference<[ERROR : Context]>
//                                ^^^^^^^^^^^^^ reference java/lang/ref/WeakReference#
//                                                         ^^^^^^^^^^^^^ reference java/lang/ref/WeakReference#`<init>`().
//                                                                       ^^^^^^^ reference com/airbnb/epoxy/PoolReference#`<init>`().(context)

    val context: Context? get() = contextReference.get()
//      ^^^^^^^ definition com/airbnb/epoxy/PoolReference#context. public final val context: [ERROR : Context]?
//                        ^^^ definition com/airbnb/epoxy/PoolReference#getContext(). public final fun <get-context>(): [ERROR : Context]?
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#contextReference.
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#getContextReference().
//                                                 ^^^ reference java/lang/ref/WeakReference#get().

    fun clearIfDestroyed() {
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#clearIfDestroyed(). public final fun clearIfDestroyed()
        parent.clearIfDestroyed(this)
//      ^^^^^^ reference com/airbnb/epoxy/PoolReference#parent.
//      ^^^^^^ reference com/airbnb/epoxy/PoolReference#getParent().
//             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().
//                              ^^^^ reference com/airbnb/epoxy/PoolReference#
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
//   ^^^^^^^^^^^^^^^^ reference androidx/lifecycle/OnLifecycleEvent#`<init>`().
//                    ^^^^^^^^^ reference androidx/lifecycle/Lifecycle#
//                              ^^^^^ reference androidx/lifecycle/Lifecycle#Event#
//                                    ^^^^^^^^^^ reference androidx/lifecycle/Lifecycle#Event#ON_DESTROY#
    fun onContextDestroyed() {
//      ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#onContextDestroyed(). public final fun onContextDestroyed()
        clearIfDestroyed()
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#clearIfDestroyed().
    }
}

internal fun Context?.isActivityDestroyed(): Boolean {
//                    ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPoolKt#isActivityDestroyed(). internal fun [ERROR : Context]?.isActivityDestroyed(): kotlin.Boolean
//                                           ^^^^^^^ reference kotlin/Boolean#
    if (this == null) {
//      ^^^^ reference com/airbnb/epoxy/ActivityRecyclerPoolKt#isActivityDestroyed().
        return true
    }

    if (this !is Activity) {
//      ^^^^ reference com/airbnb/epoxy/ActivityRecyclerPoolKt#isActivityDestroyed().
        return (this as? ContextWrapper)?.baseContext?.isActivityDestroyed() ?: false
//              ^^^^ reference com/airbnb/epoxy/ActivityRecyclerPoolKt#isActivityDestroyed().
    }

    if (isFinishing) {
        return true
    }

    return if (Build.VERSION.SDK_INT >= 17) {
        isDestroyed
    } else {
        // Use this as a proxy for being destroyed on older devices
        !ViewCompat.isAttachedToWindow(window.decorView)
    }
}
