package po;

import java.util.Date;

public class SeatPo {

	private String SeatID;
	private Date SeatTime;
	private Date SeatEnd;
	private SeatGrade seatGrade;
	private String VenueInfo;
	//推荐使用的构造方法，避免遗漏属性
	public SeatPo(String SeatID,Date SeatTime,Date SeatEnd,SeatGrade seatGrade,String VenueInfo) {
		this.SeatID = SeatID;
		this.SeatTime = SeatTime;
		this.SeatEnd =SeatEnd;
		this.seatGrade = seatGrade;
		this.VenueInfo = VenueInfo;
	}
	
	public String getSeatID() {
		return SeatID;
	}
	public void setSeatID(String seatID) {
		SeatID = seatID;
	}
	public Date getSeatTime() {
		return SeatTime;
	}
	public void setSeatTime(Date seatTime) {
		SeatTime = seatTime;
	}
	public Date getSeatEnd() {
		return SeatEnd;
	}
	public void setSeatEnd(Date seatEnd) {
		SeatEnd = seatEnd;
	}
	public SeatGrade getSeatGrade() {
		return seatGrade;
	}
	public void setSeatGrade(SeatGrade seatGrade) {
		this.seatGrade = seatGrade;
	}
	public String getVenueInfo() {
		return VenueInfo;
	}
	public void setVenueInfo(String venueInfo) {
		VenueInfo = venueInfo;
	}
	
	
}
