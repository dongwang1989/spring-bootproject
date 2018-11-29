package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum WarningMessage implements IMessage {
	CONTROLLER_TESTA;


    @Override
    public String getInfo(final String... param) {
        return getMessage(getType() + "." + this.name(), param);
    }
}
