package cn.zzdz.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.dto.ViewcarlicenseDto;
import cn.zzdz.interfaces.service.IViewcarlicense;

@Service
@RestController
@RequestMapping("/car")
public class ViewcarlicenseController {
	@Autowired
	private IViewcarlicense vie;

	@RequestMapping("/getall")
	public ViewcarlicenseDto getall(ViewcarlicenseDto param) {
		return vie.getall(param);
	}
}
