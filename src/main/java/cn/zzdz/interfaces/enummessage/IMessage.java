package cn.zzdz.interfaces.enummessage;

public interface IMessage {
    default String getType() {
        return this.getClass().getSimpleName().toUpperCase();
    }

    public String getInfo(final String... param);

}
