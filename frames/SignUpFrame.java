package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repositories.*;
import entities.*;
public class SignUpFrame extends JFrame implements ActionListener
{ 
    private JPanel panel;
    private JLabel nameLabel,titleLabel,phoneLabel,gmailLabel,userIdLabel,passLabel,genderLabel,addressLabel,packLabel,securityCodeLabel;
	private JTextField nameTF,phoneTF,gmailTF,userTF,addressTF,securityCodeTF;
	private JPasswordField passPF;
	private JButton signInBTN,backBTN;
	private JRadioButton maleRB,femaleRB;
	private ButtonGroup genderBG;
	private Font myFont;
	private JComboBox packCMB;
	private ImageIcon img;
	
	public SignUpFrame()
	{
		super("Sign up frame");
		this.setSize(1800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myFont=new Font("Arial",Font.BOLD,24);
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
		
		
		
		this.nameLabel=new JLabel(" Name ");
		this.nameLabel.setBounds(115,180,100,35);
		this.nameLabel.setForeground(Color.WHITE);
		this.panel.add(nameLabel);
		
		this.titleLabel=new JLabel("Java Internet Sign up");
		this.titleLabel.setFont(myFont);
		this.titleLabel.setBounds(500,50,500,40);
		this.titleLabel.setForeground(Color.WHITE);
		this.panel.add(titleLabel);
		
		this.phoneLabel=new JLabel("Phone ");
		this.phoneLabel.setBounds(120,270,70,35);
		this.phoneLabel.setForeground(Color.WHITE);
		this.panel.add(phoneLabel);
		
		this.gmailLabel=new JLabel("Gmail ");
		this.gmailLabel.setBounds(120,360,70,35);
		this.gmailLabel.setForeground(Color.WHITE);
		this.panel.add(gmailLabel);
		
		this.userIdLabel=new JLabel("User id ");
		this.userIdLabel.setBounds(115,450,100,35);
		this.userIdLabel.setForeground(Color.WHITE);
		this.panel.add(userIdLabel);
		
		this.passLabel=new JLabel("Password ");
		this.passLabel.setBounds(115,540,100,35);
		this.passLabel.setForeground(Color.WHITE);
		this.panel.add(passLabel);
		
		this.addressLabel=new JLabel("Address ");
		this.addressLabel.setBounds(115,630,100,35);
		this.addressLabel.setForeground(Color.WHITE);
		this.panel.add(addressLabel);
		
		this.genderLabel=new JLabel("Gender ");
		this.genderLabel.setBounds(740,195,80,35);
		this.genderLabel.setForeground(Color.WHITE);
		this.panel.add(genderLabel);
		
		this.packLabel=new JLabel("Package ");
		this.packLabel.setBounds(760,307,100,35);
		this.packLabel.setForeground(Color.WHITE);
		this.panel.add(packLabel);
		
		this.securityCodeLabel=new JLabel("Security code ");
		this.securityCodeLabel.setBounds(760,420,130,35);
		this.securityCodeLabel.setForeground(Color.WHITE);
		this.panel.add(securityCodeLabel);
		
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(200,180,150,40);
		this.panel.add(nameTF);
		
		this.phoneTF=new JTextField();
		this.phoneTF.setBounds(200,270,150,40);
		this.panel.add(phoneTF);
		
		this.gmailTF=new JTextField();
		this.gmailTF.setBounds(200,360,150,40);
		this.panel.add(gmailTF);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(200,450,150,40);
		this.panel.add(userTF);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(200,630,150,40);
		this.panel.add(addressTF);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(200,540,150,40);
		this.panel.add(passPF);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(800,200,70,20);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(900,200,70,20);
		this.panel.add(femaleRB);
		
		this.genderBG=new ButtonGroup();
		this.genderBG.add(maleRB);
		this.genderBG.add(femaleRB);
		
		String pack[]={"20 Mbps","30 Mbps","40 Mbps","50 Mbps","60 Mbps"};
		this.packCMB=new JComboBox(pack);
		this.packCMB.setBounds(820,300,150,40);
		this.panel.add(packCMB);
		
		this.securityCodeTF=new JTextField();
		this.securityCodeTF.setBounds(855,420,150,40);
		this.panel.add(securityCodeTF);
		
		this.signInBTN=new JButton("Sign In");
		this.signInBTN.setBounds(500,680,100,40);
		this.signInBTN.setForeground(Color.BLACK);
		this.signInBTN.addActionListener(this);
		this.panel.add(signInBTN);
		
		this.backBTN=new JButton("back");
		this.backBTN.setBounds(700,680,100,40);
		this.backBTN.setForeground(Color.BLACK);
		this.backBTN.addActionListener(this);
		this.panel.add(backBTN);
		
		this.add(this.panel);
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String cmnd= a.getActionCommand();
		if(this.signInBTN.getText().equals(cmnd))
		{
			String userId,name,gmail,phone,gender,address,securityCode,pass,customerType,customerSubscription;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!gmailTF.getText().isEmpty()) && (!phoneTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) &&  (!addressTF.getText().isEmpty())&& (!securityCodeTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
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
						customerSubscription=packCMB.getSelectedItem().toString();
						address=addressTF.getText();
						int role=3;
						securityCode=securityCodeTF.getText();
						pass=passPF.getText();
						Customer c=new Customer(name,userId,pass,gender,address,gmail,securityCode,phone,role,customerSubscription);
						urp.addUser(c);
						CustomerRepo crp=new CustomerRepo();						
						crp.addCustomer(c);						
						JOptionPane.showMessageDialog(this," signed up Successfully");
					}
					catch(Exception e)
					{
						
						JOptionPane.showMessageDialog(this,"provide information");
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
		
		
		if(this.backBTN.getText().equals(cmnd))
		{
			
			LogInFrame l=new LogInFrame();
			this.setVisible(false);
			l.setVisible(true);
		}
	}
			
		
		
		
		
	
}