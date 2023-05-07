package domain.gamemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JCheckBox;

import UI.gamemap.WorldMap;
import domain.ArmyPiece;
import domain.Player;

public enum Territory implements Comparable<Territory> {
	
	TERRITORY1_1("Territory1_1", WorldMap.checkbox1_1),
	TERRITORY1_2("Territory1_2", WorldMap.checkbox1_2),
	TERRITORY1_3("Territory1_3", WorldMap.checkbox1_3),
	TERRITORY1_4("Territory1_4", WorldMap.checkbox1_4),
	TERRITORY1_5("Territory1_5", WorldMap.checkbox1_5),
	TERRITORY1_6("Territory1_6", WorldMap.checkbox1_6),
	TERRITORY1_7("Territory1_7", WorldMap.checkbox1_7),
	
	TERRITORY2_1("Territory2_1", WorldMap.checkbox2_1),
	TERRITORY2_2("Territory2_2", WorldMap.checkbox2_2),
	TERRITORY2_3("Territory2_3", WorldMap.checkbox2_3),
	TERRITORY2_4("Territory2_4", WorldMap.checkbox2_4),
	TERRITORY2_5("Territory2_5", WorldMap.checkbox2_5),
	TERRITORY2_6("Territory2_6", WorldMap.checkbox2_6),
	TERRITORY2_7("Territory2_7", WorldMap.checkbox2_7),
	
	TERRITORY3_1("Territory3_1", WorldMap.checkbox3_1),
	TERRITORY3_2("Territory3_2", WorldMap.checkbox3_2),
	TERRITORY3_3("Territory3_3", WorldMap.checkbox3_3),
	TERRITORY3_4("Territory3_4", WorldMap.checkbox3_4),
	TERRITORY3_5("Territory3_5", WorldMap.checkbox3_5),
	TERRITORY3_6("Territory3_6", WorldMap.checkbox3_6),
	TERRITORY3_7("Territory3_7", WorldMap.checkbox3_7),
	
	TERRITORY4_1("Territory4_1", WorldMap.checkbox4_1),
	TERRITORY4_2("Territory4_2", WorldMap.checkbox4_2),
	TERRITORY4_3("Territory4_3", WorldMap.checkbox4_3),
	TERRITORY4_4("Territory4_4", WorldMap.checkbox4_4),
	TERRITORY4_5("Territory4_5", WorldMap.checkbox4_5),
	TERRITORY4_6("Territory4_6", WorldMap.checkbox4_6),
	TERRITORY4_7("Territory4_7", WorldMap.checkbox4_7),
	
	TERRITORY5_1("Territory5_1", WorldMap.checkbox5_1),
	TERRITORY5_2("Territory5_2", WorldMap.checkbox5_2),
	TERRITORY5_3("Territory5_3", WorldMap.checkbox5_3),
	TERRITORY5_4("Territory5_4", WorldMap.checkbox5_4),
	TERRITORY5_5("Territory5_5", WorldMap.checkbox5_5),
	TERRITORY5_6("Territory5_6", WorldMap.checkbox5_6),
	TERRITORY5_7("Territory5_7", WorldMap.checkbox5_7),
	
	TERRITORY6_1("Territory6_1", WorldMap.checkbox6_1),
	TERRITORY6_2("Territory6_2", WorldMap.checkbox6_2),
	TERRITORY6_3("Territory6_3", WorldMap.checkbox6_3),
	TERRITORY6_4("Territory6_4", WorldMap.checkbox6_4),
	TERRITORY6_5("Territory6_5", WorldMap.checkbox6_5),
	TERRITORY6_6("Territory6_6", WorldMap.checkbox6_6),
	TERRITORY6_7("Territory6_7", WorldMap.checkbox6_7);
	
	private final String territoryName;
	public final JCheckBox checkbox;
	
	private Player territoryOwner;
	private Continent which_continent;
	
	int number_of_units_on_the_territory=0;	//this variable will deleted

	Territory(String string, JCheckBox checkbox) {
		// TODO Auto-generated constructor stub
		this.territoryName = string;
		this.checkbox = checkbox;
		
	}
	
	boolean tEnabled = false;
	int occupied;
	private ArmyPiece armyPiece= ArmyPiece.ArmyPiece_initiation();
	
	private HashSet<Territory> adjacencySet = new HashSet<Territory>();
	
	
	public void addAdjacency(Territory adjacentTerritory) {
		adjacencySet.add(adjacentTerritory);
	}
	
	public void addNeighbour(Territory neighbourTerritory) {
		this.addAdjacency(neighbourTerritory);
		neighbourTerritory.addAdjacency(this);
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
	
/*
	public int compareTo(Territory otherTerritory) {
		if(this==otherTerritory) {
			return 1;
		}
		else{
			return 0;
		}
	}
	*/

	
	
	
	


}

