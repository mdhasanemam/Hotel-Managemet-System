/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse215;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class UserPage extends JFrame{
	
	private final JTabbedPane tabs;
	private final JTable historyTable;
	private final JScrollPane scrollPane;
	private final Container c;
	private final ImageIcon icon;
	private ImageIcon homeIcon;
	private JPanel homePanel, historyPanel, RoomPanel, Foodpanel, medicalPanel, updatePanel, deletePanel;
	//private JLabel labelDelete, Room1SeaView, depositAmountLabel, transferAccontLabel, transferAmountLabel, labelTransferPassword;
	private JLabel infoUsername, infoName, infoBalance, infoEmail, infoPhone, infoAddress, infoDateOfBirth, infoGender;
	//private JLabel withdrawMessage, depositMessage, transferMessage;
	//private JTextField withdrawText, depositText, balanceText, transferAccountText, transferAmountText;
	private JPasswordField withdrawPass, depositPass, passwordTransfer, deletePass;
	private JButton SeaviewOk,HillviewOk,RegularOk, foodCourtOk, DoctorOk,farmacyok, deleteOk, buttonLogOut, ambulanceok;
	private boolean a;
	UserPage(User user, int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(user.getFirstName());
		this.setBounds(x,y, 1000,730);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon_2.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/

		Font textFont = new Font("Gotham",Font.PLAIN,20);

		ImageIcon userIconImg = new ImageIcon(getClass().getResource("images/icons/user.png"));
		JLabel userIcon = new JLabel(userIconImg);
		userIcon.setBounds(20,0,100,65);
		c.add(userIcon);
		JLabel userIconName = new JLabel(user.getFirstName());
		userIconName.setBounds(120,0,300,65);
		userIconName.setFont(new Font("Gotham",Font.BOLD,25));
		c.add(userIconName);


		tabs = new JTabbedPane(JTabbedPane.LEFT);
		tabs.setBackground(Color.WHITE);
		tabs.setBounds(15,70,960,620);
		
		
		homePanel = new JPanel();
		Color homePanelColor = new Color (204,255,204);
		homePanel.setBackground(Color.WHITE);
		homePanel.setLayout(null);

		historyPanel = new JPanel();
		historyPanel.setBackground(Color.WHITE);
		historyPanel.setLayout(null);

		RoomPanel = new JPanel();
		RoomPanel.setBackground(Color.WHITE);
		RoomPanel.setLayout(null);


		Foodpanel = new JPanel();
		Foodpanel.setBackground(Color.WHITE);
		Foodpanel.setLayout(null);


		medicalPanel = new JPanel();
		medicalPanel.setBackground(Color.WHITE);
		medicalPanel.setLayout(null);


		updatePanel = new JPanel();
		Color updatePanelColor = new Color (255,229,204);
		updatePanel.setBackground(Color.WHITE);
		updatePanel.setLayout(null);


		deletePanel = new JPanel();
		deletePanel.setBackground(Color.WHITE);
		deletePanel.setLayout(null);

		tabs.addTab("Home",homePanel);
		tabs.add("History",historyPanel);
		tabs.addTab("Room",RoomPanel);
		tabs.addTab("Deposit",Foodpanel);
		tabs.addTab("Medical",medicalPanel);
		tabs.addTab("Update", updatePanel);
		tabs.addTab("Delete",deletePanel);

		ImageIcon homeIcon = new ImageIcon(getClass().getResource("images/icons/home.png"));
		JLabel home = new JLabel(homeIcon);
		home.setPreferredSize(new Dimension(200, 85));
		tabs.setTabComponentAt(0,home);

		ImageIcon historyIcon = new ImageIcon(getClass().getResource("images/icons/history.png"));
		JLabel history = new JLabel(historyIcon);
		history.setPreferredSize(new Dimension(200, 85));
		tabs.setTabComponentAt(1,history);

		
		
		ImageIcon roomIcon = new ImageIcon(getClass().getResource("images/icons/beds.png"));
		JLabel room = new JLabel(roomIcon);
		room.setPreferredSize(new Dimension(200, 84));
		tabs.setTabComponentAt(2,room);
		
	
		ImageIcon depositIcon = new ImageIcon(getClass().getResource("images/icons/food.png"));
		JLabel deposit = new JLabel(depositIcon);
		deposit.setPreferredSize(new Dimension(200, 84));
		tabs.setTabComponentAt(3,deposit);
		
		ImageIcon medicalIcon = new ImageIcon(getClass().getResource("images/icons/medical.png"));
		JLabel transfer = new JLabel(medicalIcon);
		transfer.setPreferredSize(new Dimension(200, 84));
		tabs.setTabComponentAt(4,transfer);

		ImageIcon updateIcon = new ImageIcon(getClass().getResource("images/icons/update.png"));
		JLabel update = new JLabel(updateIcon);
		update.setPreferredSize(new Dimension(200, 85));
		tabs.setTabComponentAt(5,update);

		ImageIcon deleteicon = new ImageIcon(getClass().getResource("images/icons/delete.png"));
		JLabel delete = new JLabel(deleteicon);
		delete.setPreferredSize(new Dimension(200, 84));
		tabs.setTabComponentAt(6,delete);


		c.add(tabs);

//#####################################  PANELS  ############################################################################



		//************************************* Home Panel *************************************

		JLabel homeLabel = new JLabel("HOME");
		homeLabel.setBounds(250,0, 400, 50);
		//withdrawLabel.setBackground(Color.ORANGE);
		homeLabel.setFont(new Font("Gotham",Font.BOLD,45));
		homePanel.add(homeLabel);

			// Name ###########################
		JPanel namePanel = new JPanel();
		namePanel.setLayout(null);
		namePanel.setBounds(15,55,700, 50);
		namePanel.setBackground(homePanelColor);
		homePanel.add(namePanel);
			
		JLabel nameLabel = new JLabel("Full Name:");
		nameLabel.setBounds(30, 0, 200,50);
		nameLabel.setFont(new Font("Gotham",Font.BOLD,22));
		namePanel.add(nameLabel);

		infoName = new JLabel(user.getFirstName()+" "+user.getLastName());
		infoName.setBounds(250,0,500,50);
		infoName.setFont(new Font("Gotham",Font.BOLD,18));
		infoName.setFont(new Font("Gotham",Font.BOLD,22));
		namePanel.add(infoName); 
		
		 //Username ###########################


		JPanel usernamePanel = new JPanel();
		usernamePanel.setLayout(null);
		usernamePanel.setBounds(15,125,700, 50);
		usernamePanel.setBackground(homePanelColor);
		homePanel.add(usernamePanel);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(30, 0, 200,50);
		usernameLabel.setFont(new Font("Gotham",Font.BOLD,22));
		usernamePanel.add(usernameLabel);

		infoUsername = new JLabel(user.getUsername());
		infoUsername.setBounds(250,0,300,50);
		infoUsername.setFont(new Font("Gotham",Font.BOLD,22));
		usernamePanel.add(infoUsername); 

			//Balance ###########################

//		JPanel balancePanel = new JPanel();
//		balancePanel.setLayout(null);
//		balancePanel.setBounds(15,250,700, 50);
//		balancePanel.setBackground(homePanelColor);
//		homePanel.add(usernamePanel);
//
//		JLabel balanceLabel = new JLabel("Balance:");
//		balanceLabel.setBounds(30, 0, 200,50);
//		balanceLabel.setFont(new Font("Gotham",Font.BOLD,22));
//		balancePanel.add(balanceLabel);
//		homePanel.add(balancePanel);
//
//		infoBalance = new JLabel(""+user.getBalance());
//		infoBalance.setBounds(250,0,300,50);
//		infoBalance.setFont(new Font("Gotham",Font.BOLD,22));
//		balancePanel.add(infoBalance);
			
			//Email ###########################

		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(null);
		emailPanel.setBounds(15,195,700, 50);
		emailPanel.setBackground(homePanelColor);
		homePanel.add(emailPanel);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(30, 0, 200,50);
		emailLabel.setFont(new Font("Gotham",Font.BOLD,22));
		emailPanel.add(emailLabel);

		infoEmail = new JLabel(user.getEmail());
		infoEmail.setBounds(250,0,500,50);
		infoEmail.setFont(new Font("Gotham",Font.BOLD,22));
		emailPanel.add(infoEmail);

			//Phone ###########################

		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(null);
		phonePanel.setBounds(15,265,700, 50);
		phonePanel.setBackground(homePanelColor);
		homePanel.add(phonePanel);

		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(30, 0, 200,50);
		phoneLabel.setFont(new Font("Gotham",Font.BOLD,22));
		phonePanel.add(phoneLabel);



		infoPhone = new JLabel(user.getPhone());
		infoPhone.setBounds(250,0,300,50);
		infoPhone.setFont(new Font("Gotham",Font.BOLD,22));
		phonePanel.add(infoPhone);

			// Address ###########################

		JPanel addressPanel = new JPanel();
		addressPanel.setLayout(null);
		addressPanel.setBounds(15,340,700, 50);
		addressPanel.setBackground(homePanelColor);
		homePanel.add(addressPanel);

		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setBounds(30, 0, 200,50);
		addressLabel.setFont(new Font("Gotham",Font.BOLD,22));
		addressPanel.add(addressLabel);


		infoAddress = new JLabel(user.getAddress());
		infoAddress.setBounds(250,0,300,50);
		infoAddress.setFont(new Font("Gotham",Font.BOLD,22));
		addressPanel.add(infoAddress);

			// Date Of Birth ###########################

		JPanel dobPanel = new JPanel();
		dobPanel.setLayout(null);
		dobPanel.setBounds(15,415,700, 50);
		dobPanel.setBackground(homePanelColor);
		homePanel.add(dobPanel);

		JLabel dobLabel = new JLabel("Date of Birth:");
		dobLabel.setBounds(30, 0, 200,50);
		dobLabel.setFont(new Font("Gotham",Font.BOLD,22));
		dobPanel.add(dobLabel);

		infoDateOfBirth = new JLabel(user.getDateOfBirth());
		infoDateOfBirth.setBounds(250,0,300,50);
		infoDateOfBirth.setFont(new Font("Gotham",Font.BOLD,22));
		dobPanel.add(infoDateOfBirth);
		
		
		
			//Gender ###########################

//		JPanel genderPanel = new JPanel();
//		genderPanel.setLayout(null);
//		genderPanel.setBounds(15,625,700, 50);
//		genderPanel.setBackground(homePanelColor);
//		homePanel.add(genderPanel);
//
//		JLabel genderLabel = new JLabel("Gender:");
//		genderLabel.setBounds(30, 0, 200,50);
//		genderLabel.setFont(new Font("Gotham",Font.BOLD,22));
//		genderPanel.add(genderLabel);

//		infoGender = new JLabel(user.getGender());
//		infoGender.setBounds(250,0,300,50);
//		infoGender.setFont(new Font("Gotham",Font.BOLD,22));
//		genderPanel.add(infoGender);

		//************************************* History Panel ************************************* 

		JLabel historyLabel = new JLabel("HISTORY");
		historyLabel.setBounds(200,20, 400, 50);
		//withdrawLabel.setBackground(Color.ORANGE);
		historyLabel.setFont(new Font("Gotham",Font.BOLD,45));
		historyPanel.add(historyLabel);

		String[] columnName = {"Events", "Amount", "Date & Time"};
		Vector<String[]> records= user.getRecords();
		String[][] userRecords = new String[records.size()][3];
		int j=0;
		for(int i= (records.size()-1); i>=0; i--)
		{
			userRecords[j] = records.get(i);  j++;
		}
		historyTable = new JTable(userRecords,columnName);
		//historyTable.setBackground(Color.WHITE);
		historyTable.setFont(new Font("Gotham",Font.BOLD,15)); 
		historyTable.setRowHeight(50);
		historyTable.getTableHeader().setFont(new Font("Gotham",Font.BOLD,18));
		historyTable.getTableHeader().setBackground(backgroundColor);
		scrollPane = new JScrollPane(historyTable);
		scrollPane.setBounds(8,100,715,515);
		historyPanel.add(scrollPane);

		//************************************* Room Panel ************************************* 

		JPanel topRoomPanel = new JPanel();
		topRoomPanel.setLayout(null);
		topRoomPanel.setBounds (15,100,700, 610);
		topRoomPanel.setBackground(new Color (204,229,255));
		RoomPanel.add(topRoomPanel);

		JLabel RoomLabel = new JLabel("Room");
		RoomLabel.setBounds(300,20, 700, 50);
		//withdrawLabel.setBackground(Color.ORANGE);
		RoomLabel.setFont(new Font("Gotham",Font.BOLD,45));
		RoomPanel.add(RoomLabel);

				
		
//		Room1SeaView = new JLabel("RoomSeaView");
//		Room1SeaView.setFont(new Font("Gotham",Font.BOLD,25));
//		Room1SeaView.setBounds(150, 50, 500, 100);
//		topRoomPanel.add(Room1SeaView);
		

		

		//withdrawText = new JTextField();
		//withdrawText.setFont(textFont);
		//withdrawText.setHorizontalAlignment(JTextField.CENTER);
		//withdrawText.setBounds(100,250,500,50);
		//topRoomPanel.add(withdrawText);

		SeaviewOk = new JButton("Room Sea View");
		SeaviewOk.setBounds(200, 150, 300,50);
		SeaviewOk.setForeground(Color.WHITE);
		SeaviewOk.setBackground(Color.BLACK);
		SeaviewOk.setFont(new Font("Gotham",Font.BOLD,18));
		topRoomPanel.add(SeaviewOk);
		
		HillviewOk = new JButton("Room Hill View");
		HillviewOk.setBounds(200, 250, 300,50);
		HillviewOk.setForeground(Color.WHITE);
		HillviewOk.setBackground(Color.BLACK);
		HillviewOk.setFont(new Font("Gotham",Font.BOLD,18));
		topRoomPanel.add(HillviewOk);
		
		RegularOk = new JButton("Room Regular View");
		RegularOk.setBounds(200, 350, 300,50);
		RegularOk.setForeground(Color.WHITE);
		RegularOk.setBackground(Color.BLACK);
		RegularOk.setFont(new Font("Gotham",Font.BOLD,18));
		topRoomPanel.add(RegularOk);

//		JLabel withdrawErrorLabel = new JLabel("");
//		withdrawErrorLabel.setBounds(250, 300, 300, 50);
//		topRoomPanel.add(withdrawErrorLabel);
//
//		withdrawMessage = new JLabel("");
//		withdrawMessage.setBounds(150,50, 500,50);
//		withdrawMessage.setFont(new Font("Gotham",Font.BOLD,22));
//		topRoomPanel.add(withdrawMessage);
		
		SeaviewOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				SeaView about = new SeaView(user, x,y);
				about.setVisible(true);	
				dispose();
			}
		});

		HillviewOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				HillView about = new HillView(user, x,y);
				about.setVisible(true);	
				dispose();
			}
		});

		
		RegularOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				RegularView about = new RegularView(user, x,y);
				about.setVisible(true);	
				dispose();
			}
		});


		//************************************* Food Panel ************************************* 

		JPanel FoodPanel = new JPanel();
		FoodPanel.setLayout(null);
		FoodPanel.setBounds (15,100,700, 610);
		FoodPanel.setBackground(new Color(204,255,204));
		Foodpanel.add(FoodPanel);

		JLabel FoodLabel = new JLabel("FOOD COURT");
		FoodLabel.setBounds(200,20, 700, 50);
		//withdrawLabel.setBackground(Color.ORANGE);
		FoodLabel.setFont(new Font("Gotham",Font.BOLD,45));
		Foodpanel.add(FoodLabel);

