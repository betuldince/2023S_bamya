package UI.otherScreens;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import javax.swing.text.DefaultStyledDocument;

public class GuideViaScrollPane implements IGuide {

	@Override
	public Component getGuide() {
		JScrollPane scrollPane = new JScrollPane();
		
		return scrollPane;
	}

	@Override
	public <T extends IGuideContent> void addGuideContent(Component guide, IGuideContent guideContent, Class<T> type) {
		if (type.equals(StyledDocumentGuideContent.class)) {
			JTextPane textPane = new JTextPane();
			textPane.setEditable(false);
			textPane.setDocument((DefaultStyledDocument) (guideContent.getContent()));
			((JScrollPane) guide).setViewportView(textPane);

			}
		if (type.equals(StringGuideContent.class)) {
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setText((String) guideContent.getContent());
			((JScrollPane) guide).add(textArea);
		}
		
	}


}
