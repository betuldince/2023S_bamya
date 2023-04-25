package UI.validation;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen extends ValidationScreen {
	
	LoginScreen loginInstance = this;

	public LoginScreen(String title, int width, int height) {
		super(title, width, height); 
	}
	
	public LoginScreen() {
		super("Login", 300, 150); 
	}

	@Override
	protected JPanel getValidationPanel() {
		
			JPanel loginPanel = new JPanel(new GridLayout(4, 2));
			JLabel loginLabel = new JLabel("Login");
			JLabel nicknameLabel = new JLabel("nickname: ");
			JLabel passwordLabel = new JLabel("password: ");
			
			JTextField nicknameField = new JTextField("a-Z, 0-9, _");
			JPasswordField passwordField = new JPasswordField("a-Z, 0-9, _");
			nicknameField.setEditable(true);
			passwordField.setEditable(true);

			JButton loginButton = new JButton("Log In");
			loginButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("login");				
				}
			});
			
			JButton signUpNowButton = new JButton("Sign Up Now!");
			signUpNowButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new SignupScreen();
					loginInstance.dispose();
				}
			});
			
			loginPanel.add(loginLabel);
			loginPanel.add(validationHelpButton);
			loginPanel.add(nicknameLabel);
			loginPanel.add(nicknameField);
			loginPanel.add(passwordLabel);
			loginPanel.add(passwordField);
			loginPanel.add(signUpNowButton);
			loginPanel.add(loginButton);

			return loginPanel;
	}

}
