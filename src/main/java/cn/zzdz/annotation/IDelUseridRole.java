package cn.zzdz.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
@Documented
public @interface IDelUseridRole {
    /**
     *
     * 到底实体还是单独参数
     */
    String value() default "entity";
}
