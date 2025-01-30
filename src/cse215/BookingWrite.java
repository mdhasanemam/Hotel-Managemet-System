package cse215;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookingWrite {
	//private String dateAftere;

	//private String checkInDate, checkOutDate, room;
	
	 BookingWrite(String checkInDate, long daysDiff , String room){
		try {
			File file = new File("Booking.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			PrintWriter file_to_write = new PrintWriter ( new BufferedWriter(new FileWriter("Booking.txt", true)));
			int i=0;
			while(i<=daysDiff) {
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		        //create instance of the Calendar class and set the date to the given date  
		        Calendar cal = Calendar.getInstance();  
		        try{  
		            cal.setTime(sdf.parse(checkInDate));  
		         }catch(ParseException e){  
		             e.printStackTrace();  
		          } 
		        // use add() method to add the days to the given date  
		        cal.add(Calendar.DAY_OF_MONTH, 0+i);   
				file_to_write.println(sdf.format(cal.getTime())+" "+room);
				i++;
			}
			
			file_to_write.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}