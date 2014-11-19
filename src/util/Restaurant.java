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
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	
	public Restaurant(int numTables, int numCooks, int numDiners) {
		
		
		
	}
	
	

}
