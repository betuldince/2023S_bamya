package UI.saveLoad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SaveButton extends JButton {

	private static final long serialVersionUID = 7038806639929715998L;

	public SaveButton() {
		this.setText("Save");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaveLoadHandler.getHandler().saveGame()
			}
			
		});
	}
}
