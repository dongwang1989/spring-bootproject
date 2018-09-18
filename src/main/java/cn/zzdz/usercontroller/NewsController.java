package cn.zzdz.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zzdz.domain.NewsSinaHiscontent;
import cn.zzdz.dto.NewsDto;
import cn.zzdz.interfaces.service.INewHis;

@Service
@RestController
@RequestMapping("/new")
public class NewsController {
	@Autowired
	public INewHis newhis;

	@RequestMapping("/getnew")
	public NewsDto getnew(@RequestParam String newsTitle, @RequestParam int pageIndex, @RequestParam int pageSize) {
		return newhis.newsLike(newsTitle, pageIndex, pageSize);
	}

	@RequestMapping("/getNewByid")
	public NewsSinaHiscontent getNewByid(@RequestParam String newsId) {
		return newhis.getNewByid(newsId);
	}
}
