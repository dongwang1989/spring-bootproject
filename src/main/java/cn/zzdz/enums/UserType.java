package cn.zzdz.enums;

public enum UserType implements LookUp {
    ADMIN("A"), USER("U");
    private String name;


    private UserType(String name) {
        this.name = name;
    }


    @Override
    public LookupType getLookupType() {
        return LookupType.USER_TYPE;
    }

    @Override
    public String getName() {
        return name;
    }
}
