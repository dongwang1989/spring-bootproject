package cn.zzdz.interfaces.enummessage;

public interface IMessage {
	public String typ = "IMessage";

	default String getEnumValue() {
		return "IMessage" + "." + getType() + "." + getName();
	}

	public String getType();

	public String getName();
}
