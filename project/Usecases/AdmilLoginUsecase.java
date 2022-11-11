package Usecases;

import java.util.Scanner;

import Dao.Admin;
import DaoImp.AdminImpl;

public class AdmilLoginUsecase {
	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter email");
			String email = sc.next();
			
			System.out.println("Enter password");
			String password = sc.next();
			
			Admin dao = new AdminImpl();
			String result =  dao.adminLogin(email, password);
			
			if (result.equals("Login Successfull")){
				System.out.println(result);
//				return true;
			}
			else {
				System.out.println("not registered");
//				return false;
			}
		
	}




}
