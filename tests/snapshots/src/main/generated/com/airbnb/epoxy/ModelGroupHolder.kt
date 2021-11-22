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
//    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#  public final class ModelGroupHolder
//    ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#`<init>`().  public constructor ModelGroupHolder(modelGroupParent: [ERROR : ViewParent])
//                                 ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#modelGroupParent.  private final val modelGroupParent: [ERROR : ViewParent]
//                                 ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getModelGroupParent().  private final val modelGroupParent: [ERROR : ViewParent]
//                                 ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#`<init>`().(modelGroupParent)  value-parameter modelGroupParent: [ERROR : ViewParent]
    val viewHolders = ArrayList<EpoxyViewHolder>(4)
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#viewHolders.  public final val viewHolders: [ERROR : Type for ArrayList<EpoxyViewHolder>(4)]
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewHolders().  public final val viewHolders: [ERROR : Type for ArrayList<EpoxyViewHolder>(4)]

    /** Use parent pool or create a local pool */
    @VisibleForTesting
//   ^^^^^^^^^^^^^^^^^ reference androidx/annotation/VisibleForTesting#`<init>`().
    val viewPool = findViewPool(modelGroupParent)
//      ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#viewPool.  public final val viewPool: [ERROR : RecyclerView.RecycledViewPool]
//      ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewPool().  public final val viewPool: [ERROR : RecyclerView.RecycledViewPool]
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
//               ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#rootView.  public final lateinit var rootView: [ERROR : ViewGroup]
//               ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getRootView().  public final lateinit var rootView: [ERROR : ViewGroup]
        private set
//              ^^^ definition com/airbnb/epoxy/ModelGroupHolder#setRootView().  private final fun <set-rootView>(<set-?>: [ERROR : ViewGroup])

    private lateinit var childContainer: ViewGroup
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#childContainer.  private final lateinit var childContainer: [ERROR : ViewGroup]
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getChildContainer().  private final lateinit var childContainer: [ERROR : ViewGroup]
//                       ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#setChildContainer().  private final lateinit var childContainer: [ERROR : ViewGroup]
    private lateinit var stubs: List<ViewStubData>
//                       ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#stubs.  private final lateinit var stubs: kotlin.collections.List<com.airbnb.epoxy.ViewStubData>
//                       ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getStubs().  private final lateinit var stubs: kotlin.collections.List<com.airbnb.epoxy.ViewStubData>
//                       ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#setStubs().  private final lateinit var stubs: kotlin.collections.List<com.airbnb.epoxy.ViewStubData>
//                              ^^^^ reference kotlin/collections/List#
//                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#
    private var boundGroup: EpoxyModelGroup? = null
//              ^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#boundGroup.  private final var boundGroup: [ERROR : EpoxyModelGroup]?
//              ^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getBoundGroup().  private final var boundGroup: [ERROR : EpoxyModelGroup]?
//              ^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#setBoundGroup().  private final var boundGroup: [ERROR : EpoxyModelGroup]?

    private fun usingStubs(): Boolean = stubs.isNotEmpty()
