package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum UserType implements IMessage {
    ADMIN("A"), USER("U");
    private String name;

    @Override
    public String getMessage(String... param) {
        return "LOOKUP."+getLookupType().getName()+"."+name;
    }

    public String getName() {
        return name;
    }

    private UserType(String name) {
        this.name = name;
    }

    LookupType getLookupType() {
        return LookupType.USER_TYPE;
    }
}
