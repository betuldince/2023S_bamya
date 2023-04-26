package domain.validation;

import java.util.EventObject;

import javax.swing.Icon;

public class LoginEvent extends EventObject {

	private static final long serialVersionUID = 4685583132569981055L;
	String nickname;
	Icon icon;

	public LoginEvent(Object source, String nickname, Icon icon) {
		super(source);
		this.nickname = nickname;
		this.icon = icon;
	}
	
	public String getNickname() {
		return nickname;
	}

	public Icon getIcon() {
		return icon;
	}
}
