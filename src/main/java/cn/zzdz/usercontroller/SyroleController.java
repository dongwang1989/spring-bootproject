package cn.zzdz.usercontroller;

import cn.zzdz.annotation.IDelRolePermion;
import cn.zzdz.annotation.IDelUserRplePermion;
import cn.zzdz.annotation.IDelUseridRole;
import cn.zzdz.domain.Syrole;
import cn.zzdz.domain.SysDept;
import cn.zzdz.domain.SysRole;
import cn.zzdz.domain.SysUser;
import cn.zzdz.interfaces.service.ISyrole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Api(tags ="角色相关操作")
@RequestMapping("/role")
public class SyroleController {
    @Autowired
    private ISyrole syole;

    @ApiOperation(value = "新增角色", notes = "新增角色信息")
    //@ApiImplicitParams({
    @ApiImplicitParam(name = "syolea", value = "角色实体syole", required = true, dataType = "Syrole")
    //})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@Validated @RequestBody Syrole syolea) {

        syole.add(syolea);
    }
    @IDelRolePermion
    @ApiOperation(value = "更改角色信息", notes = "更改角色信息")
    @ApiImplicitParam(name = "syolea", value = "角色实体syole", required = true, dataType = "Syrole")
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    public void updatesyole(@Validated @RequestBody Syrole syolea) {
        syole.add(syolea);
    }



    @IDelRolePermion
    @IDelUserRplePermion("UserRoleAll")
    @ApiOperation(value = "删除角色信息", notes = "删除角色信息")
    @ApiImplicitParam(name = "id", value = "id",paramType = "query", required = true, dataType = "int")
    @RequestMapping(value = "/del",method=RequestMethod.DELETE)
    public void del(@Min(value = 1) Integer id) {
        System.out.println("id:"+id);
        syole.del(id);
    }
    @ApiOperation(value = "获取权限", notes = "获取权限信息")
    @ApiImplicitParam(name = "syolea", value = "角色实体syole", required = true, dataType = "Syrole")
    @RequestMapping(value = "/rolepermion", method = RequestMethod.POST)
    public void getrolepermion(@Validated @RequestBody Syrole syolea) {
        syole.add(syolea);
    }
    @ApiOperation(value = "查询角色列表", notes = "查询角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rolename", value = "rolename", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pagesize", value = "每夜条数多",paramType = "query", required = true, dataType = "int")
    })
    @RequestMapping(value = "/getRoleList",method =RequestMethod.GET )
    public List<Syrole> getUsrList(@Min(1) Integer pageIndex, @Min(1) Integer pagesize, String  rolename) {
        return syole.getUserByrolename(rolename, pageIndex, pagesize);
    }
    @ApiOperation(value = "角色详细信息", notes = "角色详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleid", value = "roleid", paramType = "query", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/getRole",method =RequestMethod.GET )
    public Syrole getUsr(@Min(1) Integer roleid) {
        return syole.getRoleByid(roleid);
    }
}
