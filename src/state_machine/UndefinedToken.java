package state_machine;

public class UndefinedToken extends Token {

	@Override
	public Calculator evaluate(Calculator cal, char c) {
		throw new StateErrors(c).unknowCharacter();
	}
	
	@Override
	Calculator calculateTotal(Calculator cal) {
		cal.t = cal.n;
		return cal;
	}
	
}
