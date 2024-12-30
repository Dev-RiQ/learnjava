package 메서드문제;

import java.util.Random;
import java.util.Scanner;

class MemoryGame {

	Scanner sc = new Scanner(System.in);

	String[] front;
	String[] back;
	final int SIZE = 10;
	int cnt;

	void init() {
		front = new String[SIZE];
		back = new String[SIZE];
		setNewMap();
		showInfo();
	}

	void setNewMap() {
		String[] front = { "★", "◆", "♠", "♥", "♨", "★", "◆", "♠", "♥", "♨" };
		shuffleArray(front);
		this.front = front;
		for (int i = 0; i < SIZE; i++)
			back[i] = "";
	}

	String[] shuffleArray(String[] arr) {
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
			int idx = rd.nextInt(SIZE);
			String temp = arr[0];
			arr[0] = arr[idx];
			arr[idx] = temp;
		}
		return arr;
	}

	void showInfo() {
		for (int i = 0; i < SIZE; i++)
			System.out.printf(" %d ", i + 1);
		System.out.println();
		for (int i = 0; i < SIZE; i++)
			System.out.printf(" %s ", front[i]);
	}

	void showMap() {
		System.out.println();
		for (int i = 0; i < SIZE; i++)
			System.out.printf("[%1s]", !back[i].equals("") ? front[i] : back[i]);
		System.out.println();
	}

	void getValue() {
		int[] selectIdx = { -1, -1 };
		for (int i = 0; i < 2; i++) {
			System.out.printf("%d번 인덱스 입력 >> ", i + 1);
			int inputIdx = sc.nextInt() - 1;
			if (getValueError(selectIdx, inputIdx))
				i--;
			else {
				selectIdx[i] = inputIdx;
				back[selectIdx[i]] = front[selectIdx[i]];
			}
			showMap();
		}
		matchValue(selectIdx);
	}

	boolean getValueError(int[] selectIdx, int inputIdx) {
		if (inputIdx < 0 || inputIdx >= SIZE)
			System.out.println("1~10 사이의 값을 입력하세요.");
		else if (inputIdx == selectIdx[0])
			System.out.println("같은 카드 선택 불가");
		else if (!back[inputIdx].equals(""))
			System.out.println("이미 오픈된 카드");
		else
			return false;
		return true;
	}

	void matchValue(int[] selectIdx) {
		boolean isMatch = front[selectIdx[0]].equals(front[selectIdx[1]]);
		if (isMatch) {
			System.out.println("일치");
			cnt += 2;
		} else {
			back[selectIdx[0]] = "";
			back[selectIdx[1]] = "";
			System.out.println("불일치");
		}
	}

	void run() {
		init();
		while (cnt != 10) {
			showMap();
			getValue();
		}
		System.out.println("게임종료");
		sc.close();
	}
}

public class _11메서드기억력게임 {

	public static void main(String[] args) {

		MemoryGame mg = new MemoryGame();

		mg.run();
	}

}