//		depositAmountLabel = new JLabel("Enter Amount to Deposit: ");
//		depositAmountLabel.setFont(new Font("Gotham",Font.BOLD,25));
//		depositAmountLabel.setBounds(150, 150, 500, 100);
//		topDepositPanel.add(depositAmountLabel);

//		depositText = new JTextField();
//		depositText.setFont(textFont);
//		depositText.setHorizontalAlignment(JTextField.CENTER);
//		depositText.setBounds(100,250,500,50);
//		topDepositPanel.add(depositText);

		foodCourtOk = new JButton("Food Court");
		foodCourtOk.setBounds(230, 350, 200,50);
		foodCourtOk.setForeground(Color.WHITE);
		foodCourtOk.setBackground(Color.BLACK);
		foodCourtOk.setFont(new Font("Gotham",Font.BOLD,18));
		FoodPanel.add(foodCourtOk);
		
		
		foodCourtOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				FoodCourt about = new FoodCourt(user, x,y);
				about.setVisible(true);	
				dispose();
			}
		});

//		JLabel depositErrorLabel = new JLabel("");
//		depositErrorLabel.setBounds(250, 300, 300, 50);
//		topDepositPanel.add(depositErrorLabel);

//		depositMessage = new JLabel("");
//		depositMessage.setBounds(150,50, 500,50);
//		depositMessage.setFont(new Font("Gotham",Font.BOLD,22));
//		topDepositPanel.add(depositMessage);


	//************************************* Medical Panel ************************************* 

		JPanel medical = new JPanel();
		medical.setLayout(null);
		medical.setBounds (15,100,700, 610);
		medical.setBackground(new Color(255,204,229));
		medicalPanel.add(medical);

		JLabel MedicalLabel = new JLabel("Medical Facility");
		MedicalLabel.setBounds(200,20, 700, 50);
		//withdrawLabel.setBackground(Color.ORANGE);
		MedicalLabel.setFont(new Font("Gotham",Font.BOLD,45));
		medicalPanel.add(MedicalLabel);


