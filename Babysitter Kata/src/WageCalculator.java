
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

	public int familyAWageCalculation(String startTime, String endTime) {
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

		
		//if both times are between 11PM and 11 PM.
		if (firstTwoCharStartTime.equals("23") && firstTwoCharEndTime.equals("23")) {
			timeWorked = Math.abs(parseEndTimeInteger - parseStartTimeInteger);
			double hoursWorked = Math.ceil((timeWorked) / 100.0);

			return (int) (hoursWorked) * 20; // Shift started and ended prior to 11 PM return hours worked * 20 for
												// wage.
		}
		
		

		// If both times are after 11 PM.
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
		System.out.println(startTimeWorkedTotalPay);
		double endTimeWorked = Math.ceil(((twentyFourHours) - (elevenPM - parseEndTimeInteger)) / 100.0);
		int EndTimeWorkedTotalPay = 20 * (int) endTimeWorked; // 20 dollars after to 11 PM.
		System.out.println(EndTimeWorkedTotalPay);
		return EndTimeWorkedTotalPay + startTimeWorkedTotalPay;
	}
	
	
	
	
	
	
	public int familyBWageCalculation(String startTime, String endTime) {
		String parsingStartTime = startTime.substring(0, 2) + startTime.substring(3, 5); // parses the string to
		 
 
		String parsingEndTime = endTime.substring(0, 2) + endTime.substring(3, 5); // input "16:53" becomes "1653" for

		int timeWorked;
		int twentyFourHours = 2400;
		int tenPM = 2200;

		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);

		char firstCharStartTime = parsingStartTime.charAt(0);
		char firstCharEndTime = parsingEndTime.charAt(0);

		String firstTwoCharStartTime = parsingStartTime.substring(0, 2);
		String firstTwoCharEndTime = parsingEndTime.substring(0, 2);
		
		
		
		//Start before 10 PM and end before 10 PM
		if(parseEndTimeInteger < tenPM) {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			double hoursWorked = Math.ceil((timeWorked) / 100.0);
			return (int)hoursWorked * 12;
		}
		
		
		return 0;
		
		

	}
	
	
	
	
	
	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


