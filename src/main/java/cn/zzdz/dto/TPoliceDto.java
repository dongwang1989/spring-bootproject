package cn.zzdz.dto;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class TPoliceDto {
	private String id;
	private Integer pageindex;
	private Integer pagesize;
	@DateTimeFormat(iso = ISO.DATE)
	private Date fAlarmDate;

	private String fAlarmType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getfAlarmDate() {
		return fAlarmDate;
	}

	public void setfAlarmDate(Date fAlarmDate) {
		this.fAlarmDate = fAlarmDate;
	}

	public String getfAlarmType() {
		return fAlarmType;
	}

	public void setfAlarmType(String fAlarmType) {
		this.fAlarmType = fAlarmType;
	}

	public int getfBurglary() {
		return fBurglary;
	}

	public void setfBurglary(int fBurglary) {
		this.fBurglary = fBurglary;
	}

	public String getfCommunityCode() {
		return fCommunityCode;
	}

	public void setfCommunityCode(String fCommunityCode) {
		this.fCommunityCode = fCommunityCode;
	}

	public Integer getfCommunityId() {
		return fCommunityId;
	}

	public void setfCommunityId(Integer fCommunityId) {
		this.fCommunityId = fCommunityId;
	}

	public String getfCommunityName() {
		return fCommunityName;
	}

	public void setfCommunityName(String fCommunityName) {
		this.fCommunityName = fCommunityName;
	}

	public int getfElectric() {
		return fElectric;
	}

	public void setfElectric(int fElectric) {
		this.fElectric = fElectric;
	}

	public int getfFraud() {
		return fFraud;
	}

	public void setfFraud(int fFraud) {
		this.fFraud = fFraud;
	}

	public int getfGrab() {
		return fGrab;
	}

	public void setfGrab(int fGrab) {
		this.fGrab = fGrab;
	}

	public Date getfInputDate() {
		return fInputDate;
	}

	public void setfInputDate(Date fInputDate) {
		this.fInputDate = fInputDate;
	}

	public String getfInputUserCode() {
		return fInputUserCode;
	}

	public void setfInputUserCode(String fInputUserCode) {
		this.fInputUserCode = fInputUserCode;
	}

	public BigInteger getfInputUserId() {
		return fInputUserId;
	}

	public void setfInputUserId(BigInteger fInputUserId) {
		this.fInputUserId = fInputUserId;
	}

	public String getfInputUserName() {
		return fInputUserName;
	}

	public void setfInputUserName(String fInputUserName) {
		this.fInputUserName = fInputUserName;
	}

	public String getfNote() {
		return fNote;
	}

	public void setfNote(String fNote) {
		this.fNote = fNote;
	}

	public String getfOrgCode() {
		return fOrgCode;
	}

	public void setfOrgCode(String fOrgCode) {
		this.fOrgCode = fOrgCode;
	}

	public BigInteger getfOrgId() {
		return fOrgId;
	}

	public void setfOrgId(BigInteger fOrgId) {
		this.fOrgId = fOrgId;
	}

	public String getfOrgName() {
		return fOrgName;
	}

	public void setfOrgName(String fOrgName) {
		this.fOrgName = fOrgName;
	}

	public int getfOther() {
		return fOther;
	}

	public void setfOther(int fOther) {
		this.fOther = fOther;
	}

	public int getfPick() {
		return fPick;
	}

	public void setfPick(int fPick) {
		this.fPick = fPick;
	}

	public int getfProperty() {
		return fProperty;
	}

	public void setfProperty(int fProperty) {
		this.fProperty = fProperty;
	}

	public int getfRob() {
		return fRob;
	}

	public void setfRob(int fRob) {
		this.fRob = fRob;
	}

	public int getfTheftcar() {
		return fTheftcar;
	}

	public void setfTheftcar(int fTheftcar) {
		this.fTheftcar = fTheftcar;
	}

	public int getfTimes() {
		return fTimes;
	}

	public void setfTimes(int fTimes) {
		this.fTimes = fTimes;
	}

	public Date getfUpdateDate() {
		return fUpdateDate;
	}

	public void setfUpdateDate(Date fUpdateDate) {
		this.fUpdateDate = fUpdateDate;
	}

	public String getfUpdateUserCode() {
		return fUpdateUserCode;
	}

	public void setfUpdateUserCode(String fUpdateUserCode) {
		this.fUpdateUserCode = fUpdateUserCode;
	}

	public BigInteger getfUpdateUserId() {
		return fUpdateUserId;
	}

	public void setfUpdateUserId(BigInteger fUpdateUserId) {
		this.fUpdateUserId = fUpdateUserId;
	}

	public String getfUpdateUserName() {
		return fUpdateUserName;
	}

	public void setfUpdateUserName(String fUpdateUserName) {
		this.fUpdateUserName = fUpdateUserName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<TPoliceDto> getLisdto() {
		return lisdto;
	}

	public void setLisdto(List<TPoliceDto> lisdto) {
		this.lisdto = lisdto;
	}

	public int getTotalpages() {
		return totalpages;
	}

	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}

	public Integer getPageindex() {
		return pageindex;
	}

	public void setPageindex(Integer pageindex) {
		this.pageindex = pageindex;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	private int totalpages;
	private List<TPoliceDto> lisdto;
	private int fBurglary;

	private String fCommunityCode;

	private Integer fCommunityId;

	private String fCommunityName;

	private int fElectric;

	private int fFraud;

	private int fGrab;

	private Date fInputDate;

	private String fInputUserCode;

	private BigInteger fInputUserId;

	private String fInputUserName;

	private String fNote;

	private String fOrgCode;

	private BigInteger fOrgId;

	private String fOrgName;

	private int fOther;

	private int fPick;

	private int fProperty;

	private int fRob;

	private int fTheftcar;

	private int fTimes;

	private Date fUpdateDate;

	private String fUpdateUserCode;

	private BigInteger fUpdateUserId;

	private String fUpdateUserName;

	private int version;
}
