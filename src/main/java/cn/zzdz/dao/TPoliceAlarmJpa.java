package cn.zzdz.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.zzdz.domain.TPoliceAlarmData;

@Repository
public interface TPoliceAlarmJpa
		extends JpaSpecificationExecutor<TPoliceAlarmData>, JpaRepository<TPoliceAlarmData, String> {
	@Query("from TPoliceAlarmData u where u.fAlarmDate=:fAlarmDate and u.fOrgId=:fOrgId")
	Page<TPoliceAlarmData> findTPoliceAlarm(@Param("fAlarmDate") Date fAlarmDate, @Param("fOrgId") String F_ORG_ID,
			Pageable pageable);

	@Query("from TPoliceAlarmData u ")
	Page<TPoliceAlarmData> findTPoliceAlarmAll(Pageable pageable);

	@Query("from TPoliceAlarmData u where fInputDate=:fInputDate")
	Page<TPoliceAlarmData> getDo(@Param("fInputDate") Date fInputDate, Pageable pageable);
}
