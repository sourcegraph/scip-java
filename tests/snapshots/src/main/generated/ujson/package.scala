import upickle.core.NoOpVisitor
//     ^^^^^^^ reference upickle/
//             ^^^^ reference upickle/core/
//                  ^^^^^^^^^^^ reference upickle/core/NoOpVisitor.

package object ujson{
//             ^^^^^ definition ujson/package. package object ujson
  def transform[T](t: Readable, v: upickle.core.Visitor[_, T]) = t.transform(v)
//    ^^^^^^^^^ definition ujson/package.transform(). def transform(t: Readable, v: Visitor[local0, T[): T
//              ^ definition ujson/package.transform().[T] T
//                 ^ definition ujson/package.transform().(t) t: Readable
//                    ^^^^^^^^ reference ujson/Readable#
//                              ^ definition ujson/package.transform().(v) v: Visitor[local0, T[
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
//    ^^^^ definition ujson/package.read(). def read(s: Readable, trace: Boolean): Value
//         ^ definition ujson/package.read().(s) s: Readable
//            ^^^^^^^^ reference ujson/Readable#
//                      ^^^^^ definition ujson/package.read().(trace) default trace: Boolean
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
//    ^^^^ definition ujson/package.copy(). def copy(t: Value): Value
//         ^ definition ujson/package.copy().(t) t: Value
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
//    ^^^^^ definition ujson/package.write(). def write(t: Value, indent: Int, escapeUnicode: Boolean): String
//          ^ definition ujson/package.write().(t) t: Value
//             ^^^^^ reference ujson/Value.
//                   ^^^^^ reference ujson/Value.Value#
            indent: Int = -1,
//          ^^^^^^ definition ujson/package.write().(indent) default indent: Int
//                  ^^^ reference scala/Int#
            escapeUnicode: Boolean = false): String = {
//          ^^^^^^^^^^^^^ definition ujson/package.write().(escapeUnicode) default escapeUnicode: Boolean
//                         ^^^^^^^ reference scala/Boolean#
//                                           ^^^^^^ reference scala/Predef.String#
    val writer = new java.io.StringWriter
//      ^^^^^^ definition local1 writer: StringWriter
//                   ^^^^ reference java/
//                        ^^ reference java/io/
//                           ^^^^^^^^^^^^ reference java/io/StringWriter#
//                                        reference java/io/StringWriter#`<init>`().
    writeTo(t, writer, indent, escapeUnicode)
//  ^^^^^^^ reference ujson/package.writeTo().
//          ^ reference ujson/package.write().(t)
//             ^^^^^^ reference local1
//                     ^^^^^^ reference ujson/package.write().(indent)
//                             ^^^^^^^^^^^^^ reference ujson/package.write().(escapeUnicode)
    writer.toString
//  ^^^^^^ reference local1
//         ^^^^^^^^ reference java/io/StringWriter#toString().
  }

  /**
    * Write the given JSON struct as a JSON String to the given Writer
    */
  def writeTo(t: Value.Value,
//    ^^^^^^^ definition ujson/package.writeTo(). def writeTo(t: Value, out: Writer, indent: Int, escapeUnicode: Boolean): Unit
//            ^ definition ujson/package.writeTo().(t) t: Value
//               ^^^^^ reference ujson/Value.
//                     ^^^^^ reference ujson/Value.Value#
              out: java.io.Writer,
//            ^^^ definition ujson/package.writeTo().(out) out: Writer
//                 ^^^^ reference java/
//                      ^^ reference java/io/
//                         ^^^^^^ reference java/io/Writer#
              indent: Int = -1,
//            ^^^^^^ definition ujson/package.writeTo().(indent) default indent: Int
//                    ^^^ reference scala/Int#
              escapeUnicode: Boolean = false): Unit = {
//            ^^^^^^^^^^^^^ definition ujson/package.writeTo().(escapeUnicode) default escapeUnicode: Boolean
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
//    ^^^^^^^^^^^^^^^^^^^ definition ujson/package.writeToOutputStream(). def writeToOutputStream(t: Value, out: OutputStream, indent: Int, escapeUnicode: Boolean): Unit
//                        ^ definition ujson/package.writeToOutputStream().(t) t: Value
//                           ^^^^^ reference ujson/Value.
//                                 ^^^^^ reference ujson/Value.Value#
                          out: java.io.OutputStream,
//                        ^^^ definition ujson/package.writeToOutputStream().(out) out: OutputStream
//                             ^^^^ reference java/
//                                  ^^ reference java/io/
//                                     ^^^^^^^^^^^^ reference java/io/OutputStream#
                          indent: Int = -1,
//                        ^^^^^^ definition ujson/package.writeToOutputStream().(indent) default indent: Int
//                                ^^^ reference scala/Int#
                          escapeUnicode: Boolean = false): Unit = {
//                        ^^^^^^^^^^^^^ definition ujson/package.writeToOutputStream().(escapeUnicode) default escapeUnicode: Boolean
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
//    ^^^^^^^^^^^^^^^^ definition ujson/package.writeToByteArray(). def writeToByteArray(t: Value, indent: Int, escapeUnicode: Boolean): Array[Byte]
//                     ^ definition ujson/package.writeToByteArray().(t) t: Value
//                        ^^^^^ reference ujson/Value.
//                              ^^^^^ reference ujson/Value.Value#
                       indent: Int = -1,
//                     ^^^^^^ definition ujson/package.writeToByteArray().(indent) default indent: Int
//                             ^^^ reference scala/Int#
                       escapeUnicode: Boolean = false) = {
//                     ^^^^^^^^^^^^^ definition ujson/package.writeToByteArray().(escapeUnicode) default escapeUnicode: Boolean
//                                    ^^^^^^^ reference scala/Boolean#
    val baos = new java.io.ByteArrayOutputStream
//      ^^^^ definition local2 baos: ByteArrayOutputStream
//                 ^^^^ reference java/
//                      ^^ reference java/io/
//                         ^^^^^^^^^^^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#
//                                               reference java/io/ByteArrayOutputStream#`<init>`().
    writeToOutputStream(t, baos, indent, escapeUnicode)
//  ^^^^^^^^^^^^^^^^^^^ reference ujson/package.writeToOutputStream().
//                      ^ reference ujson/package.writeToByteArray().(t)
//                         ^^^^ reference local2
//                               ^^^^^^ reference ujson/package.writeToByteArray().(indent)
//                                       ^^^^^^^^^^^^^ reference ujson/package.writeToByteArray().(escapeUnicode)
    baos.toByteArray
//  ^^^^ reference local2
//       ^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#toByteArray().
  }

  /**
    * Parse the given JSON input, failing if it is invalid
    */
  def validate(s: Readable): Unit = transform(s, NoOpVisitor)
