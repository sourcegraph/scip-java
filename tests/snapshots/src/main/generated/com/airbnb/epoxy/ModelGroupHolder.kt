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
//                     documentation ```kt\npublic final class ModelGroupHolder\n```
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#`<init>`().
//                     documentation ```kt\npublic constructor ModelGroupHolder(modelGroupParent: [ERROR : ViewParent])\n```
//                                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#`<init>`().(modelGroupParent)
//                                                  documentation ```kt\nvalue-parameter modelGroupParent: [ERROR : ViewParent]\n```
//                                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getModelGroupParent().
//                                                  documentation ```kt\nprivate final val modelGroupParent: [ERROR : ViewParent]\n```
//                                 ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#modelGroupParent.
//                                                  documentation ```kt\nprivate final val modelGroupParent: [ERROR : ViewParent]\n```
    val viewHolders = ArrayList<EpoxyViewHolder>(4)
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//                  documentation ```kt\npublic final val viewHolders: [ERROR : Type for ArrayList<EpoxyViewHolder>(4)]\n```
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//                  documentation ```kt\npublic final val viewHolders: [ERROR : Type for ArrayList<EpoxyViewHolder>(4)]\n```

    /** Use parent pool or create a local pool */
    @VisibleForTesting
//   ^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/VisibleForTesting#`<init>`().
    val viewPool = findViewPool(modelGroupParent)
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewPool().
//               documentation ```kt\npublic final val viewPool: [ERROR : RecyclerView.RecycledViewPool]\n```\n\n----\n\n Use parent pool or create a local pool
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewPool.
//               documentation ```kt\npublic final val viewPool: [ERROR : RecyclerView.RecycledViewPool]\n```\n\n----\n\n Use parent pool or create a local pool
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
//                        documentation ```kt\npublic final lateinit var rootView: [ERROR : ViewGroup]\n```\n\n----\n\n\n Get the root view group (aka\n [androidx.recyclerview.widget.RecyclerView.ViewHolder.itemView].\n You can override [EpoxyModelGroup.bind] and use this method to make custom\n changes to the root view.\n
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#rootView.
//                        documentation ```kt\npublic final lateinit var rootView: [ERROR : ViewGroup]\n```\n\n----\n\n\n Get the root view group (aka\n [androidx.recyclerview.widget.RecyclerView.ViewHolder.itemView].\n You can override [EpoxyModelGroup.bind] and use this method to make custom\n changes to the root view.\n
        private set
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setRootView().
//                  documentation ```kt\nprivate final fun <set-rootView>(<set-?>: [ERROR : ViewGroup])\n```

    private lateinit var childContainer: ViewGroup
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#childContainer.
//                                      documentation ```kt\nprivate final lateinit var childContainer: [ERROR : ViewGroup]\n```
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//                                      documentation ```kt\nprivate final lateinit var childContainer: [ERROR : ViewGroup]\n```
//                       ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
//                                      documentation ```kt\nprivate final lateinit var childContainer: [ERROR : ViewGroup]\n```
    private lateinit var stubs: List<ViewStubData>
