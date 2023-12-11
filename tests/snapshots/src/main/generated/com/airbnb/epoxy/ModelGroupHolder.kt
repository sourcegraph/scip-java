package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.view.ViewStub
import androidx.annotation.VisibleForTesting
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import com.airbnb.viewmodeladapter.R
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
import java.util.ArrayList
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#

class ModelGroupHolder(private val modelGroupParent: ViewParent) : EpoxyHolder() {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#
//                     display_name ModelGroupHolder
//                     documentation ```kt\npublic final class ModelGroupHolder\n```
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#`<init>`().
//                     display_name ModelGroupHolder
//                     documentation ```kt\npublic constructor ModelGroupHolder(modelGroupParent: [Error type: Unresolved type for ViewParent])\n```
//                                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#`<init>`().(modelGroupParent)
//                                                  display_name modelGroupParent
//                                                  documentation ```kt\nvalue-parameter modelGroupParent: [Error type: Unresolved type for ViewParent]\n```
//                                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getModelGroupParent().
//                                                  display_name modelGroupParent
//                                                  documentation ```kt\nprivate final val modelGroupParent: [Error type: Unresolved type for ViewParent]\n```
//                                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#modelGroupParent.
//                                                  display_name modelGroupParent
//                                                  documentation ```kt\nprivate final val modelGroupParent: [Error type: Unresolved type for ViewParent]\n```
    val viewHolders = ArrayList<EpoxyViewHolder>(4)
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//                  display_name viewHolders
//                  documentation ```kt\npublic final val viewHolders: [Error type: Not found recorded type for ArrayList<EpoxyViewHolder>(4)]\n```
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//                  display_name viewHolders
//                  documentation ```kt\npublic final val viewHolders: [Error type: Not found recorded type for ArrayList<EpoxyViewHolder>(4)]\n```

    /** Use parent pool or create a local pool */
    @VisibleForTesting
//   ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#`<init>`().
    val viewPool = findViewPool(modelGroupParent)
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewPool().
//               display_name viewPool
//               documentation ```kt\npublic final val viewPool: [Error type: Unresolved type for RecyclerView.RecycledViewPool]\n```\n\n----\n\n Use parent pool or create a local pool
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewPool.
//               display_name viewPool
//               documentation ```kt\npublic final val viewPool: [Error type: Unresolved type for RecyclerView.RecycledViewPool]\n```\n\n----\n\n Use parent pool or create a local pool
//                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getModelGroupParent().
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#modelGroupParent.

    /**
     * Get the root view group (aka
     * [androidx.recyclerview.widget.RecyclerView.ViewHolder.itemView].
     * You can override [EpoxyModelGroup.bind] and use this method to make custom
     * changes to the root view.
     */
    lateinit var rootView: ViewGroup
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getRootView().
//                        display_name rootView
//                        documentation ```kt\npublic final lateinit var rootView: [Error type: Unresolved type for ViewGroup]\n```\n\n----\n\n\n Get the root view group (aka\n [androidx.recyclerview.widget.RecyclerView.ViewHolder.itemView].\n You can override [EpoxyModelGroup.bind] and use this method to make custom\n changes to the root view.\n
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#rootView.
//                        display_name rootView
//                        documentation ```kt\npublic final lateinit var rootView: [Error type: Unresolved type for ViewGroup]\n```\n\n----\n\n\n Get the root view group (aka\n [androidx.recyclerview.widget.RecyclerView.ViewHolder.itemView].\n You can override [EpoxyModelGroup.bind] and use this method to make custom\n changes to the root view.\n
        private set
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setRootView().
//                  display_name set
//                  documentation ```kt\nprivate final fun `<set-rootView>`(`<set-?>`: [Error type: Unresolved type for ViewGroup])\n```