//    ^^^^^^^^ definition ujson/package.validate(). def validate(s: Readable): Unit
//             ^ definition ujson/package.validate().(s) s: Readable
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
//    ^^^^^^^^ definition ujson/package.reformat(). def reformat(s: Readable, indent: Int, escapeUnicode: Boolean): String
//             ^ definition ujson/package.reformat().(s) s: Readable
//                ^^^^^^^^ reference ujson/Readable#
//                          ^^^^^^ definition ujson/package.reformat().(indent) default indent: Int
//                                  ^^^ reference scala/Int#
//                                            ^^^^^^^^^^^^^ definition ujson/package.reformat().(escapeUnicode) default escapeUnicode: Boolean
//                                                           ^^^^^^^ reference scala/Boolean#
//                                                                             ^^^^^^ reference scala/Predef.String#
    val writer = new java.io.StringWriter()
//      ^^^^^^ definition local3 writer: StringWriter
//                   ^^^^ reference java/
//                        ^^ reference java/io/
//                           ^^^^^^^^^^^^ reference java/io/StringWriter#
//                                        reference java/io/StringWriter#`<init>`().
    reformatTo(s, writer, indent, escapeUnicode)
//  ^^^^^^^^^^ reference ujson/package.reformatTo().
//             ^ reference ujson/package.reformat().(s)
//                ^^^^^^ reference local3
//                        ^^^^^^ reference ujson/package.reformat().(indent)
//                                ^^^^^^^^^^^^^ reference ujson/package.reformat().(escapeUnicode)
    writer.toString
