package cn.zzdz.interfaces.service;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;

import cn.zzdz.dto.TPoliceDto;

public interface ITplolice {
	public TPoliceDto getAll(int pageindex, int pagesize);

	public TPoliceDto doR() throws RserveException, REXPMismatchException;

	public int doRInt() throws RserveException, REXPMismatchException;

	public TPoliceDto eee(final TPoliceDto param);

	public int shuju(int a, int b) throws RserveException, REXPMismatchException;

}
