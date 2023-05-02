package UI.otherScreens;

import java.awt.Component;

import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;

public class GuideViaTextPane implements IGuide {

	@Override
	public Component getGuide() {
		return new JTextPane();
	}

	@Override
	public <T extends IGuideContent> void addGuideContent(Component guide, IGuideContent guideContent, Class<T> type) {
		if (type.equals(StyledDocumentGuideContent.class)) {
			((JTextPane) guide).setDocument((DefaultStyledDocument) guideContent.getContent());
		}
		if (type.equals(StringGuideContent.class)) {
			((JTextPane) guide).setText((String) guideContent.getContent());
		}
	}

}
