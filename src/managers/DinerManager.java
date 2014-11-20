package managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import threads.Diner;
import util.Restaurant;
import env.Constants;


public class DinerManager {

	private List<Diner> diners = new ArrayList<Diner>();
	private static int numDinersInRestaurant;
	private static int orderCount;
	
	public static final Logger logger = Logger.getLogger(DinerManager.class);

	//Synchronization using Init on Demand
	private static class SingletonHolder {
        static final DinerManager instance = new DinerManager();
    }
	
	public void init(int numDiners, List<Diner> diners){
		numDinersInRestaurant = numDiners;
		this.diners = diners;
	}
	
	
	public static DinerManager getInstance() {
		
		return SingletonHolder.instance;
		
	}
	
	public boolean isRestaurantEmpty(){
		
		return numDinersInRestaurant == 0;
		
	}
	
	public void scheduleDiners(){
		
		
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
					* Constants.MINUTE_SCALING);
			
			
		}
		
	}
	
	public void getChequeAndLeave(){
		
		numDinersInRestaurant--;
		
		if(isRestaurantEmpty()){
			
			logger.info("Last diner leaves");
			
			Restaurant.close();
			
		}
	}	
}
