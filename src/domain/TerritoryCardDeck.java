package domain;

import java.util.ArrayList;

import domain.gamemap.Continent;

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
	public TerritoryCard delete_last_card() {
		TerritoryCard to_be_returned=this.deck.get(this.deck.size()-1);
		this.deck.remove(this.deck.size()-1);
		return to_be_returned;
	}
	public TerritoryCard delete_nth_card(int n) {
		TerritoryCard to_be_returned=this.deck.get(n);
		this.deck.remove(n);
		return to_be_returned;
	}
	public TerritoryCard delete_a_card_of_a_specific_continent(Continent con) {
		TerritoryCard ret=null;
		for (int a=0; a<this.get_number_of_territory_cards(); a++) {
			if(this.get_nth_card(a).which_territory().get_continent()==con) {
				ret=this.get_nth_card(a);
				this.delete_nth_card(a);
				return ret;
				
				
			}
		}
		return ret;
		
	}

}
