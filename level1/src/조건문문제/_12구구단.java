package 조건문문제;

import java.util.Random;
import java.util.Scanner;

public class _12구구단 {

	public static void main(String[] args) {

	/*
	 	[문제]
	 	1. 구구단 출제 랜덤 (2~9단)
	 	2. 랜덤에서 받은 숫자를 출력
	 	3. 문제 정답 입력 받기
	 	4. 정답을 비교해 "정답" 또는 "오답" 출력
	 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		int rd1 = rd.nextInt(8) + 2;
		int rd2 = rd.nextInt(9) + 1;
		System.out.printf("%d X %d = ", rd1, rd2);
		int ans = sc.nextInt();

		int multi = rd1 * rd2;
		boolean match = multi == ans;

		if (match) {
			System.out.println("정답");
		}
		if (!match) {
			System.out.println("오답 (정답은 : " + multi + ")");
		}
		sc.close();

	}

}