//              ^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#usingStubs().  private final fun usingStubs(): kotlin.Boolean
//                            ^^^^^^^ reference kotlin/Boolean#
//                                      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#stubs.
//                                      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                                      ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                                            ^^^^^^^^^^ reference kotlin/collections/CollectionsKt#isNotEmpty(+9).

    override fun bindView(itemView: View) {
//               ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#bindView().  public open fun bindView(itemView: [ERROR : View])
//                        ^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#bindView().(itemView)  value-parameter itemView: [ERROR : View]
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
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#findChildContainer().  private final fun findChildContainer(outermostRoot: [ERROR : ViewGroup]): [ERROR : ViewGroup]
//                                 ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)  value-parameter outermostRoot: [ERROR : ViewGroup]
        val customRoot = outermostRoot.findViewById<View>(R.id.epoxy_model_group_child_container)
//          ^^^^^^^^^^ definition local0  val customRoot: [ERROR : <ERROR FUNCTION RETURN TYPE>]
//                       ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)

        return customRoot as? ViewGroup ?: outermostRoot
//             ^^^^^^^^^^ reference local0
//                                         ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#findChildContainer().(outermostRoot)
    }

    private fun createViewStubData(viewGroup: ViewGroup): List<ViewStubData> {
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#createViewStubData().  private final fun createViewStubData(viewGroup: [ERROR : ViewGroup]): kotlin.collections.List<com.airbnb.epoxy.ViewStubData>
//                                 ^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#createViewStubData().(viewGroup)  value-parameter viewGroup: [ERROR : ViewGroup]
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
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().  private final fun collectViewStubs(viewGroup: [ERROR : ViewGroup], stubs: java.util.ArrayList<com.airbnb.epoxy.ViewStubData>)
        viewGroup: ViewGroup,
//      ^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)  value-parameter viewGroup: [ERROR : ViewGroup]
        stubs: ArrayList<ViewStubData>
//      ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(stubs)  value-parameter stubs: java.util.ArrayList<com.airbnb.epoxy.ViewStubData>
//             ^^^^^^^^^ reference java/util/ArrayList#
//                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#
    ) {
        for (i in 0 until viewGroup.childCount) {
//           ^ definition local1  val i: kotlin.Int
//                  ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#collectViewStubs().(viewGroup)
            val child = viewGroup.getChildAt(i)
//              ^^^^^ definition local2  val child: [ERROR : <ERROR FUNCTION RETURN TYPE>]
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
//      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().  public final fun bindGroupIfNeeded(group: [ERROR : EpoxyModelGroup])
//                        ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)  value-parameter group: [ERROR : EpoxyModelGroup]
        val previouslyBoundGroup = this.boundGroup
//          ^^^^^^^^^^^^^^^^^^^^ definition local3  val previouslyBoundGroup: [ERROR : EpoxyModelGroup]?
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
//                   ^ definition local4  val i: [ERROR : <ERROR FUNCTION RETURN TYPE>]
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
//          ^^^^^^ definition local5  val models: [ERROR : <ERROR PROPERTY TYPE>]
//                   ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#bindGroupIfNeeded().(group)
        val modelCount = models.size
//          ^^^^^^^^^^ definition local6  val modelCount: [ERROR : <ERROR PROPERTY TYPE>]
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
//           ^ definition local7  val i: kotlin.Int
//                  ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^^ reference local6
            val model = models[i]
//              ^^^^^ definition local8  val model: [ERROR : <ERROR FUNCTION RETURN TYPE>]
//                      ^^^^^^ reference local5
//                             ^ reference local7
            val previouslyBoundModel = previouslyBoundGroup?.models?.getOrNull(i)
//              ^^^^^^^^^^^^^^^^^^^^ definition local9  val previouslyBoundModel: [ERROR : <ERROR FUNCTION RETURN TYPE>]
//                                     ^^^^^^^^^^^^^^^^^^^^ reference local3
//                                                                             ^ reference local7
            val stubData = stubs.getOrNull(i)
//              ^^^^^^^^ definition local10  val stubData: com.airbnb.epoxy.ViewStubData?
//                         ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#stubs.
//                         ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getStubs().
//                         ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#setStubs().
//                               ^^^^^^^^^ reference kotlin/collections/CollectionsKt#getOrNull(+9).
//                                         ^ reference local7
            val parent = stubData?.viewGroup ?: childContainer
//              ^^^^^^ definition local11  val parent: ???
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
//              ^^^^^^ definition local12  val holder: [ERROR : EpoxyViewHolder]
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
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#areSameViewType().  private final fun areSameViewType(model1: [ERROR : EpoxyModel<*>]<out [ERROR : *]>, model2: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?): kotlin.Boolean
//                              ^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model1)  value-parameter model1: [ERROR : EpoxyModel<*>]<out [ERROR : *]>
//                                                     ^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model2)  value-parameter model2: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?
//                                                                              ^^^^^^^ reference kotlin/Boolean#
        return ViewTypeManager.getViewType(model1) == ViewTypeManager.getViewType(model2)
//                                         ^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model1)
//                                                                                ^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#areSameViewType().(model2)
    }

    private fun getViewHolder(parent: ViewGroup, model: EpoxyModel<*>): EpoxyViewHolder {
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewHolder().  private final fun getViewHolder(parent: [ERROR : ViewGroup], model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>): [ERROR : EpoxyViewHolder]
//                            ^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(parent)  value-parameter parent: [ERROR : ViewGroup]
//                                               ^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)  value-parameter model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>
        val viewType = ViewTypeManager.getViewType(model)
//          ^^^^^^^^ definition local13  val viewType: [ERROR : <ERROR FUNCTION RETURN TYPE>]
//                                                 ^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolder().(model)
        val recycledView = viewPool.getRecycledView(viewType)
//          ^^^^^^^^^^^^ definition local14  val recycledView: [ERROR : <ERROR FUNCTION RETURN TYPE>]
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
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#unbindGroup().  public final fun unbindGroup()
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
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().  private final fun removeAndRecycleView(modelPosition: kotlin.Int)
//                                   ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#removeAndRecycleView().(modelPosition)  value-parameter modelPosition: kotlin.Int
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
//          ^^^^^^^^^^ definition local15  val viewHolder: [ERROR : <ERROR FUNCTION RETURN TYPE>]
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
//            ^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#Companion#  public companion object

        private val HELPER_ADAPTER = HelperAdapter()
//                  ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#Companion#HELPER_ADAPTER.  private final val HELPER_ADAPTER: com.airbnb.epoxy.HelperAdapter
//                  ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#Companion#getHELPER_ADAPTER().  private final val HELPER_ADAPTER: com.airbnb.epoxy.HelperAdapter
//                                   ^^^^^^^^^^^^^ reference com/airbnb/epoxy/HelperAdapter#`<init>`().

        private fun findViewPool(view: ViewParent): RecyclerView.RecycledViewPool {
//                  ^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().  private final fun findViewPool(view: [ERROR : ViewParent]): [ERROR : RecyclerView.RecycledViewPool]
//                               ^^^^ definition com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)  value-parameter view: [ERROR : ViewParent]
            var viewPool: RecyclerView.RecycledViewPool? = null
//              ^^^^^^^^ definition local16  var viewPool: [ERROR : RecyclerView.RecycledViewPool]?
            while (viewPool == null) {
//                 ^^^^^^^^ reference local16
                viewPool = if (view is RecyclerView) {
//              ^^^^^^^^ reference local16
//                             ^^^^ reference com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
                    view.recycledViewPool
//                  ^^^^ reference com/airbnb/epoxy/ModelGroupHolder#Companion#findViewPool().(view)
                } else {
                    val parent = view.parent
//                      ^^^^^^ definition local17  val parent: [ERROR : <ERROR PROPERTY TYPE>]
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
//            ^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#  private final class ViewStubData
//            ^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#`<init>`().  public constructor ViewStubData(viewGroup: [ERROR : ViewGroup], viewStub: [ERROR : ViewStub], position: kotlin.Int)
    val viewGroup: ViewGroup,
//      ^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#viewGroup.  public final val viewGroup: [ERROR : ViewGroup]
//      ^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#getViewGroup().  public final val viewGroup: [ERROR : ViewGroup]
//      ^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#`<init>`().(viewGroup)  value-parameter viewGroup: [ERROR : ViewGroup]
    val viewStub: ViewStub,
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#viewStub.  public final val viewStub: [ERROR : ViewStub]
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#getViewStub().  public final val viewStub: [ERROR : ViewStub]
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#`<init>`().(viewStub)  value-parameter viewStub: [ERROR : ViewStub]
    val position: Int
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#position.  public final val position: kotlin.Int
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#getPosition().  public final val position: kotlin.Int
//      ^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#`<init>`().(position)  value-parameter position: kotlin.Int
//                ^^^ reference kotlin/Int#
) {

    fun setView(view: View, useStubLayoutParams: Boolean) {
//      ^^^^^^^ definition com/airbnb/epoxy/ViewStubData#setView().  public final fun setView(view: [ERROR : View], useStubLayoutParams: kotlin.Boolean)
//              ^^^^ definition com/airbnb/epoxy/ViewStubData#setView().(view)  value-parameter view: [ERROR : View]
//                          ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#setView().(useStubLayoutParams)  value-parameter useStubLayoutParams: kotlin.Boolean
//                                               ^^^^^^^ reference kotlin/Boolean#
        removeCurrentView()
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ViewStubData#removeCurrentView().

        // Carry over the stub id manually since we aren't inflating via the stub
        val inflatedId = viewStub.inflatedId
//          ^^^^^^^^^^ definition local18  val inflatedId: [ERROR : <ERROR PROPERTY TYPE>]
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
//      ^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#resetStub().  public final fun resetStub()
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
//              ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ViewStubData#removeCurrentView().  private final fun removeCurrentView()
        val view = viewGroup.getChildAt(position)
//          ^^^^ definition local19  val view: kotlin.Nothing
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
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/LocalGroupRecycledViewPool#  private final class LocalGroupRecycledViewPool
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/LocalGroupRecycledViewPool#`<init>`().  public constructor LocalGroupRecycledViewPool()

/**
 * A viewholder's viewtype can only be set internally in an adapter when the viewholder
 * is created. To work around that we do the creation in an adapter.
 */
private class HelperAdapter : RecyclerView.Adapter<EpoxyViewHolder>() {
//            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#  private final class HelperAdapter
//            ^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#`<init>`().  public constructor HelperAdapter()

    private var model: EpoxyModel<*>? = null
//              ^^^^^ definition com/airbnb/epoxy/HelperAdapter#model.  private final var model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?
//              ^^^^^ definition com/airbnb/epoxy/HelperAdapter#getModel().  private final var model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?
//              ^^^^^ definition com/airbnb/epoxy/HelperAdapter#setModel().  private final var model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>?
    private var modelGroupParent: ViewParent? = null
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#modelGroupParent.  private final var modelGroupParent: [ERROR : ViewParent]?
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#getModelGroupParent().  private final var modelGroupParent: [ERROR : ViewParent]?
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#setModelGroupParent().  private final var modelGroupParent: [ERROR : ViewParent]?

    fun createViewHolder(
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().  public final fun createViewHolder(modelGroupParent: [ERROR : ViewParent], model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>, parent: [ERROR : ViewGroup], viewType: kotlin.Int): [ERROR : EpoxyViewHolder]
        modelGroupParent: ViewParent,
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().(modelGroupParent)  value-parameter modelGroupParent: [ERROR : ViewParent]
        model: EpoxyModel<*>,
//      ^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().(model)  value-parameter model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>
        parent: ViewGroup,
//      ^^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().(parent)  value-parameter parent: [ERROR : ViewGroup]
        viewType: Int
//      ^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#createViewHolder().(viewType)  value-parameter viewType: kotlin.Int
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
//          ^^^^^^^^^^ definition local20  val viewHolder: [ERROR : EpoxyViewHolder]
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
//               ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().  public open fun onCreateViewHolder(parent: [ERROR : ViewGroup], viewType: kotlin.Int): [ERROR : EpoxyViewHolder]
//                                  ^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(parent)  value-parameter parent: [ERROR : ViewGroup]
//                                                     ^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onCreateViewHolder().(viewType)  value-parameter viewType: kotlin.Int
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
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onBindViewHolder().  public open fun onBindViewHolder(holder: [ERROR : EpoxyViewHolder], position: kotlin.Int)
//                                ^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onBindViewHolder().(holder)  value-parameter holder: [ERROR : EpoxyViewHolder]
//                                                         ^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#onBindViewHolder().(position)  value-parameter position: kotlin.Int
//                                                                   ^^^ reference kotlin/Int#
    }

    override fun getItemCount() = 1
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/HelperAdapter#getItemCount().  public open fun getItemCount(): kotlin.Int
}
