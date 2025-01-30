package cse215;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Doctor extends JFrame{
	private Container c;
	private ImageIcon icon;
	//private JPanel singPanel, logPanel, usrPanel;
	private JButton zero, backButton, ConfirmButton;
	private JLabel PriceLabel, PriceError;
	private JTextField PriceText;
	private String answer = String.valueOf(1000);
	Doctor(User user, int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Font labelFont, errorFont;
		Color backgroundColor = new Color(133,172,233);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Doctor");
		this.setBounds(x,y, 1000,750);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon_2.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/
		
		/**************************************************/
		/*****************FONTS**************************/
		
		labelFont = new Font("Gotham",Font.BOLD,20);
		//Font textFont = new Font("Gotham",Font.PLAIN,20);
		errorFont = new Font("Ariel", Font.ITALIC+Font.BOLD,12);
		
		
		/**************************************************/
		/**************************************************/
		
		zero = new JButton(); zero.setBounds(0,0,0,0); c.add(zero);
		
		//Doctor 1
		
		ImageIcon docImg1 = new ImageIcon(getClass().getResource("images/doc2.png"));
		JLabel doc1Icon = new JLabel(docImg1);
		doc1Icon.setBounds(20,0,200,200);
		c.add(doc1Icon);
		

		JLabel doc1Name = new JLabel("Dr. Monami Islam");
		doc1Name.setBounds(300,50,600,50);
		doc1Name.setFont(new Font("Arial", Font.PLAIN,28));
		c.add(doc1Name);
		
		JLabel doc1Degree = new JLabel("MBBS, FCPS ");
		doc1Degree.setBounds(300,80,600,50);
		doc1Degree.setFont(new Font("Arial", Font.ITALIC,22));
		c.add(doc1Degree);
		
		JLabel doc1consul = new JLabel("Everyday 8 : 00 am - 4 : 00 pm");
		doc1consul.setBounds(300,110,600,50);
		doc1consul.setFont(new Font("Arial", Font.BOLD,25));
		doc1consul.setForeground(Color.RED);
		c.add(doc1consul);
		
		//Doctor 2
		
		ImageIcon docImg2 = new ImageIcon(getClass().getResource("images/doc1.png"));
		JLabel doc2Icon = new JLabel(docImg2);
		doc2Icon.setBounds(20,0,200,500);
		c.add(doc2Icon);
		

		JLabel doc2Name = new JLabel("Dr. Abu Yousuf Neshad");
		doc2Name.setBounds(300,200,600,50);
		doc2Name.setFont(new Font("Arial", Font.PLAIN,28));
		c.add(doc2Name);
		
		JLabel doc2Degree = new JLabel("MBBS, FCPS ");
		doc2Degree.setBounds(300,230,600,50);
		doc2Degree.setFont(new Font("Arial", Font.ITALIC,22));
		c.add(doc2Degree);
		
		JLabel doc2consul = new JLabel("Everyday 4 : 00 pm - 12 : 00 am");
		doc2consul.setBounds(300,255,600,50);
		doc2consul.setFont(new Font("Arial", Font.BOLD,25));
		doc2consul.setForeground(Color.RED);
		c.add(doc2consul);
		
		//Doctor 3
		
		ImageIcon docImg3 = new ImageIcon(getClass().getResource("images/doc1.png"));
		JLabel doc3Icon = new JLabel(docImg3);
		doc3Icon.setBounds(20,0,200,800);
		c.add(doc3Icon);
		

		JLabel doc3Name = new JLabel("Dr. Hasan Emam");
		doc3Name.setBounds(300,350,800,50);
		doc3Name.setFont(new Font("Arial", Font.PLAIN,28));
		c.add(doc3Name);
		
		JLabel doc3Degree = new JLabel("MBBS, FCPS, ");
		doc3Degree.setBounds(300,380,800,50);
		doc3Degree.setFont(new Font("Arial", Font.ITALIC,22));
		c.add(doc3Degree);
		
		JLabel doc3consul = new JLabel("Everyday 12 : 00 am - 8 : 00 am");
		doc3consul.setBounds(300,410,800,50);
		doc3consul.setFont(new Font("Arial", Font.BOLD,25));
		doc3consul.setForeground(Color.RED);
		c.add(doc3consul);
		
		//Price panel
		
		JLabel docConsulPrice = new JLabel("Consultation Fee: Tk. 1000");
		docConsulPrice.setBounds(70,470,800,50);
		docConsulPrice.setFont(new Font("Arial", Font.BOLD,25));
		docConsulPrice.setForeground(Color.RED);
		c.add(docConsulPrice);
		
		// label Price
		
		PriceLabel = new JLabel("Enter Amount:");
		PriceLabel.setFont(new Font("Ariel", Font.BOLD, 25));
		PriceLabel.setBounds(70, 530, 800, 50);
		c.add(PriceLabel);
		PriceError = new JLabel("");
		PriceError.setBounds(690, 580, 800,25);
		PriceError.setForeground(Color.RED);
		PriceError.setFont(errorFont);
		c.add(PriceError);
		
		// textField
		
		PriceText = new JTextField();
		PriceText.setFont(new Font("Gotham", Font.PLAIN, 20));
		PriceText.setHorizontalAlignment(JTextField.CENTER);
		PriceText.setBounds(270, 530, 550, 50);
		c.add(PriceText);
		
		
		/*   Back Button*/
		
		
		backButton = new JButton("BACK");
		backButton.setBackground(Color.RED);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Didot",Font.BOLD,15));
		backButton.setBounds(50,620,100,50);
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
		
		/*   Confirm Button*/
		
		ConfirmButton = new JButton("CONFIRM");
		ConfirmButton.setBackground(new Color(0, 153, 0));
		ConfirmButton.setForeground(Color.WHITE);
		ConfirmButton.setFont(new Font("Gotham", Font.BOLD, 25));
		ConfirmButton.setBounds(700, 620, 200, 50);
		c.add(ConfirmButton);
		
		ConfirmButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				 
				 String price = PriceText.getText();
	
				 if((price.equals(answer)) && !(price.equals("")))
				 {
					 LocalDateTime unformatedDate = LocalDateTime.now();
					 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					 String dates = unformatedDate.format(format);
					 String[] record = {"Doctor Consulted", answer, dates};
					 user.addRecord(record);
					 user.saveFile();
					 	
					 //username.write();
					 
					 JOptionPane.showMessageDialog(null, "Hope you get better soon\n", "Consultation Succesfull", -1);
						
					 Point point = getLocation();
					 int x = (int)point.getX(); int y = (int)point.getY();
					 UserPage main = new UserPage(user,x,y);
					 main.setVisible(true);
					 dispose();
				 	}
			
				 
				 else
				 {	
				 	if(price.equals(""))
				 	{
				 		PriceError.setText("Empty Price");
				 	}
				 	else if(!price.equals(answer))
				 	{
				 		PriceError.setText("Enter Correct Amount");
				 	}
				 	else{
				 		PriceError.setText("");
				 	}

				
			}}
		});
		
		
	
	}
	}
