package cn.zzdz.interfaces.service;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.transaction.annotation.Transactional;

import cn.zzdz.dto.TPolicepredDto;

public interface ITplolicePred {
	public TPolicepredDto getAll(int pageindex, int pagesize);

	public TPolicepredDto doR() throws RserveException, REXPMismatchException;

	public TPolicepredDto eee(final TPolicepredDto param);

	@Transactional
	public int doRInt() throws RserveException, REXPMismatchException;

	public int deldata();

}
