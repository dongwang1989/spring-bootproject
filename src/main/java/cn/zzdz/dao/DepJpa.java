package cn.zzdz.dao;

import cn.zzdz.domain.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DepJpa extends JpaSpecificationExecutor<SysDept>, JpaRepository<SysDept, Integer> {

}
