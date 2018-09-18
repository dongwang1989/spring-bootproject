package cn.zzdz.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cn.zzdz.domain.Carin;

@Repository
public interface CarinJpa extends JpaSpecificationExecutor<Carin>, JpaRepository<Carin, BigInteger> {

}
