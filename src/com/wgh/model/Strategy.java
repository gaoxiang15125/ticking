package com.wgh.model;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Date;
import java.util.EnumMap;

import po.StrategyType;


public class Strategy {
	
	private String strategy_Description;
	private Date time_begin;
	private Date time_end;
	//活动类别
	private String type;
	//座位价格表
	private double[] seatPrice = new double[3];
	//type 为满减时所需要的数据
	private double[] full = new double[2];
	//type 为满送时候所需要的数据
	private String fullgiven;
	//type 为优惠比例时所需要的数据
	private double cheaper;
	//type 为特别优惠时所需要的数据
	private double[] superPrice = new double[2];
	//场馆信息（所属场馆）
	private String venueName;
	private String venueID;
	//活动ID
	private String strategyID;
	
	public String getStrategyID() {
		return strategyID;
	}
	public void setStrategyID(String strategyID) {
		this.strategyID = strategyID;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenueID() {
		return venueID;
	}
	public void setVenueID(String venueID) {
		this.venueID = venueID;
	}
	public Strategy(String strategy_Description,Date time_begin,Date time_end,String type,
			double[] seatPrice,double[] full,String fullgiven,double cheaper,
			double[] superPrice) {
		this.strategy_Description = strategy_Description;
		this.time_begin = time_begin;
		this.time_end = time_end;
		this.type = type;
		this.seatPrice = seatPrice;
		this.full = full;
		this.fullgiven = fullgiven;
		this.cheaper =cheaper;
		this.superPrice =superPrice;
	}
	@SuppressWarnings("unchecked")
	public Strategy() {
		
	}

	public String getStrategy_Description() {
		return strategy_Description;
	}

	public void setStrategy_Description(String strategy_Description) {
		this.strategy_Description = strategy_Description;
	}

	public Date getTime_begin() {
		return time_begin;
	}

	public void setTime_begin(Date time_begin) {
		this.time_begin = time_begin;
	}

	public Date getTime_end() {
		return time_end;
	}

	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double[] getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double[] seatPrice) {
		this.seatPrice = seatPrice;
	}

	public double[] getFull() {
		return full;
	}

	public void setFull(double[] full) {
		this.full = full;
	}

	public String getFullgiven() {
		return fullgiven;
	}

	public void setFullgiven(String fullgiven) {
		this.fullgiven = fullgiven;
	}

	public double getCheaper() {
		return cheaper;
	}

	public void setCheaper(double cheaper) {
		this.cheaper = cheaper;
	}

	public double[] getSuperPrice() {
		return superPrice;
	}

	public void setSuperPrice(double[] superPrice) {
		this.superPrice = superPrice;
	}
	
	
	 
}
