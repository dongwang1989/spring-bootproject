package cn.zzdz.interfaces.service;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;

import cn.zzdz.dto.CasDto;

public interface ICas {
	// public CasDto findcasBysearch(int pageindex, int pagesize, String CAtime,
	// String CAot);

	public CasDto getall(CasDto param);

	public CasDto doR() throws RserveException, REXPMismatchException;
}
