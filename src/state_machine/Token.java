package state_machine;

public abstract class Token {
	
	public abstract Calculator evaluate(Calculator cal, char c);
	
	Calculator calculateTotal(Calculator cal) {
		return cal;
	}

}
