package timeClass;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        State calculator = State.State_of_C();

        while(true) {
            System.out.print("Enter +, -, or = ... ");      
            input = in.nextLine();
            char symbol = input.charAt(0);
            
            if(symbol=='=') {
                System.out.println("Answer is: " + calculator.getTotal());
                break;
            }else if(symbol=='-' || symbol=='+') {
                while(true) {
                    System.out.print("Enter a positive, whole number: ");
                    try {
                        int c = Integer.parseInt(in.nextLine());
                        if (symbol=='+') {
                            calculator.setSum(c);
                        }else {
                            calculator.setDifference(c);
                        }
                        break;
                    }catch(Exception invalid_input) {
                        System.out.println("Only positive and whole numbers are allowed. Try again.");
                    }
                }
            }else{
                System.out.println("nly positive and whole numbers are allowed. Try again.");
            }
        }
    }
}

