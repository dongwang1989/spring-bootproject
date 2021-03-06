package cn.zzdz.service.impl;

import cn.zzdz.dao.UserJpaRepository;
import cn.zzdz.domain.User;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;
import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.error.EnumError;
import cn.zzdz.error.Error;
import cn.zzdz.interfaces.service.IUserService;
import cn.zzdz.mapper.IUserMapper;
import cn.zzdz.redismap.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Resource
    private IUserMapper mapper;
    @Resource
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public ResultDto saveUser(UserDto userDto) {
        ResultDto resultDto = new ResultDto();
        if (userJpaRepository.findUserinfoBylog(userDto.getUsername()) == null) {
            User user = new User();
            user.setAge(userDto.getAge());
            user.setName(userDto.getName());
            user.setUsername(user.getUsername());
            user.setSex(user.getSex());
            user.setPwd(user.getPwd());
            try {
                User us = userJpaRepository.save(user);
                System.out.println(us);
                resultDto.setResult("1");
            } catch (Exception e) {
                resultDto.setResult("0");
            }
        } else {
            resultDto.setResult("-1");
        }
        return resultDto;
    }
    @Override
    public ResultDto login(String username, String pwd, Cookie cook) {
        ResultDto resultDto = new ResultDto();
        Object userid = redisUtils.get(cook.getValue());//redisTemplate.opsForValue().get(cook.getValue());
        if (userid != null && !userid.equals("")) {
            resultDto.setResult("当前账号已经登陆！"+cook.getValue());
        } else {
            User user = userJpaRepository.getUser(username, pwd);
            if (user != null) {
                resultDto.setResult("登陆成功"+cook.getValue());
                Integer h=user.getId();
                redisUtils.set(cook.getValue(),h.toString(),1);
                //redisTemplate.opsForValue().set(cook.getValue(),user.getId(),1, TimeUnit.HOURS);
            } else {
                throw new Error(ErrorMessage.INCORRECT_PASSWORD, user.getUsername());
            }
        }
        return resultDto;
    }

    @Override
    public ResultDto getUser(UserDto userDtolog, HttpSession session) {
        ResultDto resultDto = new ResultDto();
        Object userid = redisTemplate.opsForValue().get(session.getId());
        //String sessionIdValue = session.getAttribute(session.getId()).toString();
        if (userid != null && !userid.equals("")) {
            resultDto.setResult("当前账号已经登陆！");
        } else {
            User user = userJpaRepository.getUser(userDtolog.getUsername(), userDtolog.getPwd());
            if (user != null) {
                resultDto.setResult("登陆成功");

//                redisTemplate.opsForValue().set(session.getId(),userid,1, TimeUnit.HOURS);
//                Set<String> setLit = user.getPermission();
//                if (setLit.size() > 0) {
//                    redisTemplate.opsForSet().add(userid,setLit);
//                    redisTemplate.expire(userid,1,TimeUnit.HOURS);
//                }
            } else {
                throw new Error(ErrorMessage.INCORRECT_PASSWORD, user.getUsername());
            }

        }
        return resultDto;
    }


    @Override
    @Cacheable(value = "permion", key = "#id")
    public Set<String> getPermions(String id) {
        System.out.println("///");
        Map<String,Object> map=new HashMap<>();
        map.put("userid",id);

        Set<String> perset = mapper.getper(map);
        System.out.println("ddaaa:"+perset.size());
        return perset;
    }
    @Override
    public void ddd() {
        UserDto userDto = new UserDto();
        User user = userJpaRepository.findUserInfoByuser("zhangsan");
        System.out.println(user.getUserstatus().toString());
        //System.out.println(user.getUserstatus().getMessage());
    }

    @Override
    public User test() {
        User user = new User();
        user.setName("zhangsan");
        user.setUsername("努力");
        return user;
        //userService.test(user);

    }

    @Override
    public UserDto findUserInfoByuser(String username) {
        UserDto userDto = new UserDto();
        String usernamea = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userJpaRepository.findUserInfoByuser(usernamea);

        System.out.println(user.getSex());
        if (user != null) {
            userDto.setName(user.getName());
            userDto.setAge(user.getAge());
            userDto.setSex(user.getSex());
            userDto.setUsername(user.getUsername());
            userDto.setPwd("***");
        }
        return userDto;
    }

    @Transactional
    @Override
    public int delUserInfo(int id) {
        return userJpaRepository.delUserInfo(id);
    }

    @Override
    public ResultDto logout(HttpSession session) {
        ResultDto resultDto = new ResultDto();
        session.removeAttribute("username");
        resultDto.setResult("退出登录！");
        return resultDto;
    }

    @Override
    public ResultDto sayHello() {
        ResultDto resultDto = new ResultDto();
        resultDto.setResult("Hello World");
        return resultDto;
    }

    @Override
    public ResultDto getHello(String param) {
        ResultDto resultDto = new ResultDto();
        resultDto.setResult(param);
        return resultDto;
    }

    @Override
    public User findUserPermission(Integer id) {
        User user = userJpaRepository.findUserPermission(id);
        return user;
    }

    @Override
    @javax.transaction.Transactional
    public Set<String> cafindUserInfoByuser(String username) {
        System.out.println("cafindUserInfoByuser");
        User user = new User();
        Set<String> set = new HashSet<>();
        user = userJpaRepository.findUserinfoBylog(username);
        set = user.getPermission();
        return set;
    }

    @Override
    public List<User> Likenames(String username) {
        @SuppressWarnings("deprecation")
        Pageable pageable = new PageRequest(0, 1);
        Page<User> page = userJpaRepository.findRoomUidsByUserIdPageable(username, pageable);
        List<User> roomUids = page.getContent();
        return roomUids;// userJpaRepository.Likenames(username);
    }

    @Override
    public String denglu(String username, String pwd, HttpSession session) {
        String val = "0";
        List<User> listuser = userJpaRepository.denglu(username, pwd);
        if (listuser.size() >= 1) {
            session.setAttribute("username", listuser.get(0).getUsername());
            val = "1";
        } else {
            throw new EnumError(ErrorMessage.INCORRECT_PASSWORD, username);
        }
        return val;
    }

    @Override
    public void finduserbypage(UserDto userDto) {
        List<User> list = userJpaRepository.findAll();
        for (User u : list) {
            Set<String> set = new HashSet<>();
            System.out.println(u.getName());
            set = u.getPermission();
            for (String h : set) {
                System.out.println("chang" + h);
            }
        }
    }

}
