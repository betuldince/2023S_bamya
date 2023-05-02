package UI.validation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

import domain.userOperations.LoginEvent;
import domain.userOperations.LoginListener;
import domain.userOperations.ValidationEnum;
import domain.userOperations.UserOperationHandler;

public class LoginScreen extends ValidationScreen {
	
	private static final long serialVersionUID = 266854409531485306L;
	private EventListenerList listenerList = new EventListenerList();

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
					UserOperationHandler validationHandler = new UserOperationHandler();
					ValidationEnum result = validationHandler.requestLogin(nicknameField.getText(), new String(passwordField.getPassword()));
					if (result == ValidationEnum.VALID_LOGIN) {
						String nickname = nicknameField.getText();
						Icon icon = validationHandler.getIcon(nickname);
						fireLoginEvent(new LoginEvent(this, nickname, icon));
						closeScreen();
					}
					new ValidationDialogFrame(result);
				}
			});
			
			JButton signUpNowButton = new JButton("Sign Up Now!");
			signUpNowButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new SignupScreen();
					closeScreen();
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
	
	public void fireLoginEvent(LoginEvent loginEvent) {
		Object[] listeners = listenerList.getListenerList();
		for (int i=0; i < listeners.length; i+=2) {
			if (listeners[i] == LoginListener.class) {
				((LoginListener)listeners[i+1]).loginEventOccured(loginEvent);
			}
		}
	}
	
	
	public void addLoginListener(LoginListener loginListener) {
		listenerList.add(LoginListener.class, loginListener);
	}
	
	public void removeLoginListener(LoginListener loginListener) {
		listenerList.remove(LoginListener.class, loginListener);
	}


}
