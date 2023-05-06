package UI.user_input_taker;

import javax.swing.JOptionPane;

import domain.gamemap.Continent;

public class TerritoryCardSelectionScreen {
	public TerritoryCardSelectionScreen() {
		
	}
	public static boolean run(Continent con) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to exchange your territory cards for acquisition of the continent"+con.contName, "Title on Box", dialogButton);
		if(dialogResult == 0) {
		  return true;
		} 
		else {
		  return false;
		} 
		
	}
	
	

}
