package cn.zzdz.repository;

import cn.zzdz.interfaces.service.ILogin;
import cn.zzdz.interfaces.service.IUserService;
import cn.zzdz.redismap.RedisUtils;
import cn.zzdz.service.impl.AuthorityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.lang.String;

public class ContentRepository implements SecurityContextRepository {

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private ILogin yonghu;

    @Override
    @Transactional
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        //HttpSession session = requestResponseHolder.getRequest().getSession();
        Cookie cook=null ;
        Object userid;
        for (Cookie c : requestResponseHolder.getRequest().getCookies()) {
            if (c.getName().equals("access_token")) {
                cook = c;
            }
        }
        SecurityContext getcontext;
        if (cook!=null){
            userid=redisTemplate.opsForValue().get(cook.getValue());
            if(userid!=null&&!userid.toString().equals("")){
                /*每次访问借口增加访问时长*/
                String access_token=cook.getValue();
                redisUtils.set(access_token, userid.toString(), 1);
                //redisTemplate.opsForValue().set(access_token, userid.toString(), 1);
                //String userid =redisTemplate.opsForValue().get(cook.getValue()).toString();
                //Set<String> set = userService.getPermions(userid.toString());
                Set<String> set = yonghu.getPermions(Integer.parseInt(userid.toString()));//获取权限
                System.out.println("123");

                //Set<Object> set =redisTemplate.opsForSet().members(userid);
                /* Set<String> set = redisTemplate//userService.cafindUserInfoByuser(username); */
                Set<AuthorityImpl> permissions = new HashSet<>();
                if (set != null) {
                    permissions = set.stream().map(auth -> new AuthorityImpl(auth))
                            .collect(Collectors.toSet());
                }
                getcontext = generateNewContext();
                getcontext.setAuthentication(
                        new UsernamePasswordAuthenticationToken(access_token, "", permissions));
            }//session.getAttribute(cook.getValue())
            else {
                getcontext = generateNewContext();
            }
        }
        else {
            getcontext = generateNewContext();
        }
        return getcontext;
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        return true;
    }

    protected SecurityContext generateNewContext() {
        return SecurityContextHolder.createEmptyContext();
    }
}
