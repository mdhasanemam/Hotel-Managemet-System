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

public class SeaView extends JFrame{
	private Container c;
	private ImageIcon icon;
	//private JPanel singPanel, logPanel, usrPanel;
	private JButton zero, backButton, bookingButton;
	SeaView(User user, int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sea View Room");
		this.setBounds(x,y, 1000,750);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon_2.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/
		
		zero = new JButton(); zero.setBounds(0,0,0,0); c.add(zero);
		
		ImageIcon hotelImg = new ImageIcon(getClass().getResource("images/SeaView3.png"));
		JLabel hotelIcon = new JLabel(hotelImg);
		hotelIcon.setBounds(70,0,800,500);
		c.add(hotelIcon);
		

		JLabel offerName = new JLabel("OFFER : i.Breakfast ii. Gym iii. Swimming Pool ");
		offerName.setBounds(240,490,700,50);
		offerName.setFont(new Font("Arial", Font.BOLD,25));
		c.add(offerName); 

		JLabel priceName = new JLabel("<html>PRICE :Double Bed Tk. 5000(incl. 15% vat) per night<br>"
				+ "Single Bed Tk. 4500(incl. 15% vat) per night</html>");
											 
		priceName.setBounds(240,535,700,60);
		priceName.setFont(new Font("Arial", Font.BOLD,25));
		c.add(priceName); 
		
		
		backButton = new JButton("BACK");
		backButton.setBackground(Color.RED);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Didot",Font.BOLD,15));
		backButton.setBounds(50,620,100,50);
		c.add(backButton);
		
		bookingButton = new JButton("BOOKING");
		bookingButton.setBackground(Color.GREEN);
		bookingButton.setForeground(Color.WHITE);
		bookingButton.setFont(new Font("Didot",Font.BOLD,15));
		bookingButton.setBounds(770,620,180,50);
		c.add(bookingButton);
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
		/*   Booking Button Action */
		
		bookingButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				BookingPage about = new BookingPage(user,x,y);
				about.setVisible(true);	
				dispose();
			}
		});
}}