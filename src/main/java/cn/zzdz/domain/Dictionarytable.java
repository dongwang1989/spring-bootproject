package cn.zzdz.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the dictionarytable database table.
 * 
 */
@Entity
@Table(name = "dictionarytable")
@NamedQuery(name = "Dictionarytable.findAll", query = "SELECT d FROM Dictionarytable d")
public class Dictionarytable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DICTIONARYTABLE_CODENUM_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DICTIONARYTABLE_CODENUM_GENERATOR")
	private String codenum;

	private String vanames;

	// bi-directional many-to-one association to TPoliceAlarmDataPred
	@OneToMany(mappedBy = "dictionarytable1")
	private List<TPoliceAlarmDataPred> TPoliceAlarmDataPreds1;

	// bi-directional many-to-one association to TPoliceAlarmDataPred
	@OneToMany(mappedBy = "dictionarytable2")
	private List<TPoliceAlarmDataPred> TPoliceAlarmDataPreds2;

	public Dictionarytable() {
	}

	public String getCodenum() {
		return this.codenum;
	}

	public void setCodenum(String codenum) {
		this.codenum = codenum;
	}

	public String getVanames() {
		return this.vanames;
	}

	public void setVanames(String vanames) {
		this.vanames = vanames;
	}

	public List<TPoliceAlarmDataPred> getTPoliceAlarmDataPreds1() {
		return this.TPoliceAlarmDataPreds1;
	}

	public void setTPoliceAlarmDataPreds1(List<TPoliceAlarmDataPred> TPoliceAlarmDataPreds1) {
		this.TPoliceAlarmDataPreds1 = TPoliceAlarmDataPreds1;
	}

	public TPoliceAlarmDataPred addTPoliceAlarmDataPreds1(TPoliceAlarmDataPred TPoliceAlarmDataPreds1) {
		getTPoliceAlarmDataPreds1().add(TPoliceAlarmDataPreds1);
		TPoliceAlarmDataPreds1.setDictionarytable1(this);

		return TPoliceAlarmDataPreds1;
	}

	public TPoliceAlarmDataPred removeTPoliceAlarmDataPreds1(TPoliceAlarmDataPred TPoliceAlarmDataPreds1) {
		getTPoliceAlarmDataPreds1().remove(TPoliceAlarmDataPreds1);
		TPoliceAlarmDataPreds1.setDictionarytable1(null);

		return TPoliceAlarmDataPreds1;
	}

	public List<TPoliceAlarmDataPred> getTPoliceAlarmDataPreds2() {
		return this.TPoliceAlarmDataPreds2;
	}

	public void setTPoliceAlarmDataPreds2(List<TPoliceAlarmDataPred> TPoliceAlarmDataPreds2) {
		this.TPoliceAlarmDataPreds2 = TPoliceAlarmDataPreds2;
	}

	public TPoliceAlarmDataPred addTPoliceAlarmDataPreds2(TPoliceAlarmDataPred TPoliceAlarmDataPreds2) {
		getTPoliceAlarmDataPreds2().add(TPoliceAlarmDataPreds2);
		TPoliceAlarmDataPreds2.setDictionarytable2(this);

		return TPoliceAlarmDataPreds2;
	}

	public TPoliceAlarmDataPred removeTPoliceAlarmDataPreds2(TPoliceAlarmDataPred TPoliceAlarmDataPreds2) {
		getTPoliceAlarmDataPreds2().remove(TPoliceAlarmDataPreds2);
		TPoliceAlarmDataPreds2.setDictionarytable2(null);

		return TPoliceAlarmDataPreds2;
	}

}