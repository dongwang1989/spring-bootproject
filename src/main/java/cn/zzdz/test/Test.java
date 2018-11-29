package cn.zzdz.test;

import cn.zzdz.interfaces.enummessage.IMessage;

public  class Test implements IMessage  {
    private String name;

    public  Test(String name){
        this.name=name;
    }
    @Override
    public String getInfo(String... param) {
        return getMessage(name);
    }
}
