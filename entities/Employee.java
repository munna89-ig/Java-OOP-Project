package entities;
import java.lang.*;

public class Employee extends User
{
	private String jobPost;
	private double salary;
	
	public Employee()
	{
		super();
	}
	
	public Employee(String name,String userId,String pass,String gender,String address,String gmail,String securityCode,String phone,int role,String jobPost,double salary)
	{
		super(name,userId, pass,gender,address,gmail, securityCode,phone,role);
		this.jobPost=jobPost;
		this.salary=salary;
	}
	
	public void setJobPost(String jobPost)
	{
		this.jobPost=jobPost;
	}
	
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	public String getJobPost()
	{
		return this.jobPost;
	}
	
	public double getSalary()
	{
		return this.salary;
	}
	
	
	public String toStringEmployee()
	{
		String str=this.name+","+this.userId+","+this.gender+","+this.address+","+this.gmail+","+this.phone+","+this.jobPost+","+this.salary+"\n";
		return str;
	}
	
	public Employee formEmployee(String str)
	{
		String[] info=str.split(",");
		Employee e=new  Employee();
		e.setName(info[0]);
		e.setUserId(info[1]);
		e.setGender(info[2]);
		e.setAddress(info[3]);
		e.setGmail(info[4]);
		e.setPhone(info[5]);
		e.setJobPost(info[6]);
		e.setSalary(Double.parseDouble(info[7]));
		
		return e;
	}
	
	
}