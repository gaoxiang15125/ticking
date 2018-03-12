package po;

public class VenuePo {

	private String VenueID;
	private  String VenueName;
	private int SeatNum;
	private int availSeatNum;
	private String venue_Introduce;
	private double vaule_ratio;
	
	public VenuePo() {
		
		vaule_ratio =1;
	}

	public String getVenueID() {
		return VenueID;
	}

	public void setVenueID(String venueID) {
		VenueID = venueID;
	}

	public String getVenueName() {
		return VenueName;
	}

	public void setVenueName(String venueName) {
		VenueName = venueName;
	}

	public int getSeatNum() {
		return SeatNum;
	}

	public void setSeatNum(int seatNum) {
		SeatNum = seatNum;
	}

	public int getAvailSeatNum() {
		return availSeatNum;
	}

	public void setAvailSeatNum(int availSeatNum) {
		this.availSeatNum = availSeatNum;
	}

	public String getVenue_Introduce() {
		return venue_Introduce;
	}

	public void setVenue_Introduce(String venue_Introduce) {
		this.venue_Introduce = venue_Introduce;
	}

	public double getVaule_ratio() {
		return vaule_ratio;
	}

	public void setVaule_ratio(double vaule_ratio) {
		this.vaule_ratio = vaule_ratio;
	}
	
	
}
