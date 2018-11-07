import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeAnalyzer {
	
	
	/** This is a method that parses a user input string, and returns a boolean value
	 * to determine if the input is of proper format on the 12 hour clock. The format 
	 * must look like the following #:## PM or ##:## AM where # stands for accepted values on
	 * the 12 hour clock. The input MUST include AM or PM. 
	 * 
	 *
	 * 
	 * 
	 * 
	 * @return true if the format is legal, or false if the format is illegal.
	 */

		String exactStart = "17:00";   //This is the start time 5 PM converted to military
		String exactEnd = "04:00";     // This is the end time 4 AM converted to military
		public boolean properTimeInputs(String time) {
		LocalTime convertedFormat;
		try {
		convertedFormat = LocalTime.parse(time, DateTimeFormatter.ofPattern("h:m a")); //Java.time format for the forced user input of the program
		}catch(DateTimeParseException e) {
			System.out.println("Input format is incorrect. Please try again");         //Returns false if the format is incorrect.
			return false;
		}
		
		String convertedFormatString = convertedFormat.toString();
		System.out.println(convertedFormatString);
		if(convertedFormatString.equals(exactStart) || convertedFormatString.equals(exactEnd)) {
			return true;
		}
		int leftOfColonDigit = Integer.parseInt(convertedFormatString.substring(0,2)); //Gets the value to the left of colon and transforms to int.
	    int fourAM = 4; // 4 AM
	    int fivePM = 16;  // 5 PM
		
		if(leftOfColonDigit >= fourAM && leftOfColonDigit <= fivePM) { //If Greater than 4:00 PM with exception of 4:00 PM or
																	   // less than 16 which is 5 PM military it is non working errors so false.
			System.out.println("These are non working hours, please input working hours");
			return false;
		}
		
		
		return true;   //If all test checks pass then return true.
		
	}

}
