package cn.zzdz.dao;

import cn.zzdz.domain.Syrole;
import cn.zzdz.domain.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface SyroleJpa extends JpaSpecificationExecutor<Syrole>, JpaRepository<Syrole, Integer> {

}
