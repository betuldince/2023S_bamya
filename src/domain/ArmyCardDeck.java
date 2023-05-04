package domain;

import java.util.ArrayList;

public class ArmyCardDeck {
    private ArrayList<ArmyCard> deck;
    int total_number_of_cards;

    
	
	public ArmyCardDeck() {
		deck=new ArrayList<ArmyCard>();	
		
	}
	public void add_new_army_card(ArmyCard newArmyCard) {
		deck.add(newArmyCard);
		total_number_of_cards++;
		
	}
	public int get_number_of_army_cards(){
		return this.deck.size();
	}
	
	public ArmyCard get_nth_card(int n) {
		return this.deck.get(n);
		
	}
	public int number_of_cards_currently_on_game_system() {
		int h=this.get_number_of_army_cards();
		int number_to_be_returned=0;
		for (int i=0; i<h; i++) {
			if (!this.deck.get(i).is_it_owned_by_a_player()) {
				number_to_be_returned++;
				
				
			}
			
		}
		return number_to_be_returned;
	}

}
