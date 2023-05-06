package domain.gamemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import domain.ArmyPiece;
import domain.Player;

public class Territory{
	
	private String territoryName;
	private Player territoryOwner;
	private Continent which_continent;
	
	int number_of_units_on_the_territory=0;	//this variable will deleted

	
	
	boolean tEnabled = false;
	int occupied;
	private ArmyPiece armyPiece= ArmyPiece.ArmyPiece_initiation();
	
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
	public boolean checkAttackValidity() {
		if(this.getTotalNumberOfArmyUnits()>=2) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	public int getTotalNumberOfArmyUnits() {
		return (this.getInfantryUnitNumbers()+5*this.getCavalryUnitNumber()+10*this.getArtilleryUnitNumbers());
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
	
	public HashMap<String, Integer> getTerritoryArmyNumber() {
		return armyPiece.getArmyNumber(this);
	}
	public int getInfantryUnitNumbers() {
		return this.getTerritoryArmyNumber().get("infantry");
	}
	public void updateInfantryUnitNumbers(int unitQuantity) {
		armyPiece.updateArmyNumber(this, unitQuantity, "infantry");
	}

	public int getArtilleryUnitNumbers() {
		return this.getTerritoryArmyNumber().get("artillery");
	}
	public void updateArtilleryUnitNumbers(int unitQuantity) {
		armyPiece.updateArmyNumber(this, unitQuantity, "artillery");
	}
	public int getCavalryUnitNumber() {
		return this.getTerritoryArmyNumber().get("cavalry");
	}
	public void updateCavalryUnitNumbers(int unitQuantity) {
		armyPiece.updateArmyNumber(this, unitQuantity, "cavalry");
	}
	
	
	
	
	//these methods will be deleted, left for completeness during the  demo
	public void updateNumberofUnits(int new_unit_number) {
		this.number_of_units_on_the_territory=new_unit_number;
	}
	
	public void addNumberofUnits(int unit_number) {
		this.number_of_units_on_the_territory+=unit_number;
	}
	public int getNumberOfUnits() {
		return this.number_of_units_on_the_territory;
	}
	public String get_territory_name() {
		return this.territoryName;
	}
	public Continent get_continent() {
		return this.which_continent;
	}
	
	
	
	
	
	


}

