package 배열심화3;

import java.util.Random;

public class _03복권생성기 {

	public static void main(String[] args) {

		Random rd = new Random();
		int[][] lottoSet = new int[5][7];
		while (true) {
			String[] show = new String[5];
			int cntWin = 0;
			for (int i = 0; i < lottoSet.length; i++) {
				show[i] = "";
				int cnt = 0;
				boolean isWin = false;
				for (int k = 0; k < lottoSet[i].length; k++) {
					lottoSet[i][k] = rd.nextInt(2) + 1;
					lottoSet[i][k] = lottoSet[i][k] == 2 ? 7 : 1;
					show[i] += lottoSet[i][k] + "";
					cnt += lottoSet[i][k] == 1 ? -cnt : 1;
					if (cnt == 3) {
						isWin = true;
						cntWin++;
					}
				}
				if (cntWin > 1) {
					break;
				}
				show[i] += isWin ? " (당첨)" : " (꽝)";
			}
			if (cntWin == 1) {
				for (String print : show) {
					System.out.println(print);
				}
				break;
			}
		}
				
		
		
	}

}
