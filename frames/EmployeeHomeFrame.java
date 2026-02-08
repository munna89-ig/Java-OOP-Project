package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class EmployeeHomeFrame extends JFrame implements ActionListener
{
	
	private JButton employeeProfileBtn, customerDetailsBtn,logOutBtn;
	private JPanel panel;
	private ImageIcon img;
	
	
	public EmployeeHomeFrame()
	{
		
		super("Employee Home Frame");
		this.setSize(1800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.img=new ImageIcon("image/back2.jpg");
		this.panel=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(img.getImage(),0,0,null);
			}
		};
		this.panel.setLayout(null);
		
		
		
		
		this.employeeProfileBtn=new JButton("Employee Profile");
		this.employeeProfileBtn.setBounds(490,250,150,50);
		this.employeeProfileBtn.addActionListener(this);
		this.panel.add(employeeProfileBtn);
		
		
		
		this.customerDetailsBtn=new JButton("Customer Details");
		this.customerDetailsBtn.setBounds(490,350,150,50);
		this.customerDetailsBtn.addActionListener(this);
		this.panel.add(customerDetailsBtn);
		
		
		this.logOutBtn=new JButton("Log Out");
		this.logOutBtn.setBounds(550,450,100,40);
		this.logOutBtn.addActionListener(this);
		this.panel.add(logOutBtn);
		
		
		
		
		
		this.add(panel);
		
	}
	
     public void actionPerformed(ActionEvent a)
	{
		String cmnd=a.getActionCommand();
		if(logOutBtn.getText().equals(cmnd))
		{
			LogInFrame l=new LogInFrame();
			this.setVisible(false);
			l.setVisible(true);
		}
	}
	
}