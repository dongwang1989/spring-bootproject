package cn.zzdz.usercontroller;

import cn.zzdz.domain.SysDept;
import cn.zzdz.domain.SysDept;
import cn.zzdz.domain.SysUser;
import cn.zzdz.interfaces.service.IDep;
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
@Api(tags = "部门相关操作")
@RequestMapping("/depart")
public class DepController {
    @Autowired
    private IDep dep;

    @ApiOperation(value = "新增部门", notes = "新增部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "depa", value = "部门实体dep", required = true, dataType = "SysDept")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@Validated @RequestBody SysDept depa) {
        dep.add(depa);
    }

    @ApiOperation(value = "更改部门信息", notes = "更改部门信息")
    @ApiImplicitParam(name = "depa", value = "部门实体dep", required = true, dataType = "SysDept")
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    public void updatedep(@Validated @RequestBody SysDept depa) {
        dep.add(depa);
    }

    @ApiOperation(value = "删除部门信息", notes = "删除部门信息")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query",required = true, dataType = "int")
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    public void del(@Min(value = 1) Integer id) {
        dep.del(id);
    }
    @ApiOperation(value = "查询具体的部门信息", notes = "查询具体的部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "depid", value = "depid", paramType = "query", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/getDep",method =RequestMethod.GET )
    public SysDept getUsr(@Min(1) Integer depid) {
        return dep.getDepByid(depid);
    }
    @ApiOperation(value = "查询部门列表", notes = "查询部门列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pagesize", value = "每夜条数多",paramType = "query", required = true, dataType = "int")
    })
    @RequestMapping(value = "/getDepList",method =RequestMethod.GET )
    public List<SysDept> getUsrList(@Min(1) Integer pageIndex, @Min(1) Integer pagesize, String  name) {
        return dep.getDepList(name, pageIndex, pagesize);
    }
}
