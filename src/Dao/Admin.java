package Dao;

//import beans.Bus;

public interface Admin {
	public final String email = "pkase6@gmail.com";
	
	public final String password = "1234";
	
	public String adminLogin(String email, String password);

	public String addBus(int busNo, String bName, String bplateNo, String routeFrom, String routeTo, String bType,String bbType, String arrival, String departure,
			int totalSeats, int availSeats, int fare);
	
	public String updateStatus(int cusId);

	public void viewAllTickets();
}
