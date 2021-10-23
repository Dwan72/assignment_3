package state_machine;

public class ZeroToken extends Token {
	
	@Override
	public Calculator evaluate(Calculator cal, char c) {
		if (cal.n == 0) {
			throw new StateErrors('0').invalidStartOfNumber();
		}
		cal.n = cal.n * 10 + Character.getNumericValue(c);
		return cal;
	}

}
