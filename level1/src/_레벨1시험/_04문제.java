package _레벨1시험;

import java.util.Scanner;

public class _04문제 {

	public static void main(String[] args) {
		/*
	 	[문제]
	 		숫자 2개를 입력받는다. (숫자 15,20 입력)
	 		각각 num1, num2 변수에 저장
	 		출력
	 		두 숫자 교체하고 출력
	 		num1 - num2 출력
	 	[정답]
	 		num1 = 20 , num2 = 15, num1 - num2 = 5
	 */
		
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자 15, 20를 순서대로입력하시오");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		if (num1 != 15 || num2 != 20) {
			System.out.println("값을 요구한 대로 입력하시오.");
		} else {
			System.out.printf("저장 값 num1 = %d num2 = %d\n", num1, num2);

			int num3 = num1;
			num1 = num2;
			num2 = num3;
			System.out.printf("변경 값 num1 = %d num2 = %d\n", num1, num2);

			int diff = num1 - num2;
			System.out.println("num1 - num2 = " + diff);
		}
		sc.close();

		// 시간 : 2분 13초
	}

}
