package org.scip_code.scip_java.javac;

import java.util.NoSuchElementException;

/**
 * A Java implementation of Rust's <code>Result[T, E]</code> type, or Scala's <code>Either[A, B]
 * </code>.
 *
 * @param <T> The type of a successful value.
 * @param <E> The type of the error value.
 */
public final class Result<T, E> {
  private enum Kind {
    Ok,
    Error;
  }

  private final Kind kind;
  private final T ok;
  private final E error;

  private Result(Kind kind, T ok, E error) {
    if (kind == Kind.Ok && ok == null)
      throw new IllegalArgumentException("ok must not be null when kind == Kind.Ok");
    if (kind == Kind.Error && error == null)
      throw new IllegalArgumentException("error must not be null when kind == Kind.Error");
    this.kind = kind;
    this.error = error;
    this.ok = ok;
  }

  public boolean isOk() {
    return kind == Kind.Ok;
  }

  public T getOrThrow() {
    if (kind == Kind.Ok) {
      return ok;
    } else {
      throw new NoSuchElementException("no ok value on Result.Error(" + error + ")");
    }
  }

  public E getErrorOrThrow() {
    if (kind == Kind.Error) {
      return error;
    } else {
      throw new NoSuchElementException("no error value on Result.Ok(" + ok + ")");
    }
  }

  public static <T, E> Result<T, E> ok(T value) {
    return new Result<>(Kind.Ok, value, null);
  }

  public static <T, E> Result<T, E> error(E value) {
    return new Result<>(Kind.Error, null, value);
  }
}
