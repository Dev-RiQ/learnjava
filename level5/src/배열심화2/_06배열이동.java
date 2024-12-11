package 배열심화2;

import java.util.Arrays;

public class _06배열이동 {

	public static void main(String[] args) {

		/*
		 	아래 class1부터 class5배열은 각 반의 시험점수를 저장한 것
		 	각 반의 총점이 높은 순서대로 세 반을 뽑아 win배열에 저장 후
		 	win배열 출력
		 */
		int[][] classList = {
				{ 10, 54, 65, 22, 15 },
				{ 65, 14, 24, 75, 25 },
				{ 50, 45, 25, 87, 49 },
				{ 11, 66, 5, 21, 95 },
				{ 70, 84, 64, 21, 11 }
		};
		int[][] win = new int[3][];
		int[] sum = new int[classList.length];
		int[] idx = new int[classList.length];
		for (int i = 0; i < classList.length; i++) {
			idx[i] = i;
			for (int k = 0; k < classList[i].length; k++) {
				sum[i] += classList[i][k];
			}
			for (int k = 0; k < i; k++) {
				if (sum[i] > sum[k]) {
					int temp = sum[i];
					sum[i] = sum[k];
					sum[k] = temp;
					temp = idx[i];
					idx[i] = idx[k];
					idx[k] = temp;
				}
			}
		}
		System.out.println("win = ");
		for (int i = 0; i < win.length; i++) {
			win[i] = classList[idx[i]];
			System.out.println("    " + Arrays.toString(win[i]));
		}
	}
}
