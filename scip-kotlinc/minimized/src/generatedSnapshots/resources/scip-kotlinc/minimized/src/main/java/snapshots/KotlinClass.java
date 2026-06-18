  package snapshots;
  
//⌄ enclosing_range_start scip-java maven . . snapshots/KotlinClass#
  public class KotlinClass {
//             ^^^^^^^^^^^ definition scip-java maven . . snapshots/KotlinClass#
//                         kind Class
//                         display_name KotlinClass
//                         signature_documentation
//                         > public class KotlinClass
//  ⌄ enclosing_range_start scip-java maven . . snapshots/KotlinClass#`<init>`().
    KotlinClass() throws Class {
//  ^^^^^^^^^^^ definition scip-java maven . . snapshots/KotlinClass#`<init>`().
//              kind Constructor
//              display_name <init>
//              signature_documentation
//              > KotlinClass() throws Class
//                       ^^^^^ reference scip-java maven . . snapshots/Class#
      throw new Class();
//              ^^^^^ reference scip-java maven . . snapshots/Class#`<init>`(+1).
    }
//  ⌃ enclosing_range_end scip-java maven . . snapshots/KotlinClass#`<init>`().
  
//  ⌄ enclosing_range_start scip-java maven . . snapshots/KotlinClass#test().
    void test() throws Class {
//       ^^^^ definition scip-java maven . . snapshots/KotlinClass#test().
//            kind Method
//            display_name test
//            signature_documentation
//            > void test() throws Class
//                     ^^^^^ reference scip-java maven . . snapshots/Class#
      throw new Class(1, "");
//              ^^^^^ reference scip-java maven . . snapshots/Class#`<init>`().
    }
//  ⌃ enclosing_range_end scip-java maven . . snapshots/KotlinClass#test().
  
//  ⌄ enclosing_range_start scip-java maven . . snapshots/KotlinClass#other().
    void other() throws Class {
//       ^^^^^ definition scip-java maven . . snapshots/KotlinClass#other().
//             kind Method
//             display_name other
//             signature_documentation
//             > void other() throws Class
//                      ^^^^^ reference scip-java maven . . snapshots/Class#
      throw new Class(1);
//              ^^^^^ reference scip-java maven . . snapshots/Class#`<init>`(+2).
    }
//  ⌃ enclosing_range_end scip-java maven . . snapshots/KotlinClass#other().
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/KotlinClass#
  
