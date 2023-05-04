package UI.otherScreens;

import java.awt.Container;

import javax.swing.JFrame;

public class DisplayViaFrame implements IDisplay {

	@Override
	public Container getDisplay() {
		return new JFrame();
	}

}
