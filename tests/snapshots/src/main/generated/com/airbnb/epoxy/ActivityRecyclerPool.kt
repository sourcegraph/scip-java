package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import androidx.core.view.ViewCompat
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import androidx.lifecycle.Lifecycle
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^ reference semanticdb maven . . androidx/lifecycle/
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/Lifecycle#
import androidx.lifecycle.LifecycleObserver
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^ reference semanticdb maven . . androidx/lifecycle/
//                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/LifecycleObserver#
import androidx.lifecycle.LifecycleOwner
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^ reference semanticdb maven . . androidx/lifecycle/
//                        ^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/LifecycleOwner#
import androidx.lifecycle.OnLifecycleEvent
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^ reference semanticdb maven . . androidx/lifecycle/
//                        ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/OnLifecycleEvent#
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import java.lang.ref.WeakReference
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^ reference semanticdb maven . . java/lang/ref/
//                   ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/ref/WeakReference#
import java.util.ArrayList
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#

internal class ActivityRecyclerPool {
//             ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#
//                                  display_name ActivityRecyclerPool
//                                  documentation ```kt\ninternal final class ActivityRecyclerPool\n```
//             ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#`<init>`().
//                                  display_name ActivityRecyclerPool
//                                  documentation ```kt\npublic constructor ActivityRecyclerPool()\n```

    /**
     * Store one unique pool per activity. They are cleared out when activities are destroyed, so this
     * only needs to hold pools for active activities.
     */
    private val pools = ArrayList<PoolReference>(5)
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPools().
//                    display_name pools
//                    documentation ```kt\nprivate final val pools: java.util.ArrayList<com.airbnb.epoxy.PoolReference>\n```\n\n----\n\n\n Store one unique pool per activity. They are cleared out when activities are destroyed, so this\n only needs to hold pools for active activities.\n
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#pools.
//                    display_name pools
//                    documentation ```kt\nprivate final val pools: java.util.ArrayList<com.airbnb.epoxy.PoolReference>\n```\n\n----\n\n\n Store one unique pool per activity. They are cleared out when activities are destroyed, so this\n only needs to hold pools for active activities.\n
//                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#

    @JvmOverloads
//   ^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/jvm/JvmOverloads#`<init>`().
    fun getPool(
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPool().
//              display_name getPool
//              documentation ```kt\npublic final fun getPool(context: [Error type: Unresolved type for Context], poolFactory: () -> [Error type: Unresolved type for RecyclerView.RecycledViewPool]): com.airbnb.epoxy.PoolReference\n```
        context: Context,
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPool().(context)
//              display_name context
//              documentation ```kt\nvalue-parameter context: [Error type: Unresolved type for Context]\n```
        poolFactory: () -> RecyclerView.RecycledViewPool
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPool().(poolFactory)
//                  display_name poolFactory
//                  documentation ```kt\nvalue-parameter poolFactory: () -> [Error type: Unresolved type for RecyclerView.RecycledViewPool]\n```
    ): PoolReference {
//     ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#

        val iterator = pools.iterator()
//          ^^^^^^^^ definition local 0
//                   display_name iterator
//                   documentation ```kt\nval iterator: kotlin.collections.MutableIterator<com.airbnb.epoxy.PoolReference>\n```
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPools().
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#pools.
//                           ^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#iterator().
        var poolToUse: PoolReference? = null
//          ^^^^^^^^^ definition local 1
//                    display_name poolToUse
//                    documentation ```kt\nvar poolToUse: com.airbnb.epoxy.PoolReference?\n```
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#

        while (iterator.hasNext()) {
//             ^^^^^^^^ reference local 0
//                      ^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#hasNext().
            val poolReference = iterator.next()
//              ^^^^^^^^^^^^^ definition local 2
//                            display_name poolReference
//                            documentation ```kt\nval poolReference: com.airbnb.epoxy.PoolReference\n```
//                              ^^^^^^^^ reference local 0
//                                       ^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#next().
            when {
                poolReference.context === context -> {
//              ^^^^^^^^^^^^^ reference local 2
//                            ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#context.
//                                        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPool().(context)
                    if (poolToUse != null) {
//                      ^^^^^^^^^ reference local 1
//                                ^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#equals(+-1).
                        throw IllegalStateException("A pool was already found")
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/IllegalStateException#`<init>`(+1).
                    }
                    poolToUse = poolReference
//                  ^^^^^^^^^ reference local 1
//                              ^^^^^^^^^^^^^ reference local 2
                    // finish iterating to remove any old contexts
                }
                poolReference.context.isActivityDestroyed() -> {
//              ^^^^^^^^^^^^^ reference local 2
//                            ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#context.
                    // A pool from a different activity that was destroyed.
                    // Clear the pool references to allow the activity to be GC'd
                    poolReference.viewPool.clear()
//                  ^^^^^^^^^^^^^ reference local 2
//                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#getViewPool().
//                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#viewPool.
                    iterator.remove()
//                  ^^^^^^^^ reference local 0
//                           ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#remove().
                }
            }
        }

        if (poolToUse == null) {
//          ^^^^^^^^^ reference local 1
//                    ^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#equals(+-1).
            poolToUse = PoolReference(context, poolFactory(), this)
//          ^^^^^^^^^ reference local 1
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#`<init>`().
//                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPool().(context)
//                                             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPool().(poolFactory)
//                                                            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#
            context.lifecycle()?.addObserver(poolToUse)
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPool().(context)
//                                           ^^^^^^^^^ reference local 1
            pools.add(poolToUse)
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPools().
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#pools.
//                ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add(+1).
//                    ^^^^^^^^^ reference local 1
        }

        return poolToUse
//             ^^^^^^^^^ reference local 1
    }

