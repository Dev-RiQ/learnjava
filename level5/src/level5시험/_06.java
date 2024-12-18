package level5시험;

import java.util.Random;

public class _06 {

	public static void main(String[] args) {

		Random rd = new Random();
		
		int cntHorse = 5;
		int mapLen = 20;
		int maxMove = 4;
		int[][] horse = new int[cntHorse][mapLen];
		for (int i = 0; i < horse.length; i++) {
			horse[i][0] = 1;
		}
		int[] loc = new int[cntHorse];
		int[] ranks = new int[cntHorse];
		int rankCnt = 1;

		while (rankCnt != cntHorse + 1) {
			int rank = rankCnt;
			for (int i = 0; i < cntHorse; i++) {
				if (loc[i] == mapLen - 1) {
					continue;
				}
				int rdNum = rd.nextInt(maxMove) + 1;
				horse[i][loc[i]] = 0;
				loc[i] += rdNum;
				if (loc[i] >= mapLen - 1) {
					loc[i] = mapLen - 1;
					if (ranks[i] == 0) {
						ranks[i] = rank;
						rankCnt++;
					}
				}
				horse[i][loc[i]] = 1;
			}
		}
		for (int i = 0; i < cntHorse; i++) {
			System.out.printf("%d번 말 : %d등\n", i + 1, ranks[i]);
		}
		// 소요 시간 : 9분 44초

	}

}
