package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;
public class ForgetPassFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, passLabel,securityCodeLabel;
	private JTextField userTF,securityCodeTF;
	private JPasswordField passPF;
	private JButton  exitBtn, setBtn;
	private JPanel panel;
	private ImageIcon img;
	
	public ForgetPassFrame()
	{
		super("Forger password Frame");
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
		
		this.userIdLabel=new JLabel("User Id");
		this.userIdLabel.setBounds(500,200,50,20);
		this.userIdLabel.setForeground(Color.WHITE);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(560,200,400,40);
		this.panel.add(userTF);
		
		this.securityCodeLabel=new JLabel("Security Code");
		this.securityCodeLabel.setBounds(430,250,100,20);
		this.securityCodeLabel.setForeground(Color.WHITE);
		this.panel.add(securityCodeLabel);
		
		this.securityCodeTF=new JPasswordField();
		this.securityCodeTF.setBounds(560,250,400,40);
		this.panel.add(securityCodeTF);
		
		this.passLabel=new JLabel("New Password:");
		this.passLabel.setBounds(440,300,100,20);
		this.passLabel.setForeground(Color.WHITE);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(560,300,400,40);
		this.panel.add(passPF);
		
		
		this.setBtn=new JButton("set");
		this.setBtn.setBounds(600,400,100,30);
		this.setBtn.addActionListener(this);
		this.panel.add(setBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(730,400,60,30);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(this.setBtn.getText().equals(command));
		{
			String userId,securityCode,pass;
			if((!userTF.getText().isEmpty())&&(!securityCodeTF.getText().isEmpty()))
			{
				userId=userTF.getText();
				UserRepo urp=new UserRepo();
				User u= urp.searchUser(userId);
				
					
			    if((u!=null )&& (securityCodeTF.getText().equals(u.getSecurityCode())))
				{
					
					pass=passPF.getText();
					u.setPass(pass);
					urp.updateUser(u);
					JOptionPane.showMessageDialog(this,"Successsfull");
			    }
				else
				{
					JOptionPane.showMessageDialog(this,"invalid");
				}
			}	
			else
			{
				JOptionPane.showMessageDialog(this,"Fill the box");
			}
			
			
		}
		
		if(this.exitBtn.getText().equals(command))
		{
			LogInFrame l=new LogInFrame();
			this.setVisible(false);
			l.setVisible(true);
		}
	}
}