    fun clearIfDestroyed(pool: PoolReference) {
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().
//                       display_name clearIfDestroyed
//                       documentation ```kt\npublic final fun clearIfDestroyed(pool: com.airbnb.epoxy.PoolReference)\n```
//                       ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().(pool)
//                            display_name pool
//                            documentation ```kt\nvalue-parameter pool: com.airbnb.epoxy.PoolReference\n```
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#
        if (pool.context.isActivityDestroyed()) {
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().(pool)
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#context.
            pool.viewPool.clear()
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().(pool)
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#getViewPool().
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#viewPool.
            pools.remove(pool)
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPools().
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#pools.
//                ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#remove().
//                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().(pool)
        }
    }

    private fun Context.lifecycle(): Lifecycle? {
//                      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#lifecycle().
//                                display_name lifecycle
//                                documentation ```kt\nprivate final fun [Error type: Unresolved type for Context].lifecycle(): androidx.lifecycle.Lifecycle?\n```
//                                   ^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/Lifecycle#
        if (this is LifecycleOwner) {
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#lifecycle().
//                  ^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/LifecycleOwner#
            return lifecycle
        }

        if (this is ContextWrapper) {
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#lifecycle().
            return baseContext.lifecycle()
        }

        return null
    }
}

internal class PoolReference(
//             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#
//                           display_name PoolReference
//                           documentation ```kt\ninternal final class PoolReference : androidx.lifecycle.LifecycleObserver\n```
//                           relationship is_reference is_implementation semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/LifecycleObserver#
//             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#`<init>`().
//                           display_name PoolReference
//                           documentation ```kt\npublic constructor PoolReference(context: [Error type: Unresolved type for Context], viewPool: [Error type: Unresolved type for RecyclerView.RecycledViewPool], parent: com.airbnb.epoxy.ActivityRecyclerPool)\n```
    context: Context,
//  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#`<init>`().(context)
//          display_name context
//          documentation ```kt\nvalue-parameter context: [Error type: Unresolved type for Context]\n```
    val viewPool: RecyclerView.RecycledViewPool,
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#`<init>`().(viewPool)
//               display_name viewPool
//               documentation ```kt\nvalue-parameter viewPool: [Error type: Unresolved type for RecyclerView.RecycledViewPool]\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#getViewPool().
//               display_name viewPool
//               documentation ```kt\npublic final val viewPool: [Error type: Unresolved type for RecyclerView.RecycledViewPool]\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#viewPool.
//               display_name viewPool
//               documentation ```kt\npublic final val viewPool: [Error type: Unresolved type for RecyclerView.RecycledViewPool]\n```
    private val parent: ActivityRecyclerPool
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#`<init>`().(parent)
//                     display_name parent
//                     documentation ```kt\nvalue-parameter parent: com.airbnb.epoxy.ActivityRecyclerPool\n```
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#getParent().
//                     display_name parent
//                     documentation ```kt\nprivate final val parent: com.airbnb.epoxy.ActivityRecyclerPool\n```
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#parent.
//                     display_name parent
//                     documentation ```kt\nprivate final val parent: com.airbnb.epoxy.ActivityRecyclerPool\n```
//                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#
) : LifecycleObserver {
//  ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/LifecycleObserver#
    private val contextReference: WeakReference<Context> = WeakReference(context)
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#contextReference.
//                               display_name contextReference
//                               documentation ```kt\nprivate final val contextReference: java.lang.ref.WeakReference<[Error type: Unresolved type for Context]>\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#getContextReference().
//                               display_name contextReference
//                               documentation ```kt\nprivate final val contextReference: java.lang.ref.WeakReference<[Error type: Unresolved type for Context]>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/ref/WeakReference#
//                                                         ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/ref/WeakReference#`<init>`().
//                                                                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#`<init>`().(context)

    val context: Context? get() = contextReference.get()
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#context.
//              display_name context
//              documentation ```kt\npublic final val context: [Error type: Unresolved type for Context]?\n```
//                        ^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#getContext().
//                            display_name get
//                            documentation ```kt\npublic final fun `<get-context>`(): [Error type: Unresolved type for Context]?\n```
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#contextReference.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#getContextReference().
//                                                 ^^^ reference semanticdb maven jdk 11 java/lang/ref/WeakReference#get().

    fun clearIfDestroyed() {
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#clearIfDestroyed().
//                       display_name clearIfDestroyed
//                       documentation ```kt\npublic final fun clearIfDestroyed()\n```
        parent.clearIfDestroyed(this)
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#getParent().
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#parent.
//             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#clearIfDestroyed().
//                              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
//   ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/OnLifecycleEvent#`<init>`().
//                    ^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/Lifecycle#
//                              ^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/Lifecycle#Event#
//                                    ^^^^^^^^^^ reference semanticdb maven maven/androidx.lifecycle/lifecycle-common 2.0.0 androidx/lifecycle/Lifecycle#Event#ON_DESTROY#
    fun onContextDestroyed() {
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/PoolReference#onContextDestroyed().
//                         display_name onContextDestroyed
//                         documentation ```kt\npublic final fun onContextDestroyed()\n```
        clearIfDestroyed()
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#clearIfDestroyed().
    }
}

internal fun Context?.isActivityDestroyed(): Boolean {
//                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPoolKt#isActivityDestroyed().
//                                        display_name isActivityDestroyed
//                                        documentation ```kt\ninternal fun [Error type: Unresolved type for Context]?.isActivityDestroyed(): kotlin.Boolean\n```
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    if (this == null) {
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPoolKt#isActivityDestroyed().
        return true
    }

    if (this !is Activity) {
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPoolKt#isActivityDestroyed().
        return (this as? ContextWrapper)?.baseContext?.isActivityDestroyed() ?: false
//              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPoolKt#isActivityDestroyed().
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
