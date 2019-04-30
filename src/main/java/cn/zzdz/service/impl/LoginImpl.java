package cn.zzdz.service.impl;

import cn.zzdz.dao.LoginJpa;
import cn.zzdz.domain.SysUser;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.error.Error;
import cn.zzdz.interfaces.service.ILogin;
import cn.zzdz.mapper.IUserMapper;
import cn.zzdz.redismap.RedisUtils;
import cn.zzdz.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.util.List;
import java.util.UUID;

@Service
public class LoginImpl implements ILogin {

    @Autowired
    private LoginJpa userJpaRepository;
    @Resource
    private IUserMapper mapper;
    @Resource
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public ResultDto login(String username, String pwd, Cookie cook) {
        ResultDto resultDto = new ResultDto();
//        Object userid = redisUtils.get(cook.getValue());
//        if (userid != null && !userid.equals("")) {
//            resultDto.setResult("当前账号已经登陆！"+cook.getValue());
//        } else {
        Cookie cookie = new Cookie("access_token", UUID.randomUUID().toString());
        cookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
        String newpwd = MD5Util.encrypt(pwd);
        System.out.println("newpwd//:" + newpwd);

        SysUser user = userJpaRepository.getUser(username, newpwd);
        if (user != null) {
            resultDto.setResult("登陆成功" + cook.getValue());
            Integer h = user.getUserId();
            clearc(cook);
            redisUtils.set(cook.getValue(), h.toString(), 1);
        } else {
            throw new Error(ErrorMessage.INCORRECT_PASSWORD, user.getUsername());
        }
        //}
        return resultDto;
    }

    public Cookie cleark() {
        Cookie ncookie = new Cookie("access_token", null);//重新设置cook
        ncookie.setMaxAge(0); //立即删除型
        ncookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
        return  ncookie;
    }

    @Override
    public Cookie loginOut(Cookie cookie) {
        Cookie ncookie = cleark();
        try {
            clearc(cookie);
        } catch (Exception ex) {
            throw new Error(ErrorMessage.FAIL_OUT, "");
        }
        return ncookie;
    }

    public void clearc(Cookie cookie) {
        Object userid = redisUtils.get(cookie.getValue());
        if (userid != null && userid.toString() != "") {
            redisUtils.delete(userid.toString());//del权限
            redisUtils.delete(cookie.getValue());//del用户userid
        }
    }


    @Override
    public Cookie te(String username, String pwd, Cookie cook) {
        String newpwd = MD5Util.encrypt(pwd);
        SysUser user = userJpaRepository.getUser(username, newpwd);
        Cookie cookie;
        if (user != null) {
            if (cook != null) {
                clearc(cook);//清除缓存数
            }
            cookie = new Cookie("access_token", UUID.randomUUID().toString());//重新设置cook
            cookie.setPath("/"); //项目所有目录均有效，这句很关键
            Integer h = user.getUserId();
            redisUtils.set(cookie.getValue(), h.toString(), 1);
        } else {
            throw new Error(ErrorMessage.INCORRECT_PASSWORD, username);
        }
        return cookie;
    }

    @Override
    public void add(SysUser user) {
        System.out.println("kkk"+user.getUsername());
        userJpaRepository.save(user);
    }

    @Override
    public List<SysUser> getUserByusername(String username) {
        List<SysUser> list=userJpaRepository.getUserByusername(username);
        return list;
    }
}
