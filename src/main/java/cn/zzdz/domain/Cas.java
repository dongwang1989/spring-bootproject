package cn.zzdz.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the cases database table.
 * 
 */
@Entity
@Table(name = "cases")
@NamedQuery(name = "Cas.findAll", query = "SELECT c FROM Cas c")
public class Cas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CASES_CAID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CASES_CAID_GENERATOR")
	private int caid;
	// @Column(name = "CAaddr")
	private String cAaddr;
	// @Column(name = "CAage")
	private String cAage;
	// @Column(name = "CAclusters")
	private int cAclusters;
	// @Column(name = "CAGender")
	private String cAGender;
	// @Column(name = "CAjob")
	private String cAjob;
	// @Column(name = "CAmode")
	private String cAmode;
	// @Column(name = "CAot")
	private String cAot;
	// @Column(name = "CApro")
	private String cApro;
	// @Column(name = "CAtime")
	private String cAtime;

	public Cas() {
	}

	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public String getcAaddr() {
		return cAaddr;
	}

	public void setcAaddr(String cAaddr) {
		this.cAaddr = cAaddr;
	}

	public String getcAage() {
		return cAage;
	}

	public void setcAage(String cAage) {
		this.cAage = cAage;
	}

	public int getcAclusters() {
		return cAclusters;
	}

	public void setcAclusters(int cAclusters) {
		this.cAclusters = cAclusters;
	}

	public String getcAGender() {
		return cAGender;
	}

	public void setcAGender(String cAGender) {
		this.cAGender = cAGender;
	}

	public String getcAjob() {
		return cAjob;
	}

	public void setcAjob(String cAjob) {
		this.cAjob = cAjob;
	}

	public String getcAmode() {
		return cAmode;
	}

	public void setcAmode(String cAmode) {
		this.cAmode = cAmode;
	}

	public String getcAot() {
		return cAot;
	}

	public void setcAot(String cAot) {
		this.cAot = cAot;
	}

	public String getcApro() {
		return cApro;
	}

	public void setcApro(String cApro) {
		this.cApro = cApro;
	}

	public String getcAtime() {
		return cAtime;
	}

	public void setcAtime(String cAtime) {
		this.cAtime = cAtime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}