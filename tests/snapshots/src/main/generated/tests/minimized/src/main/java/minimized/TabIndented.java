package minimized;

public class TabIndented {
//           ^^^^^^^^^^^ definition semanticdb maven . . minimized/TabIndented#
//                       display_name TabIndented
//                       documentation ```java\npublic class TabIndented\n```
//           ^^^^^^^^^^^ definition semanticdb maven . . minimized/TabIndented#`<init>`().
//                       display_name <init>
//                       documentation ```java\npublic TabIndented()\n```
→public void app() {
//           ^^^ definition semanticdb maven . . minimized/TabIndented#app().
//               display_name app
//               documentation ```java\npublic void app()\n```
→→Object o = new Object() {
//^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//       ^ definition local 0
//         display_name o
//         documentation ```java\nObject o\n```
//               ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
→→→@Override
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
→→→public boolean equals(Object other) {
//                ^^^^^^ definition local 2
//                       display_name equals
//                       documentation ```java\n@Override\npublic boolean equals(Object other)\n```
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                              ^^^^^ definition local 3
//                                    display_name other
//                                    documentation ```java\nObject other\n```
→→→→return false;
→→→}

→→→@Override
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
→→→public int hashCode() {
//            ^^^^^^^^ definition local 4
//                     display_name hashCode
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
//                        display_name toString
//                        documentation ```java\n@Override\npublic String toString()\n```
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#toString().
→→→→return "";
→→→}
→→};
→}
}
