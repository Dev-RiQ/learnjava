package 조건문문제;

public class _01조건문연습 {

	public static void main(String[] args) {

		// 문제 1) 양수, 0 ,음수 출력
		int num1 = -10;

		if (num1 > 0) {
			System.out.println("양수");
		}
		if (num1 == 0) {
			System.out.println("0");
		}
		if (num1 < 0) {
			System.out.println("음수");
		}

		// 문제 2) 4의 배수 출력 : 4의 배수입니다. 4의 배수가 아닙니다.
		int num2 = 12;

		if (num2 % 4 == 0) {
			System.out.println("4의 배수입니다.");
		}
		if (num2 % 4 != 0) {
			System.out.println("4의 배수가 아닙니다.");
		}

		// 문제 3) 합격, 불합격 출력 기준 60점 초과
		int num3 = 87;

		if (num3 > 60) {
			System.out.println("합격");
		}
		if (num3 <= 60) {
			System.out.println("불합격");
		}

	}

}
