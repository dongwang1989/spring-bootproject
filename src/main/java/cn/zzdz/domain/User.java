package cn.zzdz.domain;

import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
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
	public int id;
	private String name;
	private int age;
	private String sex;
	private String username;
	private String pwd;

	@ElementCollection
	@CollectionTable(name = "user_permission", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "permission")
	private Set<String> permission;

	public Set<String> getPermission() {
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
