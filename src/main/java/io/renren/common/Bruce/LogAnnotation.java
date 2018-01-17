package io.renren.common.Bruce;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface LogAnnotation {
    String Value() default "";
}
