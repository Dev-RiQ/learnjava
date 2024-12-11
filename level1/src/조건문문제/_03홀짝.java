package 조건문문제;

import java.util.Scanner;

public class _03홀짝 {

	public static void main(String[] args) {

		/*
		 * 사용자에게 정수 한개 입력 받아서
		 * 홀수면 홀수 짝수면 짝수를 출력하시오
		 */
		
		Scanner scan = new Scanner(System.in);

		System.out.print("정수를 입력하세요 >> ");

		int num = scan.nextInt();

		if (num % 2 == 0) {
			System.out.println("짝수");
		}
		if (num % 2 != 0) {
			System.out.println("홀수");
		}

		scan.close();
		
	}

}
