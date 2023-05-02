package UI.validation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

import domain.userOperations.LoginEvent;
import domain.userOperations.LoginListener;

public class PlayerLabel extends JLabel {
	private static final long serialVersionUID = -4722212407611328527L;
	private boolean loggedIn = false;
	private String nickname = "Log In"; // Initial value
	private ImageIcon playerIcon;
	private final JLabel instance;


	public PlayerLabel() {
		
		instance = this;
		this.setOpaque(true);

		this.setPreferredSize(new Dimension(76,100));
		this.setBackground(Color.LIGHT_GRAY);

		
		Border grayline = BorderFactory.createLineBorder(Color.DARK_GRAY);
		this.setBorder(grayline);
		
		Path iconPath = Paths.get("src", "domain", "icons", "placeholder.png");
		playerIcon = new ImageIcon(iconPath.toString(), "Log in!");
		this.setIcon(playerIcon);;
		
		this.setText(nickname);
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.BOTTOM);
		
		this.setToolTipText(nickname);
		
		this.setVisible(true);
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!loggedIn) {
					LoginScreen loginScreen = new LoginScreen();
					loginScreen.addLoginListener(new LoginListener() {

						@Override
						public void loginEventOccured(LoginEvent loginEvent) {
							instance.setIcon(loginEvent.getIcon());
							instance.setText(loginEvent.getNickname());
							loggedIn = true;
						}
						
					});
				}	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
