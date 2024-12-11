package 기초03개념;

public class _05백의자리약수 {

	public static void main(String[] args) {

		// 약수
		/*
		 * [문제]
		 * 		아래 변수의 a 값이
		 * 		10의 자리가 45의 약수이면, true를 출력하시오.
		 */
		
		int a = 3240;
		boolean result = 45%(a/10%10) == 0;
		
		
		System.out.println(result);
		
		
		
	}

}
