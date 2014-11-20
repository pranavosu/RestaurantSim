package threads;

import org.apache.log4j.Logger;

import util.Restaurant;
import env.Order;

public class Diner implements Runnable{

	private int arrivalTime;
	private Order order;
	private int dinerId;
	
	public static final Logger logger = Logger.getLogger(Diner.class);
	
	public Diner(int id, int arrivalTime, Order order) {
		
		this.dinerId = id;
		this.setArrivalTime(arrivalTime);
		this.setOrder(order);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	
	
}
