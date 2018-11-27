package cn.zzdz.interfaces.enummessage;


public interface IMessage {
    Class<?> c = IMessage.class;
    public String typ = c.getSimpleName();

    default String getEnumValue() {
       return  typ;
    }

    default String getType() {
        Class<?> c2 = this.getClass();
        return c2.getSimpleName();
    }

    public String getName();
}
