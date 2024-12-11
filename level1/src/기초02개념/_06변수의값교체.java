package 기초02개념;

public class _06변수의값교체 {

	public static void main(String[] args) {

		int a = 5;
		int b = 7;
		System.out.printf("a = %d, b = %d \n", a ,b);
		
		int c = a;
		a = b;
		b = c;
		System.out.printf("a = %d, b = %d \n", a ,b);
	
		
	}

}
