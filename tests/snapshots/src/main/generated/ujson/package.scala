import upickle.core.NoOpVisitor
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                  ^^^^^^^^^^^ reference upickle/core/NoOpVisitor.

package object ujson{
//             ^^^^^ definition ujson/package.
  def transform[T](t: Readable, v: upickle.core.Visitor[_, T]) = t.transform(v)
//    ^^^^^^^^^ definition ujson/package.transform().
//              ^ definition ujson/package.transform().[T]
//                 ^ definition ujson/package.transform().(t)
//                    ^^^^^^^^ reference ujson/Readable#
//                              ^ definition ujson/package.transform().(v)
//                                 ^^^^^^^ reference upickle/
//                                         ^^^^ reference upickle/core/
//                                              ^^^^^^^ reference upickle/core/Visitor#
//                                                         ^ reference ujson/package.transform().[T]
//                                                               ^ reference ujson/package.transform().(t)
//                                                                 ^^^^^^^^^ reference ujson/Readable#transform().
//                                                                           ^ reference ujson/package.transform().(v)

  /**
    * Read the given JSON input as a JSON struct
    */
  def read(s: Readable, trace: Boolean = false): Value.Value =
//    ^^^^ definition ujson/package.read().
//         ^ definition ujson/package.read().(s)
//            ^^^^^^^^ reference ujson/Readable#
//                      ^^^^^ definition ujson/package.read().(trace)
//                             ^^^^^^^ reference scala/Boolean#
//                                               ^^^^^ reference ujson/Value.
//                                                     ^^^^^ reference ujson/Value.Value#
    upickle.core.TraceVisitor.withTrace(trace, Value)(transform(s, _))
//  ^^^^^^^ reference upickle/
//          ^^^^ reference upickle/core/
//               ^^^^^^^^^^^^ reference upickle/core/TraceVisitor.
//                            ^^^^^^^^^ reference upickle/core/TraceVisitor.withTrace().
//                                      ^^^^^ reference ujson/package.read().(trace)
//                                             ^^^^^ reference ujson/Value.
//                                                    ^^^^^^^^^ reference ujson/package.transform().
//                                                              ^ reference ujson/package.read().(s)

  def copy(t: Value.Value): Value.Value = transform(t, Value)
//    ^^^^ definition ujson/package.copy().
//         ^ definition ujson/package.copy().(t)
//            ^^^^^ reference ujson/Value.
//                  ^^^^^ reference ujson/Value.Value#
//                          ^^^^^ reference ujson/Value.
//                                ^^^^^ reference ujson/Value.Value#
//                                        ^^^^^^^^^ reference ujson/package.transform().
//                                                  ^ reference ujson/package.copy().(t)
//                                                     ^^^^^ reference ujson/Value.

  /**
    * Write the given JSON struct as a JSON String
    */
  def write(t: Value.Value,
//    ^^^^^ definition ujson/package.write().
//          ^ definition ujson/package.write().(t)
//             ^^^^^ reference ujson/Value.
//                   ^^^^^ reference ujson/Value.Value#
            indent: Int = -1,
//          ^^^^^^ definition ujson/package.write().(indent)
//                  ^^^ reference scala/Int#
            escapeUnicode: Boolean = false): String = {
//          ^^^^^^^^^^^^^ definition ujson/package.write().(escapeUnicode)
//                         ^^^^^^^ reference scala/Boolean#
//                                           ^^^^^^ reference scala/Predef.String#
    val writer = new java.io.StringWriter
//      ^^^^^^ definition local0
//                   ^^^^ reference java/
//                        ^^ reference java/io/
//                           ^^^^^^^^^^^^ reference java/io/StringWriter#
//                                        reference java/io/StringWriter#`<init>`().
    writeTo(t, writer, indent, escapeUnicode)
//  ^^^^^^^ reference ujson/package.writeTo().
//          ^ reference ujson/package.write().(t)
//             ^^^^^^ reference local0
//                     ^^^^^^ reference ujson/package.write().(indent)
//                             ^^^^^^^^^^^^^ reference ujson/package.write().(escapeUnicode)
    writer.toString
//  ^^^^^^ reference local0
//         ^^^^^^^^ reference java/io/StringWriter#toString().
  }

  /**
    * Write the given JSON struct as a JSON String to the given Writer
    */
  def writeTo(t: Value.Value,
//    ^^^^^^^ definition ujson/package.writeTo().
//            ^ definition ujson/package.writeTo().(t)
//               ^^^^^ reference ujson/Value.
//                     ^^^^^ reference ujson/Value.Value#
              out: java.io.Writer,
//            ^^^ definition ujson/package.writeTo().(out)
//                 ^^^^ reference java/
//                      ^^ reference java/io/
//                         ^^^^^^ reference java/io/Writer#
              indent: Int = -1,
//            ^^^^^^ definition ujson/package.writeTo().(indent)
//                    ^^^ reference scala/Int#
              escapeUnicode: Boolean = false): Unit = {
//            ^^^^^^^^^^^^^ definition ujson/package.writeTo().(escapeUnicode)
//                           ^^^^^^^ reference scala/Boolean#
//                                             ^^^^ reference scala/Unit#
    transform(t, Renderer(out, indent, escapeUnicode))
//  ^^^^^^^^^ reference ujson/package.transform().
//            ^ reference ujson/package.writeTo().(t)
//               ^^^^^^^^ reference ujson/Renderer.
//                        ^^^ reference ujson/package.writeTo().(out)
//                             ^^^^^^ reference ujson/package.writeTo().(indent)
//                                     ^^^^^^^^^^^^^ reference ujson/package.writeTo().(escapeUnicode)
  }
  def writeToOutputStream(t: Value.Value,
//    ^^^^^^^^^^^^^^^^^^^ definition ujson/package.writeToOutputStream().
//                        ^ definition ujson/package.writeToOutputStream().(t)
//                           ^^^^^ reference ujson/Value.
//                                 ^^^^^ reference ujson/Value.Value#
                          out: java.io.OutputStream,
//                        ^^^ definition ujson/package.writeToOutputStream().(out)
//                             ^^^^ reference java/
//                                  ^^ reference java/io/
//                                     ^^^^^^^^^^^^ reference java/io/OutputStream#
                          indent: Int = -1,
//                        ^^^^^^ definition ujson/package.writeToOutputStream().(indent)
//                                ^^^ reference scala/Int#
                          escapeUnicode: Boolean = false): Unit = {
//                        ^^^^^^^^^^^^^ definition ujson/package.writeToOutputStream().(escapeUnicode)
//                                       ^^^^^^^ reference scala/Boolean#
//                                                         ^^^^ reference scala/Unit#
    transform(t, new BaseByteRenderer(out, indent, escapeUnicode))
//  ^^^^^^^^^ reference ujson/package.transform().
//            ^ reference ujson/package.writeToOutputStream().(t)
//                   ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#
//                                    reference ujson/BaseByteRenderer#`<init>`().
//                                    ^^^ reference ujson/package.writeToOutputStream().(out)
//                                         ^^^^^^ reference ujson/package.writeToOutputStream().(indent)
//                                                 ^^^^^^^^^^^^^ reference ujson/package.writeToOutputStream().(escapeUnicode)
  }

  def writeToByteArray(t: Value.Value,
//    ^^^^^^^^^^^^^^^^ definition ujson/package.writeToByteArray().
//                     ^ definition ujson/package.writeToByteArray().(t)
//                        ^^^^^ reference ujson/Value.
//                              ^^^^^ reference ujson/Value.Value#
                       indent: Int = -1,
//                     ^^^^^^ definition ujson/package.writeToByteArray().(indent)
//                             ^^^ reference scala/Int#
                       escapeUnicode: Boolean = false) = {
//                     ^^^^^^^^^^^^^ definition ujson/package.writeToByteArray().(escapeUnicode)
//                                    ^^^^^^^ reference scala/Boolean#
    val baos = new java.io.ByteArrayOutputStream
//      ^^^^ definition local1
//                 ^^^^ reference java/
//                      ^^ reference java/io/
//                         ^^^^^^^^^^^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#
//                                               reference java/io/ByteArrayOutputStream#`<init>`().
    writeToOutputStream(t, baos, indent, escapeUnicode)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/package.writeToOutputStream().
//                      ^ reference ujson/package.writeToByteArray().(t)
//                         ^^^^ reference local1
//                               ^^^^^^ reference ujson/package.writeToByteArray().(indent)
//                                       ^^^^^^^^^^^^^ reference ujson/package.writeToByteArray().(escapeUnicode)
    baos.toByteArray
//  ^^^^ reference local1
//       ^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#toByteArray().
  }

  /**
    * Parse the given JSON input, failing if it is invalid
    */
  def validate(s: Readable): Unit = transform(s, NoOpVisitor)
//    ^^^^^^^^ definition ujson/package.validate().
//             ^ definition ujson/package.validate().(s)
//                ^^^^^^^^ reference ujson/Readable#
//                           ^^^^ reference scala/Unit#
//                                  ^^^^^^^^^ reference ujson/package.transform().
//                                            ^ reference ujson/package.validate().(s)
//                                               ^^^^^^^^^^^ reference upickle/core/NoOpVisitor.
  /**
    * Parse the given JSON input and write it to a string with
    * the configured formatting
    */
  def reformat(s: Readable, indent: Int = -1, escapeUnicode: Boolean = false): String = {
//    ^^^^^^^^ definition ujson/package.reformat().
//             ^ definition ujson/package.reformat().(s)
//                ^^^^^^^^ reference ujson/Readable#
//                          ^^^^^^ definition ujson/package.reformat().(indent)
//                                  ^^^ reference scala/Int#
//                                            ^^^^^^^^^^^^^ definition ujson/package.reformat().(escapeUnicode)
//                                                           ^^^^^^^ reference scala/Boolean#
//                                                                             ^^^^^^ reference scala/Predef.String#
    val writer = new java.io.StringWriter()
//      ^^^^^^ definition local2
//                   ^^^^ reference java/
//                        ^^ reference java/io/
//                           ^^^^^^^^^^^^ reference java/io/StringWriter#
//                                        reference java/io/StringWriter#`<init>`().
    reformatTo(s, writer, indent, escapeUnicode)
//  ^^^^^^^^^^ reference ujson/package.reformatTo().
//             ^ reference ujson/package.reformat().(s)
//                ^^^^^^ reference local2
//                        ^^^^^^ reference ujson/package.reformat().(indent)
//                                ^^^^^^^^^^^^^ reference ujson/package.reformat().(escapeUnicode)
    writer.toString
//  ^^^^^^ reference local2
//         ^^^^^^^^ reference java/io/StringWriter#toString().
  }
  /**
    * Parse the given JSON input and write it to a string with
    * the configured formatting to the given Writer
    */
  def reformatTo(s: Readable, out: java.io.Writer, indent: Int = -1, escapeUnicode: Boolean = false): Unit = {
//    ^^^^^^^^^^ definition ujson/package.reformatTo().
//               ^ definition ujson/package.reformatTo().(s)
//                  ^^^^^^^^ reference ujson/Readable#
//                            ^^^ definition ujson/package.reformatTo().(out)
//                                 ^^^^ reference java/
//                                      ^^ reference java/io/
//                                         ^^^^^^ reference java/io/Writer#
//                                                 ^^^^^^ definition ujson/package.reformatTo().(indent)
//                                                         ^^^ reference scala/Int#
//                                                                   ^^^^^^^^^^^^^ definition ujson/package.reformatTo().(escapeUnicode)
//                                                                                  ^^^^^^^ reference scala/Boolean#
//                                                                                                    ^^^^ reference scala/Unit#
    transform(s, Renderer(out, indent, escapeUnicode))
//  ^^^^^^^^^ reference ujson/package.transform().
//            ^ reference ujson/package.reformatTo().(s)
//               ^^^^^^^^ reference ujson/Renderer.
//                        ^^^ reference ujson/package.reformatTo().(out)
//                             ^^^^^^ reference ujson/package.reformatTo().(indent)
//                                     ^^^^^^^^^^^^^ reference ujson/package.reformatTo().(escapeUnicode)
  }
  /**
    * Parse the given JSON input and write it to a string with
    * the configured formatting to the given Writer
    */
  def reformatToOutputStream(s: Readable,
//    ^^^^^^^^^^^^^^^^^^^^^^ definition ujson/package.reformatToOutputStream().
//                           ^ definition ujson/package.reformatToOutputStream().(s)
//                              ^^^^^^^^ reference ujson/Readable#
                             out: java.io.OutputStream,
//                           ^^^ definition ujson/package.reformatToOutputStream().(out)
//                                ^^^^ reference java/
//                                     ^^ reference java/io/
//                                        ^^^^^^^^^^^^ reference java/io/OutputStream#
                             indent: Int = -1,
//                           ^^^^^^ definition ujson/package.reformatToOutputStream().(indent)
//                                   ^^^ reference scala/Int#
                             escapeUnicode: Boolean = false): Unit = {
//                           ^^^^^^^^^^^^^ definition ujson/package.reformatToOutputStream().(escapeUnicode)
//                                          ^^^^^^^ reference scala/Boolean#
//                                                            ^^^^ reference scala/Unit#
    transform(s, new BaseByteRenderer(out, indent, escapeUnicode))
//  ^^^^^^^^^ reference ujson/package.transform().
//            ^ reference ujson/package.reformatToOutputStream().(s)
//                   ^^^^^^^^^^^^^^^^ reference ujson/BaseByteRenderer#
//                                    reference ujson/BaseByteRenderer#`<init>`().
//                                    ^^^ reference ujson/package.reformatToOutputStream().(out)
//                                         ^^^^^^ reference ujson/package.reformatToOutputStream().(indent)
//                                                 ^^^^^^^^^^^^^ reference ujson/package.reformatToOutputStream().(escapeUnicode)
  }
  def reformatToByteArray(s: Readable,
//    ^^^^^^^^^^^^^^^^^^^ definition ujson/package.reformatToByteArray().
//                        ^ definition ujson/package.reformatToByteArray().(s)
//                           ^^^^^^^^ reference ujson/Readable#
                          indent: Int = -1,
//                        ^^^^^^ definition ujson/package.reformatToByteArray().(indent)
//                                ^^^ reference scala/Int#
                          escapeUnicode: Boolean = false) = {
//                        ^^^^^^^^^^^^^ definition ujson/package.reformatToByteArray().(escapeUnicode)
//                                       ^^^^^^^ reference scala/Boolean#
    val baos = new java.io.ByteArrayOutputStream
//      ^^^^ definition local3
//                 ^^^^ reference java/
//                      ^^ reference java/io/
//                         ^^^^^^^^^^^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#
//                                               reference java/io/ByteArrayOutputStream#`<init>`().
    reformatToOutputStream(s, baos, indent, escapeUnicode)
//  ^^^^^^^^^^^^^^^^^^^^^^ reference ujson/package.reformatToOutputStream().
//                         ^ reference ujson/package.reformatToByteArray().(s)
//                            ^^^^ reference local3
//                                  ^^^^^^ reference ujson/package.reformatToByteArray().(indent)
//                                          ^^^^^^^^^^^^^ reference ujson/package.reformatToByteArray().(escapeUnicode)
    baos.toByteArray
//  ^^^^ reference local3
//       ^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#toByteArray().
  }
  // End ujson
  @deprecated("use ujson.Value")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Js = Value
//     ^^ definition ujson/package.Js#
//          ^^^^^ reference ujson/Value#
  @deprecated("use ujson.Value")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Js = Value
//    ^^ definition ujson/package.Js.
//         ^^^^^ reference ujson/Value.
}
