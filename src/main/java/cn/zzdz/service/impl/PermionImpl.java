package cn.zzdz.service.impl;

import cn.zzdz.dao.PerminJpa;
import cn.zzdz.domain.Permion;
import cn.zzdz.interfaces.service.Ipermion;
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
public class PermionImpl implements Ipermion {
    @Autowired
    private PerminJpa perjpa;

    @Override
    public void add(Permion permion) {
        perjpa.save(permion);
    }

    @Override
    public void del(Integer id) {
        perjpa.deleteById(id);
    }

    @Override
    public List<Permion> getUserByusername(String name, Integer pageIndex, Integer pagesize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        PageRequest pageable = PageRequest.of(pageIndex - 1, pagesize, sort);
        Specification<Permion> spec = new Specification<Permion>() {

            @Override
            public Predicate toPredicate(Root<Permion> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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
        Page<Permion> page = perjpa.findAll(spec,pageable);
        return page.getContent();
    }

    @Override
    public Permion getUserByid(Integer id) {
        Optional<Permion> permion=perjpa.findById(id);
        return permion.get();//JpaRepository.findById(id);
    }


}
