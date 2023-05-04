package UI.otherScreens;

import java.awt.Container;

public abstract class HelpScreen {
	
	protected IGuide guideOption;
	protected IDisplay displayOption;
	protected IGuideContent guideContent;
	
	public HelpScreen() {
		setDisplayOption();
		setGuideOption();
		createGuideContent();
	}
	
	protected abstract void createGuideContent();
	protected abstract void setGuideOption(); 
	protected abstract void setDisplayOption();
	public abstract Container getHelpScreen();
}
