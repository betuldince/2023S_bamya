package UI.validation;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;


abstract class ValidationScreen extends JFrame{
	
	private static final long serialVersionUID = -2868944207398567032L;

	protected ValidationScreen validationInstance = this;
	
	protected JButton validationHelpButton;
	private JPanel validationMainPanel;
	private JPanel validationPanel;

	private static final DefaultStyledDocument helpDocument = createHelpDocument();
	
	protected ValidationScreen(String title, int width, int height) {
		setTitle(title);
        setSize(width, height);

        
        validationMainPanel = new JPanel(new GridLayout(1, 2));
        
        validationMainPanel.setVisible(true);
        
        validationHelpButton = new JButton("Help");
        validationHelpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HelpScreen();			
			}    	
        });
        
        validationPanel = getValidationPanel();
        validationMainPanel.add(validationPanel);
        
        add(validationMainPanel);
        setResizable(false);
        setVisible(true);
	}
	

	protected abstract JPanel getValidationPanel();


	private class HelpScreen extends JFrame {

		private static final long serialVersionUID = 1650921965379037078L;

		private HelpScreen() {
			setTitle("Help");
	        setSize(500, 200);
	        
	        
	        JTextPane helpPane = new JTextPane();
	        helpPane.setEditable(false);
	        helpPane.setDocument(helpDocument);
	        
	        add(helpPane);
	        setVisible(true);
		}
		
		
	}
	
	
	private static DefaultStyledDocument createHelpDocument(){
		DefaultStyledDocument helpDoc = new DefaultStyledDocument();
		StyleContext context = new StyleContext();
        
        Style keyStyle = context.addStyle("Key Style", null);
        StyleConstants.setForeground(keyStyle, Color.BLACK);
        StyleConstants.setBold(keyStyle, true);
        
        Style descriptonStyle = context.addStyle("Description Style", null);
        StyleConstants.setForeground(descriptonStyle, Color.BLACK);
        StyleConstants.setBold(descriptonStyle, false);
        
        // May use a .txt file in the future.
        try {
            helpDoc.insertString(0, "Password is never visible to anyone, including you. Don't forget it."
					  + "It is permanent, can't be changed later. Password may contain "
					  + "numbers, letters, and _. Other characters are not allowed. "
					  + "Its length must be between 3-20.\n", descriptonStyle);
            helpDoc.insertString(0, "password: ", keyStyle);
            helpDoc.insertString(0, "Nickname is visible to the players who are in the same session. "
            					  + "It is permanent, can't be changed later. Nickname may contain "
            					  + "numbers, letters, and _. Other characters are not allowed. "
            					  + "Its length must be between 3-20.\n", descriptonStyle);
            helpDoc.insertString(0, "nickname: ", keyStyle);
        }
        catch(BadLocationException e) {
        	System.out.println(e.getMessage());
        }
		
		return helpDoc;
	}
	
	protected void closeScreen() {
		validationInstance.dispose();
	}
    

}
