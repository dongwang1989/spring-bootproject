package cn.zzdz.usercontroller;

import cn.zzdz.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;

@Controller
public class I18nController {
    @Resource
    private MessageSource messageSource;

    @Autowired
    private MyLocaleResolver localea;

    public  String getMge(HttpServletRequest httpServletRequest,String info,String nam){
        Locale locale=localea.resolveLocale(httpServletRequest);
        String str=messageSource.getMessage(info, null,locale);
        str= MessageFormat.format(str, nam);
        System.out.println(str);
        return str;

    }
}
