  package snapshots;
  
  import kotlin.collections.CollectionsKt;
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/
//                          ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/CollectionsKt#
  import kotlin.text.StringsKt;
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^ reference semanticdb maven . . kotlin/text/
//                   ^^^^^^^^^ reference semanticdb maven . . kotlin/text/StringsKt#
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/KotlinLambdas#
  public class KotlinLambdas {
//             ^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/KotlinLambdas#
//                           display_name KotlinLambdas
//                           signature_documentation java public class KotlinLambdas
//                           kind Class
//             ^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/KotlinLambdas#`<init>`().
//                           display_name <init>
//                           signature_documentation java public KotlinLambdas()
//                           kind Constructor
//  ⌄ enclosing_range_start semanticdb maven . . snapshots/KotlinLambdas#test().
    public void test() {
//              ^^^^ definition semanticdb maven . . snapshots/KotlinLambdas#test().
//                   display_name test
//                   signature_documentation java public void test()
//                   kind Method
      LambdasKt.getX(); // TODO figure out emit getX on kotlin side
//    ^^^^^^^^^ reference semanticdb maven . . snapshots/LambdasKt#
//              ^^^^ reference semanticdb maven . . snapshots/LambdasKt#getX().
  
      kotlin.collections.CollectionsKt.listOf();
//    ^^^^^^ reference semanticdb maven . . kotlin/
//           ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/CollectionsKt#
//                                     ^^^^^^ reference semanticdb maven . . kotlin/collections/CollectionsKt__CollectionsKt#listOf().
      FunctionsKt.sampleText("");
//    ^^^^^^^^^^^ reference semanticdb maven . . snapshots/FunctionsKt#
//                ^^^^^^^^^^ reference semanticdb maven . . snapshots/FunctionsKt#sampleText().
    }
//  ⌃ enclosing_range_end semanticdb maven . . snapshots/KotlinLambdas#test().
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/KotlinLambdas#
