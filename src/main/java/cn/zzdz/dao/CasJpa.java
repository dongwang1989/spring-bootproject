package cn.zzdz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.zzdz.domain.Cas;

public interface CasJpa extends JpaSpecificationExecutor<Cas>, JpaRepository<Cas, String> {

	// Page<Cas> findAll(Specification<Cas> spec, PageRequest pageable);
}