//		transferAccontLabel = new JLabel("Enter Account username:");
//		transferAccontLabel.setFont(new Font("Gotham",Font.BOLD,25));
//		transferAccontLabel.setBounds(150, 125, 500, 100);
//		medical.add(transferAccontLabel);

//		transferAccountText = new JTextField();
//		transferAccountText.setFont(textFont);
//		transferAccountText.setHorizontalAlignment(JTextField.CENTER);
//		transferAccountText.setBounds(100,200,500,50);
//		medical.add(transferAccountText);


//		transferAmountLabel = new JLabel("Enter Amount to transfer: ");
//		transferAmountLabel.setFont(new Font("Gotham",Font.BOLD,25));
//		transferAmountLabel.setBounds(150, 275, 500, 100);
//		medical.add(transferAmountLabel);

//		transferAmountText = new JTextField();
//		transferAmountText.setFont(textFont);
//		transferAmountText.setHorizontalAlignment(JTextField.CENTER);
//		transferAmountText.setBounds(100,350,500,50);
//		medical.add(transferAmountText);

		//Doctor Appointment Button
		
		DoctorOk = new JButton("Doctor Appointment");
		DoctorOk.setBounds(200, 50, 300,50);
		DoctorOk.setForeground(Color.WHITE);
		DoctorOk.setBackground(Color.BLACK);
		DoctorOk.setFont(new Font("Gotham",Font.BOLD,18));
		medical.add(DoctorOk);
		
		//Pharmacy Appointment Button
		
		farmacyok = new JButton("Pharmacy");
		farmacyok.setBounds(200, 150, 300,50);
		farmacyok.setForeground(Color.WHITE);
		farmacyok.setBackground(Color.BLACK);
		farmacyok.setFont(new Font("Gotham",Font.BOLD,18));
		medical.add(farmacyok);
		
		//Ambulance Appointment Button
		
		ambulanceok = new JButton("Ambulance");
		ambulanceok.setBounds(200, 250, 300,50);
		ambulanceok.setForeground(Color.WHITE);
		ambulanceok.setBackground(Color.BLACK);
		ambulanceok.setFont(new Font("Gotham",Font.BOLD,18));
		medical.add(ambulanceok);

		//Doctor Appointment Button Action
		
		DoctorOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				Doctor about = new Doctor(user, x,y);
				about.setVisible(true);	
				dispose();
			}
		});
		
		//Pharmacy Appointment Button Action
		
		farmacyok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				Farmacy about = new Farmacy(user, x,y);
				about.setVisible(true);	
				dispose();
			}
		});

		//Ambulance Appointment Button Action
		
		ambulanceok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				Ambulance about = new Ambulance(user, x,y);
				about.setVisible(true);	
				dispose();
			}
		});
		
