package 조건문문제;

import java.util.Random;

public class _18자릿수대결 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1) 10000~90000 사이의 랜덤 숫자 2개 저장
		 		2) 백의자리 숫자 비교해서 더큰 숫자 전체 출력
		 		3) 같으면 "equal" 출력
		 */
		
		Random rd = new Random();

		int num = 0;
		int num1 = rd.nextInt(80001) + 10000;
		int num2 = rd.nextInt(80001) + 10000;

		System.out.printf("num1 : %d num2 : %d\n", num1, num2);

		int num1hund = num1 / 100 % 10;
		int num2hund = num2 / 100 % 10;

		if (num1hund > num2hund) {
			num = num1;
		} else if (num1hund < num2hund) {
			num = num2;
		}
		if (num1hund == num2hund) {
			System.out.println("equal");
		} else if (num1hund < num2hund) {
			num = num2;
			System.out.println("백의 자리가 더 큰 숫자 : " + num);
		}
		
		
		
	}

}
