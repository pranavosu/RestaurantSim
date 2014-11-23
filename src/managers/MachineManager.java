package managers;

import org.apache.log4j.Logger;

import environment.Order;
import resource.BurgerMachine;
import resource.CokeMachine;
import resource.FriesMachine;
import resource.Machine;

public class MachineManager {

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


		if(!order.areBurgersReady()){

			synchronized (burgerMachine) {
				
				if(!burgerMachine.isAvailable())
				{
					waitForMachine(burgerMachine);	
				}
				burgerMachine.setAvailable(false);
				return burgerMachine;
			}
			
		}else if(!order.areFriesReady()){

			synchronized (friesMachine) {
				
				if(!friesMachine.isAvailable())
					waitForMachine(friesMachine);
	
				friesMachine.setAvailable(false);
					
				return friesMachine;
			}
			
		}else if(!order.isCokeReady()){

			synchronized (cokeMachine) {
				
				if(!cokeMachine.isAvailable())
					waitForMachine(cokeMachine);
					
				cokeMachine.setAvailable(false);
				
				return cokeMachine;
			}
		}

		return null;

	}

	private void waitForMachine(Machine m) {

		synchronized (m) {
			try {
				
				while(!m.isAvailable())
					m.wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public void releaseMachine(Machine m){

		synchronized (m) {

			m.setAvailable(true);
			m.notify();

		}

	}
	
	private boolean noMachineAvailable() {
		return !anyMachineAvailable();
	}


	private boolean anyMachineAvailable() {
		return burgerMachine.isAvailable() || friesMachine.isAvailable() || cokeMachine.isAvailable();
	}
}
