package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.gamemap.Territory;

public class ArmyPiece {

	//singleton pattern
	private Map<Territory, HashMap<String, Integer>> territoryArmyPieceMap= new HashMap<Territory, HashMap<String, Integer>>();
	private Map<Player, HashMap<String, Integer>> playerArmyPieceMap= new HashMap<Player, HashMap<String, Integer>>();
	private static ArmyPiece single_army_piece_instance=null;
	private static HashMap<String, Integer> armyUnitWeights= new HashMap<String,Integer>();

	
	private ArmyPiece() {
		armyUnitWeights.put("infantry", 1);
		armyUnitWeights.put("cavalry", 5);
		armyUnitWeights.put("artillery", 10);
		/*
		ArrayList<Player> allPlayers;
		Iterator<Player> allPlayersIterator;
		allPlayers=AllPlayers.all_players;
		allPlayersIterator=allPlayers.iterator();
		while(allPlayersIterator.hasNext()) {
			Player currPlayer = allPlayersIterator.next();
			Iterator<Territory> territoryIterator=currPlayer.get_the_territories_in_control_of_the_player().iterator();
			this.addNewPlayerArmy(currPlayer, "infantry", 0);
			this.addNewPlayerArmy(currPlayer, "cavalry", 0);
			this.addNewPlayerArmy(currPlayer, "artillery", 0);
			while(territoryIterator.hasNext()) {
				Territory currTerritory=territoryIterator.next();
				this.addNewTerritoryArmy(currTerritory, "infantry", 0);
				this.addNewTerritoryArmy(currTerritory, "cavalry", 0);
				this.addNewTerritoryArmy(currTerritory, "artillery", 0);

			}
			}*/
		}
		

	public static ArmyPiece ArmyPiece_initiation() {
		if (single_army_piece_instance == null) {
			single_army_piece_instance = new ArmyPiece();
		}
		return single_army_piece_instance;
	}

	public HashMap<String, Integer> getArmyNumber(Territory territory) {	

		return territoryArmyPieceMap.get(territory); 
	}
	public HashMap<String, Integer> getArmyNumber(Player player) {	

		return playerArmyPieceMap.get(player); 
	}
	public void addNewPlayerArmy(Player player, String unitType, int unitQuantity) {
		
		if (playerArmyPieceMap.containsKey(player)) {
			HashMap<String, Integer> playerArmyQuantityMap= playerArmyPieceMap.get(player);
			playerArmyQuantityMap.put(unitType, unitQuantity);
		}
		else {
			HashMap<String, Integer> playerArmyQuantityMap=new HashMap<String,Integer>();
			playerArmyQuantityMap.put(unitType, unitQuantity);
			playerArmyPieceMap.put(player, playerArmyQuantityMap);
			
		}
	}
	public void addNewTerritoryArmy(Territory territory, String unitType, int unitQuantity) {
		
		if (territoryArmyPieceMap.containsKey(territory)) {
			HashMap<String, Integer> territoryArmyQuantityMap= territoryArmyPieceMap.get(territory);
			territoryArmyQuantityMap.put(unitType, unitQuantity);
		}
		else {
			HashMap<String, Integer> territoryArmyQuantityMap=new HashMap<String,Integer>();
			territoryArmyQuantityMap.put(unitType, unitQuantity);
			territoryArmyPieceMap.put(territory, territoryArmyQuantityMap);
			
		}
	}
	
	public void updateArmyNumber(Territory territory, int updateQuantity, String unitType ) {
		HashMap<String, Integer> armyMap=territoryArmyPieceMap.get(territory);
		//System.out.println(armyMap.get(unitType));
		armyMap.put(unitType,armyMap.get(unitType)+updateQuantity);
		//System.out.println(updateQuantity);
		//System.out.println(armyMap);
		
	}
	public void updateArmyNumber(Player player, int updateQuantity, String unitType ) {
		HashMap<String, Integer> armyMap=playerArmyPieceMap.get(player);
		armyMap.put(unitType,armyMap.get(unitType)+updateQuantity);
	}
	public int getArmyUnitWeights(String armyType){
		return armyUnitWeights.get(armyType);
		
	}
	public void updateMapArmiesBattle(Territory attackerTerritory, Territory defenderTerritory, Player winner) {
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
				//update territory owner
				Player attacker= attackerTerritory.getTerritoryOwner();
				Player defender= defenderTerritory.getTerritoryOwner();
				defenderTerritory.setTerritoryOwner(attacker);
				//Update Players' territory lists
				attacker.add_territory(defenderTerritory);
				defender.remove_Territory(defenderTerritory);

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
			//in case attacker loses the attack territory
			if(attackerTerritory.getTotalNumberOfArmyUnits()==0) {
				//update territory owner
				Player attacker= attackerTerritory.getTerritoryOwner();
				Player defender= defenderTerritory.getTerritoryOwner();
				attackerTerritory.setTerritoryOwner(defender);
				//Update Players' territory lists
				defender.add_territory(attackerTerritory);
				attacker.remove_Territory(attackerTerritory);

			}

		}		

	}
	public void fortifyMapArmies(Territory defortifiedTerritory, Territory fortifiedTerritory,String unitType,int unitQuantity) {
		if(unitType.equals("infantry")) {
			defortifiedTerritory.updateInfantryUnitNumbers(-1*unitQuantity);
			fortifiedTerritory.updateInfantryUnitNumbers(unitQuantity);

		}
		else if (unitType.equals("cavalry")) {
			defortifiedTerritory.updateCavalryUnitNumbers(-1*unitQuantity);
			defortifiedTerritory.updateCavalryUnitNumbers(unitQuantity);
		}
		else {
			defortifiedTerritory.updateArtilleryUnitNumbers(-1*unitQuantity);
			defortifiedTerritory.updateArtilleryUnitNumbers(unitQuantity);
		}
	}
	
	
	
}
