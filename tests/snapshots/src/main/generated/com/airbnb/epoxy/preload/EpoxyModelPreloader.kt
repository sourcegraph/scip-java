package com.airbnb.epoxy.preload
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/
//                       ^^^^^^^ reference com/airbnb/epoxy/preload/

import android.view.View
import com.airbnb.epoxy.EpoxyModel
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/

/**
 * Describes how view content for an EpoxyModel should be preloaded.
 *
 * @param T The type of EpoxyModel that this preloader applies to
 * @param U The type of view metadata to provide to the request builder.
 * @param P The type of [PreloadRequestHolder] that will execute the preload request
 */
abstract class EpoxyModelPreloader<T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder>(
//             ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#
//             ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().
//                                 ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]
//                                                    ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#[U]
//                                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                                       ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#[P]
//                                                                           ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#

    val modelType: Class<T>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#modelType.
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#getModelType().
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(modelType)
//                 ^^^^^ reference java/lang/Class#
//                       ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]

    /**
     * A list of view ids, one for each view that should be preloaded.
     * This should be left empty if the EpoxyModel's type uses the [Preloadable] interface.
     */
    val preloadableViewIds: List<Int>
//      ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#preloadableViewIds.
//      ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#getPreloadableViewIds().
//      ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(preloadableViewIds)
//                          ^^^^ reference kotlin/collections/List#
//                               ^^^ reference kotlin/Int#
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
//           ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#viewSignature().
//                         ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#viewSignature().(epoxyModel)
//                                     ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]
//                                         ^^^ reference kotlin/Any#

    /**
     * Provide optional metadata about a view. This can be used in [EpoxyModelPreloader.buildRequest]
     *
     * A preload request works best if it exactly matches the actual request (in order to match cache keys exactly)
     * Things such as request transformations, thumbnails, or crop type can affect the cache key.
     * If your preloadable view is configurable you can capture those options via this metadata.
     */
    abstract fun buildViewMetadata(view: View): U
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#buildViewMetadata().
//                                 ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#buildViewMetadata().(view)
//                                              ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[U]

    /**
     * Start a preload request with the given target.
     *
     * @param epoxyModel The EpoxyModel whose content is being preloaded.
     * @param preloadTarget The target to ues to create and store the request.
     * @param viewData Information about the view that will hold the preloaded content.
     */
    abstract fun startPreload(
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().
        epoxyModel: T,
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().(epoxyModel)
//                  ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]
        preloadTarget: P,
//      ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().(preloadTarget)
//                     ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[P]
        viewData: ViewData<U>
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().(viewData)
//                ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                         ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[U]
    )

    companion object {

        /**
         * Helper to create a [EpoxyModelPreloader].
         *
         * @param viewSignature see [EpoxyModelPreloader.viewSignature]
         * @param preloadableViewIds see [EpoxyModelPreloader.preloadableViewIds]
         * @param viewMetadata see [EpoxyModelPreloader.buildViewMetadata]
         * @param doPreload see [EpoxyModelPreloader.startPreload]
         */
        inline fun <reified T : EpoxyModel<*>, P : PreloadRequestHolder> with(
//                          ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[T]
//                                             ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[P]
//                                                 ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                       ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().
            preloadableViewIds: List<Int> = emptyList(),
//          ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(preloadableViewIds)
//                              ^^^^ reference kotlin/collections/List#
//                                   ^^^ reference kotlin/Int#
//                                          ^^^^^^^^^ reference kotlin/collections/CollectionsKt#emptyList().
            noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: ViewData<ViewMetadata?>) -> Unit
//                   ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(doPreload)
//                               ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().epoxyModel.
//                                           ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[T]
//                                              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().preloadTarget.
//                                                             ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[P]
//                                                                ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().viewData.
//                                                                          ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                                                                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                                      ^^^^ reference kotlin/Unit#
        ): EpoxyModelPreloader<T, ViewMetadata?, P> =
//         ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                             ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[T]
//                                ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                               ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[P]
            with(
//          ^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).
                preloadableViewIds,
//              ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(preloadableViewIds)
                viewMetadata = { ViewMetadata.getDefault(it) },
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewMetadata)
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#Companion#
//                                            ^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().
//                                                       ^^ reference local0
                viewSignature = { null },
//              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewSignature)
                doPreload = doPreload
//              ^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(doPreload)
//                          ^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(doPreload)
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
//                          ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                             ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U]
//                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                                ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[P]
//                                                                    ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                                          ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).
            preloadableViewIds: List<Int> = emptyList(),
//          ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(preloadableViewIds)
//                              ^^^^ reference kotlin/collections/List#
//                                   ^^^ reference kotlin/Int#
//                                          ^^^^^^^^^ reference kotlin/collections/CollectionsKt#emptyList().
            noinline viewMetadata: (View) -> U,
//                   ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewMetadata)
//                                  ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).`<no name provided>`.
//                                           ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U]
            noinline viewSignature: (T) -> Any? = { _ -> null },
//                   ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewSignature)
//                                   ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).`<no name provided>`.
//                                   ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                         ^^^ reference kotlin/Any#
//                                                  ^ definition local1
            noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: ViewData<U>) -> Unit
