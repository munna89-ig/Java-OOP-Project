package interfaces;
import java.lang.*;
import entities.*;

public interface IUserRepo
{
	public void addUser(User a);
	public void updateUser(User a);
	public void deleteUser(String id);
	public User searchUser(String id);
	public User[] getAllUser();
}