package state_machine;

public class OneToNineToken extends Token {

	@Override
	public Calculator evaluate(Calculator cal, char c) {
		cal.n = cal.n * 10 + Character.getNumericValue(c);
		return cal;
	}
	
}
