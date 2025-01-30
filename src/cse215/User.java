package cse215;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
public class User implements Serializable{
	
	//Data fields 
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String dateOfBirth;
	private String password;
	private double balance;
	private String price;
	private String date;
	private String duration;
	private String view;
	private Vector<String[]> records = new Vector<String[]>(); // type-- amount --- date 
	//Default constructor
	User() {}
	//Overloaded constructor
	User(String username, String firstName, String lastName, String email, String phone, String address, String dateOfBirth, String password)
	{
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.balance = 1000.0;
	
		// Adding account creation record

		LocalDateTime unformatedDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String date = unformatedDate.format(format);
		String[] record = {"Account Created", "", date.toString()};
		records.add(record);
		
	}


	// This method saves the User object to its 'username.dat' file;

	public void saveFile()
	{	try{
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("users/"+this.getUsername()+".dat"));
			file.writeObject(this);
			file.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

	/// Delete account! 
	public void deleteAccount()
	{
		 this.removeUsernameFromList();
		try{
				File userFile = new File("users/"+this.getUsername()+".dat");

				if(!userFile.delete())
				{
					System.out.println("Couldn't delete file[ User.java: 64]");
				}

			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}

	}

// this method removes username from the username list;
	private void removeUsernameFromList()
		{
		 	String username = this.getUsername();
			 try{ 

	        PrintWriter file_to_write = new PrintWriter ( new BufferedWriter(new FileWriter("temp.txt")));
	        BufferedReader file_to_read = new BufferedReader(new FileReader("usernamelist.txt"));
	        String temp;
	        while((temp = file_to_read.readLine()) != null)
	        {
	            if (!(temp.equals(username)))  //// Checks each line of the list;
	            {
	                file_to_write.println(temp);
	            }
	        }

	        file_to_read.close();
	        file_to_write.close();     
	        }
	        catch (Exception e)
	        {
	             System.out.println("User.java Line 99: "+e.toString());
	        }


	        try{
	        	File userFile = new File("usernamelist.txt");
						userFile.delete();
					}
	        catch (Exception e) {
	        	 System.out.println("User.java Line 108: "+e.toString());
	        }

	        try{

		        File oldfile =new File("temp.txt");
		        File newfile =new File("usernamelist.txt");
						oldfile.renameTo(newfile);
	        }
	        catch(Exception e)
	        {
	        	 System.out.println("User.java Line 199: "+e.toString());
	        }
}

 /// setters ************************************************************************************

	public void changeFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void changeLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void changeEmail(String email)
	{
		this.email = email;
	}
	public void changePhone(String phone)
	{
		this.phone = phone;
	}
	public void changeAddress(String address)
	{
		this.address = address;
	}
	public void changeDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	public void changePassword(String password)
	{
		this.password = password;
	}
	public void changeView(String view)
	{
		this.view = view;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public void setPrice(String price)
	{
		this.price = price;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public void setDuration(String duration)
	{
		this.duration = duration;
	}
 

// Action ************************************************************************************


	public void deposit(double amount)
	{
		this.balance = this.balance+amount;
	}
	public void withdraw(double amount)
	{
		this.balance = this.balance - amount;
	}

	public void addRecord(String[] newRecord )
	{
		records.add(newRecord);
	}

		public Vector<String[]> getRecords()
	{
		return this.records;
	}

// Getters ************************************************************************************
	
	public String getUsername()
	{
		return this.username;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public String getAddress()
	{
		return this.address;
	}
	public String getDateOfBirth()
	{
		return this.dateOfBirth;
	}
	public String getView()
	{
		return this.view;
	}
	public String getPassword()
	{
		return this.password;
	}
	public double getBalance()
	{
		return this.balance;
	}
	public String getPrice()
	{
		return this.password;
	}
	public String getDate()
	{
		return this.password;
	}
	public String getDuration()
	{
		return this.password;
	}
//********************************

}//last curly brace