package cn.zzdz.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the carfin database table.
 * 
 */
@Entity
@NamedQuery(name="Carfin.findAll", query="SELECT c FROM Carfin c")
public class Carfin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARFIN_EVENTLOGID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARFIN_EVENTLOGID_GENERATOR")
	private String eventLogId;

	private int colorDepth;

	private String createTime;

	private int detsceneId;

	private int driveChan;

	private int entireBelieve;

	private int eventLevel;

	private String eventLogSysCode;

	private String eventName;

	private int eventState;

	private String eventTypeName;

	private BigInteger id;

	private int illegalType;

	private int length;

	private String license;

	private int licenseLen;

	private int logoRecog;

	private String logTxt;

	private int myeventType;

	private int mytrigger;

	private String picUrl1;

	private String picUrl2;

	private int platColor;

	private String platColorName;

	private int platType;

	private String platTypeName;

	private String regionSysCode;

	private String sourceName;

	private String sourceSysCode;

	private int sourceType;

	private int speed;

	private String startTime;

	private String stopTime;

	private int subLogoRecog;

	private String unitSysCode;

	private int vehicleColor;

	private String vehicleColorName;

	private int vehicleIndex;

	private int vehicleType;

	private String vehicleTypeName;

	public Carfin() {
	}

	public String getEventLogId() {
		return this.eventLogId;
	}

	public void setEventLogId(String eventLogId) {
		this.eventLogId = eventLogId;
	}

	public int getColorDepth() {
		return this.colorDepth;
	}

	public void setColorDepth(int colorDepth) {
		this.colorDepth = colorDepth;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getDetsceneId() {
		return this.detsceneId;
	}

	public void setDetsceneId(int detsceneId) {
		this.detsceneId = detsceneId;
	}

	public int getDriveChan() {
		return this.driveChan;
	}

	public void setDriveChan(int driveChan) {
		this.driveChan = driveChan;
	}

	public int getEntireBelieve() {
		return this.entireBelieve;
	}

	public void setEntireBelieve(int entireBelieve) {
		this.entireBelieve = entireBelieve;
	}

	public int getEventLevel() {
		return this.eventLevel;
	}

	public void setEventLevel(int eventLevel) {
		this.eventLevel = eventLevel;
	}

	public String getEventLogSysCode() {
		return this.eventLogSysCode;
	}

	public void setEventLogSysCode(String eventLogSysCode) {
		this.eventLogSysCode = eventLogSysCode;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getEventState() {
		return this.eventState;
	}

	public void setEventState(int eventState) {
		this.eventState = eventState;
	}

	public String getEventTypeName() {
		return this.eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public int getIllegalType() {
		return this.illegalType;
	}

	public void setIllegalType(int illegalType) {
		this.illegalType = illegalType;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public int getLicenseLen() {
		return this.licenseLen;
	}

	public void setLicenseLen(int licenseLen) {
		this.licenseLen = licenseLen;
	}

	public int getLogoRecog() {
		return this.logoRecog;
	}

	public void setLogoRecog(int logoRecog) {
		this.logoRecog = logoRecog;
	}

	public String getLogTxt() {
		return this.logTxt;
	}

	public void setLogTxt(String logTxt) {
		this.logTxt = logTxt;
	}

	public int getMyeventType() {
		return this.myeventType;
	}

	public void setMyeventType(int myeventType) {
		this.myeventType = myeventType;
	}

	public int getMytrigger() {
		return this.mytrigger;
	}

	public void setMytrigger(int mytrigger) {
		this.mytrigger = mytrigger;
	}

	public String getPicUrl1() {
		return this.picUrl1;
	}

	public void setPicUrl1(String picUrl1) {
		this.picUrl1 = picUrl1;
	}

	public String getPicUrl2() {
		return this.picUrl2;
	}

	public void setPicUrl2(String picUrl2) {
		this.picUrl2 = picUrl2;
	}

	public int getPlatColor() {
		return this.platColor;
	}

	public void setPlatColor(int platColor) {
		this.platColor = platColor;
	}

	public String getPlatColorName() {
		return this.platColorName;
	}

	public void setPlatColorName(String platColorName) {
		this.platColorName = platColorName;
	}

	public int getPlatType() {
		return this.platType;
	}

	public void setPlatType(int platType) {
		this.platType = platType;
	}

	public String getPlatTypeName() {
		return this.platTypeName;
	}

	public void setPlatTypeName(String platTypeName) {
		this.platTypeName = platTypeName;
	}

	public String getRegionSysCode() {
		return this.regionSysCode;
	}

	public void setRegionSysCode(String regionSysCode) {
		this.regionSysCode = regionSysCode;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceSysCode() {
		return this.sourceSysCode;
	}

	public void setSourceSysCode(String sourceSysCode) {
		this.sourceSysCode = sourceSysCode;
	}

	public int getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(int sourceType) {
		this.sourceType = sourceType;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public int getSubLogoRecog() {
		return this.subLogoRecog;
	}

	public void setSubLogoRecog(int subLogoRecog) {
		this.subLogoRecog = subLogoRecog;
	}

	public String getUnitSysCode() {
		return this.unitSysCode;
	}

	public void setUnitSysCode(String unitSysCode) {
		this.unitSysCode = unitSysCode;
	}

	public int getVehicleColor() {
		return this.vehicleColor;
	}

	public void setVehicleColor(int vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getVehicleColorName() {
		return this.vehicleColorName;
	}

	public void setVehicleColorName(String vehicleColorName) {
		this.vehicleColorName = vehicleColorName;
	}

	public int getVehicleIndex() {
		return this.vehicleIndex;
	}

	public void setVehicleIndex(int vehicleIndex) {
		this.vehicleIndex = vehicleIndex;
	}

	public int getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleTypeName() {
		return this.vehicleTypeName;
	}

	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}

    @Override
    public String toString() {
        return "Carfin{" +
                "eventLogId='" + eventLogId + '\'' +
                ", colorDepth=" + colorDepth +
                ", createTime='" + createTime + '\'' +
                ", detsceneId=" + detsceneId +
                ", driveChan=" + driveChan +
                ", entireBelieve=" + entireBelieve +
                ", eventLevel=" + eventLevel +
                ", eventLogSysCode='" + eventLogSysCode + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventState=" + eventState +
                ", eventTypeName='" + eventTypeName + '\'' +
                ", id=" + id +
                ", illegalType=" + illegalType +
                ", length=" + length +
                ", license='" + license + '\'' +
                ", licenseLen=" + licenseLen +
                ", logoRecog=" + logoRecog +
                ", logTxt='" + logTxt + '\'' +
                ", myeventType=" + myeventType +
                ", mytrigger=" + mytrigger +
                ", picUrl1='" + picUrl1 + '\'' +
                ", picUrl2='" + picUrl2 + '\'' +
                ", platColor=" + platColor +
                ", platColorName='" + platColorName + '\'' +
                ", platType=" + platType +
                ", platTypeName='" + platTypeName + '\'' +
                ", regionSysCode='" + regionSysCode + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", sourceSysCode='" + sourceSysCode + '\'' +
                ", sourceType=" + sourceType +
                ", speed=" + speed +
                ", startTime='" + startTime + '\'' +
                ", stopTime='" + stopTime + '\'' +
                ", subLogoRecog=" + subLogoRecog +
                ", unitSysCode='" + unitSysCode + '\'' +
                ", vehicleColor=" + vehicleColor +
                ", vehicleColorName='" + vehicleColorName + '\'' +
                ", vehicleIndex=" + vehicleIndex +
                ", vehicleType=" + vehicleType +
                ", vehicleTypeName='" + vehicleTypeName + '\'' +
                '}';
    }
}