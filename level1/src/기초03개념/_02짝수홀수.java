package 기초03개념;

public class _02짝수홀수 {

	public static void main(String[] args) {

		/*
		 * 짝수 : 2의 배수
		 * 홀수 : 2의 배수가 아님
		 * 
		 * 2의 배수 : 2로 나눠서 나머지 0
		 */
		
		int a = 10;
		int b = 11;
		
		System.out.println(a + "은 짝수인가? " + (a % 2 == 0));
		System.out.println(b + "은 짝수인가? " + (b % 2 == 0));
		
		System.out.println(a + "은 홀수인가? " + (a % 2 == 1));
		System.out.println(b + "은 홀수인가? " + (b % 2 != 0));
		
	}

}
