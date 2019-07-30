
/**
 * @author Himanshu Kohli
 */

/**
 * The CalculatorImplementation implements the calculator Interface
 */
public class CalculatorImplementation implements CalculatorInterface {

	/**
	 * The value of 'a' stored in aValue
	 */
	private double aValue;
	/**
	 * The value of 'a' stored in bValue
	 */
	private double bValue;
	/**
	 * The value of 'a' stored in xValue
	 */
	private double xValue;
	
	/**
	 * Backup's the last calculation in the Memento Object
	 * @return : The new object which holds the variables
	 */
	@Override
	public CareTaker backupLastCalculation() {
		// TODO Auto-generated method stub
		return new PreviousCalculationImplementation(aValue, bValue,xValue);
	}

	/**
	 * This method gets the value from stored memento and restores it
	 * @param : memento : The object which has the values stored 
	 */
	@Override
	public void restorePreviousCalculation(CareTaker memento) {
		// TODO Auto-generated method stub
		this.aValue = ((Originator)memento).getA();
		this.bValue = ((Originator)memento).getB();
		this.xValue = ((Originator)memento).getX();
	}

	/**
	 * This method calculates the result
	 * @return returns the calculated value for the function
	 */
	@Override
	public double getResult() {
		// TODO Auto-generated method stub
		Function7 function7 = new Function7();
		return function7.performCalculation(aValue, bValue, xValue);
	}
	
	/**
	 * This method is a setter for the value 'aValue'
	 * @param : Sets the value of 'aValue'
	 */
	@Override
	public void setA(double aValue) {
		// TODO Auto-generated method stub
		this.aValue = aValue;
	}


	/**
	 * This method is a setter for the value 'bValue'
	 * @param : Sets the value of 'bValue'
	 */
	@Override
	public void setB(double bValue) {
		// TODO Auto-generated method stub
		this.bValue = bValue;
	}
	

	/**
	 * This method is a setter for the value 'xValue'
	 * @param : Sets the value of 'xValue'
	 */
	@Override
	public void setX(double xValue) {
		this.xValue = xValue;
	}

}
