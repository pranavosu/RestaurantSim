package threads;

import managers.MachineManager;

import org.apache.log4j.Logger;

import resource.Machine;
import env.Order;

public class Cook implements Runnable{

	private Diner diner;
	
	public static final Logger logger = Logger.getLogger(Cook.class);
	
	public Cook(Diner d) {
		
		this.diner = d;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		Order order = this.diner.getOrder();
		
		if (order.getFriesCount() == 0) {
			
			order.setFriesReady(true);
			order.itemPrepared();
			
		}
		if (order.getCokeCount() == 0) {
			
			order.setCokeReady(true);
			order.itemPrepared();
			
		}
		

		MachineManager manager = MachineManager.getInstance();
		

		
		while(!order.isReady()){
			
			Machine machine = manager.getAvailableMachine(order);
			
			machine.fulfil(order);
			
			manager.releaseMachine(machine);
			
		}
		
		
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (diner) {
			diner.notify();
		}
	}
	
	
	

	
	
}
