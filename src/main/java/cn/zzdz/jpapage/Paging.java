package cn.zzdz.jpapage;


import cn.zzdz.domain.Carfin;
import cn.zzdz.dto.CarfinDto;
import com.google.common.collect.Lists;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Paging {

    public static Object getDto(Integer pageIndex, Integer pageSize, Object objParam,
                                JpaSpecificationExecutor jpa, String columsort, Sort.Direction sortenum) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Sort sort = new Sort(sortenum, columsort);
        PageRequest pageable = PageRequest.of(pageIndex - 1, pageSize, sort);
        Class clazz = objParam.getClass();
        Class cla = Class.forName(clazz.getName());
        cla.newInstance();
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();

                for (Method met:cla.getDeclaredMethods()){
                    String col=met.getName().substring(3).toLowerCase();
                    boolean isGet = met.getName().substring(0, 3).contains("get");
                    String packageName = met.getReturnType().getPackage().getName();
                    if (isGet && packageName.equals("java.lang")) {
                        try {
                            Object val = met.invoke(objParam);
                            if (val!=null){
                                if (val.getClass()!=int.class&&val.getClass()!=Integer.class){
                                    predicates.add(criteriaBuilder.like(root.get(col), "%" + val + "%"));
                                }
                                else  {
                                    predicates.add(criteriaBuilder.equal(root.get(col), val));
                                }
                            }

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }

//                Predicate[] ps = new Predicate[list.size()];
//                Predicate p = criteriaBuilder.and(list.toArray(ps));
//                return p;

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

            }
        };

        Page<Object> pf = jpa.findAll(spec, pageable);
        List<Object> list = new ArrayList<>();
        for(Object obval:pf.getContent()) {

        }
        //return chulidata(pf);
        return objParam;
    }
}
