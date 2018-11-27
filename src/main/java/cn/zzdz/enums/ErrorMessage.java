package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;


public enum ErrorMessage implements IMessage {
    INCORRECT_PASSWORD, POWER_NOTENOUGH, NOTCONTROLLER_MESSAGEB;

    @Override
    public String getName() {
        return getType() + "." + this.name();
    }

    @Override
    public String getEnumValue() {
        return typ + "." + getType();
    }

}
