package resource;

import util.Constants;
import environment.Clock;
import environment.Order;

public class BurgerMachine extends Machine {

	private final static int BURGER_TIME = 5;
	
	@Override
	public Order fulfil(Order o) {
		
				try {
					Thread.sleep(BURGER_TIME * Constants.MINUTE_SCALING);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		
		o.burgerPrepared();
	
		return o;
	}
	
	@Override
	public String getMachineName(){
		
		return "Burger-Machine";
	}

}
