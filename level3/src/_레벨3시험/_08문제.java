package _레벨3시험;

import java.util.Scanner;

public class _08문제 {

	public static void main(String[] args) {

		/*
		 	[문제] 미니마블
		 */
		Scanner sc = new Scanner(System.in);
		int[] game = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] p1 = new int[8];
		int[] p2 = new int[8];
		int turn = 1;
		int idx1 = 0;
		int idx2 = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		p1[0] = 1;
		p2[0] = 2;
		while (true) {
			System.out.printf("p1 : %d바퀴   p2 : %d바퀴\n", cnt1, cnt2);
			for (int i = 0; i < game.length; i++) {
				System.out.print(game[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < game.length; i++) {
				System.out.print(p1[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < game.length; i++) {
				System.out.print(p2[i] + " ");
			}
			System.out.println();
			int cnt = cnt1 > cnt2 ? cnt1 : cnt2;
			if (cnt == 3) {
				turn = turn == 1 ? 2 : 1;
				System.out.println("[p" + turn + "] 승리");
				break;
			}
			System.out.print("[p" + turn + "] 1~3 입력 : ");
			int move = sc.nextInt();
			if (move < 1 || move > 3) {
				System.out.println("오류 : 1~3 입력");
				continue;
			}
			if (turn == 1) {
				p1[idx1] = 0;
				idx1 += move;
				if (idx1 > game.length - 1) {
					cnt1++;
					idx1 -= game.length;
				}
				if (idx1 == idx2) {
					System.out.println("p1이 p2를 잡았다!");
					p2[idx2] = 0;
					idx2 = 0;
					p2[idx2] = 2;
				}
				p1[idx1] = turn;
			} else {
				p2[idx2] = 0;
				idx2 += move;
				if (idx2 > game.length - 1) {
					cnt2++;
					idx2 -= game.length;
				}
				if (idx1 == idx2) {
					System.out.println("p2가 p1을 잡았다!");
					p1[idx1] = 0;
					idx1 = 0;
					p1[idx1] = 1;
				}
				p2[idx2] = turn;
			}
			turn = turn == 1 ? 2 : 1;
		}
		sc.close();
		// 소요 시간 : 14분 21초
	}

}
