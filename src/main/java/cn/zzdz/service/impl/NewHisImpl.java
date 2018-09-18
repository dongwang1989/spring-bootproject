package cn.zzdz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.zzdz.dao.NewsJpa;
import cn.zzdz.domain.NewsSinaHiscontent;
import cn.zzdz.dto.NewsDto;
import cn.zzdz.interfaces.service.INewHis;

@Service
public class NewHisImpl implements INewHis {
	@Autowired
	public NewsJpa newsjpa;

	@Override
	public NewsDto newsLike(String newsTitle, int pageIndex, int pageSize) {
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(pageIndex - 1, pageSize);
		Page<NewsSinaHiscontent> page = newsjpa.findRoomUidsByUserIdPageable(newsTitle, pageable);
		List<NewsSinaHiscontent> roomUids = page.getContent();
		// page.getTotalElements();
		// System.out.println(page.getTotalPages());
		NewsDto dto = new NewsDto();
		dto.setTotalcount(page.getTotalElements());
		dto.setList(roomUids);
		return dto;
	}

	@Override
	public NewsSinaHiscontent getNewByid(String newsId) {
		NewsSinaHiscontent con = newsjpa.getNewByid(newsId);
		System.out.println(con.getNewsPaTime());
		return con;
	}

}
