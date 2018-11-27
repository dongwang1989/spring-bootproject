package cn.zzdz.interfaces.enummessage;

public interface INotifyMessage extends IMessage {
	Class<?> c = INotifyMessage.class;

	public String typ = IMessage.typ+"."+c.getSimpleName();

}
