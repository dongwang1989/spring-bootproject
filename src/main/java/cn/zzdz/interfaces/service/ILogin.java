package cn.zzdz.interfaces.service;

import cn.zzdz.domain.SysUser;
import cn.zzdz.dto.ResultDto;
import org.springframework.data.repository.query.Param;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Set;

public interface ILogin {

    public ResultDto login(String username, String pwd, Cookie cookie);

    public Cookie loginOut(Cookie cookie);

    public Cookie te(String username, String pwd, Cookie cook);

    public void add(SysUser user);

    public void update(SysUser user);

    public void del(int id);

    public List<SysUser> getUserByusername(String username, Integer pageIndex, Integer pagesize);

    public SysUser getUserByid(Integer id);

    public Set<String> getPermions(Integer id);


    public SysUser getUser(Integer userid);

    public void delCacheAll();

    public void delUserRoleAll();

    public void delRolePerAll();



}
