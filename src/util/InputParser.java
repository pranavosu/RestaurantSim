package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;

import env.Constants;
import env.Order;
import env.ParsedInput;
import threads.Diner;

public class InputParser {

	
	public static final Logger logger = Logger.getLogger(InputParser.class);
	
	public static ParsedInput parseRestaurantInputFile(String inputFile){
		
		
		ParsedInput parsedInput = new ParsedInput();
		
		List<Diner> dinerList = new ArrayList<Diner>();
		
			try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
				
				
				String line = reader.readLine();
				int numberOfDiners = Integer.parseInt(line.trim());
				parsedInput.setNumberOfDiners(numberOfDiners);
				
				
				line = reader.readLine();
				int numberOfTables = Integer.parseInt(line.trim());
				parsedInput.setNumberOfTables(numberOfTables);
				
				line = reader.readLine();
				int numberOfCooks = Integer.parseInt(line.trim());
				parsedInput.setNumberOfCooks(numberOfCooks);
				
				int dinerCount = 1;
				
				while((line=reader.readLine())!=null){
					
					line = line.trim();
					
					
					if(line.isEmpty()) continue;
					
					String[] orderInfo = line.split("\\s+");
					
					int fries = Integer.parseInt(orderInfo[2]);
					int burgers = Integer.parseInt(orderInfo[1]);
					int coke = Integer.parseInt(orderInfo[3]);
					int arrivalTime = Integer.parseInt(orderInfo[0]);
					
					Order o = new Order(burgers, coke, fries, dinerCount);
					Diner d = new Diner(dinerCount++, arrivalTime, o);
					
					dinerList.add(d);
					
				}
				
				parsedInput.setDiners(dinerList);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return parsedInput;
		
	}
}
