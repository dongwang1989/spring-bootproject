package cn.zzdz.error;

import cn.zzdz.dto.ResultDto;
import cn.zzdz.interfaces.enummessage.IMessage;


public class Error extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String values;

	public Error(final IMessage message, final String... params) {
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
