package cn.zzdz.component;

import cn.zzdz.error.MessageSourceHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;

public class I18n {
    public static String getMessage(String name, final String... param) {
        MyLocaleResolver myLocaleResolver = new MyLocaleResolver();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = myLocaleResolver.resolveLocale(request);
        String value = MessageSourceHolder.getMessageSource().getMessage(name, null, locale);
        value = MessageFormat.format(value, param);
        return value;
    }
}
