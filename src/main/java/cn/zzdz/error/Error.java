package cn.zzdz.error;

import cn.zzdz.dto.ResultDto;
import cn.zzdz.interfaces.enummessage.INotifyMessage;

public class Error extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String values;

	public Error(final INotifyMessage message, final String... params) {

		values = MessageSourceHolder.getMessageSource().getMessage(message.getEnumValue(), params, null);
	}

	@Override
	public String getMessage() {
		final ResultDto resultdto = new ResultDto();
		resultdto.setResult(values);
		return resultdto.toString();
	}

}
