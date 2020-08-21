package com.lagelanren.lottery.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Lottery")
public class Lottery {
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
    private Integer lotteryId;
	
	//时间
	private Date createTime;
	
	//期数
	private Integer lotteryTime;
	
	//彩票
	private String lotteryNum;
	
	//是否中
	private Integer isWin;
	
	//用户
	private Integer userId;

	public Integer getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(Integer lotteryId) {
		this.lotteryId = lotteryId;
	}


	public String getLotteryNum() {
		return lotteryNum;
	}

	public Integer getLotteryTime() {
		return lotteryTime;
	}

	public void setLotteryNum(String lotteryNum) {
		this.lotteryNum = lotteryNum;
	}

	public Integer getIsWin() {
		return isWin;
	}

	public void setIsWin(Integer isWin) {
		this.isWin = isWin;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setLotteryTime(Integer lotteryTime) {
		this.lotteryTime = lotteryTime;
	}
	
	
	
}
