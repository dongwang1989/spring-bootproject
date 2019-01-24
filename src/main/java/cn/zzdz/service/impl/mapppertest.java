package cn.zzdz.service.impl;

import cn.zzdz.Convert.ConverterUtil;
import cn.zzdz.domain.User;
import cn.zzdz.dto.UserDto;
import cn.zzdz.mapper.IUserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class mapppertest {

    @Resource
    private IUserMapper usertd;
    public void finduserbypage(){
        System.out.println("name:"+usertd.finduserbypage().getName());
        User uu= usertd.finduserbypage();
        System.out.println("namee/:;"+uu.getName());
//        for (User u:uu){
//            UserDto dto=null;
//            ConverterUtil.transalte(u,dto);
//            System.out.println("age"+dto.getAge());
//        }


    }
    public void adduser(){};

}
