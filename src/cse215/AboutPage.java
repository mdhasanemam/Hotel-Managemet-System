
package cse215;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AboutPage extends JFrame{
	private Container c;
	private ImageIcon icon;
	//private JPanel singPanel, logPanel, usrPanel;
	//private Jlavel 
	private JButton zero, backButton;
	AboutPage(int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("About this project and us");
		this.setBounds(x,y, 1000,700);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon_2.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/
		
		zero = new JButton(); zero.setBounds(0,0,0,0); c.add(zero);
		
//######################## Project ####################################################

		JLabel project = new JLabel("Project");
		project.setBounds(50,10,700,50);
		project.setFont(new Font("Arial", Font.BOLD,25));
		c.add(project);

		JLabel projectName = new JLabel("Name: Internet Hotel Management System");
		projectName.setBounds(150,30,700,50);
		projectName.setFont(new Font("Arial", Font.PLAIN,25));
		c.add(projectName); 

		JLabel courseName = new JLabel("Course: CSE215 (Programming Language II)");
		courseName.setBounds(150,70,700,50);
		courseName.setFont(new Font("Arial", Font.PLAIN,25));
		c.add(courseName); 

		JLabel languageName = new JLabel("Language Used: Java and Swing for Graphics");
		languageName.setBounds(150,110,700,50);
		languageName.setFont(new Font("Arial", Font.PLAIN,25));
		c.add(languageName); 
		
//######################## Developers ####################################################


		JLabel developers = new JLabel("Developers");
		developers.setBounds(50,140,700,50);
		developers.setFont(new Font("Arial", Font.BOLD,25));
		c.add(developers);

		JPanel NameIdPanel = new JPanel();
		NameIdPanel.setLayout(null);
		NameIdPanel.setBounds(150, 200, 400, 400);
		NameIdPanel.setBackground(new Color(150,190,250));
		c.add(NameIdPanel);

		JLabel MubasshirNameLabel = new JLabel("Name: Mubasshir Sadat");
		MubasshirNameLabel.setFont(new Font("Gotham", Font.PLAIN,20));
		MubasshirNameLabel.setBounds(20,10,300,50);
		NameIdPanel.add(MubasshirNameLabel);

		JLabel MubasshirIDLabel = new JLabel("ID: 2212468642");
		MubasshirIDLabel.setFont(new Font("Gotham", Font.PLAIN,20));
		MubasshirIDLabel.setBounds(20,50,300,50);
		NameIdPanel.add(MubasshirIDLabel);
		
		
		JLabel YousufNameJLabel = new JLabel("Name:Abu yousuf Neshad");
		YousufNameJLabel.setFont(new Font("Gotham", Font.PLAIN,20));
		YousufNameJLabel.setBounds(20,90,300,50);
		NameIdPanel.add(YousufNameJLabel);

		JLabel YousufIDJLabel = new JLabel("ID: 22125170422");
		YousufIDJLabel.setFont(new Font("Gotham", Font.PLAIN,20));
		YousufIDJLabel.setBounds(20,130,300,50);
		NameIdPanel.add(YousufIDJLabel);
		
		JLabel EmamNameJLabel = new JLabel("Name:Md. Hasan Emam");
		EmamNameJLabel.setFont(new Font("Gotham", Font.PLAIN,20));
		EmamNameJLabel.setBounds(20,170,300,50);
		NameIdPanel.add(EmamNameJLabel);
		
		JLabel EmamIDJLabel = new JLabel("ID:2212478042");
		EmamIDJLabel.setFont(new Font("Gotham", Font.PLAIN,20));
		EmamIDJLabel.setBounds(20,210,300,50);
		NameIdPanel.add(EmamIDJLabel);
		
		JLabel RoktimNameJLabel = new JLabel("Name:Mehedi Hassan Roktim");
		RoktimNameJLabel.setFont(new Font("Gotham", Font.PLAIN,20));
		RoktimNameJLabel.setBounds(20,250,300,50);
		NameIdPanel.add(RoktimNameJLabel);
		
		JLabel RoktimIDJLabel = new JLabel("ID:2212497042");
		RoktimIDJLabel.setFont(new Font("Gotham", Font.PLAIN,20));
		RoktimIDJLabel.setBounds(20,290,300,50);
		NameIdPanel.add(RoktimIDJLabel);



		//###########################################################################

		backButton = new JButton("Back");
		backButton.setBackground(new Color(96,96,96));
		backButton.setFont(new Font("Gotham", Font.PLAIN,20));
		backButton.setForeground(Color.WHITE);
		backButton.setBounds(800, 600, 100,50);
		c.add(backButton);


		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				MainPage main = new MainPage(x,y);
				main.setVisible(true);	
				dispose();
			}
		});

		
	}
}
