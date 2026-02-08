package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class CustomerHomeFrame extends JFrame implements ActionListener
{
	
	private JButton ownedPackageBtn, offeredPackagesBtn, registrationPackagesBtn,  viewAllPackagesBtn, changePinBtn, profileBtn, exitBtn;
	private JPanel panel;
	private ImageIcon img;
	
	
	public CustomerHomeFrame()
	{
		
		super("Customer Home Frame");
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
		
		
		this.ownedPackageBtn=new JButton("Owned Packages");
		this.ownedPackageBtn.setBounds(250,150,150,50);
		this.ownedPackageBtn.addActionListener(this);
		this.panel.add(ownedPackageBtn);
		
		this.offeredPackagesBtn=new JButton("Offered Packages");
		this.offeredPackagesBtn.setBounds(490,150,150,50);
		this.offeredPackagesBtn.addActionListener(this);
		this.panel.add(offeredPackagesBtn);
		
		this.registrationPackagesBtn=new JButton("Package Registration");
		this.registrationPackagesBtn.setBounds(730,150,150,50);
		this.registrationPackagesBtn.addActionListener(this);
		this.panel.add(registrationPackagesBtn);
		
		this.viewAllPackagesBtn=new JButton("All Packages");
		this.viewAllPackagesBtn.setBounds(250,250,150,50);
		this.viewAllPackagesBtn.addActionListener(this);
		this.panel.add(viewAllPackagesBtn);
		
		this.changePinBtn=new JButton("Change Pin");
		this.changePinBtn.setBounds(490,250,150,50);
		this.changePinBtn.addActionListener(this);
		this.panel.add(changePinBtn);
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(730,250,150,50);
		this.profileBtn.addActionListener(this);
		this.panel.add(profileBtn);
		
		this.exitBtn=new JButton("Log Out");
		this.exitBtn.setBounds(490,350,150,50);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		
		
		
		
		this.add(panel);
		
	}
	
	
public void actionPerformed(ActionEvent a)
	{
		String cmnd=a.getActionCommand();
		if(this.exitBtn.getText().equals(cmnd))
        {
			LogInFrame l=new LogInFrame();
			this.setVisible(false);
			l.setVisible(true);
		}
		if( this.viewAllPackagesBtn.getText().equals(cmnd))
		{
			ViewAllPackages v= new ViewAllPackages();
			this.setVisible(false);
			v.setVisible(true);
		}
			
	}
	
	
}