    private lateinit var childContainer: ViewGroup
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#childContainer.
//                                      display_name childContainer
//                                      documentation ```kt\nprivate final lateinit var childContainer: [Error type: Unresolved type for ViewGroup]\n```
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//                                      display_name childContainer
//                                      documentation ```kt\nprivate final lateinit var childContainer: [Error type: Unresolved type for ViewGroup]\n```
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
//                                      display_name childContainer
//                                      documentation ```kt\nprivate final lateinit var childContainer: [Error type: Unresolved type for ViewGroup]\n```
    private lateinit var stubs: List<ViewStubData>
//                       ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                             display_name stubs
//                             documentation ```kt\nprivate final lateinit var stubs: kotlin.collections.List<com.airbnb.epoxy.ViewStubData>\n```
//                       ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                             display_name stubs
//                             documentation ```kt\nprivate final lateinit var stubs: kotlin.collections.List<com.airbnb.epoxy.ViewStubData>\n```
//                       ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                             display_name stubs
//                             documentation ```kt\nprivate final lateinit var stubs: kotlin.collections.List<com.airbnb.epoxy.ViewStubData>\n```
//                              ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#
    private var boundGroup: EpoxyModelGroup? = null
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//                         display_name boundGroup
//                         documentation ```kt\nprivate final var boundGroup: [Error type: Unresolved type for EpoxyModelGroup]?\n```
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//                         display_name boundGroup
//                         documentation ```kt\nprivate final var boundGroup: [Error type: Unresolved type for EpoxyModelGroup]?\n```
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().
//                         display_name boundGroup
//                         documentation ```kt\nprivate final var boundGroup: [Error type: Unresolved type for EpoxyModelGroup]?\n```

    private fun usingStubs(): Boolean = stubs.isNotEmpty()
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#usingStubs().
//                         display_name usingStubs
//                         documentation ```kt\nprivate final fun usingStubs(): kotlin.Boolean\n```
//                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                                            ^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#isNotEmpty(+9).

    override fun bindView(itemView: View) {
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindView().
//                        display_name bindView
//                        documentation ```kt\npublic open fun bindView(itemView: [Error type: Unresolved type for View])\n```
//                        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindView().(itemView)
//                                 display_name itemView
//                                 documentation ```kt\nvalue-parameter itemView: [Error type: Unresolved type for View]\n```
        if (itemView !is ViewGroup) {
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindView().(itemView)
            throw IllegalStateException(
//                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/IllegalStateException#`<init>`(+1).
                "The layout provided to EpoxyModelGroup must be a ViewGroup"
            )
        }

        rootView = itemView
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getRootView().
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#rootView.
//                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindView().(itemView)
        childContainer = findChildContainer(rootView)
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#childContainer.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#findChildContainer().
//                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getRootView().
//                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#rootView.

        stubs = if (childContainer.childCount != 0) {
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#childContainer.
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
            createViewStubData(childContainer)
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#createViewStubData().
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#childContainer.
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
        } else {
            emptyList()
//          ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#emptyList().
        }
    }

    /**
     * By default the outermost viewgroup is used as the container that views are added to. However,
     * users can specify a different, nested view group to use as the child container by marking it
     * with a special id.
     */
    private fun findChildContainer(outermostRoot: ViewGroup): ViewGroup {
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#findChildContainer().
//                                 display_name findChildContainer
//                                 documentation ```kt\nprivate final fun findChildContainer(outermostRoot: [Error type: Unresolved type for ViewGroup]): [Error type: Unresolved type for ViewGroup]\n```\n\n----\n\n\n By default the outermost viewgroup is used as the container that views are added to. However,\n users can specify a different, nested view group to use as the child container by marking it\n with a special id.\n
//                                 ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)
//                                               display_name outermostRoot
//                                               documentation ```kt\nvalue-parameter outermostRoot: [Error type: Unresolved type for ViewGroup]\n```
        val customRoot = outermostRoot.findViewById<View>(R.id.epoxy_model_group_child_container)
//          ^^^^^^^^^^ definition local 0
//                     display_name customRoot
//                     documentation ```kt\nval customRoot: [Error type: Return type for function cannot be resolved]\n```
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)

