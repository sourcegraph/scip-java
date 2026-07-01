import module java.base;

/// Compact source file with an instance main method.
void main() {
  IO.println(message());
}

String message() {
  return List.of("Java", "25").get(1);
}
