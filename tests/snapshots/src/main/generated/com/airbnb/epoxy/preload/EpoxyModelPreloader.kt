package com.airbnb.epoxy.preload
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/

import android.view.View
import com.airbnb.epoxy.EpoxyModel
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

/**
 * Describes how view content for an EpoxyModel should be preloaded.
 *
 * @param T The type of EpoxyModel that this preloader applies to
 * @param U The type of view metadata to provide to the request builder.
 * @param P The type of [PreloadRequestHolder] that will execute the preload request
 */
abstract class EpoxyModelPreloader<T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder>(
//             ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                 display_name EpoxyModelPreloader
//                                 documentation ```kt\npublic abstract class EpoxyModelPreloader<T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```\n\n----\n\n\n Describes how view content for an EpoxyModel should be preloaded.\n\n @param T The type of EpoxyModel that this preloader applies to\n @param U The type of view metadata to provide to the request builder.\n @param P The type of [PreloadRequestHolder] that will execute the preload request\n
//             ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().
//                                 display_name EpoxyModelPreloader
//                                 documentation ```kt\npublic constructor EpoxyModelPreloader<T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder>(modelType: java.lang.Class<T>, preloadableViewIds: kotlin.collections.List<kotlin.Int>)\n```
//                                 ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]
//                                   display_name T
//                                   documentation ```kt\n<T>\n```
//                                                    ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#[U]
//                                                      display_name U
//                                                      documentation ```kt\n<U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                                       ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#[P]
//                                                                         display_name P
//                                                                         documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                                                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#

    val modelType: Class<T>,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(modelType)
//                display_name modelType
//                documentation ```kt\nvalue-parameter modelType: java.lang.Class<T>\n```
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#getModelType().
//                display_name modelType
//                documentation ```kt\npublic final val modelType: java.lang.Class<T>\n```
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#modelType.
//                display_name modelType
//                documentation ```kt\npublic final val modelType: java.lang.Class<T>\n```
//                 ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                       ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]

    /**
     * A list of view ids, one for each view that should be preloaded.
     * This should be left empty if the EpoxyModel's type uses the [Preloadable] interface.
     */
    val preloadableViewIds: List<Int>
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(preloadableViewIds)
//                         display_name preloadableViewIds
//                         documentation ```kt\nvalue-parameter preloadableViewIds: kotlin.collections.List<kotlin.Int>\n```\n\n----\n\n\n A list of view ids, one for each view that should be preloaded.\n This should be left empty if the EpoxyModel's type uses the [Preloadable] interface.\n
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#getPreloadableViewIds().
//                         display_name preloadableViewIds
//                         documentation ```kt\npublic final val preloadableViewIds: kotlin.collections.List<kotlin.Int>\n```\n\n----\n\n\n A list of view ids, one for each view that should be preloaded.\n This should be left empty if the EpoxyModel's type uses the [Preloadable] interface.\n
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#preloadableViewIds.
//                         display_name preloadableViewIds
//                         documentation ```kt\npublic final val preloadableViewIds: kotlin.collections.List<kotlin.Int>\n```\n\n----\n\n\n A list of view ids, one for each view that should be preloaded.\n This should be left empty if the EpoxyModel's type uses the [Preloadable] interface.\n
//                          ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                               ^^^ reference semanticdb maven . . kotlin/Int#
) {

    /**
     * An optional signature to differentiate views within the same model. This is useful if your EpoxyModel can contain varying amounts of preloadable views,
     * or preloadable views of varying sizes.
     *
     * By default the model's class, span size, and layout resource, are used to differentiate views. This signature allows additional differentiation.
     * For example, if your EpoxyModel shows an preloadable view that varies between portrait or landscape, this orientation will affect the view dimensions.
     * In this case you could return a boolean here to differentiate the two cases so that the preloaded data has the correct orientation.
     *
     * The returned object can be anything, but it must implement [Object.hashCode]
     */
    open fun viewSignature(epoxyModel: T): Any? = null
//           ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#viewSignature().
//                         display_name viewSignature
//                         documentation ```kt\npublic open fun viewSignature(epoxyModel: T): kotlin.Any?\n```\n\n----\n\n\n An optional signature to differentiate views within the same model. This is useful if your EpoxyModel can contain varying amounts of preloadable views,\n or preloadable views of varying sizes.\n\n By default the model's class, span size, and layout resource, are used to differentiate views. This signature allows additional differentiation.\n For example, if your EpoxyModel shows an preloadable view that varies between portrait or landscape, this orientation will affect the view dimensions.\n In this case you could return a boolean here to differentiate the two cases so that the preloaded data has the correct orientation.\n\n The returned object can be anything, but it must implement [Object.hashCode]\n
//                         ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#viewSignature().(epoxyModel)
//                                    display_name epoxyModel
//                                    documentation ```kt\nvalue-parameter epoxyModel: T\n```
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]
//                                         ^^^ reference semanticdb maven . . kotlin/Any#

    /**
     * Provide optional metadata about a view. This can be used in [EpoxyModelPreloader.buildRequest]
     *
     * A preload request works best if it exactly matches the actual request (in order to match cache keys exactly)
     * Things such as request transformations, thumbnails, or crop type can affect the cache key.
     * If your preloadable view is configurable you can capture those options via this metadata.
     */
    abstract fun buildViewMetadata(view: View): U
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#buildViewMetadata().
//                                 display_name buildViewMetadata
//                                 documentation ```kt\npublic abstract fun buildViewMetadata(view: [Error type: Unresolved type for View]): U\n```\n\n----\n\n\n Provide optional metadata about a view. This can be used in [EpoxyModelPreloader.buildRequest]\n\n A preload request works best if it exactly matches the actual request (in order to match cache keys exactly)\n Things such as request transformations, thumbnails, or crop type can affect the cache key.\n If your preloadable view is configurable you can capture those options via this metadata.\n
//                                 ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#buildViewMetadata().(view)
//                                      display_name view
//                                      documentation ```kt\nvalue-parameter view: [Error type: Unresolved type for View]\n```
//                                              ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#[U]

    /**
     * Start a preload request with the given target.
     *
     * @param epoxyModel The EpoxyModel whose content is being preloaded.
     * @param preloadTarget The target to ues to create and store the request.
     * @param viewData Information about the view that will hold the preloaded content.
     */
    abstract fun startPreload(
//               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().
//                            display_name startPreload
//                            documentation ```kt\npublic abstract fun startPreload(epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>)\n```\n\n----\n\n\n Start a preload request with the given target.\n\n @param epoxyModel The EpoxyModel whose content is being preloaded.\n @param preloadTarget The target to ues to create and store the request.\n @param viewData Information about the view that will hold the preloaded content.\n
        epoxyModel: T,
//      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().(epoxyModel)
//                 display_name epoxyModel
//                 documentation ```kt\nvalue-parameter epoxyModel: T\n```
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]
        preloadTarget: P,
