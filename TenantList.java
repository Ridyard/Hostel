package hostelApp;

class TenantList extends ObjectList
{
	public TenantList(int sizeIn)
	{
		super(sizeIn);
	}
	
	public Tenant getTenant(int positionIn)
	{
		return (Tenant) getItem(positionIn);
	}
	
	
	public Tenant search(int roomIn)
	{
		//cycles through each item/object in the current TenantList
		for(int i=1; i<=getTotal(); i++)
		{
			/*to check the room no of a particular tenant we call the getTenant method(in this class) to identify the tenant,
			 * and then we call the getRoom method (tenant class) to identify this tenant's room no
			 */
			if(getTenant(i).getRoom()==roomIn)
			{
				return getTenant(i);
			}			
		}
		return null;
	}
	
	
	public boolean remove(int roomIn)
	{
		for(int i=1; i<=getTotal(); i++)
		{//remove tenant with given room number
			if(getTenant(i).getRoom()==roomIn)
			{
				removeTenant(i);//call remove method of the object class
				return true;
			}
		}
		return false;
	}
	
	
	

}





