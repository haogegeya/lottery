package com.lagelanren.lottery.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lagelanren.lottery.dao.LotteryRepository;
import com.lagelanren.lottery.dao.UserRepository;
import com.lagelanren.lottery.entity.Lottery;
import com.lagelanren.lottery.entity.User;
import com.lagelanren.lottery.service.LotteryService;
import com.lagelanren.lottery.util.Ssq;

@Service
public class LotterServiceImpl implements LotteryService {

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LotteryRepository lotteryRepository;
	
	@Override
	public Integer saveUser(String name, String luckNum, Double threshold, Integer num, Integer rule) {
		// TODO Auto-generated method stub
		String[] luckNumList = luckNum.split(" ");
		User user = new User();
		user.setCreateTime(new Date());
		user.setLuckNum(luckNum);
		user.setThreshold(threshold);
		user.setName(name);
		user.setNum(num);
		user.setRule(rule);
		user.setIsOpen(1);
		try {
			userRepository.saveAndFlush(user);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void datyTask() {
		// TODO Auto-generated method stub
		List<User> userList = (List<User>)userRepository.findAll();
		int lotteryTime = lotteryRepository.getMixLotteryTime();
		lotteryTime += 1;
		Ssq ssq = new Ssq();
		for(User user:userList) {
			String luckNum = user.getLuckNum();
			String[] luckNumList = luckNum.split(" ");
			int numList[] = new int[luckNumList.length];
			for(int i=0;i<luckNumList.length;i++) {
				numList[i] = Integer.valueOf(luckNumList[i]);
			}
			List<Lottery> lotteryList = new ArrayList();
			for(int k=0;k<user.getNum();k++) {
				String hm = ssq.getYZHM(user.getLuckNum(),user.getThreshold());
				Lottery lottery = new Lottery();
				lottery.setIsWin(0);
				lottery.setUserId(user.getUserId());
				lottery.setLotteryNum(hm);
				lottery.setLotteryTime(lotteryTime);			
				lotteryList.add(lottery);	
			}
			try {
				lotteryRepository.save(lotteryList);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

	@Override
	public List<Lottery> getLotteryByUserId(Integer userId) {
		// TODO Auto-generated method stub
		Integer lotteryMix = lotteryRepository.getMixLotteryTime();
		List<Lottery> lotteryList = (List<Lottery>) lotteryRepository.getLotteryByUserId(userId,lotteryMix);
		return lotteryList;
	}

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByName(userName);
		return user;
	}

}
