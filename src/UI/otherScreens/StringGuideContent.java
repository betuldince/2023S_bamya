package UI.otherScreens;

public class StringGuideContent implements IGuideContent {
	String content = "";
	
	@Override
	public <T> T getContent() {
		return (T) content;
	}

	@Override
	public <C> void setContent(C content) {
		this.content = (String) content;
	}
	
	public void appendToContent(String str) {
		content += str;
	}

}
