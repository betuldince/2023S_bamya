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
	public int get_number_of_infantry_cards() {
		int number=0;
	
		for (int a=0; a<deck.size(); a++) {
			if (this.deck.get(a).get_card_type().contentEquals("Infantry")) {
				number++;
			}
			
		}
		return number;
	}
	public int get_number_of_cavalyr_cards() {
		int number=0;
	
		for (int a=0; a<deck.size(); a++) {
			if (this.deck.get(a).get_card_type().contentEquals("Cavalyr")) {
				number++;
			}
			
		}
		return number;
	}
	public int get_number_of_artillery_cards() {
		int number=0;
	
		for (int a=0; a<deck.size(); a++) {
			if (this.deck.get(a).get_card_type().contentEquals("Artillery")) {
				number++;
			}
			
		}
		return number;
	}
	public ArmyCard delete_last_card() {
		ArmyCard to_be_returned=this.deck.get(this.deck.size()-1);
		this.deck.remove(this.deck.size()-1);
		return to_be_returned;
	}
	public ArmyCard delete_nth_card(int n) {
		ArmyCard to_be_returned=this.deck.get(n);
		this.deck.remove(n);
		return to_be_returned;
	}
	public ArmyCard delete_an_infantry_card() {
		ArmyCard ret=null;
		for (int a=0; a<this.total_number_of_cards; a++) {
			if (this.deck.get(a).card_type.contentEquals("Infantry")) {
				ret=this.deck.get(a);
				this.deck.remove(a);
				return ret;
				
			}
		}
		return ret;
	}
	public ArmyCard delete_an_cavalyr_card() {
		ArmyCard ret=null;
		for (int a=0; a<this.total_number_of_cards; a++) {
			if (this.deck.get(a).card_type.contentEquals("Cavalyr")) {
				ret=this.deck.get(a);
				this.deck.remove(a);
				return ret;
				
			}
		}
		return ret;
	}
	public ArmyCard delete_an_artiellry_card() {
		ArmyCard ret=null;
		for (int a=0; a<this.total_number_of_cards; a++) {
			if (this.deck.get(a).card_type.contentEquals("Artillery")) {
				ret=this.deck.get(a);
				this.deck.remove(a);
				return ret;
				
			}
		}
		return ret;
	}
	
 
}
