package DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Dao.CustomerDao;
import Exceptions.BusException;
import Exceptions.CustomerException;
import beans.Customer;
import utility.BusUtility;

public class CustomerDoaImpl implements CustomerDao{

	@Override
	public String cusSignUp(String email, String password, String firstName, String lastName, String address,
			String mobile) throws CustomerException {
		// TODO Auto-generated method stub
		String message = "Sign up Failed";
		try(Connection con = BusUtility.provideConnection()){
			PreparedStatement ps =  con.prepareStatement("insert into customer(email, password, firstName, lastName, address, mobile) values (?,?,?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3,  firstName);
			ps.setString(4,  lastName); 
			ps.setString(5,  address);
			ps.setString(6,  mobile);
			int x = ps.executeUpdate();
			if (x > 0) message = "Sign up Successfull";
			} 		
		catch (SQLException e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
			} 		 		return message;
		}
	
	
	
	
	
	
	

	@Override
	public Customer cusLogin(String email, String password) throws CustomerException {
		// TODO Auto-generated method stub
		Customer customer = null;
		
		try (Connection conn = BusUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from customer where email = ? and password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs =  ps.executeQuery();
			
			if (rs.next()) {
				int cusId = rs.getInt("cusId");
				String email1 =  rs.getString("email");
				String passwordd = rs.getString("password");
				String firstName = rs.getString("firstName");		
				String lastName = rs.getString("lastName");			
				String address = rs.getString("address");			
				String mobile = rs.getString("mobile");
				
				
				//customer = new beans.Customer(cusId,email1, passwordd, firstName, lastName, address, mobile);
				customer = new Customer(cusId,email1, passwordd, firstName, lastName, address, mobile);
			}
			else {
				throw new CustomerException("Invalid email or password");
				
			}
			
		}
		catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return customer;
	}

	
	
	
	
	
	
	
	
	public String bookTicket(String bName, int cusId, int no) throws BusException {
		// TODO Auto-generated method stub
		String message = "Ticket Booking fail";
		
		try (Connection conn = BusUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from bus where bName = ?");
			ps.setString(1, bName);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				int busNo = rs.getInt("busNo");
				int totalSeats = rs.getInt("totalSeats");
				int availSeats = rs.getInt("availSeats");
				Date departure = rs.getDate("departure");
				int fare = rs.getInt("fare");
				
				PreparedStatement ps1 = conn.prepareStatement("select datediff(?,current_date()) as date");
				ps1.setDate(1, (java.sql.Date) departure);
				
				ResultSet rs1 = ps1.executeQuery();
				int days = 0;
				if (rs1.next()) {
					days = rs1.getInt("date");
				}
				
				if (days <= 0) {
					throw new BusException("Booking is not available for this date");
				}
				else if (availSeats >= no) {
					int seatFrom = totalSeats - availSeats + 1;
					int seatTo = seatFrom + no -1;
					fare = fare * no;
					
					PreparedStatement ps2 = conn.prepareStatement("insert into booking(cusId, busNo, seatFrom, seatTo) values (?, ?, ?, ?)");
					ps2.setInt(1, cusId);
					ps2.setInt(2, busNo);
					ps2.setInt(3, seatFrom);
					ps2.setInt(4, seatTo);
					
					int x = ps2.executeUpdate();

					if (x > 0) {
						
						PreparedStatement ps3 = conn.prepareStatement("update bus set availseats = ? where busNo = ?");
						availSeats = availSeats - no;
						ps3.setInt(1, availSeats);
						ps3.setInt(2, busNo);
						int y = ps3.executeUpdate();
						
						if (y <= 0) throw new BusException("Available Seat is not updated");
						
						
						System.out.println("--------------------------------------------" + "\n"
																   + "Customer Id is : " + cusId + "\n"
																   + "Bus No is : " + busNo + "\n"
																   + "Seat No is from : " + seatFrom + " to " + seatTo + "\n"
																   + "Bus fare is : " + fare + "\n"
																   + "Booking yet to be confirm by Adminstrator" + "\n" 
																   + "---------------------------------------------");
						
						 message = "Ticket Booked Successfully";
					}
				
				}
	
			}
			else {
				throw new BusException("Bus with " + bName + " is not available");
			}
			
		}
		catch (SQLException e) {
			throw new BusException(e.getMessage());
		}
		
		return message;
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void viewTicket(int cusId) {
		// TODO Auto-generated method stub
boolean flag = false;
		
		try(Connection conn = BusUtility.provideConnection()){
			PreparedStatement ps1 = conn.prepareStatement("select * from booking where cusId = ?");
			ps1.setInt(1, cusId);
			
			ResultSet rs1 = ps1.executeQuery();
			
			while (rs1.next()) {
				flag = true;
				System.out.println("---------------------------------------------");
				System.out.println("Bus Id : " + rs1.getInt("bId"));
				System.out.println("Bus No : " + rs1.getInt("busNo"));
				System.out.println("Total tickets : " + (rs1.getByte("seatTo") - rs1.getInt("seatFrom") + 1));
				if (rs1.getBoolean("status")) System.out.println("Status : Booked");
				else System.out.println( "Status : Pending");
				
				System.out.println("----------------------------------------------");
			}
			
			if (flag == false) System.out.println("No tickets found");
		}
		catch (SQLException s){
			System.out.println(s.getMessage());
		}
	}








	@Override
	public String cancelTicket(String bName, int cusId) throws BusException {
		// TODO Auto-generated method stub
String message = "Ticket cancellation failed";
		
		try (Connection conn = BusUtility.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("select * from bus where bName = ?");
				ps.setString(1, bName);
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					
					int busNo = rs.getInt("busNo");
					int availSeats = rs.getInt("availSeats");
					
					PreparedStatement ps1 = conn.prepareStatement("select * from booking where busNo = ? and cusId = ?");
					ps1.setInt(1, busNo);
					ps1.setInt(2, cusId);
					
					ResultSet rs1 = ps1.executeQuery();
					boolean flag = false;
					int count = 0;
					
					while (rs1.next()) {
						flag = true;
						int seatFrom = rs1.getInt("seatFrom");
						int seatTo = rs1.getInt("seatTo");
						count += seatTo - seatFrom + 1;
					}
					
				    if (flag) {
						
						PreparedStatement ps2 = conn.prepareStatement("delete from booking where busNo = ? and cusId = ?");
						ps2.setInt(1, busNo);
						ps2.setInt(2, cusId);
						
						int x = ps2.executeUpdate();
						if (x > 0) {
							
							PreparedStatement ps3 = conn.prepareStatement("update bus set availseats = ? where busNo = ?");
							availSeats = availSeats + count;
							ps3.setInt(1, availSeats);
							ps3.setInt(2, busNo);
							int y = ps3.executeUpdate();
							
							if (y <= 0) throw new BusException("Available Seat is not updated");
							
							 message = "Ticket cancelled Successfully";
						}
					
					}
				    else message = "No booking found";
		
				}
				else {
					throw new BusException("Bus with " + bName + " is not available");
				}
				
			}
			catch (SQLException e) {
				throw new BusException(e.getMessage());
			}
		
		return message;
	}
	
	
	
	}


