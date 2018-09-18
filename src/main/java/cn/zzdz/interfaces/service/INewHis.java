package cn.zzdz.interfaces.service;

import org.springframework.data.repository.query.Param;

import cn.zzdz.domain.NewsSinaHiscontent;
import cn.zzdz.dto.NewsDto;

public interface INewHis {
	public NewsDto newsLike(String newsTitle, int pageIndex, int pageSize);

	public NewsSinaHiscontent getNewByid(@Param("newsId") String newsId);
}
