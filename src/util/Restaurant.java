package util;

import java.util.List;

import managers.CookManager;
import managers.DinerManager;
import managers.MachineManager;
import managers.TableManager;

import org.apache.log4j.Logger;

import threads.Diner;
import env.Clock;

public class Restaurant {
	
	private TableManager tableMgr;
	private DinerManager dinerMgr;
	private MachineManager manager;
	private CookManager cookMgr;
	
	private Clock clock;

	public static final Logger logger = Logger.getLogger(Restaurant.class);
	
	public Restaurant(int numTables, int numCooks, int numDiners, List<Diner> diners) {
		
		tableMgr = TableManager.getInstance();
		tableMgr.init(numTables);
		
		dinerMgr = DinerManager.getInstance();
		dinerMgr.init(numDiners, diners);
		
		cookMgr = CookManager.getInstance();
		cookMgr.init(numCooks);
		

		 manager = MachineManager.getInstance();
		 manager.init();
		
		clock = Clock.getInstance();
		
	}
	
	
	public void open() {	
		
		
		Clock.getInstance().startClock();
		
		DinerManager.getInstance().scheduleDiners();
		
//		while(shouldRemainOpen()) {
//			
//			//dinerMgr.startDinersArrivedNow();
//			clock.increment(); 
//			
//			synchronized(clock) {
//				clock.notifyAll();
//			}
//		}
		
	}

	private boolean shouldRemainOpen() {
		
		return clock.getTime() <= 120 || (!dinerMgr.isRestaurantEmpty());
	
	}
	
	public static void close(){
		
		logger.info("Restaurant Closed");
		System.exit(0);
	}
	
}
