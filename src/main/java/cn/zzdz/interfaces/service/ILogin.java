package cn.zzdz.interfaces.service;

import cn.zzdz.domain.SysUser;
import cn.zzdz.dto.ResultDto;
import org.springframework.data.repository.query.Param;

import javax.servlet.http.Cookie;
import java.util.List;

public interface ILogin {

    public ResultDto login(String username,String pwd,Cookie cookie);

    public Cookie loginOut(Cookie cookie);

    public Cookie te(String username,String pwd,Cookie cook);

    public void add(SysUser user);

    public List<SysUser> getUserByusername(String username);

}
