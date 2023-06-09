package domain.saveLoad;

public class SaveLoadHandler {
	
	private static SaveLoadHandler handler;

	private SaveLoadHandler() {
	}
	
	public static SaveLoadHandler getHandler() {
		
		if (handler == null) {
			handler = new SaveLoadHandler();
		}
		
		return handler;	
	}
	
	
	public boolean save() {
		Save save = new Save();
		return save.success();
	}
}
