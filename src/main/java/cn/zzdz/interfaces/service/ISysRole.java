package cn.zzdz.interfaces.service;

import org.springframework.data.domain.Page;

import cn.zzdz.domain.SysRole;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.SysRoleDto;

public interface ISysRole {
	Page<SysRole> findRoleNoCriteria(Integer page, Integer size);

	Page<SysRole> findRoleCriteria(Integer page, Integer size, SysRoleDto roleQuery);

	public SysRoleDto findrolebyroleid(Long roleid);

	public ResultDto save(SysRoleDto role);

	public ResultDto delete(Long roleid);
	// 获取角色列表
	// public List<SysRoleDto> getRoleList();
	// 增加权限列表
	// public

}