        return customRoot as? ViewGroup ?: outermostRoot
//             ^^^^^^^^^^ reference local 0
//                                         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)
    }

    private fun createViewStubData(viewGroup: ViewGroup): List<ViewStubData> {
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#createViewStubData().
//                                 display_name createViewStubData
//                                 documentation ```kt\nprivate final fun createViewStubData(viewGroup: [Error type: Unresolved type for ViewGroup]): kotlin.collections.List<com.airbnb.epoxy.ViewStubData>\n```
//                                 ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#createViewStubData().(viewGroup)
//                                           display_name viewGroup
//                                           documentation ```kt\nvalue-parameter viewGroup: [Error type: Unresolved type for ViewGroup]\n```
//                                                        ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#
        return ArrayList<ViewStubData>(4).apply {
//             ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
//                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#
//                                        ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/StandardKt#apply().

            collectViewStubs(viewGroup, this)
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().
//                           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#createViewStubData().(viewGroup)

            if (isEmpty()) {
//              ^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#isEmpty().
                throw IllegalStateException(
//                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/IllegalStateException#`<init>`(+1).
                    "No view stubs found. If viewgroup is not empty it must contain ViewStubs."
                )
            }
        }
    }

    private fun collectViewStubs(
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().
//                               display_name collectViewStubs
//                               documentation ```kt\nprivate final fun collectViewStubs(viewGroup: [Error type: Unresolved type for ViewGroup], stubs: java.util.ArrayList<com.airbnb.epoxy.ViewStubData>)\n```
        viewGroup: ViewGroup,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
//                display_name viewGroup
//                documentation ```kt\nvalue-parameter viewGroup: [Error type: Unresolved type for ViewGroup]\n```
        stubs: ArrayList<ViewStubData>
//      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(stubs)
//            display_name stubs
//            documentation ```kt\nvalue-parameter stubs: java.util.ArrayList<com.airbnb.epoxy.ViewStubData>\n```
//             ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#
    ) {
        for (i in 0 until viewGroup.childCount) {
//           ^ definition local 1
//             display_name i
//             documentation ```kt\nval i: kotlin.Int\n```
//                  ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
            val child = viewGroup.getChildAt(i)
//              ^^^^^ definition local 2
//                    display_name child
//                    documentation ```kt\nval child: [Error type: Return type for function cannot be resolved]\n```
//                      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
//                                           ^ reference local 1

            if (child is ViewGroup) {
//              ^^^^^ reference local 2
                collectViewStubs(child, stubs)
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().
//                               ^^^^^ reference local 2
//                                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(stubs)
            } else if (child is ViewStub) {
//                     ^^^^^ reference local 2
                stubs.add(ViewStubData(viewGroup, child, i))
//              ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(stubs)
//                    ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add(+1).
//                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#`<init>`().
//                                     ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
//                                                ^^^^^ reference local 2
//                                                       ^ reference local 1
            }
        }
    }

    fun bindGroupIfNeeded(group: EpoxyModelGroup) {
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().
//                        display_name bindGroupIfNeeded
//                        documentation ```kt\npublic final fun bindGroupIfNeeded(group: [Error type: Unresolved type for EpoxyModelGroup])\n```
//                        ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
//                              display_name group
//                              documentation ```kt\nvalue-parameter group: [Error type: Unresolved type for EpoxyModelGroup]\n```
        val previouslyBoundGroup = this.boundGroup
//          ^^^^^^^^^^^^^^^^^^^^ definition local 3
//                               display_name previouslyBoundGroup
//                               documentation ```kt\nval previouslyBoundGroup: [Error type: Unresolved type for EpoxyModelGroup]?\n```
//                                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().

        if (previouslyBoundGroup === group) {
//          ^^^^^^^^^^^^^^^^^^^^ reference local 3
//                                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
            return
        } else if (previouslyBoundGroup != null) {
//                 ^^^^^^^^^^^^^^^^^^^^ reference local 3
            // A different group is being bound; this can happen when an onscreen model is changed.
            // The models or their layouts could have changed, so views may need to be updated

            if (previouslyBoundGroup.models.size > group.models.size) {
//              ^^^^^^^^^^^^^^^^^^^^ reference local 3
//                                                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
                for (i in previouslyBoundGroup.models.size - 1 downTo group.models.size) {
//                   ^ definition local 4
//                     display_name i
//                     documentation ```kt\nval i: [Error type: Return type for function cannot be resolved]\n```
//                        ^^^^^^^^^^^^^^^^^^^^ reference local 3
//                                                                    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
                    removeAndRecycleView(i)
//                  ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().
//                                       ^ reference local 4
                }
            }
        }

        this.boundGroup = group
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().
//                        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
        val models = group.models
//          ^^^^^^ definition local 5
//                 display_name models
//                 documentation ```kt\nval models: [Error type: Error property type]\n```
//                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
        val modelCount = models.size
//          ^^^^^^^^^^ definition local 6
//                     display_name modelCount
//                     documentation ```kt\nval modelCount: [Error type: Error property type]\n```
//                       ^^^^^^ reference local 5

        if (usingStubs() && stubs.size < modelCount) {
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#usingStubs().
//                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                                ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                                       ^^^^^^^^^^ reference local 6
            throw IllegalStateException(
//                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/IllegalStateException#`<init>`(+1).
                "Insufficient view stubs for EpoxyModelGroup. $modelCount models were provided but only ${stubs.size} view stubs exist."
//                                                             ^^^^^^^^^^ reference local 6
//                                                                                                        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                                                                                                        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                                                                                                        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                                                                                                              ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                                                                                                              ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
            )
        }
        viewHolders.ensureCapacity(modelCount)
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//                                 ^^^^^^^^^^ reference local 6

        for (i in 0 until modelCount) {
//           ^ definition local 7
//             display_name i
//             documentation ```kt\nval i: kotlin.Int\n```
//                  ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^^ reference local 6
            val model = models[i]
//              ^^^^^ definition local 8
//                    display_name model
//                    documentation ```kt\nval model: [Error type: Return type for function cannot be resolved]\n```
//                      ^^^^^^ reference local 5
//                             ^ reference local 7
            val previouslyBoundModel = previouslyBoundGroup?.models?.getOrNull(i)
//              ^^^^^^^^^^^^^^^^^^^^ definition local 9
//                                   display_name previouslyBoundModel
//                                   documentation ```kt\nval previouslyBoundModel: [Error type: Return type for function cannot be resolved]?\n```
//                                     ^^^^^^^^^^^^^^^^^^^^ reference local 3
//                                                                             ^ reference local 7
            val stubData = stubs.getOrNull(i)
//              ^^^^^^^^ definition local 10
//                       display_name stubData
//                       documentation ```kt\nval stubData: com.airbnb.epoxy.ViewStubData?\n```
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                               ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#getOrNull(+9).
//                                         ^ reference local 7
            val parent = stubData?.viewGroup ?: childContainer
//              ^^^^^^ definition local 11
//                     display_name parent
//                     documentation ```kt\nval parent: ???\n```
//                       ^^^^^^^^ reference local 10
//                                 ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewGroup().
//                                 ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewGroup.
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#childContainer.
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setChildContainer().

            if (previouslyBoundModel != null) {
//              ^^^^^^^^^^^^^^^^^^^^ reference local 9
                if (areSameViewType(previouslyBoundModel, model)) {
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().
//                                  ^^^^^^^^^^^^^^^^^^^^ reference local 9
//                                                        ^^^^^ reference local 8
                    continue
                }

                removeAndRecycleView(i)
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().
//                                   ^ reference local 7
            }

            val holder = getViewHolder(parent, model)
//              ^^^^^^ definition local 12
//                     display_name holder
//                     documentation ```kt\nval holder: [Error type: Unresolved type for EpoxyViewHolder]\n```
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().
//                                     ^^^^^^ reference local 11
//                                             ^^^^^ reference local 8

            if (stubData == null) {
//              ^^^^^^^^ reference local 10
//                       ^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#equals(+-1).
                childContainer.addView(holder.itemView, i)
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#childContainer.
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
//                                     ^^^^^^ reference local 12
//                                                      ^ reference local 7
            } else {
                stubData.setView(holder.itemView, group.useViewStubLayoutParams(model, i))
//              ^^^^^^^^ reference local 10
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().
//                               ^^^^^^ reference local 12
//                                                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
//                                                                              ^^^^^ reference local 8
//                                                                                     ^ reference local 7
            }

            viewHolders.add(i, holder)
//          ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//          ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//                          ^ reference local 7
//                             ^^^^^^ reference local 12
        }
    }

    private fun areSameViewType(model1: EpoxyModel<*>, model2: EpoxyModel<*>?): Boolean {
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().
//                              display_name areSameViewType
//                              documentation ```kt\nprivate final fun areSameViewType(model1: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>, model2: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>?): kotlin.Boolean\n```
//                              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model1)
//                                     display_name model1
//                                     documentation ```kt\nvalue-parameter model1: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>\n```
//                                                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model2)
//                                                            display_name model2
//                                                            documentation ```kt\nvalue-parameter model2: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>?\n```
//                                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        return ViewTypeManager.getViewType(model1) == ViewTypeManager.getViewType(model2)
//                                         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model1)
//                                                                                ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model2)
    }

    private fun getViewHolder(parent: ViewGroup, model: EpoxyModel<*>): EpoxyViewHolder {
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().
//                            display_name getViewHolder
//                            documentation ```kt\nprivate final fun getViewHolder(parent: [Error type: Unresolved type for ViewGroup], model: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>): [Error type: Unresolved type for EpoxyViewHolder]\n```
//                            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(parent)
//                                   display_name parent
//                                   documentation ```kt\nvalue-parameter parent: [Error type: Unresolved type for ViewGroup]\n```
//                                               ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)
//                                                     display_name model
//                                                     documentation ```kt\nvalue-parameter model: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>\n```
        val viewType = ViewTypeManager.getViewType(model)
//          ^^^^^^^^ definition local 13
//                   display_name viewType
//                   documentation ```kt\nval viewType: [Error type: Return type for function cannot be resolved]\n```
//                                                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)
        val recycledView = viewPool.getRecycledView(viewType)
//          ^^^^^^^^^^^^ definition local 14
//                       display_name recycledView
//                       documentation ```kt\nval recycledView: [Error type: Return type for function cannot be resolved]\n```
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewPool().
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewPool.
//                                                  ^^^^^^^^ reference local 13

        return recycledView as? EpoxyViewHolder
//             ^^^^^^^^^^^^ reference local 14
            ?: HELPER_ADAPTER.createViewHolder(
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#HELPER_ADAPTER.
//             ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#getHELPER_ADAPTER().
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().
                modelGroupParent,
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getModelGroupParent().
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#modelGroupParent.
                model,
//              ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)
                parent,
//              ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(parent)
                viewType
//              ^^^^^^^^ reference local 13
            )
    }

    fun unbindGroup() {
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#unbindGroup().
//                  display_name unbindGroup
//                  documentation ```kt\npublic final fun unbindGroup()\n```
        if (boundGroup == null) {
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().
            throw IllegalStateException("Group is not bound")
//                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/IllegalStateException#`<init>`(+1).
        }

        repeat(viewHolders.size) {
//      ^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/StandardKt#repeat().
//             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewHolders.
            // Remove from the end for more efficient list actions
            removeAndRecycleView(viewHolders.size - 1)
//          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().
//                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewHolders.
        }

        boundGroup = null
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().
    }

    private fun removeAndRecycleView(modelPosition: Int) {
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().
//                                   display_name removeAndRecycleView
//                                   documentation ```kt\nprivate final fun removeAndRecycleView(modelPosition: kotlin.Int)\n```
//                                   ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)
//                                                 display_name modelPosition
//                                                 documentation ```kt\nvalue-parameter modelPosition: kotlin.Int\n```
//                                                  ^^^ reference semanticdb maven . . kotlin/Int#
        if (usingStubs()) {
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#usingStubs().
            stubs[modelPosition].resetStub()
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)
//                               ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#resetStub().
        } else {
            childContainer.removeViewAt(modelPosition)
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#childContainer.
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)
        }

        val viewHolder = viewHolders.removeAt(modelPosition)
