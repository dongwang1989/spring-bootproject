package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum WarningMessage implements IMessage {
    CONTROLLER_TESTA;

    LookupType getLookupType() {
        return null;
    }

    @Override
    public String getName() {
        return name();
    }
}
