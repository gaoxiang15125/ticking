package po;

import java.util.Date;
import java.util.EnumMap;


public class StrategyPo {

	private String strategy_Description;
	private Date time_begin;
	private Date time_end;
	private StrategyType type;
	//座位价格表
	private EnumMap<SeatGrade, Double> seatPrice;
	//type 为满减时所需要的数据
	private double[] full = new double[2];
	//type 为满送时候所需要的数据
	private double fullgiven;
	//type 为优惠比例时所需要的数据
	private double cheaper;
	//type 为特别优惠时所需要的数据
	private EnumMap<SeatGrade, Double> superPrice;
	
	public StrategyPo(String strategy_Description,Date time_begin,Date time_end,StrategyType type,
			EnumMap<SeatGrade, Double> seatPrice,double[] full,double fullgiven,double cheaper,
			EnumMap<SeatGrade, Double> superPrice) {
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
	public StrategyPo() {
		seatPrice = new EnumMap<SeatGrade, Double>(SeatGrade.class);
		superPrice = new EnumMap<SeatGrade, Double>(SeatGrade.class);
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

	public StrategyType getType() {
		return type;
	}

	public void setType(StrategyType type) {
		this.type = type;
	}

	public EnumMap<SeatGrade, Double> getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(EnumMap<SeatGrade, Double> seatPrice) {
		this.seatPrice = seatPrice;
	}

	public double[] getFull() {
		return full;
	}

	public void setFull(double[] full) {
		this.full = full;
	}

	public double getFullgiven() {
		return fullgiven;
	}

	public void setFullgiven(double fullgiven) {
		this.fullgiven = fullgiven;
	}

	public double getCheaper() {
		return cheaper;
	}

	public void setCheaper(double cheaper) {
		this.cheaper = cheaper;
	}

	public EnumMap<SeatGrade, Double> getSuperPrice() {
		return superPrice;
	}

	public void setSuperPrice(EnumMap<SeatGrade, Double> superPrice) {
		this.superPrice = superPrice;
	}
	
	
	 
}
