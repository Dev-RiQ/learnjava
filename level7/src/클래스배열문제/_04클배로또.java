package 클래스배열문제;

import java.util.Random;

class LottoVO {

	final int SIZE = 8;
	boolean win;
	int[] data = new int[SIZE];

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public int getSIZE() {
		return SIZE;
	}

	public int[] getData() {
		return data;
	}
}

class LottoDAO {

	Random rd;
	LottoVO[] set;
	int winner;
	int cntWinner;
	int cnt;
	final int SIZE = 5;

	void init() {
		rd = new Random();
		set = new LottoVO[SIZE];
	}

	void setLotto() {
		for (int i = 0; i < SIZE; i++) {
			set[i] = new LottoVO();
			int[] data = set[i].getData();
			for (int k = 0; k < data.length; k++) {
				data[k] = setNumbers();
				if (cnt == 3 && !set[i].isWin()) {
					set[i].setWin(true);
					cntWinner++;
					winner = i + 1;
				}
			}
			cnt = 0;
		}
	}

	int setNumbers() {
		int num = rd.nextInt(2);
		if (num == 0) {
			cnt++;
			return 7;
		}
		cnt = 0;
		return num;
	}

	void printLotto() {
		System.out.println("당첨 번호 ==> "+winner);
		for (int i = 0; i < SIZE; i++) {
			for (int k = 0; k < set[i].getSIZE(); k++)
				System.out.print(set[i].getData()[k] + " ");

			String result = set[i].isWin() ? "당첨" : "꽝";
			System.out.println(" ==> " + result);
		}
	}

	boolean isMore() {
		if (cntWinner == 1)
			return true;
		cntWinner = 0;
		return false;
	}

	void run() {
		init();
		while (!isMore()) {
			setLotto();
		}
		printLotto();
	}
}

public class _04클배로또 {

	public static void main(String[] args) {

		LottoDAO dao = new LottoDAO();

		dao.run();
	}

}
