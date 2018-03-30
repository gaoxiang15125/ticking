package com.wgh.model;

import java.sql.Date;
import java.util.Vector;

import po.OrderStatus;

public class OrderVo {

	private String orderID;
	private double money_coust;
	private Date order_time;
	private String  purchase_path;
	private Vector<SeatPo> seatPos;
	private String orderStatus;
	//推荐使用的构造方法，避免有属性没有赋值
	public OrderVo( String orderID,double money_coust, Date order_time,String  purchase_path,
	 Vector<SeatPo> seatPos,String orderStatus) {
		this.orderID = orderID;
		this.money_coust =money_coust;
		this.order_time = order_time;
		this.purchase_path = purchase_path;
		this.seatPos = seatPos;
		this.orderStatus = orderStatus;
	}
	
	public OrderVo () {
		seatPos = new Vector<SeatPo>();
	}
	
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public double getMoney_coust() {
		return money_coust;
	}
	public void setMoney_coust(double money_coust) {
		this.money_coust = money_coust;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getPurchase_path() {
		return purchase_path;
	}
	public void setPurchase_path(String purchase_path) {
		this.purchase_path = purchase_path;
	}
	public Vector<SeatPo> getSeatPos() {
		return seatPos;
	}
	public void setSeatPos(Vector<SeatPo> seatPos) {
		this.seatPos = seatPos;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
