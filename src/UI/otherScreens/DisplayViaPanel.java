package UI.otherScreens;

import java.awt.Container;

import javax.swing.JPanel;

public class DisplayViaPanel implements IDisplay {
	
	@Override
	public Container getDisplay() {
		return new JPanel();
	}

}
