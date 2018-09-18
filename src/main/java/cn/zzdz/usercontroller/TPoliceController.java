package cn.zzdz.usercontroller;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.dto.TPoliceDto;
import cn.zzdz.interfaces.service.ITplolice;

@Service
@RestController
@RequestMapping("/police")
public class TPoliceController {
	@Autowired // 如果用set方法加AutoWired那么他会自动给你把这个对象调用的地方都改过来。
	private ITplolice tpService;

	@RequestMapping("/getAll")
	public TPoliceDto getAll(@RequestParam int pageindex, @RequestParam int pagesize) {
		TPoliceDto tpdto = tpService.getAll(pageindex, pagesize);
		return tpdto;
	}

	@RequestMapping("/doR")
	public TPoliceDto doR() throws RserveException, REXPMismatchException {
		TPoliceDto jieguo = tpService.doR();
		return jieguo;
	}

	@RequestMapping("/doRInt")
	public int doRInt() throws RserveException, REXPMismatchException {
		// TPoliceDto jieguo = tpService.doR();
		return tpService.doRInt();
	}

	@RequestMapping("/suana")
	public int getvalue() throws RserveException, REXPMismatchException {
		// TPoliceDto jieguo = tpService.doR();
		return tpService.shuju(1, 2);
	}

	@RequestMapping("/wuxianzhi") //
	public TPoliceDto eee(TPoliceDto param) {
		// System.out.println(param.getfAlarmDate());
		return tpService.eee(param);
	}
}
