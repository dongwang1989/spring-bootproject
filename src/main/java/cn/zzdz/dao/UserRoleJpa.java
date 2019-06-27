package cn.zzdz.dao;

import cn.zzdz.domain.Userrole;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Repository

public interface UserRoleJpa extends JpaSpecificationExecutor<Userrole>, JpaRepository<Userrole, BigInteger> {
    @Modifying
    @Transactional
    @Query("delete from Userrole es where es.userid = :userid ")
    public void  delByUserid(@Param("userid") Integer userid);
    @Modifying
    @Transactional
    @Query("delete from Userrole es where es.userid = :userid and es.roleid= :roleid")
    public void  delByUserAndRole(@Param("userid") Integer userid, @Param("roleid") Integer roleid);

}
