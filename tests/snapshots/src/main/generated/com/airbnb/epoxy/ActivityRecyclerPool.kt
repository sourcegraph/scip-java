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
//             ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#
//             ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#`<init>`().

    /**
     * Store one unique pool per activity. They are cleared out when activities are destroyed, so this
     * only needs to hold pools for active activities.
     */
    private val pools = ArrayList<PoolReference>(5)
//              ^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#pools.
//              ^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#getPools().
//                      ^^^^^^^^^ reference java/util/ArrayList#`<init>`().
//                                ^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#

    @JvmOverloads
//   ^^^^^^^^^^^^ reference kotlin/jvm/JvmOverloads#`<init>`().
    fun getPool(
//      ^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#getPool().
        context: Context,
//      ^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#getPool().(context)
        poolFactory: () -> RecyclerView.RecycledViewPool
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#getPool().(poolFactory)
    ): PoolReference {
//     ^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#

        val iterator = pools.iterator()
//          ^^^^^^^^ definition local0
//                     ^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#pools.
//                     ^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#getPools().
//                           ^^^^^^^^ reference java/util/ArrayList#iterator().
        var poolToUse: PoolReference? = null
//          ^^^^^^^^^ definition local1
//                     ^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#

        while (iterator.hasNext()) {
//             ^^^^^^^^ reference local0
//                      ^^^^^^^ reference kotlin/collections/MutableIterator#hasNext().
            val poolReference = iterator.next()
//              ^^^^^^^^^^^^^ definition local2
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
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().
//                       ^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().(pool)
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
//                      ^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPool#lifecycle().
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
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#`<init>`().
    context: Context,
//  ^^^^^^^ definition com/airbnb/epoxy/PoolReference#`<init>`().(context)
    val viewPool: RecyclerView.RecycledViewPool,
//      ^^^^^^^^ definition com/airbnb/epoxy/PoolReference#viewPool.
//      ^^^^^^^^ definition com/airbnb/epoxy/PoolReference#getViewPool().
//      ^^^^^^^^ definition com/airbnb/epoxy/PoolReference#`<init>`().(viewPool)
    private val parent: ActivityRecyclerPool
//              ^^^^^^ definition com/airbnb/epoxy/PoolReference#parent.
//              ^^^^^^ definition com/airbnb/epoxy/PoolReference#getParent().
//              ^^^^^^ definition com/airbnb/epoxy/PoolReference#`<init>`().(parent)
//                      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ActivityRecyclerPool#
) : LifecycleObserver {
//  ^^^^^^^^^^^^^^^^^ reference androidx/lifecycle/LifecycleObserver#
    private val contextReference: WeakReference<Context> = WeakReference(context)
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#contextReference.
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#getContextReference().
//                                ^^^^^^^^^^^^^ reference java/lang/ref/WeakReference#
//                                                         ^^^^^^^^^^^^^ reference java/lang/ref/WeakReference#`<init>`().
//                                                                       ^^^^^^^ reference com/airbnb/epoxy/PoolReference#`<init>`().(context)

    val context: Context? get() = contextReference.get()
//      ^^^^^^^ definition com/airbnb/epoxy/PoolReference#context.
//                        ^^^ definition com/airbnb/epoxy/PoolReference#getContext().
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#contextReference.
//                                ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#getContextReference().
//                                                 ^^^ reference java/lang/ref/WeakReference#get().

    fun clearIfDestroyed() {
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#clearIfDestroyed().
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
//      ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/PoolReference#onContextDestroyed().
        clearIfDestroyed()
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/PoolReference#clearIfDestroyed().
    }
}

internal fun Context?.isActivityDestroyed(): Boolean {
//                    ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ActivityRecyclerPoolKt#isActivityDestroyed().
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
