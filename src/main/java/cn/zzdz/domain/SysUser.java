package cn.zzdz.domain;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;
//@Document(indexName = "td", type = "er")
//@Document(indexName = "company",type = "employee", shards = 1,replicas = 0, refreshInterval = "-1")
@Entity
//@Validated
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String username;
    private String password;
    private String salt;
    private String email;
    @NotBlank(message = "不能空")
    private String mobile;
    private Integer status;
    private Integer deptid;
    private Date createtime;
    private String name;


    @OneToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "deptid", referencedColumnName = "id", insertable = false, updatable = false)
    private SysDept dep = new SysDept();

    @ElementCollection
    @CollectionTable(name = "userrole", joinColumns = @JoinColumn(name = "userid"))
    @Column(name = "roleid")
    private Set<Integer> setrole;

    public SysDept getDep() {
        return dep;
    }

    public void setDep(SysDept dep) {
        this.dep = dep;
    }

    public Set<Integer> getSetrole() {
        return setrole;
    }

    public void setSetrole(Set<Integer> setrole) {
        this.setrole = setrole;
    }


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }


    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
