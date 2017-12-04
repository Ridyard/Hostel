package hostelApp;

/**class used to record the details of the tenant
 * @author Alex
 *
 */

class Tenant 
{
	private String name;
	private int room;
	private PaymentList payments;//this attr, being of type PaymentList, can respond to any PaymentList methods
	public static int maxNoOfPayments = 12;//max 12 monthly payments a year
	
	/**constructor: initialises the name and room number of the tenant and sets the payments made to an empty list
	 * @param nameIn
	 * @param roomIn
	 */
	public Tenant(String nameIn, int roomIn)
	{
		name = nameIn;
		room = roomIn;
		payments = new PaymentList(maxNoOfPayments);
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getRoom()
	{
		return room;
	}
	
	/**record a payment for the tenant*/
	public void makePayment(Payment paymentIn)
	{
		payments.add(paymentIn);//add method of PaymentList called
	}
	
	/**reads the payments made by the tenant */
	public PaymentList getPayments()
	{
		return payments;
	}
	
	
	
	

}
