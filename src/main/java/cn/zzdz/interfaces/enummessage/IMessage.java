package cn.zzdz.interfaces.enummessage;

import cn.zzdz.component.MyLocaleResolver;
import cn.zzdz.error.MessageSourceHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;

public interface IMessage {
    Class<?> c = IMessage.class;
    public String typ = c.getSimpleName();


    default String getType() {
        Class<?> c2 = this.getClass();
        return c2.getSimpleName();
    }

    default String getName(Enum<?> d) {

        return getType().toUpperCase() + "." + d.name();
    }
    default  String getMessage(IMessage imessage, final String... param) {
        MyLocaleResolver myLocaleResolver=new MyLocaleResolver();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = myLocaleResolver.resolveLocale(request);
        String values = imessage.getName((Enum<?>) imessage);
        values = MessageSourceHolder.getMessageSource().getMessage(values, null, locale);
        values = MessageFormat.format(values, param);
        return values;
    }
    default String getEnumValue() {
        return typ + "." + getType();
    }
}
