package 클래스배열문제;

import java.util.Random;

class LottoVO{
	
	final int SIZE = 8;
	boolean win;
	final int[] DATA = new int[SIZE];
	
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	public int getSIZE() {
		return SIZE;
	}
	public int[] getDATA() {
		return DATA;
	}
}

class LottoDAO{
	
	Random rd;
	LottoVO[] set;
	int winner;
	
	void init() {
		rd = new Random();
		LottoVO vo = new LottoVO();
		set = new LottoVO[vo.getSIZE()];
		for(int i = 0 ; i < set.length ; i++)
			set[i] = new LottoVO();
	}
	
	void setLotto() {
		
	}
	
	void run() {
		
	}
}

public class _04클배로또 {

	public static void main(String[] args) {

		LottoDAO dao = new LottoDAO();
		
		dao.run();
	}

}
