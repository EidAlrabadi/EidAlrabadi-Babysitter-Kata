import java.util.Scanner;

public class WageCalculator {

	public String startTime;
	public String endTime;

	public WageCalculator(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * 
	 * This method calculates the baby sitter wage if working for family A.
	 * 
	 * @return
	 */

	public static int familyAWageCalculation(String startTime, String endTime) {
		String parsingStartTime = startTime.substring(0, 2) + startTime.substring(3, 5); // parses the string to
																							// retrieve the time value
		// excluding :
		String parsingEndTime = endTime.substring(0, 2) + endTime.substring(3, 5); // input "16:53" becomes "1653" for
																					// later calculations

		int timeWorked;
		int twentyFourHours = 2400;
		int elevenPM = 2300;

		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);

		char firstCharStartTime = parsingStartTime.charAt(0);
		char firstCharEndTime = parsingEndTime.charAt(0);

		String firstTwoCharStartTime = parsingStartTime.substring(0, 2);
		String firstTwoCharEndTime = parsingEndTime.substring(0, 2);

		// if both times are between 11PM and 11 PM.
		if (firstTwoCharStartTime.equals("23") && firstTwoCharEndTime.equals("23")) { //Max you can work between is 1 hour so automatically return 20
		return 20;
		}
		
		// if both times are after 11 pm ,but include 11 pm in the calculation.
		
		else if(parseStartTimeInteger >= 2300 && firstCharEndTime == '0') {
			timeWorked = (int)Math.ceil((twentyFourHours-(parseStartTimeInteger-parseEndTimeInteger)) / 100.0);
			System.out.println(timeWorked);
			return (timeWorked * 20);      
			
		}
		

		// If both times are after 11 PM, but don't include 11 PM
		else if (firstCharStartTime == '0' && firstCharEndTime == '0') {
			timeWorked = Math.abs(parseEndTimeInteger - parseStartTimeInteger);
			double hoursWorked = Math.ceil((timeWorked) / 100.0);
			return (int) (hoursWorked) * 20; // Shift started and ended prior to 11 PM return hours worked * 20 for
												// wage.
		}

		// If both times are prior to 11 PM.
		else if (parseStartTimeInteger < elevenPM && parseEndTimeInteger < elevenPM && firstCharStartTime != '0'
				&& firstCharEndTime != '0') {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			double hoursWorked = Math.ceil((timeWorked) / 100.0);
			return (int) (hoursWorked) * 15; // Shift started and ended prior to 11 PM return hours worked * 15 for
												// wage.

		}

		// If the time starts before 11 PM and the time ends after 11 PM only left over
		// possible case.

		int startTimeWorked = elevenPM - parseStartTimeInteger;
		double startHoursWorked = Math.ceil((startTimeWorked) / 100.0);
		int startTimeWorkedTotalPay = 15 * (int) startHoursWorked; // 15 dollars prior to 11 PM.

		double endTimeWorked = Math.ceil(((twentyFourHours) - (elevenPM - parseEndTimeInteger)) / 100.0);
		int EndTimeWorkedTotalPay = 20 * (int) endTimeWorked; // 20 dollars after to 11 PM.

		return EndTimeWorkedTotalPay + startTimeWorkedTotalPay;
	}

	
	/**
	 * 
	 * This method calculates the sitters wage for family B. Function assumes inputs are proper.
	 * 
	 * 
	 */
	public static int familyBWageCalculation(String startTime, String endTime) {
		String parsingStartTime = startTime.substring(0, 2) + startTime.substring(3, 5); // parses the string to

		String parsingEndTime = endTime.substring(0, 2) + endTime.substring(3, 5); // input "16:53" becomes "1653" for

		int timeWorked;
		int tenPM = 2200;
		int twelveAM = 2400;

		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);

		char firstStartTimeChar = parsingStartTime.charAt(0);
		char firstEndTimeChar = parsingEndTime.charAt(0);

		
		if(parseStartTimeInteger < tenPM && parseEndTimeInteger > tenPM && parseEndTimeInteger < twelveAM ) {
			int netPay = 0;
			int firstIntervalHoursWorked = tenPM - parseStartTimeInteger;
			double hoursWorkedIntervalOne = Math.ceil((firstIntervalHoursWorked) / 100.0);
			netPay += hoursWorkedIntervalOne * 12;
			double hoursWorkedIntervalTwo = Math.ceil((parseEndTimeInteger - tenPM) / 100.0);
			netPay += hoursWorkedIntervalTwo * 8;
			return netPay;
			
		}

		else if (parseStartTimeInteger >= tenPM && parseEndTimeInteger <= 400) {
			int netPay = 0;
			int firstIntervalHoursWorked = twelveAM - parseStartTimeInteger;
			double hoursWorkedIntervalOne = Math.ceil((firstIntervalHoursWorked) / 100.0);
			netPay += hoursWorkedIntervalOne * 8;
			double hoursWorkedIntervalTwo = Math.ceil((parseEndTimeInteger) / 100.0);
			netPay += hoursWorkedIntervalTwo * 16;
			return netPay;

		}

