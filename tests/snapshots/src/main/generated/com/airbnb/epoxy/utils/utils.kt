package com.airbnb.epoxy.utils
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/
//                       ^^^^^ reference com/airbnb/epoxy/utils/

import android.content.Context
import android.content.pm.ApplicationInfo

@PublishedApi
//^^^^^^^^^^^ reference kotlin/PublishedApi#`<init>`().
internal val Context.isDebuggable: Boolean
//                   ^^^^^^^^^^^^ definition com/airbnb/epoxy/utils/utilsKt#isDebuggable. internal val [ERROR : Context].isDebuggable: kotlin.Boolean
//                                 ^^^^^^^ reference kotlin/Boolean#
    get() = (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
//  ^^^ definition com/airbnb/epoxy/utils/utilsKt#getIsDebuggable(). internal fun [ERROR : Context].<get-isDebuggable>(): kotlin.Boolean
