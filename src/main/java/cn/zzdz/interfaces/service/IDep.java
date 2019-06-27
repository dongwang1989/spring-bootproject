package cn.zzdz.interfaces.service;

import cn.zzdz.domain.SysDept;
import cn.zzdz.domain.SysDept;

import java.util.List;

public interface IDep {
    public void add(SysDept dep);

    public void del(Integer id);

    public List<SysDept> getDepList(String name, Integer pageIndex, Integer pagesize);

    public SysDept getDepByid(Integer id);
}
