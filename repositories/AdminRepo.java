package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class AdminRepo implements IAdminRepo
{
	private String file="repositories/Data/admins.txt";
	private FileIO f=new FileIO();
	public void addAdmin(Admin a)
	{
		Admin adm[]=this.getAllAdmin();
		for(int i=0;i<100;i++)
		{
			if(adm[i]==null)
			{
				adm[i]=a;
				break;
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(adm[i]!=null)
			{
				data[i]=adm[i].toStringAdmin();
			}
		}
		
		f.writeFile(this.file,data);
	}
	
	public void updateAdmin(Admin a)
	{
		Admin adm=this.searchAdmin(a.getUserId());
		if(adm!=null)
		{
			this.deleteAdmin(a.getUserId());
			this.addAdmin(a);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	public void deleteAdmin(String id)
	{
		Admin adm[]=this.getAllAdmin();
		
		for(int i=0;i<100;i++)
		{
			if(adm[i]!=null)
			{
				if(adm[i].getUserId().equals(id))
				{
					adm[i]=null;
				}
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(adm[i]!=null)
			{
				data[i]=adm[i].toStringAdmin();
			}
		}
		
		f.writeFile(this.file,data);
	}
	public Admin searchAdmin(String id)
	{
		Admin adm[]=this.getAllAdmin();
		
		for(int i=0;i<100;i++)
		{
			if(adm[i]!=null)
			{
				if(adm[i].getUserId().equals(id))
				{
					return adm[i];
				}
			}
		}
		
		return null;
	}
	public Admin[] getAllAdmin()
	{
		String data[]=f.readFile(this.file);
		Admin adm[]=new Admin[100];
		Admin ad=new Admin();
		
		for(int i=0;i<adm.length;i++)
		{
			if(adm[i]==null)
			{
				if(data[i]!=null)
				{
					adm[i]=ad.formAdmin(data[i]);
				}
				
			}
		}
		
		return adm;
	}
}
