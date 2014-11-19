package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SimulationEngine {
	
	public static final Logger logger = Logger.getLogger(SimulationEngine.class);
	
	public static void  initLogger()
	{
		PropertyConfigurator.configure("resources/LoggerConfig.txt");
		logger.info("Logger initialized");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		initLogger();
		
//		BufferedReader reader;
//		try {
//			
//			
//			reader = new BufferedReader(new FileReader(args[0]));
//		
//			String line = reader.readLine();
//			int numberOfDiners = Integer.parseInt(line.trim());
//			
//			line = reader.readLine();
//			int numberOfTables = Integer.parseInt(line.trim());
//			
//			line = reader.readLine();
//			int numberOfCooks = Integer.parseInt(line.trim());
//			
//			
//			Restaurant restaurant = new Restaurant(10,10,20);
//			
//			restaurant.open();
//			
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Restaurant restaurant = new Restaurant(10,10,20);
		
		restaurant.open();
			
	}


	
}
