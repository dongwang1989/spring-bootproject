package cn.zzdz.interfaces.enummessage;


import sun.tracing.dtrace.DTraceProviderFactory;

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
