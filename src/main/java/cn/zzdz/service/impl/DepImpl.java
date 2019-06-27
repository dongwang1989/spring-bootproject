package cn.zzdz.service.impl;

import cn.zzdz.dao.DepJpa;
import cn.zzdz.domain.SysDept;
import cn.zzdz.domain.SysDept;
import cn.zzdz.domain.SysUser;
import cn.zzdz.interfaces.service.IDep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class DepImpl implements IDep {
    @Autowired
    private DepJpa depjpa;

    @Override
    public void add(SysDept dep) {
        depjpa.save(dep);
    }

    @Override
    public void del(Integer id) {
        depjpa.deleteById(id);
    }

    @Override
    public List<SysDept> getDepList(String name, Integer pageIndex, Integer pagesize) {
        Sort sort = new Sort(Sort.Direction.ASC, "deptid");
        PageRequest pageable = PageRequest.of(pageIndex - 1, pagesize, sort);
        Specification<SysDept> spec = new Specification<SysDept>() {

            @Override
            public Predicate toPredicate(Root<SysDept> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> listpred = new ArrayList<>();

                Path<String> pname = root.get("name");
                if (pname != null && !pname.equals("")) {
                    Predicate p1 = criteriaBuilder.like(pname, "%" + name + "%");
                    listpred.add(p1);
                }

                Predicate[] par = new Predicate[listpred.size()];
                Predicate p = criteriaBuilder.and(listpred.toArray(par));
                return p;
            }
        };
        Page<SysDept> page = depjpa.findAll(spec,pageable);
        return page.getContent();
    }

    @Override
    public SysDept getDepByid(Integer id) {
        Optional<SysDept> dep=depjpa.findById(id);
        return dep.get();//JpaRepository.findById(id);
    }
}
