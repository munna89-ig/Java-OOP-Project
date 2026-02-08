package interfaces;
import java.lang.*;
import entities.*;

public interface ICustomerRepo
{
	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public void deleteCustomer(String id);
	public Customer searchCustomer(String id);
	public Customer[] getAllCustomer();
}