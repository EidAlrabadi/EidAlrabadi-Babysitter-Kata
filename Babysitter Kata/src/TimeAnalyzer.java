import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeAnalyzer {
	
	
	/** This is a method that parses a user input string, and returns a boolean value
	 * to determine if the input is of proper format on the 12 hour clock
	 * 
	 * 
	 *
	 * 
	 * 
	 * 
	 * @return true if the format is legal, or false if the format is illegal.
	 */

		public boolean properTimeInputs(String time) {
		LocalTime convertedFormat;
		convertedFormat = LocalTime.parse(time, DateTimeFormatter.ofPattern("h:m a")); //Java.time format for the forced user input of the program	
		return true;
		
	}

}
