package Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.CustomerDao;
import DaoImp.CustomerDoaImpl;
//import DaoImp.CustomerImpl;
import Exceptions.BusException;
import beans.Customer;

public class BookTicketbnameUsecase {
public static void BookTicketbName(Customer customer) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Bus Name");
		String bName = sc.next();
		
		CustomerDao dao = new CustomerDoaImpl();
		try {
			System.out.println( "Enter no. of Tickets to Book");
			int no = sc.nextInt();
			
			int cusId = customer.getCusId();
			String message = dao.bookTicket(bName, cusId, no);
			
			if (message.equals("Ticket Booked Successfully")) {
				System.out.println(message);
			}
			else {
				System.out.println(message);
			}
			
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
		
	}
}
