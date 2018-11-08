import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InputAnalyzerTest {




	TimeAnalyzer timeAnalyzer;

	@Before
	public void setup()  {
		timeAnalyzer = new TimeAnalyzer();
	}
	
	@Test
	public void ProperTimeInputWithTwoDigitsToTheLeftOfColon () {
		assertEquals("00:53",timeAnalyzer.properTimeInputs("12:53 AM"));
		
	}
	
	@Test public void ProperTimeInputWithOneDigitToTheLeftOfColon () {
		assertEquals("17:53",timeAnalyzer.properTimeInputs("5:53 PM"));

	}
	
	@Test public void ProperTimeInputWithOneDigitToTheRightOfColon1() {
		//One digit to the left of colon, and two to the right
		assertEquals("01:01",timeAnalyzer.properTimeInputs("1:01 AM"));
	}
		
	@Test public void ImproperTimeWhereDigitToLeftOfColonIsIncorrect() {
		assertEquals(null,timeAnalyzer.properTimeInputs("13:43 PM"));
	}
	
	@Test public void ImproperTimeWhereDigitToTheRightOfColonIsIncorrect() {
		assertEquals(null,timeAnalyzer.properTimeInputs("12:99 PM"));
	}
	
	@Test public void ImproperTimeFormatWithSingleCharacterInput() {
		assertEquals(null,timeAnalyzer.properTimeInputs("A"));
	}
	
	@Test public void ImproperTimeFormatWithoutPMORAM() {
		assertEquals(null,timeAnalyzer.properTimeInputs("12:53 XM"));
	}
	
	@Test public void ImproperTimeFormatWithoutSpace() {
		assertEquals(null,timeAnalyzer.properTimeInputs("12:53AM"));
	}
	
	@Test public void ImproperTimeFormatEmptyString() {
		assertEquals(null,timeAnalyzer.properTimeInputs(""));
	}
	
	@Test public void ImproperTimeDuringNoneWorkingHours() {
		assertEquals(null,timeAnalyzer.properTimeInputs("4:59 PM"));
	}
	
	
	@Test public void ImproperTimeDuringNoneWorkingHours2() {
		assertEquals(null,timeAnalyzer.properTimeInputs("4:59 AM"));
	}
	
	@Test public void ImproperTimeDuringNoneWorkingHours3() {
		assertEquals(null,timeAnalyzer.properTimeInputs("5:59 AM"));
	}
	
	@Test public void ImproperTimeDuringNoneWorkingHours4() {
		assertEquals(null,timeAnalyzer.properTimeInputs("1:59 PM"));
	}
	
	@Test public void ImproperTimeDuringNoneWorkingHours5() {
		assertEquals(null,timeAnalyzer.properTimeInputs("12:05 PM"));
	}
	
	@Test public void ImproperTimeDuringNoneWorkingHoursExactStart() {
		assertEquals("17:00",timeAnalyzer.properTimeInputs("5:00 PM"));

	}
	
	@Test public void ImproperTimeDuringNoneWorkingHoursExactEnd() {
		assertEquals("04:00",timeAnalyzer.properTimeInputs("4:00 AM"));

	}
	
	
	
	
	@Test public void ProperStartTimeAndEndTime1() {
		String startTime = "17:00";
		String endTime = "21:00";
		assertEquals(true,timeAnalyzer.timeChecker(startTime, endTime));
	}
	
	@Test public void ProperStartTimeAndEndTime2() {
		String startTime = "17:00";
		String endTime = "01:00";
		assertEquals(true,timeAnalyzer.timeChecker(startTime, endTime));
	}
	
	
	
	
	
	
	

}
