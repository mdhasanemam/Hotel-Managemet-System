package cse215;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainPage extends JFrame{
	private Container c;
	private ImageIcon icon;
	//private JPanel singPanel, logPanel, usrPanel;
	private JButton zero, signpButton, loginButton, exitButton, employeeButton, aboutButtons;
	MainPage(int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(140,140,200);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Welcome");
		this.setBounds(x,y, 1000,700);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon_2.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/
		
		zero = new JButton(); zero.setBounds(0,0,0,0); c.add(zero);

		
		ImageIcon hotelImg = new ImageIcon(getClass().getResource("images/HotelAmar.png"));
		JLabel hotelIcon = new JLabel(hotelImg);
		hotelIcon.setBounds(350,50,280,200);
		c.add(hotelIcon);


		JLabel welcome = new JLabel("WELCOME to YOUSUF INN");
		welcome.setFont(new Font("Didot",Font.BOLD,50));
		welcome.setBounds(170, 250, 1100,100);
		c.add(welcome);


		loginButton = new JButton("GUEST LOGIN");
		loginButton.setBackground(new Color(10,93,201));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Didot",Font.BOLD,25));
		loginButton.setBounds(175,400,250,65);
		c.add(loginButton);

		
		signpButton = new JButton("NEW GUEST");
		signpButton.setBounds(525,400,250,65);
		signpButton.setBackground(new Color(204,102,0));
		signpButton.setForeground(Color.WHITE);
		signpButton.setFont(new Font("Didot",Font.BOLD,25));
		c.add(signpButton);


		employeeButton = new JButton("EMPLOYEE");
		employeeButton.setBackground(new Color(0,153,0));
		employeeButton.setForeground(Color.WHITE);
		employeeButton.setFont(new Font("Didot",Font.BOLD,15));
		employeeButton.setBounds(90,520,150,50);
		c.add(employeeButton);


		aboutButtons = new JButton("ABOUT  THIS  PROJECT  AND  US");
		aboutButtons.setBackground(new Color(96,96,96));
		aboutButtons.setForeground(Color.WHITE);
		aboutButtons.setFont(new Font("Didot",Font.BOLD,18));
		aboutButtons.setBounds(300,520,380,50);
		c.add(aboutButtons);


		exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.RED);
		exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("Didot",Font.BOLD,15));
		exitButton.setBounds(770,520,100,50);
		c.add(exitButton);


		signpButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				SignupPage signup = new SignupPage(x,y);
				signup.setVisible(true);
				dispose();
			}
		});

		loginButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				LoginPage login = new LoginPage(x,y);
				login.setVisible(true);	
				dispose();
			}
		});
		employeeButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				EmployeePage help = new EmployeePage(x,y);
				help.setVisible(true);
				dispose();
			}
		});
		aboutButtons.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				AboutPage about = new AboutPage(x,y);
				about.setVisible(true);	
				dispose();
			}
		});
		
		exitButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

		
	}
}