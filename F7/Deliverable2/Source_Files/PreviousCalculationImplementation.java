/*
 * @author Himanshu Kohli
 */

/*
 * PreviousCalulationImplementation for Memento Patter
 * Implements CareTaker and Originator
 */

public class PreviousCalculationImplementation implements CareTaker, Originator {

	/*
	 * Private Variables
	 */
	/**
	 * The value of 'a' stored in aValue
	 */
	private double aValue;

	/**
	 * The value of 'b' stored in bValue
	 */
	private double bValue;

	/**
	 * The value of 'x' stored in xValue
	 */
	private double xValue;

	/**
	 * This is the constructor of the PreviousCalculationImplementation Interface
	 * @param aValue : The value of variable a
	 * @param bValue : The value of variable b
	 * @param xValue : The value of variable x
	 */
	public PreviousCalculationImplementation(double aValue, double bValue, double xValue) {
		this.aValue = aValue;
		this.bValue = bValue;
		this.xValue = xValue;
	}

	/**
	 * This method is a getter method for 'a' value
	 */
	@Override
	public double getA() {
		// TODO Auto-generated method stub
		return aValue;
	}

	/**
	 * This method is a getter method for 'b' value
	 */
	@Override
	public double getB() {
		// TODO Auto-generated method stub
		return bValue;
	}

	/**
	 * This method is a getter method for 'x' value
	 */
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return xValue;
	}

}
