
/**
 * @author Himanshu Kohli
 */

/**
 * CalculatorInterface for Memento Pattern
 */
interface CalculatorInterface {

	/**
	 * This method is a skeleton method for backing up the calculation
	 * @return : Returns the CareTaker object
	 */
	public CareTaker backupLastCalculation();

	/**
	 * This method is a skeleton method for restoring previous calculation
	 * @param memento
	 */
	public void restorePreviousCalculation(CareTaker memento);

	/**
	 * This method is skeleton method for calculating the result
	 * @return The implementation will return the result
	 */
	public double getResult();
	

	/**
	 * This method is a skeleton method for setting the value of 'a'
	 * @param aValue : The value to be set to 'a'
	 */
	public void setA(double aValue);

	/**
	 * This method is a skeleton method for setting the value of 'b'
	 * @param bValue : The value to be set to 'b'
	 */
	public void setB(double bValue);

	/**
	 * This method is a skeleton method for setting the value of 'x'
	 * @param xValue : The value to be set to 'x'
	 */
	public void setX(double xValue);

}