//  ^^^^^^ reference local3
//         ^^^^^^^^ reference java/io/StringWriter#toString().
  }
  /**
    * Parse the given JSON input and write it to a string with
    * the configured formatting to the given Writer
    */
  def reformatTo(s: Readable, out: java.io.Writer, indent: Int = -1, escapeUnicode: Boolean = false): Unit = {
//    ^^^^^^^^^^ definition ujson/package.reformatTo(). def reformatTo(s: Readable, out: Writer, indent: Int, escapeUnicode: Boolean): Unit
//               ^ definition ujson/package.reformatTo().(s) s: Readable
//                  ^^^^^^^^ reference ujson/Readable#
//                            ^^^ definition ujson/package.reformatTo().(out) out: Writer
//                                 ^^^^ reference java/
//                                      ^^ reference java/io/
//                                         ^^^^^^ reference java/io/Writer#
//                                                 ^^^^^^ definition ujson/package.reformatTo().(indent) default indent: Int
//                                                         ^^^ reference scala/Int#
//                                                                   ^^^^^^^^^^^^^ definition ujson/package.reformatTo().(escapeUnicode) default escapeUnicode: Boolean
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
//    ^^^^^^^^^^^^^^^^^^^^^^ definition ujson/package.reformatToOutputStream(). def reformatToOutputStream(s: Readable, out: OutputStream, indent: Int, escapeUnicode: Boolean): Unit
//                           ^ definition ujson/package.reformatToOutputStream().(s) s: Readable
//                              ^^^^^^^^ reference ujson/Readable#
                             out: java.io.OutputStream,
//                           ^^^ definition ujson/package.reformatToOutputStream().(out) out: OutputStream
//                                ^^^^ reference java/
//                                     ^^ reference java/io/
//                                        ^^^^^^^^^^^^ reference java/io/OutputStream#
                             indent: Int = -1,
//                           ^^^^^^ definition ujson/package.reformatToOutputStream().(indent) default indent: Int
//                                   ^^^ reference scala/Int#
                             escapeUnicode: Boolean = false): Unit = {
//                           ^^^^^^^^^^^^^ definition ujson/package.reformatToOutputStream().(escapeUnicode) default escapeUnicode: Boolean
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
//    ^^^^^^^^^^^^^^^^^^^ definition ujson/package.reformatToByteArray(). def reformatToByteArray(s: Readable, indent: Int, escapeUnicode: Boolean): Array[Byte]
//                        ^ definition ujson/package.reformatToByteArray().(s) s: Readable
//                           ^^^^^^^^ reference ujson/Readable#
                          indent: Int = -1,
//                        ^^^^^^ definition ujson/package.reformatToByteArray().(indent) default indent: Int
//                                ^^^ reference scala/Int#
                          escapeUnicode: Boolean = false) = {
//                        ^^^^^^^^^^^^^ definition ujson/package.reformatToByteArray().(escapeUnicode) default escapeUnicode: Boolean
//                                       ^^^^^^^ reference scala/Boolean#
    val baos = new java.io.ByteArrayOutputStream
//      ^^^^ definition local4 baos: ByteArrayOutputStream
//                 ^^^^ reference java/
//                      ^^ reference java/io/
//                         ^^^^^^^^^^^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#
//                                               reference java/io/ByteArrayOutputStream#`<init>`().
    reformatToOutputStream(s, baos, indent, escapeUnicode)
//  ^^^^^^^^^^^^^^^^^^^^^^ reference ujson/package.reformatToOutputStream().
//                         ^ reference ujson/package.reformatToByteArray().(s)
//                            ^^^^ reference local4
//                                  ^^^^^^ reference ujson/package.reformatToByteArray().(indent)
//                                          ^^^^^^^^^^^^^ reference ujson/package.reformatToByteArray().(escapeUnicode)
    baos.toByteArray
//  ^^^^ reference local4
//       ^^^^^^^^^^^ reference java/io/ByteArrayOutputStream#toByteArray().
  }
  // End ujson
  @deprecated("use ujson.Value")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  type Js = Value
//     ^^ definition ujson/package.Js# type Js >: Value <: Value
//          ^^^^^ reference ujson/Value#
  @deprecated("use ujson.Value")
// ^^^^^^^^^^ reference scala/deprecated#
//            reference scala/deprecated#`<init>`().
  val Js = Value
//    ^^ definition ujson/package.Js. @deprecated val Js:
//         ^^^^^ reference ujson/Value.
}
