package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.view.ViewStub
import androidx.annotation.VisibleForTesting
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^^^^^^^^^ reference androidx/annotation/VisibleForTesting#
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference androidx/
import com.airbnb.viewmodeladapter.R
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
import java.util.ArrayList
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#

class ModelGroupHolder(private val modelGroupParent: ViewParent) : EpoxyHolder() {
//    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#
//    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#`<init>`().
//                                 ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#modelGroupParent.
//                                 ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getModelGroupParent().
//                                 ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#`<init>`().(modelGroupParent)
    val viewHolders = ArrayList<EpoxyViewHolder>(4)
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewHolders().

    /** Use parent pool or create a local pool */
    @VisibleForTesting
//   ^^^^^^^^^^^^^^^^^ reference androidx/annotation/VisibleForTesting#`<init>`().
    val viewPool = findViewPool(modelGroupParent)
//      ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#viewPool.
//      ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewPool().
//                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().
//                              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#modelGroupParent.
//                              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getModelGroupParent().

    /**
     * Get the root view group (aka
     * [androidx.recyclerview.widget.RecyclerView.ViewHolder.itemView].
     * You can override [EpoxyModelGroup.bind] and use this method to make custom
     * changes to the root view.
     */
    lateinit var rootView: ViewGroup
//               ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#rootView.
//               ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getRootView().
        private set
//              ^^^ definition com/airbnb/epoxy/ModelGroupHolder#setRootView().

    private lateinit var childContainer: ViewGroup
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#childContainer.
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
    private lateinit var stubs: List<ViewStubData>
//                       ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#stubs.
//                       ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                       ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                              ^^^^ reference kotlin/collections/List#
//                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#
    private var boundGroup: EpoxyModelGroup? = null
//              ^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//              ^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//              ^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().

    private fun usingStubs(): Boolean = stubs.isNotEmpty()
//              ^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#usingStubs().
//                            ^^^^^^^ reference kotlin/Boolean#
//                                      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#stubs.
//                                      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                                      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                                            ^^^^^^^^^^ reference kotlin/collections/CollectionsKt#isNotEmpty(+9).

    override fun bindView(itemView: View) {
//               ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#bindView().
//                        ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#bindView().(itemView)
        if (itemView !is ViewGroup) {
//          ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#bindView().(itemView)
            throw IllegalStateException(
//                ^^^^^^^^^^^^^^^^^^^^^ reference kotlin/IllegalStateException#`<init>`(+1).
                "The layout provided to EpoxyModelGroup must be a ViewGroup"
            )
        }

        rootView = itemView
//      ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#rootView.
//      ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getRootView().
//                 ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#bindView().(itemView)
        childContainer = findChildContainer(rootView)
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#childContainer.
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
//                       ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#findChildContainer().
//                                          ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#rootView.
//                                          ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getRootView().

        stubs = if (childContainer.childCount != 0) {
//      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#stubs.
//      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getStubs().
//      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#childContainer.
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
            createViewStubData(childContainer)
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#createViewStubData().
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#childContainer.
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
        } else {
            emptyList()
//          ^^^^^^^^^ reference kotlin/collections/CollectionsKt#emptyList().
        }
    }

    /**
     * By default the outermost viewgroup is used as the container that views are added to. However,
     * users can specify a different, nested view group to use as the child container by marking it
     * with a special id.
     */
    private fun findChildContainer(outermostRoot: ViewGroup): ViewGroup {
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#findChildContainer().
//                                 ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)
        val customRoot = outermostRoot.findViewById<View>(R.id.epoxy_model_group_child_container)
//          ^^^^^^^^^^ definition local0
//                       ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)

        return customRoot as? ViewGroup ?: outermostRoot
//             ^^^^^^^^^^ reference local0
//                                         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)
    }

    private fun createViewStubData(viewGroup: ViewGroup): List<ViewStubData> {
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#createViewStubData().
//                                 ^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#createViewStubData().(viewGroup)
//                                                        ^^^^ reference kotlin/collections/List#
//                                                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#
        return ArrayList<ViewStubData>(4).apply {
//             ^^^^^^^^^ reference java/util/ArrayList#`<init>`().
//                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#
//                                        ^^^^^ reference kotlin/StandardKt#apply().

            collectViewStubs(viewGroup, this)
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().
//                           ^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#createViewStubData().(viewGroup)
//                                      ^^^^ reference

            if (isEmpty()) {
//              ^^^^^^^ reference java/util/ArrayList#isEmpty().
                throw IllegalStateException(
//                    ^^^^^^^^^^^^^^^^^^^^^ reference kotlin/IllegalStateException#`<init>`(+1).
                    "No view stubs found. If viewgroup is not empty it must contain ViewStubs."
                )
            }
        }
    }

