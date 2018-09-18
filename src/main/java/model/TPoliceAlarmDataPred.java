package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_police_alarm_data_pred database table.
 * 
 */
@Entity
@Table(name="t_police_alarm_data_pred")
@NamedQuery(name="TPoliceAlarmDataPred.findAll", query="SELECT t FROM TPoliceAlarmDataPred t")
public class TPoliceAlarmDataPred implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="F_ALARM_DATE")
	private String fAlarmDate;

	@Column(name="F_ALARM_TYPE")
	private String fAlarmType;

	@Column(name="F_BURGLARY")
	private String fBurglary;

	@Column(name="F_COMMUNITY_CODE")
	private String fCommunityCode;

	@Column(name="F_COMMUNITY_ID")
	private String fCommunityId;

	@Column(name="F_COMMUNITY_NAME")
	private String fCommunityName;

	@Column(name="F_ELECTRIC")
	private String fElectric;

	@Column(name="F_FRAUD")
	private String fFraud;

	@Column(name="F_GRAB")
	private String fGrab;

	@Column(name="F_INPUT_DATE")
	private String fInputDate;

	@Column(name="F_INPUT_USER_CODE")
	private String fInputUserCode;

	@Column(name="F_INPUT_USER_ID")
	private String fInputUserId;

	@Column(name="F_INPUT_USER_NAME")
	private String fInputUserName;

	@Column(name="F_NOTE")
	private String fNote;

	@Column(name="F_ORG_CODE")
	private String fOrgCode;

	@Column(name="F_ORG_ID")
	private String fOrgId;

	@Column(name="F_ORG_NAME")
	private String fOrgName;

	@Column(name="F_OTHER")
	private String fOther;

	@Column(name="F_PICK")
	private String fPick;

	@Column(name="F_PROPERTY")
	private String fProperty;

	@Column(name="F_ROB")
	private String fRob;

	@Column(name="F_THEFTCAR")
	private String fTheftcar;

	@Column(name="F_TIMES")
	private String fTimes;

	@Column(name="F_UPDATE_DATE")
	private String fUpdateDate;

	@Column(name="F_UPDATE_USER_CODE")
	private String fUpdateUserCode;

	@Column(name="F_UPDATE_USER_ID")
	private String fUpdateUserId;

	@Column(name="F_UPDATE_USER_NAME")
	private String fUpdateUserName;

	private String version;

	public TPoliceAlarmDataPred() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFAlarmDate() {
		return this.fAlarmDate;
	}

	public void setFAlarmDate(String fAlarmDate) {
		this.fAlarmDate = fAlarmDate;
	}

	public String getFAlarmType() {
		return this.fAlarmType;
	}

	public void setFAlarmType(String fAlarmType) {
		this.fAlarmType = fAlarmType;
	}

	public String getFBurglary() {
		return this.fBurglary;
	}

	public void setFBurglary(String fBurglary) {
		this.fBurglary = fBurglary;
	}

	public String getFCommunityCode() {
		return this.fCommunityCode;
	}

	public void setFCommunityCode(String fCommunityCode) {
		this.fCommunityCode = fCommunityCode;
	}

	public String getFCommunityId() {
		return this.fCommunityId;
	}

	public void setFCommunityId(String fCommunityId) {
		this.fCommunityId = fCommunityId;
	}

	public String getFCommunityName() {
		return this.fCommunityName;
	}

	public void setFCommunityName(String fCommunityName) {
		this.fCommunityName = fCommunityName;
	}

	public String getFElectric() {
		return this.fElectric;
	}

	public void setFElectric(String fElectric) {
		this.fElectric = fElectric;
	}

	public String getFFraud() {
		return this.fFraud;
	}

	public void setFFraud(String fFraud) {
		this.fFraud = fFraud;
	}

	public String getFGrab() {
		return this.fGrab;
	}

	public void setFGrab(String fGrab) {
		this.fGrab = fGrab;
	}

	public String getFInputDate() {
		return this.fInputDate;
	}

	public void setFInputDate(String fInputDate) {
		this.fInputDate = fInputDate;
	}

	public String getFInputUserCode() {
		return this.fInputUserCode;
	}

	public void setFInputUserCode(String fInputUserCode) {
		this.fInputUserCode = fInputUserCode;
	}

	public String getFInputUserId() {
		return this.fInputUserId;
	}

	public void setFInputUserId(String fInputUserId) {
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

	public String getFOrgId() {
		return this.fOrgId;
	}

	public void setFOrgId(String fOrgId) {
		this.fOrgId = fOrgId;
	}

	public String getFOrgName() {
		return this.fOrgName;
	}

	public void setFOrgName(String fOrgName) {
		this.fOrgName = fOrgName;
	}

	public String getFOther() {
		return this.fOther;
	}

	public void setFOther(String fOther) {
		this.fOther = fOther;
	}

	public String getFPick() {
		return this.fPick;
	}

	public void setFPick(String fPick) {
		this.fPick = fPick;
	}

	public String getFProperty() {
		return this.fProperty;
	}

	public void setFProperty(String fProperty) {
		this.fProperty = fProperty;
	}

	public String getFRob() {
		return this.fRob;
	}

	public void setFRob(String fRob) {
		this.fRob = fRob;
	}

	public String getFTheftcar() {
		return this.fTheftcar;
	}

	public void setFTheftcar(String fTheftcar) {
		this.fTheftcar = fTheftcar;
	}

	public String getFTimes() {
		return this.fTimes;
	}

	public void setFTimes(String fTimes) {
		this.fTimes = fTimes;
	}

	public String getFUpdateDate() {
		return this.fUpdateDate;
	}

	public void setFUpdateDate(String fUpdateDate) {
		this.fUpdateDate = fUpdateDate;
	}

	public String getFUpdateUserCode() {
		return this.fUpdateUserCode;
	}

	public void setFUpdateUserCode(String fUpdateUserCode) {
		this.fUpdateUserCode = fUpdateUserCode;
	}

	public String getFUpdateUserId() {
		return this.fUpdateUserId;
	}

	public void setFUpdateUserId(String fUpdateUserId) {
		this.fUpdateUserId = fUpdateUserId;
	}

	public String getFUpdateUserName() {
		return this.fUpdateUserName;
	}

	public void setFUpdateUserName(String fUpdateUserName) {
		this.fUpdateUserName = fUpdateUserName;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}