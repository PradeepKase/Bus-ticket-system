package DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Admin;
//import beans.Bus;
import utility.BusUtility;

public class AdminImpl implements Admin{

	@Override
	public String addBus(int busNo, String bName, String bplateNo, String routeFrom, String routeTo, String bType,
			String bbType, String arrival, String departure, int totalSeats, int availSeats, int fare) {
		// TODO Auto-generated method stub
String message = "Bus not Added";
		
		try (Connection con = BusUtility.provideConnection()){
			PreparedStatement ps = con.prepareStatement("insert into bus values (?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, busNo);
			ps.setString(2, bName);
			ps.setString(3, bplateNo);
			ps.setString(4, routeFrom);
			ps.setString(5, routeTo);
			ps.setString(6, bType);
			ps.setString(7, bbType);
			ps.setString(8, arrival);
			ps.setString(9, departure);
			ps.setInt(10,totalSeats);
			ps.setInt(11, availSeats);
			ps.setInt(12, fare);
			
			int x = ps.executeUpdate();
			
			if (x > 0) message = "Bus added Successfully";
			
		}
		catch (SQLException e) {
			message  = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String adminLogin(String email, String password) {
		// TODO Auto-generated method stub
		String message = "Invalid username or password";
		
		if (email.equals(Admin.email) && password.equals(Admin.password)) {
			 message = "Login Successfull";
		}
		
		return message;
	}

	@Override
	public String updateStatus(int cusId) {
		// TODO Auto-generated method stub
		String message = "Status not update for customer Id : " + cusId;
		
		try(Connection con = BusUtility.provideConnection()){
			PreparedStatement ps = con.prepareStatement("update booking set status = true where bId = ?");
			ps.setInt(1, cusId);
			
			int x = ps.executeUpdate();
			if (x > 0) message = "Status successfully updated for booking Id : " + cusId;
			
		}
		catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public void viewAllTickets() {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		try(Connection con = BusUtility.provideConnection()){
			PreparedStatement ps = con.prepareStatement("select * from booking");
			
			ResultSet rs1 = ps.executeQuery();
			
			while (rs1.next()) {
				flag = true;
				System.out.println("----------------------------------------------------");
				System.out.println("Booking Id : " + rs1.getInt("bId"));
				System.out.println("Bus No : " + rs1.getInt("busNo"));
				System.out.println("Total tickets : " + (rs1.getInt("seatTo") - rs1.getInt("seatFrom") + 1));
				if (rs1.getInt("status") == 1) System.out.println("Status : Booked");
				else System.out.println( "Status : Pending");
				
				System.out.println("----------------------------------------------------");
			}
			
			if (flag == false) System.out.println("No tickets found");
		}
		catch (SQLException s){
			System.out.println(s.getMessage());
		}
	}

}
