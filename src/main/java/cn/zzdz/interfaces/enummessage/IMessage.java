package cn.zzdz.interfaces.enummessage;

import cn.zzdz.component.MyLocaleResolver;
import cn.zzdz.error.MessageSourceHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;

public interface IMessage  {


    public String getInfo();
    default String getMessage(String name, final String... param) {
        String value=this.getClass().getSimpleName().toUpperCase()+"."+name;
        MyLocaleResolver myLocaleResolver = new MyLocaleResolver();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = myLocaleResolver.resolveLocale(request);
        value= MessageSourceHolder.getMessageSource().getMessage(value, null, locale);
        value= MessageFormat.format(value, param);
        return value;
    }

}
