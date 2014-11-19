package managers;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import threads.Diner;


public class DinerManager {

	private ArrayList<Diner> diners = new ArrayList<Diner>();
	
	public static final Logger logger = Logger.getLogger(DinerManager.class);

	//Synchronization using Init on Demand
	private static class SingletonHolder {
        static final DinerManager instance = new DinerManager();
    }
	
	public static DinerManager getInstance() {
		
		return SingletonHolder.instance;
		
	}
	
}
