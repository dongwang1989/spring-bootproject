package cn.zzdz.service.impl;

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
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zzdz.dao.TPoliceAlarmpredJpa;
import cn.zzdz.domain.TPoliceAlarmDataPred;
import cn.zzdz.dto.TPolicepredDto;
import cn.zzdz.interfaces.service.ITplolicePred;

@Service
public class TplolicePredImpl implements ITplolicePred {
	@Autowired
	private TPoliceAlarmpredJpa ssjpa;

	@Override
	public TPolicepredDto getAll(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPolicepredDto doR() throws RserveException, REXPMismatchException {
		// TODO Auto-generated method stub
		return null;
	}

	public TPolicepredDto chulidata(Page<TPoliceAlarmDataPred> page) {
		TPolicepredDto dto = new TPolicepredDto();
		List<TPolicepredDto> list = new ArrayList<>();
		List<TPoliceAlarmDataPred> listzhi = page.getContent();
		for (TPoliceAlarmDataPred g : listzhi) {
			TPolicepredDto dto2 = new TPolicepredDto();
			dto2.setfOrgname(g.getDictionarytable1().getVanames());
			dto2.setfCommunityName(g.getDictionarytable2().getVanames());
			dto2.setfAlarmType(g.getFAlarmType());
			dto2.setfAlarmDate(g.getFAlarmDate());
			// ("扒窃","抢劫","抢夺","入室盗窃","盗窃汽车","盗窃车内财物","盗窃电动车","诈骗","其他刑事")
			// "F_PICK","F_ROB","F_GRAB","F_BURGLARY","F_THEFTCAR","F_PROPERTY","F_ELECTRIC","F_FRAUD","F_OTHER"
			String vg = "";
			String gue = "";
			switch (g.getFAlarmType()) {
			case "F_PICK":
				vg = "扒窃";
				gue = g.getFPick();
				break;
			case "F_ROB":
				vg = "抢劫";
				gue = g.getFRob();
				break;
			case "F_GRAB":
				vg = "抢夺";
				gue = g.getFGrab();
				break;
			case "F_BURGLARY":
				vg = "入室盗窃";
				gue = g.getFBurglary();
				break;
			case "F_THEFTCAR":
				vg = "盗窃汽车";
				gue = g.getFTheftcar();
				break;
			case "F_PROPERTY":
				vg = "盗窃车内财物";
				gue = g.getFProperty();
				break;
			case "F_ELECTRIC":
				vg = "盗窃电动车";
				gue = g.getFElectric();
				break;
			case "F_FRAUD":
				vg = "诈骗";
				gue = g.getFFraud();
				break;
			case "F_OTHER":
				vg = "其他刑事";
				gue = g.getFOther();
				break;

			}
			dto2.setfAlarmType(vg);
			dto2.setGuesvalue(gue);
			list.add(dto2);
		}
		dto.setList(list);
		dto.setTotalpages(page.getTotalPages());
		return dto;
	}

	@SuppressWarnings("serial")
	@Override
	public TPolicepredDto eee(TPolicepredDto param) {
		Sort sort = new Sort(Direction.DESC, "fAlarmDate");
		PageRequest pageable = PageRequest.of(param.getPageindex() - 1, param.getPagesize(), sort);
		Specification<TPoliceAlarmDataPred> spec = new Specification<TPoliceAlarmDataPred>() {

			@Override
			public Predicate toPredicate(Root<TPoliceAlarmDataPred> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {

				Path<String> fAlarmType = root.get("fAlarmType");// 案件类型
				Path<String> fOrgname = root.get("fOrgname");// 单位泰山区分局如
				Path<String> fCommunityName = root.get("fCommunityName");// fCommunityName 派出所
				Path<Date> fAlarmDate = root.get("fAlarmDate");
				List<Predicate> list = new ArrayList<>();
				if (param.getfAlarmType() != null && !param.getfAlarmType().isEmpty()) {
					Predicate p1 = criteriaBuilder.equal(fAlarmType, param.getfAlarmType());
					list.add(p1);
				}
				if (param.getfOrgname() != null && !param.getfOrgname().isEmpty()) {
					Predicate p2 = criteriaBuilder.equal(fOrgname, param.getfOrgname());
					list.add(p2);
				}
				if (param.getfCommunityName() != null && !param.getfCommunityName().isEmpty()) {
					Predicate p3 = criteriaBuilder.equal(fCommunityName, param.getfCommunityName());
					list.add(p3);
				}
				if (param.getfAlarmDate() != null && !param.getfAlarmDate().isEmpty()) {
					Predicate p4 = criteriaBuilder.equal(fAlarmDate, param.getfAlarmDate());
					list.add(p4);
				}
				Predicate[] prd = new Predicate[list.size()];
				Predicate j = criteriaBuilder.and(list.toArray(prd));
				// Path<String> fCommunityCode = root.get("fCommunityCode");
				// Path<String> fCommunityId = root.get("fCommunityId");
				return j;
			}

		};
		Page<TPoliceAlarmDataPred> page = ssjpa.findAll(spec, pageable);
		// System.out.println(2);
		return chulidata(page);
	}

	@Autowired
	private ResourceLoader resourceloader;

	@Override
	public int doRInt() throws RserveException, REXPMismatchException {
		int jieguo = 0;
		int sum = insertdata();
		if (sum == 1) {
			jieguo = 1;
		}
		return jieguo;
	}

	public int insertdata() throws RserveException, REXPMismatchException {
		int jieguo = 0;
		// final RConnection rConnection = new RConnection();
		// final String filePath =
		// resourceloader.getResource("classpath:static/rfl/f.R").getFile().getCanonicalPath();

		final RConnection rConnection = new RConnection();
		rConnection.setStringEncoding("utf8");
		// rConnection.eval(String.format("source('%s')", filePath));
		rConnection.eval("source('D:/f.R')");

		int sum = rConnection.eval("dd()").asInteger();
		rConnection.close();
		if (sum == 123) {
			jieguo = 1;
		}

		return jieguo;
	}

	@Transactional
	public void xxx() {

		// xxRepository.delete(aaa);
		// xxRepository.save(bbb);
	}

	@Transactional
	@Override
	public int deldata() {
		int d = 0;
		try {
			ssjpa.delall();
			d = 1;
		} catch (Exception e) {
			d = 0;
		}
		return d;
	}

}