    private fun collectViewStubs(
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().
        viewGroup: ViewGroup,
//      ^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
        stubs: ArrayList<ViewStubData>
//      ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(stubs)
//             ^^^^^^^^^ reference java/util/ArrayList#
//                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#
    ) {
        for (i in 0 until viewGroup.childCount) {
//           ^ definition local1
//                  ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
            val child = viewGroup.getChildAt(i)
//              ^^^^^ definition local2
//                      ^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
//                                           ^ reference local1

            if (child is ViewGroup) {
//              ^^^^^ reference local2
                collectViewStubs(child, stubs)
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().
//                               ^^^^^ reference local2
//                                      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(stubs)
            } else if (child is ViewStub) {
//                     ^^^^^ reference local2
                stubs.add(ViewStubData(viewGroup, child, i))
//              ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(stubs)
//                    ^^^ reference java/util/ArrayList#add(+1).
//                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#`<init>`().
//                                     ^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
//                                                ^^^^^ reference local2
//                                                       ^ reference local1
            }
        }
    }

    fun bindGroupIfNeeded(group: EpoxyModelGroup) {
//      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().
//                        ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
        val previouslyBoundGroup = this.boundGroup
//          ^^^^^^^^^^^^^^^^^^^^ definition local3
//                                 ^^^^ reference com/airbnb/epoxy/ModelGroupHolder#
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().

        if (previouslyBoundGroup === group) {
//          ^^^^^^^^^^^^^^^^^^^^ reference local3
//                                   ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
            return
        } else if (previouslyBoundGroup != null) {
//                 ^^^^^^^^^^^^^^^^^^^^ reference local3
            // A different group is being bound; this can happen when an onscreen model is changed.
            // The models or their layouts could have changed, so views may need to be updated

            if (previouslyBoundGroup.models.size > group.models.size) {
//              ^^^^^^^^^^^^^^^^^^^^ reference local3
//                                                 ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
                for (i in previouslyBoundGroup.models.size - 1 downTo group.models.size) {
//                   ^ definition local4
//                        ^^^^^^^^^^^^^^^^^^^^ reference local3
//                                                                    ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
                    removeAndRecycleView(i)
//                  ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().
//                                       ^ reference local4
                }
            }
        }

        this.boundGroup = group
//      ^^^^ reference com/airbnb/epoxy/ModelGroupHolder#
//           ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//           ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//           ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().
//                        ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
        val models = group.models
//          ^^^^^^ definition local5
//                   ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
        val modelCount = models.size
//          ^^^^^^^^^^ definition local6
//                       ^^^^^^ reference local5

        if (usingStubs() && stubs.size < modelCount) {
//          ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#usingStubs().
//                          ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#stubs.
//                          ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                          ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                                ^^^^ reference kotlin/collections/List#size.
//                                ^^^^ reference kotlin/collections/List#getSize().
//                                       ^^^^^^^^^^ reference local6
            throw IllegalStateException(
//                ^^^^^^^^^^^^^^^^^^^^^ reference kotlin/IllegalStateException#`<init>`(+1).
                "Insufficient view stubs for EpoxyModelGroup. $modelCount models were provided but only ${stubs.size} view stubs exist."
//                                                             ^^^^^^^^^^ reference local6
//                                                                                                        ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#stubs.
//                                                                                                        ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                                                                                                        ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                                                                                                              ^^^^ reference kotlin/collections/List#size.
//                                                                                                              ^^^^ reference kotlin/collections/List#getSize().
            )
        }
        viewHolders.ensureCapacity(modelCount)
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//                                 ^^^^^^^^^^ reference local6

        for (i in 0 until modelCount) {
//           ^ definition local7
//                  ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^^ reference local6
            val model = models[i]
//              ^^^^^ definition local8
//                      ^^^^^^ reference local5
//                             ^ reference local7
            val previouslyBoundModel = previouslyBoundGroup?.models?.getOrNull(i)
//              ^^^^^^^^^^^^^^^^^^^^ definition local9
//                                     ^^^^^^^^^^^^^^^^^^^^ reference local3
//                                                                             ^ reference local7
            val stubData = stubs.getOrNull(i)
//              ^^^^^^^^ definition local10
//                         ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#stubs.
//                         ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                         ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                               ^^^^^^^^^ reference kotlin/collections/CollectionsKt#getOrNull(+9).
//                                         ^ reference local7
            val parent = stubData?.viewGroup ?: childContainer
//              ^^^^^^ definition local11
//                       ^^^^^^^^ reference local10
//                                 ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#viewGroup.
//                                 ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getViewGroup().
//                                              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#childContainer.
//                                              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//                                              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setChildContainer().

            if (previouslyBoundModel != null) {
//              ^^^^^^^^^^^^^^^^^^^^ reference local9
                if (areSameViewType(previouslyBoundModel, model)) {
//                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#areSameViewType().
//                                  ^^^^^^^^^^^^^^^^^^^^ reference local9
//                                                        ^^^^^ reference local8
                    continue
                }

                removeAndRecycleView(i)
//              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().
//                                   ^ reference local7
            }

            val holder = getViewHolder(parent, model)
//              ^^^^^^ definition local12
//                       ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolder().
//                                     ^^^^^^ reference local11
//                                             ^^^^^ reference local8

            if (stubData == null) {
//              ^^^^^^^^ reference local10
//                       ^^ reference com/airbnb/epoxy/ViewStubData#equals(+-1).
                childContainer.addView(holder.itemView, i)
//              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#childContainer.
//              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
//                                     ^^^^^^ reference local12
//                                                      ^ reference local7
            } else {
                stubData.setView(holder.itemView, group.useViewStubLayoutParams(model, i))
//              ^^^^^^^^ reference local10
//                       ^^^^^^^ reference com/airbnb/epoxy/ViewStubData#setView().
//                               ^^^^^^ reference local12
//                                                ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
//                                                                              ^^^^^ reference local8
//                                                                                     ^ reference local7
            }

            viewHolders.add(i, holder)
//          ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//          ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//                          ^ reference local7
//                             ^^^^^^ reference local12
        }
    }

