package state_machine;

public class StateErrors {
	
	char c;
	
	StateErrors(char c) {
		this.c = c;
	}
	
	public RuntimeException invalidEndOfExpression() {
		return new RuntimeException("Error: expression should not end with '" + c + "' try using '1..9'");
	}
	
	public RuntimeException invalidStartOfExpression() {
		return new RuntimeException("Error: expression should not start from '" + c + "' try using '1..9'");
	}
	
	public RuntimeException invalidStartOfNumber() {
		return new RuntimeException("Error: number should not start from '" + c + "' try using '1..9'");
	}
	
	public RuntimeException unknowCharacter() { 
		return new RuntimeException("Error: can not evaluate character '" + c + "'");
	}

}
