package cn.zzdz.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.zzdz.domain.NewsSinaHiscontent;

@Repository
public interface NewsJpa extends JpaRepository<NewsSinaHiscontent, String> {
	@Query("from NewsSinaHiscontent u ")
	public List<NewsSinaHiscontent> getNewLike(@Param("newsTitle") String newsTitle);

	@Query("from NewsSinaHiscontent u where u.newsId=:newsId ")
	public NewsSinaHiscontent getNewByid(@Param("newsId") String newsId);

	@Query("from NewsSinaHiscontent u  where u.newsTitle like %:newsTitle%")
	Page<NewsSinaHiscontent> findRoomUidsByUserIdPageable(@Param("newsTitle") String newsTitle, Pageable pageable);
}
