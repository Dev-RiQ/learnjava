package 배열심화3;

import java.util.Random;

public class _14경마게임 {

	public static void main(String[] args) {
		Random rd = new Random();
		int size = 5; // 말 갯수
		int track = 20; // 트랙 갯수
		int[][] race = new int[size][track]; // 경기장
		int[] horses = new int[size]; // 기록
		int[] rank = new int[size]; // 순위
		int rankCnt = 1;
		int winCnt = 0;
		while (winCnt != 5) {
			boolean isWin = false;
			int winCntTemp = winCnt;
			System.out.println("\n\n~~~~~~~~~~~~~~~~경마게임~~~~~~~~~~~~~~~~");
			for (int i = 0; i < size; i++) {
				race[i][horses[i]] = 0;
				horses[i] += rd.nextInt(4) + 1;
				if (horses[i] >= 19) {
					horses[i] = 19;
					if (rank[i] == 0) {
						rank[i] = rankCnt;
						winCnt++;
						isWin = true;
					}
				}
				race[i][horses[i]] = 1;
				for (int k = 0; k < track; k++) {
					System.out.print(race[i][k] == 1 ? (i + 1) + "馬" : "__");
				}
				System.out.println(horses[i] == 19 ? "[ " + rank[i] + "등 ]" : "");
			}
			if (isWin) {
				rankCnt += winCnt - winCntTemp;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
