package Phases;

import java.util.ArrayList;

import UI.otherScreens.FortificationDecisionScreen;
import domain.ArmyPiece;
import domain.Dice;
import domain.Player;
import domain.gamemap.GameMap;
import domain.gamemap.Territory;

public class FortificationPhase {
	GameMap gameMap = GameMap.Map_initiation();
	Dice dice = Dice.Dice_initiation();
	ArmyPiece armyPiece = ArmyPiece.ArmyPiece_initiation();
	Territory defortifiedTerritory;
	Territory fortifiedTerritory;
	Player player;
	ArrayList<Territory> playerTerritories;

	private FortificationPhase() {

	}
	private static FortificationPhase single_fortificationphasehandler_instance=null;

	public static FortificationPhase GetFortificationPhaseHandler() {
		if (single_fortificationphasehandler_instance == null) {
			single_fortificationphasehandler_instance = new FortificationPhase();
		}
		return single_fortificationphasehandler_instance;
	}	
	public void decideFortification() {
		FortificationDecisionScreen fortificationDecisionScreen=new FortificationDecisionScreen();
		boolean fortificationDecision=fortificationDecisionScreen.getFortificationDecision();
		if(fortificationDecision) {
			this.selectFortifyTerritory();
			
		}
		else {
			//move to the next phase
		}
		
	}
	
	public void selectFortifyTerritory() {
		
		
	}
	public void setDefortifiedTerritory(Territory territory) {
		this.defortifiedTerritory=territory;
	}
	public Territory getDefortifiedTerritory() {
		return this.defortifiedTerritory;
	}
	public void setFortifiedTerritory(Territory territory) {
		this.fortifiedTerritory=territory;
	}
	public Territory getTargetTerritory() {
		return this.fortifiedTerritory;
	}
	public void setPlayer(Player player) {
		this.player=player;
		this.playerTerritories=player.get_the_territories_in_control_of_the_player();
		System.out.println(playerTerritories);
	}
	public Player getPlayer() {
		return player;
	}


	public boolean checkFortificationValidity(Territory deforitifiedTerritory, Territory fortifiedTerritory,String unitType, int unitQuantity) {
		return gameMap.checkTerritoryFortificationValidity(fortifiedTerritory, fortifiedTerritory, unitType,unitQuantity );
	}

	public void fortify(Territory deforitifiedTerritory, Territory fortifiedTerritory,String unitType, int unitQuantity) {
		gameMap.fortifyMap(fortifiedTerritory, fortifiedTerritory, unitType, unitQuantity);
	}
}
