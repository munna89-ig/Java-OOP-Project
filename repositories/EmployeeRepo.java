package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class EmployeeRepo implements IEmployeeRepo
{
	private String file="repositories/Data/employees.txt";
	private FileIO f=new FileIO();
	public void addEmployee(Employee e)
	{
		Employee emps[]=this.getAllEmployee();
		for(int i=0;i<100;i++)
		{
			if(emps[i]==null)
			{
				emps[i]=e;
				break;
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(emps[i]!=null)
			{
				data[i]=emps[i].toStringEmployee();
			}
		}
		
		f.writeFile(this.file,data);
	}
	public void updateEmployee(Employee e)
	{
		Employee emp=this.searchEmployee(e.getUserId());
		if(emp!=null)
		{
			this.deleteEmployee(e.getUserId());
			this.addEmployee(e);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	public void deleteEmployee(String id)
	{
		Employee emps[]=this.getAllEmployee();
		
		for(int i=0;i<100;i++)
		{
			if(emps[i]!=null)
			{
				if(emps[i].getUserId().equals(id))
				{
					emps[i]=null;
				}
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(emps[i]!=null)
			{
				data[i]=emps[i].toStringEmployee();
			}
		}
		
		f.writeFile(this.file,data);
	}
	public Employee searchEmployee(String id)
	{
		Employee emps[]=this.getAllEmployee();
		
		for(int i=0;i<100;i++)
		{
			if(emps[i]!=null)
			{
				if(emps[i].getUserId().equals(id))
				{
					return emps[i];
				}
			}
		}
		
		return null;
	}
	public Employee[] getAllEmployee()
	{
		String data[]=f.readFile(this.file);
		Employee emps[]=new Employee[100];
		Employee emp=new Employee();
		
		for(int i=0;i<emps.length;i++)
		{
			if(emps[i]==null)
			{
				if(data[i]!=null)
				{
					emps[i]=emp.formEmployee(data[i]);
				}
				
			}
		}
		
		return emps;
	}
}
