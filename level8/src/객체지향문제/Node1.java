package 객체지향문제;

public class Node1 {

	private String front;
	private String back;
	private boolean open;
	
	Node1(String front) {
		this.front = front;
	}

	String getFront() {
		return front;
	}

	void setFront(String front) {
		this.front = front;
	}

	String getBack() {
		return back;
	}

	void setBack(String back) {
		this.back = back;
	}

	boolean isOpen() {
		return open;
	}

	void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public String toString() {
		return "[" + (back == null ? " " : back) + "]";
	}

}
