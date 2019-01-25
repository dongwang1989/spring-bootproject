package cn.zzdz.annotation;

import cn.zzdz.enums.RegularType;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD,ElementType.PARAMETER})
//METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = Ipassword.StringChecker.class)
public @interface Ipassword {
    String message() default "用户不存在或者不属于当前组织";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

   public class StringChecker implements ConstraintValidator<Ipassword, Object> {

        @Override
        public void initialize(Ipassword arg0) {

        }

        @Override
        public boolean isValid(Object password, ConstraintValidatorContext context) {
            String pwdregular = RegularType.A.getMessage();
            Pattern p = Pattern.compile(pwdregular);
            Matcher m = p.matcher(password.toString());
            boolean isMatch = m.matches();
            return  isMatch;
        }
    }

}
