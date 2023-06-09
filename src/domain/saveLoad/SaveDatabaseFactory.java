package domain.saveLoad;

import domain.exceptions.AdapterException;

public class SaveDatabaseFactory {
	
	private static SaveDatabaseFactory instance;

	private SaveDatabaseFactory() {
	}
	
	public static SaveDatabaseFactory getInstance() {
		
		if (instance == null) {
			instance = new SaveDatabaseFactory();
		}
		
		return instance;	
	}
	
	public ISaveDatabaseAdapter getDatabaseAdapter(String databaseUsed) throws AdapterException{
		ISaveDatabaseAdapter database;
		
		if (databaseUsed.equals("txt")) {
			database = new TxtSaveDatabaseAdapter();
		}
		
		else {
			database = null;
			throw  new AdapterException(databaseUsed);
		}
		
		return database;
		
	}

}
