package cn.zzdz.usercontroller;

import cn.zzdz.dto.ResultDto;
import cn.zzdz.interfaces.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RestController
@Api("用户相关操作")
@RequestMapping("/tet")
public class Tet {
    @Autowired
    private IUserService userService;
    @ApiOperation(value = "登陆",httpMethod = "get",notes = "根据传过来的用户名和密码查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String",paramType = "query")
    })
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResultDto login(String username,  String pwd) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie [] cookies = request.getCookies();
        Cookie cook=null;
        for (Cookie c:cookies) {
            if(c.getName().equals("JSESSIONID")) {
                cook=c;
            }
        }
        return userService.login(username, pwd, cook);
    }
    @RequestMapping("/c")
    public void gec(String id){
        System.out.println(id);
    }
    @RequestMapping("/cc")
    @CacheEvict(value="producta",key="#id")// 清空accountCache 缓存
    public void getrel(String id){
        System.out.println("cc");
    }



}
