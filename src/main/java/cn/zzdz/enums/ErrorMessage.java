package cn.zzdz.enums;

import cn.zzdz.component.I18n;
import cn.zzdz.interfaces.enummessage.IMessage;

public enum ErrorMessage implements IMessage {
    INCORRECT_PASSWORD, NOTCONTROLLER_MESSAGEB, POWER_NOTENOUGH;

    @Override
    public String getInfo(final String... param) {
        return I18n.getMessage(getType() + "." + this.name());
    }
}
