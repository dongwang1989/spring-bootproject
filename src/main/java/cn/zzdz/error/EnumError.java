package cn.zzdz.error;


import cn.zzdz.interfaces.enummessage.IMessage;

public class EnumError extends RuntimeException {


    private static final long serialVersionUID = 1L;
    private String values;

    public EnumError(IMessage iMessage, final String... param) {
          values =CommonEnumTran.getMessage(iMessage,param);
    }

    @Override
    public String getMessage() {
        return values;
    }
}
