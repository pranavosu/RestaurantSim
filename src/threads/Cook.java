package threads;

import org.apache.log4j.Logger;

import env.Order;

public class Cook implements Runnable{

	private Diner diner;
	
	public static final Logger logger = Logger.getLogger(Cook.class);
	
	public Cook(Diner d) {
		
		this.diner = d;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		Order currentOrder = this.diner.getOrder();
		
		
		
		
		
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (diner) {
			diner.notify();
		}
	}
	
	
	

	
	
}
