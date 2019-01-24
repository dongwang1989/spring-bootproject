package cn.zzdz.mapper;

import cn.zzdz.domain.User;
import cn.zzdz.dto.UserDto;

import java.util.List;

public interface IUserMapper {
    public User finduserbypage();
    public void adduser(UserDto userdto);
    public void edituser(UserDto userdto);
    public User finduserbyid(UserDto userdto);
}
