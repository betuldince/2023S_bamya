package UI.otherScreens.pause;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PauseButton extends JButton {

	private static final long serialVersionUID = -7364628489748422744L;

	public PauseButton(JFrame frameToBePaused) {
		super("Pause");
		this.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			frameToBePaused.setVisible(false);
			new PauseScreen(frameToBePaused);
		}		
	});
	}
}

