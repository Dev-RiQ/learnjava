package _레벨1시험;

import java.util.Random;
import java.util.Scanner;

public class _07문제 {

	public static void main(String[] args) {
		/*
	 	[문제]
	 		가운데 숫자 맞추기 게임
	 		1. 150~250 사이의 랜덤 숫자 저장
	 		2. 랜덤 숫자의 가운데 숫자를 맞추는 게임
	 */

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int com = rd.nextInt(101) + 150;

		System.out.print("0~9 사이의 정수를 입력하세요 >> ");
		int me = sc.nextInt();

		int com10 = com / 10 % 10;

		if (me < 0 || me > 9) {
			System.out.println("오류 : 0~9 사이를 입력하세요.");
		} else {
			System.out.printf("이번 숫자 : %d \n내 선택 : %d\n", com, me);
			if (me == com10) {
				System.out.println("정답");
			} else {
				System.out.println("오답");
			}
		}
		sc.close();
		// 시간 : 3분 33초
	}

}
