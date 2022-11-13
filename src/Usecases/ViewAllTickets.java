package Usecases;

import Dao.Admin;
import DaoImp.AdminImpl;

public class ViewAllTickets {
public static void viewAllTicket() {
		
		Admin dao = new AdminImpl();
		dao.viewAllTickets();
	}
}
