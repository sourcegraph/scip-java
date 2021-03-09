package minimized;

import java.util.Collections;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^ reference java/util/Collections#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#

@SuppressWarnings("ALL")
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
public class RawTypes {
//     ^^^^^^ definition minimized/RawTypes#`<init>`().
//     ^^^^^^^^ definition minimized/RawTypes#
  public static final List x = Collections.singletonList(42);
//                    ^^^^ reference java/util/List#
//                         ^ definition minimized/RawTypes#x.
//                             ^^^^^^^^^^^ reference java/util/Collections#
//                                         ^^^^^^^^^^^^^ reference java/util/Collections#singletonList().
}
