package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;
public class EmployeeOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, gmailLabel, phoneLabel, genderLabel,  addressLabel,  securityCodeLabel, passLabel, jobPostLabel,salaryLabel;
	private JTextField userTF, nameTF, gmailTF, phoneTF,  addressTF, securityCodeTF,salaryTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup genderBG;
	private JComboBox jobPostCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JPanel panel;
	private ImageIcon img;
	private User u;
	public EmployeeOperationFrame(User u)
	{
		super("Employee Operation Frame");
		this.setSize(1800,850);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.img=new ImageIcon("image/back.jpg");
		this.panel=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(img.getImage(),0,0,null);
			}
		};
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id ");
		this.userIdLabel.setBounds(120,270,70,35);
		this.userIdLabel.setForeground(Color.WHITE);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(200,270,150,40);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name ");
		this.nameLabel.setBounds(120,180,150,40);
		this.nameLabel.setForeground(Color.WHITE);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(200,180,150,40);
		this.panel.add(nameTF);
		
		this.gmailLabel=new JLabel("gmail ");
		this.gmailLabel.setBounds(120,360,70,35);
		this.gmailLabel.setForeground(Color.WHITE);
		this.panel.add(gmailLabel);
		
		this.gmailTF=new JTextField();
		this.gmailTF.setBounds(200,360,150,40);
		this.panel.add(gmailTF);
		
		this.phoneLabel=new JLabel("phone No ");
		this.phoneLabel.setBounds(115,450,100,35);
		this.phoneLabel.setForeground(Color.WHITE);
		this.panel.add(phoneLabel);
		
		this.phoneTF=new JTextField();
		this.phoneTF.setBounds(200,450,150,40);
		this.panel.add(phoneTF);
		
		this.genderLabel=new JLabel("Gender ");
		this.genderLabel.setBounds(740,190,80,35);
		this.genderLabel.setForeground(Color.WHITE);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(800,200,70,20);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(900,200,70,20);
		this.panel.add(femaleRB);
		
		this.genderBG=new ButtonGroup();
		this.genderBG.add(maleRB);
		this.genderBG.add(femaleRB);
		
		this.addressLabel=new JLabel("Address ");
		this.addressLabel.setBounds(115,630,100,35);
		this.addressLabel.setForeground(Color.WHITE);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(200,630,150,40);
		this.panel.add(addressTF);
		
		this.securityCodeLabel=new JLabel("Security Code ");
		this.securityCodeLabel.setBounds(760,420,100,30);
		this.securityCodeLabel.setForeground(Color.WHITE);
		this.panel.add(securityCodeLabel);
		
		this.securityCodeTF=new JTextField();
		this.securityCodeTF.setBounds(845,420,150,40);
		this.panel.add(securityCodeTF);
		
		this.passLabel=new JLabel("Password ");
		this.passLabel.setBounds(115,540,100,35);
		this.passLabel.setForeground(Color.WHITE);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(200,540,150,40);
		this.panel.add(passPF);
		
		this.salaryLabel=new JLabel("Salary ");
		this.salaryLabel.setBounds(760,530,100,35);
		this.salaryLabel.setForeground(Color.WHITE);
		this.panel.add(salaryLabel);
		
		
		this.salaryTF=new JTextField();
		this.salaryTF.setBounds(850,530,100,30);
		this.panel.add(salaryTF);
		
		this.jobPostLabel=new JLabel("Job post ");
		this.jobPostLabel.setBounds(760,307,100,35);
		this.jobPostLabel.setForeground(Color.WHITE);
		this.panel.add(jobPostLabel);
		
		String[] item={"Manager", "Customer care "};
		this.jobPostCMB=new JComboBox(item);
		this.jobPostCMB.setBounds(820,300,150,40);
		this.panel.add(jobPostCMB);
		
		this.addBtn=new JButton("Add  ");
		this.addBtn.setBounds(750,600,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update  ");
		this.updateBtn.setBounds(900,600,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove  ");
		this.removeBtn.setBounds(900,700,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search  ");
		this.searchBtn.setBounds(1050,600,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset ");
		this.resetBtn.setBounds(1100,700,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("back ");
		this.backBtn.setBounds(1250,700,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String cmnd=ae.getActionCommand();
		
		if(addBtn.getText().equals(cmnd))
		{
			String userId,name,gmail,phone,gender,address,securityCode,pass,jobPost;
			double salary;
			
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!gmailTF.getText().isEmpty()) && (jobPostCMB.getSelectedItem()!=null)&&(!phoneTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!salaryTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityCodeTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				
				userId=userTF.getText();
				UserRepo urp=new UserRepo();
				
				User user=urp.searchUser(userId);
				
				if(user==null)
				{
					
					try
					{
						
						name=nameTF.getText();
						
						gmail=gmailTF.getText();
						
						phone=phoneTF.getText();
						
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}
						
						salary=Double.parseDouble(salaryTF.getText());
						
						address=addressTF.getText();
						
						int role=2;
						
						securityCode=securityCodeTF.getText();
						
						pass=passPF.getText();
						
						jobPost=jobPostCMB.getSelectedItem().toString();
						Employee e=new Employee(name,userId,pass,gender,address,gmail,securityCode,phone,role,jobPost,salary);
						
						urp.addUser(e);

						EmployeeRepo emp=new EmployeeRepo();
						
						emp.addEmployee(e);
						
						JOptionPane.showMessageDialog(this,"Employee added Successfully");
					}
					catch(Exception e)
					{
						
						JOptionPane.showMessageDialog(this,"Provide valid Salary");
					}
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}
		
			}
			else
			{
				
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
			
		}
		
		if(updateBtn.getText().equals(cmnd))
		{
			
			String userId,name,gmail,phone,gender,address,securityCode,pass,jobPost;
			double salary;
			
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty())&&(!passPF.getText().isEmpty()) && (!gmailTF.getText().isEmpty()) && (!phoneTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!salaryTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				
				userId=userTF.getText();
				EmployeeRepo emp=new EmployeeRepo();
				Employee e=emp.searchEmployee(userId);
				
				if(e!=null)
				{
					
					try
					{
						
						name=nameTF.getText();
						pass=passPF.getText();
						gmail=gmailTF.getText();
						phone=phoneTF.getText();
						
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}
						salary=Double.parseDouble(salaryTF.getText());
						address=addressTF.getText();
						jobPost=jobPostCMB.getSelectedItem().toString();					
						e.setName(name);
						e.setGmail(gmail);
						e.setPass(pass);
						e.setPhone(phone);
						e.setGender(gender);
						e.setSalary(salary);
						e.setAddress(address);
						e.setJobPost(jobPost);						
						emp.updateEmployee(e);
						JOptionPane.showMessageDialog(this,"Employee details updated Successfully");
					}
					catch(Exception ee)
					{
						JOptionPane.showMessageDialog(this,"provide valid salary");
					}
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this," unvalid user ID");
				}
		
			}
			else
			{
				
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		if(removeBtn.getText().equals(cmnd))
		{
			String userId;
			
			if(!userTF.getText().isEmpty()) 
			{
				
				userId=userTF.getText();
				EmployeeRepo emp=new EmployeeRepo();
				Employee e=emp.searchEmployee(userId);
				if(e!=null)
				{
					UserRepo urp=new UserRepo();
					urp.deleteUser(userId);
					emp.deleteEmployee(userId);
					JOptionPane.showMessageDialog(this,"Employee removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"unvalid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please Provide a valid userId");
			}
		}
		
		if(searchBtn.getText().equals(cmnd))
		{
			String userId;
			
			if(!userTF.getText().isEmpty())
			{
				
				userId=userTF.getText();
				
				EmployeeRepo emp=new EmployeeRepo();
				
				Employee e=emp.searchEmployee(userId);
				
				if(e!=null)
				{
					
					userTF.setEditable(false);
					
					nameTF.setText(e.getName());
					
					gmailTF.setText(e.getGmail());
					
					phoneTF.setText(e.getPhone());
					
					if(e.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}
					
					if(e.getJobPost().equals("Manager"))
					{
						jobPostCMB.setSelectedItem("Manager");
					}
					else
					{
						jobPostCMB.setSelectedItem("Customer care");
					}
					
					salaryTF.setText(String.valueOf(e.getSalary()));
					
					addressTF.setText(e.getAddress());
					
					JOptionPane.showMessageDialog(this,"Employee found");
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"Employee not found");
				}
			}
			
			else
			{
				
				JOptionPane.showMessageDialog(this,"Please provide userId ");
			}
			
		}
		
		if(resetBtn.getText().equals(cmnd))
		{
			
			userTF.setEditable(true);
			userTF.setText("");
			nameTF.setText("");
			gmailTF.setText("");
			phoneTF.setText("");
			salaryTF.setText("");
			addressTF.setText("");
			securityCodeTF.setText("");
			passPF.setText("");
			JOptionPane.showMessageDialog(this,"reset successfully");
		}
		
		if(backBtn.getText().equals(cmnd))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
		}
	}
	
}