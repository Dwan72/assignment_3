package timeClass;

public class State {
    private char c;
    private int num;
    private int total;

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
        this.num = 10 * this.num + this.c;
    }
    public void subTotal() {
        this.total = this.total - this.num;
    }
    public void addTotal() {
        this.total = this.total + this.num;
    }

    public void errorState() {
        System.out.println("Invalid input");
        java.lang.System.exit(1);
    }

}