//		JLabel transferErrorLabel_1 = new JLabel("");
//		transferErrorLabel_1.setBounds(250, 400, 300, 50);
//		medical.add(transferErrorLabel_1);

//		JLabel transferErrorLabel_2 = new JLabel("");
//		transferErrorLabel_2.setBounds(250, 250, 300, 50);
//		medical.add(transferErrorLabel_2);

//		transferMessage = new JLabel("");
//		transferMessage.setBounds(100,50, 500,50);
//		transferMessage.setFont(new Font("Gotham",Font.BOLD,20));
//		medical.add(transferMessage);


		//*************************************  Update Panel ************************************* 

		JLabel updateLabel = new JLabel("UPDATE");
		updateLabel.setBounds(200,5, 400, 50);
		//withdrawLabel.setBackground(Color.ORANGE);
		updateLabel.setFont(new Font("Gotham",Font.BOLD,45));
		updatePanel.add(updateLabel);
	
		Font updateFont = new Font("Gotham",Font.BOLD,20);
		Font erroeUpdateFont = new Font("Ariel", Font.ITALIC+Font.BOLD,12);
		
		// Name ###########################
		JPanel nameUpdatePanel = new JPanel();
		nameUpdatePanel.setLayout(null);
		nameUpdatePanel.setBounds(15,60,700, 50);
		nameUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(nameUpdatePanel);
			
		JLabel nameUpdateLabel = new JLabel("Change Name:");
		nameUpdateLabel.setBounds(30, 0, 200,50);
		nameUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
		nameUpdatePanel.add(nameUpdateLabel);

		JLabel firstNameError = new JLabel("");
		firstNameError.setBounds(270, 103, 200,25);
		firstNameError.setFont(erroeUpdateFont);
		updatePanel.add(firstNameError);

		JLabel lastNameError = new JLabel("");
		lastNameError.setBounds(495, 103, 200,25);
		lastNameError.setFont(erroeUpdateFont);
		updatePanel.add(lastNameError);

		JTextField firstNameUpdateText = new JTextField(user.getFirstName());
		firstNameUpdateText.setBounds(250,5,175,40);
		firstNameUpdateText.setHorizontalAlignment(JTextField.CENTER);
		firstNameUpdateText.setFont(new Font("Gotham",Font.ITALIC,18));

		JTextField lastNameUpdateText = new JTextField(user.getLastName());
		lastNameUpdateText.setHorizontalAlignment(JTextField.CENTER);
		lastNameUpdateText.setBounds(475,5,175,40);
		lastNameUpdateText.setFont(new Font("Gotham",Font.ITALIC,18));

		nameUpdatePanel.add(firstNameUpdateText); 
		nameUpdatePanel.add(lastNameUpdateText);


		//Email ###########################

		JPanel emailUpdatePanel = new JPanel();
		emailUpdatePanel.setLayout(null);
		emailUpdatePanel.setBounds(15,125,700, 50);
		emailUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(emailUpdatePanel);

		JLabel emailUpdateLabel = new JLabel("Change Email:");
		emailUpdateLabel.setBounds(30, 0, 200,50);
		emailUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
		emailUpdatePanel.add(emailUpdateLabel);

		JLabel emailErrorLabel = new JLabel("");
		emailErrorLabel.setBounds(270, 168, 200,25);
		emailErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(emailErrorLabel);

		JTextField updateEmailText = new JTextField(user.getEmail());
		updateEmailText.setHorizontalAlignment(JTextField.CENTER);
		updateEmailText.setBounds(250,5,400,40);
		updateEmailText.setFont(new Font("Gotham",Font.ITALIC,22));
		emailUpdatePanel.add(updateEmailText);


		//Phone ###########################

		JPanel phoneUpdatePanel = new JPanel();
		phoneUpdatePanel.setLayout(null);
		phoneUpdatePanel.setBounds(15,190,700, 50);
		phoneUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(phoneUpdatePanel);

		JLabel phoneUpdateLabel = new JLabel("Change Phone:");
		phoneUpdateLabel.setBounds(30, 0, 200,50);
		phoneUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
		phoneUpdatePanel.add(phoneUpdateLabel);

		JLabel phoneErrorLabel = new JLabel("");
		phoneErrorLabel.setBounds(270, 233, 200,25);
		phoneErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(phoneErrorLabel);

		JTextField phoneUpdateText = new JTextField(user.getPhone());
		phoneUpdateText.setBounds(250,5,400,40);
		phoneUpdateText.setHorizontalAlignment(JTextField.CENTER);
		phoneUpdateText.setFont(new Font("Gotham",Font.ITALIC,22));
		phoneUpdatePanel.add(phoneUpdateText);


			// Address ###########################

		JPanel addressUpdatePanel = new JPanel();
		addressUpdatePanel.setLayout(null);
		addressUpdatePanel.setBounds(15,255,700, 50);
		addressUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(addressUpdatePanel);

		JLabel addressUpdateLabel = new JLabel("Change Address:");
		addressUpdateLabel.setBounds(30, 0, 200,50);
		addressUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
		addressUpdatePanel.add(addressUpdateLabel);

		JLabel addressErrorLabel = new JLabel("");
		addressErrorLabel.setBounds(270, 298, 200,25);
		addressErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(addressErrorLabel);


		JTextField addressUpdateText = new JTextField(user.getAddress());
		addressUpdateText.setHorizontalAlignment(JTextField.CENTER);
		addressUpdateText.setBounds(250,5,400,40);
		addressUpdateText.setFont(new Font("Gotham",Font.ITALIC,22));
		addressUpdatePanel.add(addressUpdateText);


			// Date Of Birth ###########################

		JPanel dobUPanel = new JPanel();
		dobUPanel.setLayout(null);
		dobUPanel.setBounds(15,320,700, 50);
		dobUPanel.setBackground(updatePanelColor);
		updatePanel.add(dobUPanel);

		JLabel dobULabel = new JLabel("Change Birthday:");
		dobULabel.setBounds(30, 0, 300,50);
		dobULabel.setFont(new Font("Gotham",Font.BOLD,18));
		dobUPanel.add(dobULabel);

		JLabel dobErrorLabel = new JLabel("");
		dobErrorLabel.setBounds(270, 363, 200,25);
		dobErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(dobErrorLabel);

		JTextField dobUpdateText = new JTextField(user.getDateOfBirth());
		dobUpdateText.setHorizontalAlignment(JTextField.CENTER);
		dobUpdateText.setBounds(250,5,400,40);
		dobUpdateText.setFont(new Font("Gotham",Font.ITALIC,22));
		dobUPanel.add(dobUpdateText);

		//Gender ###########################

