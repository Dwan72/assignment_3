package state_machine;

public class StateErrors {
	
	public static RuntimeException invalidEndOfExpression(char c) {
		return new RuntimeException("Error: expression should not end with '" + c + "' try using '1-9'");
	}
	
	public static RuntimeException invalidStartOfExpression(char c) {
		return new RuntimeException("Error: expression should not start from '" + c + "' try using '1-9'");
	}
	
	public static RuntimeException invalidStartOfNumber(char c) {
		return new RuntimeException("Error: number should not start from '" + c + "' try using '1-9'");
	}
	
	public static RuntimeException unknowCharacter(char c) { 
		return new RuntimeException("Error: can not evaluate character '" + c + "'");
	}

}
