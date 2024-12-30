package 메서드문제;

import java.util.Scanner;

class NumberGame {

	Scanner sc = new Scanner(System.in);

	int[] game = { 1, 1, 0, 0, 8, 0, 1, 0, 0, 1 };
	int pIdx = 4;
	boolean isEnd = false;

	void showMap() {
		for (int g : game)
			System.out.print(g == 0 ? "__" : g == 1 ? "[]" : "옷");
		System.out.println();
	}

	int selectValue(String text, int start, int end) {
		while (true) {
			System.out.println(text);
			int select = sc.nextInt();
			if (select < start || select > end)
				System.out.println("잘못된 입력");
			else
				return select;
		}
	}

	void selectMove() {
		int select = selectValue("[1]왼쪽  [2]오른쪽  [0]종료", 0, 2);
		if (select == 0)
			isEnd = true;
		else
			selectPlayerMove(select);
	}

	void selectPlayerMove(int select) {
		int tempIdx = select == 1 ? playerMoveLeft(pIdx) : playerMoveRight(pIdx);
		isWall(tempIdx);
	}

	int playerMoveLeft(int pIdx) {
		int tempIdx = pIdx;
		return tempIdx += tempIdx == 0 ? (game.length - 1) : -1;
	}

	int playerMoveRight(int pIdx) {
		int tempIdx = pIdx;
		return tempIdx += tempIdx == game.length - 1 ? -(game.length - 1) : 1;
	}

	void isWall(int tempIdx) {
		if (game[tempIdx] == 1)
			breakWall(tempIdx);
		else
			playerMove(tempIdx);
	}

	void breakWall(int tempIdx) {
		int select = selectValue("벽을 격파 하겠습니까? \n1:네 2:아니오", 1, 2);
		if (select == 1)
			game[tempIdx] = 0;
	}

	void playerMove(int tempIdx) {
		game[pIdx] = 0;
		pIdx = tempIdx;
		game[pIdx] = 8;
	}

	void gameEnd() {
		System.out.println("게임 종료");
	}

	void run() {
		while (!isEnd) {
			showMap();
			selectMove();
		}
		gameEnd();
	}
}

public class _10메서드숫자이동 {

	public static void main(String[] args) {

		NumberGame ng = new NumberGame();

		ng.run();
	}

}
