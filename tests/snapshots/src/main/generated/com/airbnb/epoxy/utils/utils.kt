package com.airbnb.epoxy.utils
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/utils/

import android.content.Context
import android.content.pm.ApplicationInfo

@PublishedApi
//^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/PublishedApi#`<init>`().
internal val Context.isDebuggable: Boolean
//                   ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/utils/utilsKt#isDebuggable.
//                                documentation ```kt\ninternal val [ERROR : Context].isDebuggable: kotlin.Boolean\n```
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    get() = (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
//  ^^^ definition semanticdb maven . . com/airbnb/epoxy/utils/utilsKt#getIsDebuggable().
//      documentation ```kt\ninternal fun [ERROR : Context].<get-isDebuggable>(): kotlin.Boolean\n```