//                   ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(doPreload)
//                               ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).epoxyModel.
//                                           ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).preloadTarget.
//                                                             ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[P]
//                                                                ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).viewData.
//                                                                          ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                                                                                   ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U]
//                                                                                          ^^^^ reference kotlin/Unit#
        ): EpoxyModelPreloader<T, U, P> =
//         ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                             ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U]
//                                   ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[P]
            with(
//          ^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).
                preloadableViewIds = preloadableViewIds,
//              ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(preloadableViewIds)
//                                   ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(preloadableViewIds)
                epoxyModelClass = T::class.java,
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(epoxyModelClass)
//                                ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                         ^^^^ reference kotlin/jvm/JvmClassMappingKt#java.
                viewMetadata = viewMetadata,
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewMetadata)
//                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewMetadata)
                viewSignature = viewSignature,
//              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewSignature)
//                              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewSignature)
                doPreload = doPreload
//              ^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(doPreload)
//                          ^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(doPreload)
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
//           ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                              ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
//                                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                 ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                     ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                           ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).
            preloadableViewIds: List<Int> = emptyList(),
//          ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(preloadableViewIds)
//                              ^^^^ reference kotlin/collections/List#
//                                   ^^^ reference kotlin/Int#
//                                          ^^^^^^^^^ reference kotlin/collections/CollectionsKt#emptyList().
            epoxyModelClass: Class<T>,
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(epoxyModelClass)
//                           ^^^^^ reference java/lang/Class#
//                                 ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
            viewMetadata: (View) -> U,
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewMetadata)
//                         ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).`<no name provided>`.
//                                  ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
            viewSignature: (T) -> Any? = { _ -> null },
//          ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewSignature)
//                          ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).`<no name provided>`.
//                          ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                ^^^ reference kotlin/Any#
//                                         ^ definition local2
            doPreload: (epoxyModel: T, preloadTarget: P, viewData: ViewData<U>) -> Unit
//          ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(doPreload)
//                      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).epoxyModel.
//                                  ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                     ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).preloadTarget.
//                                                    ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                       ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).viewData.
//                                                                 ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                                                                          ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
//                                                                                 ^^^^ reference kotlin/Unit#
        ): EpoxyModelPreloader<T, U, P> = object : EpoxyModelPreloader<T, U, P>(
//         ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                             ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
//                                   ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().
//                                                                     ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                                                        ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
//                                                                           ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
            modelType = epoxyModelClass,
//          ^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(modelType)
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(epoxyModelClass)
            preloadableViewIds = preloadableViewIds
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(preloadableViewIds)
//                               ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(preloadableViewIds)
        ) {

            override fun buildViewMetadata(view: View) = viewMetadata(view)
//                       ^^^^^^^^^^^^^^^^^ definition local3
//                                         ^^^^ definition local4
//                                                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewMetadata)
//                                                                    ^^^^ reference local4

            override fun viewSignature(epoxyModel: T) = viewSignature(epoxyModel)
//                       ^^^^^^^^^^^^^ definition local5
//                                     ^^^^^^^^^^ definition local6
//                                                 ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewSignature)
//                                                                    ^^^^^^^^^^ reference local6

            override fun startPreload(epoxyModel: T, preloadTarget: P, viewData: ViewData<U>) {
//                       ^^^^^^^^^^^^ definition local7
//                                    ^^^^^^^^^^ definition local8
//                                                ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                                   ^^^^^^^^^^^^^ definition local9
//                                                                  ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                                     ^^^^^^^^ definition local10
//                                                                               ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                                                                                        ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
                doPreload(epoxyModel, preloadTarget, viewData)
//              ^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(doPreload)
//                        ^^^^^^^^^^ reference local8
//                                    ^^^^^^^^^^^^^ reference local9
//                                                   ^^^^^^^^ reference local10
            }
        }
    }
}
