package hostelApp;

/**this is the generic container class to store a list of objects
 * THIS CLASS ALLOWS OBJECTS OF ANY CLASS TO BE STORED IN A LIST
 * @author Alex
 */

class ObjectList 
{
	private Object[] list;
	private int total;
	
	
	/**constructor: initialises an empty list
	 * @param sizeIn used to set the maximum size of the list
	 */
	public ObjectList(int sizeIn)
	{
		list = new Object[sizeIn];
		total = 0;
	}
	
	//methods that can be used by inheriting classes
	
	
	/**Reports on whether object list is full
	 * @return true if full; otherwise false
	 */
	public boolean isFull()
	{
		if(list.length == total)
		{
			System.out.println("list of Objects is full");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/** Reports whether the object list is empty
	 * @return true if empty; otherwise false
	 */
	public boolean isEmpty()
	{
		if(total == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	/**reads an object from the specified position in the object list
	 * @param positionIn the position of the object in the list
	 * @return returns the object at the specified position; otherwise null
	 */
	public Object getItem(int positionIn)
	{
		if(positionIn <1 || positionIn >total)
		{
			return null;
		}
		else
		{
			return list[positionIn-1];
		}
	}
	
	
	/**reads the total number of objects currently stored in list
	 * @return total number of objects currently in list
	 */
	public int getTotal()
	{
		return total;
	}
	
	
	/**adds an object to the end of the list
	 * @param ObjectIn the object to add
	 * @return true if object successfully added; otherwise false
	 */
	public boolean add(Object ObjectIn)
	{
		if(!isFull())//isFull() helper method in this class
		{
			list[total] = ObjectIn;
			total++;
			return true;
		}
		else
		{
			System.out.println("object not added to the list");
			return false;
		}
	}
	
	/**removes an object from specified place in object list
	 * @param positionIn position of the object to be removed
	 * @return true if object removed from list; otherwise false
	 */
	public boolean removeTenant(int positionIn)
	{
		if(positionIn >=1 && positionIn<= total)
		{
			for(int i=positionIn-1; i<=total-2; i++)
			{
				list[i] = list[i+1];
				
			}
			total--;
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
	
	
	
	
	
	
	
	
	
	