    private fun areSameViewType(model1: EpoxyModel<*>, model2: EpoxyModel<*>?): Boolean {
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#areSameViewType().
//                              ^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model1)
//                                                     ^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model2)
//                                                                              ^^^^^^^ reference kotlin/Boolean#
        return ViewTypeManager.getViewType(model1) == ViewTypeManager.getViewType(model2)
//                                         ^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model1)
//                                                                                ^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model2)
    }

    private fun getViewHolder(parent: ViewGroup, model: EpoxyModel<*>): EpoxyViewHolder {
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewHolder().
//                            ^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(parent)
//                                               ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)
        val viewType = ViewTypeManager.getViewType(model)
//          ^^^^^^^^ definition local13
//                                                 ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)
        val recycledView = viewPool.getRecycledView(viewType)
//          ^^^^^^^^^^^^ definition local14
//                         ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#viewPool.
//                         ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewPool().
//                                                  ^^^^^^^^ reference local13

        return recycledView as? EpoxyViewHolder
//             ^^^^^^^^^^^^ reference local14
            ?: HELPER_ADAPTER.createViewHolder(
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#Companion#HELPER_ADAPTER.
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#Companion#getHELPER_ADAPTER().
//                            ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#createViewHolder().
                modelGroupParent,
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#modelGroupParent.
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getModelGroupParent().
                model,
//              ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)
                parent,
//              ^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(parent)
                viewType
//              ^^^^^^^^ reference local13
            )
    }

    fun unbindGroup() {
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#unbindGroup().
        if (boundGroup == null) {
//          ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//          ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//          ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().
            throw IllegalStateException("Group is not bound")
//                ^^^^^^^^^^^^^^^^^^^^^ reference kotlin/IllegalStateException#`<init>`(+1).
        }

        repeat(viewHolders.size) {
//      ^^^^^^ reference kotlin/StandardKt#repeat().
//             ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//             ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
            // Remove from the end for more efficient list actions
            removeAndRecycleView(viewHolders.size - 1)
//          ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().
//                               ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//                               ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
        }

        boundGroup = null
//      ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#boundGroup.
//      ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().
//      ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().
    }

    private fun removeAndRecycleView(modelPosition: Int) {
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().
//                                   ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)
//                                                  ^^^ reference kotlin/Int#
        if (usingStubs()) {
//          ^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#usingStubs().
            stubs[modelPosition].resetStub()
//          ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#stubs.
//          ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getStubs().
//          ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)
//                               ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#resetStub().
        } else {
            childContainer.removeViewAt(modelPosition)
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#childContainer.
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getChildContainer().
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setChildContainer().
//                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)
        }

        val viewHolder = viewHolders.removeAt(modelPosition)
//          ^^^^^^^^^^ definition local15
//                       ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//                       ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)
        viewHolder.unbind()
//      ^^^^^^^^^^ reference local15
        viewPool.putRecycledView(viewHolder)
//      ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#viewPool.
//      ^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewPool().
//                               ^^^^^^^^^^ reference local15
    }

