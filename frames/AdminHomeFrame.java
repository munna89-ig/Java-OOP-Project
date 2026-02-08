package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AdminHomeFrame extends JFrame implements ActionListener
{
	
	private JButton adminBtn, customerBtn, employeeBtn,  viewAllCustomerBtn,viewAllAdminBtn, viewAllEmployeeBtn, passBtn,logOutbtn;
	private JPanel panel;
	private ImageIcon img;
	private User u;
	
	public AdminHomeFrame(User u)
	{
		
		super("Admin Home Frame");
		this.setSize(1800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.img=new ImageIcon("image/back1 .jpg");
		this.panel=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(img.getImage(),0,0,null);
			}
		};
		this.panel.setLayout(null);
		
		
		this.adminBtn=new JButton("Admin operation");
		this.adminBtn.setBounds(250,150,150,50);
		this.adminBtn.addActionListener(this);
		this.panel.add(adminBtn);
		
		this.customerBtn=new JButton("Customer operation");
		this.customerBtn.setBounds(490,150,150,50);
		this.customerBtn.addActionListener(this);
		this.panel.add(customerBtn);
		
		this.employeeBtn=new JButton("Employee operation");
		this.employeeBtn.setBounds(730,150,150,50);
		this.employeeBtn.addActionListener(this);
		this.panel.add(employeeBtn);
		
		this.viewAllCustomerBtn=new JButton("View all Customer");
		this.viewAllCustomerBtn.setBounds(250,250,150,50);
		this.viewAllCustomerBtn.addActionListener(this);
		this.panel.add(viewAllCustomerBtn);
		
		this.viewAllEmployeeBtn=new JButton("View all Employee");
		this.viewAllEmployeeBtn.setBounds(490,250,150,50);
		this.viewAllEmployeeBtn.addActionListener(this);
		this.panel.add(viewAllEmployeeBtn);
		
		this.viewAllAdminBtn=new JButton("View all Admin");
		this.viewAllAdminBtn.setBounds(730,250,150,50);
		this.viewAllAdminBtn.addActionListener(this);
		this.panel.add(viewAllAdminBtn);
		
		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(490,350,150,50);
		this.passBtn.addActionListener(this);
		this.panel.add(passBtn);
		
		this.logOutbtn=new JButton("Log out");
		this.logOutbtn.setBounds(490,600,150,50);
		this.logOutbtn.addActionListener(this);
		this.panel.add(logOutbtn);
		
		
		
		
		
		this.add(panel);
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(adminBtn.getText()))
		{
			AdminOperationFrame aof=new AdminOperationFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		 else if(command.equals(customerBtn.getText()))
		{
			CustomerOperationFrame cof=new CustomerOperationFrame(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		 else if(command.equals(employeeBtn.getText()))
		{
			EmployeeOperationFrame eof=new EmployeeOperationFrame(this.u);
			this.setVisible(false);
			eof.setVisible(true);
		}
		if(command.equals(logOutbtn.getText()))
		{
			LogInFrame l=new LogInFrame();
			this.setVisible(false);
			l.setVisible(true);
		}
		
		if(command.equals(viewAllCustomerBtn.getText()))
		{
			ViewAllCustomer v=new ViewAllCustomer(this.u);
			this.setVisible(false);
			v.setVisible(true);
		}
		if(command.equals(viewAllAdminBtn.getText()))
		{
			ViewAllAdmin va=new ViewAllAdmin(this.u);
			this.setVisible(false);
			va.setVisible(true);
		}
		if(command.equals(viewAllEmployeeBtn.getText()))
		{
			ViewAllEmployee ve=new ViewAllEmployee(this.u);
			this.setVisible(false);
			ve.setVisible(true);
		}
		
		
		
	}
	
}

