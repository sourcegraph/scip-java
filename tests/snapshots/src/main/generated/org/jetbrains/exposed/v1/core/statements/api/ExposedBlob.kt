package org.jetbrains.exposed.v1.core.statements.api
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/

import org.jetbrains.exposed.v1.core.vendors.OracleDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
import org.jetbrains.exposed.v1.core.vendors.currentDialectIfAvailable
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
import java.io.IOException
//     ^^^^ reference semanticdb maven . . java/
//          ^^ reference semanticdb maven . . java/io/
//             ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/IOException#
import java.io.InputStream
//     ^^^^ reference semanticdb maven . . java/
//          ^^ reference semanticdb maven . . java/io/
//             ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#

/** Represents a wrapper for an [inputStream] of bytes to be used in binary columns. */
class ExposedBlob(inputStream: InputStream) {
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#
//                display_name ExposedBlob
//                documentation ```kotlin\npublic final class ExposedBlob : Any\n```\n\n----\n\n Represents a wrapper for an [inputStream] of bytes to be used in binary columns.
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`().
//                display_name ExposedBlob
//                documentation ```kotlin\npublic constructor(inputStream: InputStream): ExposedBlob\n```
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`().(inputStream)
//                            display_name inputStream
//                            documentation ```kotlin\ninputStream: InputStream\n```
//                             ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#
    constructor(bytes: ByteArray) : this (bytes.inputStream())
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`(+1).
//                                                             display_name ExposedBlob
//                                                             documentation ```kotlin\npublic constructor(bytes: ByteArray): ExposedBlob\n```
//              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`(+1).(bytes)
//                    display_name bytes
//                    documentation ```kotlin\nbytes: ByteArray\n```
//                     ^^^^^^^^^ reference semanticdb maven . . kotlin/ByteArray#
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`(+1).(bytes)
//                                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/io/inputStream(+1).

    /** The [InputStream] contained by this wrapper. */
    var inputStream = inputStream
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getInputStream().
//                  display_name inputStream
//                  documentation ```kotlin\npublic get(): InputStream\n```\n\n----\n\n The [InputStream] contained by this wrapper.
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#inputStream.
//                  display_name inputStream
//                  documentation ```kotlin\npublic final var inputStream: InputStream\n```\n\n----\n\n The [InputStream] contained by this wrapper.
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#`<init>`().(inputStream)
        private set
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#setInputStream().(value)
//                  display_name value
//                  documentation ```kotlin\nvalue: InputStream\n```
//      ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#
//              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#setInputStream().
//                  display_name inputStream
//                  documentation ```kotlin\nprivate set(value: InputStream): Unit\n```

    /** The `ByteArray` returned as a result of reading the contained [InputStream] completely. */
    val bytes: ByteArray
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#bytes.
//            display_name bytes
//            documentation ```kotlin\npublic final val bytes: ByteArray\n```\n\n----\n\n The `ByteArray` returned as a result of reading the contained [InputStream] completely.
//             ^^^^^^^^^ reference semanticdb maven . . kotlin/ByteArray#
        get() = inputStream.readBytes().also {
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getBytes().
//          display_name bytes
//          documentation ```kotlin\npublic get(): ByteArray\n```
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getInputStream().
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#inputStream.
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#setInputStream().
//                          ^^^^^^^^^ reference semanticdb maven . . kotlin/io/readBytes(+2).
//                                      ^^^^ reference semanticdb maven . . kotlin/also().
//                                           ^ definition semanticdb maven . . (it) 12:9
//                                             display_name it
//                                             documentation ```kotlin\nit: ByteArray\n```
            if (inputStream.markSupported()) {
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getInputStream().
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#inputStream.
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#setInputStream().
//                          ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#markSupported().
                try {
                    inputStream.reset()
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getInputStream().
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#inputStream.
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#setInputStream().
//                              ^^^^^ reference semanticdb maven jdk 11 java/io/InputStream#reset().
                } catch (_: IOException) {
//                       ^ definition local 0
//                         display_name <unused var>
//                         documentation ```kotlin\n<unused var>: IOException\n```
//                          ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/IOException#
                    if (currentDialectIfAvailable is OracleDialect) {
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
                        inputStream = it.inputStream()
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getInputStream().
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#inputStream.
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#setInputStream().
//                                    ^^ reference semanticdb maven . . (it)
//                                       ^^^^^^^^^^^ reference semanticdb maven . . kotlin/io/inputStream(+1).
                    }
                }
            } else {
                inputStream = it.inputStream()
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getInputStream().
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#inputStream.
//              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#setInputStream().
//                            ^^ reference semanticdb maven . . (it)
//                               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/io/inputStream(+1).
            }
        }

    override fun equals(other: Any?): Boolean {
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#equals().
//                      display_name equals
//                      documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                      relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#equals().(other)
//                            display_name other
//                            documentation ```kotlin\nother: Any?\n```
//                             ^^^^ reference semanticdb maven . . kotlin/Any#
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        if (this === other) return true
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#equals().(other)
        if (other !is ExposedBlob) return false
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#equals().(other)

        return bytes.contentEquals(other.bytes)
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#bytes.
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getBytes().
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/contentEquals(+1).
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#equals().(other)
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#bytes.
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getBytes().
    }

    override fun hashCode(): Int = bytes.contentHashCode()
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#hashCode().
//                        display_name hashCode
//                        documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                           ^^^ reference semanticdb maven . . kotlin/Int#
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#bytes.
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getBytes().
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/contentHashCode(+1).

    /** Returns the hex-encoded string of the contained [InputStream] after being read. */
    fun hexString(): String = bytes.toHexString()
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#hexString().
//                display_name hexString
//                documentation ```kotlin\npublic final fun hexString(): String\n```\n\n----\n\n Returns the hex-encoded string of the contained [InputStream] after being read.
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#bytes.
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#getBytes().
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#toHexString().

    /** Returns the hex-encoded string of a ByteArray. */
    private fun ByteArray.toHexString(): String = joinToString(separator = "") { eachByte -> "%02x".format(eachByte) }
//                        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedBlob#toHexString().
//                                    display_name toHexString
//                                    documentation ```kotlin\nprivate final fun ByteArray.toHexString(): String\n```\n\n----\n\n Returns the hex-encoded string of a ByteArray.
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+1).
//                                                                               ^^^^^^^^ definition semanticdb maven . . (eachByte)
//                                                                                        display_name eachByte
//                                                                                        documentation ```kotlin\neachByte: Byte\n```
//                                                                                                  ^^^^^^ reference semanticdb maven . . kotlin/text/format().
//                                                                                                         ^^^^^^^^ reference semanticdb maven . . (eachByte)
}
