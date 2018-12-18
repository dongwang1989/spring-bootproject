package cn.zzdz.interfaces.enummessage;

import cn.zzdz.component.MyLocaleResolver;
import cn.zzdz.error.MessageSourceHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public interface IMessage {
    default String getMessage(final String... param) {
        final MyLocaleResolver myLocaleResolver = new MyLocaleResolver();
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        final Locale locale = myLocaleResolver.resolveLocale(request);
        System.out.println(getType() + "." + getName());
        return MessageSourceHolder.getMessageSource().getMessage(getType() + "." + getName(), param, locale);

    }
    String getName();

    default String getType() {
        return getClass().getSimpleName().toUpperCase();
    }


}
