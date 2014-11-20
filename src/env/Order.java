package env;

import org.apache.log4j.Logger;


public class Order {

	public static final Logger logger = Logger.getLogger(Order.class);
	
	private int friesCount;
	
	private int burgerCount;
	
	private int cokeCount;
	
	private int orderId;

	public Order(int burgerCount, int cokeCount, int friesCount, int orderId) {
		super();
		this.friesCount = friesCount;
		this.burgerCount = burgerCount;
		this.cokeCount = cokeCount;
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	

	
}
