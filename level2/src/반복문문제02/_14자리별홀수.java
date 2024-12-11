package 반복문문제02;

import java.util.Scanner;

public class _14자리별홀수 {

	public static void main(String[] args) {

		/*
		 	1~10000사이의 숫자 입력받고 자리별 홀수의 개수 출력
		 */
		
		Scanner sc = new Scanner(System.in);

		int cnt = 0;
		int input = 0;

		while (true) {
			System.out.print("1~10000사이 숫자 입력 >> ");
			input = sc.nextInt();
			if (input < 1 || input > 10000) {
				System.out.println("입력오류");
				continue;
			}
			break;
		}

		int inputPos = input;

		while (inputPos != 0) {
			if (inputPos % 10 % 2 == 1) {
				cnt += 1;
			}
			inputPos /= 10;
		}
		System.out.println(input + " 홀수 자리 개수 = " + cnt + "개");
		sc.close();
	}

}
