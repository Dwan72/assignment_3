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

            //check for double operators in input
            if ((c == '+' || c == '-') && (myState.getC() == '+' || myState.getC() == '-')){
                myState.errorState();
            }
            myState.setC(c);
            //initial state
            if (i == 0 && !Character.isDigit(c)) {
                myState.errorState();
            } else if (i == 0 && Character.isDigit(c)) {
                myState.setC(c);
                myState.setNum(Character.getNumericValue(myState.getC()));
                continue;
            }

            //final state
            if (i == equation.length() - 1) {
                if (myState.getTotal() == 0) {
                    myState.setTotal(myState.getNum());
                    myState.successState();
                } else {
                    String operation = myState.popPlusMinus();
                    if (myState.getNum() != 0) {
                        myState.ascendNum();
                    } else {
                        myState.setNum(Character.getNumericValue(myState.getC()));
                    }
                    myState.operate(operation);
                    myState.successState();
                }
            }

            //fail for special characters
            if(!Character.isDigit(c) && c != '+' && c != '-') {
                myState.errorState();
            }

            //if c is a number
            if (Character.isDigit(c) && (myState.getC() == '+' || myState.getC() == '-')) {
                myState.setNum(Character.getNumericValue(myState.getC()));
                continue;
            } else if (Character.isDigit(c)) {
                myState.ascendNum();
                continue;
            }

            //for minuses and pluses when total == 0
            if ((myState.getC() == '-' || myState.getC() == '+') && myState.getTotal() == 0) {
                myState.setTotal(myState.getNum());
                myState.setNum(0);
                myState.pushPlusMinus(String.valueOf(c));
                continue;
            }

            //for minuses and pluses
            if (myState.getC() == '-' || myState.getC() == '+') {
                String operation = myState.popPlusMinus();
                myState.operate(operation);
                myState.setNum(0);
                myState.pushPlusMinus(String.valueOf(myState.getC()));
            }

        }
    }
}
