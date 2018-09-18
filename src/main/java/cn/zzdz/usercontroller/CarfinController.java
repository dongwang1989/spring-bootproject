package cn.zzdz.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.dto.CarfinDto;
import cn.zzdz.interfaces.service.ICarfin;

@RestController
@RequestMapping("/carfin")
public class CarfinController {
	@Autowired
	private ICarfin carfin;

	@RequestMapping("/getall")
	public CarfinDto getall(CarfinDto param) {
		return carfin.getall(param);
	}
}
