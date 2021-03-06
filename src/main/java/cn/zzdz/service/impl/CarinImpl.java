package cn.zzdz.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.zzdz.dao.CarinJpa;
import cn.zzdz.domain.Carin;
import cn.zzdz.dto.CarinDto;
import cn.zzdz.interfaces.service.ICarin;

@Service
public class CarinImpl implements ICarin {
	@Autowired
	private CarinJpa jpa;

	@SuppressWarnings("serial")
	@Override
	public CarinDto getall(CarinDto param) {
		Sort sort = new Sort(Direction.DESC, "createTime");
		PageRequest pageable = PageRequest.of(param.getPageindex() - 1, param.getPagesize(), sort);
		Specification<Carin> spec = new Specification<Carin>() {

			@Override
			public Predicate toPredicate(Root<Carin> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<>();
				Path<String> startTime = root.get("startTime");
				if (param.getStartTime() != null && !param.getStartTime().isEmpty()) {
					Predicate p1 = criteriaBuilder.greaterThanOrEqualTo(startTime, param.getStartTime());
					list.add(p1);
				}
				Path<String> stopTime = root.get("stopTime");
				if (param.getStopTime() != null && !param.getStopTime().isEmpty()) {
					Predicate p2 = criteriaBuilder.lessThanOrEqualTo(stopTime, param.getStopTime());
					list.add(p2);
				}
				Path<String> license = root.get("license");
				if (param.getLicense() != null && !param.getLicense().isEmpty()) {
					Predicate p3 = criteriaBuilder.like(license, "%" + param.getLicense() + "%");
					list.add(p3);
				}
				Path<String> vehicleColorName = root.get("vehicleColorName");
				if (param.getVehicleColorName() != null && !param.getVehicleColorName().isEmpty()) {
					Predicate p4 = criteriaBuilder.like(vehicleColorName, "%" + param.getVehicleColorName() + "%");
					list.add(p4);
				}
				Path<String> vehicleTypeName = root.get("vehicleTypeName");
				if (param.getVehicleTypeName() != null && !param.getVehicleTypeName().isEmpty()) {
					Predicate p5 = criteriaBuilder.like(vehicleTypeName, "%" + param.getVehicleTypeName() + "%");
					list.add(p5);
				}
				Path<String> platTypeName = root.get("platTypeName");
				if (param.getPlatTypeName() != null && !param.getPlatTypeName().isEmpty()) {
					Predicate p6 = criteriaBuilder.like(platTypeName, "%" + param.getPlatTypeName() + "%");
					list.add(p6);
				}
				Path<String> platColorName = root.get("platColorName");
				if (param.getPlatColorName() != null && !param.getPlatColorName().isEmpty()) {
					Predicate p7 = criteriaBuilder.like(platColorName, "%" + param.getPlatColorName() + "%");
					list.add(p7);
				}
				Path<BigInteger> id = root.get("id");
				if (param.getId() != null) {
					Predicate p8 = criteriaBuilder.equal(id, param.getId());
					list.add(p8);
				}
				Predicate[] ps = new Predicate[list.size()];
				Predicate p = criteriaBuilder.and(list.toArray(ps));
				return p;
			}

		};
		Page<Carin> pf = jpa.findAll(spec, pageable);
		return chulidata(pf);
	}

	public CarinDto chulidata(Page<Carin> page) {
		CarinDto dto = new CarinDto();
		dto.setTotalpage(page.getTotalPages());
		List<CarinDto> list = new ArrayList<>();
		for (Carin f : page.getContent()) {
			CarinDto dto2 = new CarinDto();
			dto2.setId(f.getId());
			dto2.setLicense(f.getLicense());
			dto2.setVehicleColorName(f.getVehicleColorName());
			dto2.setVehicleTypeName(f.getVehicleTypeName());
			dto2.setPlatTypeName(f.getPlatTypeName());
			dto2.setPlatColorName(f.getPlatColorName());
			dto2.setCreateTime(f.getCreateTime());
			list.add(dto2);
		}
		dto.setList(list);
		return dto;

	}

}
