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
	private MachineManager machineMgr;
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

		machineMgr = MachineManager.getInstance();
		machineMgr.init();
		
	}
	
	public void open() {	
		
		Clock.startClock();
		
		DinerManager.getInstance().scheduleDiners();
		
	}
	
	public static void close(){
		
		System.exit(0);
	}
	
}
