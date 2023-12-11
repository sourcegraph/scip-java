import upickle.core.NoOpVisitor
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/NoOpVisitor.

package object ujson{
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.
//                   display_name ujson
//                   documentation ```scala\npackage object ujson\n```
  def transform[T](t: Readable, v: upickle.core.Visitor[_, T]) = t.transform(v)
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().
//              display_name transform
//              documentation ```scala\ndef transform(t: Readable, v: Visitor[local0, T[): T\n```
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().[T]
//                display_name T
//                documentation ```scala\nT\n```
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().(t)
//                   display_name t
//                   documentation ```scala\nt: Readable \n```
//                    ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().(v)
//                                display_name v
//                                documentation ```scala\nv: Visitor[local0, T[ \n```
//                                 ^^^^^^^ reference semanticdb maven . . upickle/
//                                         ^^^^ reference semanticdb maven . . upickle/core/
//                                              ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/Visitor#
//                                                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().[T]
//                                                               ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().(t)
//                                                                 ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#transform().
//                                                                           ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().(v)

  /**
    * Read the given JSON input as a JSON struct
    */
  def read(s: Readable, trace: Boolean = false): Value.Value =
//    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.read().
//         display_name read
//         documentation ```scala\ndef read(s: Readable, trace: Boolean): Value\n```
//         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.read().(s)
//           display_name s
//           documentation ```scala\ns: Readable \n```
//            ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.read().(trace)
//                            display_name trace
//                            documentation ```scala\ndefault trace: Boolean \n```
//                             ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                               ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                                                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
    upickle.core.TraceVisitor.withTrace(trace, Value)(transform(s, _))
//  ^^^^^^^ reference semanticdb maven . . upickle/
//          ^^^^ reference semanticdb maven . . upickle/core/
//               ^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/TraceVisitor.
//                            ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/TraceVisitor.withTrace().
//                                      ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.read().(trace)
//                                             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                                                    ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().
//                                                              ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.read().(s)

  def copy(t: Value.Value): Value.Value = transform(t, Value)
//    ^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.copy().
//         display_name copy
//         documentation ```scala\ndef copy(t: Value): Value\n```
//         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.copy().(t)
//           display_name t
//           documentation ```scala\nt: Value \n```
//            ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                  ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                                ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
//                                        ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().
//                                                  ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.copy().(t)
//                                                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.

  /**
    * Write the given JSON struct as a JSON String
    */
  def write(t: Value.Value,
//    ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().
//          display_name write
//          documentation ```scala\ndef write(t: Value, indent: Int, escapeUnicode: Boolean): String\n```
//          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().(t)
//            display_name t
//            documentation ```scala\nt: Value \n```
//             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
            indent: Int = -1,
//          ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().(indent)
//                 display_name indent
//                 documentation ```scala\ndefault indent: Int \n```
//                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
            escapeUnicode: Boolean = false): String = {
//          ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().(escapeUnicode)
//                        display_name escapeUnicode
//                        documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                         ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                           ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
    val writer = new java.io.StringWriter
//      ^^^^^^ definition local 1
//             display_name writer
//             documentation ```scala\nwriter: StringWriter \n```
//                   ^^^^ reference semanticdb maven . . java/
//                        ^^ reference semanticdb maven . . java/io/
//                           ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/StringWriter#
//                                       ^ reference semanticdb maven jdk 11 java/io/StringWriter#`<init>`().
    writeTo(t, writer, indent, escapeUnicode)
//  ^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().
//          ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().(t)
//             ^^^^^^ reference local 1
//                     ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().(indent)
//                             ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().(escapeUnicode)
    writer.toString
//  ^^^^^^ reference local 1
//         ^^^^^^^^ reference semanticdb maven jdk 11 java/io/StringWriter#toString().
  }

  /**
    * Write the given JSON struct as a JSON String to the given Writer
    */
  def writeTo(t: Value.Value,
//    ^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().
//            display_name writeTo
//            documentation ```scala\ndef writeTo(t: Value, out: Writer, indent: Int, escapeUnicode: Boolean): Unit\n```
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(t)
//              display_name t
//              documentation ```scala\nt: Value \n```
//               ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
              out: java.io.Writer,
//            ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(out)
//                display_name out
//                documentation ```scala\nout: Writer \n```
//                 ^^^^ reference semanticdb maven . . java/
//                      ^^ reference semanticdb maven . . java/io/
//                         ^^^^^^ reference semanticdb maven jdk 11 java/io/Writer#
              indent: Int = -1,
//            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(indent)
//                   display_name indent
//                   documentation ```scala\ndefault indent: Int \n```
//                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
              escapeUnicode: Boolean = false): Unit = {
//            ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(escapeUnicode)
//                          display_name escapeUnicode
//                          documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                           ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                             ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
    transform(t, Renderer(out, indent, escapeUnicode))
//  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().
//            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(t)
//               ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.
//                        ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(out)
//                             ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(indent)
//                                     ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(escapeUnicode)
  }
  def writeToOutputStream(t: Value.Value,
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().
//                        display_name writeToOutputStream
//                        documentation ```scala\ndef writeToOutputStream(t: Value, out: OutputStream, indent: Int, escapeUnicode: Boolean): Unit\n```
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(t)
//                          display_name t
//                          documentation ```scala\nt: Value \n```
//                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
                          out: java.io.OutputStream,
//                        ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(out)
//                            display_name out
//                            documentation ```scala\nout: OutputStream \n```
//                             ^^^^ reference semanticdb maven . . java/
//                                  ^^ reference semanticdb maven . . java/io/
//                                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/OutputStream#
                          indent: Int = -1,
//                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(indent)
//                               display_name indent
//                               documentation ```scala\ndefault indent: Int \n```
//                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                          escapeUnicode: Boolean = false): Unit = {
//                        ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(escapeUnicode)
//                                      display_name escapeUnicode
//                                      documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                       ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                                         ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
    transform(t, new BaseByteRenderer(out, indent, escapeUnicode))
//  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().
//            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(t)
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().
//                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(out)
//                                         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(indent)
//                                                 ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(escapeUnicode)
  }

  def writeToByteArray(t: Value.Value,
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().
//                     display_name writeToByteArray
//                     documentation ```scala\ndef writeToByteArray(t: Value, indent: Int, escapeUnicode: Boolean): Array[Byte]\n```
//                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().(t)
//                       display_name t
//                       documentation ```scala\nt: Value \n```
//                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
                       indent: Int = -1,
//                     ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().(indent)
//                            display_name indent
//                            documentation ```scala\ndefault indent: Int \n```
//                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                       escapeUnicode: Boolean = false) = {
//                     ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().(escapeUnicode)
//                                   display_name escapeUnicode
//                                   documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                    ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
    val baos = new java.io.ByteArrayOutputStream
//      ^^^^ definition local 2
//           display_name baos
//           documentation ```scala\nbaos: ByteArrayOutputStream \n```
//                 ^^^^ reference semanticdb maven . . java/
//                      ^^ reference semanticdb maven . . java/io/
//                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/ByteArrayOutputStream#
//                                              ^ reference semanticdb maven jdk 11 java/io/ByteArrayOutputStream#`<init>`().
    writeToOutputStream(t, baos, indent, escapeUnicode)
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().
//                      ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().(t)
//                         ^^^^ reference local 2
//                               ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().(indent)
//                                       ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().(escapeUnicode)
    baos.toByteArray
//  ^^^^ reference local 2
//       ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/ByteArrayOutputStream#toByteArray().
  }

  /**
    * Parse the given JSON input, failing if it is invalid
    */
  def validate(s: Readable): Unit = transform(s, NoOpVisitor)
//    ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.validate().
//             display_name validate
//             documentation ```scala\ndef validate(s: Readable): Unit\n```
//             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.validate().(s)
//               display_name s
//               documentation ```scala\ns: Readable \n```
//                ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                           ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
//                                  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().
//                                            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.validate().(s)
//                                               ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/NoOpVisitor.
  /**
    * Parse the given JSON input and write it to a string with
    * the configured formatting
    */
  def reformat(s: Readable, indent: Int = -1, escapeUnicode: Boolean = false): String = {
//    ^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().
//             display_name reformat
//             documentation ```scala\ndef reformat(s: Readable, indent: Int, escapeUnicode: Boolean): String\n```
//             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().(s)
//               display_name s
//               documentation ```scala\ns: Readable \n```
//                ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                          ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().(indent)
//                                 display_name indent
//                                 documentation ```scala\ndefault indent: Int \n```
//                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                            ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().(escapeUnicode)
//                                                          display_name escapeUnicode
//                                                          documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                                           ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                                                             ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
    val writer = new java.io.StringWriter()
//      ^^^^^^ definition local 3
//             display_name writer
//             documentation ```scala\nwriter: StringWriter \n```
//                   ^^^^ reference semanticdb maven . . java/
//                        ^^ reference semanticdb maven . . java/io/
//                           ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/StringWriter#
//                                       ^ reference semanticdb maven jdk 11 java/io/StringWriter#`<init>`().
    reformatTo(s, writer, indent, escapeUnicode)
//  ^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().
//             ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().(s)
//                ^^^^^^ reference local 3
//                        ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().(indent)
//                                ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().(escapeUnicode)
    writer.toString
//  ^^^^^^ reference local 3
//         ^^^^^^^^ reference semanticdb maven jdk 11 java/io/StringWriter#toString().
  }
  /**
    * Parse the given JSON input and write it to a string with
    * the configured formatting to the given Writer
    */
  def reformatTo(s: Readable, out: java.io.Writer, indent: Int = -1, escapeUnicode: Boolean = false): Unit = {
//    ^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().
//               display_name reformatTo
//               documentation ```scala\ndef reformatTo(s: Readable, out: Writer, indent: Int, escapeUnicode: Boolean): Unit\n```
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(s)
//                 display_name s
//                 documentation ```scala\ns: Readable \n```
//                  ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                            ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(out)
//                                display_name out
//                                documentation ```scala\nout: Writer \n```
//                                 ^^^^ reference semanticdb maven . . java/
//                                      ^^ reference semanticdb maven . . java/io/
//                                         ^^^^^^ reference semanticdb maven jdk 11 java/io/Writer#
//                                                 ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(indent)
//                                                        display_name indent
//                                                        documentation ```scala\ndefault indent: Int \n```
//                                                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                   ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(escapeUnicode)
//                                                                                 display_name escapeUnicode
//                                                                                 documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                                                                  ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                                                                                    ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
    transform(s, Renderer(out, indent, escapeUnicode))
//  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().
//            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(s)
//               ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Renderer.
//                        ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(out)
//                             ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(indent)
//                                     ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(escapeUnicode)
  }
  /**
    * Parse the given JSON input and write it to a string with
    * the configured formatting to the given Writer
    */
  def reformatToOutputStream(s: Readable,
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().
//                           display_name reformatToOutputStream
//                           documentation ```scala\ndef reformatToOutputStream(s: Readable, out: OutputStream, indent: Int, escapeUnicode: Boolean): Unit\n```
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(s)
//                             display_name s
//                             documentation ```scala\ns: Readable \n```
//                              ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
                             out: java.io.OutputStream,
//                           ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(out)
//                               display_name out
//                               documentation ```scala\nout: OutputStream \n```
//                                ^^^^ reference semanticdb maven . . java/
//                                     ^^ reference semanticdb maven . . java/io/
//                                        ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/OutputStream#
                             indent: Int = -1,
//                           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(indent)
//                                  display_name indent
//                                  documentation ```scala\ndefault indent: Int \n```
//                                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                             escapeUnicode: Boolean = false): Unit = {
//                           ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(escapeUnicode)
//                                         display_name escapeUnicode
//                                         documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                          ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                                            ^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Unit#
    transform(s, new BaseByteRenderer(out, indent, escapeUnicode))
//  ^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().
//            ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(s)
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#
//                                   ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/BaseByteRenderer#`<init>`().
//                                    ^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(out)
//                                         ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(indent)
//                                                 ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(escapeUnicode)
  }
  def reformatToByteArray(s: Readable,
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().
//                        display_name reformatToByteArray
//                        documentation ```scala\ndef reformatToByteArray(s: Readable, indent: Int, escapeUnicode: Boolean): Array[Byte]\n```
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().(s)
//                          display_name s
//                          documentation ```scala\ns: Readable \n```
//                           ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
                          indent: Int = -1,
//                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().(indent)
//                               display_name indent
//                               documentation ```scala\ndefault indent: Int \n```
//                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                          escapeUnicode: Boolean = false) = {
//                        ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().(escapeUnicode)
//                                      display_name escapeUnicode
//                                      documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                       ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
    val baos = new java.io.ByteArrayOutputStream
//      ^^^^ definition local 4
//           display_name baos
//           documentation ```scala\nbaos: ByteArrayOutputStream \n```
//                 ^^^^ reference semanticdb maven . . java/
//                      ^^ reference semanticdb maven . . java/io/
//                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/ByteArrayOutputStream#
//                                              ^ reference semanticdb maven jdk 11 java/io/ByteArrayOutputStream#`<init>`().
    reformatToOutputStream(s, baos, indent, escapeUnicode)
//  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().
//                         ^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().(s)
//                            ^^^^ reference local 4
//                                  ^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().(indent)
//                                          ^^^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().(escapeUnicode)
    baos.toByteArray
//  ^^^^ reference local 4
//       ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/ByteArrayOutputStream#toByteArray().
  }
  // End ujson
  @deprecated("use ujson.Value")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  type Js = Value
//     ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.Js#
//        display_name Js
//        documentation ```scala\ntype Js >: Value <: Value\n```
//          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
  @deprecated("use ujson.Value")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Js = Value
//    ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.Js.
//       display_name Js
//       documentation ```scala\n@deprecated\nval Js: \n```
//         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
}
