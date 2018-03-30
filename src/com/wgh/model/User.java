package com.wgh.model;

import java.util.Date;

public class User {
	private int id = 0;// 用户ID
	private String username = "";// 用户名
	private String pwd = "";// 密码
	private String email = "";// E-mail地址
	private String question = "";// 密码提示问题
	private String answer = "";// 密码提示问题答案
	private String city = "";// 所在地
	private int vip;
	private double vip_vaule;
	private String sex;
	private String telphone;
	private String job;
	private Date birthday;
	private Date vipTime;
	

	public double getVip_vaule() {
		return vip_vaule;
	}
	public void setVip_vaule(double vip_vaule) {
		this.vip_vaule = vip_vaule;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getVipTime() {
		return vipTime;
	}
	public void setVipTime(Date vipTime) {
		this.vipTime = vipTime;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
