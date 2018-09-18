package cn.zzdz.dto;

import java.util.List;

public class CasDto {
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

	private int Pageindex;
	private int pagesize;
	private int totalpages;
	private List<CasDto> listdto;

	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public String getCAaddr() {
		return CAaddr;
	}

	public void setCAaddr(String cAaddr) {
		CAaddr = cAaddr;
	}

	public String getCAage() {
		return CAage;
	}

	public void setCAage(String cAage) {
		CAage = cAage;
	}

	public int getCAclusters() {
		return CAclusters;
	}

	public void setCAclusters(int cAclusters) {
		CAclusters = cAclusters;
	}

	public String getCAGender() {
		return CAGender;
	}

	public void setCAGender(String cAGender) {
		CAGender = cAGender;
	}

	public String getCAjob() {
		return CAjob;
	}

	public void setCAjob(String cAjob) {
		CAjob = cAjob;
	}

	public String getCAmode() {
		return CAmode;
	}

	public void setCAmode(String cAmode) {
		CAmode = cAmode;
	}

	public String getCAot() {
		return CAot;
	}

	public void setCAot(String cAot) {
		CAot = cAot;
	}

	public String getCApro() {
		return CApro;
	}

	public void setCApro(String cApro) {
		CApro = cApro;
	}

	public String getCAtime() {
		return CAtime;
	}

	public void setCAtime(String cAtime) {
		CAtime = cAtime;
	}

	public int getPageindex() {
		return Pageindex;
	}

	public void setPageindex(int pageindex) {
		Pageindex = pageindex;
	}

	public List<CasDto> getListdto() {
		return listdto;
	}

	public void setListdto(List<CasDto> listdto) {
		this.listdto = listdto;
	}

	public int getTotpageSize() {
		return totalpages;
	}

	public void setTotpageSize(int totpageSize) {
		totalpages = totpageSize;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
}
