package BabySitterTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import BabySitterMethods.WageCalculator;

class WageCalculatorTest {

	WageCalculator wageCalculator;
	private String startTime;
	private String endTime;
	@Before
	public void setup()  {
		wageCalculator = new WageCalculator(startTime,endTime);	
		
	}
	//Since only proper inputs will get to this point, I will only test proper inputs since that is the only
	// possible scenario that will occur, due to the error catching of the previous methods.
	
	// Family A test cases
	@Test
	public void familyABefore11PMOnlyWageCalculation () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:00");  //From 5:00 PM to 10:59 PM
		wageCalculator.setEndTime("22:59");
		assertEquals(90,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyABefore11PMOnlyWageCalculation_2 () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("18:52");  //From 6:52 PM to 7:59 PM
		wageCalculator.setEndTime("19:59");
		assertEquals(30,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyABefore11PMOnlyWageCalculation_3 () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("18:30");  //From 6:30 PM to 11:00 pm
		wageCalculator.setEndTime("23:00");
		assertEquals(75,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	@Test
	public void familyAAfter11PMWageCalculation() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("00:00");  // from 12 AM to 3:59 AM
		wageCalculator.setEndTime("03:59");
		assertEquals(80,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyAAfter11PMWageCalculation_2() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("01:00");  // from 1 AM to 2:43 AM
		wageCalculator.setEndTime("02:43");
		assertEquals(40,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyAAfter11PMWageCalculation_3() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("23:00");  //From 11 PM to 11:43 PM
		wageCalculator.setEndTime("23:43");
		assertEquals(20,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyAAfter11PMWageCalculation_4() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("23:15");   //From 11:15 PM to 2:15 AM
		wageCalculator.setEndTime("02:15");
		assertEquals(60,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
		
		
	}
	
	@Test
	public void familyCAfter9PMWageCalculation_5() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("23:00");  // 9 PM to 9:43 PM
		wageCalculator.setEndTime("23:43");
		assertEquals(15,wageCalculator.familyCWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyAAfter9PMWageCalculation_5() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("00:00");  // from 12 AM to 3:59 AM
		wageCalculator.setEndTime("03:59");
		assertEquals(80,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	@Test
	public void familyAStartBefore11PMEndAfter11PM() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("18:53"); //From 6:53 PM to 3:43 AM
		wageCalculator.setEndTime("03:43");
		assertEquals(175,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyAStartBefore11PMEndAfter11PM_2 () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:43"); //From 5:43 PM to 2:43 AM
				  
		wageCalculator.setEndTime("02:43");
		assertEquals(170,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	
	@Test
	public void familyAStartBefore11PMEndAfter11PMStartMinutesIsLarger () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("19:59");  //From 7:59 PM to 3:13 AM
				  
		wageCalculator.setEndTime("03:13");  
		assertEquals(160,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	//Family B test cases
	
	@Test void familyBStartTimeBefore10PMEndTimeBefore10PM() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:30");    //5:30 pm
		wageCalculator.setEndTime("21:35");    //9:35 PM 
												 // 4 hours and 5 minutes have elapsed.
		assertEquals(60,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test void familyBStartTimeBefore10PMEndTimeBefore10PM_2() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:30");    //5:30 PM
		wageCalculator.setEndTime("19:30");      //7:30 PM 
												 // 2 hours have elapsed.
		assertEquals(24,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test void familyBStartTimeBefore10PMEndTimeBefore10PM_3() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:30");    //5:30 PM
		wageCalculator.setEndTime("22:00");      //10:00 PM 
												
		assertEquals(60,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	@Test void familyBStartTimeAfter10PMEndTimeBefore12AM() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("22:00");    //10 PM
		wageCalculator.setEndTime("00:00");      //12 AM 
												 // 2 hours have elapsed.
		assertEquals(16,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test void familyBStartTimeAfter10PMEndTimeBefore12AM_2() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("23:15");    //11:15 PM
		wageCalculator.setEndTime("23:59");      //11:59 AM 
												 //44 minutes have elapsed.
		assertEquals(8,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	@Test void familyBStartTimeAfter10PMEndTimeBefore12AM_3() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("22:15");    //10:15 PM
		wageCalculator.setEndTime("23:55");      //11:55 AM 
												 // 1 hour 40 minutes elapsed
		assertEquals(16,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test void familyBStartTimeAfter12AMAndEndTimeAfter12AM() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("00:05");    //12:05 AM
		wageCalculator.setEndTime("03:55");      //03:55 AM 
												 //3 hours 50 minutes elapsed.
		assertEquals(64,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test void familyBStartTimeAfter12AMAndEndTimeAfter12AM_2() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("01:05");    //01:05 AM
		wageCalculator.setEndTime("02:37");      //02:37 AM 
												 //1 hour 32 minutes elapsed.
		assertEquals(32,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	@Test void familyBStartTimeAfter12AMAndEndTimeAfter12AM_3() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("00:00");    //12:00 AM
		wageCalculator.setEndTime("04:00");      //04:00 AM 
												 //4 hour elapsed.
		assertEquals(64,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	// these are the test cases that will span all 3 different pay intervals.
	@Test void familyBAllThreeDifferentIntervals() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:05");    //5:05 PM
		wageCalculator.setEndTime("02:30");      //02:30 AM 
												 //9 hours 15 minutes elapsed.
		assertEquals(124,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	@Test void familyBAllThreeDifferentIntervals_2() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("19:55");    //7:55 PM
		wageCalculator.setEndTime("03:59");      //03:59 AM 
												 
		assertEquals(116,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	// these are the test cases that will span 2 different intervals. After 10PM
	
	@Test void familyBTwoDifferentIntervals() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("22:30");    //10:30 PM
		wageCalculator.setEndTime("02:30");      //02:30 AM 
												 //4 hours elapsed
												
		assertEquals(64,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	@Test void familyBTwoDifferentIntervals_2() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("23:15");    //11:15 PM
		wageCalculator.setEndTime("03:45");      //03:45 AM 
												
												
		assertEquals(72,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test void familyBTwoDifferentIntervals_3() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("23:59");    //11:59 PM
		wageCalculator.setEndTime("01:59");      //1:59 AM 
											
												
		assertEquals(40,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	//The following test cases are of intervals >= 5PM but <= 12 AM
	
	@Test void familyBTwoDifferentIntervals_4() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:30");    //5:30 PM
		wageCalculator.setEndTime("23:30");      //11:30 PM 
												
												
		assertEquals(76,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test void familyBTwoDifferentIntervals_5() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:00");    //5:00 PM
		wageCalculator.setEndTime("00:00");      //12:00 AM 
		
												
												
		assertEquals(76,wageCalculator.familyBWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	//Family C test cases. Since C and A are the same calculation with minor differences in the variable values.
	// test cases are the same, but adjusted for the different times.
	
	
	@Test
	public void familyCBefore9PMOnlyWageCalculation () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:00");  //From 5Pm to 8:30 
		wageCalculator.setEndTime("20:30");	   //3 hours 30 minutes elapsed
		assertEquals(84,wageCalculator.familyCWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyCBefore9PMOnlyWageCalculation_2 () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("18:50"); // 6:50 PM to 7:59 PM 1 hour and 9 minutes elapsed  
		wageCalculator.setEndTime("19:59");
		assertEquals(42,wageCalculator.familyCWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	@Test
	public void familyCAfter9PMWageCalculation() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("00:00");  // from 12 AM to 3:59 AM 3 hours 59 minutes elapsed.
		wageCalculator.setEndTime("03:59");
		assertEquals(60,wageCalculator.familyCWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyCAfter9PMWageCalculation_2() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("21:30");  // from 9:30 PM to 2:43 AM
		wageCalculator.setEndTime("02:43");
		assertEquals(90,wageCalculator.familyCWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyCAfter9PMWageCalculation_3() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("21:00");  // 9 PM to 9:43 PM
		wageCalculator.setEndTime("21:43");
		assertEquals(15,wageCalculator.familyCWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyCStartBefore9PMEndAfter9PM() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("18:53");    //6:53 PM to 3:43 AM   
		wageCalculator.setEndTime("03:43");
		assertEquals(168,wageCalculator.familyCWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyCStartBefore9PMEndAfter9PM_2 () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:43"); //From 5:43 PM to 2:43 AM
				  
		wageCalculator.setEndTime("02:43");
		assertEquals(174,wageCalculator.familyCWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	
	@Test
	public void familyCStartBefore9PMEndAfter9PMStartMinutesIsLarger () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:59");  //From 5:59 PM to 12:05 AM
				  
		wageCalculator.setEndTime("00:05");  
		assertEquals(144,wageCalculator.familyCWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	
	
	//Tear down method after all the tests are completed.
	@After
	public void tearDown() throws Exception {
	    wageCalculator = null;
	    assertNull(wageCalculator);
	}
	
}
