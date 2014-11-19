package util;

import managers.CookManager;
import managers.DinerManager;
import managers.TableManager;

import org.apache.log4j.Logger;

import env.Clock;

public class Restaurant {
	
	private TableManager tableMgr;
	private DinerManager dinerMgr;
	private CookManager cookMgr;
	private Clock clock;

	public static final Logger logger = Logger.getLogger(Restaurant.class);
	
	public Restaurant(int numTables, int numCooks, int numDiners) {
		
		tableMgr = TableManager.getInstance();
		tableMgr.init(numTables);
		
		dinerMgr = DinerManager.getInstance();
		dinerMgr.init(numDiners);
		
		cookMgr = CookManager.getInstance();
		cookMgr.init(numCooks);
		
		clock = Clock.getInstance();
		
	}
	
	
	public void open() {	
		// Time started
		while(shouldRemainOpen()) {
			
			//dinerMgr.startDinersArrivedNow();
			clock.increment(); 
			
			synchronized(clock) {
				clock.notifyAll();
			}
		}
		
	}

	private boolean shouldRemainOpen() {
		
		return clock.getTime() <= 120 && (!dinerMgr.isRestaurantEmpty());
	
	}
	

}
