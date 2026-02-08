package entities;
import java.lang.*;

public class Admin extends User
{
	private String adminSector;
	
	public Admin()
	{
		super();
	}
	
	public Admin(String name, String userId,  String pass,  String gender,  String address, String gmail, String securityCode,  String phone,  int role, String adminSector)
	{
		super(name, userId, pass, gender, address, gmail, securityCode, phone, role);
	
		this.adminSector=adminSector;
	}
	
	public void setAdminSector(String adminSector)
	{
		this.adminSector=adminSector;
	}
	
	public String getAdminSector()
	{
		return this.adminSector;
	}
	
	
	public String toStringAdmin()
	{
		String str=this.name+","+this.userId+","+this.gender+","+this.address+","+this.gmail+","+this.phone+","+this.adminSector+"\n";
		return str;
	}
	
	public Admin formAdmin(String str)
	{
		String info[]=str.split(",");
		Admin a=new Admin();
		a.setName(info[0]);
		a.setUserId(info[1]);
		a.setGender(info[2]);
		a.setAddress(info[3]);
		a.setGmail(info[4]);
		a.setPhone(info[5]);
		a.setAdminSector(info[6]);
		
		return a;
	}
	
	
}