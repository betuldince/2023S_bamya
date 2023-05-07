package Phases;

import java.util.ArrayDeque;
import java.util.Queue;

import UI.gamemap.WorldMap;
import domain.ArmyPiece;
import domain.Dice;
import domain.Player;
import domain.buildingmode.BuildingModeHandler;
import domain.gamemap.Map;
import domain.gamemap.Territory;
import domain.initArmyTerritory.initArmyTerritoryStarter;

public class AttackPhase {
	Map map = Map.Map_initiation();
	Dice dice = Dice.Dice_initiation();
	ArmyPiece armyPiece = ArmyPiece.ArmyPiece_initiation();


	public AttackPhase() {

	}
	public void run() {





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
	
	public void attack(Territory attackTerritory, Territory targetTerritory){
		Player attacker=attackTerritory.getTerritoryOwner();
		Player defender=targetTerritory.getTerritoryOwner();
		attacker.playerRollsAttackDice();
		String winner= attacker.getAttackDiceRollWinner();
		Player winnerPlayer;
		if(winner.equals("attacker")) {
			winnerPlayer=attacker;
		}
		else {
			winnerPlayer=defender;
		}
	}
	


}


