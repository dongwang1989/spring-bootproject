package cn.zzdz.interfaces.service;

import cn.zzdz.domain.Permion;
import cn.zzdz.domain.Permionrole;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface IPermionRole {
    @Transactional
    public void add(Integer roleid, List<String> listpermion);

    public void del(Integer roleid, String permion);

    public List<Permionrole> getPermionByroleid(Integer roleid);

    public void delall(Integer roleid);

    public Set<String> getPermions(Integer roleid);

    public void deluserpermion(Integer roleid);
}
