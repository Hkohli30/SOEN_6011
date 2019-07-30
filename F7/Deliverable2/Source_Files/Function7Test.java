
import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Himanshu Kohli
 *
 */

/**
 * Function7Test class tests the functions for class
 */
class Function7Test {

	Function7 function7Object;
	DecimalFormat decimalFormat;
	
	/**
	 * This method initializes the values for the Function7 and DecimalFormat Object 
	 */
	@BeforeEach
	void init() {
		function7Object = new Function7();
		decimalFormat = new DecimalFormat("#.####");
	}
	
	/**
	 * This method tests the result log values for the functions 
	 */
	@Test
	public void testForLogValue() {	
		assertEquals(decimalFormat.format(Math.log10(22)), decimalFormat.format(function7Object.calculateLog(22)));
		assertEquals(decimalFormat.format(Math.log10(300)), decimalFormat.format(function7Object.calculateLog(300)));
		assertEquals(decimalFormat.format(Math.log10(92.25)), decimalFormat.format(function7Object.calculateLog(92.25)));
		assertEquals(decimalFormat.format(Math.log10(0.234)), decimalFormat.format(function7Object.calculateLog(0.234)));
		assertEquals(decimalFormat.format(Math.log10(1)), decimalFormat.format(function7Object.calculateLog(1)));
		assertEquals(decimalFormat.format(Math.log10(Double.MAX_VALUE)), decimalFormat.format(function7Object.calculateLog(Double.MAX_VALUE)));
	}
	
	/**
	 * The function which tests the power functions for integer power values
	 */
	@Test
	public void testForPowerFunctionIntegerValues() {
		assertEquals(decimalFormat.format(function7Object.power(2,3)),decimalFormat.format(Math.pow(2, 3)));
		assertEquals(decimalFormat.format(function7Object.power(2.2,-3)),decimalFormat.format(Math.pow(2.2, -3)));
		assertEquals(decimalFormat.format(function7Object.power(2.2,3)),decimalFormat.format(Math.pow(2.2, 3)));
	}
	
	/**
	 * The function which tests the power functions for decimal power values
	 */
	@Test
	public void testForPowerFunctionDecimalValues() {
		assertEquals(decimalFormat.format(function7Object.power(2,3.3)),decimalFormat.format(Math.pow(2, 3.3)));
		assertEquals(decimalFormat.format(function7Object.power(2.2,3.3)),decimalFormat.format(Math.pow(2.2, 3.3)));
		assertEquals(decimalFormat.format(function7Object.power(-2.2,3.3)),decimalFormat.format(-Math.pow(2.2, 3.3)));
		assertEquals(decimalFormat.format(function7Object.power(2.2,-3.3)),decimalFormat.format(Math.pow(2.2, -3.3)));
		assertEquals(decimalFormat.format(function7Object.power(0,0)),decimalFormat.format(Math.pow(0, 0)));
		assertEquals(decimalFormat.format(function7Object.power(1,0)),decimalFormat.format(Math.pow(1, 0)));
		assertEquals(function7Object.power(Double.MAX_VALUE,1.0),Math.pow(Double.MAX_VALUE,1.0));
		assertEquals(function7Object.power(7,Double.MAX_VALUE),Double.MAX_VALUE); 
	}
	
	/**
	 * The function which tests the power functions for large values positive values
	 */
	@Test
	public void testForPowerFunctionLargeValues() {
		assertTrue(function7Object.power(22550, 23.4) >= Math.pow(22550, 23.4) && function7Object.power(22550, 23.4) <= Math.pow(22550, 23.5));
		assertTrue(function7Object.power(22550, -23.4) <= Math.pow(22550, -23.4) && function7Object.power(22550, -23.4) >= Math.pow(22550, -23.5));
		}
	
	/**
	 * The function which tests for a^(b^x)
	 */
	@Test
	public void testForEntireFunction() {
		double expectedBX = Math.pow(2, 3);
		double actualBX = function7Object.power(2,3); 
		assertEquals(decimalFormat.format(function7Object.power(2,actualBX)),decimalFormat.format(Math.pow(2, expectedBX)));
		assertEquals(decimalFormat.format(function7Object.power(6.6,actualBX)),decimalFormat.format(Math.pow(6.6, expectedBX)));
		assertEquals(decimalFormat.format(function7Object.power(2.7,actualBX)),decimalFormat.format(Math.pow(2.7, expectedBX)));
		
		DecimalFormat decFormat = decimalFormat = new DecimalFormat("#.##");
		expectedBX = Double.parseDouble(decFormat.format(Math.pow(2, 3.3)));
		actualBX = Double.parseDouble(decFormat.format(function7Object.power(2,3.3))); 
		assertEquals(decFormat.format(function7Object.power(-2,actualBX)),decFormat.format(-Math.pow(2, expectedBX)));
		assertEquals(decFormat.format(function7Object.power(3,actualBX)),decFormat.format(Math.pow(3, expectedBX)));
		
	}
	
	/**
	 * The function which tests the sign of the result i.e dependency on base sign
	 */
	@Test
	public void signTestingForPowerFunction() {
		assertTrue(function7Object.power(-2.2,3.3) < 0);
		assertTrue(function7Object.power(2.2,-3.3) > 0);
		assertTrue(function7Object.power(-2.2,-3.3) < 0);
	}
	
	/**
	 * The function tests for valid inputs which is real and in input domain
	 */
	@Test
	public void inputTestingForValidInputs() {
		CalculatorGUI obj = new CalculatorGUI();
		assertEquals(obj.validiateInput("2", "2", "2",false)[3],1);
		assertEquals(obj.validiateInput("200", "0.62", "2.4",false)[3],1);
		assertEquals(obj.validiateInput("1", "200", "222",false)[3],1);
		assertEquals(obj.validiateInput("0", "0", "0",false)[3],1);
	}
	

	/**
	 * The function tests for invalid inputs
	 */
	@Test
	public void inputTestingForInvalidInputs() {
		CalculatorGUI obj = new CalculatorGUI();
		assertEquals(obj.validiateInput("l", "2", "l",false)[3],0);
		assertEquals(obj.validiateInput("l", " ", " ",false)[3],0);
		assertEquals(obj.validiateInput(" ", " ", "l",false)[3],0);
	}

}
