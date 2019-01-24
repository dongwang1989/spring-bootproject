package cn.zzdz.component;


public class User {

  private long id;
  private long age;
  private String name;
  private String pwd;
  private String sex;
  private String username;
  private String userstatus;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getUserstatus() {
    return userstatus;
  }

  public void setUserstatus(String userstatus) {
    this.userstatus = userstatus;
  }

}
