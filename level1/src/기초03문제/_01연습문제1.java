package 기초03문제;

public class _01연습문제1 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 	아래 연산의 결과가 모두 true가 출력되도록 변수의 값을 변경하시오.
		 */
		int a = 3;
		int b = 1;
		int c = 1;
		System.out.println(a + b - 3 == c);
		
		a = -1;
		b = 1;
		c = 1;
		System.out.println(a * -b == c);
		
		a = 4;
		b = 1;
		c = 1;
		System.out.println(a + -b * 3 == c);
		
		a = 3;
		b = 2;
		c = 1;
		System.out.println(a % b == c);
		
		a = 3;
		b = 2;
		c = 2;
		System.out.println(a % b + 3 == c * 2);
		
		a = 17;
		b = 5;
		c = 6;
		int d = 4;
		System.out.println(7 * 2 - a == 3 * -2 - -3);
		System.out.println(b * b - 25 == 0);
		System.out.println(3 * c + 2 == 20);
		System.out.println(5 * d == 2 * 10);
		
	}

}
