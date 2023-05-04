package domain;

import java.util.Random;

public class Dice {
	//singleton pattern dice
			private int numberOfFaces = 6;
			private int numberOfDice;
			private int[] attackerFaceValues;	
			private int[] defenderFaceValues;
			private static Dice single_dice_instance=null;	
			Random rd = new Random();
			private Dice(int numberOfFaces,int numberOfDice) {
				this.numberOfFaces=numberOfFaces;
				this.numberOfDice=numberOfDice;
				this.attackerFaceValues= new int[numberOfDice];
				this.defenderFaceValues= new int[numberOfDice];	
			}
			public static Dice Dice_initiation(int numberOfDice) {
				if (single_dice_instance == null) {
					single_dice_instance = new Dice(numberOfFaces,numberOfDice);
				}
				return single_dice_instance;
			}


			public int rollDice() {
				Random rd = new Random();
				/*for (int i=0;i<numberOfDice;i++) {

			
			//Dice methods for building phase
			public void rollDice() {
				for (int i=0;i<numberOfDice;i++) {
					attackerFaceValues[i]= rd.nextInt(numberOfFaces)+1;	
				}
				
			}
			public int getValue() {
				int sum=0;
				for (int i=0;i<numberOfDice;i++) {
					sum+=attackerFaceValues[i];
				}
				return sum;
				
			}
			
			//Dice methods for attack phase
			public void rollDiceAttack() {
				for (int i=0;i<numberOfDice;i++) {

					attackerFaceValues[i]= rd.nextInt(numberOfFaces)+1;	
				}
				for (int j=0;j<numberOfDice;j++) {
					attackerFaceValues[j]= rd.nextInt(numberOfFaces)+1;	
				}*/
				
				return rd.nextInt(numberOfFaces)+1;
			}
			public String getWinner() {
				int sumAttacker=0;
				int sumDefender=0;
				for (int i=0;i<numberOfDice;i++) {
					sumAttacker+=attackerFaceValues[i];
					sumDefender+=defenderFaceValues[i];
				}
				if(sumAttacker>sumDefender) {
					return "attacker";}
				else {
					return "defender";

				}
			}

}
