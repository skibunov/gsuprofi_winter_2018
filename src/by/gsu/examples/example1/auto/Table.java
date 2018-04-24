package by.gsu.examples.example1.auto;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
//    String value();
    String name();
    String collation() default "UTF-8";
}
