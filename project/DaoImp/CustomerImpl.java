package DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dao.Customer;
import Exceptions.CustomerException;
import utility.BusUtility;

public class CustomerImpl implements Customer{

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
	}


