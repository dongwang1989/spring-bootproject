package cn.zzdz.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RUNTIME)
@Documented
public @interface IReturnEntityColum {

    String [] value()  default "";
    Class<?> clazz() ;
}
