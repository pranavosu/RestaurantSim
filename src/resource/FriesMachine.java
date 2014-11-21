package resource;

import env.Constants;
import env.Order;

public class FriesMachine extends Machine {

	private final static int FRIES_TIME = 3;
	

	@Override
	public Order fulfil(Order o) {
		
			try {
				Thread.sleep(FRIES_TIME * Constants.MINUTE_SCALING);
			} catch (InterruptedException e) {
			}
		
		o.friesPrepared();
		
		return o;
	}

	
	@Override
	public String getMachineName(){
		
		return "Fries-Machine";
	}

}
