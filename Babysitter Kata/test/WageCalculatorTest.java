import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

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
	
	
	@Test
	public void familyABefore11PMOnlyWageCalculation () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:00");  //From 5Pm to 10:59 PM
		wageCalculator.setEndTime("22:59");
		assertEquals(90,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyABefore11PMOnlyWageCalculation_2 () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("18:52");  
		wageCalculator.setEndTime("19:59");
		assertEquals(30,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	@Test
	public void familyAAfter11PMWageCalculation() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("00:00");  // from 5:00 PM to 2:59 AM
		wageCalculator.setEndTime("03:59");
		assertEquals(80,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyAAfter11PMWageCalculation_2() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("01:00");  // from 5:00 PM to 2:59 AM
		wageCalculator.setEndTime("02:43");
		assertEquals(40,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyAAfter11PMWageCalculation_3() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("23:00");  
		wageCalculator.setEndTime("23:43");
		assertEquals(20,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyAStartBefore11PMEndAfter11PM() {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("18:53");  
		wageCalculator.setEndTime("03:43");
		assertEquals(175,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	@Test
	public void familyAStartBefore11PMEndAfter11PM_2 () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("17:43");
				  
		wageCalculator.setEndTime("02:43");
		assertEquals(170,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
	
	@Test
	public void familyAStartBefore11PMEndAfter11PMStartMinutesIsLarger () {
		wageCalculator = new WageCalculator(startTime,endTime);
		wageCalculator.setStartTime("19:59");  
				  
		wageCalculator.setEndTime("03:13");  
		assertEquals(160,wageCalculator.familyAWageCalculation(wageCalculator.getStartTime(), wageCalculator.getEndTime()));
	}
	
	
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
	
	
	
	//Tear down method after all the tests are completed.
	@After
	public void tearDown() throws Exception {
	    wageCalculator = null;
	    assertNull(wageCalculator);
	}
	
}
