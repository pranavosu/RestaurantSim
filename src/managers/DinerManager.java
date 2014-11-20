package managers;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import env.EnvironmentConstants;
import threads.Diner;


public class DinerManager {

	private ArrayList<Diner> diners = new ArrayList<Diner>();
	private int numDinersInRestaurant;
	private int orderCount;
	
	public static final Logger logger = Logger.getLogger(DinerManager.class);

	//Synchronization using Init on Demand
	private static class SingletonHolder {
        static final DinerManager instance = new DinerManager();
    }
	
	public void init(int numDiners){
		numDinersInRestaurant = numDiners;
	}
	
	
	public static DinerManager getInstance() {
		
		return SingletonHolder.instance;
		
	}
	
	public boolean isRestaurantEmpty(){
		
		return numDinersInRestaurant == 0;
		
	}
	
	public void scheduleDiners(ArrayList<Diner> diners){
		
		
		final TableManager manager = TableManager.getInstance();
		
		orderCount = 1;
		
		for (final Diner diner : diners) {
			
			TimerTask timerTask = new TimerTask() {

				@Override
				public void run() {
			
					diner.getOrder().setOrderId(orderCount++);
					manager.queueDiner(diner);
				
				}
			};
			
			Timer timer = new Timer();
			
			timer.schedule(timerTask, diner.getArrivalTime()
					* EnvironmentConstants.MINUTE_SCALING);
			
			
		}
		
	}
	
}
