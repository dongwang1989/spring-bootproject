package cn.zzdz.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
@Documented
public @interface IDelUserRplePermion {
    String value() default "";
    String value2() default "";

}
