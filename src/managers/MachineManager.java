package managers;

import java.util.List;


import org.apache.log4j.Logger;

import env.Order;
import resource.BurgerMachine;
import resource.CokeMachine;
import resource.FriesMachine;
import resource.Machine;
import threads.Diner;

public class MachineManager {

	Object obj = new Object();
	
	BurgerMachine burgerMachine;
	FriesMachine friesMachine;
	CokeMachine cokeMachine;
	
	
	public static final Logger logger = Logger.getLogger(MachineManager.class);

	//Synchronization using Init on Demand
	private static class SingletonHolder {
        static final MachineManager instance = new MachineManager();
    }
	
	public void init(){
		
		burgerMachine = new BurgerMachine();
		friesMachine = new FriesMachine();
		cokeMachine = new CokeMachine();
	}
	
	public static MachineManager getInstance() {
		
		return SingletonHolder.instance;
		
	}
	

	public Machine getAvailableMachine(Order order){
		
		synchronized (obj) {
			
			
			if(allMachinesBusy()){
				
				waitForMachine();
				
			}
			else{
				
				if(!order.areBurgersReady() && burgerMachine.isAvailable()){
					
					
					burgerMachine.setAvailable(false);
					
					return burgerMachine;
				}
				
				else if(!order.areFriesReady() && friesMachine.isAvailable())
				{
					
					friesMachine.setAvailable(false);
					
					return friesMachine;
					
					
				}
				else if(!order.isCokeReady() && cokeMachine.isAvailable()){
					
					cokeMachine.setAvailable(false);
					
					return cokeMachine;
					
				}
				
			}
		}
		
		
		//TODO: null returned
		return null;
		

		
	}

	private void waitForMachine() {
		
		try {
			
			obj.wait();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void releaseMachine(Machine m){
		
		synchronized (obj) {
			
			m.setAvailable(true);
			obj.notifyAll();
			
		}
		
		
	}

	private boolean allMachinesBusy() {
		return burgerMachine.isAvailable() && friesMachine.isAvailable() && cokeMachine.isAvailable();
	}
}
