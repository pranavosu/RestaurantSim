package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import environment.ParsedInput;
import environment.Restaurant;

public class SimulationEngine {
	
	public static final Logger logger = Logger.getLogger(SimulationEngine.class);
	
	public static void  initLogger()
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//initLogger();
		
		
		if(args.length == 0){
			
			logger.info("Run jar file using: java -jar Sim.jar <TestDataFile>");
			System.exit(0);
		}
		ParsedInput pi = InputParser.parseRestaurantInputFile(args[0]);
		
		Restaurant restaurant = new Restaurant(pi.getNumberOfTables(), pi.getNumberOfCooks(),
											   pi.getNumberOfDiners(),pi.getDiners());
		
		restaurant.open();
			
	}
	
}
