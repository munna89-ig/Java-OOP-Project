package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repositories.*;
import entities.*;
public class LogInFrame extends JFrame implements ActionListener
{
	private JPanel panel;
    private JLabel userIdLabel, passLabel, titleLabel,extraLabel;
    private JTextField userIdTF;
    private JPasswordField passPF;
    private JButton loginBTN, signUpBTN,exitBTN,forgetPassBtn;
	private ImageIcon img;
	private Font myFont;
	
	public LogInFrame()
	{
		super("Login Frame");
		this.setSize(1800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myFont=new Font("Arial",Font.BOLD,24);
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
		
		this.titleLabel=new JLabel("Welcome to JAVA Internet");
		this.titleLabel.setBounds(400,50,500,20);
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(myFont);
		this.panel.add(titleLabel);
		
		this.userIdLabel=new JLabel("User Id");
		this.userIdLabel.setBounds(500,200,50,20);
		this.userIdLabel.setForeground(Color.WHITE);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(560,200,400,40);
		this.panel.add(userIdTF);
		
		
		
		this.loginBTN=new JButton("Login");
		this.loginBTN.setBounds(600,350,100,40);
		this.loginBTN.addActionListener(this);
		this.panel.add(loginBTN);
		
		this.signUpBTN=new JButton("Sign up");this.passLabel=new JLabel("Password");
		this.passLabel.setBounds(500,250,70,20);
		this.passLabel.setForeground(Color.WHITE);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(560,250,400,40);
		this.panel.add(passPF);
		this.signUpBTN.setBounds(750,420,100,40);
		this.signUpBTN.addActionListener(this);
		this.panel.add(signUpBTN);
		
		this.extraLabel=new JLabel("Don't have any account?");
		this.extraLabel.setBounds(600,420,300,40);
		this.extraLabel.setForeground(Color.WHITE);
		this.panel.add(extraLabel);
		
		this.exitBTN=new JButton("Exit");
		this.exitBTN.setBounds(750,350,100,40);
		this.exitBTN.addActionListener(this);
		this.panel.add(exitBTN);
		
		this.forgetPassBtn=new JButton("Forget pass");
		this.forgetPassBtn.setBounds(870,350,130,40);
		this.forgetPassBtn.addActionListener(this);
		this.panel.add(forgetPassBtn);
		
		this.add(this.panel);
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String cmnd=a.getActionCommand();
		
		if(this.loginBTN.getText().equals(cmnd))
		{
			String uId=userIdTF.getText();
			String pass=passPF.getText();
			UserRepo urp=new UserRepo();
			User user=urp.searchUser(uId);
			
			if(user!=null)
			{
				if(user.getUserId().equals(uId)&& user.getPassword().equals(pass)&&user.getRole()==1)
				{
					AdminHomeFrame admn=new AdminHomeFrame(user);
					this.setVisible(false);
					admn.setVisible(true);
				}
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==2)
				{
					EmployeeHomeFrame e = new EmployeeHomeFrame();
					this.setVisible(false);
					e.setVisible(true);
				}
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==3)
				{
					CustomerHomeFrame cstm=new CustomerHomeFrame();
					this.setVisible(false);
					cstm.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
			}
					
		}
		if(this.signUpBTN.getText().equals(cmnd))
		{
			SignUpFrame s= new SignUpFrame();
			this.setVisible(false);
			s.setVisible(true);
		}
		if(this.forgetPassBtn.getText().equals(cmnd))
		{
			ForgetPassFrame f= new ForgetPassFrame();
			this.setVisible(false);
			f.setVisible(true);
		}
		
		 if(exitBTN.getText().equals(cmnd))
		{
			System.exit(0);
		}
		
		
	}
}