package cn.zzdz.interfaces.service;

import cn.zzdz.domain.Userrole;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface IUserRole {
    public void add(Integer userid, List<Integer> listroleid);

    public void del(Integer userid);

    public void delByUserAndRole(Integer userid, Integer roleid);

    @Modifying
    @Transactional
    public void delByUserid(Integer userid);

    public Set<String> getRoleSetByUserid(Integer userid);

    public void delroleset(Integer userid);
    //del user cachable when update or del
}
