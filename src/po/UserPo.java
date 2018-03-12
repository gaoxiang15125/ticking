package po;

import java.util.Date;

public class UserPo {
	/**
	 * VIP 会员等级
	 * password 是否经过验证
	 * 可以存储数据的对象
	 */
	private String userID;
	private String userName;
	private String email;
	private int vip;
	private double vip_vaule;
	private String sex;
	private String telphone;
	private String job;
	private Date birthday;
	private Date vipTime;
	private Boolean password;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Boolean getPassword() {
		return password;
	}
	public void setPassword(Boolean password) {
		this.password = password;
	}
	public double getVip_vaule() {
		return vip_vaule;
	}
	public void setVip_vaule(double vip_vaule) {
		this.vip_vaule = vip_vaule;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
}
