package managers;

import org.apache.log4j.Logger;


public class CookManager {

	public static final Logger logger = Logger.getLogger(CookManager.class);

	//Synchronization using Init on Demand
	private static class SingletonHolder {
        static final CookManager instance = new CookManager();
    }
	
	
	public static CookManager getInstance() {
		
		return SingletonHolder.instance;
	}
}
