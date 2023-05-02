package UI.otherScreens;

import java.awt.Component;

public interface IGuide {
	public Component getGuide();
	public <T extends IGuideContent> void addGuideContent(Component guide, IGuideContent guideContent, Class<T> type);
}
