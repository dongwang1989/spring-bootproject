package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.INotifyMessage;

public enum WarningMessage implements INotifyMessage {
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
