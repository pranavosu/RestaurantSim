package resource;

import environment.Order;

public abstract class Machine {

	
	
	protected boolean isAvailable;
	protected int numCooksWaiting;
	
	public  boolean isAvailable(){
		return isAvailable;
	}
	public  void setAvailable(boolean available){
		
		isAvailable = available;
	}
	
	
	public int getNumCooksWaiting() {
		return numCooksWaiting;
	}
	
	public boolean areCooksWaiting(){
		return getNumCooksWaiting() > 0;
	}
	public void incrementNumCooks() {
		this.numCooksWaiting++;
	}
	
	public void decrementNumCooks() {
		this.numCooksWaiting--;
	}
	
	public abstract Order fulfil(Order order);
	
	public Machine() {
		
		isAvailable = true;
		numCooksWaiting = 0;
		
	}
	
	public String getMachineName(){
		
		return "Machine";
	}
	
}