//		JPanel genderUpdatePanel = new JPanel();
//		genderUpdatePanel.setLayout(null);
//		genderUpdatePanel.setBounds(15,475,700, 50);
//		genderUpdatePanel.setBackground(updatePanelColor);
//		updatePanel.add(genderUpdatePanel);
//
//		JLabel genderUpdateLabel = new JLabel("Change Gender:");
//		genderUpdateLabel.setBounds(30, 0, 200,50);
//		genderUpdateLabel.setFont(new Font("Gotham",Font.BOLD,18));
//		genderUpdatePanel.add(genderUpdateLabel);
//
//		JLabel genderErrorLabel = new JLabel("");
//		genderErrorLabel.setBounds(270, 520, 200,25);
//		updatePanel.add(genderErrorLabel);
//
//		JRadioButton maleRadio = new JRadioButton("Male");
//		maleRadio.setBounds(250, 0, 60,50);
//		maleRadio.setBackground(updatePanelColor);
//		genderUpdatePanel.add(maleRadio);
//		JRadioButton femaleRadio = new JRadioButton("Female");
//		femaleRadio.setBounds(400, 0, 100,50);
//		femaleRadio.setBackground(updatePanelColor);
//		genderUpdatePanel.add(femaleRadio);
//
//		JRadioButton otherRadio = new JRadioButton("Other");
//		otherRadio.setBounds(550, 0, 100,50);
//		otherRadio.setBackground(updatePanelColor);
//		genderUpdatePanel.add(otherRadio);

//		if((user.getGender()).equals("Male"))
//		{
//			maleRadio.setSelected(true);
//		}
//		else if((user.getGender()).equals("Female"))
//		{
//			femaleRadio.setSelected(true);
//		}
//		else{
//			otherRadio.setSelected(true);
//		}

