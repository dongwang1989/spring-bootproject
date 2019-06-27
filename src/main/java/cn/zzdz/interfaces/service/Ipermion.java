package cn.zzdz.interfaces.service;

import cn.zzdz.domain.Permion;
import cn.zzdz.domain.Permion;

import java.util.List;

public interface Ipermion {
    
    public void add(Permion dep);

    public void del(Integer id);

    public List<Permion> getUserByusername(String name, Integer pageIndex, Integer pagesize);

    public Permion getUserByid(Integer id);
}
