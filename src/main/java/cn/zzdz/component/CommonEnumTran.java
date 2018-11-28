package cn.zzdz.component;

import cn.zzdz.error.MessageSourceHolder;
import cn.zzdz.interfaces.enummessage.IMessage;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * Common enumeration transformation
 */

public class CommonEnumTran {

    public static String getMessage(IMessage imessage, final String... param) {
        MyLocaleResolver myLocaleResolver=new MyLocaleResolver();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = myLocaleResolver.resolveLocale(request);
        String values = imessage.getName((Enum<?>) imessage);
        values = MessageSourceHolder.getMessageSource().getMessage(values, null, locale);
        values = MessageFormat.format(values, param);
        return values;
    }


}
