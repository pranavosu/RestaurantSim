package managers;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import resource.Table;

public class TableManager {
	
	private ArrayList<Table> tables = new ArrayList<Table>();

	public static final Logger logger = Logger.getLogger(TableManager.class);

	//Synchronization using Init on Demand
	private static class SingletonHolder {
        static final TableManager instance = new TableManager();
    }
	
	public void init(int numTables){
		
		for(int i = 0 ; i < numTables; i++){
	
			Table t = new Table(i);
			tables.add(t);
		}
	}
	
	public static TableManager getInstance() {
		
		return SingletonHolder.instance;
	}
	
	
	
	
}
