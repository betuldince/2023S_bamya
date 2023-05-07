package UI.otherScreens.pause;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PauseScreen extends JFrame {
	private JFrame pausedFrame;
	private PauseScreen pauseScreen = this;

	public PauseScreen(JFrame pausedFrame){
		super("Game Paused");
		this.pausedFrame = pausedFrame;
		
		setLayout(new BorderLayout());
		setSize(200,120);
		
		JPanel pausePanel = new JPanel(new FlowLayout());
		JLabel pauseLabel = new JLabel("Game Paused");
		pausePanel.add(pauseLabel);
		
		JPanel resumePanel = new JPanel(new FlowLayout());
		resumePanel.add(new ResumeButton());
		
		add(pausePanel, BorderLayout.CENTER);
		add(resumePanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private class ResumeButton extends JButton {
		
		private ResumeButton() {
			super("Resume");
			this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pauseScreen.dispose();
				pausedFrame.setVisible(true);
			}
			
		});
		}
	}
}
