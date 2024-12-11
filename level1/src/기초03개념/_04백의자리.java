package 기초03개념;

public class _04백의자리 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 		아래 변수 a의 값이 100의 자리가 3이면,
		 * 		true를 출력하시오.
		 */
		
		int a = 3340;
		
		boolean result = (a / 100 - 3) % 10 == 0;
		System.out.println(result);
		
		boolean result2 = a%1000/100 == 3;
		System.out.println(result2);
		
		boolean result3 = a/100%10 == 3;
		System.out.println(result3);
		
		
		
	}

}
