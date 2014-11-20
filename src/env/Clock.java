package env;


import org.apache.log4j.Logger;

public class Clock {
	
	private int time;
	private long startTime;
	
	public static final Logger logger = Logger.getLogger(Clock.class);
	
	private Clock() {
		time = 0;
	}
	
	public int getTime() {
		return time;
	}
	
	//Synchronization using Init on Demand
		private static class SingletonHolder {
	        static final Clock instance = new Clock();
	    }
		
		
		public static Clock getInstance() {
			
			return SingletonHolder.instance;
		}
	
	public long startClock(){
	
		startTime = System.currentTimeMillis();
		
		return startTime;
	}
	
	public void increment() {
		
	}
}
