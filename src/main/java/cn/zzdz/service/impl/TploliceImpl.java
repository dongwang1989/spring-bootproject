package cn.zzdz.service.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zzdz.dao.TPoliceAlarmJpa;
import cn.zzdz.domain.TPoliceAlarmData;
import cn.zzdz.dto.TPoliceDto;
import cn.zzdz.interfaces.service.ITplolice;

@Service
public class TploliceImpl implements ITplolice {
	@Autowired
	public TPoliceAlarmJpa tpolice;

	@Override
	public TPoliceDto getAll(int pageindex, int pagesize) {
		PageRequest pageable = PageRequest.of(pageindex, pagesize);
		// Pageable pageable = new PageRequest(pageindex, 10);
		Page<TPoliceAlarmData> page = tpolice.findTPoliceAlarmAll(pageable);

		List<TPoliceAlarmData> list = page.getContent();
		List<TPoliceDto> listtpldto = new ArrayList<>();
		for (TPoliceAlarmData tp : list) {
			TPoliceDto dto = new TPoliceDto();
			dto.setfInputDate(tp.getFInputDate());
			dto.setfInputUserName(tp.getFInputUserName());
			dto.setfOrgName(tp.getFOrgName());
			dto.setfCommunityName(tp.getFCommunityName());
			dto.setfPick(tp.getFPick());
			dto.setfRob(tp.getFRob());
			// F_PICK","F_ROB","F_GRAB","F_BURGLARY","F_THEFTCAR","F_PROPERTY","F_ELECTRIC","F_FRAUD","F_OTHER
			dto.setfGrab(tp.getFGrab());
			dto.setfBurglary(tp.getFBurglary());
			dto.setfTheftcar(tp.getFTheftcar());
			dto.setfProperty(tp.getFProperty());
			dto.setfElectric(tp.getFElectric());
			dto.setfFraud(tp.getFFraud());
			dto.setfOther(tp.getFOther());
			listtpldto.add(dto);
		}
		TPoliceDto jieguo = new TPoliceDto();
		jieguo.setTotalpages(page.getTotalPages());
		jieguo.setLisdto(listtpldto);

		return jieguo;
	}

	@Override
	public TPoliceDto doR() throws RserveException, REXPMismatchException {
		TPoliceDto m = new TPoliceDto();

		RConnection rConnection = new RConnection();// Rservel.getRConnection();
		rConnection.setStringEncoding("utf8");
		// REXP rexp = rConnection.eval("R.version.string");// 测试连接，方法是eval(String arg0)
		// System.out.println(rexp.asString());// R version 3.1.2 (2014-10-31)
		rConnection.eval("source('D:/f.R')");
		int sum = rConnection.eval("dd()").asInteger();
		@SuppressWarnings("unused")
		int jieguo;
		if (sum == 123) {
			jieguo = 1;
			m = getDo(1, 10);
		}
		return m;
	}

