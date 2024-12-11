package 배열심화3;

import java.util.Random;
import java.util.Scanner;

public class _01빙고 {

	public static void main(String[] args) {

		/*
		 	1~50 랜덤숫자 25개 중복없이 배치
		 	행과 열 입력받아 숫자 선택
		 	가로 세로 대각선 한줄이면 빙고
		 */
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int maxMatch = 5;
		int maxNum = 50;
		int[][] bingo = new int[maxMatch][maxMatch];
		int[][] mark = new int[maxMatch][maxMatch];
		boolean[] check = new boolean[maxNum + 1];
		boolean gameEnd = false;
		for (int i = 0; i < maxMatch; i++) {
			for (int k = 0; k < maxMatch; k++) {
				bingo[i][k] = rd.nextInt(50) + 1;
				if (check[bingo[i][k]]) {
					k--;
					continue;
				}
				check[bingo[i][k]] = true;
			}
		}
		while (true) {
			System.out.println("     ①    ②    ③    ④    ⑤");
			for (int i = 0; i < maxMatch; i++) {
				System.out.print(i == 0 ? "①" : i == 1 ? "②" : i == 2 ? "③" : i == 3 ? "④" : "⑤");
				System.out.print(" ");
				for (int k = 0; k < maxMatch; k++) {
					System.out.print(check[bingo[i][k]]
							? bingo[i][k] < 10 ? "[ " + bingo[i][k] + "  ]" : "[ " + bingo[i][k] + " ]"
							: "[ ○  ]");
				}
				System.out.println();
			}
			if (gameEnd) {
				System.out.println("게임 종료");
				break;
			}
			int idx1 = -1;
			int idx2 = -1;
			for (int i = 0; i < 2; i++) {
				System.out.print(i == 0 ? "행" : "열");
				System.out.print(" 번호 입력 >> ");
				int input = sc.nextInt() - 1;
				if (input < 0 || input > 4) {
					System.out.println("없는 번호입니다.");
					i--;
					continue;
				}
				if (i == 0) {
					idx1 = input;
				} else {
					idx2 = input;
				}
			}
			if (check[bingo[idx1][idx2]]) {
				mark[idx1][idx2] = 1;
				check[bingo[idx1][idx2]] = false;
			} else {
				System.out.println("이미 맞춘 번호입니다.");
			}
			for (int i = 0; i < maxMatch; i++) {
			}
			int cnt = 0;
			if (!gameEnd) {
				// 가로
				for (int i = 0; i < maxMatch; i++) {
					cnt = 0;
					for (int k = 0; k < maxMatch; k++) {
						if (mark[i][k] != 0) {
							cnt++;
						}
					}
					if (cnt == maxMatch) {
						gameEnd = true;
						break;
					}
				}
			}
			if (!gameEnd) {
				// 세로
				for (int i = 0; i < maxMatch; i++) {
					cnt = 0;
					for (int k = 0; k < maxMatch; k++) {
						if (mark[k][i] != 0) {
							cnt++;
						}
					}
					if (cnt == maxMatch) {
						gameEnd = true;
						break;
					}

				}

			}
			if (!gameEnd) {
				// 대각 아래
				cnt = 0;
				for (int i = 0; i < maxMatch; i++) {
					if (mark[i][i] != 0) {
						cnt++;
					}
				}
				if (cnt == maxMatch) {
					gameEnd = true;
				}

			}
			if (!gameEnd) {
				// 대각 위
				cnt = 0;
				for (int i = 0; i < maxMatch; i++) {
					if (mark[i][maxMatch - 1 - i] != 0) {
						cnt++;
					}
				}
				if (cnt == maxMatch) {
					gameEnd = true;
				}

			}

		}
		sc.close();
	}

}
