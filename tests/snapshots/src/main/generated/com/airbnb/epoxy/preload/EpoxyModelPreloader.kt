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
//             ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader# public abstract class EpoxyModelPreloader<T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//             ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`(). public constructor EpoxyModelPreloader<T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder>(modelType: java.lang.Class<T>, preloadableViewIds: kotlin.collections.List<kotlin.Int>)
//                                 ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#[T] <T>
//                                                    ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#[U] <U : com.airbnb.epoxy.preload.ViewMetadata?>
//                                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                                       ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#[P] <P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//                                                                           ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#

    val modelType: Class<T>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#modelType. public final val modelType: java.lang.Class<T>
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#getModelType(). public final val modelType: java.lang.Class<T>
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(modelType) value-parameter modelType: java.lang.Class<T>
//                 ^^^^^ reference java/lang/Class#
//                       ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]

    /**
     * A list of view ids, one for each view that should be preloaded.
     * This should be left empty if the EpoxyModel's type uses the [Preloadable] interface.
     */
    val preloadableViewIds: List<Int>
//      ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#preloadableViewIds. public final val preloadableViewIds: kotlin.collections.List<kotlin.Int>
//      ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#getPreloadableViewIds(). public final val preloadableViewIds: kotlin.collections.List<kotlin.Int>
//      ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#`<init>`().(preloadableViewIds) value-parameter preloadableViewIds: kotlin.collections.List<kotlin.Int>
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
//           ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#viewSignature(). public open fun viewSignature(epoxyModel: T): kotlin.Any?
//                         ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#viewSignature().(epoxyModel) value-parameter epoxyModel: T
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
//               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#buildViewMetadata(). public abstract fun buildViewMetadata(view: [ERROR : View]): U
//                                 ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#buildViewMetadata().(view) value-parameter view: [ERROR : View]
//                                              ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[U]

    /**
     * Start a preload request with the given target.
     *
     * @param epoxyModel The EpoxyModel whose content is being preloaded.
     * @param preloadTarget The target to ues to create and store the request.
     * @param viewData Information about the view that will hold the preloaded content.
     */
    abstract fun startPreload(
//               ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload(). public abstract fun startPreload(epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>)
        epoxyModel: T,
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().(epoxyModel) value-parameter epoxyModel: T
//                  ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[T]
        preloadTarget: P,
//      ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().(preloadTarget) value-parameter preloadTarget: P
//                     ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[P]
        viewData: ViewData<U>
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().(viewData) value-parameter viewData: com.airbnb.epoxy.preload.ViewData<U>
//                ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                         ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#[U]
    )

    companion object {
//            ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion# public companion object

        /**
         * Helper to create a [EpoxyModelPreloader].
         *
         * @param viewSignature see [EpoxyModelPreloader.viewSignature]
         * @param preloadableViewIds see [EpoxyModelPreloader.preloadableViewIds]
         * @param viewMetadata see [EpoxyModelPreloader.buildViewMetadata]
         * @param doPreload see [EpoxyModelPreloader.startPreload]
         */
        inline fun <reified T : EpoxyModel<*>, P : PreloadRequestHolder> with(
//                          ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[T] <reified T>
//                                             ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[P] <P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//                                                 ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                       ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(). public final inline fun <reified T, P : com.airbnb.epoxy.preload.PreloadRequestHolder> with(preloadableViewIds: kotlin.collections.List<kotlin.Int> = ..., noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<com.airbnb.epoxy.preload.ViewMetadata?>) -> kotlin.Unit): com.airbnb.epoxy.preload.EpoxyModelPreloader<T, com.airbnb.epoxy.preload.ViewMetadata?, P>
            preloadableViewIds: List<Int> = emptyList(),
//          ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(preloadableViewIds) value-parameter preloadableViewIds: kotlin.collections.List<kotlin.Int> = ...
//                              ^^^^ reference kotlin/collections/List#
//                                   ^^^ reference kotlin/Int#
//                                          ^^^^^^^^^ reference kotlin/collections/CollectionsKt#emptyList().
            noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: ViewData<ViewMetadata?>) -> Unit
//                   ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().(doPreload) value-parameter noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<com.airbnb.epoxy.preload.ViewMetadata?>) -> kotlin.Unit
//                               ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().epoxyModel. val epoxyModel: T
//                                           ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[T]
//                                              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().preloadTarget. val preloadTarget: P
//                                                             ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().[P]
//                                                                ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with().viewData. val viewData: com.airbnb.epoxy.preload.ViewData<com.airbnb.epoxy.preload.ViewMetadata?>
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
//                          ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T] <reified T>
//                                             ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U] <U : com.airbnb.epoxy.preload.ViewMetadata?>
//                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                                ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[P] <P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//                                                                    ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                                          ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1). public final inline fun <reified T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> with(preloadableViewIds: kotlin.collections.List<kotlin.Int> = ..., noinline viewMetadata: ([ERROR : View]) -> U, noinline viewSignature: (T) -> kotlin.Any? = ..., noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>) -> kotlin.Unit): com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>
            preloadableViewIds: List<Int> = emptyList(),
//          ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(preloadableViewIds) value-parameter preloadableViewIds: kotlin.collections.List<kotlin.Int> = ...
//                              ^^^^ reference kotlin/collections/List#
//                                   ^^^ reference kotlin/Int#
//                                          ^^^^^^^^^ reference kotlin/collections/CollectionsKt#emptyList().
            noinline viewMetadata: (View) -> U,
//                   ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewMetadata) value-parameter noinline viewMetadata: ([ERROR : View]) -> U
//                                  ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).`<no name provided>`. val <no name provided>: T
//                                           ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[U]
            noinline viewSignature: (T) -> Any? = { _ -> null },
//                   ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(viewSignature) value-parameter noinline viewSignature: (T) -> kotlin.Any? = ...
//                                   ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).`<no name provided>`. val <no name provided>: T
//                                   ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                         ^^^ reference kotlin/Any#
//                                                  ^ definition local1 value-parameter <anonymous parameter 0>: T
            noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: ViewData<U>) -> Unit
