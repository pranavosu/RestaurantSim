package threads;

import org.apache.log4j.Logger;

import util.Restaurant;
import env.Order;

public class Diner implements Runnable{

	private Thread diner;
	private int arrivalTime;
	private int seatingTime;
	private Order order;
	
	public static final Logger logger = Logger.getLogger(Diner.class);
	
	public Diner(int id, int arrivalTime, int seatingTime, Order order) {
		// TODO Auto-generated constructor stub
		
		this.arrivalTime = arrivalTime;
		this.seatingTime = seatingTime;
		this.order = order;
		this.diner = new Thread(this, "Diner #"+id);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
	
}
