package UI.otherScreens;

import javax.swing.JOptionPane;

import Phases.AttackPhase;

public class AttackDecisionScreen {
	public AttackDecisionScreen(){

	}
	public boolean getAttackDecision() {
		int result = JOptionPane.showConfirmDialog(null, 
				"Do you want to carry out another attack?", "Confirmation", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			return true;
		} else if (result == JOptionPane.NO_OPTION) {
			// Actions for 'No'
			return false;
		} else if (result == JOptionPane.CLOSED_OPTION) {
			// Actions for dialog close or close button clicked
			return false;
		}
		else {
			return false;
		}
	}

}

