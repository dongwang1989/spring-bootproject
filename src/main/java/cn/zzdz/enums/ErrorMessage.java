package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum ErrorMessage implements IMessage {
    INCORRECT_PASSWORD,
    NOTCONTROLLER_MESSAGEB,
    POWER_NOTENOUGH,
    FAIL_OUT,
    REPEATNAME;
    @Override
    public String getName() {
        return name();
    }
}
