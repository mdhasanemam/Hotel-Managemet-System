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

public class FoodCourt extends JFrame{
	private Container c;
	private ImageIcon icon;
	//private JPanel singPanel, logPanel, usrPanel;
	private JButton zero, backButton, ConfirmButton;
	JLabel Fries;
	FoodCourt(User user, int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Font labelFont, errorFont;
		Color backgroundColor = new Color(133,172,233);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Food Court");
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
		
		JLabel FoodType1 = new JLabel("Fast Food");
		FoodType1.setBounds(60,30,600,50);
		FoodType1.setFont(new Font("Arial", Font.PLAIN,28));
		c.add(FoodType1);
		
		ImageIcon FrenchFries = new ImageIcon(getClass().getResource("images/FrenchFries.png"));
		JLabel Fries = new JLabel(FrenchFries);
		Fries.setBounds(0,20,200,200);
		c.add(Fries);
		
		ImageIcon Hamburger = new ImageIcon(getClass().getResource("images/hamburger.png"));
		JLabel burger = new JLabel(Hamburger);
		burger.setBounds(200,20,200,200);
		c.add(burger);
		
		ImageIcon Pizza = new ImageIcon(getClass().getResource("images/pizza.png"));
		JLabel pizza = new JLabel(Pizza);
		pizza.setBounds(400,20,200,200);
		c.add(pizza);
		
		ImageIcon Hotdog = new ImageIcon(getClass().getResource("images/hotdog.png"));
		JLabel hotdog = new JLabel(Hotdog);
		hotdog.setBounds(600,20,200,200);
		c.add(hotdog);
		
		ImageIcon Sandwich = new ImageIcon(getClass().getResource("images/sandwich.png"));
		JLabel sandwich = new JLabel(Sandwich);
		sandwich.setBounds(800,20,200,200);
		c.add(sandwich);
		
		JLabel FoodType2 = new JLabel("Rice & Kebabs");
		FoodType2.setBounds(60,240,600,50);
		FoodType2.setFont(new Font("Arial", Font.PLAIN,28));
		c.add(FoodType2);
		
		ImageIcon FriedRice = new ImageIcon(getClass().getResource("images/friedrice.png"));
		JLabel friedrice = new JLabel(FriedRice);
		friedrice.setBounds(0,246,200,200);
		c.add(friedrice);
		
		ImageIcon ChickenRice = new ImageIcon(getClass().getResource("images/chickenrice.png"));
		JLabel chickenrice = new JLabel(ChickenRice);
		chickenrice.setBounds(200,246,200,200);
		c.add(chickenrice);
		
		ImageIcon Steak = new ImageIcon(getClass().getResource("images/steak.png"));
		JLabel steak = new JLabel(Steak);
		steak.setBounds(400,246,200,200);
		c.add(steak);
		
		ImageIcon ShikhKebab = new ImageIcon(getClass().getResource("images/kebab(1).png"));
		JLabel shikhkebab = new JLabel(ShikhKebab);
		shikhkebab.setBounds(600,246,200,200);
		c.add(shikhkebab);
		
		ImageIcon DonerKebab = new ImageIcon(getClass().getResource("images/donerkebab.png"));
		JLabel doner = new JLabel(DonerKebab);
		doner.setBounds(800,246,200,200);
		c.add(doner);
		
		JLabel FoodType3 = new JLabel("Drinks & Pastry");
		FoodType3.setBounds(60,460,600,50);
		FoodType3.setFont(new Font("Arial", Font.PLAIN,28));
		c.add(FoodType3);
		
		ImageIcon Pepsi = new ImageIcon(getClass().getResource("images/pepsi.png"));
		JLabel pepsi = new JLabel(Pepsi);
		pepsi.setBounds(0,462,200,200);
		c.add(pepsi);
		
		ImageIcon CocaCola = new ImageIcon(getClass().getResource("images/cocacola.png"));
		JLabel cocacola = new JLabel(CocaCola);
		cocacola.setBounds(200,462,200,200);
		c.add(cocacola);
		
		ImageIcon Cofee = new ImageIcon(getClass().getResource("images/cofee.png"));
		JLabel cofee = new JLabel(Cofee);
		cofee.setBounds(400,462,200,200);
		c.add(cofee);
		
		ImageIcon Pastry = new ImageIcon(getClass().getResource("images/pastry.png"));
		JLabel pastry = new JLabel(Pastry);
		pastry.setBounds(600,462,200,200);
		c.add(pastry);
		
		ImageIcon Donut = new ImageIcon(getClass().getResource("images/donut.png"));
		JLabel donut = new JLabel(Donut);
		donut.setBounds(800,462,200,200);
		c.add(donut);
		
		zero = new JButton(); zero.setBounds(0,0,0,0); c.add(zero);
		backButton = new JButton("BACK");
		backButton.setBackground(Color.RED);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Didot",Font.BOLD,15));
		backButton.setBounds(20,660,100,50);
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
