package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public interface LookUp extends IMessage {
    public String lookup = "LOOKUP";

    public LookupType getLookupType();

    @Override
    default String getMessage(final String... param) {
        return lookup + "." + getLookupType().getName() + "." + getName();
    }

}