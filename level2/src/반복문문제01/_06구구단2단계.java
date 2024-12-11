package 반복문문제01;

import java.util.Random;
import java.util.Scanner;

public class _06구구단2단계 {

	public static void main(String[] args) {

		/*
		 	구구단게임
		 	1. 구구단 게임을 5회반복한다.
		 	2. 정답을 맞추면 개당 20점이다.
		 	3. 게임 종료 후, 성적을 출력한다.
		 */

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

//		int cntO = 0;
//		int cntX = 0;
//		
//		while (cntO + cntX < 5) {
//			int rd1 = rd.nextInt(8) + 2;
//			int rd2 = rd.nextInt(9) + 1;
//			System.out.printf("%d X %d = ", rd1, rd2);
//
//			int ans = sc.nextInt();
//
//			if (ans == rd1 * rd2) {
//				System.out.println("정답");
//				cntO += 1;
//			} else {
//				System.out.println("오답");
//				cntX += 1;
//			}
//		}
//		System.out.println("성적 : " + (20 * cntO) + "점");

		
		int i = 1;
		int score = 0;

		while (i <= 5) {
			int rd1 = rd.nextInt(8) + 2;
			int rd2 = rd.nextInt(9) + 1;
			System.out.printf("[ %d ] %d X %d = ", i, rd1, rd2);

			int ans = sc.nextInt();

			if (ans == rd1 * rd2) {
				System.out.println("정답");
				score += 20;
			} else {
				System.out.println("오답");
			}
			i += 1;
		}
		System.out.println("성적 : " + score + "점");

		sc.close();
	}

}
