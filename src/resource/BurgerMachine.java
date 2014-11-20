package resource;

import env.Constants;
import env.Order;

public class BurgerMachine extends Machine {

	
	
	@Override
	public
	boolean isAvailable() {
		return isAvailable;
	}

	@Override
	public
	Order fulfil(Order o) {
	
		for (int i = 0; i < o.getBurgerCount(); i++) {
			try {
				Thread.sleep(5 * Constants.MINUTE_SCALING);
			} catch (InterruptedException e) {
			}
		}
		
		o.setBurgersReady(true);
		
		return o;
	}

	@Override
	public
	void setAvailable(boolean available) {
	
		isAvailable = available;
	}

}
