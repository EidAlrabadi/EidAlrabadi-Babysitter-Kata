package BabySitterMethods;
import java.util.Scanner;

public class Babysitter {

	public static void main(String[] args) {
		int babySitterPay = 0;
		TimeAnalyzer timeAnalyzer = new TimeAnalyzer();  //Initialize the constructor
		String startTime = timeAnalyzer.getStartTimeFromUser(); // Retrieve start time from user
		System.out.println();
		String endTime = timeAnalyzer.getEndTimeFromUser();   // Retrieve end time from user
		System.out.println();
		timeAnalyzer.validateStartAndEndTime(startTime, endTime); // Input format is correct, checking if end time is after start time
		String familyInput = WageCalculator.getFamilyFromUser();  // Decides which family the user has entered
		if(familyInput.equals("a")) { //if family A do wage A calculation
			babySitterPay = WageCalculator.familyAWageCalculation(startTime,endTime);
		}else if(familyInput.equals("b")) { //if family B do wage B calculation
			babySitterPay = WageCalculator.familyBWageCalculation(startTime,endTime);

		}else if(familyInput.equals("c")) {  //if family C do wage C calculation
			babySitterPay = WageCalculator.familyCWageCalculation(startTime,endTime);

		}
		System.out.println();
		System.out.println("Your pay for working between " + TimeAnalyzer.getUserStartTime() + " and " + TimeAnalyzer.getUserEndTime() + " for family " + familyInput.toUpperCase() + " is " + "$" + babySitterPay);
	
	
		
		
	
		
		
		
	}

}

