package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum WarningMessage implements IMessage {
	CONTROLLER_TESTA;

	@Override
	public String getType() {
		return "WarningMessage";
	}

	@Override
	public String getName() {
		return this.name();
	}

}
