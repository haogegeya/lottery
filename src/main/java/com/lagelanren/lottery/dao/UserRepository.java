package com.lagelanren.lottery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lagelanren.lottery.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("from User s where s.name=:name")
	User getUserByName(@Param("name") String name);
}
