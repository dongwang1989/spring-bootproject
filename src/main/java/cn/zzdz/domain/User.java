package cn.zzdz.domain;


import cn.zzdz.annotation.Ipassword;
import cn.zzdz.enums.UserStatus;
import cn.zzdz.hib.CustomType;
import cn.zzdz.valid.interfaces.Add;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@TypeDefs(@TypeDef(typeClass = CustomType.class, defaultForType = UserStatus.class, parameters = @org.hibernate.annotations.Parameter(name = "class", value = "cn.zzdz.enums.UserStatus")))
//@JsonIgnoreProperties(value = )
 //@JsonIgnoreProperties(value = {"name"})
public class User implements Serializable {
    /**
     * EntityManager em = emf.createEntityManager(); Query query =
     * em.createNamedQuery("finduser_permission");//根据User实体中定义的命名查询
     * query.setParameter("name", "李坏"); List<User> users = query.getResultList();
     */ 
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotEmpty(groups = {Add.class})
    public int id;
    @Column(name = "name")
    //@NotEmpty
    private String name;
    @Min(value = 18, message = "年龄最小为18")
    @Column(name = "age")
       //(groups = {Add.class})
    private int age;
    //@NotEmpty
    private String sex;

    //@NotEmpty
    @Column(name = "username")
    private String username;

    //@JsonIgnore
    //@JsonInclude(value = JsonInclude.Include.NON_NULL)
    @Ipassword(groups = {Add.class})
    @Column(name = "pwd")
    public String pwd;


    @ElementCollection
    @CollectionTable(name = "user_permission", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "permission")
    private Set<String> permission;

    @Column(name = "userstatus")
    private UserStatus userstatus;



    public UserStatus getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(UserStatus userstatus) {
        this.userstatus = userstatus;
    }

    public Set<String> getPermission() {
        //Map<String, Map<String, List<String>>> map = null;
        //map.get("");
        return permission;
    }

    public void setPermissions(Set<String> permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
