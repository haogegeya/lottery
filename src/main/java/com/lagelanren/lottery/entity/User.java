package com.lagelanren.lottery.entity;


	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.Transient;

	import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table(name="User")
	public class User {
		@Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    @GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	    //@Column(name="USER_ID")
	    private Integer userId;
		
		//创建时间
		//@Column(name="CREATE_TIME")
		private Date createTime;
		
		//姓名
		//@Column(name="NAME",length=50)
		private String name;
		
		//图片
		//@Column(name="PICTURE",length=100)
		private String picture;
		
		//幸运数字
		private String luckNum;
		
		//注数
		private Integer num;
		
		//概率
		private Double threshold;
		
		//规则
		private Integer rule;
		
		//是否启用
		//@Column(name="IS_OPEN")
		private Integer isOpen;

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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPicture() {
			return picture;
		}

		public void setPicture(String picture) {
			this.picture = picture;
		}

		public String getLuckNum() {
			return luckNum;
		}

		public void setLuckNum(String luckNum) {
			this.luckNum = luckNum;
		}

		public Double getThreshold() {
			return threshold;
		}

		public void setThreshold(Double threshold) {
			this.threshold = threshold;
		}

		public Integer getRule() {
			return rule;
		}

		public void setRule(Integer rule) {
			this.rule = rule;
		}

		public Integer getIsOpen() {
			return isOpen;
		}

		public void setIsOpen(Integer isOpen) {
			this.isOpen = isOpen;
		}

		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}
	}
