package resource;

import env.Constants;
import env.Order;

public class FriesMachine extends Machine {

	@Override
	public
	boolean isAvailable() {
		
		return isAvailable;
	}

	@Override
	public Order fulfil(Order o) {
		
		for (int i = 0; i < o.getFriesCount(); i++) {
			try {
				Thread.sleep(3 * Constants.MINUTE_SCALING);
			} catch (InterruptedException e) {
			}
		}
		
		o.setFriesReady(true);
		
		return o;
	}

	@Override
	public void setAvailable(boolean available) {
		
		isAvailable = available;
	}

}
