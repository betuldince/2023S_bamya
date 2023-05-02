package domain.gamemap;

import java.util.ArrayList;

public class Territory{
	
	String territoryName;
	boolean tEnabled = false;
	int occupied;
	
	private ArrayList<Territory> adjacencyList = new ArrayList<Territory>();
	private ArrayList<Bridge> bridgeList = new ArrayList<Bridge>();
	
	public Territory(String territoryName) {
		this.territoryName=territoryName;
	}
	
	public void addNeighbour(Territory neighbourTerritory) {
		adjacencyList.add(neighbourTerritory);
	}
	public ArrayList<Territory> getAdjacencyList(){
		return adjacencyList;
	}
	public boolean checkArmyNumberValidity() {
		return true;
		
	}
	
	private void createTerritory(Territory t){
		
		tEnabled = true;
	}
	
	
	
	


}

