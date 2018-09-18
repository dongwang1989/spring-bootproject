package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cases database table.
 * 
 */
@Entity
@Table(name="cases")
@NamedQuery(name="Cas.findAll", query="SELECT c FROM Cas c")
public class Cas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int caid;

	private String CAaddr;

	private String CAage;

	private int CAclusters;

	private String CAGender;

	private String CAjob;

	private String CAmode;

	private String CAot;

	private String CApro;

	private String CAtime;

	public Cas() {
	}

	public int getCaid() {
		return this.caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public String getCAaddr() {
		return this.CAaddr;
	}

	public void setCAaddr(String CAaddr) {
		this.CAaddr = CAaddr;
	}

	public String getCAage() {
		return this.CAage;
	}

	public void setCAage(String CAage) {
		this.CAage = CAage;
	}

	public int getCAclusters() {
		return this.CAclusters;
	}

	public void setCAclusters(int CAclusters) {
		this.CAclusters = CAclusters;
	}

	public String getCAGender() {
		return this.CAGender;
	}

	public void setCAGender(String CAGender) {
		this.CAGender = CAGender;
	}

	public String getCAjob() {
		return this.CAjob;
	}

	public void setCAjob(String CAjob) {
		this.CAjob = CAjob;
	}

	public String getCAmode() {
		return this.CAmode;
	}

	public void setCAmode(String CAmode) {
		this.CAmode = CAmode;
	}

	public String getCAot() {
		return this.CAot;
	}

	public void setCAot(String CAot) {
		this.CAot = CAot;
	}

	public String getCApro() {
		return this.CApro;
	}

	public void setCApro(String CApro) {
		this.CApro = CApro;
	}

	public String getCAtime() {
		return this.CAtime;
	}

	public void setCAtime(String CAtime) {
		this.CAtime = CAtime;
	}

}