package UI.otherScreens;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

public class StyledDocumentGuideContent implements IGuideContent {
	
	private DefaultStyledDocument content = new DefaultStyledDocument();

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getContent() {
		return (T) content;
	}

	@Override
	public <C> void setContent(C content) {
		this.content = (DefaultStyledDocument) content;
	}
	
	public void insertText(int offset, String text, AttributeSet a) {
		try {
			content.insertString(offset, text, a);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
