package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum ButtonMessage implements IMessage {
	BUTTON_PASSWORD;
	@Override
	public String getName() {
		return getType() + "." + this.name();
	}

	@Override
	public String getEnumValue() {
		return typ + "." + getType();
	}

}