//      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().(preloadTarget)
//                    display_name preloadTarget
//                    documentation ```kt\nvalue-parameter preloadTarget: P\n```
//                     ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#[P]
        viewData: ViewData<U>
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().(viewData)
//               display_name viewData
//               documentation ```kt\nvalue-parameter viewData: com.airbnb.epoxy.preload.ViewData<U>\n```
//                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//                         ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#[U]
    )

    companion object {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion# 1:0
//                     display_name Companion
//                     documentation ```kt\npublic companion object\n```

        /**
         * Helper to create a [EpoxyModelPreloader].
         *
         * @param viewSignature see [EpoxyModelPreloader.viewSignature]
         * @param preloadableViewIds see [EpoxyModelPreloader.preloadableViewIds]
         * @param viewMetadata see [EpoxyModelPreloader.buildViewMetadata]
         * @param doPreload see [EpoxyModelPreloader.startPreload]
         */
        inline fun <reified T : EpoxyModel<*>, P : PreloadRequestHolder> with(
//                          ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[T]
//                            display_name T
//                            documentation ```kt\n<reified T>\n```
//                                             ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[P]
//                                               display_name P
//                                               documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                       ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().
//                                                                            display_name with
//                                                                            documentation ```kt\npublic final inline fun <reified T, P : com.airbnb.epoxy.preload.PreloadRequestHolder> with(preloadableViewIds: kotlin.collections.List<kotlin.Int> = ..., noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<com.airbnb.epoxy.preload.ViewMetadata?>) -> kotlin.Unit): com.airbnb.epoxy.preload.EpoxyModelPreloader<T, com.airbnb.epoxy.preload.ViewMetadata?, P>\n```\n\n----\n\n\n Helper to create a [EpoxyModelPreloader].\n\n @param viewSignature see [EpoxyModelPreloader.viewSignature]\n @param preloadableViewIds see [EpoxyModelPreloader.preloadableViewIds]\n @param viewMetadata see [EpoxyModelPreloader.buildViewMetadata]\n @param doPreload see [EpoxyModelPreloader.startPreload]\n
            preloadableViewIds: List<Int> = emptyList(),
//          ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(preloadableViewIds)
//                             display_name preloadableViewIds
//                             documentation ```kt\nvalue-parameter preloadableViewIds: kotlin.collections.List<kotlin.Int> = ...\n```
//                              ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                   ^^^ reference semanticdb maven . . kotlin/Int#
//                                          ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#emptyList().
            noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: ViewData<ViewMetadata?>) -> Unit
//                   ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(doPreload)
//                             display_name doPreload
//                             documentation ```kt\nvalue-parameter noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<com.airbnb.epoxy.preload.ViewMetadata?>) -> kotlin.Unit\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().epoxyModel.
//                                          display_name epoxyModel
//                                          documentation ```kt\nval epoxyModel: T\n```
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[T]
//                                              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().preloadTarget.
//                                                            display_name preloadTarget
//                                                            documentation ```kt\nval preloadTarget: P\n```
//                                                             ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[P]
//                                                                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().viewData.
//                                                                         display_name viewData
//                                                                         documentation ```kt\nval viewData: com.airbnb.epoxy.preload.ViewData<com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                                                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                                      ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#
        ): EpoxyModelPreloader<T, ViewMetadata?, P> =
