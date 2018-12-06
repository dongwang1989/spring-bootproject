package cn.zzdz.enums;

import cn.zzdz.interfaces.enummessage.IMessage;

public enum ButtonMessage implements IMessage {
    BUTTON_PASSWORD("kmnyk","","");
    private   ButtonMessage(String bh,String nk,String ui){

    }



    @Override
    public String getName() {
        return name();
    }
}
