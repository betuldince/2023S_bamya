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

import domain.userOperations.LoginEvent;
import domain.userOperations.ValidationEnum;
import domain.userOperations.UserOperationHandler;

public class SignupScreen extends ValidationScreen {

	private static final long serialVersionUID = 1886343666691765652L;

	public SignupScreen(String title, int width, int height) {
		super(title, width, height);
	}
	
	public SignupScreen() {
		super("Signup", 300, 150); 
	}

	@Override
	protected JPanel getValidationPanel() {
		
			JPanel signupPanel = new JPanel(new GridLayout(4, 2));
			JLabel signupLabel = new JLabel("Signup");
			JLabel nicknameLabel = new JLabel("nickname: ");
			JLabel passwordLabel = new JLabel("password: ");
			
			JTextField nicknameField = new JTextField("a-Z, 0-9, _");
			JPasswordField passwordField = new JPasswordField("a-Z, 0-9, _");
			nicknameField.setEditable(true);
			passwordField.setEditable(true);

			JButton signupButton = new JButton("Sign Up");
			signupButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					UserOperationHandler validationHandler = new UserOperationHandler();
					ValidationEnum result = validationHandler.requestSignup(nicknameField.getText(), new String(passwordField.getPassword()));
					new ValidationDialogFrame(result);
					if (result == ValidationEnum.VALID_SIGNUP) {
						closeScreen();
					}
				}
			});
			
			JButton logInInsteadButton = new JButton("Log In Instead");
			logInInsteadButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new LoginScreen();
					closeScreen();
				}
			});
			
			signupPanel.add(signupLabel);
			signupPanel.add(validationHelpButton);
			signupPanel.add(nicknameLabel);
			signupPanel.add(nicknameField);
			signupPanel.add(passwordLabel);
			signupPanel.add(passwordField);
			signupPanel.add(logInInsteadButton);
			signupPanel.add(signupButton);

			return signupPanel;	
	}

}
