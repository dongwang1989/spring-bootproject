package cn.zzdz.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.zzdz.domain.Viewcarlicense;

public interface ViewcarlicenseJpa
		extends JpaSpecificationExecutor<Viewcarlicense>, JpaRepository<Viewcarlicense, BigInteger> {

}
