package cn.zzdz.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zzdz.dao.UserJpaRepository;
import cn.zzdz.permission.IPermission;

//@RestController
//@RequestMapping("/sys/role")
public class RoleController {
	@Autowired
	private UserJpaRepository userJpaRepository;

	// @Autowired
	// private ISysRole sysrole;

	// @RequestMapping("/list")
	// @IPermission("rolelist")
	// public void getrolelist(@RequestParam String roleName, @RequestParam Integer
	// page, @RequestParam Integer size) {
	// // Page<SysRoleDto> pages;
	// // if (roleName != null && !roleName.equals("")) {
	// // SysRoleDto sysroledto = new SysRoleDto();
	// // sysroledto.setRoleName(roleName);
	// // pages = sysrole.findRoleCriteria(page, size, sysroledto);
	// // } else {
	// // pages = sysrole.findRoleNoCriteria(page, size);
	// // }
	// // System.out.println(pages);
	// }
	//
	// /**
	// * 角色信息
	// */
	@GetMapping("/info/{roleId}")
	@IPermission("sys:role:info")
	public void info(@RequestParam("roleId") Long roleId) {
		userJpaRepository.deleteAll();
		// return role;
		// 查询角色对应的菜单

	}
	//
	// /**
	// * 保存角色
	// */
	// @PostMapping("/save")
	// @IPermission("sys:role:save")
	// public ResultDto save(@RequestBody SysRoleDto role) {
	// ResultDto res = sysrole.save(role);
	// return res;
	// }
	//
	// //
	// /**
	// * 修改角色
	// */
	// @PostMapping("/update")
	// @IPermission("sys:role:update")
	// public ResultDto update(@RequestBody SysRoleDto role) {
	// ResultDto res = sysrole.save(role);
	// return res;
	//
	// }
	//
	// /**
	// * 删除角色
	// */
	// @PostMapping("/delete")
	// @IPermission("sys:role:delete")
	// public ResultDto delete(@RequestBody Long roleId) {
	// ResultDto res = sysrole.delete(roleId);
	// return res;
	// }
}
