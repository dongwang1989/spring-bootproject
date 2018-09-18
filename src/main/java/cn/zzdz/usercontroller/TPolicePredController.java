package cn.zzdz.usercontroller;

import java.io.IOException;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.dto.TPolicepredDto;
import cn.zzdz.interfaces.service.ITplolicePred;

@RestController
@RequestMapping("/policepred")
public class TPolicePredController {
	@Autowired
	public ITplolicePred red;

	@RequestMapping("/serachBy")
	public TPolicepredDto serachBy(TPolicepredDto params) {
		return red.eee(params);
	}

	@RequestMapping("/doRInt")
	public int doRInt() throws RserveException, REXPMismatchException, IOException {
		return red.doRInt();
	}

	@RequestMapping("/deldata")
	public int deldata() {
		return red.deldata();
	}

}
