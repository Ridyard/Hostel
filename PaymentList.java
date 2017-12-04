package hostelApp;

/**collection class to hold a list of payment objects
 * @author Alex
 */

class PaymentList extends ObjectList//inherit ObjectList
{
	public PaymentList(int sizeIn)
	{
		//call ObjectList constructor
		super(sizeIn);
	}

	/**reads a payment at a given position in the list
	 * @param positionIn position of the payment in the list
	 * @return the payment at the given position in the list; or null if no payment exists
	 */
	public Payment getPayment(int positionIn)
	{
		//check for valid position
		if(positionIn >= 1 && positionIn<= getTotal())//getTotal() number of payments made, of parent class: ObjectList
		{
			//call inherited method and type cast from 'Object' object to 'Payment' object
			return (Payment) getItem(positionIn);
		}
		else
		{
			return null;
		}
	}
	
	/**returns total value of payments recorded*/
	public double calculateTotalPaid()
	{
		double totalPaid = 0;
		//loop through all payments
		for(int i=1; i<=getTotal(); i++)
		{
			//add current payment to the running total
			/*calls getPayment() from this class, and getAmount() from Payment class;
			 * return current payment, and the amount of that payment
			 */
			totalPaid = totalPaid+getPayment(i).getAmount();
		}
		return totalPaid;
	}
}







