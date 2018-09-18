package cn.zzdz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.zzdz.domain.TPoliceAlarmDataPred;

@Repository
public interface TPoliceAlarmpredJpa
		extends JpaSpecificationExecutor<TPoliceAlarmDataPred>, JpaRepository<TPoliceAlarmDataPred, Integer> {

	@Modifying
	@Query("delete from TPoliceAlarmDataPred")
	public int delall();

}