//         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[T]
//                                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                               ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[P]
            with(
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).
                preloadableViewIds,
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(preloadableViewIds)
                viewMetadata = { ViewMetadata.getDefault(it) },
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewMetadata)
//                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#Companion#
//                                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().
//                                                       ^^ reference local 0
                viewSignature = { null },
//              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewSignature)
                doPreload = doPreload
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(doPreload)
//                          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(doPreload)
            )

        /**
         * Helper to create a [EpoxyModelPreloader].
         *
         * @param viewSignature see [EpoxyModelPreloader.viewSignature]
         * @param preloadableViewIds see [EpoxyModelPreloader.preloadableViewIds]
         * @param viewMetadata see [EpoxyModelPreloader.buildViewMetadata]
         * @param doPreload see [EpoxyModelPreloader.startPreload]
         */
        inline fun <reified T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> with(
//                          ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                            display_name T
//                            documentation ```kt\n<reified T>\n```
//                                             ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U]
//                                               display_name U
//                                               documentation ```kt\n<U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                                ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[P]
//                                                                  display_name P
//                                                                  documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                                          ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).
//                                                                                               display_name with
//                                                                                               documentation ```kt\npublic final inline fun <reified T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> with(preloadableViewIds: kotlin.collections.List<kotlin.Int> = ..., noinline viewMetadata: ([Error type: Unresolved type for View]) -> U, noinline viewSignature: (T) -> kotlin.Any? = ..., noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>) -> kotlin.Unit): com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```\n\n----\n\n\n Helper to create a [EpoxyModelPreloader].\n\n @param viewSignature see [EpoxyModelPreloader.viewSignature]\n @param preloadableViewIds see [EpoxyModelPreloader.preloadableViewIds]\n @param viewMetadata see [EpoxyModelPreloader.buildViewMetadata]\n @param doPreload see [EpoxyModelPreloader.startPreload]\n
            preloadableViewIds: List<Int> = emptyList(),
//          ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(preloadableViewIds)
//                             display_name preloadableViewIds
//                             documentation ```kt\nvalue-parameter preloadableViewIds: kotlin.collections.List<kotlin.Int> = ...\n```
//                              ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                   ^^^ reference semanticdb maven . . kotlin/Int#
//                                          ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#emptyList().
            noinline viewMetadata: (View) -> U,
//                   ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewMetadata)
//                                display_name viewMetadata
//                                documentation ```kt\nvalue-parameter noinline viewMetadata: ([Error type: Unresolved type for View]) -> U\n```
//                                  ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).`<no name provided>`.
//                                       display_name T
//                                       documentation ```kt\nval `<no name provided>`: T\n```
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U]
            noinline viewSignature: (T) -> Any? = { _ -> null },
