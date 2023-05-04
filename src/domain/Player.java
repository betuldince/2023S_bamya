package domain;

import java.util.ArrayList;


import domain.gamemap.Territory;

public class Player {
	public String Player_Name;
	public TerritoryCardDeck territory_deck;
	private ArmyCardDeck army_deck;
	public ArrayList<Territory> Territories_possesed = new ArrayList<Territory>();
	
	
	public Player(String name_of_player) {
		this.Player_Name=name_of_player;
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
			
			if (Territories_possesed.get(h).territoryName.contentEquals(Territory_to_be_removed.territoryName)) {
				this.Territories_possesed.remove(h);
				break;
				
			}
				
			
				
		}
	}
	public void add_territory(Territory Territory_to_be_added ) {
		Territories_possesed.add(Territory_to_be_added);
		
	}

	
	

}
