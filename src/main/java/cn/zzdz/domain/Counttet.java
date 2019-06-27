package cn.zzdz.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Counttet {
  @Id
  private Integer id;
  private Integer count;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

}
