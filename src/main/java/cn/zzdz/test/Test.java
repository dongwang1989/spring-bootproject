package cn.zzdz.test;

import cn.zzdz.interfaces.enummessage.IMessage;

public class Test implements IMessage {
    private final String name;

    public Test(final String name) {
        this.name = getType() + "." + name;
    }



    @Override
    public String getName() {
        return name;
    }
}
