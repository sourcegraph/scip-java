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
//           ^^^^^^^^ definition minimized/RawTypes# @SuppressWarnings("ALL") public class RawTypes
//           ^^^^^^^^ definition minimized/RawTypes#`<init>`(). public RawTypes()
  public static final List x = Collections.singletonList(42);
//                    ^^^^ reference java/util/List#
//                         ^ definition minimized/RawTypes#x. public static final List x
//                             ^^^^^^^^^^^ reference java/util/Collections#
//                                         ^^^^^^^^^^^^^ reference java/util/Collections#singletonList().
}