	@SuppressWarnings("serial")
	@Override
	public TPoliceDto eee(final TPoliceDto param) {
		// System.out.println("riqi:" + param.getfAlarmDate());
		Sort sort = new Sort(Direction.DESC, "fCommunityCode");
		PageRequest pageable = PageRequest.of(param.getPageindex(), param.getPagesize(), sort);
		Specification<TPoliceAlarmData> spec = new Specification<TPoliceAlarmData>() {

			@Override
			public Predicate toPredicate(Root<TPoliceAlarmData> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				Path<String> fCommunityCode = root.get("fCommunityCode");
				Path<String> fCommunityId = root.get("fCommunityId");
				Path<Date> fAlarmDate = root.get("fAlarmDate");
				List<Predicate> list = new ArrayList<>();
				if (param.getfCommunityCode() != null && !param.getfCommunityCode().isEmpty()) {
					System.out.println(param.getfCommunityCode());
					Predicate p1 = criteriaBuilder.equal(fCommunityCode, param.getfCommunityCode());
					list.add(p1);
				}
				if (param.getfCommunityId() != null) {
					System.out.println(param.getfCommunityId());
					Predicate p2 = criteriaBuilder.equal(fCommunityId, param.getfCommunityId());
					list.add(p2);
				}
				if (param.getfAlarmDate() != null) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String dateString = formatter.format(param.getfAlarmDate());
					ParsePosition pos = new ParsePosition(0);
					Date currentTime_2 = formatter.parse(dateString, pos);

					System.out.println(currentTime_2);
					Predicate p3 = criteriaBuilder.equal(fAlarmDate, currentTime_2);
					// criteriaBuilder.i
					list.add(p3);
				}
				Predicate[] pre = new Predicate[list.size()];

				// return query.where(list.toArray(pre)).getRestriction();
				return criteriaBuilder.and(list.toArray(pre));
			}
		};
		Page<TPoliceAlarmData> page = tpolice.findAll(spec, pageable);
		return chulidata(page);
	}

	public TPoliceDto chulidata(Page<TPoliceAlarmData> page) {
		// TPoliceDto jieguo;
		List<TPoliceAlarmData> list = page.getContent();
		List<TPoliceDto> listtpldto = new ArrayList<>();
		for (TPoliceAlarmData tp : list) {
			TPoliceDto dto = new TPoliceDto();
			dto.setfInputDate(tp.getFInputDate());
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy/M/d");
			// String dateString = formatter.format(tp.getFInputDate());
			// System.out.println("日期：" + dateString);
			dto.setfInputUserName(tp.getFInputUserName());
			dto.setfOrgName(tp.getFOrgName());
			dto.setfCommunityName(tp.getFCommunityName());
			dto.setfPick(tp.getFPick());
			dto.setfRob(tp.getFRob());
			// F_PICK","F_ROB","F_GRAB","F_BURGLARY","F_THEFTCAR","F_PROPERTY","F_ELECTRIC","F_FRAUD","F_OTHER
			dto.setfGrab(tp.getFGrab());
			dto.setfBurglary(tp.getFBurglary());
			dto.setfTheftcar(tp.getFTheftcar());
			dto.setfProperty(tp.getFProperty());
			dto.setfElectric(tp.getFElectric());
			dto.setfFraud(tp.getFFraud());
			dto.setfOther(tp.getFOther());
			listtpldto.add(dto);
		}
		TPoliceDto jieguo = new TPoliceDto();
		jieguo.setTotalpages(page.getTotalPages());
		jieguo.setLisdto(listtpldto);
		return jieguo;
	}

	public TPoliceDto getDo(int pageindex, int pagesize) {
		PageRequest pageable = PageRequest.of(pageindex, pagesize);

		Date d = new Date();
		d = getNowDate();
		System.out.println(d);
		Page<TPoliceAlarmData> page = tpolice.getDo(d, pageable);

		List<TPoliceAlarmData> list = page.getContent();
		List<TPoliceDto> listtpldto = new ArrayList<>();
		for (TPoliceAlarmData tp : list) {
			TPoliceDto dto = new TPoliceDto();
			dto.setfInputDate(tp.getFInputDate());
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy/M/d");
			// String dateString = formatter.format(tp.getFInputDate());
			// System.out.println("日期：" + dateString);
			dto.setfInputUserName(tp.getFInputUserName());
			dto.setfOrgName(tp.getFOrgName());
			dto.setfCommunityName(tp.getFCommunityName());
			dto.setfPick(tp.getFPick());
			dto.setfRob(tp.getFRob());
			// F_PICK","F_ROB","F_GRAB","F_BURGLARY","F_THEFTCAR","F_PROPERTY","F_ELECTRIC","F_FRAUD","F_OTHER
			dto.setfGrab(tp.getFGrab());
			dto.setfBurglary(tp.getFBurglary());
			dto.setfTheftcar(tp.getFTheftcar());
			dto.setfProperty(tp.getFProperty());
			dto.setfElectric(tp.getFElectric());
			dto.setfFraud(tp.getFFraud());
			dto.setfOther(tp.getFOther());
			listtpldto.add(dto);
		}
		TPoliceDto jieguo = new TPoliceDto();
		jieguo.setTotalpages(page.getTotalPages());
		jieguo.setLisdto(listtpldto);

		return jieguo;
	}

	public Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime_2 = formatter.parse("2017-05-01", pos);
		// System.out.println("riqi:" + dateString);
		return currentTime_2;
	}

	@Transactional
	@Override
	public int doRInt() throws RserveException, REXPMismatchException {

		System.out.println("dor");
		RConnection rConnection = new RConnection();// Rservel.getRConnection();
		rConnection.setStringEncoding("utf8");
		// REXP rexp = rConnection.eval("R.version.string");// 测试连接，方法是eval(String arg0)
		// System.out.println(rexp.asString());// R version 3.1.2 (2014-10-31)
		rConnection.eval("source('D:/f.R')");
		int sum = rConnection.eval("dd()").asInteger();
		System.out.println("dor2");
		@SuppressWarnings("unused")
		int jieguo = 0;
		if (sum == 123) {
			jieguo = 1;
		}
		return jieguo;
	}

	@Override
	public int shuju(int a, int b) throws RserveException, REXPMismatchException {
		RConnection rConnection = new RConnection();// Rservel.getRConnection();
		rConnection.setStringEncoding("utf8");
		rConnection.eval("source('D:/f.R')");
		System.out.println("dor3");
		int sum = rConnection.eval("ff(" + a + "," + b + ")").asInteger();
		return sum;
	}

}
