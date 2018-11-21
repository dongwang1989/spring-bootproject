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

    @Autowired
    private I18nController i18nController;

    @Autowired
    private MyLocaleResolver mylocale;
    private static final long serialVersionUID = 1L;
    private  String values;

    public EnumError(String bb,String aa) {
        MyLocaleResolver ft =new MyLocaleResolver();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = ft.resolveLocale(request);
        values = MessageSourceHolder.getMessageSource().getMessage(bb, null, locale);
        values= MessageFormat.format(values,aa);
        System.out.println(values);
    }
    public EnumError(INotifyMessage notifyMessage,final String ... param) {
        MyLocaleResolver ft =new MyLocaleResolver();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = ft.resolveLocale(request);
        String mg=notifyMessage.getName();
        values = MessageSourceHolder.getMessageSource().getMessage(mg, null, locale);
        values= MessageFormat.format(values,param[0]);
        System.out.println(values);
    }
//    public EnumError(final INotifyMessage message, final String... params) {
//        MyLocaleResolver ft =new MyLocaleResolver();
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        ft.resolveLocale(request);
//        //String msg=i18nController.getMge(httpServletRequest,message.getName(),params[0]);
//        values = MessageSourceHolder.getMessageSource().getMessage(message.getName(), params, null);
//    }
    @Override
    public String getMessage() {
        final ResultDto resultdto = new ResultDto();
        resultdto.setResult(values);
        return values;//resultdto.toString();
    }
}
