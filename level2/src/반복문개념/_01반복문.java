package 반복문개념;

public class _01반복문 {

	public static void main(String[] args) {

		/*
		 	[개념]
		 		제어문 : 코드의 흐름을 제어 ( 건너뛰기 if , 되돌아가기 while / for )
		 		반복 => 1번 이상 실행 : 어디서부터 어디까지 몇번 실행 => 횟수가 있는 반복문
		 		
		 		1. while : ~하는 동안
		 		2. (조건식) => true일때 실행
		 		3. { 반복문 영역 } => true이면 계속 실행 (false 뜰 때 까지)
		 		4. 반복문은 반드시 종료 조건을 만들어야한다. => 무한 반복 방
		 		
		 		반복문 변수 => i j k n => 반복문 안에서 변화하는 변수
		 		
		 		반복문 초기값, 조건식, 증감식이 필요하다.
		 */
		
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);

		System.out.println("===========================");

		int i = 1; // 초기값

		while (i <= 5) { // 조건식
			System.out.println(i);
			i += 1; // 증감식
		}
		System.out.println("===========================");
		System.out.println(i);

		System.out.println("===========================");

		System.out.println(5);
		System.out.println(4);
		System.out.println(3);
		System.out.println(2);
		System.out.println(1);

		System.out.println("===========================");

		i = 5; // 초기값

		while (i >= 1) { // 조건식
			System.out.println(i);
			i -= 1; // 증감식
		}
		System.out.println("===========================");
		System.out.println(i);

	}

}
