package 배열심화2;

import java.util.Arrays;
import java.util.Random;

public class _09이차원랜덤저장 {

	public static void main(String[] args) {

		/*
		 * darr배열에 1~50 숫자중 25개만 중복되지않게 저장
		 * 1. 1차월 배열 생성 후 중복 없이 랜덤 넣기
		 * 2. 2차원 배열에 다시 넣기
		 */
		Random rd = new Random();
		int size = 5;
		int[][] darr = new int[5][5];
		boolean[] isUse = new boolean[50];
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				darr[i][k] = rd.nextInt(50) + 1;
				if (isUse[darr[i][k] - 1]) {
					k--;
				} else {
					isUse[darr[i][k] - 1] = true;
				}
			}
			System.out.println(Arrays.toString(darr[i]));
		}
	}

}
