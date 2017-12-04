package hostelApp;

/**
 * class is used to store the details of a single payment in a hostel
 * @author Alex
 *
 */
class Payment 
{
	private String month;
	private double amount;
	
	/**constructor: sets the month and amount of the payment*/
	public Payment(String monthIn, double amountIn)
	{
		month = monthIn;
		amount = amountIn;
	}
	
	/**reads the month of payment*/
	public String getMonth()
	{
		return month;
	}
	
	/**reads the amount of payment*/
	public double getAmount()
	{
		return amount;
	}

}
