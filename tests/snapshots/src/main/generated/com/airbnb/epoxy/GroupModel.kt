package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

import androidx.annotation.LayoutRes
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#

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
//^^^^^^^^^^^^^^ reference semanticdb maven maven/com.airbnb.android/epoxy-annotations 4.3.1 com/airbnb/epoxy/EpoxyModelClass#`<init>`().
abstract class GroupModel : EpoxyModelGroup, ModelCollector {
//             ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/GroupModel#
//                        documentation ```kt\npublic abstract class GroupModel : com.airbnb.epoxy.ModelCollector\n```\n\n----\n\n\n An [EpoxyModelGroup] usable in a DSL manner via the [group] extension.\n <p>\n Example:\n ```\n group {\n   id("photos")\n   layout(R.layout.photo_grid)\n\n   // add your models here, example:\n   for (photo in photos) {\n     imageView {\n       id(photo.id)\n       url(photo.url)\n     }\n   }\n }\n ```\n
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelCollector#
    constructor() : super()
//  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/GroupModel#`<init>`().
//              documentation ```kt\npublic constructor GroupModel()\n```
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)
//  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/GroupModel#`<init>`(+1).
//              documentation ```kt\npublic constructor GroupModel(layoutRes: kotlin.Int)\n```
//               ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/LayoutRes#`<init>`().
//                         ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/GroupModel#`<init>`(+1).(layoutRes)
//                                   documentation ```kt\nvalue-parameter layoutRes: kotlin.Int\n```
//                                    ^^^ reference semanticdb maven . . kotlin/Int#
//                                                 ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/GroupModel#`<init>`(+1).(layoutRes)

    override fun add(model: EpoxyModel<*>) {
//               ^^^ definition semanticdb maven . . com/airbnb/epoxy/GroupModel#add().
//                   documentation ```kt\npublic open fun add(model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>)\n```
//                   ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/GroupModel#add().(model)
//                         documentation ```kt\nvalue-parameter model: [ERROR : EpoxyModel<*>]<out [ERROR : *]>\n```
        super.addModel(model)
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelCollector#
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/GroupModel#add().(model)
    }
}
