package UI.otherScreens;

import java.awt.Component;
import javax.swing.JTextArea;

public class GuideViaTextArea implements IGuide {

	@Override
	public Component getGuide() {
		return new JTextArea();
	}

	@Override
	public void addGuideContent(Component guide, IGuideContent guideContent) {
		((JTextArea) guide).setText(guideContent.getContent());
	}

}
