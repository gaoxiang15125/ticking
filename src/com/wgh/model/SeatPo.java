package com.wgh.model;

public class SeatPo {

	private String SeatID;
	private int seatGrade;
	private String strategyID;
	private String status;
	private String orderID;
	public String getSeatID() {
		return SeatID;
	}
	public void setSeatID(String seatID) {
		SeatID = seatID;
	}
	public int getSeatGrade() {
		return seatGrade;
	}
	public void setSeatGrade(int seatGrade) {
		this.seatGrade = seatGrade;
	}
	public String getStrategyID() {
		return strategyID;
	}
	public void setStrategyID(String strategyID) {
		this.strategyID = strategyID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	
}
