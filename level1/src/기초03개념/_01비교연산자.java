package 기초03개념;

public class _01비교연산자 {

	public static void main(String[] args) {

		/* 비교 연산자 : 두 값을 비교 (true / false 출력)
		 * 		-a가 b보다 어떤지 비교(먼저쓴게 주체)
		 * 1. 크니? 			a > b   (초과)
		 * 2. 작니? 			a < b	(미만)
		 * 3. 같니? 			a == b
		 * 4. 다르니? 		a != b  (! = not)
		 * 5. 크거나 같니? 	a >= b  (이상) ( 항상 =은 뒤에)
		 * 6. 작거나 같니? 	a <= b	(이하)
		 */
		
		System.out.println(10 > 3);
		System.out.println(10 < 3);
		System.out.println(10 == 3);
		System.out.println(10 != 3);
		System.out.println(10 >= 3);
		System.out.println(10 <= 3);
		System.out.println("----");
		
		int a = 10;
		int b = 3;
		char c = 'a'; // 문자의 숫자코드 정수이기 때문에 가능
		// 비교 연산자보다 산술 연산자가 우선 처리
		System.out.println(a > b);
		System.out.println(a < b + c);
		System.out.println(a == b + 7);
		System.out.println(a != b);
		System.out.println(a >= b);
		System.out.println(a <= b + c);
		
		
		
		
	}

}
