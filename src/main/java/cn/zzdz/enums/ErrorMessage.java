package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.INotifyMessage;

public enum ErrorMessage implements INotifyMessage {
	INCORRECT_PASSWORD, POWER_NOTENOUGH, NOTCONTROLLER_MESSAGEB;

	@Override
	public String getType() {
		return typ + "." + "ErrorMessage";
	}

	@Override
	public String getName() {
		return this.name();
	}

}
