package domain;

import java.util.ArrayList;

public class ChanceCardDeck {
	private ArrayList<ChanceCard> deck;
	
	public ChanceCardDeck() {
		deck=new ArrayList<ChanceCard>();	
		
	}
	public void add_new_chance_card(ChanceCard newChanceCard) {
		deck.add(newChanceCard);
		
	}
	public int get_number_of_chance_cards(){
		return this.deck.size();
	}
	
	public ChanceCard get_nth_card(int n) {
		return this.deck.get(n);
		
	}
	
	
	

}
