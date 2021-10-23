package state_machine;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorStateMachineTest {

	@Test
	public void validTests() {
		String inputs[] = {"1+2", "1-2", "10+5-2", "9+10+10-2", "1+2+3+4+5+6+7+8+9+10"};
		int ops[] = {3, -1, 13, 27, 55};
		for (int i = 0; i < inputs.length; i++) {
			int t = 0;
			try {
				t = CalculatorStateMachine.calculate(inputs[i], 0, 0, 0, 0);
			} catch (RuntimeException e) {
				// e.printStackTrace();
			}
			assertEquals(t,ops[i]);
		}
	}
	
	@Test
	public void invalidStart() {
		String inputs[] =  {"01+2", "1+02", "+2", "-2"};
		RuntimeException ops[] = {
				StateErrors.invalidStartOfNumber('0'),
				StateErrors.invalidStartOfNumber('0'), 
				StateErrors.invalidStartOfExpression('+'), 
				StateErrors.invalidStartOfExpression('-'),
		};
		for (int i = 0; i < inputs.length; i++)
		try {
			CalculatorStateMachine.calculate(inputs[i], 0, 0, 0, 0);
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), ops[i].getMessage());
		}
	}
	
	@Test
	public void endWithAdd() {
		String input = "2+";
		try {
			CalculatorStateMachine.calculate(input, 0, 0, 0, 0);
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), StateErrors.invalidEndOfExpression('+').getMessage());
		}
	}
	
	@Test
	public void endWithSub() {
		String input = "2-";
		try {
			CalculatorStateMachine.calculate(input, 0, 0, 0, 0);
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), StateErrors.invalidEndOfExpression('-').getMessage());
		}
	}
	
	@Test
	public void doubleOperators() {
		String inputs[] = {"1++", "2--", "3+-", "4-+"};
		char operators[] = {'+', '-', '-', '+'};
		for (int i = 0; i < inputs.length; i++) {
			try {
				CalculatorStateMachine.calculate(inputs[i], 0, 0, 0, 0);
			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), StateErrors.invalidStartOfNumber(operators[i]).getMessage());
			}
		}
	}
	
	@Test
	public void unknowChar() {
		String inputs[] = {"10.3", "*", "a+2"};
		char operators[] = {'.', '*', 'a'};
		for (int i = 0; i < inputs.length; i++) {
			try {
				CalculatorStateMachine.calculate(inputs[i], 0, 0, 0, 0);
			} catch (RuntimeException e) {
//				System.out.println("MSG ===>" + e.getMessage() + expected);
				assertEquals(e.getMessage(), StateErrors.unknowCharacter(operators[i]).getMessage());
			}
		}
	}

}
