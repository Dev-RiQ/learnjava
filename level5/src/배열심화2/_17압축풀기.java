package 배열심화2;

import java.util.Arrays;

public class _17압축풀기 {

	public static void main(String[] args) {

		/*
		 * {데이터, 개수}
		 */
		int[][] arr = {
				{3, 2},
				{5, 6},
				{2, 1},
				{4,3}
		};
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cnt += arr[i][1];
		}
		int[] temp = new int[cnt];
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i][1]; k++) {
				temp[idx++] = arr[i][0];
			}
		}
		System.out.println(Arrays.toString(temp));
	}

}
