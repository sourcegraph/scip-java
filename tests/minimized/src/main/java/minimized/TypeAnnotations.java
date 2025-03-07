package minimized;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE_USE })
@interface TypeAnnotation {
    int integer() default 1;
}

// FIXME(issue: GRAPH-1122): Definition range for T below is incorrect
class ClassProcessed<@TypeAnnotation T extends Number> {

    public ClassProcessed() {
        String s = new @TypeAnnotation String();
    }
}
