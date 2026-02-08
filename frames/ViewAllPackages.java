package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repositories.*;
import entities.*;

public class ViewAllPackages extends JFrame implements ActionListener
{
	private JLabel i1Label,i2Label,i3Label,i4Label,i5Label;
	private JPanel panel;
	private ImageIcon img, backImg,i1,i2,i3,i4,i5;
	private JButton exitBTN;
	
	public ViewAllPackages()
	{
		super("View All Packages");
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
		
		this.i1=new ImageIcon("image/1.jpg");
		this.i1Label=new JLabel(i1);
		this.i1Label.setBounds(100,100,300,300);
		this.panel.add(i1Label);
		
		this.i2=new ImageIcon("image/2.jpg");
		this.i2Label=new JLabel(i2);
		this.i2Label.setBounds(500,100,300,300);
		this.panel.add(i2Label);
		
		this.i3=new ImageIcon("image/3.jpg");
		this.i3Label=new JLabel(i3);
		this.i3Label.setBounds(900,100,300,300);
		this.panel.add(i3Label);
		
		this.i4=new ImageIcon("image/4.jpg");
		this.i4Label=new JLabel(i4);
		this.i4Label.setBounds(100,400,300,300);
		this.panel.add(i4Label);
		
		this.i5=new ImageIcon("image/5.jpg");
		this.i5Label=new JLabel(i5);
		this.i5Label.setBounds(500,400,300,300);
		this.panel.add(i5Label);
		
		this.exitBTN=new JButton("Exit");
		this.exitBTN.setBounds(100,700,100,40);
		this.exitBTN.addActionListener(this);
		this.panel.add(exitBTN);
		
		this.add(this.panel);
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String cmnd= a.getActionCommand();
	    if(this.exitBTN.getText().equals(cmnd))
		{
			CustomerHomeFrame c =new CustomerHomeFrame();
			this.setVisible(false);
			c.setVisible(true);
		}
	}
}