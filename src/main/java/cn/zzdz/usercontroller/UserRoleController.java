package cn.zzdz.usercontroller;

import cn.zzdz.domain.SysUser;
import cn.zzdz.domain.Userrole;
import cn.zzdz.interfaces.service.IUserRole;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户角色相关操作")
@RequestMapping("/userrole")
public class UserRoleController {
    @Autowired
    private IUserRole userRole;

    @ApiOperation(value = "新增用户角色", notes = "新增用户角色信息")
    @ApiImplicitParam(name = "userid", value = "用户id", required = true, dataType = "int")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(Integer userid, @RequestParam(value = "listrole") @ApiParam(value = "可被访问的roleid列表") List<Integer> listrole) {
        //del cache
        userRole.delroleset(userid);
        userRole.add(userid,listrole);
    }
    @ApiOperation(value = "删除用户角色", notes = "删除用户角色信息")
    @ApiImplicitParam(name = "userid", value = "用户id", required = true, dataType = "int")
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void delByUserid(Integer userid){
        //del cache
        userRole.delroleset(userid);
        userRole.delByUserid(userid);
    }


}
