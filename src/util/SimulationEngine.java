package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import env.ParsedInput;

public class SimulationEngine {
	
	public static final Logger logger = Logger.getLogger(SimulationEngine.class);
	
	public static void  initLogger()
	{
		PropertyConfigurator.configure("resources/LoggerConfig.txt");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		initLogger();
		
		ParsedInput pi = InputParser.parseRestaurantInputFile(args[0]);
		
		Restaurant restaurant = new Restaurant(pi.getNumberOfTables(), pi.getNumberOfCooks(),
											   pi.getNumberOfDiners(),pi.getDiners());
		
		restaurant.open();
			
		
	}
	
}
