package cn.zzdz.usercontroller;

import cn.zzdz.annotation.IDelRolePermion;
import cn.zzdz.annotation.IDelUserRplePermion;
import cn.zzdz.domain.Permion;
import cn.zzdz.domain.Permion;
import cn.zzdz.interfaces.service.IDep;
import cn.zzdz.interfaces.service.Ipermion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@RestController
@Api(tags ="权限相关操作")
@RequestMapping("/permion")
public class PermionController {
    @Autowired
    private Ipermion per;

    @ApiOperation(value = "新增权限", notes = "新增权限信息")
    //@ApiImplicitParams({
    @ApiImplicitParam(name = "pera", value = "权限实体per", required = true, dataType = "Permion")
    //})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@Validated @RequestBody Permion pera) {

        per.add(pera);
    }

    @IDelUserRplePermion("RolePerAll")
    @ApiOperation(value = "更改权限信息", notes = "更改权限信息")
    @ApiImplicitParam(name = "pera", value = "权限实体per", required = true, dataType = "Permion")
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    public void updateper(@Validated @RequestBody Permion pera) {
        per.add(pera);
    }

    @IDelUserRplePermion("CacheAll")
    @ApiOperation(value = "删除权限信息", notes = "删除权限信息")
    @ApiImplicitParam(name = "id", value = "id",paramType = "query", required = true, dataType = "int")
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    public void del(@Min(value = 1) Integer id) {
        per.del(id);
    }


}
