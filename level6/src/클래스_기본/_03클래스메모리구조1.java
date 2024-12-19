package 클래스_기본;

class Sample01 {

	int a;
	int b;
}

public class _03클래스메모리구조1 {

	public static void main(String[] args) {

		Sample01 s1 = new Sample01();
		s1.a = 20;
		
		s1 = new Sample01();
		
		s1.a = 10;
		
		s1 = null;
	}

}
