package cn.zzdz.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

public class a {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userId;

    @NotBlank(message="用户名不能为空")
    @Column(name = "username")
    private String username;
    //@Ipassword(groups = {Add.class})
    @NotBlank(message="密码必填项")
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "status")
    private Integer status;
    //@Column(name = "deptid")
    private Integer deptId;
    @Column(name = "createtime")
    private Date createTime;
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

    @OneToOne
    @JoinColumn(name="deptid",referencedColumnName="id")
    private SysDept dep;

    public Set<Integer> getSetrole() {
        return setrole;
    }

    public void setSetrole(Set<Integer> setrole) {
        this.setrole = setrole;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Column(name = "roleid")
    private Integer roleid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