//          ^^^^^^^^^^ definition local 15
//                     display_name viewHolder
//                     documentation ```kt\nval viewHolder: [Error type: Return type for function cannot be resolved]\n```
//                       ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//                       ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)
        viewHolder.unbind()
//      ^^^^^^^^^^ reference local 15
        viewPool.putRecycledView(viewHolder)
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewPool().
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewPool.
//                               ^^^^^^^^^^ reference local 15
    }

    companion object {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion# 1:0
//                     display_name Companion
//                     documentation ```kt\npublic companion object\n```

        private val HELPER_ADAPTER = HelperAdapter()
//                  ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#HELPER_ADAPTER.
//                                 display_name HELPER_ADAPTER
//                                 documentation ```kt\nprivate final val HELPER_ADAPTER: com.airbnb.epoxy.HelperAdapter\n```
//                  ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#getHELPER_ADAPTER().
//                                 display_name HELPER_ADAPTER
//                                 documentation ```kt\nprivate final val HELPER_ADAPTER: com.airbnb.epoxy.HelperAdapter\n```
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#`<init>`().

        private fun findViewPool(view: ViewParent): RecyclerView.RecycledViewPool {
//                  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().
//                               display_name findViewPool
//                               documentation ```kt\nprivate final fun findViewPool(view: [Error type: Unresolved type for ViewParent]): [Error type: Unresolved type for RecyclerView.RecycledViewPool]\n```
//                               ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
//                                    display_name view
//                                    documentation ```kt\nvalue-parameter view: [Error type: Unresolved type for ViewParent]\n```
            var viewPool: RecyclerView.RecycledViewPool? = null
//              ^^^^^^^^ definition local 16
//                       display_name viewPool
//                       documentation ```kt\nvar viewPool: [Error type: Unresolved type for RecyclerView.RecycledViewPool]?\n```
            while (viewPool == null) {
//                 ^^^^^^^^ reference local 16
                viewPool = if (view is RecyclerView) {
//              ^^^^^^^^ reference local 16
//                             ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
                    view.recycledViewPool
//                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
                } else {
                    val parent = view.parent
//                      ^^^^^^ definition local 17
//                             display_name parent
//                             documentation ```kt\nval parent: [Error type: Error property type]\n```
//                               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
                    if (parent is ViewParent) {
//                      ^^^^^^ reference local 17
                        findViewPool(parent)
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().
//                                   ^^^^^^ reference local 17
                    } else {
                        // This model group is is not in a RecyclerView
                        LocalGroupRecycledViewPool()
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/LocalGroupRecycledViewPool#`<init>`().
                    }
                }
            }
            return viewPool
//                 ^^^^^^^^ reference local 16
        }
    }
}

