package com.lagelanren.lottery.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.lagelanren.lottery.service.LotteryService;

@Configuration
@EnableScheduling
public class LotteryTask {
	
	@Autowired
	private LotteryService lotteryService;
	//每天十点
	//@Scheduled(cron="0 16 14 ? * 2,4,7")
	//每天凌晨12点
	@Scheduled(cron="0 0 0 ? * 2,4,7")
	private void configureTask() {
		lotteryService.datyTask();
	}
	
}
