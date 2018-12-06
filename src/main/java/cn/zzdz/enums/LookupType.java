package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum LookupType implements IMessage {
    USER_STATUS("STAT"), LOOKUP("LU"), USER_TYPE("TYPE");
    private String name;

    private LookupType(String name) {
        this.name = name;
        //this.name =getLookupType().getName();
    }

    public String getName() {
        return name;
    }


    LookupType getLookupType() {
        return LookupType.LOOKUP;
    }
}
