package cn.zzdz.dto;

import cn.zzdz.annotation.Ipassword;
import cn.zzdz.constant.ConAttribute;
import cn.zzdz.enums.UserStatus;
import cn.zzdz.valid.interfaces.Add;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDto {
    public int id;
    private String name;
    private int age;
    private String sex;
    private String username;

    public String pwd;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int pageIndex;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int pageSize;
    private Set<String> permission;

    private String userstatus;


    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public Set<String> getPermission() {
        Map<String, Map<String, List<String>>> map = null;
        map.get("");
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
