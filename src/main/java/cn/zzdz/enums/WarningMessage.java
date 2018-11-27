package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum WarningMessage implements IMessage {
	CONTROLLER_TESTA;

	@Override
	public String getName() {
		return getType() + "." + this.name();
	}

	@Override
	public String getEnumValue() {
		return typ + "." + getType();
	}

}
