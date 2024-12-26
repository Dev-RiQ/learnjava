package 메서드개념;

class Ex03 {
	int result;
}

class Ex04 {
	void plus(Ex03 data, int x, int y) {
		data.result = x + y;
	}

	void minus(Ex03 data, int x, int y) {
		data.result = x - y;
	}
}

public class _07메서드메모리그림4 {

	public static void main(String[] args) {

		Ex03 e3 = new Ex03();
		Ex04 e4 = new Ex04();

		e4.plus(e3, 10, 3);
		System.out.println(e3.result);

		e4.minus(e3, 10, 3);
		System.out.println(e3.result);
	}

}
