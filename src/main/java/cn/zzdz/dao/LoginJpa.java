package cn.zzdz.dao;

import cn.zzdz.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginJpa extends JpaSpecificationExecutor<SysUser>,  JpaRepository<SysUser, Integer> {
    @Query(value="from SysUser u where u.username=:username and u.password=:password")
    public SysUser getUser(@Param("username") String username, @Param("password") String password);

    @Query(value="from SysUser u where u.username=:username")
    public List<SysUser> getUserByusername(@Param("username") String username);




    
}



