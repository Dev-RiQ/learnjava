package 콜랙션리스트;

public class Seat {

	private int num;
	private boolean taken;
	Seat(int num) {
		setNum(num);
	}
	public int getNum() {
		return num;
	}
	public boolean isTaken() {
		return taken;
	}
	private void setNum(int num) {
		this.num = num;
	}
	void setTaken(boolean taken) {
		this.taken = taken;
	}
	
}
