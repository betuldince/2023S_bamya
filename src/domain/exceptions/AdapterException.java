package domain.exceptions;

public class AdapterException extends Exception {

	private static final long serialVersionUID = 6637193955583347447L;

	public AdapterException() {
	}

	public AdapterException(String adapter) {
		super("Adapter for " + adapter + "doesn't exist.");
	}
	
	@Override
	public String toString() {
		return "Adapter doesn't exist";
	}
}
