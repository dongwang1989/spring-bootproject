package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum ButtonMessage implements IMessage {
	BUTTON_PASSWORD;

	@Override
	public String getInfo(final String... param) {
		return getMessage(getType() + "." + this.name(), param);
	}
}
