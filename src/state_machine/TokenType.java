package state_machine;

public class TokenType {
	 
	public static Token getToken(int ip) {
		
		if (ip == 48) {
			return new ZeroToken();
		}
		
		if (ip >= 49 && ip <= 58) {
			return new OneToNineToken();
		}
		
		if (ip == 43) {
			return new AddToken();
		}
		
		if (ip == 45) {
			return new SubToken();
		}
		
		return new UndefinedToken();
	}

}
