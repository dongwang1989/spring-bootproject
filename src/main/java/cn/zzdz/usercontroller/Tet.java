package cn.zzdz.usercontroller;

import cn.zzdz.dto.ResultDto;
import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.error.Error;
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
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

//@Service
@RestController
@Api("用户相关操作")
@RequestMapping("/tet")
public class Tet {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登陆", httpMethod = "get", notes = "根据传过来的用户名和密码查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultDto login(String username, String pwd) {
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
    @RequestMapping(value = "/login2", method = RequestMethod.GET)
    public ResultDto login2(String username, String pwd) {
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

    @ApiOperation(value = "文件上传", httpMethod = "post")
    @PostMapping(value = "/uppload", headers = "content-type=multipart/form-data")
    public StorePath test(@RequestParam MultipartFile file) throws IOException {
        // 设置文件信息
        Set<MataData> mataData = new HashSet<>();
        mataData.add(new MataData("author", "zonghui"));
        mataData.add(new MataData("description", "xxx文件，嘿嘿嘿"));
        // 上传   （文件上传可不填文件信息，填入null即可）
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), mataData);
        String url = FastDFSClient.getResAccessUrl(storePath.getFullPath());
        System.out.println("address dizhi:" + url);
        return storePath;
    }

    @RequestMapping("/c")
    public void gec(HttpServletResponse response) {
        String[] bn = {"rBBkK1y6qS2ABRY3AADyy4xlRyA95.conf", "rBBkLFy6qQuAfYL1AAMtk3_3ZEM499.jpg"
        ,"rBBkLFy6pjyAdljZAAMtk3_3ZEM803.jpg","rBBkLFy6oo2ACLExAAMtk3_3ZEM996.jpg","rBBkLFy6pjyAdljZAAMtk3_3ZEM803.jpg"
        ,"rBBkLFzCuB2AV_NTAAMtk3_3ZEM346.jpg"};
        for (String c : bn) {
            FastDFSClient.deleteFile("group1/M00/00/00/" + c);
        }
    }

    @RequestMapping("/cc")
    @CacheEvict(value = "producta", key = "#id")// 清空accountCache 缓存
    public void getrel(String id) {
        System.out.println("cc");
    }

    @Test
    public void ab() {
        String[] bn = {"rBBkK1y6qS2ABRY3AADyy4xlRyA95.conf"};
        for (String c : bn) {
            FastDFSClient.deleteFile("group1/M00/00/00/" + c);
        }

    }
    //Cookie cookie = new Cookie("access_token", UUID.randomUUID().toString());
    @RequestMapping("/aa")
    public void aa(HttpServletResponse response){
        Cookie cookie = new Cookie("access_token", "aa");
        response.addCookie(cookie);
    }
    @RequestMapping("/aaa")
    public void aaa(HttpServletResponse response){
        Cookie cookie = new Cookie("access_token", "aaa");
        response.addCookie(cookie);
    }
    @RequestMapping("/bb")
    public void bb(HttpServletResponse response){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        Cookie cook = null;
        for (Cookie c : cookies) {
            System.out.println(c.getName()+":"+c.getValue());
        }
//        Cookie ncookie = new Cookie("access_token", null);//重新设置cook
//        ncookie.setMaxAge(0); //立即删除型
//        //ncookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
//        response.addCookie(ncookie);
    }
    @RequestMapping("/ccc")
    public void cc(){
        throw new Error(ErrorMessage.INCORRECT_PASSWORD, "acc");
    }

}
