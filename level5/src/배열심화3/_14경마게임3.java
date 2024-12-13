package 배열심화3;

import java.util.Random;

public class _14경마게임3 {
	
	int size, track, rankCnt, winCnt, winCntTemp, maxSpeed;
	int[] horses, rank;
	int[][] race;
	boolean isWin;
	
	_14경마게임2 gg2 = new _14경마게임2();
	
	public void set() {
		race = new int[size][track];
		horses = new int[size];
		rank = new int[size];
		winCnt = 0;
		rankCnt = 1;
		
	}
	
	public void run() {
		set();
		while(winCnt != size) {
			isWin = false;
			System.out.println("\n\n~~~~~~~~~~~~~~~~경마게임~~~~~~~~~~~~~~~~");
			show();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void show() {
		move();
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < track; k++) {
				System.out.print(race[i][k] == 1 ? (i + 1) + "馬" : "__");
			}
			System.out.println(horses[i] == track - 1 ? "[" + rank[i] + "등]" : "");
		}
		rank();
	}
	
	public void rank() {
		if (isWin) {
			rankCnt += winCnt - winCntTemp;
		}
		winCntTemp = winCnt;
	}
	
	public void move() {
		Random rd = new Random();
		for (int i = 0; i < size; i++) {
			race[i][horses[i]] = 0;
			horses[i] += rd.nextInt(maxSpeed) + 1;
			if (horses[i] >= track - 1) {
				horses[i] = track - 1;
				if (rank[i] == 0) {
					rank[i] = rankCnt;
					winCnt++;
					isWin = true;
				}
			}
			race[i][horses[i]] = 1;
		}
	}
	
}