//                   ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewSignature)
//                                 display_name viewSignature
//                                 documentation ```kt\nvalue-parameter noinline viewSignature: (T) -> kotlin.Any? = ...\n```
//                                   ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                   ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).`<no name provided>`.
//                                     display_name T
//                                     documentation ```kt\nval `<no name provided>`: T\n```
//                                         ^^^ reference semanticdb maven . . kotlin/Any#
//                                                  ^ definition local 1
//                                                    display_name _
//                                                    documentation ```kt\nvalue-parameter `<anonymous parameter 0>`: T\n```
            noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: ViewData<U>) -> Unit
//                   ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(doPreload)
//                             display_name doPreload
//                             documentation ```kt\nvalue-parameter noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>) -> kotlin.Unit\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).epoxyModel.
//                                          display_name epoxyModel
//                                          documentation ```kt\nval epoxyModel: T\n```
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).preloadTarget.
//                                                            display_name preloadTarget
//                                                            documentation ```kt\nval preloadTarget: P\n```
//                                                             ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[P]
//                                                                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).viewData.
//                                                                         display_name viewData
//                                                                         documentation ```kt\nval viewData: com.airbnb.epoxy.preload.ViewData<U>\n```
//                                                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//                                                                                   ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U]
//                                                                                          ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#
        ): EpoxyModelPreloader<T, U, P> =
//         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U]
//                                   ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[P]
            with(
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).
                preloadableViewIds = preloadableViewIds,
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(preloadableViewIds)
//                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(preloadableViewIds)
                epoxyModelClass = T::class.java,
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(epoxyModelClass)
//                                ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                         ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/jvm/JvmClassMappingKt#java.
                viewMetadata = viewMetadata,
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewMetadata)
//                             ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewMetadata)
                viewSignature = viewSignature,
//              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewSignature)
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewSignature)
                doPreload = doPreload
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(doPreload)
//                          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(doPreload)
            )

        /**
         * Helper to create a [EpoxyModelPreloader]. This is similar to the other helper methods but not inlined so it can be used with Java.
         *
         * @param epoxyModelClass The specific type of EpoxyModel that this preloader is for.
         * @param viewSignature see [EpoxyModelPreloader.viewSignature]
         * @param preloadableViewIds see [EpoxyModelPreloader.preloadableViewIds]
         * @param viewMetadata see [EpoxyModelPreloader.buildViewMetadata]
         * @param doPreload see [EpoxyModelPreloader.startPreload]
         */
        fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> with(
//           ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//             display_name T
//             documentation ```kt\n<T>\n```
//                              ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
//                                display_name U
//                                documentation ```kt\n<U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                 ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                   display_name P
//                                                   documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                           ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).
//                                                                                display_name with
//                                                                                documentation ```kt\npublic final fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> with(preloadableViewIds: kotlin.collections.List<kotlin.Int> = ..., epoxyModelClass: java.lang.Class<T>, viewMetadata: ([Error type: Unresolved type for View]) -> U, viewSignature: (T) -> kotlin.Any? = ..., doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>) -> kotlin.Unit): com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```\n\n----\n\n\n Helper to create a [EpoxyModelPreloader]. This is similar to the other helper methods but not inlined so it can be used with Java.\n\n @param epoxyModelClass The specific type of EpoxyModel that this preloader is for.\n @param viewSignature see [EpoxyModelPreloader.viewSignature]\n @param preloadableViewIds see [EpoxyModelPreloader.preloadableViewIds]\n @param viewMetadata see [EpoxyModelPreloader.buildViewMetadata]\n @param doPreload see [EpoxyModelPreloader.startPreload]\n
            preloadableViewIds: List<Int> = emptyList(),
//          ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(preloadableViewIds)
//                             display_name preloadableViewIds
//                             documentation ```kt\nvalue-parameter preloadableViewIds: kotlin.collections.List<kotlin.Int> = ...\n```
//                              ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                   ^^^ reference semanticdb maven . . kotlin/Int#
//                                          ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#emptyList().
            epoxyModelClass: Class<T>,
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(epoxyModelClass)
//                          display_name epoxyModelClass
//                          documentation ```kt\nvalue-parameter epoxyModelClass: java.lang.Class<T>\n```
//                           ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
//                                 ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
            viewMetadata: (View) -> U,
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewMetadata)
//                       display_name viewMetadata
//                       documentation ```kt\nvalue-parameter viewMetadata: ([Error type: Unresolved type for View]) -> U\n```
//                         ^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).`<no name provided>`.
//                              display_name T
//                              documentation ```kt\nval `<no name provided>`: T\n```
//                                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
            viewSignature: (T) -> Any? = { _ -> null },
