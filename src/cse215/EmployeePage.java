/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse215;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EmployeePage extends JFrame{
	private final Container c;
	private final ImageIcon icon;
         //private JPanel singPanel, logPanel, usrPanel;
    private final JButton zero;
	private JButton signpButton, loginButton, exitButton, EmployeeButton, aboutButtons;
	EmployeePage(int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Employee");
		this.setBounds(x,y, 700,700);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon_2.png"));
		this.setIconImage(icon.getImage());
		
		/**************************************************/
		
		zero = new JButton(); zero.setBounds(0,0,0,0); c.add(zero);

		

		JButton backButton = new JButton("Back");
		backButton.setBackground(new Color(96,96,96));
		backButton.setFont(new Font("Gotham", Font.PLAIN,20));
		backButton.setForeground(Color.WHITE);
		backButton.setBounds(450, 875, 100,50);
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
