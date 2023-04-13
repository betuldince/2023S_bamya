package domain;

import java.util.ArrayList;

public class ChanceCardDeck {
	public ArrayList<ChanceCard> deck;
	
	public ChanceCardDeck() {
		deck=new ArrayList<ChanceCard>();	
		
	}
	public void add_new_chance_card(ChanceCard newChanceCard) {
		deck.add(newChanceCard);
		
	}
	
	
	
	

}
