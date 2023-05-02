package UI.otherScreens;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BuildingModeHelpScreen extends HelpScreen {

	public BuildingModeHelpScreen() {
		super();
		
	}

	@Override
	protected void createGuideContent() {
		guideContent = new StringGuideContent();
		String content = "First, select the number of players, then, the continents\n"
						+ "you want to add. Click Select Continents. After continents\n"
						+ "are selected, select the territories to customize the map\n"
						+ "further. Finaly, draw bridges between territories by ... \n";
		guideContent.setContent(content);
	}

	@Override
	protected void setGuideOption() {
		guideOption = new GuideViaTextArea();
	}

	@Override
	protected void setDisplayOption() {
		displayOption = new DisplayViaFrame();

	}

	@Override
	public Container getHelpScreen() {
		JFrame display = (JFrame) displayOption.getDisplay();
		JTextArea guide = (JTextArea) guideOption.getGuide();
		guide.setEditable(false);
		guideOption.addGuideContent(guide, guideContent);
		display.setSize(350, 150);
		display.add(guide);
		return display;
	}

}
