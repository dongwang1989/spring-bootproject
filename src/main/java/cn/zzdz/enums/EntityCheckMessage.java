package cn.zzdz.enums;

public enum EntityCheckMessage implements LookUp {
    PAGEINDEX("PAGEINDEX"), PAGESIZE("PAGESIZE");

    private String name;

    private EntityCheckMessage(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LookupType getLookupType() {
        return LookupType.Entity_CheckMessage;
    }
}
