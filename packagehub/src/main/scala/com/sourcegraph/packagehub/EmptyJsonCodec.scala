package com.sourcegraph.packagehub

import moped.json.DecodingContext
import moped.json.ErrorResult
import moped.json.JsonCodec
import moped.json.JsonElement
import moped.json.JsonString
import moped.json.Result
import moped.macros.ClassShape
import moped.reporters.Diagnostic

/**
 * Codec that always fails the decoding step.
 *
 * Useful for types that cannot be configured from the command-line.
 */
class EmptyJsonCodec[T] extends JsonCodec[T] {
  def decode(context: DecodingContext): Result[T] =
    ErrorResult(Diagnostic.error(s"not supported: $context"))
  def encode(value: T): JsonElement = JsonString(value.toString())
  def shape: ClassShape = ClassShape.empty
}
