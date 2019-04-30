package com.sample;


public class SysDept {

  private long deptid;
  private long parentid;
  private String name;
  private long ordernum;
  private long delflag;


  public long getDeptid() {
    return deptid;
  }

  public void setDeptid(long deptid) {
    this.deptid = deptid;
  }


  public long getParentid() {
    return parentid;
  }

  public void setParentid(long parentid) {
    this.parentid = parentid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getOrdernum() {
    return ordernum;
  }

  public void setOrdernum(long ordernum) {
    this.ordernum = ordernum;
  }


  public long getDelflag() {
    return delflag;
  }

  public void setDelflag(long delflag) {
    this.delflag = delflag;
  }

}
