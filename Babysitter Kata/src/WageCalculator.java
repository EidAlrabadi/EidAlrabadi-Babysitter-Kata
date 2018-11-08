
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
		
		int parseStartTimeInteger = Integer.parseInt(parsingStartTime);
		int parseEndTimeInteger = Integer.parseInt(parsingEndTime);
		int timeWorked = parseEndTimeInteger - parseStartTimeInteger;
		double hoursWorked = Math.ceil(timeWorked/100.0);
		System.out.println(timeWorked/100);
		int totalPay = (int)hoursWorked * 15;

		return totalPay;
	}
	
	



}
