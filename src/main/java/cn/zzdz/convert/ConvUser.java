package cn.zzdz.convert;

import cn.zzdz.domain.User;
import cn.zzdz.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConvUser {

    public User toUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        return  user;
    }
    public List<User> toListUser(List<UserDto> userDto){
        List<User> lit=new ArrayList<>();
        for(UserDto dto:userDto) {
            User user = new User();
            user.setId(dto.getId());
            user.setName(dto.getName());
            lit.add(user);
        }
        return  lit;
    }


}
