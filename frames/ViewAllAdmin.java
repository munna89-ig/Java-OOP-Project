package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repositories.*;
import entities.*;

public class ViewAllAdmin extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JPanel panel;
	private JTable adminTable;
	private JScrollPane adminTableSP;
	private User u;
	private ImageIcon img;
	public ViewAllAdmin(User u)
	{
		super("All admin Frame");
		this.setSize(1800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(100,500,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		AdminRepo arp=new AdminRepo();
		Admin[] adminList=arp.getAllAdmin();
		String adminData[][]=new String[adminList.length][7];
		for(int i=0;i<adminList.length;i++)
		{
		
			if(adminList[i]!=null)
			{
				System.out.println(adminList[i].toStringAdmin());
				adminData[i][0]=adminList[i].getName();
				adminData[i][1]=adminList[i].getUserId();
				adminData[i][2]=adminList[i].getGender();
				adminData[i][3]=adminList[i].getAddress();
				adminData[i][4]=adminList[i].getGmail();
				adminData[i][5]=adminList[i].getPhone();
				adminData[i][6]=adminList[i].getAdminSector();
				
			}
			
			
			
		}
		
		String head[]={"Name","Id","Gender","Adress","Gmail","Phone","Admin type"};
		this.adminTable=new JTable(adminData,head);
		this.adminTableSP=new JScrollPane(adminTable);
		this.adminTableSP.setBounds(50,100,700,200);
		this.adminTable.setEnabled(true);
		this.panel.add(adminTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		if(this.backBtn.getText().equals(command));
		{
			AdminHomeFrame a= new AdminHomeFrame(this.u);
			this.setVisible(false);
			a.setVisible(true);
		}
	}
}