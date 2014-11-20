package resource;

import env.Order;

public abstract class Machine {

	
	
	protected boolean isAvailable;
	
	public abstract boolean isAvailable();
	public abstract void setAvailable(boolean available);
	
	public abstract Order fulfil(Order order);
	
	public Machine() {
		
		isAvailable = true;
		
	}
	
}
