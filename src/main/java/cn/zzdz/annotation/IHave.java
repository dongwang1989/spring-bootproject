package cn.zzdz.annotation;

import cn.zzdz.domain.SysUser;
import cn.zzdz.enums.RegularType;
import cn.zzdz.interfaces.service.ILogin;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = IHave.StringChecker.class)
public @interface IHave {
    String message() default "用户名已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class StringChecker implements ConstraintValidator<IHave, Object> {
        @Autowired
        private ILogin userservice;

        @Override
        public void initialize(IHave arg0) {

        }

        public static Boolean isObjectNotEmpty(Object obj) {
            String str = ObjectUtils.toString(obj, "");
            return StringUtils.isNotBlank(str);
        }

        @Override
        public boolean isValid(Object username, ConstraintValidatorContext context) {
            System.out.println("##########");
            boolean isMatch = false;
            if (StringChecker.isObjectNotEmpty(username)) {
                List<SysUser> list = userservice.getUserByusername(username.toString(),1,10);
                if (list == null || list.size() == 0) {
                    isMatch = true;
                }
            }
            return isMatch;
        }
    }
}
