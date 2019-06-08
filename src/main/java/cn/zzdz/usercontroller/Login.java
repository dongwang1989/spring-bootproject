package cn.zzdz.usercontroller;

import cn.zzdz.dto.ResultDto;
import cn.zzdz.interfaces.service.ILogin;
import cn.zzdz.interfaces.service.IUserService;
import cn.zzdz.service.impl.LoginImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@Api(tags = "登陆相关操作")
@RequestMapping("/logind")
public class Login {
    @Autowired
    private ILogin userService;

    @ApiOperation(value = "登陆", httpMethod = "GET", notes = "根据传过来的用户名和密码查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(String username, String pwd, HttpServletResponse response) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        Cookie cook = null;
        if(cookies!=null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("access_token")) {
                    cook = c;
                }
            }
        }
        Cookie cookie= userService.te(username, pwd, cook);
        response.addCookie(cookie);
    }
    @ApiOperation(value = "获取用户权限", httpMethod = "GET", notes = "获取用户权限")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int")
    @RequestMapping(value = "/getUserPermion", method = RequestMethod.GET)
    public Set<String> getUserPermion(Integer userId){
       Set<String> lPermion= userService.getPermions(userId);
       return  lPermion;
    }

    @ApiOperation(value = "登出", httpMethod = "GET", notes = "根据传过来的用户名和密码查询")
    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public void loginout(HttpServletResponse response) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        Cookie cook = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("access_token")) {
                cook = c;
            }
        }
        Cookie cookie= userService.loginOut(cook);
        response.addCookie(cookie);
    }

}
