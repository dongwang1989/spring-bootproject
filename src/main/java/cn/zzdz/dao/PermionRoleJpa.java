package cn.zzdz.dao;

import cn.zzdz.domain.Permionrole;
import cn.zzdz.domain.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PermionRoleJpa  extends JpaSpecificationExecutor<Permionrole>, JpaRepository<Permionrole, Integer> {
    @Modifying
    @Transactional
    @Query("delete from Permionrole es where es.roleid = :roleid")
    public void  delByrolid(@Param("roleid") Integer roleid);
    @Modifying
    @Transactional
    @Query("delete from Permionrole es where es.roleid = :roleid and es.permssion= :permion")
    public void  del(@Param("roleid") Integer roleid,@Param("permion") String permion);
}
