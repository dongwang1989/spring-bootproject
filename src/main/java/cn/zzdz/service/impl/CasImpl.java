package cn.zzdz.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.Cas_;
import org.rosuda.REngine.REXP;
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

import cn.zzdz.dao.CasJpa;
import cn.zzdz.domain.Cas;
import cn.zzdz.dto.CasDto;
import cn.zzdz.interfaces.service.ICas;

@Service
public class CasImpl implements ICas {
	@Autowired
	private CasJpa jpa;

	@SuppressWarnings("serial")
	@Override
	public CasDto getall(CasDto param) {
		Sort sort = new Sort(Direction.ASC, "cAage");
		PageRequest pageable = PageRequest.of(param.getPageindex() - 1, param.getPagesize(), sort);
		Specification<Cas> spec = new Specification<Cas>() {

			@Override
			public Predicate toPredicate(Root<Cas> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> listpred = new ArrayList<>();

				Path<String> CAtime = root.get("cAtime");
				if (param.getCAtime() != null && !param.getCAtime().isEmpty()) {
					Predicate p1 = criteriaBuilder.like(CAtime, "%" + param.getCAtime() + "%");
					listpred.add(p1);
				}
				Path<String> CAaddr = root.get("cAaddr");
				if (param.getCAaddr() != null && !param.getCAaddr().isEmpty()) {
					Predicate p2 = criteriaBuilder.like(CAaddr, "%" + param.getCAaddr() + "%");
					listpred.add(p2);
				}
				Path<String> CAage = root.get("cAage");
				if (param.getCAage() != null && !param.getCAage().isEmpty()) {
					Predicate p3 = criteriaBuilder.equal(CAage, param.getCAage());
					listpred.add(p3);
				}
				Path<String> CAGender = root.get("cAGender");
				if (param.getCAGender() != null && !param.getCAGender().isEmpty()) {
					Predicate p4 = criteriaBuilder.equal(CAGender, param.getCAGender());
					listpred.add(p4);
				}
				Path<String> CAjob = root.get("cAjob");
				if (param.getCAjob() != null && !param.getCAjob().isEmpty()) {
					Predicate p5 = criteriaBuilder.like(CAjob, "%" + param.getCAjob() + "%");
					listpred.add(p5);
				}
				Path<String> CAmode = root.get("cAmode");
				if (param.getCAmode() != null && !param.getCAmode().isEmpty()) {

					Predicate p6 = criteriaBuilder.like(CAmode, "%" + param.getCAmode() + "%");
					listpred.add(p6);
				}
				Path<String> CAot = root.get("cAot");
				if (param.getCAot() != null && !param.getCAot().isEmpty()) {
					Predicate p7 = criteriaBuilder.like(CAot, "%" + param.getCAot() + "%");
					listpred.add(p7);
				}
				Path<String> CApro = root.get("cApro");

				if (param.getCApro() != null && !param.getCApro().isEmpty()) {
					Predicate p8 = criteriaBuilder.like(CApro, "%" + param.getCApro() + "%");
					listpred.add(p8);
				}
				Predicate[] par = new Predicate[listpred.size()];
				Predicate p = criteriaBuilder.and(listpred.toArray(par));
				return p;
			}
		};
		System.out.println(1);
		Page<Cas> page = jpa.findAll(spec, pageable);
		System.out.println(2);
		return chulis(page);
	}

	public CasDto chulis(Page<Cas> page) {
		List<CasDto> listdto = new ArrayList<>();
		List<Cas> listcas = page.getContent();
		for (Cas cas : listcas) {
			CasDto dto = new CasDto();
			dto.setCAaddr(cas.getcAaddr());
			dto.setCAage(cas.getcAage());
			dto.setCAclusters(cas.getcAclusters());
			dto.setCAGender(cas.getcAGender());
			dto.setCaid(cas.getCaid());
			dto.setCAjob(cas.getcAjob());
			dto.setCAmode(cas.getcAmode());
			dto.setCAot(cas.getcAot());
			dto.setCApro(cas.getcApro());
			dto.setCAtime(cas.getcAtime());
			listdto.add(dto);
		}
		CasDto zhi = new CasDto();
		zhi.setTotpageSize(page.getTotalPages());
		page.getNumber();
		zhi.setListdto(listdto);
		return zhi;
	}

	@Override
	public CasDto doR() throws RserveException, REXPMismatchException {
		RConnection rConnection = new RConnection();// Rservel.getRConnection();
		rConnection.setStringEncoding("utf8");
		REXP rexp = rConnection.eval("R.version.string");// 测试连接，方法是eval(String arg0)
		System.out.println(rexp.asString());// R version 3.1.2 (2014-10-31)
		rConnection.eval("source('D:/cases.R')");
		// int sum = rConnection.eval("dd()").asInteger();
		// @SuppressWarnings("unused")
		// int jieguo;
		// if (sum == 123) {
		// jieguo = 1;
		// // m = getDo(1, 10);
		// }

		return null;
	}

}
