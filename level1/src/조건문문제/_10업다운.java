package 조건문문제;

import java.util.Random;
import java.util.Scanner;

public class _10업다운 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		1. com은 랜덤 10-90
		 		2. me는 숫자 하나 입력
		 		3. com과 me를 비교해 출력
		 			com>me -> up!
		 			com < me -> down!
		 			com = me -> bingo!
		 */
		
		Scanner sc = new Scanner(System.in);

		System.out.print("10~90 사이의 숫자 하나를 고르시오 >>");
		int me = sc.nextInt();

		Random rd = new Random();

		int com = rd.nextInt(81) + 10;

		boolean input = me <= 90 && me >= 10;

		if (input) {
			System.out.printf("com : %d  me : %d \n", com, me);
			if (com > me) {
				System.out.println("up!");
			}
			if (com == me) {
				System.out.println("bingo!");
			}
			if (com < me) {
				System.out.println("down!");
			}
		}
		if (!input) {
			System.out.println("Error! 10~90 사이의 값을 입력하세요");
		}
		sc.close();
		
	}

}
