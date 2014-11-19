package env;

import org.apache.log4j.Logger;

public class Clock {
	private static Clock clock = null;
	private int time;
	
	public static final Logger logger = Logger.getLogger(Clock.class);
	
	private Clock() {
		time = 0;
	}
	
	public int getTime() {
		return time;
	}
	
	public static Clock getInstance() {
		if(clock == null) {
			clock = new Clock();
		}
		return clock;
	}
	
	public void increment() {
		
		logger.info("Current Time : " + time);
		
		try {
			Thread.sleep(50);
		} catch(InterruptedException ie) {
			
		}
		time++;
	}
}
