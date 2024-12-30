package 메서드문제;

import java.util.Scanner;

class TicTacToe {

	Scanner sc = new Scanner(System.in);

	String[][] game;
	final int SIZE = 3;
	int turn;
	int cnt;
	boolean isWin;

	void init() {
		game = new String[SIZE][SIZE];
		turn = 1;
	}

	void showMap() {
		System.out.printf("[Player%d] \n", turn);
		for (String[] col : game) {
			for (String row : col)
				System.out.printf("[%s]", row == null ? " " : row.equals("2") ? "○" : "●");
			System.out.println();
		}
	}

	void turnChange() {
		turn = turn == 1 ? 2 : 1;
		cnt++;
	}

	int[] getValue() {
		while (true) {
			System.out.print("1~9입력>");
			int value = sc.nextInt() - 1;
			if (value < 0 || value > 8)
				System.out.println("존재하지 않는 범위");
			else
				return setIdxs(value);
		}
	}
	
	int[] setIdxs(int value) {
		int[] idxs = new int[2];
		idxs[0] = value / 3;
		idxs[1] = value % 3;
		return idxs;
	}

	void checkMap(int[] idxs) {
		int y = idxs[0];
		int x = idxs[1];
		if (game[y][x] == null)
			game[y][x] = turn + "";
		else {
			System.out.println("이미 놓아진 자리");
			turnChange();
		}
	}

	void checkWin(int[] idxs) {
		int y = idxs[0];
		int x = idxs[1];
		if (checkRow(y) || checkCol(x) || checkRightDiagonal() || checkLeftDiagonal()) {
			isWin = true;
		}
	}

	boolean checkRow(int y) {
		for (int i = 0; i < SIZE; i++)
			if (game[y][i] == null || !game[y][i].equals(turn + ""))
				return false;
		return true;
	}

	boolean checkCol(int x) {
		for (int i = 0; i < SIZE; i++)
			if (game[i][x] == null || !game[i][x].equals(turn + ""))
				return false;
		return true;
	}

	boolean checkRightDiagonal() {
		for (int i = 0; i < SIZE; i++)
			if (game[i][i] == null || !game[i][i].equals(turn + ""))
				return false;
		return true;
	}

	boolean checkLeftDiagonal() {
		for (int i = 0; i < SIZE; i++)
			if (game[SIZE - 1 - i][i] == null || !game[SIZE - 1 - i][i].equals(turn + ""))
				return false;
		return true;
	}

	void gameEnd() {
		turnChange();
		showMap();
		if (isWin)
			System.out.printf("Player%d승", turn);
		else
			System.out.println("[무승부;]");
	}

	boolean isEnd() {
		boolean check = cnt == 9 || isWin;
		if (!check)
			return false;
		return true;
	}

	void run() {
		init();
		while (!isEnd()) {
			showMap();
			int[] idxs = getValue();
			checkMap(idxs);
			checkWin(idxs);
			turnChange();
		}
		gameEnd();
		sc.close();
	}
}

public class _12메서드틱택토 {

	public static void main(String[] args) {

		TicTacToe t = new TicTacToe();

		t.run();
	}

}
