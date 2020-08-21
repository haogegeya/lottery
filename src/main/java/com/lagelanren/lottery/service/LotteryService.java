package com.lagelanren.lottery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lagelanren.lottery.entity.Lottery;
import com.lagelanren.lottery.entity.User;

public interface LotteryService {
	Integer saveUser(String name,String luckNum,Double threshold,Integer num,Integer rule);
	void datyTask();
	List<Lottery> getLotteryByUserId(Integer userId);
	User getUserByUserName(String userName);
}
