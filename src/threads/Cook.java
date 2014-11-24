package threads;

import managers.MachineManager;

import org.apache.log4j.Logger;

import resource.Machine;
import environment.Clock;
import environment.Order;

public class Cook implements Runnable{

	private Diner diner;
	
	public static final Logger logger = Logger.getLogger(Cook.class);
	
	public Cook(Diner d) {
		
		this.diner = d;
		
	}
	
	@Override
	public void run() {
		
		
		logger.info("Time "+Clock.getCurrentTime()+": "+Thread.currentThread().getName() +" is cooking for "+diner.getName()+" with "+diner.getOrder().getOrderName()+".");
		
		Order order = this.diner.getOrder();
		
		if (order.getFriesCount() == 0) {
			order.setFriesReady(true);
		}
		
		if (order.getCokeCount() == 0) {
			order.setCokeReady(true);
		}
		
		MachineManager manager = MachineManager.getInstance();
		
		while(!order.isReady()){
			
			Machine machine = manager.getAvailableMachine(order);
			
			logger.info("Time "+Clock.getCurrentTime()+": "+machine.getMachineName()+" is now working on "+diner.getOrder().getOrderName()+".");
			
			machine.fulfil(order);
			manager.releaseMachine(machine);
			
			
		}
		
		synchronized (diner) {
			diner.notify();
		}
	}
	
	
	

	
	
}
