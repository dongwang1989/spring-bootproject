package cn.zzdz.enums;

public enum UserStatus implements LookUp {
    ACTIVE("A"), DISABLED("D");
    private String name;

    private UserStatus(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LookupType getLookupType() {
        return LookupType.USER_STATUS;
    }

}
