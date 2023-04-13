package domain;

public class Player {
	private TerritoryCardDeck territory_deck;
	private ArmyCardDeck army_deck;
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

}
