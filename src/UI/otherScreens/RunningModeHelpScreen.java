package UI.otherScreens;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class RunningModeHelpScreen extends HelpScreen {

	public RunningModeHelpScreen() {
		super();
	}

	@Override
	protected void createGuideContent() {
		guideContent = new StyledDocumentGuideContent();

		StyleContext context = new StyleContext();
        
        Style keyStyle = context.addStyle("Key Style", null);
        StyleConstants.setForeground(keyStyle, Color.BLACK);
        StyleConstants.setBold(keyStyle, true);
        
        Style descriptonStyle = context.addStyle("Description Style", null);
        StyleConstants.setForeground(descriptonStyle, Color.BLACK);
        StyleConstants.setBold(descriptonStyle, false);
        
        String introductionHeader = "1. Introduction\n";
        
        String conKUerorSub = "\nConKUeror ";
        String introductionBody = "is an easy and competitive strategy game to play, inspired from a famous game called RISK [1]. "
        						+ "It combines fun and challenge. In this game, players are battling to conquer the world. To win, you must launch "
        						+ "daring attacks, defend yourself on all fronts, and sweep across vast continents with boldness and cunning. But "
        						+ "remember, the dangers, as well as the rewards, are high. Just when the world is within your grasp, your opponent "
        						+ "might strike and take it all away! \r\n"
        						+ "The game is played on a political map of the world, divided into territories, which are grouped into continents. "
        						+ "Turns rotate among players who control armies of playing pieces with which they attempt to capture territories "
        						+ "from other players, with results determined by dice rolls. Players may form and dissolve alliances during the "
        						+ "course of the game. The goal of the game is to occupy every territory on the board and, in doing so, eliminate "
        						+ "the other players. \r\n"
        						+ "While attacking a territory or defending your territory, sudden situations may happen like in the real world. For "
        						+ "example, your soldiers can become sick and die, or they can get some help to defeat your enemies. Similarly, these "
        						+ "things may happen to your enemies as well. The game is played by two to six players. At least one of these players "
        						+ "is a computer while others are real people. The game ends when one of the players conquers the whole world "
        						+ "defeating all his/her enemies.\n";
        
        
        
        String gameObjectsHeader = "\n2. Game Objects\n";
        
        String gameMapSub = "\n\t1. Game Map \n ";
        String gameMapBody = "The original game map consists of 6 continents divided into 42 territories. Each continent is a different color and "
        					+ "contains from 4 to 12 territories. Players share the territories following the rules explained in Section 3.1 (Initial Sharing "
        					+ "of Territories and Army Placement). However, in the building mode, it is possible to enable/disable some continents and territories.\n";
        
        String armiesSub = "\n\t2. Armies \n ";
        String armiesBody = "There are 6 complete sets of armies, each containing 3 denominations of army pieces: Infantry (worth l), Cavalry (worth 5 Infantry), "
        				  + "and Artillery (worth 10 Infantry, or 2 Cavalry). Start the game by placing Infantry pieces; later in the game, you may trade in "
        				  + "5 Infantry for 1 Cavalry, or 2 Cavalry (or 1 Cavalry and 5 Infantry) for 1 Artillery.\n";
        
        String cardsSub = "\n\t3. Cards \n ";
        String cardsBody = "There will be three kinds of cards in the game: territory cards, chance cards, and army cards. At the beginning of any turn,"
        				 + " you will pick a chance card, and at the end of any turn in which you have captured at least one territory, you will earn "
        				 + "one territory or army card chosen randomly. \n";
             
        String territoryCardsSub = "\n\t3.1. Territory Cards \n ";
        String territoryCardsBody = "There will be territory cards as many as the number of territories in the game. During the game, the aim of collecting"
        						  + " territory cards is to conquer a continent without attacking. When the player collects all territory cards of a continent,"
        						  + " the player conquers all territories of that continent without a need to attack these territories.  \n";
        
        String armyCardsSub = "\n\t3.2. Army Cards \n ";
        String armyCardsBody = "There will be three types of army cards for infantry, cavalry, and artillery. For each player in the game, there will "
        					 + "be three infantry, two cavalry, and one artillery card. Thus, the total number of army cards will be as follows:\n\n"
        					 + "\t\t# of army cards = # of players x (3 Infantry + 2 Cavalry + 1 Artillery)\n\n"
        					 + "A player can trade army cards to gain an additional army if she/he has a set of 3 cards. He/she can place new armies"
        					 + " in any territories she/he has. The rules of gaining armies is as follows:\r\n"
        					 + "3 Infantry cards => 1 Cavalry\r\n"
        					 + "2 Infantry cards + 1 Cavalry card => 2 Cavalry\r\n"
        					 + "2 Infantry cards + 1 Artillery card => 2 Artillery\r\n"
        					 + "1 Infantry card + 2 Cavalry cards => 1 Cavalry + 1 Artillery\r\n"
        					 + "1 Artillery + 2 Cavalry cards => 3 Artillery\n\n"
        					 + "NOTE: If you have collected a set of territory and/or army cards, you may turn them in at the beginning of your next "
        					 + "turn to conquer a continent or gain soldiers.\r\n"
        					 + "\r\n"
        					 + "NOTE: If the territory and army cards end before the game ends, they are shuffled and used again. Therefore, a player"
        					 + " who has conquered a continent using territory cards may lose that continent to another player later in the game. \n";
        
        String chanceCardsSub = "\n\t3.3. Chance Cards \n ";
        String chanceCardsBody = "\"Alliance\": This card allows a player to form an alliance with another player of their choice for the duration of"
        		+ " the turn. The two players can coordinate their attacks and defenses, and share territories and cards. At the end of the turn, the"
        		+ " alliance dissolves and the players resume normal play.\r\n"
        					   + "\"Reinforcements\": This card allows a player to add a certain number of armies to one of their territories. The "
        					   + "number of armies added is determined by a roll of the dice.\r\n"
        					   + "\"Sabotage\": This card allows a player to choose one territory belonging to another player and remove a certain number"
        					   + " of armies from it. The number of armies removed is determined by a roll of the dice.\r\n"
        					   + "\"Coup\": This card allows a player to take control of one of their opponent's territories without a fight. The opponent"
        					   + " loses all armies on that territory, and the player gains control of it.\r\n"
        					   + "\"Surprise Attack\": This card allows a player to launch a surprise attack on an opponent's territory, catching them off"
        					   + " guard. The player can add a certain number of armies to their attack, and the opponent can't defend against it with their full force.\r\n"
        					   + "\"Diplomatic Immunity\": This card allows a player to protect one of their territories from attack for one turn. No other"
        					   + " player can attack that territory during that turn.\r\n"
        					   + "\"Mercenaries\": This card allows a player to hire a group of mercenaries to fight for them. The mercenaries are added to"
        					   + " one of the player's territories, and act as extra armies for that turn.\r\n"
        					   + "\"Spy\": This card allows a player to spy on one of their opponents and learn information about their strategy. The player"
        					   + " can choose to either see the opponent's cards, or learn how many armies they have on a certain territory.\r\n"
        					   + "\"Revolution\": This card allows a player to incite a revolution in one of their opponent's territories. The opponent loses"
        					   + " control of the territory, and the player gains control of it.\r\n"
        					   + "\"Disaster\": This card causes a natural disaster to strike a certain continent, affecting all players who control "
        					   + "territories on that continent. The disaster causes a certain number of armies to be lost on each territory, and the "
        					   + "player with the fewest armies on each territory loses control of it.\r\n"
        					   + "“Draft”: This card allows you to draw two additional army cards at the end of your turn.\r\n"
        					   + "“Bombardment”: You can use this card to attack a territory with a barrage of artillery, allowing you to roll two dice "
        					   + "instead of one for that attack.\r\n"
        					   + "“Rebellion”: This card allows you to incite a rebellion in one of your opponent's territories, causing half/percentage "
        					   + "of their armies there to switch to your side.\r\n"
        					   + "“Decoy”: This card allows you to place a fake army onto a territory you control, tricking your opponent into thinking "
        					   + "it is a stronger position than it actually is.\r\n"
        					   + "“Nuclear Strike”: This card allows you to wipe out all armies in one territory, regardless of how many there are, but "
        					   + "at the cost of destroying one of your own territories as well.\r\n"
        					   + "“Revolt”: Play this card on your turn to remove all armies from one of your territories and add them to another.\r\n"
        					   + "“Trade Deal”: Play this card to trade one territory card of your choice with an opponent.\r\n"
        					   + "“Secret Weapon”: Play this card to reveal and use one of your opponent's unplayed territory or army cards.\r\n"
        					   + "“World Event”: Roll a die. On a 1-2, all players receive three extra armies. On a 3-4, all players lose three armies. "
        					   + "On a 5-6, all players exchange one territory they control with another player of their choice.\n";
        
        
        
        String gamePlayHeader = "\n3. Game Play\n";
        
        String sharePlaceSub = "\n\t1. Initial Sharing of Territories and Army Placement \n ";
        String sharePlaceBody = "At the beginning, depending on the number of players, each player gets the “armies” they’ll need to start the game.\r\n"
        							+ "\t-If 2 are playing, each player has 40 Infantry.\r\n"
        							+ "\t-If 3 are playing, each player has 35 Infantry.\r\n"
        							+ "\t-If 4 are playing, each player has 30 Infantry.\r\n"
        							+ "\t-If 5 are playing, each player has 25 Infantry.\r\n"
        							+ "\t-If 6 are playing, each player has 20 Infantry.\r\n"
        							+ "Then, each player rolls one die. Whoever rolls the highest number takes one Infantry piece from his or her pile"
        							+ " and places it onto any territory on the board, thus claiming that territory.\r\n"
        							+ "Starting to the left of the first player, everyone in turn places one army onto any unoccupied territory. This"
        							+ " continues until all territories  have been claimed.\r\n"
        							+ "After all territories are claimed, each player in turn places one additional army onto any territory he or she"
        							+ " already occupies. Players continue in this way until everyone has run out of armies. There is no limit to the"
        							+ " number of armies you may place onto a single territory.\r\n"
        							+ "System shuffles the pack of cards (territory and army cards together, chance cards are separate).\r\n"
        							+ "Finally, the game starts. Whoever placed the first army takes the first turn.\n";
        
        String playerActionsSub = "\n\t2. Player Actions \n ";
        String playerActionsBody = "On a player’s turn, he/she tries to capture territories by defeating his/her opponents’ armies. "
        						 + "But they need to be careful: Winning battles will depend on careful planning, quick decisions and"
        						 + " bold moves. The player will have to place his/her forces wisely, attack at just the right time"
        						 + " and fortify his/her defenses against all enemies. \r\n"
        						 + "Each of players’ turns consists of the following steps, in this order: \r\n"
        						 + "\t1. Picking a chance card and doing whatever the card says: See Section 2.3.3 (Chance Cards) "
        						 + "for details\r\n"
        						 + "\t2. Getting and placing new armies: At the beginning of every turn (including a player’s first),"
        						 + " count the number of territories the player currently occupies, then divide the total by three"
        						 + " (ignore any fraction). The answer is the number of armies the player receives. The player places"
        						 + " the new armies on any territory he/she already occupies.\r\n"
        						 + "Example: \r\n"
        						 	+ "\t\t11 territories = 3 armies \r\n"
        						 	+ "\t\t14 territories = 4 armies \r\n"
        						 	+ "\t\t17 territories = 5 armies \r\n"
        						 + "NOTE: The player will always receive at least 3 armies on a turn, even if he/she occupies fewer"
        						 + " than 9 territories.\r\n"
        						 + "\t3. Attacking, if the player chooses to, by rolling the dice: After placing his/her armies at the"
        						 + " beginning of a turn, the player decides if he/she wishes to attack at this time. The object of an"
        						 + " attack is to capture a territory by defeating all the opposing armies already on it. The battle"
        						 + " is fought by a roll of the dice. If the player chooses not to attack, he/she passes the dice to"
        						 + " the player on his/her left. The player may still fortify his/her position, if he/she wishes (see"
        						 + " next step). If the player chooses to attack, he/she must follow these rules:\r\n"
        						 + "\t\ta. A player may only attack a territory that’s adjacent (touching) to one of his/her own, or"
        						 + " connected to it by a line. (See the map in Section 2.1 - Game Map)\r\n"
        						 + "\t\tb. The player must always have at least two armies in the territory he/she is attacking from."
        						 + " The armies should be as powerful as the ones on the territory which the player is attacking. For"
        						 + " example if the player is attacking from Greenland to Ontorio and Ontorio has Cavalry armies, the"
        						 + " player must have at least two Cavalry armies or one Cavalry army, one Artillery army on Greenland."
        						 + " He/she cannot attack Ontorio’s Cavalry armies with Infantry armies.\r\n"
        						 + "\t\tc. The player may continue attacking one territory until he/she has eliminated all armies on it,"
        						 + " or he/she may shift his/her attack from one territory to another, attacking each as often as he/she"
        						 + " likes and attacking as many territories as he/she likes during one turn.\r\n"
        						 + "\t\td. Once the player attacks a territory, both the player and his/her opponent roll a dice. The one"
        						 + " who gets the largest number wins. If the defender loses, he/she loses one army. If the attacker loses,"
        						 + " he/she loses two armies.  In case of a tie, the defender always wins.\r\n"
        						 + "\t\te. When the player defeats the last opposing army on a territory, he/she must move at least one army"
        						 + " to this territory to occupy it. Because the player has captured a territory, he/she gets a randomly"
        						 + " chosen territory or army card. He/she can save it for later use or use it immediately if he/she "
        						 + "satisfies the rules specified in Section 2.3.1 (Territory Cards) and/or Section 2.3.2 (Army Cards).\r\n"
        						 + "4. Fortifying the position: No matter what a player has done on his/her turn, he/she may, if he/she wishes,"
        						 + " end his/her turn by fortifying his/her position. The player is not required to win a battle or even to"
        						 + " try an attack to do so. This can be referred to as the “free move.” To fortify position, the player"
        						 + " moves as many armies as he/she would like from one (and only one) of his/her territories into one "
        						 + "(and only one) of his/her adjacent territories.\r\n"
        						 + "Hint: Moving troops towards borders can help in an attack! \r\n"
        						 + "NOTE: In moving his/her armies from one territory to another, the player must leave at least one "
        						 + "army behind.\r\n"
        						 + "\r\n"
        						 + "NOTE: At any time during the game, the player may trade in Infantry pieces for the equivalent in "
        						 + "Cavalry or Artillery if he/she needs to, or wishes to.\n";
        
        int docLen = 0;
        // May use a .txt file in the future.       
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, introductionHeader, keyStyle);
        docLen += introductionHeader.length();
        
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, conKUerorSub, keyStyle);
        docLen += conKUerorSub.length();
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, introductionBody, descriptonStyle);
        docLen += introductionBody.length();
        
        
        
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, gameObjectsHeader, keyStyle);
        docLen += gameObjectsHeader.length();
        
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, gameMapSub, keyStyle);
        docLen += gameMapSub.length();
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, gameMapBody, descriptonStyle);
        docLen += gameMapBody.length();
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, armiesSub, keyStyle);
        docLen += armiesSub.length();
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, armiesBody, descriptonStyle);
        docLen += armiesBody.length();

        ((StyledDocumentGuideContent) guideContent).insertText(docLen, cardsSub, keyStyle);
        docLen += cardsSub.length();
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, cardsBody, descriptonStyle);
        docLen += cardsBody.length();
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, territoryCardsSub, keyStyle);
        docLen += territoryCardsSub.length();
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, territoryCardsBody, descriptonStyle);
        docLen += territoryCardsBody.length();
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, armyCardsSub, keyStyle);
        docLen += armyCardsSub.length();
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, armyCardsBody, descriptonStyle);
        docLen += armyCardsBody.length();
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, chanceCardsSub, keyStyle);
        docLen += chanceCardsSub.length();
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, chanceCardsBody, descriptonStyle);
        docLen += chanceCardsBody.length();
        
        
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, gamePlayHeader, keyStyle);
        docLen += gamePlayHeader.length();
        
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, sharePlaceSub, keyStyle);
        docLen += sharePlaceSub.length();
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, sharePlaceBody, descriptonStyle);
        docLen += sharePlaceBody.length();
        
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, playerActionsSub, keyStyle);
        docLen += playerActionsSub.length();
        ((StyledDocumentGuideContent) guideContent).insertText(docLen, playerActionsBody, descriptonStyle);
        docLen += playerActionsBody.length();

	}

	@Override
	protected void setGuideOption() {
		// Possibility of adding more interactive guide in the next phase
		guideOption = new GuideViaScrollPane();
	}

	@Override
	protected void setDisplayOption() {
		displayOption = new DisplayViaFrame();

	}

	@Override
	public Container getHelpScreen() {
		JFrame display = (JFrame) displayOption.getDisplay();
		JScrollPane guide = (JScrollPane) guideOption.getGuide();
		guideOption.addGuideContent(guide, guideContent, StyledDocumentGuideContent.class);
		display.setSize(700, 800);
		display.add(guide);
		return display;
	}

}
