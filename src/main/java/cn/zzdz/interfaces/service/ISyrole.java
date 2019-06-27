package cn.zzdz.interfaces.service;

import cn.zzdz.domain.Syrole;
import cn.zzdz.domain.Syrole;
import cn.zzdz.domain.Syrole;

import java.util.List;

public interface ISyrole {
    public void add(Syrole sy);

    public void del(Integer id);

    public List<Syrole> getUserByrolename(String name, Integer pageIndex, Integer pagesize);

    public Syrole getRoleByid(Integer id);
}
