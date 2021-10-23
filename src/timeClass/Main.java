package timeClass;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter an equation: ");
        Scanner sc = new Scanner(System.in);
        String equation = sc.nextLine();

        State myState = new State();

        for (int i = 0; i < equation.length(); i++) {

            char c = equation.charAt(i);

            //initial state
            if (i == 0 && !Character.isDigit(c)) {
                myState.errorState();
            } else if (i == 0 && Character.isDigit(c)) {
                myState.setC(c);
                myState.setNum(myState.getC());
                continue;
            }

            //fail for special characters
            if(!Character.isDigit(c) && c != '+' && c != '-') {
                myState.errorState();
            }

            //if c is a number
            if (Character.isDigit(c) && (myState.getC() == '+' || myState.getC() == '-')) {
                myState.setC(c);
                myState.setNum(myState.getC());
                continue;
            } else if (Character.isDigit(c)) {
                myState.setC(c);
                myState.ascendNum();
                continue;
            }

            //for minuses and pluses when total == 0
            if (myState.getC() == '-' && myState.getTotal() == 0) {
                myState.setTotal(myState.getNum());
                continue;

            } else if (myState.getC() == '+' && myState.getTotal() == 0) {
                myState.setTotal(myState.getNum());
                continue;
            }

            //for minuses and pluses
            if (myState.getC() == '-') {
                myState.setTotal(myState.getTotal() - myState.getNum());

            } else if (myState.getC() == '+') {
                myState.setTotal(myState.getTotal() + myState.getNum());
            }

        }
    }
}
