package Phases;

import java.util.ArrayDeque;
import java.util.Queue;

import UI.gamemap.WorldMap;
import domain.ArmyPiece;
import domain.Dice;
import domain.Player;
import domain.buildingmode.BuildingModeHandler;
import domain.gamemap.GameMap;
import domain.gamemap.Territory;

//import domain.InitArmyTerritory.initArmyTerritoryStarter;


public class AttackPhase {
	GameMap map = GameMap.Map_initiation();
	Dice dice = Dice.Dice_initiation();
	ArmyPiece armyPiece = ArmyPiece.ArmyPiece_initiation();


	public AttackPhase() {

	}
	public void run() {



		


/*
		Territory t1= Territory.TERRITORY1_1;
		Territory t2= Territory.TERRITORY1_2;
		Territory t3= Territory.TERRITORY1_3;
		t1.addNeighbour(t2);
		t2.addNeighbour(t3);
		map.isConnected(t1, t3);
		
*/

/*
		Territory t1= Territory.TERRITORY1_1;
		Territory t2= Territory.TERRITORY1_2;
		Territory t3= Territory.TERRITORY1_3;
		t2.addNeighbour(t3);
		System.out.println(map.isConnected(t1, t3));
*/
		//initArmyTerritoryStarter.main();


		/*
		Map map = Map.Map_initiation();
		Territory istanbul = new Territory("istanbul");
		Territory kocaeli = new Territory("kocaeli");
		Territory kirklareli = new Territory("kirklareli");
		Territory tekirdag= new Territory("tekirdag");

		Territory ankara= new Territory("ankara");
		Territory düzce= new Territory("düzce");
		Territory kirikkale= new Territory("kirikkale");
		Territory cankiri= new Territory("cankiri");
		Territory konya= new Territory("konya");		




		istanbul.addNeighbour(kocaeli);
		istanbul.addNeighbour(kirklareli);
		istanbul.addNeighbour(tekirdag);

		kirklareli.addNeighbour(konya);
		ankara.addNeighbour(konya);
		ankara.addNeighbour(düzce);
		ankara.addNeighbour(cankiri);
		kirikkale.addNeighbour(konya);
		System.out.println(map.isConnected(istanbul, ankara));

		 */




	}
	
	
	public boolean initiateAttack(Territory attackTerritory, Territory targetTerritory) {
		return map.checkTerritoryAttackValidity(attackTerritory, targetTerritory);	
		
	}

	
	public void attack(Territory attackerTerritory, Territory targetTerritory){
		Player attacker=attackerTerritory.getTerritoryOwner();
		Player defender=targetTerritory.getTerritoryOwner();
		attacker.playerRollsAttackDice();
		String winner= attacker.getAttackDiceRollWinner();
		Player winnerPlayer;
		Player loserPlayer;

		int unitQuantity;
		if(winner.equals("attacker")) {
			winnerPlayer=attacker;
			loserPlayer=defender;
			unitQuantity=1;
			
		}
		else {
			winnerPlayer=defender;
			loserPlayer=attacker;
			unitQuantity=2;
		}
		loserPlayer.updatePlayerArmyNumberAfterAttack(unitQuantity);
		map.updateMapBattle(attackerTerritory, targetTerritory, winnerPlayer);
	}
	


}