//                       ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                             documentation ```kt\nprivate final lateinit var stubs: kotlin.collections.List<com.airbnb.epoxy.ViewStubData>\n```
//                       ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                             documentation ```kt\nprivate final lateinit var stubs: kotlin.collections.List<com.airbnb.epoxy.ViewStubData>\n```
//                       ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                             documentation ```kt\nprivate final lateinit var stubs: kotlin.collections.List<com.airbnb.epoxy.ViewStubData>\n```
//                              ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#
    private var boundGroup: EpoxyModelGroup? = null
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//                         documentation ```kt\nprivate final var boundGroup: [ERROR : EpoxyModelGroup]?\n```
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//                         documentation ```kt\nprivate final var boundGroup: [ERROR : EpoxyModelGroup]?\n```
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().
//                         documentation ```kt\nprivate final var boundGroup: [ERROR : EpoxyModelGroup]?\n```

    private fun usingStubs(): Boolean = stubs.isNotEmpty()
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#usingStubs().
//                         documentation ```kt\nprivate final fun usingStubs(): kotlin.Boolean\n```
//                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                                            ^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#isNotEmpty(+9).

    override fun bindView(itemView: View) {
//               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindView().
//                        documentation ```kt\npublic open fun bindView(itemView: [ERROR : View])\n```
//                        ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindView().(itemView)
//                                 documentation ```kt\nvalue-parameter itemView: [ERROR : View]\n```
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
//                                 documentation ```kt\nprivate final fun findChildContainer(outermostRoot: [ERROR : ViewGroup]): [ERROR : ViewGroup]\n```\n\n----\n\n\n By default the outermost viewgroup is used as the container that views are added to. However,\n users can specify a different, nested view group to use as the child container by marking it\n with a special id.\n
//                                 ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)
//                                               documentation ```kt\nvalue-parameter outermostRoot: [ERROR : ViewGroup]\n```
        val customRoot = outermostRoot.findViewById<View>(R.id.epoxy_model_group_child_container)
//          ^^^^^^^^^^ definition local 0
//                     documentation ```kt\nval customRoot: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)

        return customRoot as? ViewGroup ?: outermostRoot
//             ^^^^^^^^^^ reference local 0
//                                         ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)
    }

    private fun createViewStubData(viewGroup: ViewGroup): List<ViewStubData> {
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#createViewStubData().
//                                 documentation ```kt\nprivate final fun createViewStubData(viewGroup: [ERROR : ViewGroup]): kotlin.collections.List<com.airbnb.epoxy.ViewStubData>\n```
//                                 ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#createViewStubData().(viewGroup)
//                                           documentation ```kt\nvalue-parameter viewGroup: [ERROR : ViewGroup]\n```
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
//                               documentation ```kt\nprivate final fun collectViewStubs(viewGroup: [ERROR : ViewGroup], stubs: java.util.ArrayList<com.airbnb.epoxy.ViewStubData>)\n```
        viewGroup: ViewGroup,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
//                documentation ```kt\nvalue-parameter viewGroup: [ERROR : ViewGroup]\n```
        stubs: ArrayList<ViewStubData>
//      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(stubs)
//            documentation ```kt\nvalue-parameter stubs: java.util.ArrayList<com.airbnb.epoxy.ViewStubData>\n```
//             ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#
    ) {
        for (i in 0 until viewGroup.childCount) {
//           ^ definition local 1
//             documentation ```kt\nval i: kotlin.Int\n```
//                  ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
            val child = viewGroup.getChildAt(i)
//              ^^^^^ definition local 2
//                    documentation ```kt\nval child: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
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
//                        documentation ```kt\npublic final fun bindGroupIfNeeded(group: [ERROR : EpoxyModelGroup])\n```
//                        ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
//                              documentation ```kt\nvalue-parameter group: [ERROR : EpoxyModelGroup]\n```
        val previouslyBoundGroup = this.boundGroup
//          ^^^^^^^^^^^^^^^^^^^^ definition local 3
//                               documentation ```kt\nval previouslyBoundGroup: [ERROR : EpoxyModelGroup]?\n```
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
//                     documentation ```kt\nval i: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
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
//                 documentation ```kt\nval models: [ERROR : <ERROR PROPERTY TYPE>]\n```
//                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
        val modelCount = models.size
//          ^^^^^^^^^^ definition local 6
//                     documentation ```kt\nval modelCount: [ERROR : <ERROR PROPERTY TYPE>]\n```
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
//             documentation ```kt\nval i: kotlin.Int\n```
//                  ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^^ reference local 6
            val model = models[i]
//              ^^^^^ definition local 8
//                    documentation ```kt\nval model: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//                      ^^^^^^ reference local 5
//                             ^ reference local 7
            val previouslyBoundModel = previouslyBoundGroup?.models?.getOrNull(i)
//              ^^^^^^^^^^^^^^^^^^^^ definition local 9
//                                   documentation ```kt\nval previouslyBoundModel: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//                                     ^^^^^^^^^^^^^^^^^^^^ reference local 3
//                                                                             ^ reference local 7
            val stubData = stubs.getOrNull(i)
//              ^^^^^^^^ definition local 10
//                       documentation ```kt\nval stubData: com.airbnb.epoxy.ViewStubData?\n```
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#stubs.
//                               ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#getOrNull(+9).
//                                         ^ reference local 7
            val parent = stubData?.viewGroup ?: childContainer
//              ^^^^^^ definition local 11
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
//                     documentation ```kt\nval holder: [ERROR : EpoxyViewHolder]\n```
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
//                              documentation ```kt\nprivate final fun areSameViewType(model1: [ERROR : EpoxyModel<*>]<out [ERROR : *]>, model2: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?): kotlin.Boolean\n```
//                              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model1)
//                                     documentation ```kt\nvalue-parameter model1: [ERROR : EpoxyModel<*>]<out [ERROR : *]>\n```
//                                                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model2)
//                                                            documentation ```kt\nvalue-parameter model2: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?\n```
//                                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        return ViewTypeManager.getViewType(model1) == ViewTypeManager.getViewType(model2)
//                                         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model1)
//                                                                                ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model2)
    }

    private fun getViewHolder(parent: ViewGroup, model: EpoxyModel<*>): EpoxyViewHolder {
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().
//                            documentation ```kt\nprivate final fun getViewHolder(parent: [ERROR : ViewGroup], model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>): [ERROR : EpoxyViewHolder]\n```
//                            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(parent)
//                                   documentation ```kt\nvalue-parameter parent: [ERROR : ViewGroup]\n```
//                                               ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)
//                                                     documentation ```kt\nvalue-parameter model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>\n```
        val viewType = ViewTypeManager.getViewType(model)
//          ^^^^^^^^ definition local 13
//                   documentation ```kt\nval viewType: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//                                                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)
        val recycledView = viewPool.getRecycledView(viewType)
//          ^^^^^^^^^^^^ definition local 14
//                       documentation ```kt\nval recycledView: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
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
//                                   documentation ```kt\nprivate final fun removeAndRecycleView(modelPosition: kotlin.Int)\n```
//                                   ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)
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
//                     documentation ```kt\nval viewHolder: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
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
//                     documentation ```kt\npublic companion object\n```

        private val HELPER_ADAPTER = HelperAdapter()
//                  ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#HELPER_ADAPTER.
//                                 documentation ```kt\nprivate final val HELPER_ADAPTER: com.airbnb.epoxy.HelperAdapter\n```
//                  ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#getHELPER_ADAPTER().
//                                 documentation ```kt\nprivate final val HELPER_ADAPTER: com.airbnb.epoxy.HelperAdapter\n```
//                                   ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/HelperAdapter#`<init>`().

        private fun findViewPool(view: ViewParent): RecyclerView.RecycledViewPool {
//                  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().
//                               documentation ```kt\nprivate final fun findViewPool(view: [ERROR : ViewParent]): [ERROR : RecyclerView.RecycledViewPool]\n```
//                               ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
//                                    documentation ```kt\nvalue-parameter view: [ERROR : ViewParent]\n```
            var viewPool: RecyclerView.RecycledViewPool? = null
//              ^^^^^^^^ definition local 16
//                       documentation ```kt\nvar viewPool: [ERROR : RecyclerView.RecycledViewPool]?\n```
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
//                             documentation ```kt\nval parent: [ERROR : <ERROR PROPERTY TYPE>]\n```
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
//                         documentation ```kt\nprivate final class ViewStubData\n```
//            ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#`<init>`().
//                         documentation ```kt\npublic constructor ViewStubData(viewGroup: [ERROR : ViewGroup], viewStub: [ERROR : ViewStub], position: kotlin.Int)\n```
    val viewGroup: ViewGroup,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#`<init>`().(viewGroup)
//                documentation ```kt\nvalue-parameter viewGroup: [ERROR : ViewGroup]\n```
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewGroup().
//                documentation ```kt\npublic final val viewGroup: [ERROR : ViewGroup]\n```
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewGroup.
//                documentation ```kt\npublic final val viewGroup: [ERROR : ViewGroup]\n```
    val viewStub: ViewStub,
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#`<init>`().(viewStub)
//               documentation ```kt\nvalue-parameter viewStub: [ERROR : ViewStub]\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#getViewStub().
//               documentation ```kt\npublic final val viewStub: [ERROR : ViewStub]\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#viewStub.
//               documentation ```kt\npublic final val viewStub: [ERROR : ViewStub]\n```
    val position: Int
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#`<init>`().(position)
//               documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#getPosition().
//               documentation ```kt\npublic final val position: kotlin.Int\n```
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#position.
//               documentation ```kt\npublic final val position: kotlin.Int\n```
//                ^^^ reference semanticdb maven . . kotlin/Int#
) {

    fun setView(view: View, useStubLayoutParams: Boolean) {
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().
//              documentation ```kt\npublic final fun setView(view: [ERROR : View], useStubLayoutParams: kotlin.Boolean)\n```
//              ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().(view)
//                   documentation ```kt\nvalue-parameter view: [ERROR : View]\n```
//                          ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ViewStubData#setView().(useStubLayoutParams)
//                                              documentation ```kt\nvalue-parameter useStubLayoutParams: kotlin.Boolean\n```
//                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        removeCurrentView()
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ViewStubData#removeCurrentView().

        // Carry over the stub id manually since we aren't inflating via the stub
        val inflatedId = viewStub.inflatedId
//          ^^^^^^^^^^ definition local 18
//                     documentation ```kt\nval inflatedId: [ERROR : <ERROR PROPERTY TYPE>]\n```
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
//                                documentation ```kt\nprivate final fun removeCurrentView()\n```
        val view = viewGroup.getChildAt(position)
//          ^^^^ definition local 19
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
//                                       documentation ```kt\nprivate final class LocalGroupRecycledViewPool\n```\n\n----\n\n\n Local pool to the [ModelGroupHolder]\n
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/LocalGroupRecycledViewPool#`<init>`().
//                                       documentation ```kt\npublic constructor LocalGroupRecycledViewPool()\n```\n\n----\n\n\n Local pool to the [ModelGroupHolder]\n

/**
 * A viewholder's viewtype can only be set internally in an adapter when the viewholder
 * is created. To work around that we do the creation in an adapter.
 */
private class HelperAdapter : RecyclerView.Adapter<EpoxyViewHolder>() {
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#
//                          documentation ```kt\nprivate final class HelperAdapter\n```\n\n----\n\n\n A viewholder's viewtype can only be set internally in an adapter when the viewholder\n is created. To work around that we do the creation in an adapter.\n
//            ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#`<init>`().
//                          documentation ```kt\npublic constructor HelperAdapter()\n```\n\n----\n\n\n A viewholder's viewtype can only be set internally in an adapter when the viewholder\n is created. To work around that we do the creation in an adapter.\n

    private var model: EpoxyModel<*>? = null
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModel().
//                    documentation ```kt\nprivate final var model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?\n```
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#model.
//                    documentation ```kt\nprivate final var model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?\n```
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModel().
//                    documentation ```kt\nprivate final var model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?\n```
    private var modelGroupParent: ViewParent? = null
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getModelGroupParent().
//                               documentation ```kt\nprivate final var modelGroupParent: [ERROR : ViewParent]?\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#modelGroupParent.
//                               documentation ```kt\nprivate final var modelGroupParent: [ERROR : ViewParent]?\n```
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#setModelGroupParent().
//                               documentation ```kt\nprivate final var modelGroupParent: [ERROR : ViewParent]?\n```

    fun createViewHolder(
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().
//                       documentation ```kt\npublic final fun createViewHolder(modelGroupParent: [ERROR : ViewParent], model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>, parent: [ERROR : ViewGroup], viewType: kotlin.Int): [ERROR : EpoxyViewHolder]\n```
        modelGroupParent: ViewParent,
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(modelGroupParent)
//                       documentation ```kt\nvalue-parameter modelGroupParent: [ERROR : ViewParent]\n```
        model: EpoxyModel<*>,
//      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(model)
//            documentation ```kt\nvalue-parameter model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>\n```
        parent: ViewGroup,
//      ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(parent)
//             documentation ```kt\nvalue-parameter parent: [ERROR : ViewGroup]\n```
        viewType: Int
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#createViewHolder().(viewType)
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
//                     documentation ```kt\nval viewHolder: [ERROR : EpoxyViewHolder]\n```
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
//                                  documentation ```kt\npublic open fun onCreateViewHolder(parent: [ERROR : ViewGroup], viewType: kotlin.Int): [ERROR : EpoxyViewHolder]\n```
//                                  ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(parent)
//                                         documentation ```kt\nvalue-parameter parent: [ERROR : ViewGroup]\n```
//                                                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(viewType)
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
//                                documentation ```kt\npublic open fun onBindViewHolder(holder: [ERROR : EpoxyViewHolder], position: kotlin.Int)\n```
//                                ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onBindViewHolder().(holder)
//                                       documentation ```kt\nvalue-parameter holder: [ERROR : EpoxyViewHolder]\n```
//                                                         ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#onBindViewHolder().(position)
//                                                                  documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                                                   ^^^ reference semanticdb maven . . kotlin/Int#
    }

    override fun getItemCount() = 1
//               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/HelperAdapter#getItemCount().
//                            documentation ```kt\npublic open fun getItemCount(): kotlin.Int\n```
}
