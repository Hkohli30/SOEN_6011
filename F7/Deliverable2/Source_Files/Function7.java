
import java.text.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Himanshu Kohli
 */

/**
 * 
 * Function7 class is the main logic class which calculates the value 
 * of a^(b^x)
 */
public class Function7 {
	
	/*
	 * This method takes input for the values and perform the a^(b^x) operation
	 * This method works on command line
	 */
	public void execute() {
		double a = 0, b = 0, x = 0;
		a = inputABX(a, "a");
		b = inputABX(b, "b");
		x = inputABX(x, "x");

		performCalculation(a,b,x);
	}
	
	/**
	 * This method call the necessary methods to perform the calculations
	 * @param a : The value of 'a'
	 * @param b : The value of 'b'
	 * @param x : The value of 'x'
	 * @return : The final result of the calculation
	 */
	public double performCalculation(double a, double b, double x) {
		double firstResult = 0.0, finalResult = 0.0;
		firstResult = power(b, x);
		finalResult = power(a, firstResult);
		return finalResult;
	}
	
	
	/**
	 * This method determines if the exponential is decimal of integer
	 * and calls the necessary calculation method
	 * @param base : The base value
	 * @param exp : The exponent value
	 * @return : The calculated Result
	 */
	public double power(double base, double exp) {
		if (exp % 1 == 0)
			return calculatePowerInteger(base, exp);
		else
			return calculatePowerDecimals(base, exp);
	}

	/**
	 * This method calculates the value if the exponent is integer 
	 * @param base : The base value
	 * @param exp : The exponent value
	 * @return The result
	 */
	public double calculatePowerInteger(double base, double exp) {

		if(exp == 0)
			return 1;
		else if (exp == 1)
			return base;
		
		if(base == 1 || base == -1)
			return base;
		
		boolean negBaseFlag = false;
		if(base < 0) {
			negBaseFlag = true;
			base = base * -1;
		}
	
		double result = 1;
		if (exp < 0) {
			exp = -exp;
			for (int i = 0; i < exp; i++) {
				result /= base;
				if(result <= Double.MIN_VALUE)
					return -Double.MAX_VALUE;
			}
		} else {
			for (int i = 0; i < exp; i++) {
				result *= base;
				if (result >= Double.MAX_VALUE ) {
					if(negBaseFlag)
						return -Double.MAX_VALUE;
					else
						return Double.MAX_VALUE;
				}

			}
		}
		
		if(negBaseFlag)
			result = (-1) * result;
		return result;
	}

	/**
	 * This method prints the welcome message for CommandLine Interface
	 */
	public void welcomeMessage() {
		System.out.println("Welcome To a^(b^x) function calculator");
		System.out.println("The Function Domain is set of Real Numbers where a and b are"
				+ "real constants and x is a real variable \n");

	}

	/**
	 * This method takes input for values and checks exceptions
	 * @param value : The input for a particular value such as 'a' or 'b' or 'x'
	 * @param name : Name of the variable for specification
	 * @return : returns the new value for variable
	 */
	public double inputABX(double value, String name) {
		System.out.print("Please Enter the values of " + name + " : ");
		Scanner scanner = new Scanner(System.in);
		try {
			value = Double.parseDouble(scanner.next());
			System.out.println("The input value " + value + " is accepted");
		} catch (InputMismatchException e) {
			System.out.println("Please Enter any real value");
			value = inputABX(value, name);
		} catch (NumberFormatException e) {
			System.out.println("Please Enter a valid value");
			value = inputABX(value, name);
		}
		return value;
	}

	/**
	 * This method calculates the value if the exponent is decimals (2.3) 
	 * @param base : The base value
	 * @param exp : The exponent value
	 * @return The result
	 */
	public double calculatePowerDecimals(double base, double exp) {
		// Determines the sign of the result
		boolean signDetermineFlag = false;
		boolean expSignNegativeFlag = false;
		double result = 0;

		// No log negative values so make base positive and store sign
		if (base < 0) {
			base = base * (-1);
			signDetermineFlag = true;
		} else if (base == 0) // Return 0 if base is 0 (anything pow 0 is 0)
			return 0;
		double logE = calculateLog(base) / calculateLog(2.718281828); // ln x = log x / log e

		// Determine the Taylor series
		if (exp >= 0) {
			exp *= logE;
		} else {
			exp *= -logE;
			expSignNegativeFlag = true;
		}
		
		result = calculateTaylorResult(exp, result, expSignNegativeFlag);

		if (result == Double.MAX_VALUE)
			return Double.MAX_VALUE;
		if (signDetermineFlag == true)
			return -result;
		else
			return result;
	}

	/**
	 *  This method calculates the Taylor series of the function
	 * @param exp : The exponent value 
	 * @param result : The result variable to return the value
	 * @param flag : The flag which stores the sign
	 * @return : The result of taylor series
	 */
	public double calculateTaylorResult(double exp, double result, boolean flag) {
		double tempValue = 1;
		double i = 1;
		while (tempValue > 0) {
			result += tempValue;
			tempValue *= exp;
			tempValue /= i;
			i = i + 1;
			if (result >= Double.MAX_VALUE)
				return Double.MAX_VALUE;
		}
		if (flag)
			return 1 / result;
		else
			return result;
	}

	/**
	 * This method calculates the log value of any value
	 * @param exp : The value for which log is needed
	 * @return : The result of the log value 
	 */
	public double calculateLog(double exp) {
		if (exp == 1)
			return 0;
		if (exp == 10)
			return 1;
		final double ln_10 = 2.302585092994046;
		double beforeDecimal = 0;
		double afterDecimal;
		double result = 0;
		double tempVal = 1;

		// calculate the before decimal value
		while (exp > 1) {
			exp /= 10.0;
			beforeDecimal++;
		}
		afterDecimal = (exp - 1) / (exp + 1);
		tempVal = afterDecimal;
		for (int i = 0; i < 50; i++) {
			result = result + (tempVal / (2 * i + 1));
			tempVal = tempVal * afterDecimal * afterDecimal;
		}
		result = result * 2;
		double finalResult = beforeDecimal + result / ln_10;
		return finalResult;
	}

}
