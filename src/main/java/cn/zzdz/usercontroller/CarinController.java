package cn.zzdz.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.dto.CarinDto;
import cn.zzdz.interfaces.service.ICarin;

@Service
@RestController
@RequestMapping("/carin")
public class CarinController {
	@Autowired
	private ICarin carin;

	@RequestMapping("/getall")
	public CarinDto getall(CarinDto param) {
		System.out.println(123);
		return carin.getall(param);
	}
}
