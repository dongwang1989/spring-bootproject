package cn.zzdz.usercontroller;

import cn.zzdz.domain.SysUser;
import cn.zzdz.domain.User;
import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.error.Error;
import cn.zzdz.interfaces.service.ILogin;
import cn.zzdz.valid.interfaces.Add;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController
@Api("用户相关操作")
@RequestMapping("/userdd")
public class UerController {
    @Autowired
    private ILogin userService2;

    @ApiOperation(value = "新增用户", notes = "新增用户信息")
    //@ApiImplicitParams({
    @ApiImplicitParam(name = "usera", value = "用户实体user", required = true, dataType = "SysUser")
    //})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@Validated @RequestBody  SysUser usera) {

            userService2.add(usera);
    }
    @ApiOperation(value = "hjb", notes = "新增用户信息")
    //@ApiImplicitParams({
    @ApiImplicitParam(name = "usera", value = "用户实体user", required = true, dataType = "User")
    //})
    @RequestMapping(value = "/add2", method = RequestMethod.POST)
    public void add2(@Validated @RequestBody User usera) {

        //userService2.add(usera);
    }

    @RequestMapping(value = "/add3")
    public String add3(@Min(value = 200) @RequestParam("name") long name) {
        System.out.println("bjbcdskj");
        return  "qwe";
    }
}
