package cn.zzdz.error;


import cn.zzdz.component.MyLocaleResolver;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.interfaces.enummessage.IMessage;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;

public class EnumError extends RuntimeException {


    private static final long serialVersionUID = 1L;
    private String values;


    public EnumError(IMessage notifyMessage, final String... param) {
        MyLocaleResolver ft = new MyLocaleResolver();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = ft.resolveLocale(request);
        String mg = notifyMessage.getName();
        values = MessageSourceHolder.getMessageSource().getMessage(mg, null, locale);
        values = MessageFormat.format(values, param);
    }

    @Override
    public String getMessage() {
        final ResultDto resultdto = new ResultDto();
        resultdto.setResult(values);
        return values;
    }
}
