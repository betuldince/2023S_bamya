package UI.otherScreens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UI.gamemap.WorldMap;
import domain.initArmyTerritory.InitArmyTerritoryHandler;

public class NextPhasePopUpWindow {

	public void createNextPhasePopUp(InitArmyTerritoryHandler IATHandler) {
		WorldMap.frame.dispose(); //closing previous map
		
		JPanel popUpPanel = new JPanel();
		JLabel lblMsg = new JLabel("Deployment Phase Over");
		JButton nextPhaseBtn = new JButton("Next Phase");
		
		popUpPanel.add(lblMsg);
		popUpPanel.add(nextPhaseBtn);
		
		
		nextPhaseBtn.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IATHandler.nextPhase();
			}
			
		});
	
		JOptionPane.showMessageDialog(null, popUpPanel, "Building Phase Over", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
