package domain.userOperations;

import domain.exceptions.AdapterException;

public abstract class UserOperation {
	
	protected static final DatabaseFactory databaseFactory = DatabaseFactory.getInstance();
	protected IDatabaseAdapter databaseAdapter;
	protected final String database = "txt"; // change this line for other databases
	private String nickname;

	public UserOperation(String nickname) {
		this.nickname = nickname;
		try {
			databaseAdapter = databaseFactory.getDatabaseAdapter(database);
		}
		catch (AdapterException ae) {
			databaseAdapter = null;
		}
	}

}
