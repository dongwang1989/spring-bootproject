package cn.zzdz.enums;

public enum RegularType implements LookUp {
    A("A");
    private String name;

    private RegularType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LookupType getLookupType() {
        return LookupType.Regular_Type;
    }

}
