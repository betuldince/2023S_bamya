package UI.otherScreens;

import java.awt.Component;

import javax.swing.JLabel;

public class GuideViaLabel implements IGuide {

	@Override
	public Component getGuide() {
		return new JLabel();
	}

	@Override
	public <T extends IGuideContent> void addGuideContent(Component guide, IGuideContent guideContent, Class<T> type) {
		((JLabel) guide).add((Component) guideContent.getContent());
		
	}

}
