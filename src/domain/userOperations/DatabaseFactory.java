package domain.userOperations;

import domain.exceptions.AdapterException;

public class DatabaseFactory {
	
	private static DatabaseFactory instance;

	private DatabaseFactory() {
	}
	
	public static DatabaseFactory getInstance() {
		
		if (instance == null) {
			instance = new DatabaseFactory();
		}
		
		return instance;	
	}
	
	public IDatabaseAdapter getDatabaseAdapter(String databaseUsed) throws AdapterException{
		IDatabaseAdapter database;
		
		if (databaseUsed.equals("txt")) {
			database = new TxtDatabaseAdapter();
		}
		
		else {
			database = null;
			throw  new AdapterException(databaseUsed);
		}
		
		return database;
		
	}

}
