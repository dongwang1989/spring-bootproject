package cn.zzdz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.zzdz.domain.SysRole;

public interface RoleJpaRepository extends JpaRepository<SysRole, Long>, PagingAndSortingRepository<SysRole, Long> {//
	// @Query("from SysRole u where u.username=:username and u.pwd=:pwd")
	// public List<SysRoleEntity> getRoleList();
	@Query("from SysRole u where u.roleId=:role_id")
	public SysRole findroleinfo(@Param("role_id") Long role_id);
}
