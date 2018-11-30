package cn.zzdz.interfaces.enummessage;

import cn.zzdz.component.MyLocaleResolver;
import cn.zzdz.error.MessageSourceHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;

public interface IMessage {
    default String getType() {
        return this.getClass().getSimpleName().toUpperCase();
    }

    public String getInfo(final String... param);
    default String getMessage(String name, final String... param) {
        MyLocaleResolver myLocaleResolver = new MyLocaleResolver();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = myLocaleResolver.resolveLocale(request);
        String value = MessageSourceHolder.getMessageSource().getMessage(name, null, locale);
        value = MessageFormat.format(value, param);
        return value;
    }

}
