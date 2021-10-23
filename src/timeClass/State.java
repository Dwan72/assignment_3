package timeClass;
import java.util.ArrayList;

public class State {
    private char c;
    private int num;
    private int total;

    private ArrayList<String> plusMinus = new ArrayList<>();

    State() {
        this.num = 0;
        this.total = 0;
    }

    public void setC(char c) {
        this.c = c;
    }
    public char getC() {
        return this.c;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public int getNum() {
        return this.num;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return this.total;
    }

    public void ascendNum() {
        this.num = 10 * this.num + Character.getNumericValue(this.c);
    }
    public void subTotal() {
        this.total = this.total - this.num;
    }
    public void addTotal() {
        this.total = this.total + this.num;
    }
    public void operate(String operation) {
        switch (operation) {
            case "+":
                this.total = this.total + this.num;
                break;
            case "-":
                this.total = this.total - this.num;
                break;
        }
        return;
    }

    //plusMinus stack
    public String popPlusMinus() {
        if (this.plusMinus.isEmpty()) {
            return null;
        }
        String top = this.plusMinus.get(this.plusMinus.size() - 1);
        this.plusMinus.remove(this.plusMinus.size() - 1);
        return top;
    }
    public void pushPlusMinus(String element) {
        this.plusMinus.add(element);
    }
    public boolean isEmptyPlusMinus() {
        return this.plusMinus.isEmpty();
    }

    public int size() {
        return this.plusMinus.size();
    }

    public void successState() {
        System.out.println("Result: " + this.total);
        java.lang.System.exit(0);
    }
    public void errorState() {
        System.out.println("Invalid input");
        java.lang.System.exit(1);
    }

}
