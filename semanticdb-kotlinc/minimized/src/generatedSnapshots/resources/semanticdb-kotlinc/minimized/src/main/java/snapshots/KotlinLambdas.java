  package snapshots;
  
  import kotlin.collections.CollectionsKt;
//       ^^^^^^ reference scip-java maven . . kotlin/
//              ^^^^^^^^^^^ reference scip-java maven . . kotlin/collections/
//                          ^^^^^^^^^^^^^ reference scip-java maven . . kotlin/collections/CollectionsKt#
  import kotlin.text.StringsKt;
//       ^^^^^^ reference scip-java maven . . kotlin/
//              ^^^^ reference scip-java maven . . kotlin/text/
//                   ^^^^^^^^^ reference scip-java maven . . kotlin/text/StringsKt#
  
//⌄ enclosing_range_start scip-java maven . . snapshots/KotlinLambdas#
  public class KotlinLambdas {
//             ^^^^^^^^^^^^^ definition scip-java maven . . snapshots/KotlinLambdas#
//                           display_name KotlinLambdas
//                           signature_documentation java public class KotlinLambdas
//                           kind Class
//             ^^^^^^^^^^^^^ definition scip-java maven . . snapshots/KotlinLambdas#`<init>`().
//                           display_name <init>
//                           signature_documentation java public KotlinLambdas()
//                           kind Constructor
//  ⌄ enclosing_range_start scip-java maven . . snapshots/KotlinLambdas#test().
    public void test() {
//              ^^^^ definition scip-java maven . . snapshots/KotlinLambdas#test().
//                   display_name test
//                   signature_documentation java public void test()
//                   kind Method
      LambdasKt.getX(); // TODO figure out emit getX on kotlin side
//    ^^^^^^^^^ reference scip-java maven . . snapshots/LambdasKt#
//              ^^^^ reference scip-java maven . . snapshots/LambdasKt#getX().
  
      kotlin.collections.CollectionsKt.listOf();
//    ^^^^^^ reference scip-java maven . . kotlin/
//           ^^^^^^^^^^^ reference scip-java maven . . kotlin/collections/
//                       ^^^^^^^^^^^^^ reference scip-java maven . . kotlin/collections/CollectionsKt#
//                                     ^^^^^^ reference scip-java maven . . kotlin/collections/CollectionsKt__CollectionsKt#listOf().
      FunctionsKt.sampleText("");
//    ^^^^^^^^^^^ reference scip-java maven . . snapshots/FunctionsKt#
//                ^^^^^^^^^^ reference scip-java maven . . snapshots/FunctionsKt#sampleText().
    }
//  ⌃ enclosing_range_end scip-java maven . . snapshots/KotlinLambdas#test().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/KotlinLambdas#
