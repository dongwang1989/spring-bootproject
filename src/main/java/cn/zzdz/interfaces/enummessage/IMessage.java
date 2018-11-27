package cn.zzdz.interfaces.enummessage;


public interface IMessage {
    Class<?> c = IMessage.class;
    public String typ = c.getSimpleName();



    default String getType() {
        Class<?> c2 = this.getClass();
        return c2.getSimpleName();
    }

    default String getName(Enum<?> d) {

        return getType() + "." + d.name();
    }

    default String getEnumValue() {
        return typ + "." + getType();
    }
}
