package 객체지향문제;

public class Player {

	private String name;
	private String mark;

	Player(String name, String mark) {
		this.name = name;
		this.mark = mark;
	}

	 String getName() {
		return name;
	}

	 String getMark() {
		return mark;
	}

	 void setName(String name) {
		this.name = name;
	}

	 void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "["+mark+"]";
	}

}
