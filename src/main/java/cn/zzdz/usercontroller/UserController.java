package cn.zzdz.usercontroller;

import cn.zzdz.convert.ConverterUtil;
import cn.zzdz.dao.UserRoleJpa;
import cn.zzdz.domain.SysUser;
import cn.zzdz.domain.User;
import cn.zzdz.domain.User_;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;
import cn.zzdz.enums.DruidIp;
import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.enums.UserStatus;
import cn.zzdz.enums.UserType;
import cn.zzdz.error.EnumError;
import cn.zzdz.error.Error;
import cn.zzdz.hbase.HBaseUtils;
import cn.zzdz.interfaces.service.ILogin;
import cn.zzdz.interfaces.service.IUserService;
import cn.zzdz.permission.IPermission;
import cn.zzdz.rabbitmq.HelloSender;
import cn.zzdz.test.Test;
import cn.zzdz.valid.interfaces.Add;
import io.swagger.annotations.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RestController
//@Api(tags = "swaggerTestController相关api")
public class UserController {
    @Autowired // 如果用set方法加AutoWired那么他会自动给你把这个对象调用的地方都改过来。
    private IUserService userService;


    @RequestMapping("/login2") // (value="/login", method = RequestMethod.POST, consumes = "application/json")
    public ResultDto log(@RequestParam String username, @RequestParam String pwd) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        Cookie cook = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("JSESSIONID")) {
                cook = c;
            }
        }
        return userService.login(username, pwd, cook);
    }

    @PostMapping("/login") // (value="/login", method = RequestMethod.POST, consumes = "application/json")
    public ResultDto log(@RequestBody UserDto userdtolog, HttpSession session) {
        System.out.println("12");
        return userService.getUser(userdtolog, session);
    }


    @RequestMapping("/denglu")
    public String denglu(@RequestParam String username, @RequestParam String pwd, HttpSession session) {
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
            @Size(min = 1, max = 10, message = "姓名长度必须为1到10") @RequestParam("name") String name,
            @Min(value = 10, message = "年龄最小为10") @Max(value = 100, message = "年龄最大为100") @RequestParam("age") Integer age//,
    ) {
        return "validate1";
    }

    @RequestMapping("test/finduserbypage")
    public void finduserbypage() {
        UserDto userdto = new UserDto();
        userdto.setSex("1");
        //UserServiceImpl h = new UserServiceImpl();
        //User user=new User();
//        user.setPageIndex(1);
//        user.setPageSize(10);
        userService.finduserbypage(userdto);
    }

    @RequestMapping("test/22")
    public @Validated(value = {Add.class})
    User test22() {
        User user = userService.test();
        return user;
    }

    @ApiOperation(value = "根据id查询学生的信息", notes = "查询数据库中某个学生的信息")
    @RequestMapping(value = "/test/33")
    //@JsonFieldFilter(type = User.class,exclude = "age")
    //@IReturnEntityColum(clazz = User.class, value = {"id", "name"})
    public User test33() {

        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setSex("难");
        return user;
    }

    @RequestMapping("/test/55")
    public void test55(@Validated(value = {Add.class}) User user) {
        System.out.println(UserStatus.ACTIVE.getMessage());

    }

    @RequestMapping("/test/66")
    public void test66(String pwd) {
        System.out.println("pwd:" + pwd);
    }


    @RequestMapping("/test/77")
    public void test77() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setSex("难");
        UserDto uerdto = new UserDto();
        String[] str = {"id,", "name"};
        ConverterUtil.transalte2(user, uerdto, str);
    }

    public static void readExcel(String excelName) throws IOException {

        //将文件读入
        InputStream in = new FileInputStream(new File("/"));
        //创建工作簿
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取第一个sheet
        Sheet sheet = wb.getSheetAt(0);
        //获取第二行

        //循环读取科目
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {

            Row row = sheet.getRow(i);
            for (int j = 0; j < 6; j++) {
                System.out.println(row.getCell(j));
            }

        }
    }

    @RequestMapping("/test/88")
    public void test88(HttpSession cc) {
        System.out.println("tt:" + cc.getId());
        cc.setAttribute(cc.getId(), "123");
    }

    @Autowired
    private HBaseUtils hBaseUtils;

    @RequestMapping("test/hba")
    public void hba() throws IOException {
        String va = hBaseUtils.selectValue("licy", "rowkey01", "f1", "col1");
        System.out.println("wd:" + va);
    }

    @RequestMapping("/test/99")
    public void test99(HttpSession cc) {
        System.out.println("tt:" + cc.getAttribute("username"));
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/test/ed")
    public void tested() {
        redisTemplate.opsForValue().set("aaa", "wd");
        System.out.println("tt:" + redisTemplate.opsForValue().get("aaa"));
    }

    @RequestMapping("test/00")
    public void test00() {
        System.out.println(User_.id.getName());
    }

    @RequestMapping("test/mn")
    public void testmn(HttpSession ID) {
        System.out.println("wd:" + ID);
    }

    @Autowired
    private HelloSender helloSender;

    @RequestMapping("test/nm")
    public void nm() {
        helloSender.send(1);
    }

    @RequestMapping("test/nm2")
    public void nm2(HttpServletRequest hq) {
        for (Cookie c : hq.getCookies()) {
            System.out.println(c.getName() + ":" + c.getValue());
            System.out.println(hq.getSession().getId());
            int i = 0;

        }
    }
    @Autowired
    private ILogin user;

    @IPermission("sys:aduser")
    @RequestMapping("/aduser")
    public void adUser(@Validated(value = {Add.class}) SysUser user){

    }

}
