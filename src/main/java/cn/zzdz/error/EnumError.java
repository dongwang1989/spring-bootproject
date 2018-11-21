package cn.zzdz.error;


import cn.zzdz.component.MyLocaleResolver;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.interfaces.enummessage.INotifyMessage;
import cn.zzdz.usercontroller.I18nController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;

public class EnumError extends RuntimeException {

//    @Autowired
//    private I18nController i18nController;
//
//    @Autowired
//    private MyLocaleResolver mylocale;
    private static final long serialVersionUID = 1L;
    private  String values;


    public EnumError(INotifyMessage notifyMessage,final String ... param) {
        MyLocaleResolver ft =new MyLocaleResolver();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = ft.resolveLocale(request);
        String mg=notifyMessage.getName();
        values = MessageSourceHolder.getMessageSource().getMessage(mg, null, locale);
        values= MessageFormat.format(values,param);
        System.out.println(values);
    }
    @Override
    public String getMessage() {
        final ResultDto resultdto = new ResultDto();
        resultdto.setResult(values);
        return values;//resultdto.toString();
    }
}
