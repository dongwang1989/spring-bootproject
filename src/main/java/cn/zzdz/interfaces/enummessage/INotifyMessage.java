package cn.zzdz.interfaces.enummessage;

public interface INotifyMessage extends IMessage {

	public String typ = "INotifyMessage";

	@Override
	public default String getEnumValue() {

		//return  getName();
		return IMessage.typ + getType() + "." + getName();
	}
}
