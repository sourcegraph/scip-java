
import com.google.auto.value.AutoValue;

@AutoValue
abstract class Animal {
  static Animal create(String name, int numberOfLegs) {
    return new AutoValue_Animal(name, numberOfLegs);
  }

  abstract String name();
  abstract int numberOfLegs();
}
