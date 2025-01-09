package 객체지향문제;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTackToeGame {

	private ArrayList<Player> plist;
	private ArrayList<ArrayList<Node3>> list;
	private Player winner;
	private final int SIZE = 3;

	private void init() {
		setPlayer();
		setMap();
	}

	private void setPlayer() {
		plist = new ArrayList<>();
		plist.add(new Player("player 1", "●"));
		plist.add(new Player("player 2", "○"));
	}

	private void setMap() {
		list = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			list.add(new ArrayList<Node3>());
			for (int k = 0; k < SIZE; k++)
				list.get(i).add(new Node3(" "));
		}
	}

	private void showTurn(int turn) {
		System.out.printf("[%s]\n", plist.get(turn).getName());
	}

	private void showMap() {
		for (int i = 0; i < SIZE; i++) {
			for (int k = 0; k < SIZE; k++)
				System.out.print(list.get(i).get(k));
			System.out.println();
		}
	}

	private int getValue(Scanner sc) {
		while (true) {
			System.out.println("[1~9]>>");
			try {
				return getIndex(sc);
			} catch (NullPointerException e) {
				System.err.println("이미 놓은 자리");
			} catch (Exception e) {
				System.err.println("1~9 사이 정수 입력");
			} finally {
				sc.nextLine();
			}
		}
	}

	private int getIndex(Scanner sc) throws Exception {
		int sel = sc.nextInt() - 1;
		if (sel < 0 || sel > 8)
			throw new Exception();
		if (!list.get(sel / SIZE).get(sel % SIZE).getMark().equals(" "))
			throw new NullPointerException();
		else
			return sel;
	}

	private void setMark(int value, int turn) {
		list.get(value / SIZE).get(value % SIZE).setMark(plist.get(turn).getMark());
	}

	private int changeTurn(int turn) {
		return turn == 0 ? 1 : 0;
	}

	private boolean isWin(int value, int turn) {
		if (isGaro(value, turn) || isSero(value, turn) || isDaegakUp(value, turn) || isDaegakDown(value, turn)) {
			winner = plist.get(turn);
			return true;
		}
		return false;
	}

	private boolean isGaro(int value, int turn) {
		for (int i = 0; i < SIZE; i++)
			if (!list.get(value / SIZE).get(i).getMark().equals(plist.get(turn).getMark()))
				return false;
		return true;
	}

	private boolean isSero(int value, int turn) {
		for (int i = 0; i < SIZE; i++)
			if (!list.get(i).get(value % SIZE).getMark().equals(plist.get(turn).getMark()))
				return false;
		return true;
	}

	private boolean isDaegakDown(int value, int turn) {
		for (int i = 0; i < SIZE; i++)
			if (!list.get(i).get(i).getMark().equals(plist.get(turn).getMark()))
				return false;
		return true;
	}

	private boolean isDaegakUp(int value, int turn) {
		for (int i = 0; i < SIZE; i++)
			if (!list.get(SIZE - 1 - i).get(i).getMark().equals(plist.get(turn).getMark()))
				return false;
		return true;
	}

	private void gameEnd(int turn) {
		showMap();
		if (winner != null)
			System.out.println(plist.get(turn).getName() + "승리");
		else
			System.out.println("무승부");
	}

	private void playGame() {
		Scanner sc = new Scanner(System.in);
		int turn = 0;
		int cnt = 0;
		while (winner == null && cnt != 9) {
			showTurn(turn);
			showMap();
			int value = getValue(sc);
			setMark(value, turn);
			cnt++;
			if (isWin(value, turn))
				continue;
			if (cnt == 9)
				continue;
			turn = changeTurn(turn);
		}
		gameEnd(turn);
		sc.close();
	}

	void run() {
		init();
		playGame();
	}
}
