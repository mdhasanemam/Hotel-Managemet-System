package cse215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class BookingDate {

	// private String currentcheckInDate;
	// private String currentcheckOutDate;
	// private String currentroom;
	int size;
	Vector vc_CheckIn = new Vector();
	// Vector vc_CheckOut = new Vector();
	Vector vc_Room = new Vector();
	public boolean availableRoom(String s4, String s3) {
		try {
			BufferedReader file_to_read = new BufferedReader(new FileReader("Booking.txt"));
			String temp;
			while ((temp = file_to_read.readLine()) != null) {
				System.out.println(temp);
				System.out.println(s3);
				System.out.println(s4);
				if ( temp.equals(s4)||temp.equals(s3)) {
					return false;
				}
			}
		
		} catch (Exception e) {
			System.out.println("Error Occured reading usernamelist!");
			System.out.println(e.toString());

		}
		return true;
		
	}
}