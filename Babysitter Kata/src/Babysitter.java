import java.util.Scanner;

public class Babysitter {

	public static void main(String[] args) {
		int babySitterPay = 0;
		TimeAnalyzer timeAnalyzer = new TimeAnalyzer();  //Initialize the constructor
		String startTime = timeAnalyzer.getStartTimeFromUser(); // Retrieve start time from user
		String endTime = timeAnalyzer.getEndTimeFromUser();   // Retrieve end time from user
		timeAnalyzer.validateStartAndEndTime(startTime, endTime); // Input format is correct, checking if end time is after start time
		String familyInput = WageCalculator.getFamilyFromUser();
		if(familyInput.equals("a")) {
			babySitterPay = WageCalculator.familyAWageCalculation(startTime,endTime);
		}else if(familyInput.equals('b')) {
			babySitterPay = WageCalculator.familyBWageCalculation(startTime,endTime);

		}else if(familyInput.equals('c')) {
			babySitterPay = WageCalculator.familyCWageCalculation(startTime,endTime);

		}
		
		System.out.println("Your pay for working between " + startTime + " and" + endTime + " for family " + familyInput + " is " + babySitterPay);
	
	
		
		
	
		
		
		
	}

}

