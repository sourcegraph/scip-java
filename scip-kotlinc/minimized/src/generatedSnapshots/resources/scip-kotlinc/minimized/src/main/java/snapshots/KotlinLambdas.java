  package snapshots;
  
  import kotlin.collections.CollectionsKt;
//       ^^^^^^ reference scip-java maven . . scip-java maven . . kotlin/
//              ^^^^^^^^^^^ reference scip-java maven . . scip-java maven . . kotlin/collections/
//                          ^^^^^^^^^^^^^ reference scip-java maven . . scip-java maven . . kotlin/collections/CollectionsKt#
  import kotlin.text.StringsKt;
//       ^^^^^^ reference scip-java maven . . scip-java maven . . kotlin/
//              ^^^^ reference scip-java maven . . scip-java maven . . kotlin/text/
//                   ^^^^^^^^^ reference scip-java maven . . scip-java maven . . kotlin/text/StringsKt#
  
//⌄ enclosing_range_start scip-java maven . . scip-java maven . . snapshots/KotlinLambdas#
  public class KotlinLambdas {
//             ^^^^^^^^^^^^^ definition scip-java maven . . scip-java maven . . snapshots/KotlinLambdas#
//                           kind Class
//                           display_name KotlinLambdas
//                           signature_documentation
//                           > public class KotlinLambdas
//             ^^^^^^^^^^^^^ definition scip-java maven . . scip-java maven . . snapshots/KotlinLambdas#`<init>`().
//                           kind Constructor
//                           display_name <init>
//                           signature_documentation
//                           > public KotlinLambdas()
//  ⌄ enclosing_range_start scip-java maven . . scip-java maven . . snapshots/KotlinLambdas#test().
    public void test() {
//              ^^^^ definition scip-java maven . . scip-java maven . . snapshots/KotlinLambdas#test().
//                   kind Method
//                   display_name test
//                   signature_documentation
//                   > public void test()
      LambdasKt.getX(); // TODO figure out emit getX on kotlin side
//    ^^^^^^^^^ reference scip-java maven . . scip-java maven . . snapshots/LambdasKt#
//              ^^^^ reference scip-java maven . . scip-java maven . . snapshots/LambdasKt#getX().
  
      kotlin.collections.CollectionsKt.listOf();
//    ^^^^^^ reference scip-java maven . . scip-java maven . . kotlin/
//           ^^^^^^^^^^^ reference scip-java maven . . scip-java maven . . kotlin/collections/
//                       ^^^^^^^^^^^^^ reference scip-java maven . . scip-java maven . . kotlin/collections/CollectionsKt#
//                                     ^^^^^^ reference scip-java maven . . scip-java maven . . kotlin/collections/CollectionsKt__CollectionsKt#listOf().
      FunctionsKt.sampleText("");
//    ^^^^^^^^^^^ reference scip-java maven . . scip-java maven . . snapshots/FunctionsKt#
//                ^^^^^^^^^^ reference scip-java maven . . scip-java maven . . snapshots/FunctionsKt#sampleText().
    }
//  ⌃ enclosing_range_end scip-java maven . . scip-java maven . . snapshots/KotlinLambdas#test().
  }
//⌃ enclosing_range_end scip-java maven . . scip-java maven . . snapshots/KotlinLambdas#
  
