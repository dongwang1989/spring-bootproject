package cn.zzdz.usercontroller;

import cn.zzdz.annotation.IReturnEntityColum;
import cn.zzdz.domain.User;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;
import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.enums.UserType;
import cn.zzdz.error.EnumError;
import cn.zzdz.error.Error;
import cn.zzdz.interfaces.service.IUserService;
import cn.zzdz.permission.IPermission;
import cn.zzdz.service.impl.UserServiceImpl;
import cn.zzdz.service.impl.mapppertest;
import cn.zzdz.test.Test;
import cn.zzdz.valid.interfaces.Add;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RestController
public class UserController {
    @Autowired // 如果用set方法加AutoWired那么他会自动给你把这个对象调用的地方都改过来。
    private IUserService userService;

     @Autowired
     private mapppertest hhh;

    @PostMapping("/login") // (value="/login", method = RequestMethod.POST, consumes = "application/json")
    public ResultDto log(@RequestBody UserDto userdtolog, HttpSession session) {
        System.out.println("12");
        return userService.getUser(userdtolog, session);
    }

    @RequestMapping("/denglu")
    public String denglu( @RequestParam String username, @RequestParam String pwd, HttpSession session) {
        System.out.println(username);
        return userService.denglu(username, pwd, session);
    }

    @RequestMapping("/user")
    public UserDto getUser(@RequestParam String username) {
        return userService.findUserInfoByuser(username);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultDto register(@RequestBody UserDto userdto) {
        return userService.saveUser(userdto);
    }

    // 修改用户信息
    @RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
    public ResultDto updateuser(@RequestBody UserDto userdto) {
        return userService.saveUser(userdto);
    }

    @RequestMapping("/loginout")
    public ResultDto logout(HttpSession session) {
        return userService.logout(session);
    }

    @IPermission("who")
    @RequestMapping("/whoim")
    public String whoIm() {
        System.out.println("进入whoim");
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @RequestMapping("/whoim2")
    public Set<String> whoIm2(HttpSession session) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("dsf:" + df.toString());
        // Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        // System.out.println(md5.encodePassword("123", "wd"));
        Set<String> set = new HashSet<>();
        set = userService.cafindUserInfoByuser("zhangsan");
        session.setAttribute("username", "zhangsan");
        return set;
    }

    @IPermission("hello")
    @RequestMapping("/hello")
    public ResultDto sayHello() {
        return userService.sayHello();
    }

    @IPermission("hello2")
    @RequestMapping("/hello/{param}")
    public ResultDto getHello(@PathVariable String param) {
        return userService.getHello(param);
    }

    @Resource
    private MessageSource messageSource;

    @RequestMapping("/exception/checked")
    public void checkedException(HttpServletRequest httpServletRequest) throws Exception {
        throw new Error(ErrorMessage.INCORRECT_PASSWORD);
    }

    @RequestMapping("/ha")
    public List<User> ha(@RequestParam String username) {
        return userService.Likenames(username);
    }

    @RequestMapping("/exception/runtime")
    public void runtimeException() {
        //throw new Error(ErrorMessage.NOTCONTROLLER_MESSAGEB);
    }

    @Value("${args.environment}")
    private String environment;

    @GetMapping("/GET/environment")
    public String getenvironment() {
        return environment;
    }


    @GetMapping("/test/throwerror")
    public void getaa() throws Exception {
        throw new EnumError(ErrorMessage.INCORRECT_PASSWORD, "ad");
    }

    @GetMapping("/test/throwerror2")
    public void getab() {
        System.out.println(ErrorMessage.INCORRECT_PASSWORD.getMessage());
    }

    @GetMapping("/test/throwerror3")
    public String getac() {
        return new Test("NAME").getMessage();
    }

    @GetMapping("/test/throwerror5")
    public void getae() {
        System.out.println(UserType.ADMIN.getMessage());
    }
    @RequestMapping("/test/hib")
    public void hib() {
         userService.ddd();
    }
    @GetMapping("test/validate1")
    @ResponseBody
    public String validate1(

            @Size(min = 1,max = 10,message = "姓名长度必须为1到10")@RequestParam("name") String name,
            @Min(value = 10,message = "年龄最小为10")@Max(value = 100,message = "年龄最大为100") @RequestParam("age") Integer age//,
            //@Future @RequestParam("birth")@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") Date birth
            ){
        return "validate1";
    }
    @RequestMapping("test/finduserbypage")
    public void   finduserbypage(){
        UserDto userdto = new UserDto();
        userdto.setSex("1");
        //UserServiceImpl h = new UserServiceImpl();
        //User user=new User();
//        user.setPageIndex(1);
//        user.setPageSize(10);
        userService.finduserbypage(userdto);
    }
    @RequestMapping("test/22")
    public @Validated(value={Add.class})User   test22(){
        User user = userService.test();
        return user;
    }

    @RequestMapping("/test/33")
    @IReturnEntityColum(clazz = User.class,value = {"id","name"})
    public   User test33(){
        User user=new User();
        user.setId(1);
        user.setName("张三");
        user.setSex("难");
        return user;
    }


}
