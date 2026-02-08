package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AdminOperationFrame extends JFrame implements ActionListener
{
	private JLabel nameLabel, userIdLabel, passLabel, genderLabel, addressLabel, gmailLabel, securityCodeLabel, securityAnsLabel, phoneLabel, adminSectorLabel;
	private JTextField nameTF, userIdTF, addressTF, gmailTF,  securityAnsTF, phoneTF ;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup genderBg;
	private JComboBox adminSectorCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable adminTable;
	private JScrollPane adminTableSP;
	private ImageIcon img;
	private JPanel panel;
	private User u;
	
	
	
	public AdminOperationFrame(User u)
	{
		super("Admin Operation Frame");
		this.setSize(1800,800);
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
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,50,90,50);
		this.nameLabel.setForeground(Color.WHITE);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(110,60,120,30);
		this.panel.add(nameTF);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,90,90,50);
		this.userIdLabel.setForeground(Color.WHITE);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(110,100,120,30);
		this.panel.add(userIdTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,240,90,50);
		this.genderLabel.setForeground(Color.WHITE);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(120,240,90,50);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(190,240,100,50);
		this.panel.add(femaleRB);
		
		this.genderBg=new ButtonGroup();
		this.genderBg.add(maleRB);
		this.genderBg.add(femaleRB);		
		
		this.gmailLabel=new JLabel("Gmail:");
		this.gmailLabel.setBounds(50,130,90,50);
		this.gmailLabel.setForeground(Color.WHITE);
		this.panel.add(gmailLabel);
		
		this.gmailTF=new JTextField();
		this.gmailTF.setBounds(110,140,120,30);
		this.panel.add(gmailTF);
		
		this.phoneLabel=new JLabel("Phone:");
		this.phoneLabel.setBounds(50,170,90,50);
		this.phoneLabel.setForeground(Color.WHITE);
		this.panel.add(phoneLabel);
		
		this.phoneTF=new JTextField();
		this.phoneTF.setBounds(110,180,120,30);
		this.panel.add(phoneTF);
		

		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(280,50,90,50);
		this.addressLabel.setForeground(Color.WHITE);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(350,60,120,30);
		this.panel.add(addressTF);
		
		this.securityCodeLabel=new JLabel("Security Code (Write 4 digits code)");
		this.securityCodeLabel.setBounds(280,90,300,50);
		this.securityCodeLabel.setForeground(Color.WHITE);
		this.panel.add(securityCodeLabel);
		
		this.securityAnsLabel=new JLabel("Write here");
		this.securityAnsLabel.setBounds(280,130,90,50);
		this.securityAnsLabel.setForeground(Color.WHITE);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(350,140,120,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(280,170,90,50);
		this.passLabel.setForeground(Color.WHITE);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(350,180,120,30);
		this.panel.add(passPF);
		
		this.adminSectorLabel=new JLabel("Admin Sector");
		this.adminSectorLabel.setBounds(280,240,100,50);
		this.adminSectorLabel.setForeground(Color.WHITE);
		this.panel.add(adminSectorLabel);
		
		String[] item={"Developer", "Customer admin"};
		this.adminSectorCMB=new JComboBox(item);
		this.adminSectorCMB.setBounds(370,250,150,30);
		this.panel.add(adminSectorCMB);
		
		this.addBtn=new JButton("Add Admin");
		this.addBtn.setBounds(580,60,120,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("update Admin");
		this.updateBtn.setBounds(580,100,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("remove Admin");
		this.removeBtn.setBounds(580,140,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("search Admin");
		this.searchBtn.setBounds(580,180,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(580,220,120,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(580,260,120,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
	
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			String name,userId,gmail,phone,gender,address,securityAns,pass,adminSector;
			
			if((!nameTF.getText().isEmpty()) && (!userIdTF.getText().isEmpty()) && (!gmailTF.getText().isEmpty()) && (!phoneTF.getText().isEmpty()) &&(maleRB.isSelected()) || (femaleRB.isSelected()) &&  (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				
				userId=userIdTF.getText();
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
						
						address=addressTF.getText();
						
						int role=1;
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();

						adminSector=adminSectorCMB.getSelectedItem().toString();
					
						Admin a=new Admin(name,userId,pass,gender,address,gmail,securityAns,phone,role,adminSector);
						
						urp.addUser(a);
						AdminRepo arp=new AdminRepo();
						arp.addAdmin(a);
						
						JOptionPane.showMessageDialog(this,"admin added Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"provide valid information");
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
		
		if(command.equals(updateBtn.getText()))
		{
			
			String name,userId,gmail,phone,gender,address,adminSector;
			
		
			if((!nameTF.getText().isEmpty()) && (!userIdTF.getText().isEmpty()) && (!gmailTF.getText().isEmpty()) && (!phoneTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) &&  (!addressTF.getText().isEmpty()))
			{
				
				userId=userIdTF.getText();
				AdminRepo arp=new AdminRepo();
				Admin a=arp.searchAdmin(userId);
				
				if(a!=null)
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
					
						address=addressTF.getText();
						
						adminSector=adminSectorCMB.getSelectedItem().toString();
					
						a.setName(name);
						a.setGmail(gmail);
						a.setPhone(phone);
						a.setGender(gender);
						a.setAddress(address);
						a.setAdminSector(adminSector);
						
						arp.updateAdmin(a);
						JOptionPane.showMessageDialog(this,"admin updated Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"provide valid information");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			
			if(!userIdTF.getText().isEmpty()) 
			{
				userId=userIdTF.getText();
				AdminRepo arp=new AdminRepo();
				Admin a=arp.searchAdmin(userId);
				if(a!=null)
				{
					
					UserRepo urp=new UserRepo();
					urp.deleteUser(userId);
					arp.deleteAdmin(userId);
					JOptionPane.showMessageDialog(this,"Admin removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please Provide a valid userId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String userId;
			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText();
				AdminRepo urp=new AdminRepo();
				Admin a=urp.searchAdmin(userId);
				if(a!=null)
				{
					
					userIdTF.setEditable(false);
					nameTF.setText(a.getName());
					gmailTF.setText(a.getGmail());
					phoneTF.setText(a.getPhone());
					if(a.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}
					if(a.getAdminSector().equals("Developer"))
					{
						adminSectorCMB.setSelectedItem("Developer");
					}
					else
					{
						adminSectorCMB.setSelectedItem("Customer Admin");
					}
					
					addressTF.setText(a.getAddress());
					JOptionPane.showMessageDialog(this,"admin found");
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"admin not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide userId to search admin.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{
			
			userIdTF.setEditable(true);
			userIdTF.setText("");
			nameTF.setText("");
			gmailTF.setText("");
			phoneTF.setText("");
			addressTF.setText("");
			securityAnsTF.setText("");
			passPF.setText("");
			JOptionPane.showMessageDialog(this,"reset successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{
			
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
	
}
