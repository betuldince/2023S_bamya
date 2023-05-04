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
	public int number_of_cards_currently_on_game_system() {
		int h=this.deck.size();
		int number_to_be_returned=0;
		for (int i=0; i<h; i++) {
			if (!this.deck.get(i).is_it_owned_by_a_player()) {
				number_to_be_returned++;
				
				
			}
			
		}
		return number_to_be_returned;
	}

}
