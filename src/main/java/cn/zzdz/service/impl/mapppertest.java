package cn.zzdz.service.impl;

import cn.zzdz.Convert.ConverterUtil;
import cn.zzdz.domain.User;
import cn.zzdz.dto.UserDto;
import cn.zzdz.mapper.IUserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void  cha(){
        Map<String,Object> ma=new HashMap<>();
        ma.put("skzc","1-10周上");

//        1-11周上
//        1-12周上
//        1-13周上
//        1-14周上
//        1-15周上
//        1-16周上
//        1-17周上
//        1-18周上
//        1-19周
//        1-19周上
        List<Map<String,Object>> list=usertd.cha(ma);
        for (int i = 0; i <list.size(); i++) {

            Map<String,Object> ma2=new HashMap<>();
            ma2.put("xn",list.get(i).get("xn"));
            ma2.put("xqh",list.get(i).get("xqh"));
            ma2.put("jxlh",list.get(i).get("jxlh"));
            ma2.put("jash",list.get(i).get("jash"));
            ma2.put("zj",list.get(i).get("skxq"));
            ma2.put("kch",list.get(i).get("KCH"));
            ma2.put("kcm",list.get(i).get("KCM"));
            ma2.put("kxh",list.get(i).get("KXH"));
            ma2.put("skjc",list.get(i).get("skjc"));
            ma2.put("cxjc",list.get(i).get("cxjc"));
            ma2.put("skzc",list.get(i).get("skzc"));
            for (int j = 0; j < 10; j++) {
                int kk=j+1;
                ma2.put("djz",String.valueOf(kk));
                usertd.adkcb(ma2);
            }
//            for (int c = 16; c < 20; c++) {
//                int kk=c;
//                ma2.put("djz",String.valueOf(kk));
//                usertd.adkcb(ma2);
//            }

        }
    }

}
