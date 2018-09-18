package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum ButtonMessage implements IMessage {
	BUTTON_PASSWORD;
	@Override
	public String getType() {
		return "BUTTONMESSAGE";
	}

	@Override
	public String getName() {
		return this.name();
	}

}
