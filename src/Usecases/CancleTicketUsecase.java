package Usecases;

import java.util.Scanner;

import Dao.CustomerDao;
import DaoImp.CustomerDoaImpl;
import Exceptions.BusException;
import beans.Customer;

public class CancleTicketUsecase {
	public  static void cancelTicket(Customer customer) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Bus Name");
		String bName = sc.nextLine();
		
		CustomerDao dao = new CustomerDoaImpl();
		try {
			
			int cusId = customer.getCusId();
			String message = dao.cancelTicket(bName, cusId);
			
			if (message.equals("Ticket cancelled Successfully")) {
				System.out.println( message);
			}
			else {
				System.out.println( message );
			}
			
		} catch (BusException e) {
			System.out.println( e.getMessage() );
		}
	
	}
}
