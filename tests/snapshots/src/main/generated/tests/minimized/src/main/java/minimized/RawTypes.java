package minimized;

import java.util.Collections;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#

@SuppressWarnings("ALL")
//^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
public class RawTypes {
//           ^^^^^^^^ definition semanticdb maven . . minimized/RawTypes#
//                    display_name RawTypes
//                    documentation ```java\n@SuppressWarnings("ALL")\npublic class RawTypes\n```
//           ^^^^^^^^ definition semanticdb maven . . minimized/RawTypes#`<init>`().
//                    display_name <init>
//                    documentation ```java\npublic RawTypes()\n```
  public static final List x = Collections.singletonList(42);
//                    ^^^^ reference semanticdb maven jdk 11 java/util/List#
//                         ^ definition semanticdb maven . . minimized/RawTypes#x.
//                           display_name x
//                           documentation ```java\npublic static final List x\n```
//                             ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#
//                                         ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collections#singletonList().
}
