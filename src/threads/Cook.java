package threads;

import org.apache.log4j.Logger;

import env.Order;

public class Cook implements Runnable{

	private Thread cook;
	private int arrivalTime;
	private int seatingTime;
	private Order order;
	
	public static final Logger logger = Logger.getLogger(Cook.class);
	
	public Cook(int id) {
		
		this.cook = new Thread(this, "Cook #"+id);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
	
}
