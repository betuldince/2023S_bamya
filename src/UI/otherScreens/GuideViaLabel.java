package UI.otherScreens;

import java.awt.Component;

import javax.swing.JLabel;

public class GuideViaLabel implements IGuide {

	@Override
	public Component getGuide() {
		return new JLabel();
	}

	@Override
	public void addGuideContent(Component guide, IGuideContent guideContent) {
		// TODO Auto-generated method stub
		
	}

}
