package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repositories.*;
import entities.*;

public class ViewAllCustomer extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JPanel panel;
	private JTable customerTable;
	private JScrollPane customerTableSP;
	private User u;
	private ImageIcon img;
	public ViewAllCustomer(User u)
	{
		super("All customer Frame");
		this.setSize(1800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(100,500,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		CustomerRepo crp=new CustomerRepo();
		Customer[] customerList=crp.getAllCustomer();
		String customerData[][]=new String[customerList.length][7];
		for(int i=0;i<customerList.length;i++)
		{
		
			if(customerList[i]!=null)
			{
				System.out.println(customerList[i].toStringCustomer());
				customerData[i][0]=customerList[i].getName();
				customerData[i][1]=customerList[i].getUserId();
				customerData[i][2]=customerList[i].getGender();
				customerData[i][3]=customerList[i].getAddress();
				customerData[i][4]=customerList[i].getGmail();
				customerData[i][5]=customerList[i].getPhone();
				customerData[i][6]=customerList[i].getCustomerSubscription();
				
			}
			
			
			
		}
		
		String head[]={"Name","Id","Gender","Adress","Gmail","Phone","Subscription"};
		this.customerTable=new JTable(customerData,head);
		this.customerTableSP=new JScrollPane(customerTable);
		this.customerTableSP.setBounds(50,100,700,200);
		this.customerTable.setEnabled(true);
		this.panel.add(customerTableSP);
		
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