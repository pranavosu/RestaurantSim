package managers;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import threads.Cook;


public class CookManager {

	
	private ArrayList<Cook> cooks = new ArrayList<Cook>();

	public static final Logger logger = Logger.getLogger(CookManager.class);

	//Synchronization using Init on Demand
	private static class SingletonHolder {
        static final CookManager instance = new CookManager();
    }
	
	
	public static CookManager getInstance() {
		
		return SingletonHolder.instance;
	}
	
	public void init(int numCooks){
		
		for(int i = 0 ; i < numCooks; i++){
	
			Cook c = new Cook(i);
			cooks.add(c);
		}
	}
	
}
