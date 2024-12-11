package 배열3문제;

import java.util.Scanner;

public class _01틱택토 {

	public static void main(String[] args) {

		/*
		 	=== 틱택토 ===
		 	[X][X][O]
		 	[ ][O][ ]
		 	[ ][ ][ ]
		 	[p1]인덱스 입력 : 6 
		 	=== 틱택토 ===
		 	[X][X][O]
		 	[ ][O][ ]
		 	[O][ ][ ]
			[p1] 승리
		 */
		Scanner sc = new Scanner(System.in);
		int size = 9;
		int[] game = new int[size];
		int turn = 1;
		int endCnt = 0;
		boolean win = false;
		System.out.println("=== 틱택토 ===");
		while (endCnt != size) {
			for (int i = 0; i < size; i++) {
				System.out.print(game[i] == 2 ? "[X]" : game[i] == 1 ? "[O]" : "[ ]");
				System.out.print(i % 3 == 2 ? "\n" : "");
			}
			if(win) {
				break;
			}
			System.out.println("[player " + turn + " 턴]");
			System.out.print("인덱스(1-9) >> ");
			int idx = sc.nextInt() - 1;
			if (idx < 0 || idx > 8) {
				System.out.println("인덱스 범위 오류");
				continue;
			}
			if (game[idx] != 0) {
				System.out.println("이미 놓아진 자리입니다");
				continue;
			}
			game[idx] = turn == 1 ? 1 : 2;
			for (int i = 0; i < 3; i++) {
				if ((game[i] == turn && game[i + 3] == turn && game[i + 6] == turn)
						|| (game[i * 3] == turn && game[i * 3 + 1] == turn && game[i * 3 + 2] == turn)
						|| (i != 2 && game[i * 2] == turn && game[4] == turn && game[8 - (i * 2)] == turn)) {
					win = true;
				}
			}
			if(!win) {
				turn = turn == 1 ? 2 : 1;
				endCnt++;
			}
		}
		System.out.println(endCnt == 9 ? "무승부" : "[p" + turn + " 승리]");
		
		
		
		
		size = 9;
		game = new int[size];
		turn = 1;
		int line = 3;
		endCnt = 0;
		win = false;

		System.out.println("=== 틱택토 ===");
		while (true) {
			for (int i = 0; i < size; i++) {
				if (game[i] == 1) {
					System.out.print("[X]");
				} else if (game[i] == 2) {
					System.out.print("[O]");
				} else {
					System.out.print("[ ]");
				}
				if (i % 3 == 2) {
					System.out.println();
				}
			}
			if (win) {
				System.out.println("[p" + turn + " 승리]");
				break;
			}
			if (endCnt == 9) {
				System.out.println("무승부");
				break;
			}
			System.out.println("[player " + turn + " 턴]");
			System.out.print("인덱스(1-9) >> ");
			int idx = sc.nextInt() - 1;
			if (idx < 0 || idx > 8) {
				System.out.println("인덱스 범위 오류");
				continue;
			}
			if (game[idx] != 0) {
				System.out.println("이미 놓아진 자리입니다");
				continue;
			}
			System.out.println();
			if (turn == 1) {
				game[idx] = 2;
			} else {
				game[idx] = 1;
			}
			for (int i = 0; i < line; i++) {
				if (game[i] == turn && game[i + 3] == turn && game[i + 6] == turn) {
					win = true;
					break;
				}
			}
			for (int i = 0; i < size; i += line) {
				if (game[i] == turn && game[i + 1] == turn && game[i + 2] == turn) {
					win = true;
					break;
				}
			}
			if (game[2] == turn && game[4] == turn && game[6] == turn) {
				win = true;
			}
			if (game[0] == turn && game[4] == turn && game[8] == turn) {
				win = true;
			}
			if (win) {
				continue;
			}
			turn = game[idx];
			endCnt++;
		}
		sc.close();
	}

}
