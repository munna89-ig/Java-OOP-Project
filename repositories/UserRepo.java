package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;
public class UserRepo implements IUserRepo
{
	private String file="repositories/Data/users.txt";
	private FileIO f=new FileIO();
	public void addUser(User u)
	{
		User user[]=this.getAllUser();
		for(int i=0;i<100;i++)
		{
			if(user[i]==null)
			{
				user[i]=u;
				break;
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(user[i]!=null)
			{
				data[i]=user[i].toStringUser();
			}
		}
		
		f.writeFile(this.file,data);
	}
	public void updateUser(User u)
	{
		User user=this.searchUser(u.getUserId());
		if(user!=null)
		{
			this.deleteUser(u.getUserId());
			this.addUser(u);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	public void deleteUser(String id)
	{
		User user[]=this.getAllUser();
		
		for(int i=0;i<100;i++)
		{
			if(user[i]!=null)
			{
				if(user[i].getUserId().equals(id))
				{
					user[i]=null;
				}
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(user[i]!=null)
			{
				data[i]=user[i].toStringUser();
			}
		}
		
		f.writeFile(this.file,data);
	}
	public User searchUser(String id)
	{
		User user[]=this.getAllUser();
		
		for(int i=0;i<100;i++)
		{
			if(user[i]!=null)
			{
				if(user[i].getUserId().equals(id))
				{
					return user[i];
				}
			}
		}
		
		return null;
	}
	public User[] getAllUser()
	{
		 String data[] = f.readFile(this.file);
        User[] users = new User[data.length];
        
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] != null && !data[i].isEmpty())
            {
                User us = new User();
                users[i] = us.formUser(data[i]);
            }
        }
		
		return users;
	}
}
