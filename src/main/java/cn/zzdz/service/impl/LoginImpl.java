package cn.zzdz.service.impl;

import cn.zzdz.dao.LoginJpa;
import cn.zzdz.domain.SysUser;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.error.Error;
import cn.zzdz.interfaces.service.ILogin;
import cn.zzdz.interfaces.service.IPermionRole;
import cn.zzdz.interfaces.service.ISyrole;
import cn.zzdz.interfaces.service.IUserRole;
import cn.zzdz.mapper.IUserMapper;
import cn.zzdz.redismap.RedisUtils;
import cn.zzdz.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import javax.servlet.http.Cookie;
import java.util.*;

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
            Integer h = user.getUserid();
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
        return ncookie;
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

    @Autowired
    private IUserRole userRoleervice;

    public void clearc(Cookie cookie) {
        System.out.println("cookie//:" + cookie.getValue());

        Object userid = redisUtils.get(cookie.getValue());
        if (userid != null && userid.toString() != "") {
            //redisUtils.delete(userid.toString());//del权限
            //redisUtils.delete(cookie.getValue());//del用户userid
            userRoleervice.delroleset(Integer.parseInt(userid.toString()));//del user rolelist
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
            Integer h = user.getUserid();
            redisUtils.set(cookie.getValue(), h.toString(), 1);
            String b="";
        } else {
            throw new Error(ErrorMessage.INCORRECT_PASSWORD, username);
        }
        return cookie;
    }

    @Override
    public void add(SysUser user) {
        //判断用户名不能重复
        List<SysUser> liuer = userJpaRepository.getUserByusername(user.getUsername());
        if (liuer != null && liuer.size() > 0) {
            throw new Error(ErrorMessage.REPEATNAME, user.getUsername());
        }
        String newpwd = MD5Util.encrypt(user.getPassword());
        user.setPassword(newpwd);
        userJpaRepository.save(user);
    }
    @Override
    public void update(SysUser user) {
        List<SysUser> liuer = userJpaRepository.getUserByusername(user.getUsername());
        if(liuer==null||liuer.size()<=1){
            String newpwd = MD5Util.encrypt(user.getPassword());
            SysUser yue=getUserByid(user.getUserid());
            if(yue.getPassword()==user.getPassword())
            {
                user.setPassword(yue.getPassword());
            }
            else {
                user.setPassword(newpwd);
            }
            userJpaRepository.save(user);
        }

    }

    @Override
    public void del(int id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public List<SysUser> getUserByusername(String username, Integer pageIndex, Integer pagesize) {
        Sort sort = new Sort(Sort.Direction.ASC, "userid");
        PageRequest pageable = PageRequest.of(pageIndex - 1, pagesize, sort);
        Specification<SysUser> spec = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> listpred = new ArrayList<>();

                Path<String> pusername = root.get("username");
                if (pusername != null && !pusername.equals("")) {
                    Predicate p1 = criteriaBuilder.like(pusername, "%" + username + "%");
                    listpred.add(p1);
                }

                Predicate[] par = new Predicate[listpred.size()];
                Predicate p = criteriaBuilder.and(listpred.toArray(par));
                return p;
            }
        };
        Page<SysUser> page = userJpaRepository.findAll(spec, pageable);

        //return chulis(page);
        //List<SysUser> list = userJpaRepository.getUserByusername(username);
        return page.getContent();
    }

    @Override
    public SysUser getUserByid(Integer id) {
        Optional<SysUser> user = userJpaRepository.findById(id);
        SysUser userre = new SysUser();
        if (user.isPresent()) {
            userre = user.get();
        }
        System.out.println("6768r68");
        return userre;//JpaRepository.findById(id);
    }

    @Autowired
    private ISyrole syple;
    @Autowired
    private IUserRole userroleservice;
    @Autowired
    private IPermionRole permionroleservice;

    //获取个人权限
    @Override
    public Set<String> getPermions(Integer id) {
        Set<String> perset = new HashSet<>();
        Set<String> roleset = userroleservice.getRoleSetByUserid(id);
        if (roleset != null && roleset.size() > 0) {
            for (String i : roleset) {
                Set<String> permionset = permionroleservice.getPermions(Integer.parseInt(i));
                if (permionset != null && permionset.size() > 0) {
                    perset.addAll(permionset);
                }
            }
        }
        System.out.println("*****" + "###");
        return perset;
    }


    @Override
    public SysUser getUser(Integer userid){
       Optional<SysUser> optuser=userJpaRepository.findById(userid);
       SysUser uer=new SysUser();
       if(optuser.isPresent()){
           uer=optuser.get();
       }
       return uer;
    }
    @Override
    @CacheEvict(value = {"permion", "cacheuserrole"}, allEntries = true)
    public void delCacheAll(){
        System.out.println("delete delCacheAll");

    }
    @Override
    @CacheEvict(value = {"cacheuserrole"}, allEntries = true)
    public void delUserRoleAll(){
        System.out.println("delete cacheuserrole");

    }
    @Override
    @CacheEvict(value = {"permion"}, allEntries = true)
    public void delRolePerAll(){
        System.out.println("delete permion");

    }

}
