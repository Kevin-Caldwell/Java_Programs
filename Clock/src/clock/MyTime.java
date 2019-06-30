package clock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyTime {
	
	public double hours = 0;
	public int minutes = 0;
	public int seconds = 0;
	
	public Calendar cal;
	public Date date;
	public String strDateFormat;
	public DateFormat dateFormat;
	public String formattedDate;
	
	
	public MyTime() {
		cal = Calendar.getInstance();
	    date = new Date();

	    strDateFormat = "hh:mm:ss a";
	}

	public void getCurrentTime() {
	    dateFormat = new SimpleDateFormat(strDateFormat);

	    formattedDate = dateFormat.format(date);
	    
		System.out.println("Current time: " + formattedDate);
		
		hours = Integer.parseInt(formattedDate.substring(0, 2))*30;
		minutes = Integer.parseInt(formattedDate.substring(3, 5))*6;
		seconds = Integer.parseInt(formattedDate.substring(6, 8))*6;
	}

	public void addOneSecond() {
		
		seconds+=6;
		
		if(seconds >= 360) {
			seconds-=360;
			minutes+=6;
		}
		
		if(minutes >= 360) {
			minutes-=360;
			hours+=30;
		}
		
		if(seconds%180 == 0) {
			hours+=3;
		}
		
	}
}
