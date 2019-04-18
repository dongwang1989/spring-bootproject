package cn.zzdz.usercontroller;

import cn.zzdz.dto.ResultDto;
import cn.zzdz.fastfd.FastDFSClient;
import cn.zzdz.interfaces.service.IUserService;
import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//@Service
@RestController
@Api("用户相关操作")
@RequestMapping("/tet")
public class Tet {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private IUserService userService;
    @ApiOperation(value = "登陆",httpMethod = "get",notes = "根据传过来的用户名和密码查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String",paramType = "query")
    })
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResultDto login(String username,  String pwd) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie [] cookies = request.getCookies();
        Cookie cook=null;
        for (Cookie c:cookies) {
            if(c.getName().equals("JSESSIONID")) {
                cook=c;
            }
        }
        return userService.login(username, pwd, cook);
    }


    @ApiOperation(value = "文件上传",httpMethod = "post")
    @PostMapping(value="/uppload",headers = "content-type=multipart/form-data")
    public StorePath test(@RequestParam MultipartFile file) throws IOException {


        // 设置文件信息
        Set<MataData> mataData = new HashSet<>();
        mataData.add(new MataData("author", "zonghui"));
        mataData.add(new MataData("description", "xxx文件，嘿嘿嘿"));

        // 上传   （文件上传可不填文件信息，填入null即可）
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), mataData);
    String url=FastDFSClient.getResAccessUrl( storePath.getFullPath());
    System.out.println("address dizhi:"+url);
        return storePath;
//        String fileUrl = this.getClass().getResource("/test.jpg").getPath();
//        File file = new File(fileUrl);
//        String str = FastDFSClient.uploadFile(file);

    }

    @RequestMapping("/c")
    public void gec(){
       boolean a= FastDFSClient.downloadFile2("group1/M00/00/00/rBBkLFy4GLOAKGzJAAMtk3_3ZEM552.jpg","/Users/wangdong/Downloads/a.jpg");
    }
    @RequestMapping("/cc")
    @CacheEvict(value="producta",key="#id")// 清空accountCache 缓存
    public void getrel(String id){
        System.out.println("cc");
    }



}
