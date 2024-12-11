package _레벨3시험;

import java.util.Scanner;

public class _07문제 {

	public static void main(String[] args) {

		/*
		 	[문제] 틱택토
		 */
		Scanner sc = new Scanner(System.in);
		int[] game = new int[9];
		int turn = 1;
		int cnt = 0;
		boolean win = false;
		while (true) {
			System.out.println("=== 틱택토 ===");
			for (int i = 0; i < game.length; i++) {
				System.out.print(game[i] == 0 ? "[ ]" : game[i] == 1 ? "[O]" : "[X]");
				System.out.print(i % 3 == 2 ? "\n" : "");
			}
			if (win) {
				turn = turn == 1 ? 2 : 1;
				System.out.print("[p" + turn + "] 승리");
				break;
			}
			if (cnt == 9) {
				System.out.println("무승부");
				break;
			}
			System.out.print("[p" + turn + "] 인덱스 입력 : ");
			int idx = sc.nextInt();
			if (idx < 0 || idx > 8) {
				System.out.println("인덱스 범위 오류");
				continue;
			}
			if (game[idx] != 0) {
				System.out.println("이미 놓아진 자리입니다");
				continue;
			}
			game[idx] = turn;
			for (int i = 0; i < 3; i++) {
				if (game[i * 3] == turn && game[i * 3 + 1] == turn && game[i * 3 + 2] == turn
						|| game[i] == turn && game[i + 3] == turn && game[i + 6] == turn
						|| i != 1 && game[i] == turn && game[4] == turn && game[8 - i] == turn) {
					win = true;
				}
			}
			turn = turn == 1 ? 2 : 1;
			cnt++;
		}
		sc.close();
		// 소요 시간 : 12분 01초
	}

}