    companion object {

        private val HELPER_ADAPTER = HelperAdapter()
//                  ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#Companion#HELPER_ADAPTER.
//                  ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#Companion#getHELPER_ADAPTER().
//                                   ^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#`<init>`().

        private fun findViewPool(view: ViewParent): RecyclerView.RecycledViewPool {
//                  ^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().
//                               ^^^^ definition com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
            var viewPool: RecyclerView.RecycledViewPool? = null
//              ^^^^^^^^ definition local16
            while (viewPool == null) {
//                 ^^^^^^^^ reference local16
                viewPool = if (view is RecyclerView) {
//              ^^^^^^^^ reference local16
//                             ^^^^ reference com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
                    view.recycledViewPool
//                  ^^^^ reference com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
                } else {
                    val parent = view.parent
//                      ^^^^^^ definition local17
//                               ^^^^ reference com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
                    if (parent is ViewParent) {
//                      ^^^^^^ reference local17
                        findViewPool(parent)
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().
//                                   ^^^^^^ reference local17
                    } else {
                        // This model group is is not in a RecyclerView
                        LocalGroupRecycledViewPool()
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/LocalGroupRecycledViewPool#`<init>`().
                    }
                }
            }
            return viewPool
//                 ^^^^^^^^ reference local16
        }
    }
}

private class ViewStubData(
//            ^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#
//            ^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#`<init>`().
    val viewGroup: ViewGroup,
//      ^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#viewGroup.
//      ^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#getViewGroup().
//      ^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#`<init>`().(viewGroup)
    val viewStub: ViewStub,
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#viewStub.
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#getViewStub().
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#`<init>`().(viewStub)
    val position: Int
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#position.
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#getPosition().
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#`<init>`().(position)
//                ^^^ reference kotlin/Int#
) {

    fun setView(view: View, useStubLayoutParams: Boolean) {
//      ^^^^^^^ definition com/airbnb/epoxy/ViewStubData#setView().
//              ^^^^ definition com/airbnb/epoxy/ViewStubData#setView().(view)
//                          ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#setView().(useStubLayoutParams)
//                                               ^^^^^^^ reference kotlin/Boolean#
        removeCurrentView()
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#removeCurrentView().

        // Carry over the stub id manually since we aren't inflating via the stub
        val inflatedId = viewStub.inflatedId
//          ^^^^^^^^^^ definition local18
//                       ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#viewStub.
//                       ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getViewStub().
        if (inflatedId != View.NO_ID) {
//          ^^^^^^^^^^ reference local18
            view.id = inflatedId
//          ^^^^ reference com/airbnb/epoxy/ViewStubData#setView().(view)
//                    ^^^^^^^^^^ reference local18
        }

        if (useStubLayoutParams) {
//          ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#setView().(useStubLayoutParams)
            viewGroup.addView(view, position, viewStub.layoutParams)
//          ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#viewGroup.
//          ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getViewGroup().
//                            ^^^^ reference com/airbnb/epoxy/ViewStubData#setView().(view)
//                                  ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#position.
//                                  ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getPosition().
//                                            ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#viewStub.
//                                            ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getViewStub().
        } else {
            viewGroup.addView(view, position)
//          ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#viewGroup.
//          ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getViewGroup().
//                            ^^^^ reference com/airbnb/epoxy/ViewStubData#setView().(view)
//                                  ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#position.
//                                  ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getPosition().
        }
    }

    fun resetStub() {
//      ^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#resetStub().
        removeCurrentView()
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#removeCurrentView().
        viewGroup.addView(viewStub, position)
//      ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#viewGroup.
//      ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getViewGroup().
//                        ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#viewStub.
//                        ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getViewStub().
//                                  ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#position.
//                                  ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getPosition().
    }

    private fun removeCurrentView() {
//              ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#removeCurrentView().
        val view = viewGroup.getChildAt(position)
//          ^^^^ definition local19
//                 ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#viewGroup.
//                 ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getViewGroup().
//                                      ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#position.
//                                      ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getPosition().
            ?: throw IllegalStateException("No view exists at position $position")
//                   ^^^^^^^^^^^^^^^^^^^^^ reference kotlin/IllegalStateException#`<init>`(+1).
//                                                                      ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#position.
//                                                                      ^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getPosition().
        viewGroup.removeView(view)
//      ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#viewGroup.
//      ^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#getViewGroup().
//                           ^^^^ reference local19
    }
}

