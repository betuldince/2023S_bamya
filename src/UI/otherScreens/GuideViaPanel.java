package UI.otherScreens;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextPane;

public class GuideViaPanel implements IGuide {

	@Override
	public Component getGuide() {
		return new JPanel();
	}

	@Override
	public <T extends IGuideContent> void addGuideContent(Component guide, IGuideContent guideContent, Class<T> type) {

		
	}



}
