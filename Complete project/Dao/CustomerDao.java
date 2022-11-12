package Dao;

import Exceptions.BusException;
import Exceptions.CustomerException;
import beans.Customer;

public interface CustomerDao {

	public String cusSignUp (String email, String password, String firstName, String lastName, String address, String mobile) throws CustomerException ;
	
	public Customer cusLogin (String email, String password) throws CustomerException;

	public String bookTicket (String bName, int cusId, int no) throws BusException;
	
	public String cancelTicket(String bName, int cusId) throws BusException;
	
	public void viewTicket(int cusId);

}
