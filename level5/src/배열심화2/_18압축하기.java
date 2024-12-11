package 배열심화2;

import java.util.Arrays;

public class _18압축하기 {

	public static void main(String[] args) {

		int[] before = { 3, 3, 5, 5, 5, 5, 5, 3, 4, 4, 4 };
		int[][] after = new int[4][2];
		int idx = 0;
		for (int i = 0; i < after.length; i++) {
			after[i][0] = before[idx];
			for (int k = idx; k < before.length; k++) {
				after[i][1] ++;
				if (k != before.length - 1 && before[k] != before[k + 1]) {
					idx = k + 1;
					break;
				}
			}
			System.out.println(Arrays.toString(after[i]));
		}
	}

}
