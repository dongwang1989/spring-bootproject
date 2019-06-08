package cn.zzdz.usercontroller;

import cn.zzdz.annotation.IDelUseridRole;
import cn.zzdz.domain.SysUser;
import cn.zzdz.interfaces.service.ILogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@RestController
@Api(tags = "用户相关操作")
@RequestMapping("/userdd")
public class UerController {
    @Autowired
    private ILogin userService;

    @ApiOperation(value = "新增用户", notes = "新增用户信息")
    //@ApiImplicitParams({
    @ApiImplicitParam(name = "usera", value = "用户实体user", required = true, dataType = "SysUser")
    //})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@Validated @RequestBody SysUser usera) {
        userService.add(usera);
    }

    @IDelUseridRole
    @ApiOperation(value = "更改用户信息", notes = "更改用户信息")
    @ApiImplicitParam(name = "usera", value = "用户实体user", required = true, dataType = "SysUser")
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    public void updateuser(@Validated @RequestBody SysUser usera) {
        userService.update(usera);
    }


//    @ApiOperation(value = "red", notes = "red")
//    @ApiImplicitParam(name = "id", value = "用户主键id", paramType = "query", required = true, dataType = "int")
//    @RequestMapping(value = "/ww", method = RequestMethod.GET)
//    public void ww(Integer id) {
//        Set<String> se = userService.getPermions(id);
//    }

    //    @ApiOperation(value = "delred", notes = "delred")
//    @ApiImplicitParam(name = "id", value = "用户主键id", paramType = "query", required = true, dataType = "int")
//    @RequestMapping(value = "/ww2", method = RequestMethod.POST)
//    public void ww2(Integer id) {
//        userService.delred(id);
//    }
    @IDelUseridRole("parma")
    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @ApiImplicitParam(name = "id", value = "id",paramType = "query", required = true, dataType = "int")
    @RequestMapping(value = "/del",method=RequestMethod.DELETE)
    public void del(@Min(value = 1) Integer id) {
        userService.del(id);
    }
//
//    @RequestMapping(value = "/tet")
//    public Set<String> te(Integer id) {
//        Set<String> set = userService.getPermions(id);
//        return set;
//    }

    @ApiOperation(value = "查询用户列表", notes = "查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "username", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pagesize", value = "每夜条数多", paramType = "query", required = true, dataType = "int")
    })
    @RequestMapping(value = "/getUsrList", method = RequestMethod.GET)
    public List<SysUser> getUsrList(@Min(1) Integer pageIndex, @Min(1) Integer pagesize, String username) {
        List<SysUser> ler = userService.getUserByusername(username, pageIndex, pagesize);
        return ler;
    }

    @ApiOperation(value = "查询单个用户信息", notes = "查询单个用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "userid", paramType = "query", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public SysUser getUsr(@Min(1) Integer userid) {
        //List<SysUser> ler = userService.getUserByusername(username, pageIndex, pagesize);
        return userService.getUser(userid);
    }


}