//		ButtonGroup buttonGroup = new ButtonGroup();
//		buttonGroup.add(maleRadio);
//		buttonGroup.add(femaleRadio);
//		buttonGroup.add(otherRadio);
	

		//****************** Update Password  ******************
		JPanel passwordUpdatePanel = new JPanel();
		passwordUpdatePanel.setLayout(null);
		passwordUpdatePanel.setBounds(15,385,700, 50);
		passwordUpdatePanel.setBackground(updatePanelColor);
		updatePanel.add(passwordUpdatePanel);

		JLabel passwordUpdatelabel = new JLabel("Change Password:");
		passwordUpdatelabel.setBounds(30, 0, 250,50);
		passwordUpdatelabel.setFont(new Font("Gotham",Font.BOLD,18));
		passwordUpdatePanel.add(passwordUpdatelabel);

		JLabel passErrorLabel = new JLabel("");
		passErrorLabel.setBounds(270, 328, 200,25);
		passErrorLabel.setFont(erroeUpdateFont);
		updatePanel.add(passErrorLabel);

		JPasswordField updatePasswordText = new JPasswordField(user.getPassword());
		updatePasswordText.setHorizontalAlignment(JTextField.CENTER);
		updatePasswordText.setBounds(250,5,400,40);
		updatePasswordText.setFont(new Font("Gotham",Font.ITALIC,22));
		passwordUpdatePanel.add(updatePasswordText);
		
		
		JLabel updateLabelForPassword = new JLabel("Enter password:");
		updateLabelForPassword.setBounds(20,460,200,50);
		updateLabelForPassword.setFont(new Font("Gotham",Font.BOLD,18));
		updatePanel.add(updateLabelForPassword);

		JLabel oldPassError = new JLabel("");
		oldPassError.setBounds(240,495,200,50);
		oldPassError.setFont(erroeUpdateFont);
		updatePanel.add(oldPassError);

		JPasswordField passText = new JPasswordField();
		passText.setHorizontalAlignment(JTextField.CENTER);
		passText.setFont(new Font("Gotham",Font.ITALIC,22));
		passText.setBounds(220,460,310,50);
		updatePanel.add(passText);

		JLabel updatable = new JLabel("");
		updatable.setBounds(550,580, 200,50);
		updatePanel.add(updatable);

		JButton updateButton = new JButton("UPDATE");
		updateButton.setBounds(550,540, 150,50);
		updateButton.setBackground(new Color(153,76,0));
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(new Font("Gotham",Font.ITALIC+Font.BOLD,22));

		updatePanel.add(updateButton);


		//************************************* Delete Panel ************************************* 

			JPanel topDeletePanel = new JPanel();
		topDeletePanel.setLayout(null);
		topDeletePanel.setBounds (15,100,700, 610);
		topDeletePanel.setBackground(new Color(255,204,204));
		deletePanel.add(topDeletePanel);

		JLabel deleteLabel = new JLabel("DELETE");
		deleteLabel.setBounds(200,20, 700, 50);
		//withdrawLabel.setBackground(Color.ORANGE);
		deleteLabel.setFont(new Font("Gotham",Font.BOLD,45));
		deletePanel.add(deleteLabel);

		JLabel deleteTextLabel = new JLabel("Enter password to Confirm: ");
		deleteTextLabel.setFont(new Font("Gotham",Font.BOLD,25));
		deleteTextLabel.setBounds(150, 150, 500, 100);
		topDeletePanel.add(deleteTextLabel);

		deletePass = new JPasswordField();
		deletePass.setFont(textFont);
		deletePass.setHorizontalAlignment(JTextField.CENTER);
		deletePass.setBounds(100,250,500,50);
		topDeletePanel.add(deletePass);

		deleteOk = new JButton("Delete");
		deleteOk.setBounds(230, 350, 200,50);
		deleteOk.setForeground(Color.WHITE);
		deleteOk.setBackground(Color.BLACK);
		deleteOk.setFont(new Font("Gotham",Font.BOLD,18));
		topDeletePanel.add(deleteOk);

		JLabel deleteErrorLabel = new JLabel("");
		deleteErrorLabel.setBounds(250, 300, 300, 50);
		topDeletePanel.add(deleteErrorLabel);



	//#################################  PANEL ENDS  #########################################################################

	

		JButton zero = new JButton();  // Captures first mark 
		zero.setBounds(0,0,0,0);
		c.add(zero);


		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBounds(60, 550, 200,50);
		refreshButton.setFont(new Font("Gotham",Font.BOLD,25));
		refreshButton.setForeground(Color.WHITE);
		refreshButton.setBackground(new Color(0,153,0));
		//c.add(refreshButton);	
		updatePanel.add(refreshButton);


		//Logout Button *************************************************************************

		buttonLogOut = new JButton("Logout");
		buttonLogOut.setBounds(800,15, 150,40);
		buttonLogOut.setBackground(Color.RED);
		buttonLogOut.setForeground(Color.WHITE);
		buttonLogOut.setFont(new Font("Gotham",Font.BOLD,25));
		c.add(buttonLogOut);

		buttonLogOut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				MainPage main = new MainPage(x,y);
				main.setVisible(true);
				dispose();


			}
		});


		refreshButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				
				UserPage main = new UserPage(user,x,y);
				main.setVisible(true);
				dispose();


			}
		});


		updateButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{					Color greenColor = new Color(0,153,0);
				Color redColor = new Color(204,0,0);

				/// ****************** INPUTS *****************************
				String firstName = firstNameUpdateText.getText();
				String lastName = lastNameUpdateText.getText();
				String email = updateEmailText.getText();
				Matcher matcher = (Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9\\+_-]+(\\.[\\p{L}0-9\\+_-]+)*@"
				        + "[^-][\\p{L}0-9\\+-]+(\\.[\\p{L}0-9\\+-]+)*(\\.[\\p{L}]{2,})$")).matcher(email);
				String phone = phoneUpdateText.getText();
				String address = addressUpdateText.getText();
				String dateOfBirth = dobUpdateText.getText();
			 	String newPassword = String.valueOf(updatePasswordText.getPassword());
			 	String password = String.valueOf(passText.getPassword());
				//String gender;
				passText.setText("");

