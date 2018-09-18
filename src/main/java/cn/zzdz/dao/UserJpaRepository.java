package cn.zzdz.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.zzdz.domain.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
	@Query("from User u where u.username=:username and u.pwd=:pwd")
	public User getUser(@Param("username") String username, @Param("pwd") String pwd);

	@Query("select u from User u where u.username=:username")
	public User findUserinfoBylog(@Param("username") String username);

	@Query("from User u where u.username=:username")
	public User findUserInfoByuser(@Param("username") String username);

	@Query("from User u  where u.id=:id")
	public User findUserPermission(@Param("id") Integer id);

	// @Query("select User from user_permission User where User.id=:id")
	// public List<User> ListfindUserinfo(@Param("id") Integer id);
	@Query("from User u where u.username like %:username%")
	public List<User> Likenames(@Param("username") String username);

	@Modifying
	@Query("delete from User where id=:id ")
	public int delUserInfo(@Param("id") int id);

	@Query("from User u where u.username like %:username%")
	Page<User> findRoomUidsByUserIdPageable(@Param("username") String username, Pageable pageable);

	@Query("from User u where u.username =:username and pwd=:pwd")
	public List<User> denglu(@Param("username") String username, @Param("pwd") String pwd);
}
