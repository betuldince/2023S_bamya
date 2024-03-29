package Phases;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import UI.attackMap.AttackMap;
import UI.attackMap.InitiateAttackUI;
import UI.gamemap.WorldMap;
import UI.otherScreens.AttackDecisionScreen;
import domain.ArmyPiece;
import domain.Dice;
import domain.Player;
import domain.buildingmode.BuildingModeHandler;
import domain.gamemap.GameMap;
import domain.gamemap.GameMapListener;
import domain.gamemap.Territory;

//import domain.InitArmyTerritory.initArmyTerritoryStarter;


public class AttackPhase implements GameMapListener{
	GameMap gameMap = GameMap.Map_initiation();
	Dice dice = Dice.Dice_initiation();
	ArmyPiece armyPiece = ArmyPiece.ArmyPiece_initiation();
	Territory attackTerritory;
	Territory targetTerritory;
	Player attacker;
	ArrayList<Territory> attackerTerritories;
	boolean threadCheck;
	
	private AttackPhase() {
		
	}
	private static AttackPhase single_attackphasehandler_instance=null;

	public static AttackPhase GetAttackPhaseHandler() {
		if (single_attackphasehandler_instance == null) {
			single_attackphasehandler_instance = new AttackPhase();
		}
		return single_attackphasehandler_instance;
	}
		

	
	public void selectAttackTerritory() {
		//get territories that are neighbouring enemy territories
		ArrayList<Territory> attackerTerritoriesNeighbouringEnemy;
		attackerTerritoriesNeighbouringEnemy=gameMap.getTerritoriesNeighbouringEnemy(attackerTerritories);
		InitiateAttackUI initiateAnAttack = new InitiateAttackUI(attackerTerritoriesNeighbouringEnemy,attacker);
		initiateAnAttack.DrawInitiateAttackMap();
	}
	public void selectTargetTerritory() {
		System.out.println("Select");
		System.out.println(armyPiece.getArmyNumber(attackTerritory));
		ArrayList<Territory> attackableTerritories;
		attackableTerritories=gameMap.getAttackableTerritories(attackTerritory);
		AttackMap attackMap=new AttackMap(attackableTerritories,attacker);
		attackMap.DrawAttackMap();
	}
	public void decideAttackAgain() {
		AttackDecisionScreen attackDecisionScreen= new AttackDecisionScreen();
		boolean attackDecision=attackDecisionScreen.getAttackDecision();
		if (attackDecision) {
			this.selectAttackTerritory();
		}
		else {
			//move to fortification phase
			FortificationPhase fortificationPhaseHandler = FortificationPhase.GetFortificationPhaseHandler();
			fortificationPhaseHandler.setPlayer(attacker);
			fortificationPhaseHandler.decideFortification();
		}
	}
	public void setThread(boolean thread){
		threadCheck=thread;
	}
	public boolean getThread(){
		return threadCheck;
	}


	public void setAttackTerritory(Territory territory) {
		this.attackTerritory=territory;
	}
	public Territory getAttackTerritory() {
		return this.attackTerritory;
	}
	public void setTargetTerritory(Territory territory) {
		this.targetTerritory=territory;
	}
	public Territory getTargetTerritory() {
		return this.targetTerritory;
	}
	public void setAttacker(Player attacker) {
		this.attacker=attacker;
		this.attackerTerritories=attacker.get_the_territories_in_control_of_the_player();
		System.out.println(attackerTerritories);
	}
	public Player getAttacker() {
		return attacker;
	}
	public boolean checkAttackTerritoryValidity() {
		return attackTerritory.checkAttackValidity();
	}
	public boolean checkTargetTerritoryValidity() {
		return gameMap.checkTerritoryAttackValidity(attackTerritory, targetTerritory);
	}
	
	
	public void attack(){
		Player defender=targetTerritory.getTerritoryOwner();
		Dice dice=Dice.Dice_initiation();
		dice.rollDiceAttack();
		String winner=dice.getWinner();
		//attacker.playerRollsAttackDice();
		//String winner= attacker.getAttackDiceRollWinner();
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
		gameMap.updateMapBattle(attackTerritory, targetTerritory, winnerPlayer);
		System.out.println(winner);
		System.out.println("Attacker territory army num:");
		System.out.println(armyPiece.getArmyNumber(attackTerritory));
		System.out.println("Defender territory army num:");
		System.out.println(armyPiece.getArmyNumber(targetTerritory));
	}
	@Override
	public void nextPhase() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void nextTurn(Territory t) {
		// TODO Auto-generated method stub
		
		
	}
	


}


