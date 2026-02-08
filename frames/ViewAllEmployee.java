package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repositories.*;
import entities.*;

public class ViewAllEmployee extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JPanel panel;
	private JTable employeeTable;
	private JScrollPane employeeTableSP;
	private User u;
	private ImageIcon img;
	public ViewAllEmployee(User u)
	{
		super("All Employee Frame");
		this.setSize(1800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(100,500,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		EmployeeRepo emp=new EmployeeRepo();
		Employee[] employeeList=emp.getAllEmployee();
		String employeeData[][]=new String[employeeList.length][8];
		for(int i=0;i<employeeList.length;i++)
		{
		
			if(employeeList[i]!=null)
			{
				System.out.println(employeeList[i].toStringEmployee());
				employeeData[i][0]=employeeList[i].getName();
				employeeData[i][1]=employeeList[i].getUserId();
				employeeData[i][2]=employeeList[i].getGender();
				employeeData[i][3]=employeeList[i].getAddress();
				employeeData[i][4]=employeeList[i].getGmail();
				employeeData[i][5]=employeeList[i].getPhone();
				employeeData[i][6]=employeeList[i].getJobPost();
				employeeData[i][7]=String.valueOf(employeeList[i].getSalary());
			}
			
			
			
		}
		
		String head[]={"Name","Id","Gender","Adress","Gmail","Phone","Job Post","Salary"};
		this.employeeTable=new JTable(employeeData,head);
		this.employeeTableSP=new JScrollPane(employeeTable);
		this.employeeTableSP.setBounds(50,100,700,200);
		this.employeeTable.setEnabled(true);
		this.panel.add(employeeTableSP);
		
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
			AdminHomeFrame e= new AdminHomeFrame(this.u);
			this.setVisible(false);
			e.setVisible(true);
		}
	}
}