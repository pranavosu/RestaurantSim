package resource;

import env.Constants;
import env.Order;

public class CokeMachine extends Machine {

	@Override
	public
	boolean isAvailable() {
		// TODO Auto-generated method stub
		return isAvailable;
	}

	@Override
	public Order fulfil(Order o) {
		
		for (int i = 0; i < o.getCokeCount(); i++) {
			try {
				Thread.sleep(1 * Constants.MINUTE_SCALING);
				
				
				
			} catch (InterruptedException e) {
			}
		}
		
		
		o.setCokeReady(true);
		
		return o;
	}

	@Override
	public void setAvailable(boolean available) {
		isAvailable = available;
	}

}
