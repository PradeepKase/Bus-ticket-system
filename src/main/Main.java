package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.CustomerException;
import Usecases.AddBusUsecase;
import Usecases.AdmilLoginUsecase;
import Usecases.BookTicketbnameUsecase;
import Usecases.CancleTicketUsecase;
import Usecases.CustomerLoingUsecase;
import Usecases.CustomerSignup;
import Usecases.UpdateStatus;
import Usecases.ViewAllTickets;
import Usecases.ViewTicketUsecase;
import beans.Customer;

public class Main {
	static void AdminOrCustomer() throws CustomerException {
		System.out.println("+---------------------------+" + "\n"
						 						   + "| 1. Login As Administrator |" + "\n"
						 						   + "| 2. Login As Customer      |" + "\n"
						 						   + "| 3. Exit                   |" + "\n"
						 						   + "+---------------------------+" );
		choice();
	}
	private static void choice() throws CustomerException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Input type should be number");
			AdminOrCustomer();
		}
		
		if (choice == 1) {
			System.out.println("Welcome Admin! Please Login to your account");
			AdminLogin();
		}
		else if (choice == 2) {
			System.out.println("Welcome Customer!");
			customerLoginOrSignup();
		}
		else if (choice == 3) {
			System.out.println("Thank you! Visit again");
			System.exit(0);
		}
		else {
			System.out.println("Please choose a number from below options");
			AdminOrCustomer();
		}
	}

	private static void AdminLogin() throws CustomerException {
		// TODO Auto-generated method stub
		Boolean result = AdmilLoginUsecase.AdminLogin();

		if (result) adminMethods();
		else {
			AdminLogin();
		}
	}
	
	
	private static void adminMethods() throws CustomerException {
		// TODO Auto-generated method stub
		System.out.println("+--------------------------------+" + "\n"
				 + "| Welcome Admin                  |" + "\n"
				 + "| 1. Add Bus                     |" + "\n"
				 + "| 2. Confirm Tickets of Customer |" + "\n"
				 + "| 3. View All Bookings           |" + "\n"
				 + "| 4. Back                        |" + "\n"
				 + "| 5. Exit                        |" + "\n"
				 + "+--------------------------------+");

Scanner sc = new Scanner(System.in);

int choice = 0;
try {
	choice = sc.nextInt();
	if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
		System.out.println("Please choose a number from below options");
		adminMethods();
	}
	else adminChoice(choice);
}
catch (InputMismatchException e) {
	
	System.out.println("Input type should be number");
	adminMethods();
	}
}
	
	
	private static void adminChoice(int choice) throws CustomerException {
		// TODO Auto-generated method stub
		switch(choice) {
		case 1 : {
			AddBusUsecase.AddBus();
			adminMethods();
		}
		break;
		case 2 : {
			UpdateStatus.updateStatus();
			adminMethods();
		}
		break;
		case 3 : {
			ViewAllTickets.viewAllTicket();
			adminMethods();
		}
		break;
		case 4 : AdminOrCustomer();
		break;	
		case 5 : {
			System.out.println("Thank you ! Visit again");
			System.exit(0);
		}
	}
}
	private static void customerLoginOrSignup() throws CustomerException {
		// TODO Auto-generated method stub
		System.out.println("+--------------------------------+" + "\n"
                + "| 1. Login to your Account       |" + "\n"
                + "| 2. Don't have Account? Sign Up |" + "\n"
                + "| 3. Back                        |" + "\n"
                + "| 4. Exit                        |" + "\n"
                + "+--------------------------------+");
		try {
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice == 1) {
				customerLogin();
			}
			else if (choice == 2) {
				customerSignup();
			}
			else if (choice == 3) {
				AdminOrCustomer();
			}
			else if (choice == 4) {
				System.out.println("Thank you ! Visit again");
				System.exit(0);
			}
			else {
				System.out.println("Please choose a number from below options");
				customerLoginOrSignup();
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Input type should be number");
			customerLoginOrSignup();
		}
	}
	
	
	private static void customerLogin(){
		// TODO Auto-generated method stub
		Customer customer = CustomerLoingUsecase.CusLogin();
		
		if (customer == null) {
//			System.out.println("invalid credentital");
			customerLogin();
		}
		
		else {
			System.out.println("Login Successfull" );
			try {
				customerMethods(customer);
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	
	
	private static void customerSignup() throws CustomerException {
		// TODO Auto-generated method stub
		boolean flag = CustomerSignup.cusSignUp();
		
		if (flag) {
			System.out.println("Login to your Account");
			customerLogin();
		}
		else {
			customerSignup();
		}
	}
	
	static void customerMethods(Customer customer) throws CustomerException {
		System.out.println("+--------------------------------+" + "\n"
				 		 + "| 1. Book Bus Ticket             |" + "\n"
				         + "| 2. Cancel Bus Ticket           |" + "\n"
				         + "| 3. View Status of your Tickets |" + "\n"
				         + "| 4. Back                        |" + "\n"
				         + "| 5. Exit                        |" + "\n"
				         + "+--------------------------------+");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				System.out.println("Please choose a number from below options");
				customerMethods(customer);
			}
			else customerChoice(choice, customer);
		}
		catch (InputMismatchException e) {
			
			System.out.println("Input type should be number");
			customerMethods(customer);
		}
	}
	
	private static void customerChoice(int choice, Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		switch(choice) {
		case 1 : {
			BookTicketbnameUsecase.BookTicketbName(customer);
			customerMethods(customer);
		}
		break;
		case 2 : {
			CancleTicketUsecase.cancelTicket(customer);
			customerMethods(customer);
		}
		break;
		case 3 : {
			ViewTicketUsecase.viewTicket(customer);
			customerMethods(customer);
		}
		break;
		case 4 : {
			customerLoginOrSignup();
		}
		case 5 : {
			System.out.println("Thank you ! Visit again");
			System.exit(0);
		}
	}
}

	public static void main(String[] args) throws CustomerException {
		// TODO Auto-generated method stub
		AdminOrCustomer();
	}

}
