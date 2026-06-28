package java25;

import module java.base;

/// Exercises language features that require Java 22 through Java 25 source support.
public class LanguageFeatures {
  /// Java 22 unnamed variables and unnamed record patterns.
  public static int unnamedVariablesAndPatterns(Object input) {
    int seen = 0;
    for (String _ : List.of("alpha", "beta")) {
      seen++;
    }
    try {
      Integer.parseInt("not-a-number");
    } catch (NumberFormatException _) {
      seen++;
    }
    if (input instanceof Range(int start, int _)) {
      return start + seen;
    }
    return seen;
  }

  /// Java 24/25 primitive patterns in switch.
  public static String primitivePatterns(int value) {
    return switch (value) {
      case byte _ -> "byte range";
      case int i when i > 0 -> "positive int";
      case int _ -> "int";
    };
  }

  /// Java 25 flexible constructor bodies.
  public static final class Child extends Parent {
    public Child(String input) {
      String normalized = Objects.requireNonNull(input).strip();
      if (normalized.isEmpty()) {
        throw new IllegalArgumentException("blank");
      }
      super(normalized);
    }
  }

  public static sealed class Parent permits Child {
    private final String value;

    protected Parent(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }
  }

  public record Range(int start, int end) {}
}
