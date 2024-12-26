package 메서드개념;

class Ex01{
	void setValue(int x) {
		x = 100;
	}
}

public class _04메서드메모리그림1 {

	public static void main(String[] args) {

		int x = 56;
		
		Ex01 e = new Ex01();
		e.setValue(x);
		System.out.println(x);
		
//		int y = 20;
//		int z = y;
//		z  = 100;
	}

}
