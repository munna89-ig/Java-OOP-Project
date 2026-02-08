package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class CustomerRepo implements ICustomerRepo
{
	private String file="repositories/Data/customers.txt";
	private FileIO f=new FileIO();
	public void addCustomer(Customer c)
	{
		Customer cstm[]=this.getAllCustomer();
		for(int i=0;i<100;i++)
		{
			if(cstm[i]==null)
			{
				cstm[i]=c;
				break;
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(cstm[i]!=null)
			{
				data[i]=cstm[i].toStringCustomer();
			}
		}
		
		f.writeFile(this.file,data);
	}
	public void updateCustomer(Customer c)
	{
		Customer cstm=this.searchCustomer(c.getUserId());
		if(cstm!=null)
		{
			this.deleteCustomer(c.getUserId());
			this.addCustomer(c);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	public void deleteCustomer(String id)
	{
		Customer cstm[]=this.getAllCustomer();
		
		for(int i=0;i<100;i++)
		{
			if(cstm[i]!=null)
			{
				if(cstm[i].getUserId().equals(id))
				{
					cstm[i]=null;
				}
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(cstm[i]!=null)
			{
				data[i]=cstm[i].toStringCustomer();
			}
		}
		
		f.writeFile(this.file,data);
	}
	public Customer searchCustomer(String id)
	{
		Customer cstm[]=this.getAllCustomer();
		
		for(int i=0;i<100;i++)
		{
			if(cstm[i]!=null)
			{
				if(cstm[i].getUserId().equals(id))
				{
					return cstm[i];
				}
			}
		}
		
		return null;
	}
	public Customer[] getAllCustomer()
	{
		 String data[] = f.readFile(this.file);
        Customer[] cstm = new Customer[data.length];
        
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] != null && !data[i].isEmpty())
            {
                Customer c = new Customer();
                cstm[i] = c.formCustomer(data[i]);
            }
        }
		
		return cstm;
	}
	
}