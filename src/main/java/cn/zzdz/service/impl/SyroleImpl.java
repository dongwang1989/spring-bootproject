package cn.zzdz.service.impl;

import cn.zzdz.dao.SyroleJpa;
import cn.zzdz.domain.Syrole;
import cn.zzdz.domain.Syrole;
import cn.zzdz.interfaces.service.IPermionRole;
import cn.zzdz.interfaces.service.ISyrole;
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
import java.util.Set;

@Service
public class SyroleImpl implements ISyrole {
    @Autowired
    private SyroleJpa syrolejpa;

    @Override
    public void add(Syrole sy) {
        syrolejpa.save(sy);
    }


    @Override
    public void del(Integer id) {
        //del cache by roleid
        //permionRole.deluserpermion(id);
        syrolejpa.deleteById(id);
    }

    @Override
    public List<Syrole> getUserByrolename(String name, Integer pageIndex, Integer pagesize) {
        Sort sort = new Sort(Sort.Direction.ASC, "roleid");
        PageRequest pageable = PageRequest.of(pageIndex - 1, pagesize, sort);
        Specification<Syrole> spec = new Specification<Syrole>() {

            @Override
            public Predicate toPredicate(Root<Syrole> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> listpred = new ArrayList<>();

                Path<String> pname = root.get("rolename");
                if (pname != null && !pname.equals("")) {
                    Predicate p1 = criteriaBuilder.like(pname, "%" + name + "%");
                    listpred.add(p1);
                }

                Predicate[] par = new Predicate[listpred.size()];
                Predicate p = criteriaBuilder.and(listpred.toArray(par));

                return p;
            }
        };
        Page<Syrole> page = syrolejpa.findAll(spec, pageable);
        return page.getContent();
    }

    @Override
    public Syrole getRoleByid(Integer id) {
        Optional<Syrole> syrole = syrolejpa.findById(id);
        Syrole rol = new Syrole();
        if (syrole.isPresent()) {
            rol = syrole.get();
        }
        return rol;
    }

}
