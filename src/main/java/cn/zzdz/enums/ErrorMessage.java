package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.INotifyMessage;

//@Component
//@ConfigurationProperties(prefix = "ErrorMessage")
public enum ErrorMessage implements INotifyMessage {
	INCORRECT_PASSWORD,POWER_NOTENOUGH,NOTCONTROLLER_MESSAGEB;

//	private String msg;
//	public String getMsg() {
//		MyLocaleResolver locale =new MyLocaleResolver();
//		String dd=locale.getMessage(msg);
//		System.out.println("dwdewd:"+dd);
//		return locale.getMessage(msg);
//	}
//
//
//	ErrorMessage(String msg){
//		System.out.println("jj:"+msg);
//		this.msg=msg;
//
//	}
	@Override
	public String getType() {
		return "ErrorMessage"+ "." + this.name();
		//return typ + "." + "ErrorMessage";
	}

	@Override
	public String getName() {
		return "ErrorMessage."+this.name();
	}

}
