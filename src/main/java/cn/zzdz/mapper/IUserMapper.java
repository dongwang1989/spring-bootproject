package cn.zzdz.mapper;

import cn.zzdz.domain.User;
import cn.zzdz.dto.UserDto;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IUserMapper {
    public User finduserbypage();
    public void adduser(UserDto userdto);
    public void edituser(UserDto userdto);
    public User finduserbyid(UserDto userdto);
    public List<Map<String,Object>> cha(Map<String,Object> ma);
    public void adkcb(Map<String,Object> ma);
    public Set<String> getper(Map<String,Object> map);
}
