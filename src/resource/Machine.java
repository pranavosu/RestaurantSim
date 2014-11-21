package resource;

import env.Order;

public abstract class Machine {

	
	
	protected boolean isAvailable;
	
	public  boolean isAvailable(){
		return isAvailable;
	}
	public  void setAvailable(boolean available){
		
		isAvailable = available;
	}
	
	public abstract Order fulfil(Order order);
	
	public Machine() {
		
		isAvailable = true;
		
	}
	
	public String getMachineName(){
		
		return "Machine";
	}
	
}