//                   ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).(doPreload) value-parameter noinline doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>) -> kotlin.Unit
//                               ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).epoxyModel. val epoxyModel: T
//                                           ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[T]
//                                              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).preloadTarget. val preloadTarget: P
//                                                             ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).[P]
//                                                                ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+1).viewData. val viewData: com.airbnb.epoxy.preload.ViewData<U>
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
//           ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T] <T>
//                              ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U] <U : com.airbnb.epoxy.preload.ViewMetadata?>
//                                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                 ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P] <P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//                                                     ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                           ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2). public final fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> with(preloadableViewIds: kotlin.collections.List<kotlin.Int> = ..., epoxyModelClass: java.lang.Class<T>, viewMetadata: ([ERROR : View]) -> U, viewSignature: (T) -> kotlin.Any? = ..., doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>) -> kotlin.Unit): com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>
            preloadableViewIds: List<Int> = emptyList(),
//          ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(preloadableViewIds) value-parameter preloadableViewIds: kotlin.collections.List<kotlin.Int> = ...
//                              ^^^^ reference kotlin/collections/List#
//                                   ^^^ reference kotlin/Int#
//                                          ^^^^^^^^^ reference kotlin/collections/CollectionsKt#emptyList().
            epoxyModelClass: Class<T>,
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(epoxyModelClass) value-parameter epoxyModelClass: java.lang.Class<T>
//                           ^^^^^ reference java/lang/Class#
//                                 ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
            viewMetadata: (View) -> U,
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewMetadata) value-parameter viewMetadata: ([ERROR : View]) -> U
//                         ^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).`<no name provided>`. val <no name provided>: T
//                                  ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[U]
            viewSignature: (T) -> Any? = { _ -> null },
//          ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewSignature) value-parameter viewSignature: (T) -> kotlin.Any? = ...
//                          ^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).`<no name provided>`. val <no name provided>: T
//                          ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                ^^^ reference kotlin/Any#
//                                         ^ definition local2 value-parameter <anonymous parameter 0>: T
            doPreload: (epoxyModel: T, preloadTarget: P, viewData: ViewData<U>) -> Unit
//          ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(doPreload) value-parameter doPreload: (epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>) -> kotlin.Unit
//                      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).epoxyModel. val epoxyModel: T
//                                  ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                     ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).preloadTarget. val preloadTarget: P
//                                                    ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                       ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).viewData. val viewData: com.airbnb.epoxy.preload.ViewData<U>
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
//                       ^^^^^^^^^^^^^^^^^ definition local3 public open fun buildViewMetadata(view: [ERROR : View]): U
//                                         ^^^^ definition local4 value-parameter view: [ERROR : View]
//                                                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewMetadata)
//                                                                    ^^^^ reference local4

            override fun viewSignature(epoxyModel: T) = viewSignature(epoxyModel)
//                       ^^^^^^^^^^^^^ definition local5 public open fun viewSignature(epoxyModel: T): kotlin.Any?
//                                     ^^^^^^^^^^ definition local6 value-parameter epoxyModel: T
//                                                 ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).(viewSignature)
//                                                                    ^^^^^^^^^^ reference local6

            override fun startPreload(epoxyModel: T, preloadTarget: P, viewData: ViewData<U>) {
//                       ^^^^^^^^^^^^ definition local7 public open fun startPreload(epoxyModel: T, preloadTarget: P, viewData: com.airbnb.epoxy.preload.ViewData<U>)
//                                    ^^^^^^^^^^ definition local8 value-parameter epoxyModel: T
//                                                ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[T]
//                                                   ^^^^^^^^^^^^^ definition local9 value-parameter preloadTarget: P
//                                                                  ^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#Companion#with(+2).[P]
//                                                                     ^^^^^^^^ definition local10 value-parameter viewData: com.airbnb.epoxy.preload.ViewData<U>
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
