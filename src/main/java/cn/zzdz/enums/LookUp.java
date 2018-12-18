package cn.zzdz.enums;

import cn.zzdz.component.MyLocaleResolver;
import cn.zzdz.error.MessageSourceHolder;
import cn.zzdz.interfaces.enummessage.IMessage;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public interface LookUp extends IMessage {
    public String lookup = "LOOKUP";

    public LookupType getLookupType();

    @Override
    default String getMessage(final String... param) {
        final MyLocaleResolver myLocaleResolver = new MyLocaleResolver();
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        final Locale locale = myLocaleResolver.resolveLocale(request);
        return MessageSourceHolder.getMessageSource().getMessage(lookup + "." + getLookupType().getName() + "." + getName(), param, locale);
    }

}