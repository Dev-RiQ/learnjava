package 클래스_문제;

import java.util.Scanner;

class TicTacToe {
	int size = 3;
	String[][] game = new String[size][size];
	int turn;
	int win;
}

public class _04틱택토 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		TicTacToe t3 = new TicTacToe();
		int round = 1;

		while (true) {
			System.out.println();
			System.out.println("[1:○ 2:●]");
			for (String[] col : t3.game) {
				for (String row : col) {
					System.out.print(row == null ? "[ ]" : row.equals("0") ? "[○]" : "[●]");
				}
				System.out.println();
			}
			if (round == 1) {
				System.out.println("[ START ]");
			}
			if (round == 10 || t3.win != 0) {
				System.out.println("[ E N D ]");
			}
			if (t3.win != 0) {
				System.out.println("[P" + (t3.turn == 0 ? 1 : 2) + " 승리]");
				break;
			}
			if (round == 10) {
				System.out.println("[비겼다.]");
				break;
			}
			System.out.println("[Player" + (t3.turn == 0 ? 1 : 2) + "]");
			System.out.print("1~9 >>> ");
			int sel = sc.nextInt() - 1;
			if (sel < 0 || sel > 8) {
				System.err.println("입력 오류");
				continue;
			}
			if (t3.game[sel / t3.size][sel % t3.size] != null) {
				System.err.println("이미 놓음");
				continue;
			}
			t3.game[sel / t3.size][sel % t3.size] = t3.turn + "";
			// 가로
			int cnt = 0;
			for (int i = 0; i < t3.size; i++) {
				if (t3.game[sel / t3.size][i] == null) {
					break;
				}
				if (t3.game[sel / t3.size][i].equals((t3.turn + ""))) {
					cnt++;
				}
			}
			if (cnt == 3) {
				t3.win++;
				continue;
			}
			// 세로
			cnt = 0;
			for (int i = 0; i < t3.size; i++) {
				if (t3.game[i][sel % t3.size] == null) {
					break;
				}
				if (t3.game[i][sel % t3.size].equals((t3.turn + ""))) {
					cnt++;
				}
			}
			if (cnt == 3) {
				t3.win++;
				continue;
			}
			// 대각 오른 아래
			if (sel % 2 == 0) {
				cnt = 0;
				for (int i = 0; i < t3.size; i++) {
					if (t3.game[i][i] == null) {
						break;
					}
					if (t3.game[i][i].equals((t3.turn + ""))) {
						cnt++;
					}
				}
				if (cnt == 3) {
					t3.win++;
					continue;
				}
			}
			// 대각 오른 위
			if (sel % 2 == 0) {
				cnt = 0;
				for (int i = 0; i < t3.size; i++) {
					if (t3.game[t3.size - 1 - i][i] == null) {
						break;
					}
					if (t3.game[t3.size - 1 - i][i].equals((t3.turn + ""))) {
						cnt++;
					}
				}
				if (cnt == 3) {
					t3.win++;
					continue;
				}
			}
			t3.turn = t3.turn == 0 ? 1 : 0;
			round++;
		}
		sc.close();
	}

}
