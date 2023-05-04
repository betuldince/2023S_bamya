package UI.otherScreens;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class ValidationHelpScreen extends HelpScreen {

	public ValidationHelpScreen() {
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
        ((StyledDocumentGuideContent) guideContent).insertText(0, "Password is never visible to anyone, including you. Don't forget it."
				  												+ "It is permanent, can't be changed later. Password may contain "
				  												+ "numbers, letters, and _. Other characters are not allowed. "
				  												+ "Its length must be between 3-20.\n", descriptonStyle);
        ((StyledDocumentGuideContent) guideContent).insertText(0, "password: ", keyStyle);
        ((StyledDocumentGuideContent) guideContent).insertText(0, "Nickname is visible to the players who are in the same session. "
        					  									+ "It is permanent, can't be changed later. Nickname may contain "
        					  									+ "numbers, letters, and _. Other characters are not allowed. "
        					  									+ "Its length must be between 3-20.\n", descriptonStyle);
        ((StyledDocumentGuideContent) guideContent).insertText(0, "nickname: ", keyStyle);
        // May use a .txt file in the future.


	}

	@Override
	protected void setGuideOption() {
		guideOption = new GuideViaTextPane();

	}

	@Override
	protected void setDisplayOption() {
		displayOption = new DisplayViaFrame();
	}

	@Override
	public Container getHelpScreen() {
		JFrame display = (JFrame) displayOption.getDisplay();
		JTextPane guide = (JTextPane) guideOption.getGuide();
		guide.setEditable(false);
		guideOption.addGuideContent(guide, guideContent, StyledDocumentGuideContent.class);
		display.setSize(500, 200);
		display.add(guide);
		return display;
	}

}
