package state_machine;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String input = readEquation();
//		System.out.println(input);
		int t;
		try {
			t = new Calculator(input).calculate();
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
}