//          ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewSignature)
//                        display_name viewSignature
//                        documentation ```kt\nvalue-parameter viewSignature: (T) -> kotlin.Any? = ...\n```
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                          ^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).`<no name provided>`.
//                            display_name T
//                            documentation ```kt\nval `<no name provided>`: T\n```
//                                ^^^ reference semanticdb maven . . kotlin/Any#
//                                         ^ definition local 2
//                                           display_name _
//                                           documentation ```kt\nvalue-parameter `<anonymous parameter 0>`: T\n```
            doPreload: (epoxyModel: T, preloadTarget: P, viewData: ViewData<U>) -> Unit
//          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(doPreload)
//                    display_name doPreload
//                    documentation ```kt\nvalue-parameter doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>) -> kotlin.Unit\n```
//                      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).epoxyModel.
//                                 display_name epoxyModel
//                                 documentation ```kt\nval epoxyModel: T\n```
//                                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                     ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).preloadTarget.
//                                                   display_name preloadTarget
//                                                   documentation ```kt\nval preloadTarget: P\n```
//                                                    ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).viewData.
//                                                                display_name viewData
//                                                                documentation ```kt\nval viewData: com.airbnb.epoxy.preload.ViewData<U>\n```
//                                                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//                                                                          ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
//                                                                                 ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#
        ): EpoxyModelPreloader<T, U, P> = object : EpoxyModelPreloader<T, U, P>(
//         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                             ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
//                                   ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().
//                                                                     ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                                                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
//                                                                           ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
            modelType = epoxyModelClass,
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(modelType)
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(epoxyModelClass)
            preloadableViewIds = preloadableViewIds
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(preloadableViewIds)
//                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(preloadableViewIds)
        ) {

            override fun buildViewMetadata(view: View) = viewMetadata(view)
//                       ^^^^^^^^^^^^^^^^^ definition local 3
//                                         display_name buildViewMetadata
//                                         documentation ```kt\npublic open fun buildViewMetadata(view: [Error type: Unresolved type for View]): U\n```
//                                         relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#buildViewMetadata().
//                                         ^^^^ definition local 4
//                                              display_name view
//                                              documentation ```kt\nvalue-parameter view: [Error type: Unresolved type for View]\n```
//                                                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewMetadata)
//                                                                    ^^^^ reference local 4

            override fun viewSignature(epoxyModel: T) = viewSignature(epoxyModel)
//                       ^^^^^^^^^^^^^ definition local 5
//                                     display_name viewSignature
//                                     documentation ```kt\npublic open fun viewSignature(epoxyModel: T): kotlin.Any?\n```
//                                     relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#viewSignature().
//                                     ^^^^^^^^^^ definition local 6
//                                                display_name epoxyModel
//                                                documentation ```kt\nvalue-parameter epoxyModel: T\n```
//                                                 ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewSignature)
//                                                                    ^^^^^^^^^^ reference local 6

            override fun startPreload(epoxyModel: T, preloadTarget: P, viewData: ViewData<U>) {
//                       ^^^^^^^^^^^^ definition local 7
//                                    display_name startPreload
//                                    documentation ```kt\npublic open fun startPreload(epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>)\n```
//                                    relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().
//                                    ^^^^^^^^^^ definition local 8
//                                               display_name epoxyModel
//                                               documentation ```kt\nvalue-parameter epoxyModel: T\n```
//                                                ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                                   ^^^^^^^^^^^^^ definition local 9
//                                                                 display_name preloadTarget
//                                                                 documentation ```kt\nvalue-parameter preloadTarget: P\n```
//                                                                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                                     ^^^^^^^^ definition local 10
//                                                                              display_name viewData
//                                                                              documentation ```kt\nvalue-parameter viewData: com.airbnb.epoxy.preload.ViewData<U>\n```
//                                                                               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//                                                                                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
                doPreload(epoxyModel, preloadTarget, viewData)
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(doPreload)
//                        ^^^^^^^^^^ reference local 8
//                                    ^^^^^^^^^^^^^ reference local 9
//                                                   ^^^^^^^^ reference local 10
            }
        }
    }
}
