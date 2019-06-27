package cn.zzdz.service.impl;

import cn.zzdz.dao.PerminJpa;
import cn.zzdz.dao.PermionRoleJpa;
import cn.zzdz.domain.Permionrole;
import cn.zzdz.domain.Syrole;
import cn.zzdz.domain.SysUser;
import cn.zzdz.interfaces.service.ILogin;
import cn.zzdz.interfaces.service.IPermionRole;
import cn.zzdz.interfaces.service.ISyrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermionRoleImpl implements IPermionRole {
    @Autowired
    private PermionRoleJpa jpa;
    @Autowired
    private ILogin loginservice;

    @Transactional
    @Override
    public void add(Integer roleid, List<String> listpermion) {
        //del old per by roleid
        //delall(roleid);

        List<Permionrole> list = new ArrayList<>();
        for (String w : listpermion) {
            Permionrole pro = new Permionrole();
            pro.setRoleid(roleid);
            pro.setPermssion(w);
            list.add(pro);
            //System.out.println("pro:"+pro.getPermssion());
        }

        jpa.saveAll(list);
    }

    //根据删除全
    @Override
    public void delall(Integer roleid) {
        jpa.delByrolid(roleid);
    }

    @Override
    public void del(Integer roleid, String permion) {
        jpa.del(roleid, permion);
    }

    @Override
    public List<Permionrole> getPermionByroleid(Integer roleid) {
        return null;
    }

    @Autowired
    private ISyrole syervice;

    @Override
    @Cacheable(value = "permion", key = "#roleid")
    public Set<String> getPermions(Integer roleid) {
        Syrole role = syervice.getRoleByid(roleid);
        Set<String> setpermion = new HashSet<>();
        if(role.getRoleid()!=null) {
            setpermion = role.getPermission();
        }
        System.out.println("获取权限列表"+setpermion.size());
        return setpermion;
    }

    @Override
    @CacheEvict(value = "permion", key = "#roleid")
    public void deluserpermion(Integer roleid) {

        System.out.println("delete deluserpermion by id: " + roleid);

    }
}
