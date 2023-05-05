package domain.gamemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import domain.ArmyPiece;
import domain.Dice;
import domain.Player;
import domain.buildingmode.*;
import domain.gamemap.*;


public class Map {
	
	private static int MAXCONTINENT = 6;
	public static ArrayList<Continent> continents =  new ArrayList<Continent>(); //arraylist
	private static HashSet<Territory> adjacencySet = new HashSet<Territory>();
	
	
	//temporary will be deleted when armyPiece is implemented using inheritance, this is used in getting army weights
	ArmyPiece armyPiece= ArmyPiece.ArmyPiece_initiation();

	
	public static Continent continent1;
	public static Continent continent2;
	public static Continent continent3;
	public static Continent continent4;
	public static Continent continent5;
	public static Continent continent6;
	private static Map single_map_instance=null;
	
	/*private void initContinent(Continent c) {
		
		continentCount++;
	}*/
	
	private Map() {
		continent1 = Continent.CONTINENT1;
		continent2 = Continent.CONTINENT2;
		continent3 = Continent.CONTINENT3;
		continent4 = Continent.CONTINENT4;
		continent5 = Continent.CONTINENT5;
		continent6 = Continent.CONTINENT6;
	}
	public static Map Map_initiation() {
		if (single_map_instance == null) {
			single_map_instance = new Map();
		}
		return single_map_instance;
	}
	
	public void specifyContinent(Continent c) {
		this.continents.add(c);
		System.out.println("Continent: " + c.contName + " is added");
	}

	private boolean checkNumContinent(BuildingModeHandler buildHandle) {
		int total_player= buildHandle.compPlayerCount + buildHandle.playerCount;
		
		if(continents.size() <= MAXCONTINENT && continents.size() >= total_player) {
			return true;
		} else {
			return false;
		}
	}
	
	private void specifyTerritory(Territory t) {
		
	}
	
	private void checkMap() {
		
	}
	//consider moving this method to territory?
	public boolean checkTerritoryAttackValidity(Territory attackTerritory,Territory targetTerritory) {
		if(isNeighbouring(attackTerritory, targetTerritory) & attackTerritory.checkAttackValidity()) {
			return true;
		}
		else {
			return false;
		}
	}
	//implemenet breadth first search to connect indirectly neighbouring territories
	public boolean checkTerritoryFortificationValidity(Territory defortifiedTerritory, Territory fortifiedTerritory,String unitType,int unitQuantity) {
		if(isNeighbouring(defortifiedTerritory, fortifiedTerritory) & (unitQuantity<=defortifiedTerritory.getTerritoryArmyNumber().get(unitType))&
				((defortifiedTerritory.getTotalNumberOfArmyUnits()-unitQuantity*armyPiece.getArmyUnitWeights(unitType))>=2)) {
			return true;
		}
		else {
			return false;
		}
			
	}
	private boolean isNeighbouring(Territory territory, Territory territoryQuiry) {
		HashSet<Territory> territoryAdjancencySet= territory.getAdjacencySet();
		if(territoryAdjancencySet.contains(territoryQuiry)) {
			return true;}
		else {
			return false;
		}
	}
	public void updateMapBattle(Territory attackerTerritory, Territory defenderTerritory, Player winner) {
		if(attackerTerritory.getTerritoryOwner().equals(winner)) {
			if(defenderTerritory.getInfantryUnitNumbers()>=1) {
				defenderTerritory.updateInfantryUnitNumbers(-1);
			}
			else if(defenderTerritory.getCavalryUnitNumber()>0) {
				defenderTerritory.updateCavalryUnitNumbers(-1);
				defenderTerritory.updateInfantryUnitNumbers(4);
			}
			else {
				defenderTerritory.updateArtilleryUnitNumbers(-1);
				defenderTerritory.updateCavalryUnitNumbers(1);
				defenderTerritory.updateInfantryUnitNumbers(4);
			}
			//case defeated defender territory
			if(defenderTerritory.getTotalNumberOfArmyUnits()==0) {
				defenderTerritory.setTerritoryOwner(winner);
				
			}
		}
		else {
			if(attackerTerritory.getInfantryUnitNumbers()>=2) {
				attackerTerritory.updateInfantryUnitNumbers(-2);
				}
			else if(attackerTerritory.getCavalryUnitNumber()>0){
				attackerTerritory.updateCavalryUnitNumbers(-1);
				attackerTerritory.updateArtilleryUnitNumbers(3);
				}
			else {
				attackerTerritory.updateArtilleryUnitNumbers(-1);
				attackerTerritory.updateCavalryUnitNumbers(1);
				attackerTerritory.updateInfantryUnitNumbers(3);	
			}				
			//case defeated attacker territory
			if(attackerTerritory.getTotalNumberOfArmyUnits()==0) {
				defenderTerritory.setTerritoryOwner(winner);
				}
			
		}		
		
	}

}
