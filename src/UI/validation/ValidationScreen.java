package UI.validation;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import UI.otherScreens.ValidationHelpScreen;


abstract class ValidationScreen extends JFrame{
	
	private static final long serialVersionUID = -2868944207398567032L;

	protected ValidationScreen validationInstance = this;
	
	protected JButton validationHelpButton;
	private JPanel validationMainPanel;
	private JPanel validationPanel;
	
	protected ValidationScreen(String title, int width, int height) {
		setTitle(title);
        setSize(width, height);

        
        validationMainPanel = new JPanel(new GridLayout(1, 2));
        
        validationMainPanel.setVisible(true);
        
        validationHelpButton = new JButton("Help");
        validationHelpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame helpScreen = (JFrame) new ValidationHelpScreen().getHelpScreen();
				helpScreen.setVisible(true);
			}    	
        });
        
        validationPanel = getValidationPanel();
        validationMainPanel.add(validationPanel);
        
        add(validationMainPanel);
        setResizable(false);
        setVisible(true);
	}
	

	protected abstract JPanel getValidationPanel();

	
	protected void closeScreen() {
		validationInstance.dispose();
	}
    

}
