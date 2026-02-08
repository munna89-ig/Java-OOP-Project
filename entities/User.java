package entities;
import java.lang.*;

public class User
{
	protected String  name,userId,pass,gender,address, gmail,securityCode, phone;
	protected int  role;
	
	public User()
	{
	}
	
	public User( String name,String userId,String pass,String gender,String address, String gmail,String securityCode, String phone,int role)
	{
		this.userId=userId;
		this.name=name;
		this.gmail=gmail;
		this.phone=phone;
		this.gender=gender;
		this.address=address;
		this.role=role;
		this.securityCode=securityCode;
		this.pass=pass;
	}
	
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setGmail(String gmail)
	{
		this.gmail=gmail;
	}
	
	
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public void setRole(int role)
	{
		this.role=role;
	}
	
	public void setSecurityCode(String securityCode)
	{
		this.securityCode=securityCode;
	}
	
	public void setPass(String pass)
	{
		this.pass=pass;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getGmail()
	{
		return this.gmail;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public int getRole()
	{
		return this.role;
	}
	
	public String getSecurityCode()
	{
		return this.securityCode;
	}
	
	public String getPassword()
	{
		return this.pass;
	}
	
	
	public String toStringUser()
	{
		String str=this.userId+","+this.role+","+this.securityCode+","+this.pass+"\n";
		return str;
	}
	
	public User formUser(String str)
	{
		String info[]=str.split(",");
		
		User u=new User();
		u.setUserId(info[0]);
		u.setRole(Integer.parseInt(info[1]));
		u.setSecurityCode(info[2]);
		u.setPass(info[3]);
		
		return u;
		
	}
	
	
	
	
	
	
	
	
}