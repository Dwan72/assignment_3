package state_machine;

public class AddToken extends Token {
	
	@Override
	public Calculator evaluate(Calculator cal, char c) {
		if (cal.n == 0) {
			if (cal.operator == 0) {
				throw new StateErrors(c).invalidStartOfExpression();
			}
			// if (t == 0) {
			// Start with operator
			// }
			// double operator
			throw new StateErrors(c).invalidStartOfNumber();
		}

		cal = TokenType.getToken(cal.operator).calculateTotal(cal);
		cal.operator = c;
		cal.n = 0;
		return cal;
	}
	
	@Override
	Calculator calculateTotal(Calculator cal) {
		cal.t += cal.n;
		return cal;
	}

}
