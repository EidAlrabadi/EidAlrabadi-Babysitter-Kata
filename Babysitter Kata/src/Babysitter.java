import java.util.Scanner;

public class Babysitter {

	public static void main(String[] args) {
		TimeAnalyzer timeAnalyzer = new TimeAnalyzer();  //Initialize the constructor
		String startTime = timeAnalyzer.getStartTimeFromUser(); // Retrieve start time from user
		String endTime = timeAnalyzer.getEndTimeFromUser();   // Retrieve end time from user
		System.out.println(startTime);
		System.out.println(endTime);
		timeAnalyzer.validateStartAndEndTime(startTime, endTime); // Input format is correct, checking if end time is after start time
	
	
		
		
	
		
		
		
	}

}

