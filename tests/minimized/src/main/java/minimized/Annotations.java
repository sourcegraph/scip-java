package minimized;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {CONSTRUCTOR,
        FIELD,
        LOCAL_VARIABLE,
        METHOD,
        PACKAGE,
        PARAMETER,
        TYPE}
)
public @interface Annotations {

  String value() default "";

  String format() default "";
}
