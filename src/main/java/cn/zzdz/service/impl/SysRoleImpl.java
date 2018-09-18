package cn.zzdz.service.impl;

import org.springframework.data.domain.Page;

import cn.zzdz.domain.SysRole;
import cn.zzdz.dto.ResultDto;
import cn.zzdz.dto.SysRoleDto;
import cn.zzdz.interfaces.service.ISysRole;

public class SysRoleImpl implements ISysRole {

	@Override
	public Page<SysRole> findRoleNoCriteria(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SysRole> findRoleCriteria(Integer page, Integer size, SysRoleDto roleQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysRoleDto findrolebyroleid(Long roleid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDto save(SysRoleDto role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDto delete(Long roleid) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Autowired
	// private RoleJpaRepository r;
	//
	// @Override
	// public Page<SysRole> findRoleNoCriteria(Integer page, Integer size) {
	// @SuppressWarnings("deprecation")
	// Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
	// return r.findAll(pageable);
	// }
	//
	// @Override
	// public Page<SysRole> findRoleCriteria(Integer page, Integer size, SysRoleDto
	// sysroledto) {
	// @SuppressWarnings("deprecation")
	// Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
	// Page<SysRole> rolePage = r.findAll(pageable);
	// // Page<SysRoleEntity> rolePage = r.findAll((Specification<SysRoleEntity>)
	// // (root, query, cb) -> {
	// // List<Predicate> list = new ArrayList<>();
	// // if (null != sysroledto.getRoleName() &&
	// !"".equals(sysroledto.getRoleName()))
	// // {
	// // list.add(cb.equal(root.get("name").as(String.class),
	// // sysroledto.getRoleName()));
	// // }
	// // list.add(cb.like(root.get("name").as(String.class),
	// // sysroledto.getRoleName()));
	// // Predicate[] p = new Predicate[list.size()];
	// // return cb.and(list.toArray(p));
	// // }, pageable);
	// return rolePage;
	// }
	//
	// @Override
	// public SysRoleDto findrolebyroleid(Long roleid) {
	// // SysRole role = r.findroleinfo(roleid);
	// // SysRoleDto dto = new SysRoleDto();
	// // dto.setRole_id(role.getRole_id());
	// // dto.setRole_name(role.getRole_name());
	// // dto.setCreate_time(role.getCreate_time());
	// // dto.setCreate_user_id(role.getCreate_user_id());
	// // dto.setRemark(role.getRemark());
	// return null;
	// }
	//
	// @Override
	// public ResultDto save(SysRoleDto role) {
	// // SysRole roleentity = new SysRole();
	// // roleentity.setRole_id(role.getRole_id());
	// // roleentity.setRole_name(role.getRole_name());
	// // roleentity.setCreate_time(role.getCreate_time());
	// // roleentity.setCreate_user_id(role.getCreate_user_id());
	// // roleentity.setRemark(role.getRemark());
	// ResultDto resdto = new ResultDto();
	// // SysRole roleentity2 = r.save(roleentity);
	// // if (roleentity2 != null) {
	// // resdto.setResult("1");
	// // } else {
	// // resdto.setResult("0");
	// // }
	// return resdto;
	// }
	//
	// @Override
	// public ResultDto delete(Long roleid) {
	// r.deleteById(roleid);
	// return null;
	// }

}
