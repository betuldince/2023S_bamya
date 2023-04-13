package domain;

import java.util.ArrayList;

public class TerritoryCardDeck {
    private ArrayList<TerritoryCard> deck;
	
	public TerritoryCardDeck() {
		deck=new ArrayList<TerritoryCard>();	
		
	}
	public void add_new_territory_card(TerritoryCard newTerritoryCard) {
		deck.add(newTerritoryCard);
		
	}
	public int get_number_of_territory_cards(){
		return this.deck.size();
	}
	
	public TerritoryCard get_nth_card(int n) {
		return this.deck.get(n);
		
	}

}
