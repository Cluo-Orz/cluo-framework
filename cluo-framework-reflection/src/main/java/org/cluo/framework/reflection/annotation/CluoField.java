package org.cluo.framework.reflection.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)

public @interface CluoField {
    String value() default "";
    boolean ignore() default false;
}
