package managers;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import pools.RestaurantThreadPoolExecutor;
import threads.Cook;
import threads.Diner;
import env.Constants;
import env.Order;


public class CookManager {

	

	public static final Logger logger = Logger.getLogger(CookManager.class);

	private RestaurantThreadPoolExecutor cooks;
	
	
	//Synchronization using Init on Demand
	private static class SingletonHolder {
        static final CookManager instance = new CookManager();
    }
	
	
	public static CookManager getInstance() {
		
		return SingletonHolder.instance;
	}
	
	public void init(int numCooks){
		
		cooks = new RestaurantThreadPoolExecutor("Cook",
				numCooks, numCooks,
				40 * Constants.MINUTE_SCALING,
				TimeUnit.MILLISECONDS, 
				new LinkedBlockingQueue<Runnable>());
	
	}
	
	
	public void takeOrder(Diner diner){
		
		Cook c = new Cook(diner);
		
		cooks.execute(c);
		
	}
	
}
