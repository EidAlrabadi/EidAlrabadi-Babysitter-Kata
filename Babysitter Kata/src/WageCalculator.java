
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


	
	public int familyAWageCalculation(String startTime, String endTime) {
		String parsingStartTime = startTime.substring(0,2) + startTime.substring(3,5); //parses the string to retrieve the time value excluding :
		String parsingEndTime =  endTime.substring(0,2) + endTime.substring(3,5);     // input "16:53" becomes "1653" for later calculations
		
		int timeWorked;
		int twentyFourHours = 2400;
		int elevenPM = 2300;
		
		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);
		
		char firstCharStartTime = parsingStartTime.charAt(0);
		char firstStartEndTime = parsingEndTime.charAt(0);
		
		
		
		//If both times are prior to 11 PM.
		
		
		
		//If both times are after 11 PM.
		
		 if(firstCharStartTime == '0' && firstCharStartTime == '0') {
			timeWorked = Math.abs(parseEndTimeInteger - parseStartTimeInteger);
			double hoursWorked = Math.ceil((timeWorked)/100.0);
			System.out.println(hoursWorked);
			return (int)(hoursWorked) * 20; // Shift started and ended prior to 11 PM return hours worked * 15 for wage.
		}
		
		 else if(parseStartTimeInteger < elevenPM && parseEndTimeInteger < elevenPM ) {
			timeWorked = parseEndTimeInteger - parseStartTimeInteger;
			double hoursWorked = Math.ceil((timeWorked)/100.0);
			return (int)(hoursWorked) * 15; // Shift started and ended prior to 11 PM return hours worked * 15 for wage.
		}
		
		
		
		
		timeWorked = Math.abs(parseEndTimeInteger - parseStartTimeInteger);
		System.out.println("Time worked: " + timeWorked);
		double hoursWorked = Math.ceil((twentyFourHours - timeWorked)/100.0);
		System.out.println("Hours worked: " + hoursWorked);
		int totalPay = (int)hoursWorked * 15;
		System.out.println();

		return totalPay;
	}
	
	



}
