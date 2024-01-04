package minimized;

public class TabIndented {
//           ^^^^^^^^^^^ definition semanticdb maven . . minimized/TabIndented#
//                       display_name TabIndented
//                       signature_documentation java public class TabIndented
//           ^^^^^^^^^^^ definition semanticdb maven . . minimized/TabIndented#`<init>`().
//                       display_name <init>
//                       signature_documentation java public TabIndented()
→public void app() {
//           ^^^ definition semanticdb maven . . minimized/TabIndented#app().
//               display_name app
//               signature_documentation java public void app()
→→Object o = new Object() {
//^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//       ^ definition local 0
//         display_name o
//         signature_documentation java Object o
//         enclosing_symbol semanticdb maven . . minimized/TabIndented#app().
//               ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
→→→@Override
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
→→→public boolean equals(Object other) {
//                ^^^^^^ definition local 2
//                       display_name equals
//                       signature_documentation java @Override\npublic boolean equals(Object other)
//                       enclosing_symbol local 1
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                              ^^^^^ definition local 3
//                                    display_name other
//                                    signature_documentation java Object other
//                                    enclosing_symbol local 2
→→→→return false;
→→→}

→→→@Override
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
→→→public int hashCode() {
//            ^^^^^^^^ definition local 4
//                     display_name hashCode
//                     signature_documentation java @Override\npublic int hashCode()
//                     enclosing_symbol local 1
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
//                        signature_documentation java @Override\npublic String toString()
//                        enclosing_symbol local 1
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#toString().
→→→→return "";
→→→}
→→};
→}
}
