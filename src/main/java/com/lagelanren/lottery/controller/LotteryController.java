package com.lagelanren.lottery.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lagelanren.lottery.entity.Lottery;
import com.lagelanren.lottery.entity.User;
import com.lagelanren.lottery.service.LotteryService;
import com.lagelanren.lottery.util.Query;

@Controller
public class LotteryController {
	private static Logger logger = Logger.getLogger(LotteryController.class);
	@Autowired
	private LotteryService lotteryService;
	
	@RequestMapping("/index")
	public String hello() {
		return "index";
	}
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/login")
	public String login1(Model model,String name) {
		logger.info(name + "  登录");
		User user = (User) lotteryService.getUserByUserName(name);
		if(user == null) {
			model.addAttribute("msg", "-1");
			return "login";
		}
		List<Lottery> lotteryList = lotteryService.getLotteryByUserId(user.getUserId());
		if(lotteryList.size() == 0) {
			model.addAttribute("lotteryList",null);
			model.addAttribute("lotteryTime",null);
			model.addAttribute("name",null);
			return "index";
		}
		model.addAttribute("lotteryList",lotteryList);
		model.addAttribute("lotteryTime",lotteryList.get(0).getLotteryTime());
		model.addAttribute("name",name);
		return "index";
	}
	
	
	
	@RequestMapping("/commit_infermation")
	public String CommitInfomation(Model model,String name,String luckNum,Double threshold,Integer num,Integer rule) {
		if(name.length()<=0) {
			model.addAttribute("msg",-1);
			return "register";
		}
		User user = (User) lotteryService.getUserByUserName(name);
		if(user != null) {
			model.addAttribute("msg",-1);
			return "register";
		}
		luckNum = luckNum.trim();
		while (luckNum.startsWith("　")) {//这里判断是不是全角空格
			luckNum = luckNum.substring(1, luckNum.length()).trim();
		}
		while (luckNum.endsWith("　")) {
			luckNum = luckNum.substring(0, luckNum.length() - 1).trim();
		}
		Integer state = lotteryService.saveUser(name, luckNum, threshold, num, rule);
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/openPrize")
	public String openPrize(String lotteryTime) {
		logger.info("查奖");
		Query queryP = new Query();
		return queryP.Get(lotteryTime);
	}
	
}
