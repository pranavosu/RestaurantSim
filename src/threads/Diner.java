package threads;

import managers.CookManager;
import managers.DinerManager;

import org.apache.log4j.Logger;

import util.Constants;
import environment.Clock;
import environment.Order;

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
		
		
		logger.info("Time "+Clock.getCurrentTime()+": "+this.getName()+" arrived at "+arrivalTime+" minutes, seated on "+Thread.currentThread().getName()+".");
		
		CookManager.getInstance().takeOrder(this);
		
		waitForFood();
		
		logger.info("Time "+Clock.getCurrentTime()+": "+this.getName()+" served food.");
		
		eat();
		
		logger.info("Time "+Clock.getCurrentTime()+": "+this.getName()+" leaves.");
		
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
		
		
			try {
				Thread.sleep(30 * Constants.MINUTE_SCALING);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	}
	
	public String getName(){
		
		return "Diner #"+dinerId;
		
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
