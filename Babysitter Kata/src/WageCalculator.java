
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
	
		double endTimeWorked = Math.ceil(((twentyFourHours) - (elevenPM - parseEndTimeInteger)) / 100.0);
		int EndTimeWorkedTotalPay = 20 * (int) endTimeWorked; // 20 dollars after to 11 PM.
		
		return EndTimeWorkedTotalPay + startTimeWorkedTotalPay;
	}
	
	
	
	
	
	
	public int familyBWageCalculation(String startTime, String endTime) {
		String parsingStartTime = startTime.substring(0, 2) + startTime.substring(3, 5); // parses the string to
		 
 
		String parsingEndTime = endTime.substring(0, 2) + endTime.substring(3, 5); // input "16:53" becomes "1653" for

		int timeWorked;
		int tenPM = 2200;
		int twelveAM = 2400;

		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);

		

		char firstStartTimeChar = parsingStartTime.charAt(0);
		char firstEndTimeChar = parsingEndTime.charAt(0);
		
		//Time span across all 3 different pay intervals.
		
		if(parseStartTimeInteger < tenPM && firstStartTimeChar != '0' &&firstEndTimeChar == '0') {
			//payment prior to 10 pm
			int netPay = 0;
			int firstIntervalHoursWorked = tenPM - parseStartTimeInteger;
			double hoursWorked = Math.ceil((firstIntervalHoursWorked) / 100.0);
			netPay += (int)hoursWorked * 12;
			
			//payment after 10pm but before 12 AM because it is after 12 PM that it ends we can assume the full two hours
			// are reached, and so we can automatically add 16.
			
			netPay += 16;             //2 hours of work between 10 pm and 12 am.
			
			//payment after 12 am
		
			double thirdIntervalHoursWorked = Math.ceil((parseEndTimeInteger)/100.0);  //only remaining time is the end time.
			netPay += (int)thirdIntervalHoursWorked * 16;							   // 16 after end time
			return netPay;
			
			
		}
		
		// if start time and end time are after 12:00 AM
		else if(firstStartTimeChar == '0' && firstEndTimeChar == '0') {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			double hoursWorked = Math.ceil((timeWorked) / 100.0);
			return (int)hoursWorked * 16;
		}
		
		
		//if start time is 10 or higher, and end time is 12:00 AM or lower
		
		if(parseStartTimeInteger >= tenPM && parseEndTimeInteger <= twelveAM || parseStartTimeInteger >= tenPM && parseEndTimeInteger == 0) {
			//if end time is exactly 12AM
			if(parseEndTimeInteger == 0) {
			int realParseEndTimeInteger = parseEndTimeInteger + twelveAM;
			timeWorked = realParseEndTimeInteger - parseStartTimeInteger;
			double hoursWorked = Math.ceil((timeWorked) / 100.0);
			return (int)hoursWorked * 8;
			//if end time is not exactly 12 AM but is greater than 11 PM and less than 12 AM.
			}else {
				timeWorked = parseEndTimeInteger - parseStartTimeInteger;
				double hoursWorked = Math.ceil((timeWorked / 100.0));
				return (int)hoursWorked * 8;
			}
			
			
		}
		
		
		//Start before 10 PM and end before 10 PM
		else if(parseEndTimeInteger < tenPM) {
			
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			double hoursWorked = Math.ceil((timeWorked) / 100.0);
			return (int)hoursWorked * 12;
		}
		
		
		return 0;
		
		

	}
	
	
	
	
	
	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


