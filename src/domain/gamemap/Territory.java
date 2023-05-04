package domain.gamemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import domain.ArmyPiece;
import domain.Player;

public class Territory{
	
	public String territoryName;
	Player territoryOwner;
	int number_of_units_on_the_territory=0;
	boolean tEnabled = false;
	int occupied;
	ArmyPiece armyPiece= ArmyPiece.ArmyPiece_initiation();
	
	private HashSet<Territory> adjacencySet = new HashSet<Territory>();
	private ArrayList<Bridge> bridgeList = new ArrayList<Bridge>();
	
	public Territory(String territoryName) {
		this.territoryName=territoryName;
	}
	
	public void addNeighbour(Territory neighbourTerritory) {
		adjacencySet.add(neighbourTerritory);
	}
	public HashSet<Territory>  getAdjacencySet(){
		return adjacencySet;
	}
	//not implemented yet
	public boolean checkArmyNumberValidity() {
		return true;
		
	}
	
	private void createTerritory(Territory t){
		
		tEnabled = true;
	}
	public void setTerritoryOwner(Player player) {
		this.territoryOwner=player;
	}
	public Player getTerritoryOwner() {
		return territoryOwner;
	}
	
	public void updateTerritory(int armynum, String unitType)  {
		
	}
	public HashMap<String, Integer> getTerritoryArmyNumber() {
		return armyPiece.getArmyNumber(this);
		
	}
	public void updateNumberofUnits(int new_unit_number) {
		this.number_of_units_on_the_territory=new_unit_number;
	}
	
	public void addNumberofUnits(int unit_number) {
		this.number_of_units_on_the_territory+=unit_number;
	}
	
	
	
	
	


}

