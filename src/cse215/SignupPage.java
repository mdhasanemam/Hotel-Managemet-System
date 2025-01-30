
package cse215;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;

public class SignupPage extends JFrame {
	private Container c;
	private ImageIcon icon;
	// private JDateChooser dateChooser;
	private JLabel firstNameLabel, lastNameLabel, nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel,
			dateOfBirthLabel, dateOfBirthLabel_2, genderLabel, addressLabel;
	private JLabel /* Warnings */ usernameError, firstNameError, lastNameError, balanceError, phoneError, emailError,
			dateOfBirthError, genderError, passwordError, addressError;
	private JTextField usernameText, firstNameText, lastNameText, balanceText, phoneText, emailText, dateOfBirthText,
			genderText, addressText;
	private JPasswordField passText;
	private JButton signpButton, clearButton, cancelButton, backButton;
	// private JRadioButton maleRadio, femaleRadio, otherRadio;
	private ButtonGroup buttonGroup;

	SignupPage(int x, int y) {

		/*********************** Same Everywhere **********************/
		Color backgroundColor = new Color(133, 172, 233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Create New Account");
		this.setBounds(x, y, 1100, 730);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);
		this.icon = new ImageIcon(getClass().getResource("images/icon_2.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/

		// ****************** Fonts ******************

		labelFont = new Font("Gotham", Font.BOLD, 20);
		Font textFont = new Font("Gotham", Font.PLAIN, 20);
		errorFont = new Font("Ariel", Font.ITALIC + Font.BOLD, 12);

		// ****************** Username ******************
		usernameLabel = new JLabel("USERNAME");
		usernameLabel.setBounds(60, 30, 150, 50);
		usernameLabel.setFont(labelFont);
		c.add(usernameLabel);

		JLabel finalUsername = new JLabel("[ Account will be known as and cannot change later]");
		finalUsername.setBounds(530, 80, 400, 25);
		c.add(finalUsername);

		usernameError = new JLabel("");
		usernameError.setBounds(360, 80, 200, 25);
		usernameError.setForeground(Color.RED);
		usernameError.setFont(errorFont);
		c.add(usernameError);

		//// textFiled ******************

		usernameText = new JTextField("");
		usernameText.setFont(textFont);
		usernameText.setBounds(350, 30, 550, 50);
		usernameText.setHorizontalAlignment(JTextField.CENTER);
		c.add(usernameText);

		// ****************** Name ******************
		nameLabel = new JLabel("NAME");
		nameLabel.setFont(labelFont);
		nameLabel.setBounds(60, 130, 200, 50);
		c.add(nameLabel);
		firstNameError = new JLabel("");
		firstNameError.setBounds(410, 180, 200, 25);
		firstNameError.setForeground(Color.RED);
		firstNameError.setFont(errorFont);
		c.add(firstNameError);
		lastNameError = new JLabel("");
		lastNameError.setBounds(710, 180, 200, 25);
		lastNameError.setForeground(Color.RED);
		lastNameError.setFont(errorFont);
		c.add(lastNameError);

		firstNameLabel = new JLabel("First");
		firstNameLabel.setBounds(360, 180, 100, 25);
		c.add(firstNameLabel);

		lastNameLabel = new JLabel("Last");
		lastNameLabel.setBounds(660, 180, 100, 25);
		c.add(lastNameLabel);

		// Text Field ***********

		firstNameText = new JTextField("");
		firstNameText.setBounds(350, 130, 250, 50);
		firstNameText.setFont(textFont);
		firstNameText.setHorizontalAlignment(JTextField.CENTER);
		c.add(firstNameText);
		lastNameText = new JTextField("");
		lastNameText.setBounds(650, 130, 250, 50);
		lastNameText.setFont(textFont);
		lastNameText.setHorizontalAlignment(JTextField.CENTER);
		c.add(lastNameText);

		// ****************** Email ******************
		emailLabel = new JLabel("EMAIL");
		emailLabel.setBounds(60, 210, 150, 50);
		emailLabel.setFont(labelFont);
		c.add(emailLabel);
		emailError = new JLabel("");
		emailError.setBounds(360, 260, 200, 25);
		emailError.setForeground(Color.RED);
		emailError.setFont(errorFont);
		c.add(emailError);

		//// textFiled ******************

		emailText = new JTextField("");
		emailText.setFont(textFont);
		emailText.setHorizontalAlignment(JTextField.CENTER);
		emailText.setBounds(350, 210, 550, 50);
		c.add(emailText);

		// ****************** Phone ******************
		phoneLabel = new JLabel("PHONE");
		phoneLabel.setBounds(60, 300, 150, 50);
		phoneLabel.setFont(labelFont);
		c.add(phoneLabel);
		phoneError = new JLabel("");
		phoneError.setBounds(360, 350, 200, 25);
		phoneError.setForeground(Color.RED);
		phoneError.setFont(errorFont);
		c.add(phoneError);

		//// textFiled ******************

		phoneText = new JTextField("");
		phoneText.setFont(textFont);
		phoneText.setHorizontalAlignment(JTextField.CENTER);
		phoneText.setBounds(350, 300, 550, 50);
		c.add(phoneText);

		// ****************** Address ******************
		addressLabel = new JLabel("ADDRESS");
		addressLabel.setBounds(60, 380, 150, 50);
		addressLabel.setFont(labelFont);
		c.add(addressLabel);
		addressError = new JLabel("");
		addressError.setBounds(360, 430, 200, 25);
		addressError.setForeground(Color.RED);
		addressError.setFont(errorFont);
		c.add(addressError);

		//// textFiled ******************

		addressText = new JTextField("");
		addressText.setFont(textFont);
		addressText.setHorizontalAlignment(JTextField.CENTER);
		addressText.setBounds(350, 380, 550, 50);
		c.add(addressText);

		// ****************** Date Of Birth ******************
		dateOfBirthLabel = new JLabel("DATE OF BIRTH");
		dateOfBirthLabel.setBounds(60, 460, 200, 50);
		dateOfBirthLabel.setFont(labelFont);
		c.add(dateOfBirthLabel);
		dateOfBirthError = new JLabel("");
		dateOfBirthError.setBounds(560, 512, 200, 25);
		dateOfBirthError.setForeground(Color.RED);
		dateOfBirthError.setFont(errorFont);
		c.add(dateOfBirthError);

		dateOfBirthLabel_2 = new JLabel("(DD/MM/YYYY)");
		dateOfBirthLabel_2.setBounds(360, 512, 200, 25);
		c.add(dateOfBirthLabel_2);

		//// textFiled ******************

		dateOfBirthText = new JTextField("");
		dateOfBirthText.setFont(textFont);
		dateOfBirthText.setHorizontalAlignment(JTextField.CENTER);
		dateOfBirthText.setBounds(350, 460, 550, 50);
		c.add(dateOfBirthText);

		// ****************** Gender ******************
		/*
		 * genderLabel = new JLabel("MARITAL STATUS");
		 * genderLabel.setBounds(60,470,200,50); genderLabel.setFont(labelFont);
		 * c.add(genderLabel); maleRadio = new JRadioButton("Single");
		 * maleRadio.setBounds(350, 470, 60,50);
		 * maleRadio.setBackground(backgroundColor); c.add(maleRadio); femaleRadio = new
		 * JRadioButton("Married"); femaleRadio.setBounds(500, 470, 100,50);
		 * femaleRadio.setBackground(backgroundColor); c.add(femaleRadio);
		 * 
		 * otherRadio = new JRadioButton("Other"); otherRadio.setBounds(650, 470,
		 * 100,50); otherRadio.setBackground(backgroundColor);
		 * otherRadio.setSelected(true); c.add(otherRadio);
		 * 
		 * buttonGroup = new ButtonGroup(); buttonGroup.add(maleRadio);
		 * buttonGroup.add(femaleRadio); buttonGroup.add(otherRadio);
		 * 
		 */

		// ****************** Password ******************
		passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(60, 540, 150, 50);
		passwordLabel.setFont(labelFont);
		c.add(passwordLabel);
		passwordError = new JLabel("");
		passwordError.setBounds(360, 590, 300, 25);
		passwordError.setForeground(Color.RED);
		passwordError.setFont(errorFont);
		c.add(passwordError);

		//// textFiled ******************

		passText = new JPasswordField("");
		passText.setFont(textFont);
		passText.setBounds(350, 540, 550, 50);
		passText.setHorizontalAlignment(JTextField.CENTER);
		c.add(passText);

		// ****************** Buttons ******************

		// Signup Button **********

		signpButton = new JButton("SIGNUP");
		signpButton.setBackground(new Color(0, 153, 0));
		signpButton.setForeground(Color.WHITE);
		signpButton.setFont(new Font("Gotham", Font.BOLD, 25));
		signpButton.setBounds(400, 620, 200, 50);
		c.add(signpButton);

		clearButton = new JButton("Clear");
		clearButton.setBackground(new Color(255, 128, 0));
		clearButton.setForeground(Color.WHITE);
		clearButton.setBounds(800, 620, 100, 50);
		c.add(clearButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(204, 0, 0));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(100, 620, 100, 50);
		c.add(cancelButton);

		signpButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Username username = new Username(usernameText.getText());
				String firstName = firstNameText.getText();
				String lastName = lastNameText.getText();
				String email = emailText.getText();
				Matcher matcher = (Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9\\+_-]+(\\.[\\p{L}0-9\\+_-]+)*@"
				        + "[^-][\\p{L}0-9\\+-]+(\\.[\\p{L}0-9\\+-]+)*(\\.[\\p{L}]{2,})$")).matcher(email);
				String phone = phoneText.getText();
				String address = addressText.getText();
				String dateOfBirth = dateOfBirthText.getText();
				String password = String.valueOf(passText.getPassword());

//                 ############User Date>>>>>>>>>				 

				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				String s2 = null;
				int user_month = 0;
				int user_day = 0;
				int user_year = 0;
				try {
					java.util.Date d = sdf.parse(dateOfBirth);
					s2 = sdf.format(d);
					// System.out.println(s2);
					SimpleDateFormat day_user = new SimpleDateFormat("dd");
					user_day = Integer.parseInt(day_user.format(d));
					// System.out.println("Day:"+user_day);

					SimpleDateFormat month_user = new SimpleDateFormat("mm");
					user_month = Integer.parseInt(month_user.format(d));
					// System.out.println("Day:"+user_month);

					SimpleDateFormat year_user = new SimpleDateFormat("yyyy");
					user_year = Integer.parseInt(year_user.format(d));
					// System.out.println("Day:"+user_year);

				} catch (ParseException e1) {
					e1.printStackTrace();
				}

//				############Current Date>>>>>
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String str = formatter.format(date);
				//System.out.println("Current date: " + str);

				SimpleDateFormat day_current = new SimpleDateFormat("dd");
				int day_Current = Integer.parseInt(day_current.format(date));
				// System.out.println("Day current:"+day_current.format(date));

				SimpleDateFormat month_current = new SimpleDateFormat("MM");
				int month_Current = Integer.parseInt(month_current.format(date));

				SimpleDateFormat year_current = new SimpleDateFormat("yyyy");
				int year_Current = Integer.parseInt(year_current.format(date));

				int count = 0;

				if (year_Current > user_year) {
					count = 0;
				}

				else if (year_Current < user_year) {
					count = 1;
				}

				else if (year_Current == user_year) {
					if (month_Current > user_month) {
						count = 0;
					} else if (month_Current < user_month) {
						count = 1;
					} else if (month_Current == user_month) {
						if (day_Current > user_day) {
							count = 0;
						} else if (day_Current < user_day) {
							count = 1;
						}

						else {
							count = 0;
						}

					}
				}

				if (!(username.get()).equals("") && !(firstName.equals("")) && !(lastName.equals(""))
						&& !(email.equals("")) && (phone.matches("[0-9]{11}")) && !(address.equals(""))&&(!(dateOfBirth.matches(" ")))
						&& (dateOfBirth.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}"))&&(count==0)
						&& !(password.equals("")) && password.length() >= 8 && matcher.matches()) {

					if (!(username.exists())) {
						User user = new User(username.get(), firstName, lastName, email, phone, address, dateOfBirth,
								password);
						user.saveFile();
						username.write();
						JOptionPane.showMessageDialog(null, "Account successfully created\nNow you can login",
								"Signup successful", -1);

						Point point = getLocation();
						int x = (int) point.getX();
						int y = (int) point.getY();
						MainPage main = new MainPage(x, y);
						main.setVisible(true);
						dispose();
					} else {
						usernameError.setText("Username already exists");
					}

				}

				else {
					if (username.exists()) {
						usernameError.setText("Username already exists");
					} else if ((username.get()).equals("")) {
						usernameError.setText("Empty username");
					} else {
						usernameError.setText("");
					}

					if (firstName.equals("")) {
						firstNameError.setText("Empty first name");
					} else {
						firstNameError.setText("");
					}

					if (lastName.equals("")) {
						lastNameError.setText("Empty last name");
					} else {
						lastNameError.setText("");
					}
					if (email.equals("")) {
						emailError.setText("Empty email");
					} else if (!(matcher.matches())) {
						emailError.setText("Invalid Email format");
					} else {
						emailError.setText("");
					}
					if (phone.equals("")) {
						phoneError.setText("Empty phone no");
					} else if (!(phone.matches("[0-9]{11}"))) {
						phoneError.setText("Invalid Phone Number");
					} else {
						phoneError.setText("");
					}
					if (address.equals("")) {
						addressError.setText("Empty address");
					} else {
						addressError.setText("");
					}
					if (dateOfBirth.equals("")) {
						dateOfBirthError.setText("Empty date of birth");
					} else if (!(dateOfBirth.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}"))) {
						dateOfBirthError.setText("Invalid Date Formate");
					} else if (count==1) {
						dateOfBirthError.setText("Invalid Date");
					} else {
						dateOfBirthError.setText("");
					}
					if (password.equals("")) {
						passwordError.setText("Empty Password");
					} else if (password.length() < 8) {
						passwordError.setText("Password should have at least 8 characters");
					} else {
						passwordError.setText("");
					}
				}

			}
		});

		clearButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				usernameText.setText("");
				usernameError.setText("");
				firstNameText.setText("");
				firstNameError.setText("");
				lastNameText.setText("");
				lastNameError.setText("");
				emailText.setText("");
				emailError.setText("");
				phoneText.setText("");
				phoneError.setText("");
				addressText.setText("");
				addressError.setText("");
				dateOfBirthText.setText("");
				dateOfBirthError.setText("");
				passText.setText("");
				passwordError.setText("");

			}
		});

		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				MainPage main = new MainPage(x, y);
				main.setVisible(true);
				dispose();

			}
		});

	}
}