package state_machine;

public class Calculator {
	
	String input;
	int t = 0, n = 0, operator = 0, i = 0;
	public Calculator(String input) {
		this.input = input;
	}

	public int calculate() throws RuntimeException {
		if (i == input.length()) {
			if (n == 0) {
				throw new StateErrors((char) operator).invalidEndOfExpression();
			}

			Calculator calc = TokenType.getToken(operator).calculateTotal(this);
			calc.n = 0;
			System.out.println("t ==> " + calc.t + " n ==> " + calc.n);
			System.out.println();
			System.out.println();
			return calc.t;
		}

		char c = input.charAt(i);
		int ip = c;
		
//		CharacterType tp = TokenType.get(ip);
		
		Token token = TokenType.getToken(ip);
		Calculator calc = token.evaluate(this, c);

		System.out.println("t ==> " + calc.t + " n ==> " + calc.n);
		calc.i++;
		return calc.calculate();
	}

}
