package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

import androidx.annotation.LayoutRes
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/LayoutRes#

/**
 * An [EpoxyModelGroup] usable in a DSL manner via the [group] extension.
 * <p>
 * Example:
 * ```
 * group {
 *   id("photos")
 *   layout(R.layout.photo_grid)
 *
 *   // add your models here, example:
 *   for (photo in photos) {
 *     imageView {
 *       id(photo.id)
 *       url(photo.url)
 *     }
 *   }
 * }
 * ```
 */
@EpoxyModelClass
//^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModelClass#`<init>`().
abstract class GroupModel : EpoxyModelGroup, ModelCollector {
//             ^^^^^^^^^^ definition com/airbnb/epoxy/GroupModel#
//                                           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelCollector#
    constructor() : super()
//  ^^^^^^^^^^^ definition com/airbnb/epoxy/GroupModel#`<init>`().
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)
//  ^^^^^^^^^^^ definition com/airbnb/epoxy/GroupModel#`<init>`(+1).
//               ^^^^^^^^^ reference androidx/annotation/LayoutRes#`<init>`().
//                         ^^^^^^^^^ definition com/airbnb/epoxy/GroupModel#`<init>`(+1).(layoutRes)
//                                    ^^^ reference kotlin/Int#
//                                                 ^^^^^^^^^ reference com/airbnb/epoxy/GroupModel#`<init>`(+1).(layoutRes)

    override fun add(model: EpoxyModel<*>) {
//               ^^^ definition com/airbnb/epoxy/GroupModel#add().
//                   ^^^^^ definition com/airbnb/epoxy/GroupModel#add().(model)
        super.addModel(model)
//      ^^^^^ reference com/airbnb/epoxy/ModelCollector#
//                     ^^^^^ reference com/airbnb/epoxy/GroupModel#add().(model)
    }
}
