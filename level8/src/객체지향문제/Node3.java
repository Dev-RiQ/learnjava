package 객체지향문제;

public class Node3 {
	private String mark;

	Node3(String mark) {
		this.mark = mark;
	}

	 String getMark() {
		return mark;
	}

	 void setMark(String mark) {
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return "[" + mark + "]";
	}
}
