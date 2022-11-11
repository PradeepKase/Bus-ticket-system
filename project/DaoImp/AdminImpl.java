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
		
		try (Connection conn = BusUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into bus values (?,?,?,?,?,?,?,?,?,?,?,?)");
			
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

}
