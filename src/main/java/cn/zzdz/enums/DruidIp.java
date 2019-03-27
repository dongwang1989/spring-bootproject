package cn.zzdz.enums;

public enum DruidIp implements LookUp {

    AllowIp("Yip"),DenyIp("Nip");
    private String name;

    private DruidIp(String name) {
        this.name = name;
    }

    @Override
    public LookupType getLookupType() {
        return LookupType.Druid_Ip;
    }

    @Override
    public String getName() {
        return name;
    }
}
