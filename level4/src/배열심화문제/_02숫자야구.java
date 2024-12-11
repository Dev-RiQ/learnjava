package 배열심화문제;

import java.util.Random;
import java.util.Scanner;

public class _02숫자야구 {

	public static void main(String[] args) {

		/*
		 	[문제]
		 		me 에 1~9 사이 숫자 3개 저장(중복 불가)
		 		com과 me를 비교해 정답을 맞출 때 까지 반복
		 		숫자와 자리가 같으면 strike += 1
		 		숫자만 같고 자리가 다르면 ball +=1
		 */
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int[] com = new int[3];
		int[] me = new int[3];
		while (true) {
			for (int i = 0; i < com.length; i++) {
				com[i] = rd.nextInt(9) + 1;
				for (int k = 0; k < i; k++) {
					if (com[i] == com[k]) {
						i--;
						break;
					}
				}
			}
			int round = 1;
			while (true) {
				System.out.println("[ round " + round + " ]");
				int strike = 0, ball = 0;
				for (int i = 0; i < me.length; i++) {
					System.out.print((i + 1) + "번 숫자 >> ");
					int num = sc.nextInt();
					if (num < 1 || num > 9) {
						System.out.println("1~9사이 입력");
						i--;
						continue;
					}
					me[i] = num;
					for (int k = 0; k < i; k++) {
						if (me[i] == me[k]) {
							System.out.println("같은 값 입력 불가");
							i--;
							break;
						}
					}
				}
				for (int i = 0; i < me.length; i++) {
					for (int k = 0; k < me.length; k++) {
						if (me[i] == com[k]) {
							strike += i == k ? 1 : 0;
							ball += i != k ? 1 : 0;
						}
					}
					System.out.print(me[i] + " ");
				}
				System.out.println(" >> " + strike + "s " + ball + "b");
				System.out.println();
				round++;
				if (strike == 3) {
					System.out.println("정답");
					break;
				}
			}
			int sel = 0;
			System.out.println("한판 더?");
			while (true) {
				System.out.println("1.yes 2.no");
				sel = sc.nextInt();
				if (sel != 1 && sel != 2) {
					System.out.println("1,2 중 고르세요");
					continue;
				}
				break;
			}
			if (sel == 1) {
				System.out.println();
				continue;
			}
			break;
		}
		System.out.println("게임종료");
		sc.close();
	}

}
