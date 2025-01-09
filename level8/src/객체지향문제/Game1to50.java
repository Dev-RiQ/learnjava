package 객체지향문제;

import java.util.ArrayList;
import java.util.Random;

public class Game1to50 {

	ArrayList<ArrayList<Node2>> list;
	final int SIZE = 25;

	private void init() {
		list = new ArrayList<ArrayList<Node2>>();
		list.add(new ArrayList<Node2>());
		list.add(new ArrayList<Node2>());
		for (int i = 0; i < SIZE * 2; i++)
			if (i < 25)
				list.get(0).add(new Node2(i + 1));
			else
				list.get(1).add(new Node2(i + 1));
		suffleNums(list.get(0));
		suffleNums(list.get(1));
	}

	private void suffleNums(ArrayList<Node2> list) {
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
			int idx = rd.nextInt(SIZE);
			Node2 temp = list.get(0);
			list.set(0, list.get(idx));
			list.set(idx, temp);
		}
	}

	private void showMap() {
		for (int i = 0; i < SIZE; i++) {
			printNums(i);
			if (i % 5 == 4)
				System.out.println();
		}
	}

	private void printNums(int i) {
		if (list.get(0).get(i).getNum() == 0)
			if (list.get(1).get(i).getNum() == 0)
				System.out.print("[  ]");
			else
				System.out.print(list.get(1).get(i));
		else
			System.out.print(list.get(0).get(i));
	}

	private int getMatchCnt(int cnt) {
		ArrayList<Node2> list = cnt < 26 ? this.list.get(0) : this.list.get(1);
		int idx = getIndex(list, cnt);
		list.get(idx).setNum(0);
		System.out.printf("%d 인덱스 (위치) >> [%d] \n", cnt, idx);
		cnt++;
		return cnt;
	}

	private int getIndex(ArrayList<Node2> list, int cnt) {
		for (int i = 0; i < SIZE; i++)
			if (list.get(i).getNum() == cnt)
				return i;
		return 0;
	}

	private void playGame() {
		int cnt = 1;
		while (true) {
			showMap();
			if (cnt > SIZE * 2)
				break;
			cnt = getMatchCnt(cnt);
		}
		System.out.println("게임 종료");
	}

	void run() {
		init();
		playGame();
	}
}