private class ViewStubData(
//            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#
//                         display_name ViewStubData
//                         documentation ```kt\nprivate final class ViewStubData\n```
//            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#`<init>`().
//                         display_name ViewStubData
//                         documentation ```kt\npublic constructor ViewStubData(viewGroup: [Error type: Unresolved type for ViewGroup], viewStub: [Error type: Unresolved type for ViewStub], position: kotlin.Int)\n```
    val viewGroup: ViewGroup,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#`<init>`().(viewGroup)
//                display_name viewGroup
//                documentation ```kt\nvalue-parameter viewGroup: [Error type: Unresolved type for ViewGroup]\n```
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewGroup().
//                display_name viewGroup
//                documentation ```kt\npublic final val viewGroup: [Error type: Unresolved type for ViewGroup]\n```
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewGroup.
//                display_name viewGroup
//                documentation ```kt\npublic final val viewGroup: [Error type: Unresolved type for ViewGroup]\n```
    val viewStub: ViewStub,
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#`<init>`().(viewStub)
//               display_name viewStub
//               documentation ```kt\nvalue-parameter viewStub: [Error type: Unresolved type for ViewStub]\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewStub().
//               display_name viewStub
//               documentation ```kt\npublic final val viewStub: [Error type: Unresolved type for ViewStub]\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewStub.
//               display_name viewStub
//               documentation ```kt\npublic final val viewStub: [Error type: Unresolved type for ViewStub]\n```
    val position: Int
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#`<init>`().(position)
//               display_name position
//               documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#getPosition().
//               display_name position
//               documentation ```kt\npublic final val position: kotlin.Int\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#position.
//               display_name position
//               documentation ```kt\npublic final val position: kotlin.Int\n```
//                ^^^ reference semanticdb maven . . kotlin/Int#
) {

    fun setView(view: View, useStubLayoutParams: Boolean) {
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().
//              display_name setView
//              documentation ```kt\npublic final fun setView(view: [Error type: Unresolved type for View], useStubLayoutParams: kotlin.Boolean)\n```
//              ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().(view)
//                   display_name view
//                   documentation ```kt\nvalue-parameter view: [Error type: Unresolved type for View]\n```
//                          ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().(useStubLayoutParams)
//                                              display_name useStubLayoutParams
//                                              documentation ```kt\nvalue-parameter useStubLayoutParams: kotlin.Boolean\n```
//                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        removeCurrentView()
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#removeCurrentView().

        // Carry over the stub id manually since we aren't inflating via the stub
        val inflatedId = viewStub.inflatedId
//          ^^^^^^^^^^ definition local 18
//                     display_name inflatedId
//                     documentation ```kt\nval inflatedId: [Error type: Error property type]\n```
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewStub().
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewStub.
        if (inflatedId != View.NO_ID) {
//          ^^^^^^^^^^ reference local 18
            view.id = inflatedId
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().(view)
//                    ^^^^^^^^^^ reference local 18
        }

        if (useStubLayoutParams) {
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().(useStubLayoutParams)
            viewGroup.addView(view, position, viewStub.layoutParams)
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewGroup().
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewGroup.
//                            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().(view)
//                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getPosition().
//                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#position.
//                                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewStub().
//                                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewStub.
        } else {
            viewGroup.addView(view, position)
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewGroup().
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewGroup.
//                            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().(view)
//                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getPosition().
//                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#position.
        }
    }

    fun resetStub() {
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#resetStub().
//                display_name resetStub
//                documentation ```kt\npublic final fun resetStub()\n```
        removeCurrentView()
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#removeCurrentView().
        viewGroup.addView(viewStub, position)
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewGroup().
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewGroup.
//                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewStub().
//                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewStub.
//                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getPosition().
//                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#position.
    }

    private fun removeCurrentView() {
//              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#removeCurrentView().
//                                display_name removeCurrentView
//                                documentation ```kt\nprivate final fun removeCurrentView()\n```
        val view = viewGroup.getChildAt(position)
//          ^^^^ definition local 19
//               display_name view
//               documentation ```kt\nval view: kotlin.Nothing\n```
//                 ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewGroup().
//                 ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewGroup.
//                                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getPosition().
//                                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#position.
            ?: throw IllegalStateException("No view exists at position $position")
//                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/IllegalStateException#`<init>`(+1).
//                                                                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getPosition().
//                                                                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#position.
        viewGroup.removeView(view)
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewGroup().
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewGroup.
//                           ^^^^ reference local 19
    }
}

