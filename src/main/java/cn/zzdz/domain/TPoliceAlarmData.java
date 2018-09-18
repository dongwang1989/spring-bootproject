package cn.zzdz.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the t_police_alarm_data database table.
 * 
 */
@Entity
@Table(name = "t_police_alarm_data")
@NamedQuery(name = "TPoliceAlarmData.findAll", query = "SELECT t FROM TPoliceAlarmData t")
public class TPoliceAlarmData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "T_POLICE_ALARM_DATA_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_POLICE_ALARM_DATA_ID_GENERATOR")
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_ALARM_DATE")
	private Date fAlarmDate;

	@Column(name = "F_ALARM_TYPE")
	private String fAlarmType;

	@Column(name = "F_BURGLARY")
	private int fBurglary;

	@Column(name = "F_COMMUNITY_CODE")
	private String fCommunityCode;

	@Column(name = "F_COMMUNITY_ID")
	private BigInteger fCommunityId;

	@Column(name = "F_COMMUNITY_NAME")
	private String fCommunityName;

	@Column(name = "F_ELECTRIC")
	private int fElectric;

	@Column(name = "F_FRAUD")
	private int fFraud;

	@Column(name = "F_GRAB")
	private int fGrab;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_INPUT_DATE")
	private Date fInputDate;

	@Column(name = "F_INPUT_USER_CODE")
	private String fInputUserCode;

	@Column(name = "F_INPUT_USER_ID")
	private BigInteger fInputUserId;

	@Column(name = "F_INPUT_USER_NAME")
	private String fInputUserName;

	@Column(name = "F_NOTE")
	private String fNote;

	@Column(name = "F_ORG_CODE")
	private String fOrgCode;

	@Column(name = "F_ORG_ID")
	private BigInteger fOrgId;

	@Column(name = "F_ORG_NAME")
	private String fOrgName;

	@Column(name = "F_OTHER")
	private int fOther;

	@Column(name = "F_PICK")
	private int fPick;

	@Column(name = "F_PROPERTY")
	private int fProperty;

	@Column(name = "F_ROB")
	private int fRob;

	@Column(name = "F_THEFTCAR")
	private int fTheftcar;

	@Column(name = "F_TIMES")
	private Integer fTimes;

	@Temporal(TemporalType.DATE)
	@Column(name = "F_UPDATE_DATE")
	private Date fUpdateDate;

	@Column(name = "F_UPDATE_USER_CODE")
	private String fUpdateUserCode;

	@Column(name = "F_UPDATE_USER_ID")
	private BigInteger fUpdateUserId;

	@Column(name = "F_UPDATE_USER_NAME")
	private String fUpdateUserName;

	private int version;

	public TPoliceAlarmData() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFAlarmDate() {
		return this.fAlarmDate;
	}

	public void setFAlarmDate(Date fAlarmDate) {
		this.fAlarmDate = fAlarmDate;
	}

	public String getFAlarmType() {
		return this.fAlarmType;
	}

	public void setFAlarmType(String fAlarmType) {
		this.fAlarmType = fAlarmType;
	}

	public int getFBurglary() {
		return this.fBurglary;
	}

	public void setFBurglary(int fBurglary) {
		this.fBurglary = fBurglary;
	}

	public String getFCommunityCode() {
		return this.fCommunityCode;
	}

	public void setFCommunityCode(String fCommunityCode) {
		this.fCommunityCode = fCommunityCode;
	}

	public BigInteger getFCommunityId() {
		return this.fCommunityId;
	}

	public void setFCommunityId(BigInteger fCommunityId) {
		this.fCommunityId = fCommunityId;
	}

	public String getFCommunityName() {
		return this.fCommunityName;
	}

	public void setFCommunityName(String fCommunityName) {
		this.fCommunityName = fCommunityName;
	}

	public int getFElectric() {
		return this.fElectric;
	}

	public void setFElectric(int fElectric) {
		this.fElectric = fElectric;
	}

	public int getFFraud() {
		return this.fFraud;
	}

	public void setFFraud(int fFraud) {
		this.fFraud = fFraud;
	}

	public int getFGrab() {
		return this.fGrab;
	}

	public void setFGrab(int fGrab) {
		this.fGrab = fGrab;
	}

	public Date getFInputDate() {
		return this.fInputDate;
	}

	public void setFInputDate(Date fInputDate) {
		this.fInputDate = fInputDate;
	}

	public String getFInputUserCode() {
		return this.fInputUserCode;
	}

	public void setFInputUserCode(String fInputUserCode) {
		this.fInputUserCode = fInputUserCode;
	}

	public BigInteger getFInputUserId() {
		return this.fInputUserId;
	}

	public void setFInputUserId(BigInteger fInputUserId) {
		this.fInputUserId = fInputUserId;
	}

	public String getFInputUserName() {
		return this.fInputUserName;
	}

	public void setFInputUserName(String fInputUserName) {
		this.fInputUserName = fInputUserName;
	}

	public String getFNote() {
		return this.fNote;
	}

	public void setFNote(String fNote) {
		this.fNote = fNote;
	}

	public String getFOrgCode() {
		return this.fOrgCode;
	}

	public void setFOrgCode(String fOrgCode) {
		this.fOrgCode = fOrgCode;
	}

	public BigInteger getFOrgId() {
		return this.fOrgId;
	}

	public void setFOrgId(BigInteger fOrgId) {
		this.fOrgId = fOrgId;
	}

	public String getFOrgName() {
		return this.fOrgName;
	}

	public void setFOrgName(String fOrgName) {
		this.fOrgName = fOrgName;
	}

	public int getFOther() {
		return this.fOther;
	}

	public void setFOther(int fOther) {
		this.fOther = fOther;
	}

	public int getFPick() {
		return this.fPick;
	}

	public void setFPick(int fPick) {
		this.fPick = fPick;
	}

	public int getFProperty() {
		return this.fProperty;
	}

	public void setFProperty(int fProperty) {
		this.fProperty = fProperty;
	}

	public int getFRob() {
		return this.fRob;
	}

	public void setFRob(int fRob) {
		this.fRob = fRob;
	}

	public int getFTheftcar() {
		return this.fTheftcar;
	}

	public void setFTheftcar(int fTheftcar) {
		this.fTheftcar = fTheftcar;
	}

	public Integer getFTimes() {
		return this.fTimes;
	}

	public void setFTimes(Integer fTimes) {
		this.fTimes = fTimes;
	}

	public Date getFUpdateDate() {
		return this.fUpdateDate;
	}

	public void setFUpdateDate(Date fUpdateDate) {
		this.fUpdateDate = fUpdateDate;
	}

	public String getFUpdateUserCode() {
		return this.fUpdateUserCode;
	}

	public void setFUpdateUserCode(String fUpdateUserCode) {
		this.fUpdateUserCode = fUpdateUserCode;
	}

	public BigInteger getFUpdateUserId() {
		return this.fUpdateUserId;
	}

	public void setFUpdateUserId(BigInteger fUpdateUserId) {
		this.fUpdateUserId = fUpdateUserId;
	}

	public String getFUpdateUserName() {
		return this.fUpdateUserName;
	}

	public void setFUpdateUserName(String fUpdateUserName) {
		this.fUpdateUserName = fUpdateUserName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}