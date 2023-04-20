import upickle.core.NoOpVisitor
//     ^^^^^^^ reference semanticdb maven . . upickle/
//             ^^^^ reference semanticdb maven . . upickle/core/
//                  ^^^^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/upickle-core_2.13 1.4.0 upickle/core/NoOpVisitor.

package object ujson{
//             ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.
//                   documentation ```scala\npackage object ujson\n```
  def transform[T](t: Readable, v: upickle.core.Visitor[_, T]) = t.transform(v)
//    ^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().
//              documentation ```scala\ndef transform(t: Readable, v: Visitor[local0, T[): T\n```
//              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().[T]
//                documentation ```scala\nT\n```
//                 ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().(t)
//                   documentation ```scala\nt: Readable \n```
//                    ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                              ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.transform().(v)
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
//         documentation ```scala\ndef read(s: Readable, trace: Boolean): Value\n```
//         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.read().(s)
//           documentation ```scala\ns: Readable \n```
//            ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                      ^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.read().(trace)
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
//         documentation ```scala\ndef copy(t: Value): Value\n```
//         ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.copy().(t)
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
//          documentation ```scala\ndef write(t: Value, indent: Int, escapeUnicode: Boolean): String\n```
//          ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().(t)
//            documentation ```scala\nt: Value \n```
//             ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                   ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
            indent: Int = -1,
//          ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().(indent)
//                 documentation ```scala\ndefault indent: Int \n```
//                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
            escapeUnicode: Boolean = false): String = {
//          ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.write().(escapeUnicode)
//                        documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                         ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                           ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
    val writer = new java.io.StringWriter
//      ^^^^^^ definition local 1
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
//            documentation ```scala\ndef writeTo(t: Value, out: Writer, indent: Int, escapeUnicode: Boolean): Unit\n```
//            ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(t)
//              documentation ```scala\nt: Value \n```
//               ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                     ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
              out: java.io.Writer,
//            ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(out)
//                documentation ```scala\nout: Writer \n```
//                 ^^^^ reference semanticdb maven . . java/
//                      ^^ reference semanticdb maven . . java/io/
//                         ^^^^^^ reference semanticdb maven jdk 11 java/io/Writer#
              indent: Int = -1,
//            ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(indent)
//                   documentation ```scala\ndefault indent: Int \n```
//                    ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
              escapeUnicode: Boolean = false): Unit = {
//            ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeTo().(escapeUnicode)
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
//                        documentation ```scala\ndef writeToOutputStream(t: Value, out: OutputStream, indent: Int, escapeUnicode: Boolean): Unit\n```
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(t)
//                          documentation ```scala\nt: Value \n```
//                           ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                                 ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
                          out: java.io.OutputStream,
//                        ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(out)
//                            documentation ```scala\nout: OutputStream \n```
//                             ^^^^ reference semanticdb maven . . java/
//                                  ^^ reference semanticdb maven . . java/io/
//                                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/OutputStream#
                          indent: Int = -1,
//                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(indent)
//                               documentation ```scala\ndefault indent: Int \n```
//                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                          escapeUnicode: Boolean = false): Unit = {
//                        ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToOutputStream().(escapeUnicode)
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
//                     documentation ```scala\ndef writeToByteArray(t: Value, indent: Int, escapeUnicode: Boolean): Array[Byte]\n```
//                     ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().(t)
//                       documentation ```scala\nt: Value \n```
//                        ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
//                              ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.Value#
                       indent: Int = -1,
//                     ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().(indent)
//                            documentation ```scala\ndefault indent: Int \n```
//                             ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                       escapeUnicode: Boolean = false) = {
//                     ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.writeToByteArray().(escapeUnicode)
//                                   documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                    ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
    val baos = new java.io.ByteArrayOutputStream
//      ^^^^ definition local 2
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
//             documentation ```scala\ndef validate(s: Readable): Unit\n```
//             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.validate().(s)
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
//             documentation ```scala\ndef reformat(s: Readable, indent: Int, escapeUnicode: Boolean): String\n```
//             ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().(s)
//               documentation ```scala\ns: Readable \n```
//                ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                          ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().(indent)
//                                 documentation ```scala\ndefault indent: Int \n```
//                                  ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                            ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformat().(escapeUnicode)
//                                                          documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                                           ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
//                                                                             ^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Predef.String#
    val writer = new java.io.StringWriter()
//      ^^^^^^ definition local 3
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
//               documentation ```scala\ndef reformatTo(s: Readable, out: Writer, indent: Int, escapeUnicode: Boolean): Unit\n```
//               ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(s)
//                 documentation ```scala\ns: Readable \n```
//                  ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
//                            ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(out)
//                                documentation ```scala\nout: Writer \n```
//                                 ^^^^ reference semanticdb maven . . java/
//                                      ^^ reference semanticdb maven . . java/io/
//                                         ^^^^^^ reference semanticdb maven jdk 11 java/io/Writer#
//                                                 ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(indent)
//                                                        documentation ```scala\ndefault indent: Int \n```
//                                                         ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
//                                                                   ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatTo().(escapeUnicode)
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
//                           documentation ```scala\ndef reformatToOutputStream(s: Readable, out: OutputStream, indent: Int, escapeUnicode: Boolean): Unit\n```
//                           ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(s)
//                             documentation ```scala\ns: Readable \n```
//                              ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
                             out: java.io.OutputStream,
//                           ^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(out)
//                               documentation ```scala\nout: OutputStream \n```
//                                ^^^^ reference semanticdb maven . . java/
//                                     ^^ reference semanticdb maven . . java/io/
//                                        ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/OutputStream#
                             indent: Int = -1,
//                           ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(indent)
//                                  documentation ```scala\ndefault indent: Int \n```
//                                   ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                             escapeUnicode: Boolean = false): Unit = {
//                           ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToOutputStream().(escapeUnicode)
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
//                        documentation ```scala\ndef reformatToByteArray(s: Readable, indent: Int, escapeUnicode: Boolean): Array[Byte]\n```
//                        ^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().(s)
//                          documentation ```scala\ns: Readable \n```
//                           ^^^^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Readable#
                          indent: Int = -1,
//                        ^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().(indent)
//                               documentation ```scala\ndefault indent: Int \n```
//                                ^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Int#
                          escapeUnicode: Boolean = false) = {
//                        ^^^^^^^^^^^^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.reformatToByteArray().(escapeUnicode)
//                                      documentation ```scala\ndefault escapeUnicode: Boolean \n```
//                                       ^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/Boolean#
    val baos = new java.io.ByteArrayOutputStream
//      ^^^^ definition local 4
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
//        documentation ```scala\ntype Js >: Value <: Value\n```
//          ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value#
  @deprecated("use ujson.Value")
// ^^^^^^^^^^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#
//           ^ reference semanticdb maven maven/org.scala-lang/scala-library 2.13.10 scala/deprecated#`<init>`().
  val Js = Value
//    ^^ definition semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/package.Js.
//       documentation ```scala\n@deprecated\nval Js: \n```
//         ^^^^^ reference semanticdb maven maven/com.lihaoyi/ujson_2.13 1.4.0 ujson/Value.
}