/**
 * Local pool to the [ModelGroupHolder]
 */
private class LocalGroupRecycledViewPool : RecyclerView.RecycledViewPool()
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/LocalGroupRecycledViewPool#
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/LocalGroupRecycledViewPool#`<init>`().

/**
 * A viewholder's viewtype can only be set internally in an adapter when the viewholder
 * is created. To work around that we do the creation in an adapter.
 */
private class HelperAdapter : RecyclerView.Adapter<EpoxyViewHolder>() {
//            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#
//            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#`<init>`().

    private var model: EpoxyModel<*>? = null
//              ^^^^^ definition com/airbnb/epoxy/HelperAdapter#model.
//              ^^^^^ definition com/airbnb/epoxy/HelperAdapter#getModel().
//              ^^^^^ definition com/airbnb/epoxy/HelperAdapter#setModel().
    private var modelGroupParent: ViewParent? = null
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#modelGroupParent.
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#getModelGroupParent().
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#setModelGroupParent().

    fun createViewHolder(
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().
        modelGroupParent: ViewParent,
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().(modelGroupParent)
        model: EpoxyModel<*>,
//      ^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().(model)
        parent: ViewGroup,
//      ^^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().(parent)
        viewType: Int
//      ^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().(viewType)
//                ^^^ reference kotlin/Int#
    ): EpoxyViewHolder {
        this.model = model
//      ^^^^ reference com/airbnb/epoxy/HelperAdapter#
//           ^^^^^ reference com/airbnb/epoxy/HelperAdapter#model.
//           ^^^^^ reference com/airbnb/epoxy/HelperAdapter#getModel().
//           ^^^^^ reference com/airbnb/epoxy/HelperAdapter#setModel().
//                   ^^^^^ reference com/airbnb/epoxy/HelperAdapter#createViewHolder().(model)
        this.modelGroupParent = modelGroupParent
//      ^^^^ reference com/airbnb/epoxy/HelperAdapter#
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#modelGroupParent.
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#getModelGroupParent().
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#setModelGroupParent().
//                              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#createViewHolder().(modelGroupParent)
        val viewHolder = createViewHolder(parent, viewType)
//          ^^^^^^^^^^ definition local20
//                       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#createViewHolder().
//                                        ^^^^^^ reference com/airbnb/epoxy/HelperAdapter#createViewHolder().(parent)
//                                                ^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#createViewHolder().(viewType)
        this.model = null
//      ^^^^ reference com/airbnb/epoxy/HelperAdapter#
//           ^^^^^ reference com/airbnb/epoxy/HelperAdapter#model.
//           ^^^^^ reference com/airbnb/epoxy/HelperAdapter#getModel().
//           ^^^^^ reference com/airbnb/epoxy/HelperAdapter#setModel().
        this.modelGroupParent = null
//      ^^^^ reference com/airbnb/epoxy/HelperAdapter#
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#modelGroupParent.
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#getModelGroupParent().
//           ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#setModelGroupParent().
        return viewHolder
//             ^^^^^^^^^^ reference local20
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpoxyViewHolder {
//               ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().
//                                  ^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(parent)
//                                                     ^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(viewType)
//                                                               ^^^ reference kotlin/Int#
        return EpoxyViewHolder(modelGroupParent, model!!.buildView(parent), model!!.shouldSaveViewState())
//                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#modelGroupParent.
//                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#getModelGroupParent().
//                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#setModelGroupParent().
//                                               ^^^^^ reference com/airbnb/epoxy/HelperAdapter#model.
//                                               ^^^^^ reference com/airbnb/epoxy/HelperAdapter#getModel().
//                                               ^^^^^ reference com/airbnb/epoxy/HelperAdapter#setModel().
//                                                                 ^^^^^^ reference com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(parent)
//                                                                          ^^^^^ reference com/airbnb/epoxy/HelperAdapter#model.
//                                                                          ^^^^^ reference com/airbnb/epoxy/HelperAdapter#getModel().
//                                                                          ^^^^^ reference com/airbnb/epoxy/HelperAdapter#setModel().
    }

    override fun onBindViewHolder(holder: EpoxyViewHolder, position: Int) {
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onBindViewHolder().
//                                ^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onBindViewHolder().(holder)
//                                                         ^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onBindViewHolder().(position)
//                                                                   ^^^ reference kotlin/Int#
    }

    override fun getItemCount() = 1
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#getItemCount().
}
