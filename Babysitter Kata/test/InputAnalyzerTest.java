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
		assertEquals(true,timeAnalyzer.properTimeInputs("12:53 AM"));
		
	}
	
	@Test public void ProperTimeInputWithOneDigitToTheLeftOfColon () {
		assertEquals(true,timeAnalyzer.properTimeInputs("5:53 PM"));

	}
	
	@Test public void ProperTimeInputWithOneDigitToTheRightOfColon1() {
		//One digit to the left of colon, and two to the right
		assertEquals(true,timeAnalyzer.properTimeInputs("1:01 AM"));
	}
		
	@Test public void ImproperTimeWhereDigitToLeftOfColonIsIncorrect() {
		assertEquals(false,timeAnalyzer.properTimeInputs("13:43 PM"));
	}
	
	@Test public void ImproperTimeWhereDigitToTheRightOfColonIsIncorrect() {
		assertEquals(false,timeAnalyzer.properTimeInputs("12:99 PM"));
	}
	
	@Test public void ImproperTimeFormatWithSingleCharacterInput() {
		assertEquals(false,timeAnalyzer.properTimeInputs("A"));
	}
	
	@Test public void ImproperTimeFormatWithoutPMORAM() {
		assertEquals(false,timeAnalyzer.properTimeInputs("12:53 XM"));
	}
	
	@Test public void ImproperTimeFormatWithoutSpace() {
		assertEquals(false,timeAnalyzer.properTimeInputs("12:53AM"));
	}
	
	@Test public void ImproperTimeFormatEmptyString() {
		assertEquals(false,timeAnalyzer.properTimeInputs(""));
	}
	
	@Test public void ImproperTimeDuringNoneWorkingHours() {
		assertEquals(false,timeAnalyzer.properTimeInputs("4:59 PM"));
	}
	
	
	
	
	
	
	
	
	

}
