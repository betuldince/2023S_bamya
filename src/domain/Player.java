package domain;

import java.util.ArrayList;


import domain.gamemap.Territory;

public class Player {
	public String Player_Name;
	public TerritoryCardDeck territory_deck= new TerritoryCardDeck();
	private ArmyCardDeck army_deck= new ArmyCardDeck();
	private ArrayList<Territory> Territories_possesed = new ArrayList<Territory>();
	private Player with_whom_we_have_an_alliance=null;
	private Dice dice= Dice.Dice_initiation();
	private ArmyPiece armyPiece = ArmyPiece.ArmyPiece_initiation();
	
	
	public Player(String name_of_player) {
		this.Player_Name=name_of_player;
		armyPiece.addNewPlayerArmy(this, "infantry", 0);
		armyPiece.addNewPlayerArmy(this, "cavalry", 0);
		armyPiece.addNewPlayerArmy(this, "artillery", 0);
	}
	
	
	public TerritoryCardDeck getTerritory_deck() {
		return territory_deck;
	}
	public void setTerritory_deck(TerritoryCardDeck territory_deck) {
		this.territory_deck = territory_deck;
	}
	public ArmyCardDeck getArmy_deck() {
		return army_deck;
	}
	public void setArmy_deck(ArmyCardDeck army_deck) {
		this.army_deck = army_deck;
	}
	
	public void remove_Territory(Territory Territory_to_be_removed) {
		for (int h=0; h<Territories_possesed.size(); h++) {
			
			if (Territories_possesed.get(h).get_territory_name().contentEquals(Territory_to_be_removed.get_territory_name())) {
				this.Territories_possesed.remove(h);
				break;
				
			}
				
			
				
		}
	}
	public int getPlayerInfantryNumbers() {
		return armyPiece.getArmyNumber(this).get("infantry");	
	}
	public int getPlayerCavalryNumbers() {
		return armyPiece.getArmyNumber(this).get("cavalry");	
	}
	public int getPlayerArtilleryNumbers() {
		return armyPiece.getArmyNumber(this).get("artillery");	
	}
	public void updatePlayerInfantryNumbers(int unitQuantity) {
		armyPiece.updateArmyNumber(this, unitQuantity, "infantry");
	}
	public void updatePlayerCavalryNumbers(int unitQuantity) {
		armyPiece.updateArmyNumber(this, unitQuantity, "cavalry");	
	}
	public void updatePlayerArtilleryNumbers(int unitQuantity) {
		armyPiece.updateArmyNumber(this, unitQuantity, "artillery");
	}
	public void updatePlayerArmyNumberAfterAttack(int unitQuantity) {
		if (this.getPlayerInfantryNumbers()>=unitQuantity) {
			this.updatePlayerInfantryNumbers(-1*unitQuantity);			
		}
		else if(this.getPlayerCavalryNumbers()>0) {
			this.updatePlayerCavalryNumbers(-1);
			this.updatePlayerInfantryNumbers(5-unitQuantity);
		}
		else {
			this.updatePlayerArtilleryNumbers(-1);
			this.updatePlayerCavalryNumbers(1);
			this.updatePlayerInfantryNumbers(5-unitQuantity);
		}
	}

	public void add_territory(Territory Territory_to_be_added ) {
		Territories_possesed.add(Territory_to_be_added);
		armyPiece.addNewTerritoryArmy(Territory_to_be_added, "infantry", 0);
		armyPiece.addNewTerritoryArmy(Territory_to_be_added, "cavalry", 0);
		armyPiece.addNewTerritoryArmy(Territory_to_be_added, "artillery", 0);
	}
	public Territory get_the_territory_with_the_name(String Territory_name) {
		Territory thing_to_return=null;
		int n=this.Territories_possesed.size();
		for (int i=0; i<n; i++) {
			if (this.Territories_possesed.get(i).get_territory_name().compareTo(Territory_name)==0) {
				thing_to_return=this.Territories_possesed.get(i);
				
				
				
			}
		}
		return thing_to_return;
		
	}
	//public void updatePlayerArmyNumberAttack(int unitQuantity) {
//		if (armyPiece.))
//	}


	public Player getWith_whom_we_have_an_alliance() {
		return with_whom_we_have_an_alliance;
	}


	public void setWith_whom_we_have_an_alliance(Player with_whom_we_have_an_alliance) {
		this.with_whom_we_have_an_alliance = with_whom_we_have_an_alliance;
	}
	
	// call this method when exit from the current method
	public void finish_the_turn() {
		this.with_whom_we_have_an_alliance=null;
	}
	
	public ArrayList<Territory> get_the_territories_in_control_of_the_player() {
	    return this.Territories_possesed;
	}	

	public int playerRollsDice() {
		dice.rollDice();
		return dice.getValue();
	}
	public void playerRollsAttackDice() {
		dice.rollDiceAttack();
	}
	public String getAttackDiceRollWinner() {
		return dice.getWinner();
	}
}
