package Usecases;

import Dao.CustomerDao;
import DaoImp.CustomerDoaImpl;
import beans.Customer;

public class ViewTicketUsecase {
	public static void viewTicket(Customer customer) {
		
		CustomerDao dao = new CustomerDoaImpl();
		
		dao.viewTicket(customer.getCusId());
	}
}
