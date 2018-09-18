package cn.zzdz.dto;

import java.util.List;

import cn.zzdz.domain.NewsSinaHiscontent;

public class NewsDto {
	private long totalcount;
	private List<NewsSinaHiscontent> list;

	public long getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(long totalcount) {
		this.totalcount = totalcount;
	}

	public List<NewsSinaHiscontent> getList() {
		return list;
	}

	public void setList(List<NewsSinaHiscontent> list) {
		this.list = list;
	}

}
