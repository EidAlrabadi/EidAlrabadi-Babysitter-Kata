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
		assertEquals(true,timeAnalyzer.properTimeInputs("1:53 AM"));

	}
	
	@Test public void ProperTimeInputWithOneDigitToTheRightOfColon() {
		assertEquals(true,timeAnalyzer.properTimeInputs("1:01 AM"));
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
