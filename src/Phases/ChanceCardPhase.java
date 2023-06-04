package Phases;

import java.util.ArrayList;
import java.util.Random;

import UI.otherScreens.InformationGiver;
import domain.AllPlayers;
import domain.Dice;
import domain.Player;
import domain.ChanceCards.ChanceCard;
import domain.ChanceCards.ChanceCardDeck;

public class ChanceCardPhase {
	public ChanceCardDeck chance_card_deck;
	public AllPlayers other_players; //current player is included in this object
	public Player current_player;
	public Dice our_dice;
	
	public ChanceCardPhase(ChanceCardDeck chance_card_deck, AllPlayers all_players, Player current_player) {
		this.other_players=all_players;
		this.chance_card_deck=chance_card_deck;
		this.current_player=current_player;
		
		
		
	}
	public int run() throws InterruptedException {
		InformationGiver.run("Chance Card Phase for the player "+current_player.Player_Name+" has started",1);
		
		
		
		int n=this.chance_card_deck.get_number_of_chance_cards();
		
		Random rn = new Random();
		
		int random=rn.nextInt(n);
		ChanceCard our_chance_card=this.chance_card_deck.get_nth_card(random);
		
		InformationGiver.run("The assigned chance card is "+our_chance_card.get_the_name(),1);
		
		Dice our_dice1=Dice.Dice_initiation();
		this.our_dice=our_dice1;
		
		our_chance_card.run(other_players, current_player, our_dice);
		
		return 1; // 1 means phase is complete with SUCCESS code.
		
	}
	

}
