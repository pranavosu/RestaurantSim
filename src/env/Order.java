package env;

import org.apache.log4j.Logger;


public class Order {

	public static final Logger logger = Logger.getLogger(Order.class);
	
	private int friesCount;
	
	private int burgerCount;
	
	private int cokeCount;
	
	private int orderId;
	
	private boolean areFriesReady;
	private boolean areBurgersReady;
	private boolean isCokeReady;
	


	public Order(int burgerCount, int cokeCount, int friesCount, int orderId) {
		super();
		this.friesCount = friesCount;
		this.burgerCount = burgerCount;
		this.cokeCount = cokeCount;
		this.orderId = orderId;
	}
	
	
	
	
	public int getFriesCount() {
		return friesCount;
	}




	public int getBurgerCount() {
		return burgerCount;
	}




	public int getCokeCount() {
		return cokeCount;
	}




	public boolean areFriesReady() {
		return areFriesReady;
	}




	public void setFriesReady(boolean areFriesReady) {
		this.areFriesReady = areFriesReady;
	}




	public boolean areBurgersReady() {
		return areBurgersReady;
	}




	public void setBurgersReady(boolean areBurgersReady) {
		this.areBurgersReady = areBurgersReady;
	}




	public boolean isCokeReady() {
		return isCokeReady;
	}




	public void setCokeReady(boolean isCokeReady) {
		this.isCokeReady = isCokeReady;
	}




	
	
	public boolean isReady(){
		
		return areBurgersReady && areFriesReady && isCokeReady;
		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
}
