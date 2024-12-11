package 조건문개념;

public class _01조건문 {

	public static void main(String[] args) {

		/*
		 * [제어문] : 코드의 흐름을 제어한다. (조건문-건너뛰기 / 반복문-되돌리기)
		 * 
		 * 조건문 : 조건이 참이면 실행, 거짓이면 실행X
		 * 조건식 : 비교 연산자, 논리 연산자 사용 -> boolean 값만 허용		
		 * 	if(조건식) {조건문 영역}
		 */
		
		int num = 10;
		
		System.out.println("1");
		
		if(num == 10) {
			System.out.println("2");
		}
		System.out.println("3");
		
		if(num == 9) {
			System.out.println("4");
		}
		System.out.println("5");
		
	}

}