//				 if(maleRadio.isSelected())
//				 {
//				 	gender = "Male";
//				 }
//				 else if(femaleRadio.isSelected())
//				 {
//				 	gender = "Female";
//				 }
//				 else{
//				 	gender = "Other";
//				 }

				Date date1 = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
				String str = formatter.format(date1);
				
				try {
				Date current = formatter.parse(str);
				Date input = formatter.parse(dateOfBirth);
				//Date output = formatter.parse(s3);
				a = current.after(input);
				//b = output.after(input);
				} catch (Exception e11) {
				//	e11.printStackTrace();
				}
				
				
				if((user.getFirstName()).equals(firstName) && (user.getLastName()).equals(lastName) && (user.getEmail()).equals(email) && (user.getPhone()).equals(phone) && (user.getAddress()).equals(address) && (user.getDateOfBirth()).equals(dateOfBirth) && (user.getPassword()).equals(newPassword) && (user.getPassword()).equals(password))
				 {

				 	oldPassError.setText("");
				 	firstNameError.setText("");
				 	lastNameError.setText("");
				 	emailErrorLabel.setText("");
				 	phoneErrorLabel.setText("");
				 	addressErrorLabel.setText("");
				 	dobErrorLabel.setText("");
				 	//genderErrorLabel.setText("");
				 	passErrorLabel.setText("");
				 	// updatable.setText("Nothing to update");
				 	// updatable.setForeground(redColor);
				 	JOptionPane.showMessageDialog(null, "Nothing has been changed!", "Not updated", -1);
				 }
				 else
				 {
				 	
					//************************************************
					if(!(firstName.equals("")) && !(lastName.equals("")) && !(email.equals("")) && !(phone.equals("")) && !(address.equals("")) && !(dateOfBirth.equals("")) && !(password.equals("")) && password.length()>=8 && matcher.matches()
							&&  (phone.matches("[0-9]{11}")) && (dateOfBirth.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) && (a))
					{
						 if((user.getPassword()).equals(password))
						 {
						 	oldPassError.setText("");
						 	
						 	// updatable.setText("Refresh the page");
						 	// updatable.setForeground(greenColor);

						 	//******************* Update labels
						 	if((user.getFirstName()).equals(firstName))
						 	{
						 		firstNameError.setText("");
						 	}
						 	else
						 	{	user.changeFirstName(firstName);
						 		firstNameError.setText("First name updated");
						 		firstNameError.setForeground(greenColor);
						 	}
						 	if((user.getLastName()).equals(lastName))
						 	{
						 		lastNameError.setText("");
						 	}
						 	else
						 	{	user.changeLastName(lastName);
						 		lastNameError.setText("Last name updated");
						 		lastNameError.setForeground(greenColor);
						 	}
						 	if((user.getEmail()).equals(email))
						 	{
						 		emailErrorLabel.setText("");
						 	}
						 	else
						 	{	
						 		user.changeEmail(email);
						 		emailErrorLabel.setText("Email updated");
						 		emailErrorLabel.setForeground(greenColor);
						 	}
  						 	if((user.getPhone()).equals(phone))
						 	{
						 		phoneErrorLabel.setText("");
						 	}
						 	else
						 	{
						 		user.changePhone(phone);
						 		phoneErrorLabel.setText("Phone no updated");
						 		phoneErrorLabel.setForeground(greenColor);	
						 	}
						 	if((user.getAddress()).equals(address))
						 	{
						 		addressErrorLabel.setText("");
						 	}
						 	else
						 	{
						 		user.changeAddress(address);
						 		addressErrorLabel.setText("Address updated");
						 		addressErrorLabel.setForeground(greenColor);
						 	}
						 	if((user.getDateOfBirth()).equals(dateOfBirth))
						 	{
						 		dobErrorLabel.setText("");
						 	}
						 	else
						 	{
						 		user.changeDateOfBirth(dateOfBirth);
						 		dobErrorLabel.setText("Date of Birth Updated");
						 		dobErrorLabel.setForeground(greenColor);

						 	}

//						 	if((user.getGender()).equals(gender))
//						 	{
//						 		genderErrorLabel.setText("");
//						 	}
//						 	else
//						 	{
//						 		user.changeGender(gender);
//						 		genderErrorLabel.setText("Gender updated");
//						 		genderErrorLabel.setForeground(greenColor);
//						 	}

						 	if((user.getPassword()).equals(newPassword))
						 	{
						 		passErrorLabel.setText("");
						 	}
						 	else
						 	{
						 		user.changePassword(newPassword);
						 		passErrorLabel.setText("Password updated");
						 		passErrorLabel.setForeground(greenColor);	
						 	}


					 	//************************************************************************
						 
						 	JOptionPane.showMessageDialog(null, "Account successfully updated!\n\tRefresh the page.", "Updated", -1);
						 	LocalDateTime unformatedDate = LocalDateTime.now();
						    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						    String date = unformatedDate.format(format);
							String[] record = {"Account Updated", "", date};
							user.addRecord(record);
							user.saveFile();
						 
						 }
						 else
						 {
						 	oldPassError.setText("Wrong Password");
						 }
					}
					else
					{
						
					 	if(firstName.equals(""))
					 	{
					 		firstNameError.setText("Empty first name");
					 		firstNameError.setForeground(redColor);
					 	}
					 	else{
					 		firstNameError.setText("");
					 	}

					 	if(lastName.equals(""))
					 	{
					 		lastNameError.setText("Empty last name");
					 		lastNameError.setForeground(redColor);
					 	}
					 	else
				 		{
					 		lastNameError.setText("");
					 	}
					 	if(email.equals(""))
					 	{
					 		emailErrorLabel.setText("Empty email");
					 		emailErrorLabel.setForeground(redColor);
					 	}
					 	else if(!(matcher.matches()))
					 	{
					 		emailErrorLabel.setText("Invalid Email format");
					 		emailErrorLabel.setForeground(redColor);
					 	}
					 	else
				 		{
					 		emailErrorLabel.setText("");
					 	}
					 	if(phone.equals(""))
					 	{
					 		phoneErrorLabel.setText("Empty phone no");
					 		phoneErrorLabel.setForeground(redColor);
					 	}
					 	else if(!(phone.matches("[0-9]{11}")))
					 	{
					 		phoneErrorLabel.setText("Invalid Phone no");
					 		phoneErrorLabel.setForeground(redColor);
					 	}
					 	else
					 	{
					 		phoneErrorLabel.setText("");
					 	}
					 	if(address.equals(""))
					 	{
					 		phoneErrorLabel.setText("Empty address");
					 		phoneErrorLabel.setForeground(redColor);
					 	}
					 	else
					 	{
					 		addressErrorLabel.setText("");
					 	}
					 	if(dateOfBirth.equals(""))
					 	{
					 		dobErrorLabel.setText("Empty date of birth");
					 		dobErrorLabel.setForeground(redColor);
					 	}
					 	else if(!(dateOfBirth.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")))
					 	{
					 		dobErrorLabel.setText("Invalid date of birth");
					 		dobErrorLabel.setForeground(redColor);
					 	}
					 	else if(!a)
					 	{
					 		dobErrorLabel.setText("Invalid date of birth");
					 		dobErrorLabel.setForeground(redColor);
					 	}
					 	else
				 		{
					 		dobErrorLabel.setText("");
					 	}
					 	if(newPassword.equals(""))
					 	{
					 		passErrorLabel.setText("Empty Password");
					 		passErrorLabel.setForeground(redColor);
					 	}
					 	else if(newPassword.length()<8)
					 	{
					 		passErrorLabel.setText("Password should have at least 8 characters");
					 		passErrorLabel.setForeground(redColor);	
					 	}
					 	else
				 		{
					 		passErrorLabel.setText("");
					 	}
					 	if(password.equals("") || !(user.getPassword()).equals(password))
					 	{
					 		oldPassError.setText("Wrong Password");
					 		oldPassError.setForeground(redColor);
					 	}
					 	else
					 	{
					 		oldPassError.setText("");	
					 	}

					}


				 }


			}
		});






		//Buttons

