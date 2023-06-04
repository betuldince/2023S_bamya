package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.StartingHandler;

class PlayerCountTests {

	@Test
	void validPlayerCount() {		
		StartingHandler handler = StartingHandler.getHandler();
		boolean result = handler.validatePlayerInput("1");
		assertEquals(true, result, "1 should be a valid player count");
		
		// edge cases
		boolean result2 = handler.validatePlayerInput("0");
		assertEquals(true, result2, "0 should be a valid player count");
		boolean result3 = handler.validatePlayerInput("5");
		assertEquals(true, result3, "0 should be a valid player count");

	}
	
	@Test
	void invalidPlayerCount() {		
		StartingHandler handler = StartingHandler.getHandler();
		boolean result = handler.validatePlayerInput("10");
		assertEquals(false, result, "10 should be an invalid player count");
		
		// edge cases
		boolean result2 = handler.validatePlayerInput("6");
		assertEquals(false, result2, "6 should be an invalid player count");
		boolean result3 = handler.validatePlayerInput("-1");
		assertEquals(false, result3, "-1 should be an invalid player count");

	}
	
	@Test
	void validComputerCount() {		
		StartingHandler handler = StartingHandler.getHandler();
		boolean result = handler.validateComputerInput("3", 2);
		assertEquals(true, result, "3 should be a valid computer count given 2 player count");
		
		// edge cases
		boolean result2 = handler.validateComputerInput("1", 1);
		assertEquals(true, result2, "1 should be a valid computer count given 1 player count");
		boolean result3 = handler.validateComputerInput("2", 0);
		assertEquals(true, result3, "2 should be a valid computer count given 0 player count");
		
		boolean result4 = handler.validateComputerInput("5", 1);
		assertEquals(true, result4, "5 should be a valid computer count given 1 player count");
		boolean result5 = handler.validateComputerInput("6", 0);
		assertEquals(true, result5, "6 should be a valid computer count given 0 player count");

	}
	
	@Test
	void invalidCompCount() {		
		StartingHandler handler = StartingHandler.getHandler();
		
		boolean result0 = handler.validateComputerInput("9", 0);
		assertEquals(false, result0, "9 should be an invalid computer count given 0 player count");
		boolean result1 = handler.validateComputerInput("9", 1);
		assertEquals(false, result1, "9 should be an invalid computer count given 1 player count");
		
		// edge cases
		boolean result2 = handler.validateComputerInput("0", 1);
		assertEquals(false, result2, "0 should be an invalid computer count given 1 player count");
		boolean result3 = handler.validateComputerInput("1", 0);
		assertEquals(false, result3, "1 should be an invalid computer count given 0 player count");
		
		boolean result4 = handler.validateComputerInput("6", 1);
		assertEquals(false, result4, "6 should be an invalid computer count given 1 player count");
		boolean result5 = handler.validateComputerInput("7", 0);
		assertEquals(false, result5, "7 should be an invalid computer count given 0 player count");

	}
	
	@Test
	void invalidInput() {		
		StartingHandler handler = StartingHandler.getHandler();
		
		boolean result1 = handler.validatePlayerInput("abc");
		assertEquals(false, result1, "abc should be an invalid player input");
		boolean result2 = handler.validatePlayerInput(" ");
		assertEquals(false, result2, "\" \" should be an invalid player input");
		boolean result3 = handler.validatePlayerInput("");
		assertEquals(false, result3, "\"\" should be an invalid player input");
		
		boolean result4 = handler.validateComputerInput("abc", 0);
		assertEquals(false, result4, "abc should be an invalid computer input");
		boolean result5 = handler.validateComputerInput("", 1);
		assertEquals(false, result5, "\"\" should be an invalid computer input");
		boolean result6 = handler.validateComputerInput(" ", 1);
		assertEquals(false, result6, "\" \" should be an invalid computer input");


	}
}
