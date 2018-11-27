package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.INotifyMessage;


public enum ErrorMessage implements INotifyMessage {
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
