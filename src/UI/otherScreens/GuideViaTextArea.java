package UI.otherScreens;

import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.text.DefaultStyledDocument;

public class GuideViaTextArea implements IGuide {

	@Override
	public Component getGuide() {
		return new JTextArea();
	}

	@Override
	public <T extends IGuideContent> void addGuideContent(Component guide, IGuideContent guideContent, Class<T> type) {
		if (type.equals(StyledDocumentGuideContent.class)) {
			((JTextArea) guide).setDocument((DefaultStyledDocument) guideContent.getContent());
		}
		if (type.equals(StringGuideContent.class)) {
			((JTextArea) guide).setText((String) guideContent.getContent());
		}
	}
}
