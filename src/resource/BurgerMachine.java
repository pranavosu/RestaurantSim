package resource;

import env.Constants;
import env.Order;

public class BurgerMachine extends Machine {

	
	
	@Override
	public
	boolean isAvailable() {
		// TODO Auto-generated method stub
		return isAvailable;
	}

	@Override
	public
	Order fulfil(Order o) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		isAvailable = available;
	}

}
