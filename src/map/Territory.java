package map;

import java.util.ArrayList;

public class Territory{
	String territoryName;
	private ArrayList<Territory> adjacencyList = new ArrayList<Territory>();
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
	


}

