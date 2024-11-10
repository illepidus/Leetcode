package ru.krotarnya.leetcode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Problem {
    int id();

    String name();

    Complexity complexity();

    Resolution resolution() default Resolution.FAIR;

    String className() default "Solution";
}
