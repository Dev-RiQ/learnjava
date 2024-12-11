package 기초03문제;

public class _07홀짝배수 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		숫자 1이 3의 배수이면서 짝수이면 true
		 * [문제]
		 * 		숫자 2가 홀수이거나 5의 배수이면 true
		 */
		
		int num1 = 12;
		
		boolean result = num1%2 == 0 && num1%3 == 0;
		System.out.println(result);
		
		int num2 = 50;
		
		boolean result2 = num2%2 == 1 || num2%5 == 0;
		System.out.println(result2);
		
		
		
		
	}

}
