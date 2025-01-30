package cse215;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BookingPage extends JFrame {
	private Container c;
	private ImageIcon icon;
	// private JPanel singPanel, logPanel, usrPanel;
	private JButton zero, backButton, ConfirmButton, clearButton, totalamoutButton;
	private JPanel PricePanel, DatePanel, NumberofDaysPanel, homePanel;
	private JTextField checkinText, PriceText, checkoutText, TotalamountText, durationText;
	private JLabel checkinLabel, PriceLabel,durationLabel, checkoutLabel, roomviewLabel, roomsizeLabel, TotalamountLabel, roomnumberLabel,
			TotalamountLabel1,checkinFormate;

	private JLabel checkinError, PriceError, checkoutError, viewError, sizeError, roomError;
	private JRadioButton seaviewRadio, hillviewRadio, normalRadio, singleRadio, doubleRadio, sewRoom101, sewRoom102,
			sewRoom103,sewRoom104, hillRoom101, hillRoom102, hillRoom103,hillRoom104, normalRoom101, normalRoom102, normalRoom103,normalRoom104;
	private ButtonGroup buttonGroup1, buttonGroup2, buttonroomgrp, buttonSV, buttonHV, buttonNV;
	private String answer, answer1;

	BookingPage(User user, int x, int y) {
		/*********************** Same Everywhere **********************/
		Font labelFont, errorFont, calcFont;
		Color backgroundColor = new Color(133, 172, 233);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Booking Page");
		this.setBounds(x, y, 1000, 750);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);
		this.icon = new ImageIcon(getClass().getResource("images/icon_2.png"));
		this.setIconImage(icon.getImage());

		/**************************************************/
		/***************** FONTS **************************/

		labelFont = new Font("Gotham", Font.BOLD, 20);
		Font textFont = new Font("Gotham", Font.PLAIN, 20);
		errorFont = new Font("Ariel", Font.ITALIC + Font.BOLD, 12);
		calcFont = new Font("Ariel", Font.ITALIC + Font.BOLD, 14);

		/**************************************************/
		/**************************************************/

		zero = new JButton();
		zero.setBounds(0, 0, 0, 0);
		c.add(zero);

		// label Room View

		roomviewLabel = new JLabel("VIEW:");
		roomviewLabel.setBounds(95, 20, 200, 50);
		roomviewLabel.setFont(labelFont);
		c.add(roomviewLabel);

		viewError = new JLabel("");
		viewError.setBounds(850, 30, 200, 25);
		viewError.setForeground(Color.RED);
		viewError.setFont(errorFont);
		c.add(viewError);

		roomnumberLabel = new JLabel("Room :");
		roomnumberLabel.setBounds(95, 85, 200, 50);
		roomnumberLabel.setFont(labelFont);
		c.add(roomnumberLabel);
		
		roomError = new JLabel("");
		roomError.setBounds(850, 100, 200, 25);
		roomError.setForeground(Color.RED);
		roomError.setFont(errorFont);
		c.add(roomError);

		seaviewRadio = new JRadioButton("SEA VIEW");
		seaviewRadio.setBounds(200, 20, 100, 50);
		seaviewRadio.setBackground(backgroundColor);
		c.add(seaviewRadio);

		sewRoom101 = new JRadioButton("SV Single Room101");
		sewRoom101.setBounds(200, 90, 150, 50);
		sewRoom101.setBackground(backgroundColor);
		c.add(sewRoom101);

		sewRoom102 = new JRadioButton("SV Single Room102");
		sewRoom102.setBounds(200, 120, 150, 50);
		sewRoom102.setBackground(backgroundColor);
		c.add(sewRoom102);

		sewRoom103 = new JRadioButton("SV Double Room103");
		sewRoom103.setBounds(200, 150, 150, 50);
		sewRoom103.setBackground(backgroundColor);
		c.add(sewRoom103);
		
		sewRoom104 = new JRadioButton("SV Double Room104");
		sewRoom104.setBounds(200, 180, 150, 50);
		sewRoom104.setBackground(backgroundColor);
		c.add(sewRoom104);

		hillviewRadio = new JRadioButton("HILL VIEW");
		hillviewRadio.setBounds(450, 20, 100, 50);
		hillviewRadio.setBackground(backgroundColor);
		c.add(hillviewRadio);

		hillRoom101 = new JRadioButton("HV Single Room101");
		hillRoom101.setBounds(450, 90, 150, 50);
		hillRoom101.setBackground(backgroundColor);
		c.add(hillRoom101);

		hillRoom102 = new JRadioButton("HV Single Room102");
		hillRoom102.setBounds(450, 120, 150, 50);
		hillRoom102.setBackground(backgroundColor);
		c.add(hillRoom102);

		hillRoom103 = new JRadioButton("HV Double Room103");
		hillRoom103.setBounds(450, 150, 150, 50);
		hillRoom103.setBackground(backgroundColor);
		c.add(hillRoom103);
		
		hillRoom104 = new JRadioButton("HV Double Room104");
		hillRoom104.setBounds(450, 180, 150, 50);
		hillRoom104.setBackground(backgroundColor);
		c.add(hillRoom104);

		normalRadio = new JRadioButton("NORMAL");
		normalRadio.setBounds(700, 20, 100, 50);
		normalRadio.setBackground(backgroundColor);
		// normalRadio.setSelected(true);
		c.add(normalRadio);

		normalRoom101 = new JRadioButton("NV Single Room101");
		normalRoom101.setBounds(700, 90, 150, 50);
		normalRoom101.setBackground(backgroundColor);
		c.add(normalRoom101);

		normalRoom102 = new JRadioButton("NV Single Room102");
		normalRoom102.setBounds(700, 120, 150, 50);
		normalRoom102.setBackground(backgroundColor);
		c.add(normalRoom102);

		normalRoom103 = new JRadioButton("NV Double Room103");
		normalRoom103.setBounds(700, 150, 150, 50);
		normalRoom103.setBackground(backgroundColor);
		c.add(normalRoom103);
		
		normalRoom104 = new JRadioButton("NV Double Room103");
		normalRoom104.setBounds(700, 180, 150, 50);
		normalRoom104.setBackground(backgroundColor);
		c.add(normalRoom104);

		buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(seaviewRadio);
		buttonGroup1.add(hillviewRadio);
		buttonGroup1.add(normalRadio);

		buttonroomgrp = new ButtonGroup();
		buttonroomgrp.add(sewRoom101);
		buttonroomgrp.add(sewRoom102);
		buttonroomgrp.add(sewRoom103);
		buttonroomgrp.add(sewRoom104);

		//buttonHV = new ButtonGroup();
		buttonroomgrp.add(hillRoom101);
		buttonroomgrp.add(hillRoom102);
		buttonroomgrp.add(hillRoom103);
		buttonroomgrp.add(hillRoom104);

		//buttonNV = new ButtonGroup();
		buttonroomgrp.add(normalRoom101);
		buttonroomgrp.add(normalRoom102);
		buttonroomgrp.add(normalRoom103);
		buttonroomgrp.add(normalRoom104);

		// label Room SIZE

		roomsizeLabel = new JLabel("SIZE:");
		roomsizeLabel.setBounds(95, 55, 200, 50);
		roomsizeLabel.setFont(labelFont);
		c.add(roomsizeLabel);

		sizeError = new JLabel("");
		sizeError.setBounds(650, 65, 200, 25);
		sizeError.setForeground(Color.RED);
		sizeError.setFont(errorFont);
		c.add(sizeError);

		singleRadio = new JRadioButton("SINGLE BED");
		singleRadio.setBounds(200, 55, 100, 50);
		singleRadio.setBackground(backgroundColor);
		c.add(singleRadio);

		doubleRadio = new JRadioButton("DOUBLE BED");
		doubleRadio.setBounds(450, 55, 100, 50);
		doubleRadio.setBackground(backgroundColor);
		c.add(doubleRadio);

		/*
		 * normalRadio = new JRadioButton("NORMAL"); normalRadio.setBounds(650, 180,
		 * 100,50); normalRadio.setBackground(backgroundColor);
		 * normalRadio.setSelected(true); c.add(normalRadio);
		 */

		buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(singleRadio);
		buttonGroup2.add(doubleRadio);
		// buttonGroup2.add(normalRadio);

		// label DATE
		checkinLabel = new JLabel("Check-in Date:");
		checkinLabel.setFont(new Font("Ariel", Font.BOLD, 25));
		checkinLabel.setBounds(250, 260, 200, 50);
		c.add(checkinLabel);
		
		checkinFormate = new JLabel("(YYYY-MM-DD)");
		checkinFormate.setBounds(250, 360, 200, 25);
		c.add(checkinFormate);
		
		checkinError = new JLabel("");
		checkinError.setBounds(350, 360, 200, 25);
		checkinError.setForeground(Color.RED);
		checkinError.setFont(errorFont);
		c.add(checkinError);
		
		// textFiled
		
		checkinText = new JTextField();
		checkinText.setFont(new Font("Gotham", Font.PLAIN, 20));
		checkinText.setHorizontalAlignment(JTextField.CENTER);
		checkinText.setBounds(250, 310, 500, 50);
		c.add(checkinText);

		// Label DURATION
		
		checkoutLabel = new JLabel("Check-Out Date:");
		checkoutLabel.setFont(new Font("Ariel", Font.BOLD, 25));
		checkoutLabel.setBounds(250, 370, 400, 50);
		c.add(checkoutLabel);
		
		checkoutError = new JLabel("");
		checkoutError.setBounds(250, 465, 200, 25);
		checkoutError.setForeground(Color.RED);
		checkoutError.setFont(errorFont);
		c.add(checkoutError);
		
		// Label DURATION
		
//		durationLabel = new JLabel("Duration:");
//		durationLabel.setFont(new Font("Ariel", Font.BOLD, 25));
//		durationLabel.setBounds(620, 370, 500, 50);
//		c.add(durationLabel);

//		checkoutError = new JLabel("");
//		checkoutError.setBounds(620, 465, 200, 25);
//		checkoutError.setForeground(Color.RED);
//		checkoutError.setFont(errorFont);
//		c.add(checkoutError);
		
		// TextField
		
		checkoutText = new JTextField();
		checkoutText.setFont(new Font("Gotham", Font.PLAIN, 20));
		checkoutText.setHorizontalAlignment(JTextField.CENTER);
		checkoutText.setBounds(250, 420, 500, 50);
		c.add(checkoutText);
		
//		durationText = new JTextField();
//		durationText.setFont(new Font("Gotham", Font.PLAIN, 20));
//		durationText.setHorizontalAlignment(JTextField.CENTER);
//		durationText.setBounds(625, 420, 130, 50);
//		c.add(durationText);
		

        
		// label PRICE
		
		PriceLabel = new JLabel("PRICE:");
		PriceLabel.setFont(new Font("Ariel", Font.BOLD, 25));
		PriceLabel.setBounds(250, 470, 400, 50);
		c.add(PriceLabel);
		PriceError = new JLabel("");
		PriceError.setBounds(250, 570, 200, 25);
		PriceError.setForeground(Color.RED);
		PriceError.setFont(errorFont);
		c.add(PriceError);
		
		// TextField
		
		PriceText = new JTextField();
		PriceText.setFont(new Font("Gotham", Font.PLAIN, 20));
		PriceText.setHorizontalAlignment(JTextField.CENTER);
		PriceText.setBounds(250, 520, 500, 50);
		c.add(PriceText);

		// BACKBUTTON
		backButton = new JButton("BACK");
		backButton.setBackground(Color.RED);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Didot", Font.BOLD, 15));
		backButton.setBounds(50, 620, 100, 50);
		c.add(backButton);

		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				SeaView about = new SeaView(user, x, y);
				about.setVisible(true);
				dispose();
			}
		});
		// CLEARBUTTON
		clearButton = new JButton("CLEAR");
		clearButton.setBackground(new Color(255, 128, 0));
		clearButton.setForeground(Color.WHITE);
		clearButton.setBounds(530, 620, 100, 50);
		c.add(clearButton);

		clearButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				PriceText.setText("");
				checkinText.setText("");
				checkoutText.setText("");
				// firstNameError.setText("");

			}
		});
		// CONFIRMBUTTON
		ConfirmButton = new JButton("CONFIRM");
		ConfirmButton.setBackground(new Color(0, 153, 0));
		ConfirmButton.setForeground(Color.WHITE);
		ConfirmButton.setFont(new Font("Gotham", Font.BOLD, 25));
		ConfirmButton.setBounds(700, 620, 200, 50);
		c.add(ConfirmButton);

