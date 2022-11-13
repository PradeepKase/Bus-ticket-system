package beans;

public class Bus {
	 private int busNo;
	 
	 private String bName;
	 
	 private String bplateNo ;
	 
	 private String routeFrom;
	 
	 private String routeTo;
	 
	 private String bType;
	 
	 private String bbType;
	 
	 private String departure;
	 
	 private String arrival;
	 
	 private int totalSeats;
	 
	 private int availSeats;
	 
	 private int fare;
	 
	 public Bus() {
		 
	 }

	public Bus(int busNo, String bName, String bplateNo, String routeFrom, String routeTo, String bType, String bbType,
			String departure, String arrival, int totalSeats, int availSeats, int fare) {
		super();
		this.busNo = busNo;
		this.bName = bName;
		this.bplateNo = bplateNo;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.bType = bType;
		this.bbType = bbType;
		this.departure = departure;
		this.arrival = arrival;
		this.totalSeats = totalSeats;
		this.availSeats = availSeats;
		this.fare = fare;
	}

	
	
	public int getBusNo() {
		return busNo;
	}



	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}



	public String getbName() {
		return bName;
	}



	public void setbName(String bName) {
		this.bName = bName;
	}



	public String getBplateNo() {
		return bplateNo;
	}



	public void setBplateNo(String bplateNo) {
		this.bplateNo = bplateNo;
	}



	public String getRouteFrom() {
		return routeFrom;
	}



	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}



	public String getRouteTo() {
		return routeTo;
	}



	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}



	public String getbType() {
		return bType;
	}



	public void setbType(String bType) {
		this.bType = bType;
	}



	public String getBbType() {
		return bbType;
	}



	public void setBbType(String bbType) {
		this.bbType = bbType;
	}



	public String getDeparture() {
		return departure;
	}



	public void setDeparture(String departure) {
		this.departure = departure;
	}



	public String getArrival() {
		return arrival;
	}



	public void setArrival(String arrival) {
		this.arrival = arrival;
	}



	public int getTotalSeats() {
		return totalSeats;
	}



	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}



	public int getAvailSeats() {
		return availSeats;
	}



	public void setAvailSeats(int availSeats) {
		this.availSeats = availSeats;
	}



	public int getFare() {
		return fare;
	}



	public void setFare(int fare) {
		this.fare = fare;
	}



	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", bName=" + bName + ", bplateNo=" + bplateNo + ", routeFrom=" + routeFrom
				+ ", routeTo=" + routeTo + ", bType=" + bType + ", bbType=" + bbType + ", departure=" + departure
				+ ", arrival=" + arrival + ", totalSeats=" + totalSeats + ", availSeats=" + availSeats + ", fare="
				+ fare + "]";
	}
	 
	 
}
