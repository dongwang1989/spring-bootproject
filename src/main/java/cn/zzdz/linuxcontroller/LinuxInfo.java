package cn.zzdz.linuxcontroller;

import cn.zzdz.domain.SysUser;
import cn.zzdz.interfaces.service.ILinux;
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

@RestController
@Api(tags = "获取Linux信息相关操作")
@RequestMapping("/linux")
public class LinuxInfo {
    @Autowired
    private ILinux iLinux;
    @ApiOperation(value = "获取内存信息", notes = "内存使用率")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ip", value = "ip", paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/getMemory", method = RequestMethod.GET)
    public String getMemory(String ip) {
        iLinux.getMemory(ip);
        return iLinux.getMemory(ip);
    }
    @ApiOperation(value = "获取容器信息", notes = "容器信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ip", value = "ip", paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/getContainers", method = RequestMethod.GET)
    public String getContainers(String ip) {

        return iLinux.getContainers(ip);
    }
    @ApiOperation(value = "获取硬盘信息", notes = "硬盘信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ip", value = "ip", paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/getDev", method = RequestMethod.GET)
    public String getDev(String ip) {

        return iLinux.getDev(ip);
    }
}