//		TotalamountLabel = new JLabel("");
//		TotalamountLabel.setFont(new Font("Ariel", Font.BOLD, 25));
//		TotalamountLabel.setBounds(250, 50, 400, 50);
//		c.add(TotalamountLabel);

		totalamoutButton = new JButton("Total Amount");
		totalamoutButton.setBackground(new Color(1, 200, 1));
		totalamoutButton.setForeground(Color.WHITE);
		totalamoutButton.setFont(new Font("Gotham", Font.BOLD, 25));
		totalamoutButton.setBounds(250, 620, 200, 50);
		c.add(totalamoutButton);

		TotalamountLabel = new JLabel("Total Amount:");
		TotalamountLabel.setBounds(600, 470, 400, 50);
		TotalamountLabel.setForeground(Color.BLACK);
		TotalamountLabel.setFont(calcFont);
		c.add(TotalamountLabel);

		TotalamountLabel1 = new JLabel("");
		TotalamountLabel1.setBounds(700, 470, 400, 50);
		TotalamountLabel1.setForeground(Color.BLACK);
		TotalamountLabel1.setFont(calcFont);
		c.add(TotalamountLabel1);


		// Total amount action

		totalamoutButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//String duration = durationText.getText();
				String view = null;
				String checkindate = checkinText.getText();
				String checkoutdate = checkoutText.getText();
				// String ans = answer;
				
				
				 long daysDiff=0;
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
					    LocalDate dateBefore = LocalDate.parse(checkindate);
					    LocalDate dateAfter = LocalDate.parse(checkoutdate);

					    // Approach 1
					    daysDiff = ChronoUnit.DAYS.between(dateBefore, dateAfter);
					    System.out.println("The number of days between dates: " + daysDiff);

					}catch(Exception e2){
					    //e2.printStackTrace();
					}
				
		
				if (seaviewRadio.isSelected()) {
					view = "Sea View";
				} else if (hillviewRadio.isSelected()) {
					view = "Hill View";
				} else if (normalRadio.isSelected()) {
					view = "Normal";
				} else {
					view = "";
				}

				String size = null;
				if (singleRadio.isSelected()) {
					size = "Single Bed";
				} else if (doubleRadio.isSelected()) {
					size = "Double Bed";
				} else {
					size = "";
				}

				if ((seaviewRadio.isSelected() || hillviewRadio.isSelected() || normalRadio.isSelected())
						&& (doubleRadio.isSelected() || singleRadio.isSelected())) {
					if (seaviewRadio.isSelected() && singleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 4500 * daysDiff;
						answer = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer);
						// sizeError.setText()
					} else if (seaviewRadio.isSelected() && doubleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 5000 * daysDiff;
						answer = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer);
						// sizeError.setText()
					} else if (hillviewRadio.isSelected() && singleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 3500 *  daysDiff;
						answer = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer);
						// sizeError.setText()
					} else if (hillviewRadio.isSelected() && doubleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 4000 *  daysDiff;
						answer = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer);
						// sizeError.setText()
					} else if (normalRadio.isSelected() && singleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 2500 * daysDiff;
						answer = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer);
						// sizeError.setText()
					} else if (normalRadio.isSelected() && doubleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 3000 *  daysDiff;
						answer = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer);
						// sizeError.setText()
					}
				} else {
//					if (duration.equals("")) {
//						checkoutError.setText("Empty Duration");
//					} else {
//						checkoutError.setText("");
//					}
					if (view.equals("")) {
						viewError.setText("Select Please!!");
					} else {
						viewError.setText("");
					}
					if (size.equals("")) {
						sizeError.setText("Select Please!!");
					} else {
						sizeError.setText("");
					}
				}
			}
		});

