package cse215;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Farmacy extends JFrame{
	private Container c;
	private ImageIcon icon;
	//private JPanel singPanel, logPanel, usrPanel;
	private JButton zero, backButton, bookingButton;
	Farmacy(User user, int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pharmacy");
		this.setBounds(x,y, 1000,750);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon_2.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/
		
		zero = new JButton(); zero.setBounds(0,0,0,0); c.add(zero);
		
		
		
		backButton = new JButton("BACK");
		backButton.setBackground(Color.RED);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Didot",Font.BOLD,15));
		backButton.setBounds(450,620,100,50);
		c.add(backButton);
		
		/*   Back action*/
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				UserPage about = new UserPage(user,x,y);
				about.setVisible(true);	
				dispose();
			}
		});
	
	}
	}
