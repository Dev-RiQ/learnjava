package 스태틱카드;

public class Card {

	private static int garoSize = 150;
	private static int seroSize = 200;

	private static String[] shapes = { "♥", "◆", "♣", "♠" };

	private String shape;
	private int num;

	Card(String shape, int num) {
		this.shape = shape;
		this.num = num;
	}

	static int getGaroSize() {
		return garoSize;
	}

	static int getSeroSize() {
		return seroSize;
	}

	static String[] getShapes() {
		return shapes;
	}

	static void setGaroSize(int garoSize) {
		Card.garoSize = garoSize;
	}

	static void setSeroSize(int seroSize) {
		Card.seroSize = seroSize;
	}

	static void setShapes(String[] shapes) {
		Card.shapes = shapes;
	}

	String getShape() {
		return shape;
	}

	int getNum() {
		return num;
	}

	void setShape(String shape) {
		this.shape = shape;
	}

	void setNum(int num) {
		this.num = num;
	}
	
	String setToString() {
		String msg = shape + " ";
		if(num == 1)
			msg += "A";
		else if(num == 11)
			msg += "J";
		else if(num == 12)
			msg += "Q";
		else if(num == 13)
			msg += "K";
		else
			msg += num;
		return msg;
	}

	@Override
	public String toString() {
		return setToString();
	}

}
