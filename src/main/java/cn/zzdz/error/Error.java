package cn.zzdz.error;

import cn.zzdz.component.MyLocaleResolver;
import cn.zzdz.config.WebMvcConfiguration;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.interfaces.enummessage.INotifyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


public class Error extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String values;

	public Error(final INotifyMessage message, final String... params) {
		System.out.println(message.getName());
		String val=message.getEnumValue();
		values = MessageSourceHolder.getMessageSource().getMessage(val, null, null);
		//values = MessageSourceHolder.getMessageSource().getMessage(message.getEnumValue(), params, null);
	}

	@Override
	public String getMessage() {
		final ResultDto resultdto = new ResultDto();
		resultdto.setResult(values);
		return resultdto.toString();
	}

}
