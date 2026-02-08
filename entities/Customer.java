package entities;
import java.lang.*;

public class Customer extends User
{
	
	private String customerSubscription;
	
	public Customer()
	{
		super();
	}
	
	public Customer(String name, String userId,  String pass,  String gender,  String address, String gmail, String securityCode,  String phone,  int role, String customerSubscription)
	{
		super(name, userId, pass, gender, address, gmail, securityCode, phone, role  );
	
		this.customerSubscription=customerSubscription;
	}
	
	public void setCustomerSubscription(String customerSubscription)
	{
		this.customerSubscription=customerSubscription;
	}
	
	public String getCustomerSubscription()
	{
		return this.customerSubscription;
	}
	
	
	
	public String toStringCustomer()
	{
		String str=this.name+","+this.userId+","+this.gender+","+this.address+","+this.gmail+","+this.phone+","+this.customerSubscription+"\n";
		return str;
	}
	
	public Customer formCustomer(String str)
	{
		String[] info=str.split(",");
		Customer c=new Customer();
		c.setName(info[0]);
		c.setUserId(info[1]);
		c.setGender(info[2]);
		c.setAddress(info[3]);
		c.setGmail(info[4]);
		c.setPhone(info[5]);
		c.setCustomerSubscription(info[6]);
		
		
		
		
		
		return c;
	}
	
	
}