		else if (parseStartTimeInteger < tenPM && firstStartTimeChar != '0' && firstEndTimeChar == '0') {
			// payment prior to 10 pm
			int netPay = 0;
			int firstIntervalHoursWorked = tenPM - parseStartTimeInteger;
			double hoursWorked = Math.ceil((firstIntervalHoursWorked) / 100.0);
			netPay += (int) hoursWorked * 12;

			// payment after 10pm but before 12 AM because it is after 12 PM that it ends we
			// can assume the full two hours
			// are reached, and so we can automatically add 16.

			netPay += 16; // 2 hours of work between 10 pm and 12 am.

			// payment after 12 am

			double thirdIntervalHoursWorked = Math.ceil((parseEndTimeInteger) / 100.0); // only remaining time is the
																						// end time.
			netPay += (int) thirdIntervalHoursWorked * 16; // 16 after end time
			return netPay;

		}

		// if start time and end time are after 12:00 AM
		else if (firstStartTimeChar == '0' && firstEndTimeChar == '0') {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			double hoursWorked = Math.ceil((timeWorked) / 100.0);
			return (int) hoursWorked * 16;
		}

		// if start time is 10 or higher, and end time is 12:00 AM or lower

		else if (parseStartTimeInteger >= tenPM && parseEndTimeInteger <= twelveAM
				|| parseStartTimeInteger >= tenPM && parseEndTimeInteger == 0) {
			// if end time is exactly 12AM
			if (parseEndTimeInteger == 0) {
				int realParseEndTimeInteger = parseEndTimeInteger + twelveAM;
				timeWorked = realParseEndTimeInteger - parseStartTimeInteger;
				double hoursWorked = Math.ceil((timeWorked) / 100.0);
				return (int) hoursWorked * 8;
				// if end time is not exactly 12 AM but is greater than 11 PM and less than 12
				// AM.
			} else {
				timeWorked = parseEndTimeInteger - parseStartTimeInteger;
				double hoursWorked = Math.ceil((timeWorked / 100.0));
				return (int) hoursWorked * 8;
			}

		}

		timeWorked = parseEndTimeInteger - parseStartTimeInteger;
		double hoursWorked = Math.ceil((timeWorked) / 100.0);
		return (int) hoursWorked * 12;

	}

	
	
	
	
	
	
	
	
	public static int familyCWageCalculation(String startTime, String endTime) {
		
		
		String parsingStartTime = startTime.substring(0, 2) + startTime.substring(3, 5); // parses the string to
																						// retrieve the time value
																						// excluding :
		String parsingEndTime = endTime.substring(0, 2) + endTime.substring(3, 5); // input "16:53" becomes "1653" for
																				  // later calculations
		
		int timeWorked;
		int twentyFourHours = 2400;
		int ninePM = 2100;

		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);

		char firstCharStartTime = parsingStartTime.charAt(0);
		char firstCharEndTime = parsingEndTime.charAt(0);

		String firstTwoCharStartTime = parsingStartTime.substring(0, 2);
		String firstTwoCharEndTime = parsingEndTime.substring(0, 2);

// if both times are between 9PM and 9PM.
		if (firstTwoCharStartTime.equals("21") && firstTwoCharEndTime.equals("21")) {
			return 21;
		}

		// if both times are after 9 pm ,but include 9 pm in the calculation.
		
				else if(parseStartTimeInteger >= 2100 && firstCharEndTime == '0') {
					timeWorked = (int)Math.ceil((twentyFourHours-(parseStartTimeInteger-parseEndTimeInteger)) / 100.0);
			 
					return (timeWorked * 15);      
					
				}
				
		// If both times are after 9
		else if (parseStartTimeInteger >= ninePM || firstCharStartTime == '0' && firstCharEndTime == '0') {
			timeWorked = Math.abs(parseEndTimeInteger - parseStartTimeInteger);
			double hoursWorked = Math.ceil((timeWorked) / 100.0);
			
			return (int) (hoursWorked) * 15;
		}

		// If both times are prior to 9 PM.
		else if (parseStartTimeInteger < ninePM && parseEndTimeInteger < ninePM && firstCharStartTime != '0'
				&& firstCharEndTime != '0') {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			double hoursWorked = Math.ceil((timeWorked) / 100.0);
		
			return (int) (hoursWorked) *21; // Shift started and ended prior to 9 PM return hours worked * 21 for
			// wage.

		}

// If the time starts before 9 PM and the time ends after 9 PM only left over
// possible case.

		int startTimeWorked = ninePM - parseStartTimeInteger;
		double startHoursWorked = Math.ceil((startTimeWorked) / 100.0);
		int startTimeWorkedTotalPay = 21 * (int) startHoursWorked; // 21 dollars prior to 9 PM.

		double endTimeWorked = Math.ceil(((twentyFourHours) - (ninePM - parseEndTimeInteger)) / 100.0);
		int EndTimeWorkedTotalPay = 15 * (int) endTimeWorked; // 15 dollars after to 9 PM.
		
		return EndTimeWorkedTotalPay + startTimeWorkedTotalPay;
	}
		
		

public static String getFamilyFromUser() {
	Scanner in = new Scanner(System.in);
	System.out.println("Which family are you working for please enter 'A', 'B', 'C''");
	String familyChar = in.nextLine();
	String familyInput = familyChar.toLowerCase();
	while(!familyInput.equals("a") && !familyInput.equals("b") && !familyInput.equals("c")) {
		System.out.println("Error please enter either family A,B,C by entering the letter");
		familyChar = in.nextLine();
		familyInput = familyChar.toLowerCase();
	}
	
	return familyInput;
}
	
	
	
	
}
	
	

	
	
	

