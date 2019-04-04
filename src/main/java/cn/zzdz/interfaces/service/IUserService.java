package cn.zzdz.interfaces.service;

import cn.zzdz.domain.User;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.UserDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

public interface IUserService {
	public ResultDto login(String username, String pwd, Cookie cookie);
	public void finduserbypage(UserDto userdto);
	public ResultDto getUser(UserDto userdto, HttpSession session);

	public ResultDto saveUser(UserDto userdto);

	public UserDto findUserInfoByuser(String username);

	public int delUserInfo(int id);

	public ResultDto logout(HttpSession session);

	public ResultDto sayHello();

	public ResultDto getHello(String param);

	public User findUserPermission(Integer id);

	// @Cacheable(value = "users")
	public Set<String> cafindUserInfoByuser(String username);

	public List<User> Likenames(String username);

	public String denglu(String username, String pwd, HttpSession session);

	public void ddd();

	public User test();
	//@Cacheable(value = "permion", key = "#id")
	public Set<String> getPermions(String id);
}
