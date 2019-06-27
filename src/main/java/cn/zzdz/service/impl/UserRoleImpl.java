package cn.zzdz.service.impl;

import cn.zzdz.dao.PermionRoleJpa;
import cn.zzdz.dao.UserRoleJpa;
import cn.zzdz.domain.SysUser;
import cn.zzdz.domain.Userrole;
import cn.zzdz.interfaces.service.ILogin;
import cn.zzdz.interfaces.service.IUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class UserRoleImpl implements IUserRole {
    @Autowired
    private UserRoleJpa jpa;
    @Override
    public void add(Integer userid, List<Integer> listroleid) {
        //del old data by userid
        delByUserid(userid);
        List<Userrole> list = new ArrayList<>();
        for (Integer i:listroleid){
            Userrole userrole=new Userrole();
            userrole.setUserid(userid);
            userrole.setRoleid(i);
            list.add(userrole);

        }
        jpa.saveAll(list);
    }

    @Override
    public void del(Integer userid) {

    }

    @Override
    public void delByUserAndRole(Integer userid, Integer roleid) {
        jpa.delByUserAndRole(userid,roleid);
    }

    @Override
    public void delByUserid(Integer userid) {
        jpa.delByUserid(userid);
    }


    @Autowired
    private ILogin loginervice;
    @Override
    @Cacheable(value = "cacheuserrole", key = "#userid")
    public Set<String> getRoleSetByUserid(Integer userid) {
        SysUser user=loginervice.getUserByid(userid);
        Set<String> roleset=new HashSet<>();
        if(user.getUsername()!=null) {
            Set<Integer>   val = user.getSetrole();
            for (Integer i:val) {
                roleset.add(i.toString());
            }
        }
        System.out.println("该用户角色数量///"+roleset.size()+"jinru:获取角色");
        return roleset;
    }
    @Override
    @CacheEvict(value = "cacheuserrole", key = "#userid")
    public void delroleset(Integer userid) {
        System.out.println("delete cacheuserrole by id: " + userid);
    }
}

