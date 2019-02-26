package cn.zzdz.constant;

import java.util.HashMap;
import java.util.Map;

public class UserAttributeCor {

    public static Map<Object,Object> met(){
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("User.id","UserDto.id");
        map.put("User.age","UserDto.age");
        map.put("User.sex","UserDto.sex");
        map.put("User.name","UserDto.name");
        map.put("User.username","UserDto.username");
        map.put("User.pwd","UserDto.pwd");
        map.put("User.permission","UserDto.permission");
        map.put("User.userstatus","UserDto.userstatus");
        return  map;
    }
}
