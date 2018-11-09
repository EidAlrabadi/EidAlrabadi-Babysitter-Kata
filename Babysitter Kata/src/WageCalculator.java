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
		String parsingEndTime = endTime.substring(0, 2) + endTime.substring(3, 5); // input "16:53" becomes "1653" for																			// later calculations
		int timeWorked;
		int elevenPM = 2300;

		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);



		//if times are after midnight I added 2400 to keep the theme of them being "greater" than 12 AM
		// for calculations.
		if(parseStartTimeInteger <= 400) {
			parseStartTimeInteger += 2400;
		}
		
		if(parseEndTimeInteger <= 400) {
			parseEndTimeInteger += 2400;	}
		
		//shift ends prior to 11 PM
		if(parseEndTimeInteger <= elevenPM) {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			return 15 * (int)Math.ceil(timeWorked/100.0);
			
			
		//shift starts after 11 PM
		}else if(parseStartTimeInteger >= elevenPM) {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			return 20 * (int)Math.ceil(timeWorked/100.0);
		}
		
		//shift starts before 11 PM and ends after 11 PM
		int netPay = 0;
		timeWorked = elevenPM - parseStartTimeInteger;
		netPay += 15 * (int)(Math.ceil(timeWorked/100.0));
		
		timeWorked = parseEndTimeInteger- elevenPM;
		netPay += 20 * (int)(Math.ceil(timeWorked/100.0));
		
		
		
		
		

		return netPay;
		
	}

	
	/**
	 * 
	 * This method calculates the sitters wage for family B. Function assumes inputs are proper.
	 * 
	 * 
	 */
	public static int familyBWageCalculation(String startTime, String endTime) {
		
		String parsingStartTime = startTime.substring(0, 2) + startTime.substring(3, 5); // parses the string to
		// retrieve the time value
		// excluding :
		String parsingEndTime = endTime.substring(0, 2) + endTime.substring(3, 5); // input "16:53" becomes "1653" for																			// later calculations
		int timeWorked;
		int tenPM = 2200;
		int twelveAM = 2400;
		int netPay = 0;
		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);



		//if times are after midnight I added 2400 to keep the theme of them being "greater" than 12 AM
		// for calculations.
	if(parseStartTimeInteger <= 400) {
		parseStartTimeInteger += 2400;
	}

	if(parseEndTimeInteger <= 400) {
		parseEndTimeInteger += 2400;	
	
	}
	
	//starts before 10 PM and ends before 10 PM
	
	if(parseEndTimeInteger <= tenPM) {
		timeWorked = parseEndTimeInteger - parseStartTimeInteger;
		return 12 * (int)Math.ceil(timeWorked/100.0);

	// between 10 PM and 12 AM
	}else if(parseStartTimeInteger >= tenPM && parseEndTimeInteger <= twelveAM) {
		timeWorked = parseEndTimeInteger - parseStartTimeInteger;
		return 8 * (int)Math.ceil(timeWorked/100.0);
	//both times after 12 AM
	}else if(parseStartTimeInteger >= twelveAM && parseEndTimeInteger >= twelveAM) {
		timeWorked = parseEndTimeInteger - parseStartTimeInteger;
		return 16 * (int)Math.ceil(timeWorked/100.0);
	//spans all 3 intervals
	}else if(parseStartTimeInteger < tenPM && parseEndTimeInteger > twelveAM ) {
		timeWorked = tenPM - parseStartTimeInteger;
		netPay += 12 * (int)Math.ceil(timeWorked/100.0);
		netPay += 16;  // Since we know the end time is >= 10 PM we can assume full pay for 10 PM to 12 AM.
	    timeWorked = parseEndTimeInteger - twelveAM;
	    netPay += 16 * (int)Math.ceil(timeWorked/100.0);
	    return netPay;
	    
	  //starts before 10 PM and ends before 12 AM
		
	}else if(parseStartTimeInteger < tenPM && parseEndTimeInteger <= twelveAM) {
		timeWorked = tenPM - parseStartTimeInteger;
		netPay += 12 * (int)Math.ceil(timeWorked/100.0);
		timeWorked = parseEndTimeInteger - tenPM;
		netPay += 8 * (int)Math.ceil(timeWorked/100.0);
		return netPay;
		
	}
	
	//starts after 10 PM and ends after 12 AM
	 timeWorked = twelveAM - parseStartTimeInteger;
	 netPay += 8 * (int)Math.ceil(timeWorked/100.0);
	 timeWorked = parseEndTimeInteger - twelveAM;
	 netPay += 16 * (int)Math.ceil(timeWorked/100.0);
	return netPay;
	
	
	
	
	
	}

	
	
	
	
	
	
	
	
	public static int familyCWageCalculation(String startTime, String endTime) {
		
		String parsingStartTime = startTime.substring(0, 2) + startTime.substring(3, 5); // parses the string to
		// retrieve the time value
// excluding :
		String parsingEndTime = endTime.substring(0, 2) + endTime.substring(3, 5); // input "16:53" becomes "1653" for																			// later calculations
		int timeWorked;
		int ninePM = 2100;

		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);



		//if times are after midnight I added 2400 to keep the theme of them being "greater" than 12 AM
		// for calculations.
		if(parseStartTimeInteger <= 400) {
			parseStartTimeInteger += 2400;
		}

		if(parseEndTimeInteger <= 400) {
			parseEndTimeInteger += 2400;	
			}

		//shift ends prior to 11 PM
		if(parseEndTimeInteger <= ninePM) {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			return 21 * (int)Math.ceil(timeWorked/100.0);


			//shift starts after 11 PM
		}else if(parseStartTimeInteger >= ninePM) {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			return 15 * (int)Math.ceil(timeWorked/100.0);
		}

		//shift starts before 11 PM and ends after 11 PM
		int netPay = 0;
		timeWorked = ninePM - parseStartTimeInteger;
		netPay += 21 * (int)(Math.ceil(timeWorked/100.0));

		timeWorked = parseEndTimeInteger- ninePM;
		netPay += 15 * (int)(Math.ceil(timeWorked/100.0));






return netPay;

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
	
	

	
	
	

