package timeClass;

public class State {
	private int total;

    public static State State_of_C() {
        return new State(); 
    }
	
	public void setSum(int c) {
		this.total = this.total + c;
	}
	
	public void setDifference(int c) {
		this.total = this.total - c;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotal() {
		return this.total;
	}
}
