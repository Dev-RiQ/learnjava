package level5시험;

import java.util.Random;

public class _04 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		int[][] lottoSet = new int[5][7];
		
		int winIdx = -1;
		int winCnt = 0;
		for (int i = 0; i < lottoSet.length; i++) {
			int cnt = 0;
			for (int k = 0; k < lottoSet[i].length; k++) {
				int rdNum = rd.nextInt(2);
				lottoSet[i][k] = rdNum == 0? 7 : 1;
				cnt += rdNum == 0 ? 1 : -cnt;
				if (cnt == 3) {
					winCnt++;
					winIdx = i;
				}
			}
			if (winCnt > 1 || (winCnt == 0 && i == lottoSet.length - 1)) {
				winCnt = 0;
				i = -1;
			}
		}
		int idx = 0;
		for (int[] col : lottoSet) {
			for (int row : col) {
				System.out.print(row);
			}
			System.out.println(idx++ == winIdx ? "(당첨)" : "(꽝)");
		}
		
		
//		int winIdx = -1;
//		boolean isWin = false;
//		boolean isWinAgain = false;
//		for (int i = 0; i < lottoSet.length; i++) {
//			int cnt = 0;
//			for (int k = 0; k < lottoSet[i].length; k++) {
//				int rdNum = rd.nextInt(2);
//				if (rdNum == 0) {
//					rdNum = 7;
//				}
//				lottoSet[i][k] = rdNum;
//				cnt += rdNum == 7 ? 1 : -cnt;
//				if (cnt == 3 && isWin) {
//					isWinAgain = true;
//					break;
//				}
//				if (cnt == 3 && !isWin) {
//					isWin = true;
//					winIdx = i;
//				}
//			}
//			if (isWinAgain || !isWin) {
//				isWin = false;
//				isWinAgain = false;
//				i = -1;
//			}
//		}
//		int idx = 0;
//		for (int[] col : lottoSet) {
//			for (int row : col) {
//				System.out.print(row);
//			}
//			System.out.println(idx++ == winIdx ? "(당첨)" : "(꽝)");
//		}
		// 소요 시간 : 13분 19초
	}

}
