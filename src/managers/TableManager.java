package managers;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import pools.RestaurantThreadPoolExecutor;
import threads.Diner;
import env.Constants;

public class TableManager {
	
	//private ArrayList<Table> tables = new ArrayList<Table>();
	
	private RestaurantThreadPoolExecutor tables;

	public static final Logger logger = Logger.getLogger(TableManager.class);

	//Synchronization using Init on Demand
	private static class SingletonHolder {
        static final TableManager instance = new TableManager();
    }
	
	public void init(int numTables){
		
		tables = new RestaurantThreadPoolExecutor(
				"Table ", numTables, numTables,
				120 * Constants.MINUTE_SCALING,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		
		
		
	}
	
	public static TableManager getInstance() {
		
		return SingletonHolder.instance;
	}
	
	
	public void queueDiner(Diner diner){
		
		tables.execute(diner);
		
	}
	
	
}
