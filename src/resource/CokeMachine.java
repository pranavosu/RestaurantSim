package resource;

import env.Constants;
import env.Order;

public class CokeMachine extends Machine {

	private final static int COKE_TIME = 1;
	

	@Override
	public Order fulfil(Order o) {
		
			try {
			
				Thread.sleep(COKE_TIME * Constants.MINUTE_SCALING);
		
			} catch (InterruptedException e) {
		}
		
		o.cokePrepared();
		
		return o;
	}


	@Override
	public String getMachineName(){
		
		return "Coke-Machine";
	}
}