//		SeaviewOk.addActionListener(new ActionListener(){
//
//			public void actionPerformed(ActionEvent e)
//			{
//				try{
//					double amount = Double.parseDouble(withdrawText.getText()); 
//					//withdrawErrorLabel.setText("");
//					if(user.getBalance()>=amount)
//					{
//						user.withdraw(amount);
//						withdrawMessage.setText(amount+" Taka withdraw successful!");
//						infoBalance.setText(""+user.getBalance());
//						withdrawText.setText("");
//						//
//
//						LocalDateTime unformatedDate = LocalDateTime.now();
//					    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//					    String date = unformatedDate.format(format);
//						//
//						String[] record = {"Withdraw", ""+amount, date.toString()};
//						user.addRecord(record);
//						user.saveFile();
//					}
//					else{
//						withdrawMessage.setText("");
//						withdrawErrorLabel.setText("Insufficient balance");
//						withdrawErrorLabel.setForeground(Color.RED);
//					}
//				} 
//				catch(Exception ex)
//				{
//					withdrawMessage.setText("");
//					withdrawErrorLabel.setText("Invalid amount");
//					withdrawErrorLabel.setForeground(Color.RED);
//				}
//				
//
//			}
//		});

//		depositOk.addActionListener(new ActionListener(){
//
//			public void actionPerformed(ActionEvent e)
//			{	try{
//					double amount = Double.parseDouble(depositText.getText()); 
//					user.deposit(amount);
//
//					depositMessage.setText(amount+" Taka deposit successful!");
//					infoBalance.setText(""+user.getBalance());
//					depositText.setText("");
//					depositErrorLabel.setText("");
//
//
//					LocalDateTime unformatedDate = LocalDateTime.now();
//				    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//				    String date = unformatedDate.format(format);
//					String[] record = {"Deposit", ""+amount, date.toString()};
//					user.addRecord(record);
//	 				user.saveFile();
// 				}
// 				catch(Exception ex)
// 				{
// 					depositMessage.setText("");
// 					depositErrorLabel.setText("Invalid amount");
//					depositErrorLabel.setForeground(Color.RED);
// 				}
//			}
//
//	});

//		DoctorOk.addActionListener(new ActionListener(){
//
//			public void actionPerformed(ActionEvent e)
//			{
//				Username username = new Username(transferAccountText.getText());
//				
//				try{
//					double amount = Double.parseDouble(transferAmountText.getText()); 
//					if(username.exists() && !((username.get()).equals(user.getUsername())))
//					{	
//						transferErrorLabel_1.setText("");
//						transferErrorLabel_2.setText("");
//						User tuser;
//						try{
//							ObjectInputStream file = new ObjectInputStream(new FileInputStream("users/"+username.get()+".dat"));
//							tuser = (User)file.readObject();
//						
//							if(user.getBalance()>=amount)
//							{
//								transferAccountText.setText("");
//								transferAmountText.setText("");
//								transferErrorLabel_1.setText("");
//								transferErrorLabel_2.setText("");
//								user.withdraw(amount);
//								tuser.deposit(amount);
//								transferMessage.setText(amount+" Taka transfer to "+tuser.getUsername()+" successful!");
//								infoBalance.setText(""+user.getBalance());
//								LocalDateTime unformatedDate = LocalDateTime.now();
//							    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//							    String date = unformatedDate.format(format);
//								String[] userRecord = {"Transfer to "+tuser.getUsername(), ""+amount, date.toString()};
//								String[] tUserRecord = {"Transfer from "+user.getUsername(), ""+amount, date.toString()};
//								user.addRecord(userRecord);
//								tuser.addRecord(tUserRecord);
//								user.saveFile();
//								tuser.saveFile();
//							}
//							else
//							{
//								transferErrorLabel_1.setText("Insufficient balance!");
//								transferErrorLabel_1.setForeground(Color.RED);
//							}
//								
//							
//							
//						}
//						catch(Exception ex)
//						{
//							System.out.println("An error occured during Transfer");
//							System.out.println(e.toString());
//						} 
//					
//					}
//					else
//					{
//						transferErrorLabel_1.setText("");
//						transferErrorLabel_2.setText("Account Not found");
//						transferErrorLabel_2.setForeground(Color.RED);
//					}
//						
//				}
//				catch(Exception ex1)
//				{
//					if(!username.exists())
//					{
//						transferErrorLabel_2.setText("Account Not found");
//						transferErrorLabel_2.setForeground(Color.RED);
//					}
//					else
//					{
//						transferErrorLabel_2.setText("");
//					}
//					transferMessage.setText("");
//					transferErrorLabel_1.setText("Invalid amount");
//					transferErrorLabel_1.setForeground(Color.RED);
//				}
//					
//			}
//
//		});

		deleteOk.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				String password = String.valueOf(deletePass.getPassword());
				if(user.getPassword().equals(password))
				{
					user.deleteAccount();
					JOptionPane.showMessageDialog(null, "Account deleted!", "Delete", -1);
					Point point = getLocation();
					int x = (int)point.getX(); int y = (int)point.getY();
					MainPage main = new MainPage(x,y);
					main.setVisible(true);
					dispose();

				}
				else
				{
					deleteErrorLabel.setText("Wrong Password");
					deleteErrorLabel.setForeground(Color.RED);
				}
			}

	});

	}

}