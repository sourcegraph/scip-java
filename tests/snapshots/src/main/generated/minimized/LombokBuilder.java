package minimized;

@lombok.Builder
//^^^^^ definition minimized/Hello#HelloBuilder#build(). @SuppressWarnings("all") public Hello build()
//^^^^^^^ definition local0 final String message
//^^^^^^^ definition minimized/Hello#HelloBuilder#message. @SuppressWarnings("all") private String message
//^^^^^^^ definition minimized/Hello#HelloBuilder#message(). @SuppressWarnings("all") public HelloBuilder message(String message)
//^^^^^^^ definition local1 final String message
//^^^^^^^ definition minimized/Hello#builder(). @SuppressWarnings("all") public static HelloBuilder builder()
//^^^^^^^^ definition minimized/Hello#HelloBuilder#toString(). @Override @SuppressWarnings("all") public String toString()
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference java/lang/String#
//^^^^^^^^^^^^^^^ reference local0
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#value().
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#value().
//^^^^^^^^^^^^^^^ reference java/lang/String#
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference minimized/Hello#
//^^^^^^^^^^^^^^^ reference java/lang/String#
//^^^^^^^^^^^^^^^ reference local1
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference minimized/Hello#
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference java/
//^^^^^^^^^^^^^^^ reference minimized/Hello#
//^^^ reference java/lang/
//^^^ reference java/lang/
//^^^ reference java/lang/
//^^^ reference java/lang/
//^^^ reference java/lang/
//^^^ reference java/lang/
//^^^ reference java/lang/
//^^^ reference java/lang/
//^^^ reference java/lang/
//^^^ reference java/lang/
//^^^^^ reference lombok/
//^^^^^ reference java/lang/String#
//^^^^^^ reference minimized/Hello#message.
//^^^^^^ reference minimized/Hello#HelloBuilder#message.
//^^^^^^ reference minimized/Hello#HelloBuilder#message.
//^^^^^^ reference minimized/Hello#HelloBuilder#message.
//^^^^^^^ reference java/lang/Override#
//^^^^^^^^^^^ reference minimized/Hello#HelloBuilder#
//^^^^^^^^^^^ reference minimized/Hello#HelloBuilder#
//^^^^^^^^^^^^^ reference java/lang/SuppressWarnings# 1:1
//^^^^^^^^^^^^^ reference java/lang/SuppressWarnings# 1:1
//^^^^^^^^^^^^^ reference java/lang/SuppressWarnings# 1:1
//^^^^^^^^^^^^^ reference java/lang/SuppressWarnings# 1:1
//^^^^^^^^^^^^^ reference java/lang/SuppressWarnings# 1:1
//^^^^^^^^^^^^^ reference java/lang/SuppressWarnings# 1:1
//^^^^^^^^^^^^^ reference java/lang/SuppressWarnings# 1:1
//^^^^^^^^^^^^^ reference java/lang/SuppressWarnings# 1:1
//      ^^^^^^^ reference lombok/Builder#
class Hello {
//    ^^^^^ definition minimized/Hello# @Builder class Hello
//    ^^^^^ definition minimized/Hello#`<init>`(). @SuppressWarnings("all") Hello(String message)
//    ^^^^^ reference minimized/Hello#`<init>`().
→private String message;
//       ^^^^^^ reference java/lang/String#
//              ^^^^^^^ definition minimized/Hello#message. private String message
}
