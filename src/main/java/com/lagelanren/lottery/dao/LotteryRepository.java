package com.lagelanren.lottery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lagelanren.lottery.entity.Lottery;
import com.lagelanren.lottery.entity.User;

public interface LotteryRepository extends JpaRepository<Lottery, Long>{
	@Query(nativeQuery=true, value = "select * from lottery s where s.user_id=:userId and s.lottery_time =:lotteryTime")
	List<Lottery> getLotteryByUserId(@Param("userId") Integer userId,@Param("lotteryTime") Integer lotteryTime);
	
	@Query(nativeQuery=true, value = "select lottery_time from lottery s order by s.lottery_time desc limit 1")
	Integer getMixLotteryTime();
}

