package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CustomerOperationFrame extends JFrame implements ActionListener
{   
	
	private JLabel userIdLabel,nameLabel, gmailLabel, phoneLabel, genderLabel, addressLabel,securityCodeLabel, passLabel,subscriptionLabel;
	private JTextField userTF, nameTF, gmailTF, phoneTF,addressTF, securityCodeTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup genderBG;
	private JComboBox subscriptionCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JPanel panel;
	private ImageIcon img;
	private User u;
	
	
	
	
	public CustomerOperationFrame(User u)
	{
		super("Customer Operation Frame");
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
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(120,270,70,35);
		this.userIdLabel.setForeground(Color.WHITE);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(200,270,150,40);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(120,180,150,40);
		this.nameLabel.setForeground(Color.WHITE);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(200,180,150,40);
		this.panel.add(nameTF);
		
		this.gmailLabel=new JLabel("Gmail:");
		this.gmailLabel.setBounds(120,360,70,35);
		this.gmailLabel.setForeground(Color.WHITE);
		this.panel.add(gmailLabel);
		
		this.gmailTF=new JTextField();
		this.gmailTF.setBounds(200,360,150,40);
		this.panel.add(gmailTF);
		
		this.phoneLabel=new JLabel("Phone No:");
		this.phoneLabel.setBounds(115,450,100,35);
		this.phoneLabel.setForeground(Color.WHITE);
		this.panel.add(phoneLabel);
		
		this.phoneTF=new JTextField();
		this.phoneTF.setBounds(200,450,150,40);
		this.panel.add(phoneTF);
		
		this.genderLabel=new JLabel("Gender:");
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
		
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(115,630,100,35);
		this.addressLabel.setForeground(Color.WHITE);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(200,630,100,35);
		this.panel.add(addressTF);
	
		
		this.securityCodeLabel=new JLabel("Security Code:");
		this.securityCodeLabel.setBounds(750,460,100,30);
		this.securityCodeLabel.setForeground(Color.WHITE);
		this.panel.add(securityCodeLabel);
		
		this.securityCodeTF=new JTextField();
		this.securityCodeTF.setBounds(845,450,150,40);
		this.panel.add(securityCodeTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(115,540,100,35);
		this.passLabel.setForeground(Color.WHITE);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(200,540,150,40);
		this.panel.add(passPF);
		
		this.subscriptionLabel=new JLabel("Subscription ");
		this.subscriptionLabel.setBounds(740,400,100,35);
		this.subscriptionLabel.setForeground(Color.WHITE);
		this.panel.add(subscriptionLabel);
		
		String[] item1={"20Mbps", "30Mbps","40Mbps","50Mbps","60Mbps"};
		this.subscriptionCMB=new JComboBox(item1);
		this.subscriptionCMB.setBounds(820,400,150,40);
		this.panel.add(subscriptionCMB);
		
		this.addBtn=new JButton("Add ");
		this.addBtn.setBounds(750,600,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update ");
		this.updateBtn.setBounds(900,600,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove ");
		this.removeBtn.setBounds(900,700,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search ");
		this.searchBtn.setBounds(1050,600,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(1100,700,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(1250,700,100,30);
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
			String userId,name,gmail,phone,gender,address,securityCode,pass,subscription;
			
			
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!gmailTF.getText().isEmpty()) && (!phoneTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!addressTF.getText().isEmpty())&& (!securityCodeTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
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
	
					
						address=addressTF.getText();
						
						int role=3;
						
						securityCode=securityCodeTF.getText();
						
						pass=passPF.getText();
						
						
						
						subscription=subscriptionCMB.getSelectedItem().toString();
						
						Customer c=new Customer(name,userId,pass,gender,address,gmail,securityCode,phone,role,subscription);
					
						urp.addUser(c);
					
						CustomerRepo crp=new CustomerRepo();
					
						crp.addCustomer(c);
						
						JOptionPane.showMessageDialog(this,"Customer Added Successfully");
					}
					catch(Exception e)
					{
						
						JOptionPane.showMessageDialog(this,"Provide Valid Information");
					}
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"User Id Already Exists.");
				}
		
			}
			else
			{
				
				JOptionPane.showMessageDialog(this,"Please Fill UP All The Field Properly");
			}
			
		}
		
		if(command.equals(updateBtn.getText()))
		{
			
			String userId,name,gmail,pass,phone,gender,address,subscription;
		

			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty())&&(!passPF.getText().isEmpty()) && (!gmailTF.getText().isEmpty()) && (!phoneTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!addressTF.getText().isEmpty()))
			{
				
				userId=userTF.getText();
				
				CustomerRepo crp=new CustomerRepo();
			
				Customer c=crp.searchCustomer(userId);
			
				if(c!=null)
				{
				
					try
					{
						name=nameTF.getText();
						
						gmail=gmailTF.getText();
						
						phone=phoneTF.getText();
						pass=passPF.getText();
					
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
						subscription=subscriptionCMB.getSelectedItem().toString();
					
					    c.setPass(pass);
						c.setName(name);
						c.setGmail(gmail);
						c.setPhone(phone);
						c.setGender(gender);
						c.setAddress(address);
						c.setCustomerSubscription(subscription);
					    crp.updateCustomer(c);

						JOptionPane.showMessageDialog(this,"Customer Updated Successfully");
					}
					catch(Exception e)
					{
						
						JOptionPane.showMessageDialog(this,"Provide Valid Information");
					}
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"Provide Valid User ID");
				}
		
			}
			else
			{
				
				JOptionPane.showMessageDialog(this,"Please Fill UP All The Field Properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			
			if(!userTF.getText().isEmpty()) 
			{
			
				userId=userTF.getText();
			
				CustomerRepo crp=new CustomerRepo();
			
				Customer c=crp.searchCustomer(userId);
				
				if(c!=null)
				{

					UserRepo urp=new UserRepo();
					
					urp.deleteUser(userId);
					
					crp.deleteCustomer(userId);
					
					JOptionPane.showMessageDialog(this,"Customer Removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid User ID");
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
		
			if(!userTF.getText().isEmpty())
			{
				userId=userTF.getText();
				
				CustomerRepo crp=new CustomerRepo();
				
				Customer c=crp.searchCustomer(userId);
			
				if(c!=null)
				{
				
					userTF.setEditable(false);

					nameTF.setText(c.getName());

					gmailTF.setText(c.getGmail());
					passPF.setText(c.getPassword());

					phoneTF.setText(c.getPhone());

					if(c.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}
				
					addressTF.setText(c.getAddress());

					JOptionPane.showMessageDialog(this,"Customer Found");
				}
				
				else
				{
					
					JOptionPane.showMessageDialog(this,"Customer Not Found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please Provide User ID To Search Customer.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{

			userTF.setEditable(true);
			userTF.setText("");
			nameTF.setText("");
			gmailTF.setText("");
			phoneTF.setText("");
			addressTF.setText("");
			securityCodeTF.setText("");
			passPF.setText("");
			JOptionPane.showMessageDialog(this,"Reset Successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{

			AdminHomeFrame a=new AdminHomeFrame(this.u);
			this.setVisible(false);
			a.setVisible(true);
		}
	}
	
}