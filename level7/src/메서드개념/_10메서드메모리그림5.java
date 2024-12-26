package 메서드개념;

class Test06 {
	int result;
	void plus(int a, int b) {
		result = a+b;
	}
}

class Test07 {
	int plus(int a, int b) {
		return a+b;
	}
}

public class _10메서드메모리그림5 {

	public static void main(String[] args) {

		Test06 e6 = new Test06();
		Test07 e7 = new Test07();
		
		e6.plus(10, 3);
		System.out.println(e6.result);
		
		System.out.println("-------------");
		
		int result = e7.plus(10, 3);
		System.out.println(result);
	}

}
