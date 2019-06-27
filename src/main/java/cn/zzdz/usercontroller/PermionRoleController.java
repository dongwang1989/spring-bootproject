package cn.zzdz.usercontroller;

import cn.zzdz.domain.Permionrole;
import cn.zzdz.domain.Permionrole;
import cn.zzdz.interfaces.service.IDep;
import cn.zzdz.interfaces.service.IPermionRole;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Api("角色的权限相关操作")
@RequestMapping("/perole")
public class PermionRoleController {
    @Autowired
    private IPermionRole permionRole;

    @ApiOperation(value = "新增角色权限", notes = "新增角色权限信息")
    //@ApiImplicitParams({
    //@ApiImplicitParam(name = "listpermion", value = "角色权限实体dep", required = true, dataType = "query"),
    @ApiImplicitParam(name = "roleid", value = "角色id", paramType = "query",required = true, dataType = "int")
    //})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add( Integer roleid,@RequestParam(value = "listpermion") @ApiParam(value = "可被访问的clientId列表") List<String> listpermion) {
        //del cache
        permionRole.deluserpermion(roleid);

        permionRole.add(roleid,listpermion);
    }

//    @ApiOperation(value = "更改角色权限信息", notes = "更改角色权限信息")
//    @ApiImplicitParam(name = "pra", value = "角色权限实体dep", required = true, dataType = "Permionrole")
//    @RequestMapping(value = "/up", method = RequestMethod.POST)
//    public void updatedep(@Validated @RequestBody Permionrole pra) {
//        permionRole.add(pra);
//    }

    @ApiOperation(value = "删除角色权限信息", notes = "删除角色权限信息")
    @ApiImplicitParam(name = "id", value = "角色权限实体dep",paramType = "query", required = true, dataType = "int")
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    public void del(@Min(value = 1) Integer id) {
        permionRole.delall(id);
    }
}
