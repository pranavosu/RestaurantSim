package threads;

import managers.CookManager;
import managers.DinerManager;

import org.apache.log4j.Logger;

import env.Constants;
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
		
		
		//TODO: Print arrive
		logger.info("Diner #"+dinerId+" arrived at:"+arrivalTime+" seated at "+Thread.currentThread().getName());
		
		
		
		CookManager.getInstance().takeOrder(this);
		
		waitForFood();
		
		eat();
		
		
		//TODO Print done
		logger.info(Thread.currentThread().getName()+" done at:"+arrivalTime+50);
		
		DinerManager.getInstance().getChequeAndLeave();
		
	}

	private void waitForFood() {
		synchronized (this) {
			try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
			}
		}
	}
	
	public void eat() {
		
		logger.info("Diner #"+dinerId+" is eating.");
		
			try {
				Thread.sleep(30 * Constants.MINUTE_SCALING);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
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

	@Override
	public String toString() {
		return "Diner [arrivalTime=" + arrivalTime + ", order=" + order
				+ ", dinerId=" + dinerId + "]";
	}


	
	
}
