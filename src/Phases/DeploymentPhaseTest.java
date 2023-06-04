package Phases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import domain.AllPlayers;
import domain.AllTerritories;
import domain.ArmyCardDeck;
import domain.ArmyPiece;
import domain.Player;
import domain.TerritoryCardDeck;
import domain.gamemap.Continent;
import domain.gamemap.GameMap;




@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeploymentPhaseTest {
	DeploymentPhase phase;
	
	Continent con1;
	Continent con2;
	Continent con3;
	Continent con4;
	Continent con5;
	Continent con6;
	
	@BeforeAll
	@DisplayName("Test Setup")
	void testSetup() {
		System.out.println("Test is processing");
		AllPlayers ordered_all_players=AllPlayers.createAllPlayers();
		AllTerritories AllTerritories= new AllTerritories();
		
		Player player1= new Player("player1");
		Player player2= new Player("player2");
		
		ordered_all_players.add_new_player(player1);
		ordered_all_players.add_new_player(player2);
		
		GameMap map=GameMap.Map_initiation();
		AllTerritories.add_a_new_territory(GameMap.territory1_1);
		AllTerritories.add_a_new_territory(GameMap.territory1_2);
		AllTerritories.add_a_new_territory(GameMap.territory1_3);
		AllTerritories.add_a_new_territory(GameMap.territory1_4);
		AllTerritories.add_a_new_territory(GameMap.territory1_5);
		AllTerritories.add_a_new_territory(GameMap.territory1_6);
		
		AllTerritories.add_a_new_territory(GameMap.territory2_1);
		AllTerritories.add_a_new_territory(GameMap.territory2_2);
		AllTerritories.add_a_new_territory(GameMap.territory2_3);
		AllTerritories.add_a_new_territory(GameMap.territory2_4);
		AllTerritories.add_a_new_territory(GameMap.territory2_5);
		AllTerritories.add_a_new_territory(GameMap.territory2_6);
		
		AllTerritories.add_a_new_territory(GameMap.territory3_1);
		AllTerritories.add_a_new_territory(GameMap.territory3_2);
		AllTerritories.add_a_new_territory(GameMap.territory3_3);
		AllTerritories.add_a_new_territory(GameMap.territory3_4);
		AllTerritories.add_a_new_territory(GameMap.territory3_5);
		AllTerritories.add_a_new_territory(GameMap.territory3_6);
		
		AllTerritories.add_a_new_territory(GameMap.territory4_1);
		AllTerritories.add_a_new_territory(GameMap.territory4_2);
		AllTerritories.add_a_new_territory(GameMap.territory4_3);
		AllTerritories.add_a_new_territory(GameMap.territory4_4);
		AllTerritories.add_a_new_territory(GameMap.territory4_5);
		AllTerritories.add_a_new_territory(GameMap.territory4_6);
		
		AllTerritories.add_a_new_territory(GameMap.territory5_1);
		AllTerritories.add_a_new_territory(GameMap.territory5_2);
		AllTerritories.add_a_new_territory(GameMap.territory5_3);
		AllTerritories.add_a_new_territory(GameMap.territory5_4);
		AllTerritories.add_a_new_territory(GameMap.territory5_5);
		AllTerritories.add_a_new_territory(GameMap.territory5_6);
		
		AllTerritories.add_a_new_territory(GameMap.territory6_1);
		AllTerritories.add_a_new_territory(GameMap.territory6_2);
		AllTerritories.add_a_new_territory(GameMap.territory6_3);
		AllTerritories.add_a_new_territory(GameMap.territory6_4);
		AllTerritories.add_a_new_territory(GameMap.territory6_5);
		AllTerritories.add_a_new_territory(GameMap.territory6_6);
		
		ArmyPiece army=ArmyPiece.ArmyPiece_initiation();
		
		for (int a=0; a<18; a++) {
			player1.add_territory(AllTerritories.get_the_nth_territory(a));
			army.addNewTerritoryArmy(AllTerritories.get_the_nth_territory(a), "Infantry", 1);
			army.addNewPlayerArmy(player1, "Infantry", 1);
			
		}
		for (int a=0; a<18; a++) {
			player2.add_territory(AllTerritories.get_the_nth_territory(a+18));
			army.addNewTerritoryArmy(AllTerritories.get_the_nth_territory(a+18), "Infantry", 1);
			army.addNewPlayerArmy(player2, "Infantry", 1);
			
		}
		
		phase = new DeploymentPhase(null,null,  ordered_all_players, player1, null,  AllTerritories);
		
		System.out.println("Test is processing");
		
		con1=GameMap.continent1;
		con2=GameMap.continent2;
		con3=GameMap.continent3;
		con4=GameMap.continent4;
		con5=GameMap.continent5;
		con6=GameMap.continent6;
		
		// assign 
		for (int t=0; t<6; t++) {
			for (int u=0; u<6; u++) {
				if (t==0) {
					AllTerritories.get_the_nth_territory(t*6+u).set_continent(con1);
					
				}
                if (t==1) {
                	AllTerritories.get_the_nth_territory(t*6+u).set_continent(con2);
					
				}
                if (t==2) {
                	AllTerritories.get_the_nth_territory(t*6+u).set_continent(con3);
	
                 }
                if (t==3) {
                	AllTerritories.get_the_nth_territory(t*6+u).set_continent(con4);
	
                }
                if (t==4) {
                	AllTerritories.get_the_nth_territory(t*6+u).set_continent(con5);
	
                }
                if (t==5) {
                	AllTerritories.get_the_nth_territory(t*6+u).set_continent(con6);
	
                 }
			}
		}
		
		

		
		System.out.println("Test is setup");
	}
	@Test
	void con1test() {
		HashMap<Continent, Integer> continent_territory_numbers = new HashMap<Continent, Integer>();
		phase.territory_counter(continent_territory_numbers);
		assertEquals(6, continent_territory_numbers.get(con1), "the number of territories of the continent1 should be 6");
	}
	
	
	@Test
	void con2test() {
		HashMap<Continent, Integer> continent_territory_numbers = new HashMap<Continent, Integer>();
		phase.territory_counter(continent_territory_numbers);
		assertEquals(6, continent_territory_numbers.get(con2), "the number of territories of the continent2 should be 6");
	}
	@Test
	void con3test() {
		HashMap<Continent, Integer> continent_territory_numbers = new HashMap<Continent, Integer>();
		phase.territory_counter(continent_territory_numbers);
		assertEquals(6, continent_territory_numbers.get(con3), "the number of territories of the continent3 should be 6");
	}
	@Test
	void con4test() {
		HashMap<Continent, Integer> continent_territory_numbers = new HashMap<Continent, Integer>();
		phase.territory_counter(continent_territory_numbers);
		assertEquals(6, continent_territory_numbers.get(con4), "the number of territories of the continent4 should be 6");
	}

	@Test
	void con5test() {
		HashMap<Continent, Integer> continent_territory_numbers = new HashMap<Continent, Integer>();
		phase.territory_counter(continent_territory_numbers);
		assertEquals(6, continent_territory_numbers.get(con5), "the number of territories of the continent5 should be 6");
	}

}
