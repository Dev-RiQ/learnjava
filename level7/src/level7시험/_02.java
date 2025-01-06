package level7시험;

import java.util.Random;

class Horse {

	String name;
	int pos;
	int rank;
	boolean win;

	String getName() {
		return name;
	}

	int getPos() {
		return pos;
	}

	int getRank() {
		return rank;
	}

	boolean isWin() {
		return win;
	}

	void setName(String name) {
		this.name = name;
	}

	void setPos(int pos) {
		this.pos = pos;
	}

	void setRank(int rank) {
		this.rank = rank;
	}

	void setWin(boolean win) {
		this.win = win;
	}
}

class Racing {

	int size;
	Horse[] horses;
	int line;
	int[][] track;

	void init() {
		size = 4;
		line = 20;
		horses = new Horse[size];
		track = new int[size][line];
		
		String[] name = { "a", "b", "c", "d" };
		for (int i = 0; i < size; i++) {
			horses[i] = new Horse();
			horses[i].setName(name[i]);
			track[i][horses[i].getPos()] = 1;
		}
	}

	void showTrack() {
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < line; k++)
				System.out.printf("[%1s]", track[i][k] == 0 ? "" : horses[i].getName());
			System.out.printf(horses[i].isWin() ? " ==> %d등\n" : "\n", horses[i].getRank());
		}
		System.out.println();
	}

	void moveRandom() {
		Random rd = new Random();
		for (int i = 0; i < size; i++) {
			int posNow = horses[i].getPos();
			if (posNow == line - 1)
				continue;
			int move = rd.nextInt(4) + 1;
			int posAfter = horses[i].getPos() + move;
			if (posAfter >= line - 1) {
				posAfter = line - 1;
				horses[i].setWin(true);
			}
			track[i][posNow] = 0;
			track[i][posAfter] = 1;
			horses[i].setPos(posAfter);
		}
	}

	void setRank(int[] rank) {
		for (int i = 0; i < size; i++)
			if (horses[i].isWin() && horses[i].getRank() == 0) {
				horses[i].setRank(rank[1]);
				rank[0]++;
			}
		rank[1] += rank[0];
		rank[0] = 0;
	}

	void run() {
		init();
		int[] rank = { 0, 1 };
		while (true) {
			showTrack();
			if (rank[1] == size + 1)
				break;
			moveRandom();
			setRank(rank);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class _02 {

	public static void main(String[] args) {

		Racing game = new Racing();
		game.run();
	}
	// 소요 시간 : 24분 27초
}
