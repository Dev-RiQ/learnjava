package 객체지향문제;

public class Node2 {
	private int num;

	Node2(int num) {
		this.num = num;
	}

	int getNum() {
		return num;
	}

	void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return String.format("[%2d]", num);
	}
}
