package domain;

public class Start {
	
	String input;
	int playerCount = -1;
	int computerCount = -1;
	boolean result = false;
	
	
	public Start(String input) {
		this.input = input;
		if (isValidInput()) {
			setPlayerCount();
		}
		setResult(isValidInput() && isValidPlayerCount());
	}
	
	public Start(String input, int playerCount) {
		this.input = input;
		this.playerCount = playerCount;

		if (isValidInput()) {
			setComputerCount();
		}
		
		setResult(isValidInput() && isValidComputerCount());
		
	}

	private boolean isValidPlayerCount() {
		boolean isValidPlayerCount = true;
		
        if (playerCount < 0 || playerCount > 5) {
            isValidPlayerCount = false;
        }
		return isValidPlayerCount;
	}
	
	private boolean isValidComputerCount() {
		int noPlayers = (playerCount == 0 ? 1 : 0);
		boolean isValidComputerCount = true;

        if (computerCount < 1 + noPlayers || computerCount > 6-playerCount) {
        	isValidComputerCount = false;
        }
        
		return isValidComputerCount;
	}

	protected boolean isValidInput() {
		boolean isValidInput = true;
        // Attempt to parse input as an integer
        try {
            Integer.parseInt(input);
            
        } catch (NumberFormatException e) {
            // Input was not a valid integer
        	isValidInput = false;
        }
                
		return isValidInput;
	}
	
	
	private void setComputerCount() {
		this.computerCount = Integer.parseInt(input);
	}

	private void setPlayerCount() {
		this.playerCount = Integer.parseInt(input);
	}

	private void setResult(boolean b) {
		this.result = b;	
	}
	
	protected boolean getResult() {
		return result;
	}

	public int getPlayerCount() {
		if (result) {
			return this.playerCount;
		}
		else {
			return -1;
		}
	}

	public int getComputerCount() {
		if (result) {
			return this.computerCount;
		}
		else {
			return -1;
		}
	}

	public static int getMinComputerPlayers(int playerCount) {
		return playerCount == 0 ? 2 : 1;
	}

	public static int getMaxComputerPlayers(int playerCount) {
		
		return 6-playerCount;
	}

}