/**
 * Local pool to the [ModelGroupHolder]
 */
private class LocalGroupRecycledViewPool : RecyclerView.RecycledViewPool()
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/LocalGroupRecycledViewPool#
//                                       display_name LocalGroupRecycledViewPool
//                                       documentation ```kt\nprivate final class LocalGroupRecycledViewPool\n```\n\n----\n\n\n Local pool to the [ModelGroupHolder]\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/LocalGroupRecycledViewPool#`<init>`().
//                                       display_name LocalGroupRecycledViewPool
//                                       documentation ```kt\npublic constructor LocalGroupRecycledViewPool()\n```\n\n----\n\n\n Local pool to the [ModelGroupHolder]\n

/**
 * A viewholder's viewtype can only be set internally in an adapter when the viewholder
 * is created. To work around that we do the creation in an adapter.
 */
private class HelperAdapter : RecyclerView.Adapter<EpoxyViewHolder>() {
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#
//                          display_name HelperAdapter
//                          documentation ```kt\nprivate final class HelperAdapter\n```\n\n----\n\n\n A viewholder's viewtype can only be set internally in an adapter when the viewholder\n is created. To work around that we do the creation in an adapter.\n
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#`<init>`().
//                          display_name HelperAdapter
//                          documentation ```kt\npublic constructor HelperAdapter()\n```\n\n----\n\n\n A viewholder's viewtype can only be set internally in an adapter when the viewholder\n is created. To work around that we do the creation in an adapter.\n

