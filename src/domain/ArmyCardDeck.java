package domain;

import java.util.ArrayList;

public class ArmyCardDeck {
    private ArrayList<ArmyCard> deck;
	
	public ArmyCardDeck() {
		deck=new ArrayList<ArmyCard>();	
		
	}
	public void add_new_army_card(ArmyCard newArmyCard) {
		deck.add(newArmyCard);
		
	}
	public int get_number_of_army_cards(){
		return this.deck.size();
	}
	
	public ArmyCard get_nth_card(int n) {
		return this.deck.get(n);
		
	}

}
