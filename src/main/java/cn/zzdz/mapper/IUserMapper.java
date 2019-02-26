package cn.zzdz.mapper;

import cn.zzdz.domain.User;
import cn.zzdz.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface IUserMapper {
    public User finduserbypage();
    public void adduser(UserDto userdto);
    public void edituser(UserDto userdto);
    public User finduserbyid(UserDto userdto);
    public List<Map<String,Object>> cha(Map<String,Object> ma);
    public void adkcb(Map<String,Object> ma);
}
