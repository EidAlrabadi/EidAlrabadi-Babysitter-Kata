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

		public boolean properTimeInputs(String time) {
		LocalTime convertedFormat;
		try {
		convertedFormat = LocalTime.parse(time, DateTimeFormatter.ofPattern("h:m a")); //Java.time format for the forced user input of the program
		}catch(DateTimeParseException e) {
			System.out.println("Input format is incorrect. Please try again");         //Returns false if the format is incorrect.
			return false;
		}
		return true;
		
	}

}