    private var model: EpoxyModel<*>? = null
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModel().
//                    display_name model
//                    documentation ```kt\nprivate final var model: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>?\n```
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#model.
//                    display_name model
//                    documentation ```kt\nprivate final var model: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>?\n```
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModel().
//                    display_name model
//                    documentation ```kt\nprivate final var model: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>?\n```
    private var modelGroupParent: ViewParent? = null
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModelGroupParent().
//                               display_name modelGroupParent
//                               documentation ```kt\nprivate final var modelGroupParent: [Error type: Unresolved type for ViewParent]?\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#modelGroupParent.
//                               display_name modelGroupParent
//                               documentation ```kt\nprivate final var modelGroupParent: [Error type: Unresolved type for ViewParent]?\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModelGroupParent().
//                               display_name modelGroupParent
//                               documentation ```kt\nprivate final var modelGroupParent: [Error type: Unresolved type for ViewParent]?\n```

    fun createViewHolder(
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().
//                       display_name createViewHolder
//                       documentation ```kt\npublic final fun createViewHolder(modelGroupParent: [Error type: Unresolved type for ViewParent], model: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>, parent: [Error type: Unresolved type for ViewGroup], viewType: kotlin.Int): [Error type: Unresolved type for EpoxyViewHolder]\n```
        modelGroupParent: ViewParent,
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(modelGroupParent)
//                       display_name modelGroupParent
//                       documentation ```kt\nvalue-parameter modelGroupParent: [Error type: Unresolved type for ViewParent]\n```
        model: EpoxyModel<*>,
//      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(model)
//            display_name model
//            documentation ```kt\nvalue-parameter model: [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>\n```
        parent: ViewGroup,
//      ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(parent)
//             display_name parent
//             documentation ```kt\nvalue-parameter parent: [Error type: Unresolved type for ViewGroup]\n```
        viewType: Int
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(viewType)
//               display_name viewType
//               documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//                ^^^ reference semanticdb maven . . kotlin/Int#
    ): EpoxyViewHolder {
        this.model = model
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#
//           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModel().
//           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#model.
//           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModel().
//                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(model)
        this.modelGroupParent = modelGroupParent
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModelGroupParent().
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#modelGroupParent.
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModelGroupParent().
//                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(modelGroupParent)
        val viewHolder = createViewHolder(parent, viewType)
//          ^^^^^^^^^^ definition local 20
//                     display_name viewHolder
//                     documentation ```kt\nval viewHolder: [Error type: Unresolved type for EpoxyViewHolder]\n```
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().
//                                        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(parent)
//                                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(viewType)
        this.model = null
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#
//           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModel().
//           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#model.
//           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModel().
        this.modelGroupParent = null
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModelGroupParent().
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#modelGroupParent.
//           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModelGroupParent().
        return viewHolder
//             ^^^^^^^^^^ reference local 20
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpoxyViewHolder {
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().
//                                  display_name onCreateViewHolder
//                                  documentation ```kt\npublic open fun onCreateViewHolder(parent: [Error type: Unresolved type for ViewGroup], viewType: kotlin.Int): [Error type: Unresolved type for EpoxyViewHolder]\n```
//                                  ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(parent)
//                                         display_name parent
//                                         documentation ```kt\nvalue-parameter parent: [Error type: Unresolved type for ViewGroup]\n```
//                                                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(viewType)
//                                                              display_name viewType
//                                                              documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//                                                               ^^^ reference semanticdb maven . . kotlin/Int#
        return EpoxyViewHolder(modelGroupParent, model!!.buildView(parent), model!!.shouldSaveViewState())
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModelGroupParent().
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#modelGroupParent.
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModelGroupParent().
//                                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModel().
//                                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#model.
//                                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModel().
//                                                                 ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(parent)
//                                                                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModel().
//                                                                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#model.
//                                                                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModel().
    }

    override fun onBindViewHolder(holder: EpoxyViewHolder, position: Int) {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onBindViewHolder().
//                                display_name onBindViewHolder
//                                documentation ```kt\npublic open fun onBindViewHolder(holder: [Error type: Unresolved type for EpoxyViewHolder], position: kotlin.Int)\n```
//                                ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onBindViewHolder().(holder)
//                                       display_name holder
//                                       documentation ```kt\nvalue-parameter holder: [Error type: Unresolved type for EpoxyViewHolder]\n```
//                                                         ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onBindViewHolder().(position)
//                                                                  display_name position
//                                                                  documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                                                   ^^^ reference semanticdb maven . . kotlin/Int#
    }

    override fun getItemCount() = 1
//               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getItemCount().
//                            display_name getItemCount
//                            documentation ```kt\npublic open fun getItemCount(): kotlin.Int\n```
}
