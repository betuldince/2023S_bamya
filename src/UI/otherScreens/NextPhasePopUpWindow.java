
package UI.otherScreens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import UI.gamemap.WorldMap;
import domain.boolean_singleton;
import domain.initArmyTerritory.InitArmyTerritoryHandler;

public class NextPhasePopUpWindow {

	public void createNextPhasePopUp(InitArmyTerritoryHandler IATHandler) {
		boolean_singleton our_bool=boolean_singleton.initiate_bool();
		our_bool.our_boolean=false;
		WorldMap.frame.dispose(); //closing previous map
		
		JTextField juf = new JTextField("Building Phase Over");
		JOptionPane op = new JOptionPane(juf, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_OPTION);
		JDialog userDialog = op.createDialog("next phase");
		userDialog.addComponentListener(new ComponentAdapter() {
	        @Override/*from   w ww .  j  a  va2s. c  om*/
	        public void componentShown(ComponentEvent e) {
	            SwingUtilities.invokeLater(new Runnable() {
	                @Override
	                public void run() {
	                    juf.requestFocusInWindow();
	                }
	            });
	        }
	    });
	    userDialog.setVisible(true);
	    int uresult = (Integer) op.getValue();
	    userDialog.dispose();
	    
	    if (uresult == JOptionPane.OK_OPTION) {
	        System.out.println("button clicked");
	        IATHandler.nextPhase();
	    }
	
		
	}
	
}