//		noDaysError = new JLabel("");
//		noDaysError.setBounds(250, 465, 200,25);
//		noDaysError.setForeground(Color.RED);
//		noDaysError.setFont(errorFont);
//		c.add(noDaysError);

//		// TextField
//		TotalamountText = new JTextField("");
//		TotalamountText.setFont(new Font("Gotham", Font.PLAIN, 20));
//		TotalamountText.setHorizontalAlignment(JTextField.CENTER);
//		TotalamountText.setBounds(250, 150, 500, 50);
//		c.add(TotalamountText);
//		

//		String duration;
//		 String price ;
//		 String view = null;
//		 String size = null;

		// Confirm button action

		ConfirmButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Username username = new Username(usernameText.getText());
				String checkindate = checkinText.getText();
				String checkoutdate = checkoutText.getText();
				//String duration = checkoutText.getText();
				String price = PriceText.getText();
				String view = null;
				String room = null;
				boolean a = false;
				boolean b = false;
		        
				if (sewRoom101.isSelected()) {
					room = "sewRoom101";
				} else if (sewRoom102.isSelected()) {
					room = "sewRoom102";
				} else if (sewRoom103.isSelected()) {
					room = "sewRoom103";
				} else if (sewRoom104.isSelected()) {
					room = "sewRoom104";
				} else if (hillRoom101.isSelected()) {
					room = "hillRoom101";
				} else if (hillRoom102.isSelected()) {
					room = "hillRoom102";
				} else if (hillRoom103.isSelected()) {
					room = "hillRoom103";
				} else if (hillRoom104.isSelected()) {
					room = "hillRoom104";
				} else if (normalRoom101.isSelected()) {
					room = "normalRoom101";
				} else if (normalRoom102.isSelected()) {
					room = "normalRoom102";
				} else if (normalRoom103.isSelected()) {
					room = "normalRoom103";
				}else if (normalRoom104.isSelected()) {
					room = "normalRoom104";
				}else {
					room = "";
				}
				
				//long result = ChronoUnit.DAYS.between(checkoutdate, checkindate);
				 long daysDiff=0;
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				    LocalDate dateBefore = LocalDate.parse(checkindate);
				    LocalDate dateAfter = LocalDate.parse(checkoutdate);

				    // Approach 1
				    daysDiff = ChronoUnit.DAYS.between(dateBefore, dateAfter);
				    System.out.println("The number of days between dates: " + daysDiff);

				}catch(Exception e2){
				   // e2.printStackTrace();
				}
		        //System.out.println(duration);
				BookingDate ob = new BookingDate();
		        //ob.write(checkindate,checkoutdate, room);
				 String s4=checkoutdate.concat(" "+room);
				 String s3=checkindate.concat(" "+room);
		        boolean c = ob.availableRoom(s4,s3);
				//ob.availableRoom(checkindate,checkoutdate, room);
				
				// String ans = answer;
				if (seaviewRadio.isSelected()) {
					view = "Sea View";
				} else if (hillviewRadio.isSelected()) {
					view = "Hill View";
				} else if (normalRadio.isSelected()) {
					view = "Normal";
				} else {
					view = "";
				}

				String size = null;
				if (singleRadio.isSelected()) {
					size = "Single Bed";
				} else if (doubleRadio.isSelected()) {
					size = "Double Bed";
				} else {
					size = "";
				}
				
				////////Check-in-date Validity Check//////////////////////////////
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				String s2 = null;
				int user_month = 0;
				int user_day = 0;
				int user_year = 0;
				try {
					java.util.Date d = sdf.parse(checkinText.getText());
					s2 = sdf.format(d);
					java.util.Date d1 = sdf.parse(checkoutText.getText());
					s3 = sdf.format(d1);
					
//					// System.out.println(s2);
//					SimpleDateFormat day_user = new SimpleDateFormat("dd");
//					user_day = Integer.parseInt(day_user.format(d));
//					// System.out.println("Day:"+user_day);
//
//					SimpleDateFormat month_user = new SimpleDateFormat("mm");
//					user_month = Integer.parseInt(month_user.format(d));
//					// System.out.println("Day:"+user_month);
//
//					SimpleDateFormat year_user = new SimpleDateFormat("yyyy");
//					user_year = Integer.parseInt(year_user.format(d));
//					// System.out.println("Day:"+user_year);

				} catch (ParseException e1) {
				//	e1.printStackTrace();
				}

