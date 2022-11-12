package Usecases;

import java.util.Scanner;

import Dao.Admin;
import DaoImp.AdminImpl;

public class UpdateStatus {
	public static void updateStatus() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println( "Enter customer Id");
		int cusId = sc.nextInt();
		
		Admin dao = new AdminImpl();
		
		String result = dao.updateStatus(cusId);
		boolean flag = true;
		
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == 'n') flag = false;
		}
	
		if (flag) System.out.println(result);
		else System.out.println(result);
		
	}
}
