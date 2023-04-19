package minimized;

public class TabIndented {
//           ^^^^^^^^^^^ definition semanticdb maven . . minimized/TabIndented#
//                       documentation ```java\npublic class TabIndented\n```
//           ^^^^^^^^^^^ definition semanticdb maven . . minimized/TabIndented#`<init>`().
//                       documentation ```java\npublic TabIndented()\n```
→public void app() {
//           ^^^ definition semanticdb maven . . minimized/TabIndented#app().
//               documentation ```java\npublic void app()\n```
→→Object o = new Object() {
//^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//       ^ definition local 0
//         documentation ```java\nObject o\n```
//               ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
→→→@Override
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
→→→public boolean equals(Object other) {
//                ^^^^^^ definition local 3
//                       documentation ```java\n@Override\npublic boolean equals(Object other)\n```
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                              ^^^^^ definition local 6
//                                    documentation ```java\nObject other\n```
→→→→return false;
→→→}

→→→@Override
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
→→→public int hashCode() {
//            ^^^^^^^^ definition local 4
//                     documentation ```java\n@Override\npublic int hashCode()\n```
//                     relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
→→→→return System.identityHashCode(this);
//         ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#identityHashCode().
→→→}

→→→@Override
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
→→→public String toString() {
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//               ^^^^^^^^ definition local 5
//                        documentation ```java\n@Override\npublic String toString()\n```
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#toString().
→→→→return "";
→→→}
→→};
→}
}
