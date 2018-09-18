package cn.zzdz.usercontroller;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.dto.CasDto;
import cn.zzdz.interfaces.service.ICas;

@Service
@RestController
@RequestMapping("/cas")
public class CasController {
	@Autowired // 如果用set方法加AutoWired那么他会自动给你把这个对象调用的地方都改过来。
	private ICas casService;

	@RequestMapping("/getcasDtoByser")
	public CasDto getcasDtoByser(@RequestParam int pageindex, @RequestParam int pagesize, @RequestParam String CAtime,
			@RequestParam String CAot) {
		// CasDto casdto = casService.findcasBysearch(pageindex, pagesize, CAtime,
		// CAot);
		return null;
	}

	@RequestMapping("/getall")
	public CasDto getcasDtoByser(CasDto param) {
		CasDto casdto = casService.getall(param);
		return casdto;
	}

	@RequestMapping("/doR")
	public void doR() throws RserveException, REXPMismatchException {
		casService.doR();

	}

}
