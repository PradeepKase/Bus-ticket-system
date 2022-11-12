package Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.CustomerDao;
import DaoImp.CustomerDoaImpl;
//import DaoImp.CustomerImpl;
import Exceptions.CustomerException;

public class CustomerSignup {

	public static boolean cusSignUp() throws CustomerException {
		
		boolean flag = false;
		
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter email");
			String emial = sc.next();
			
			System.out.println("Enter Password");
			String password = sc.next();
			
			System.out.println("Enter First Name");
			String firstName = sc.next();
			
			System.out.println("Enter Last Name");
			String lastName = sc.next();
			
			sc.nextLine();
			System.out.println("Enter Address");
			String address = sc.nextLine();
			
			System.out.println("Enter Mobile");
			String mobile = sc.next();
			
			CustomerDao dao = new CustomerDoaImpl();
			
			String result = dao.cusSignUp(emial, password, firstName, lastName, address, mobile);
			
			
			if (result == "Sign up Successfull") {
				System.out.println(result);
				flag = true;
				}
			else {
				System.out.println( result);
			}
			
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid Input");
		}
		
		return flag;
	}
}
