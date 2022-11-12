package Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.CustomerDao;
import beans.Customer;
import DaoImp.CustomerDoaImpl;
import Exceptions.CustomerException;
public class CustomerLoingUsecase {
public static Customer CusLogin() {
		
		Customer customer = null;
		
		try {
			
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Enter Username");
			String username = sc.next();
			
			System.out.println("Enter Password");
			String password = sc.next();
			
			CustomerDao dao = new CustomerDoaImpl();
			
			try {
				customer = dao.cusLogin(username, password);
				
				System.out.println("Welcome " + customer.getFirstname() + " " + customer.getLastname());
			} catch (CustomerException e) {
				
				System.out.println(e.getMessage());
			}
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		
		return customer;

	}

}
