package state_machine;

public class SpaceToken extends Token {
	
	@Override
	public Calculator evaluate(Calculator cal, char c) {
		return cal;
	}

}
