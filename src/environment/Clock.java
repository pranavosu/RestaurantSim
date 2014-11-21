package environment;


import org.apache.log4j.Logger;

import util.Constants;


public class Clock {
	
	private static long startTime;
	
	public static final Logger logger = Logger.getLogger(Clock.class);
	
	
	public static long startClock(){
	
		startTime = System.currentTimeMillis();
		return startTime;
	
	}
	
	public static int getCurrentTime() {
		
		double currentTime = System.currentTimeMillis();
		int time = (int) ((currentTime - startTime) / Constants.MINUTE_SCALING);
		return time;
	}

}
