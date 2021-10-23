package state_machine;

import java.util.Scanner;

import state_machine.CharacterType.IpType;

public class CalculatorStateMachine {

	public static void main(String[] args) {
		String input = readEquation();
		System.out.println(input);
		int t;
		try {
			t = calculate(input, 0, 0, 0, 0);
			System.out.println("Total is: " + t);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static String readEquation() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the equation: ");
		String str = sc.nextLine();
		sc.close();
		return str;
	}

	public static int calculate(String input, int i, int t, int n, int operator) throws RuntimeException {
		if (i == input.length()) {
			if (n == 0) {
				throw StateErrors.invalidEndOfExpression((char) operator);
			}

			t = calculateTotal(t, n, operator);
			n = 0;
			System.out.println("t ==> " + t + " n ==> " + n);
			System.out.println();
			System.out.println();
			return t;
		}

		char c = input.charAt(i);
		int ip = c;
		IpType tp = CharacterType.get(ip);
		switch (tp) {

		case ONE_TO_NINE:
			n = n * 10 + Character.getNumericValue(c);
			break;

		case ZERO:
			if (n == 0) {
				throw StateErrors.invalidStartOfNumber('0');
			}
			n = n * 10 + Character.getNumericValue(c);
			break;

		case ADD:
		case SUB:
			if (n == 0) {
				if (operator == 0) {
					throw StateErrors.invalidStartOfExpression(c);
				}
				// if (t == 0) {
				// Start with operator
				// }
				// double operator
				throw StateErrors.invalidStartOfNumber(c);
			}

			t = calculateTotal(t, n, operator);
			operator = ip;
			n = 0;
			break;

		case UNDEFINED:
			// show error
			throw StateErrors.unknowCharacter(c);

		}
		// System.out.println(ip + " ==> " + c);

		System.out.println("t ==> " + t + " n ==> " + n);

		return calculate(input, i + 1, t, n, operator);
	}

	static int calculateTotal(int t, int n, int operator) {
		switch (CharacterType.get(operator)) {
		case ADD:
			t += n;
			break;
		case SUB:
			t -= n;
			break;
		case UNDEFINED:
			t = n;
			break;
		}
		return t;
	}

}
