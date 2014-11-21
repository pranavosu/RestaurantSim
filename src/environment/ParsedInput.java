package environment;

import java.util.List;

import threads.Diner;

public class ParsedInput {

	
	int numberOfDiners;
	int numberOfTables;
	int numberOfCooks;
	
	List<Diner> diners;

	@Override
	public String toString() {
		return "ParsedInput [numberOfDiners=" + numberOfDiners
				+ ", numberOfTables=" + numberOfTables + ", numberOfCooks="
				+ numberOfCooks + ", diners=" + diners + "]";
	}

	public int getNumberOfDiners() {
		return numberOfDiners;
	}

	public void setNumberOfDiners(int numberOfDiners) {
		this.numberOfDiners = numberOfDiners;
	}

	public int getNumberOfTables() {
		return numberOfTables;
	}

	public void setNumberOfTables(int numberOfTables) {
		this.numberOfTables = numberOfTables;
	}

	public int getNumberOfCooks() {
		return numberOfCooks;
	}

	public void setNumberOfCooks(int numberOfCooks) {
		this.numberOfCooks = numberOfCooks;
	}

	public List<Diner> getDiners() {
		return diners;
	}

	public void setDiners(List<Diner> diners) {
		this.diners = diners;
	}
	
	
	
	
}
