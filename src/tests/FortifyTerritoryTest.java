package tests;

import domain.ArmyPiece;
import domain.gamemap.GameMap;
import domain.gamemap.Territory;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

 

public class FortifyTerritoryTest {
	GameMap gameMap=GameMap.Map_initiation();
	ArmyPiece armyPiece=ArmyPiece.ArmyPiece_initiation();
	private Territory territory1_1=Territory.TERRITORY1_1;
	private Territory territory1_2=Territory.TERRITORY1_2;
	private Territory territory1_3=Territory.TERRITORY1_3;
	private Territory territory2_1=Territory.TERRITORY2_1;
	private Territory territory2_2=Territory.TERRITORY2_2;
	private Territory territory2_3=Territory.TERRITORY2_3;
	private Territory territory3_1=Territory.TERRITORY3_1;
	private Territory territory3_2=Territory.TERRITORY3_2;
	private Territory territory3_3=Territory.TERRITORY3_3;
	private Territory territory3_4=Territory.TERRITORY3_4;

	
	
	@Test
	public void indirectlyConnectedWithSinglePathValidArmyNumbersTest() {
		//construction of territories, neighborings and armies
		territory1_1.addNeighbour(territory1_2);
		territory1_1.addNeighbour(territory1_3);
		territory1_1.addNeighbour(territory2_1);
		territory2_2.addNeighbour(territory2_1);
		territory2_2.addNeighbour(territory3_1);
		territory2_2.addNeighbour(territory3_3);
		territory3_3.addNeighbour(territory3_1);
		territory3_2.addNeighbour(territory3_4);
		territory2_3.addNeighbour(territory2_1);
		armyPiece.addNewTerritoryArmy(territory1_1, "infantry", 4);
		armyPiece.addNewTerritoryArmy(territory1_1, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory1_1, "artillery", 0);
		
		armyPiece.addNewTerritoryArmy(territory1_2, "infantry", 2);
		armyPiece.addNewTerritoryArmy(territory1_2, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory1_2, "artillery", 0);
		
		armyPiece.addNewTerritoryArmy(territory1_3, "infantry", 4);
		armyPiece.addNewTerritoryArmy(territory1_3, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory1_3, "artillery", 0);
		
		armyPiece.addNewTerritoryArmy(territory2_1, "infantry", 6);
		armyPiece.addNewTerritoryArmy(territory2_1, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory2_1, "artillery", 0);
		
		armyPiece.addNewTerritoryArmy(territory2_2, "infantry", 2);
		armyPiece.addNewTerritoryArmy(territory2_2, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory2_2, "artillery", 0);
		
		armyPiece.addNewTerritoryArmy(territory2_3, "infantry", 0);
		armyPiece.addNewTerritoryArmy(territory2_3, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory2_3, "artillery", 1);
		
		armyPiece.addNewTerritoryArmy(territory3_1, "infantry", 0);
		armyPiece.addNewTerritoryArmy(territory3_1, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory3_1, "artillery", 0);
		
		armyPiece.addNewTerritoryArmy(territory3_2, "infantry", 0);
		armyPiece.addNewTerritoryArmy(territory3_2, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory3_2, "artillery", 0);
		
		armyPiece.addNewTerritoryArmy(territory3_3, "infantry", 0);
		armyPiece.addNewTerritoryArmy(territory3_3, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory3_3, "artillery", 1);
		
		armyPiece.addNewTerritoryArmy(territory3_4, "infantry", 0);
		armyPiece.addNewTerritoryArmy(territory3_4, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(territory3_4, "artillery", 0);
		
		
		gameMap.fortifyTerritory(territory1_1, territory2_3, "infantry", 2);
		assertEquals(2,territory1_1.getInfantryUnitNumbers());
		assertEquals(2,territory2_3.getInfantryUnitNumbers());
	}
	
	@Test
	public void notConnectedWithValidArmyNumbersTest() {
		gameMap.fortifyTerritory(territory1_1, territory3_4, "infantry", 2);
		assertEquals(4,territory1_3.getInfantryUnitNumbers());
		assertEquals(0,territory3_4.getInfantryUnitNumbers());
	}
	@Test
	public void connectedWithInvalidArmyNumbersTest() {	
		gameMap.fortifyTerritory(territory2_2,territory3_3, "infantry", 2);
		assertEquals(2,territory2_2.getInfantryUnitNumbers());
		assertEquals(0,territory3_3.getInfantryUnitNumbers());	
	}
	@Test
	public void connectedWithMultiplePathsValidArmyNumbersTest() {
		gameMap.fortifyTerritory(territory2_1, territory3_1, "infantry", 4);
		assertEquals(2,territory2_1.getInfantryUnitNumbers());
		assertEquals(4,territory3_1.getInfantryUnitNumbers());
	}
	
	@Test 
	public void connectedWithComplexInvalidArmyNumbersTest() {
		gameMap.fortifyTerritory(territory3_3, territory3_4, "cavalry", 1);
		assertEquals(0,territory3_3.getCavalryUnitNumber());
		assertEquals(0,territory3_4.getCavalryUnitNumber());
	}
	
	
	
	



	

}