//				############Current Date>>>>>
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
				String str = formatter.format(date);
				
				try {
				Date current = formatter.parse(str);
				Date input = formatter.parse(s2);
				Date output = formatter.parse(s3);
				a = input.after(current);
				b = output.after(input);
				} catch (Exception e11) {
				//	e11.printStackTrace();
				}
				//System.out.println("Current date: " + str);

//				int comparison = str.compareTo(s2);
//				System.out.print(comparison);
				//boolean a = input.after(current);
				
				
				
//				SimpleDateFormat day_current = new SimpleDateFormat("dd");
//				int day_Current = Integer.parseInt(day_current.format(date));
//				// System.out.println("Day current:"+day_current.format(date));
//
//				SimpleDateFormat month_current = new SimpleDateFormat("MM");
//				int month_Current = Integer.parseInt(month_current.format(date));
//
//				SimpleDateFormat year_current = new SimpleDateFormat("yyyy");
//				int year_Current = Integer.parseInt(year_current.format(date));
//
//				int count = 0;
//
//				if (year_Current > user_year) {
//					count = 0;
//				}
//
//				else if (year_Current < user_year) {
//					count = 1;
//				}
//
//				else if (year_Current == user_year) {
//					if (month_Current > user_month) {
//						count = 0;
//					} else if (month_Current < user_month) {
//						count = 1;
//					} else if (month_Current == user_month) {
//						if (day_Current > user_day) {
//							count = 0;
//						} else if (day_Current < user_day) {
//							count = 1;
//						}
//
//						else {
//							count = 0;
//						}
//
//					}
//				}
				
		////////Check-out-date Validity Check//////////////////////////////
				
				if ((seaviewRadio.isSelected() || hillviewRadio.isSelected() || normalRadio.isSelected())
						&& (doubleRadio.isSelected() || singleRadio.isSelected())) {
					if (seaviewRadio.isSelected() && singleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 4500 * daysDiff;
						answer1 = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer1);
						// sizeError.setText()
					} else if (seaviewRadio.isSelected() && doubleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 5000 * daysDiff;
						answer1 = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer1);
						// sizeError.setText()
					} else if (hillviewRadio.isSelected() && singleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 3500 *  daysDiff;
						answer1 = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer1);
						// sizeError.setText()
					} else if (hillviewRadio.isSelected() && doubleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 4000 *  daysDiff;
						answer1 = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer1);
						// sizeError.setText()
					} else if (normalRadio.isSelected() && singleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 2500 * daysDiff;
						answer1 = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer1);
						// sizeError.setText()
					} else if (normalRadio.isSelected() && doubleRadio.isSelected()) {
						//int numberOfdays = Integer.parseInt(durationText.getText());
						long totalamount = 3000 *  daysDiff;
						answer1 = String.valueOf(totalamount);
						TotalamountLabel1.setText(answer1);
						// sizeError.setText()
					}
				}
				
				String noob = PriceText.getText();
				boolean n = answer1.equals(noob);
				
				// System.out.println(matcher.matches());
				if (!(checkindate.equals("")) & (checkindate.matches("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}")) &
					!(checkoutdate.equals("")) & (checkoutdate.matches("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}"))
					&(c) & (a) & (b) & !(view.equals("")) & !(size.equals("")) & !(price.equals(""))& (n) & !(room.equals(""))
						& (((view.equals("Sea View")) & (size.equals("Single Bed")) & ((room.equals("sewRoom101")) | (room.equals("sewRoom102"))))
						| ((view.equals("Sea View")) & (size.equals("Double Bed"))&((room.equals("sewRoom103")) | (room.equals("sewRoom104"))))
						| ((view.equals("Hill View")) & (size.equals("Single Bed"))& ((room.equals("hillRoom101")) | (room.equals("hillRoom102"))))
						| ((view.equals("Hill View")) & (size.equals("Double Bed"))& ((room.equals("hillRoom103")) | (room.equals("hillRoom104"))))
						| ((view.equals("Normal")) & (size.equals("Single Bed")) & ((room.equals("normalRoom101")) | (room.equals("normalRoom102"))))
						| ((view.equals("Normal")) & (size.equals("Double Bed")) & ((room.equals("normalRoom103")) | (room.equals("normalRoom104")))))) {
					// User user = new User(username.get(), firstName, lastName, email, phone,
					// address, dateOfBirth, password);
					user.setDate(checkindate);
					//user.setDuration(duration);
					user.setPrice(price);
					user.changeView(view);
					
					
					LocalDateTime unformatedDate = LocalDateTime.now();
					DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
					String dates = unformatedDate.format(format);
					String[] record = {room, answer, dates };
					user.addRecord(record);
					user.saveFile();
					BookingWrite write = new BookingWrite(checkindate,daysDiff,room);
					// username.write();
					JOptionPane.showMessageDialog(null, "Booking successfully \n", "Enjoy!!", -1);

					Point point = getLocation();
					int x = (int) point.getX();
					int y = (int) point.getY();
					UserPage main = new UserPage(user, x, y);
					main.setVisible(true);
					dispose();
				}

				else {
					//PriceText.setText("");
					if (checkindate.equals("")) {
						checkinError.setText("Empty Date");
					}
					else if(!(checkindate.matches("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}"))){
						checkinError.setText("Invalid Date Formate");
					}
					else if(!a){
						checkinError.setText("Invalid Date");
					}
					else {
						checkinError.setText("");
					}

					if (checkoutdate.equals("")) {
						checkoutError.setText("Empty Date");
					}
					else if(!(checkoutdate.matches("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}"))){
						checkoutError.setText("Invalid Date Formate");
					}
					else if(!b){
						checkoutError.setText("Invalid Date");
					}
					else {
						checkoutError.setText("");
					}
					
					
					if (view.equals("")) {
						viewError.setText("Select Please!!");
					} else {
						viewError.setText("");
					}
					if (room.equals("")) {
						roomError.setText("Select Please!!");
					}else if (!c) {
						roomError.setText("Room Unavailable");
					}
					else if (!(((view.equals("Sea View")) & (size.equals("Single Bed")) &((room.equals("sewRoom101")) | (room.equals("sewRoom102"))))
							| ((view.equals("Sea View")) & (size.equals("Double Bed")) &((room.equals("sewRoom103")) | (room.equals("sewRoom104"))))
							| ((view.equals("Hill View")) & (size.equals("Single Bed")) & ((room.equals("hillRoom101")) | (room.equals("hillRoom102"))))
							| ((view.equals("Hill View")) & (size.equals("Double Bed")) & ((room.equals("hillRoom103")) | (room.equals("hillRoom104"))))
							| ((view.equals("Normal")) & (size.equals("Single Bed")) & ((room.equals("normalRoom101")) | (room.equals("normalRoom102"))))
							| ((view.equals("Normal")) & (size.equals("Double Bed")) & ((room.equals("normalRoom103")) | (room.equals("normalRoom104")))))) {
						roomError.setText("Wrong Room Type!!");
					}else {
						roomError.setText("");
					}
					if (size.equals("")) {
						sizeError.setText("Select Please!!");
					} else {
						sizeError.setText("");
					}
					if (price.equals("")) {
						PriceError.setText("Empty Price");
					}else if (!price.equals(answer)) {
						PriceError.setText("Price not equal to required amount");
					}else if (!n) {
						PriceError.setText("Price not equal to required amount");
					}else {
						PriceError.setText("");
					}

				}
			}
		});

	}
}